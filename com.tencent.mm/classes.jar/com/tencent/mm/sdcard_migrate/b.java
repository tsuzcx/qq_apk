package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.sdk.platformtools.ax;
import java.io.File;

public final class b
{
  private static final Boolean[] HZV = { null };
  
  private static String MB(String paramString)
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
      ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean aPQ(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + MB(paramString);
    boolean bool = ax.aQz("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void aPR(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + MB(paramString);
    ax.aQz("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  static void fjA()
  {
    AppMethodBeat.i(189891);
    ax.aQz("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(189891);
  }
  
  static void fjB()
  {
    AppMethodBeat.i(189892);
    ax.aQz("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(189892);
  }
  
  public static boolean fjC()
  {
    AppMethodBeat.i(176867);
    AppMethodBeat.o(176867);
    return true;
  }
  
  public static void fjD()
  {
    AppMethodBeat.i(176868);
    AppMethodBeat.o(176868);
  }
  
  public static boolean fjt()
  {
    AppMethodBeat.i(176864);
    boolean bool = ax.aQz("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored_v2", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  public static boolean fju()
  {
    AppMethodBeat.i(189885);
    boolean bool = ax.aQz("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(189885);
    return bool;
  }
  
  static void fjv()
  {
    AppMethodBeat.i(189886);
    ax.aQz("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(189886);
  }
  
  static void fjw()
  {
    AppMethodBeat.i(189887);
    ax.aQz("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(189887);
  }
  
  static void fjx()
  {
    AppMethodBeat.i(189888);
    ax.aQz("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(189888);
  }
  
  static void fjy()
  {
    AppMethodBeat.i(189889);
    ax.aQz("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(189889);
  }
  
  public static boolean fjz()
  {
    AppMethodBeat.i(189890);
    boolean bool = ax.aQz("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(189890);
    return bool;
  }
  
  static void iv(Context paramContext)
  {
    AppMethodBeat.i(176865);
    if (iw(paramContext))
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateStatus", "[+] Mark newly installed in process: %s", new Object[] { d.cDP });
      ax.aQz("extmig_status_memo_storage").encode("key_is_olddata_ignored_v2", true);
    }
    AppMethodBeat.o(176865);
  }
  
  private static boolean iw(Context paramContext)
  {
    AppMethodBeat.i(176866);
    if (new File(com.tencent.mm.loader.j.b.arM(), "version_history.cfg").exists())
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