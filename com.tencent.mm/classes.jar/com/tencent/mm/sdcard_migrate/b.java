package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.p;
import java.io.File;

public final class b
{
  private static final Boolean[] Goi = { null };
  
  private static String Jk(String paramString)
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
      ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean aKl(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + Jk(paramString);
    boolean bool = aw.aKT("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void aKm(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + Jk(paramString);
    aw.aKT("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  public static boolean eTQ()
  {
    AppMethodBeat.i(176864);
    boolean bool = aw.aKT("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  public static boolean eTR()
  {
    AppMethodBeat.i(206920);
    boolean bool = aw.aKT("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(206920);
    return bool;
  }
  
  static void eTS()
  {
    AppMethodBeat.i(206921);
    aw.aKT("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(206921);
  }
  
  static void eTT()
  {
    AppMethodBeat.i(206922);
    aw.aKT("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(206922);
  }
  
  static void eTU()
  {
    AppMethodBeat.i(206923);
    aw.aKT("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(206923);
  }
  
  static void eTV()
  {
    AppMethodBeat.i(206924);
    aw.aKT("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(206924);
  }
  
  public static boolean eTW()
  {
    AppMethodBeat.i(206925);
    boolean bool = aw.aKT("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(206925);
    return bool;
  }
  
  static void eTX()
  {
    AppMethodBeat.i(206926);
    aw.aKT("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(206926);
  }
  
  static void eTY()
  {
    AppMethodBeat.i(206927);
    aw.aKT("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(206927);
  }
  
  public static boolean eTZ()
  {
    AppMethodBeat.i(176867);
    synchronized (Goi)
    {
      if (Goi[0] == null)
      {
        boolean[] arrayOfBoolean1 = p.me("extmig_switch_storage", "is_routine_enabled");
        Goi[0] = Boolean.valueOf(arrayOfBoolean1[0]);
        if (arrayOfBoolean1[1] != 0) {
          ExtStorageMigrateMonitor.as(1317L, 21L);
        }
      }
      boolean bool = Goi[0].booleanValue();
      AppMethodBeat.o(176867);
      return bool;
    }
  }
  
  public static void eUa()
  {
    AppMethodBeat.i(176868);
    if (bs.getInt(com.tencent.mm.plugin.expt.e.b.cmk().fS("clicfg_extmig_switch_open", "0"), 0) > 0) {
      synchronized (Goi)
      {
        if ((Goi[0] != null) && (Goi[0].booleanValue()))
        {
          ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateStatus", "[!] Already enabled.", new Object[0]);
          AppMethodBeat.o(176868);
          return;
        }
        if (!p.mf("extmig_switch_storage", "is_routine_enabled"))
        {
          ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateStatus", "[-] Fail to store to mmkv, keep original status for safety.", new Object[0]);
          AppMethodBeat.o(176868);
          return;
        }
        Goi[0] = Boolean.TRUE;
        AppMethodBeat.o(176868);
        return;
      }
    }
    AppMethodBeat.o(176868);
  }
  
  public static void il(Context paramContext)
  {
    AppMethodBeat.i(176865);
    if (im(paramContext)) {
      aw.aKT("extmig_status_memo_storage").encode("key_is_olddata_ignored", true);
    }
    AppMethodBeat.o(176865);
  }
  
  private static boolean im(Context paramContext)
  {
    AppMethodBeat.i(176866);
    if (new File(com.tencent.mm.loader.j.b.aoZ(), "version_history.cfg").exists())
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