package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.File;

public final class b
{
  private static final Boolean[] NHz = { null };
  
  private static String Wr(String paramString)
  {
    AppMethodBeat.i(176869);
    File localFile = new File(paramString);
    try
    {
      String str = localFile.getCanonicalPath();
      AppMethodBeat.o(176869);
      return str;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean bhQ(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + Wr(paramString);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void bhR(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + Wr(paramString);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  public static boolean gwY()
  {
    AppMethodBeat.i(176864);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored_v2", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  public static boolean gwZ()
  {
    AppMethodBeat.i(197161);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(197161);
    return bool;
  }
  
  static void gxa()
  {
    AppMethodBeat.i(197162);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(197162);
  }
  
  static void gxb()
  {
    AppMethodBeat.i(197163);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(197163);
  }
  
  static void gxc()
  {
    AppMethodBeat.i(197164);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(197164);
  }
  
  static void gxd()
  {
    AppMethodBeat.i(197165);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(197165);
  }
  
  public static boolean gxe()
  {
    AppMethodBeat.i(197166);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(197166);
    return bool;
  }
  
  static void gxf()
  {
    AppMethodBeat.i(197167);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(197167);
  }
  
  static void gxg()
  {
    AppMethodBeat.i(197168);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(197168);
  }
  
  public static void gxh()
  {
    AppMethodBeat.i(176868);
    AppMethodBeat.o(176868);
  }
  
  static void ju(Context paramContext)
  {
    AppMethodBeat.i(176865);
    if (jv(paramContext))
    {
      ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateStatus", "[+] Mark newly installed in process: %s", new Object[] { d.cQi });
      MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_is_olddata_ignored_v2", true);
    }
    AppMethodBeat.o(176865);
  }
  
  private static boolean jv(Context paramContext)
  {
    AppMethodBeat.i(176866);
    if (new File(com.tencent.mm.loader.j.b.aKB(), "version_history.cfg").exists())
    {
      AppMethodBeat.o(176866);
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext.firstInstallTime == paramContext.lastUpdateTime)
      {
        AppMethodBeat.o(176866);
        return true;
      }
      AppMethodBeat.o(176866);
      return false;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(176866);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.b
 * JD-Core Version:    0.7.0.1
 */