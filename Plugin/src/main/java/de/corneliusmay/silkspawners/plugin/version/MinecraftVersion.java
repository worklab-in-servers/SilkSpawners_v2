package de.corneliusmay.silkspawners.plugin.version;

import org.bukkit.Bukkit;

public class MinecraftVersion {
    private static String version;
    private static int majorVersion, minorVersion, patchVersion;

    static {
        try {
            // Split on the "-" to just get the version information
            version = Bukkit.getServer().getBukkitVersion().split("-")[0];
            final String[] splitVersion = version.split("\\.");

            majorVersion = Integer.parseInt(splitVersion[0]);
            minorVersion = Integer.parseInt(splitVersion[1]);
            patchVersion = Integer.parseInt(splitVersion[2]);
        } catch (Exception e) {
            System.err.println("Failed to load Reflector");
            e.printStackTrace();
        }
    }

    public static String getVersion() {
        return version;
    }

    /**
     * Checks if the current server version is newer or equal to the one provided.
     *
     * @param major the target major version
     * @param minor the target minor version. 0 for all
     * @param patch the target patch version. 0 for all
     * @return true if the server version is newer or equal to the one provided
     */
    public static boolean versionIsNewerOrEqualTo(int major, int minor, int patch) {
        if (getMajorVersion() < major) return false;
        if (getMinorVersion() < minor) return false;
        return getPatchVersion() >= patch;
    }

    private static int getMajorVersion() {
        return majorVersion;
    }

    private static int getMinorVersion() {
        return minorVersion;
    }

    private static int getPatchVersion() {
        return patchVersion;
    }
}
