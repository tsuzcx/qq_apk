package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.sdk.platformtools.ay;
import java.io.File;

public final class b
{
  private static final Boolean[] Iuc = { null };
  
  private static String Ni(String paramString)
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
      ExtStorageMigrateMonitor.fmX().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean aRn(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + Ni(paramString);
    boolean bool = ay.aRW("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void aRo(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + Ni(paramString);
    ay.aRW("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  public static boolean fnl()
  {
    AppMethodBeat.i(176864);
    boolean bool = ay.aRW("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored_v2", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  public static boolean fnm()
  {
    AppMethodBeat.i(193603);
    boolean bool = ay.aRW("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(193603);
    return bool;
  }
  
  static void fnn()
  {
    AppMethodBeat.i(193604);
    ay.aRW("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(193604);
  }
  
  static void fno()
  {
    AppMethodBeat.i(193605);
    ay.aRW("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(193605);
  }
  
  static void fnp()
  {
    AppMethodBeat.i(193606);
    ay.aRW("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(193606);
  }
  
  static void fnq()
  {
    AppMethodBeat.i(193607);
    ay.aRW("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(193607);
  }
  
  public static boolean fnr()
  {
    AppMethodBeat.i(193608);
    boolean bool = ay.aRW("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(193608);
    return bool;
  }
  
  static void fns()
  {
    AppMethodBeat.i(193609);
    ay.aRW("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(193609);
  }
  
  static void fnt()
  {
    AppMethodBeat.i(193610);
    ay.aRW("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(193610);
  }
  
  public static boolean fnu()
  {
    AppMethodBeat.i(176867);
    AppMethodBeat.o(176867);
    return true;
  }
  
  public static void fnv()
  {
    AppMethodBeat.i(176868);
    AppMethodBeat.o(176868);
  }
  
  static void iA(Context paramContext)
  {
    AppMethodBeat.i(176865);
    if (iB(paramContext))
    {
      ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateStatus", "[+] Mark newly installed in process: %s", new Object[] { d.cEw });
      ay.aRW("extmig_status_memo_storage").encode("key_is_olddata_ignored_v2", true);
    }
    AppMethodBeat.o(176865);
  }
  
  private static boolean iB(Context paramContext)
  {
    AppMethodBeat.i(176866);
    if (new File(com.tencent.mm.loader.j.b.asb(), "version_history.cfg").exists())
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