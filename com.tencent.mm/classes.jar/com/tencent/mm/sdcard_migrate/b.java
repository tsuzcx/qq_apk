package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.e;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.File;

public final class b
{
  private static final Boolean[] acql = { null };
  
  private static String buf(String paramString)
  {
    AppMethodBeat.i(176869);
    File localFile = new File(paramString);
    try
    {
      String str = localFile.getCanonicalPath();
      AppMethodBeat.o(176869);
      return str;
    }
    finally
    {
      ExtStorageMigrateMonitor.iSO().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = localFile.getAbsolutePath();
      AppMethodBeat.o(176869);
    }
    return paramString;
  }
  
  public static boolean bui(String paramString)
  {
    AppMethodBeat.i(176862);
    paramString = "key_is_migrated_" + buf(paramString);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean(paramString, false);
    AppMethodBeat.o(176862);
    return bool;
  }
  
  static void buj(String paramString)
  {
    AppMethodBeat.i(176863);
    paramString = "key_is_migrated_" + buf(paramString);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode(paramString, true);
    AppMethodBeat.o(176863);
  }
  
  public static boolean iTc()
  {
    AppMethodBeat.i(176864);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored_v2", false);
    AppMethodBeat.o(176864);
    return bool;
  }
  
  static void iTd()
  {
    AppMethodBeat.i(257055);
    if (!new File(com.tencent.mm.loader.i.b.bmr(), "version_history.cfg").exists()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateStatus", "[+] Mark newly installed in process: %s", new Object[] { e.eMg });
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_is_olddata_ignored_v2", true);
      }
      AppMethodBeat.o(257055);
      return;
    }
  }
  
  public static boolean iTe()
  {
    AppMethodBeat.i(257058);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(257058);
    return bool;
  }
  
  static void iTf()
  {
    AppMethodBeat.i(257064);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
    AppMethodBeat.o(257064);
  }
  
  static void iTg()
  {
    AppMethodBeat.i(257071);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
    AppMethodBeat.o(257071);
  }
  
  static void iTh()
  {
    AppMethodBeat.i(257078);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
    AppMethodBeat.o(257078);
  }
  
  static void iTi()
  {
    AppMethodBeat.i(257082);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
    AppMethodBeat.o(257082);
  }
  
  public static boolean iTj()
  {
    AppMethodBeat.i(257086);
    boolean bool = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(257086);
    return bool;
  }
  
  static void iTk()
  {
    AppMethodBeat.i(257091);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
    AppMethodBeat.o(257091);
  }
  
  static void iTl()
  {
    AppMethodBeat.i(257095);
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
    AppMethodBeat.o(257095);
  }
  
  public static void iTm()
  {
    AppMethodBeat.i(176868);
    AppMethodBeat.o(176868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.b
 * JD-Core Version:    0.7.0.1
 */