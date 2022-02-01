package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.p;
import java.io.File;

public final class b
{
  private static final Boolean[] EQV = { null };
  
  private static String Fh(String paramString)
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
      ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean aEU(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + Fh(paramString);
    boolean bool = ax.aFC("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void aEV(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + Fh(paramString);
    ax.aFC("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  static void eEA()
  {
    AppMethodBeat.i(192908);
    ax.aFC("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(192908);
  }
  
  static void eEB()
  {
    AppMethodBeat.i(192909);
    ax.aFC("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(192909);
  }
  
  public static boolean eEC()
  {
    AppMethodBeat.i(192910);
    boolean bool = ax.aFC("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(192910);
    return bool;
  }
  
  static void eED()
  {
    AppMethodBeat.i(192911);
    ax.aFC("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(192911);
  }
  
  static void eEE()
  {
    AppMethodBeat.i(192912);
    ax.aFC("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(192912);
  }
  
  public static boolean eEF()
  {
    AppMethodBeat.i(176867);
    synchronized (EQV)
    {
      if (EQV[0] == null)
      {
        boolean[] arrayOfBoolean1 = p.lH("extmig_switch_storage", "is_routine_enabled");
        EQV[0] = Boolean.valueOf(arrayOfBoolean1[0]);
        if (arrayOfBoolean1[1] != 0) {
          ExtStorageMigrateMonitor.at(1317L, 21L);
        }
      }
      boolean bool = EQV[0].booleanValue();
      AppMethodBeat.o(176867);
      return bool;
    }
  }
  
  public static void eEG()
  {
    AppMethodBeat.i(176868);
    if (bt.getInt(com.tencent.mm.plugin.expt.e.b.ceD().fF("clicfg_extmig_switch_open", "0"), 0) > 0) {
      synchronized (EQV)
      {
        if ((EQV[0] != null) && (EQV[0].booleanValue()))
        {
          ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateStatus", "[!] Already enabled.", new Object[0]);
          AppMethodBeat.o(176868);
          return;
        }
        if (!p.lI("extmig_switch_storage", "is_routine_enabled"))
        {
          ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateStatus", "[-] Fail to store to mmkv, keep original status for safety.", new Object[0]);
          AppMethodBeat.o(176868);
          return;
        }
        EQV[0] = Boolean.TRUE;
        AppMethodBeat.o(176868);
        return;
      }
    }
    AppMethodBeat.o(176868);
  }
  
  public static boolean eEw()
  {
    AppMethodBeat.i(176864);
    boolean bool = ax.aFC("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  public static boolean eEx()
  {
    AppMethodBeat.i(192905);
    boolean bool = ax.aFC("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(192905);
    return bool;
  }
  
  static void eEy()
  {
    AppMethodBeat.i(192906);
    ax.aFC("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(192906);
  }
  
  static void eEz()
  {
    AppMethodBeat.i(192907);
    ax.aFC("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(192907);
  }
  
  public static void ia(Context paramContext)
  {
    AppMethodBeat.i(176865);
    if (ib(paramContext)) {
      ax.aFC("extmig_status_memo_storage").encode("key_is_olddata_ignored", true);
    }
    AppMethodBeat.o(176865);
  }
  
  private static boolean ib(Context paramContext)
  {
    AppMethodBeat.i(176866);
    if (new File(com.tencent.mm.loader.j.b.ahZ(), "version_history.cfg").exists())
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