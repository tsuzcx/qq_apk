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
  private static final Boolean[] UVa = { null };
  
  private static String bug(String paramString)
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
      ExtStorageMigrateMonitor.hsJ().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean buj(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + bug(paramString);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void buk(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + bug(paramString);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  public static boolean hsX()
  {
    AppMethodBeat.i(176864);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored_v2", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  public static boolean hsY()
  {
    AppMethodBeat.i(199985);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(199985);
    return bool;
  }
  
  static void hsZ()
  {
    AppMethodBeat.i(199986);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(199986);
  }
  
  static void hta()
  {
    AppMethodBeat.i(199987);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(199987);
  }
  
  static void htb()
  {
    AppMethodBeat.i(199989);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(199989);
  }
  
  static void htc()
  {
    AppMethodBeat.i(199991);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(199991);
  }
  
  public static boolean htd()
  {
    AppMethodBeat.i(199995);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(199995);
    return bool;
  }
  
  static void hte()
  {
    AppMethodBeat.i(199996);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(199996);
  }
  
  static void htf()
  {
    AppMethodBeat.i(199998);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(199998);
  }
  
  public static void htg()
  {
    AppMethodBeat.i(176868);
    AppMethodBeat.o(176868);
  }
  
  static void ky(Context paramContext)
  {
    AppMethodBeat.i(176865);
    if (kz(paramContext))
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateStatus", "[+] Mark newly installed in process: %s", new Object[] { d.cQP });
      MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_is_olddata_ignored_v2", true);
    }
    AppMethodBeat.o(176865);
  }
  
  private static boolean kz(Context paramContext)
  {
    AppMethodBeat.i(176866);
    if (new File(com.tencent.mm.loader.j.b.aSD(), "version_history.cfg").exists())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.b
 * JD-Core Version:    0.7.0.1
 */