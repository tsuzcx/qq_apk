package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.hook.HookManager.b;
import com.tencent.matrix.hook.memory.GCSemiSpaceTrimmer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.aa;
import com.tencent.mm.app.e;
import com.tencent.mm.compatible.util.k;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class GCSemiSpaceTrimWrapper
{
  private static final String DATA_DIR_NAME = "gc_ss_trim";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final String ENABLED_MARK_ONCE_FILE_NAME = "enabled_marked_once";
  private static final PeriodRecorder REPORT_FREQ_LIMIT;
  private static final String TAG = "MicroMsg.GCSemiSpaceTrimWrapper";
  
  static
  {
    AppMethodBeat.i(243458);
    REPORT_FREQ_LIMIT = new PeriodRecorder("gc_sst_w", TimeUnit.HOURS.toMillis(24L), true, true);
    AppMethodBeat.o(243458);
  }
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(243444);
    paramContext = paramContext.getDir("gc_ss_trim", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(243444);
    return paramContext;
  }
  
  private static String getMarkerFileName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243452);
    String str2 = e.eMg;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Util.getProcessNameByPid(paramContext, Process.myPid());
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(243452);
      return null;
    }
    paramContext = str1.replace('.', '_').replace(":", "__") + "_" + paramString;
    AppMethodBeat.o(243452);
    return paramContext;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(243437);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(243437);
      return false;
    }
    String str = getMarkerFileName(paramContext, "enabled");
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(243437);
      return bool;
    }
    aa.c("MicroMsg.GCSemiSpaceTrimWrapper", "[-] Fail to get marker file name, treat as disabled.", new Object[0]);
    AppMethodBeat.o(243437);
    return false;
  }
  
  private static boolean isPreconditionsSatisfied(Context paramContext)
  {
    return (!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT < 26);
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(243432);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243432);
        return;
      }
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.GCSemiSpaceTrimWrapper", "[-] Fail to get marker file name, skip marking disabled.", new Object[0]);
        AppMethodBeat.o(243432);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        aa.a("MicroMsg.GCSemiSpaceTrimWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(243432);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.GCSemiSpaceTrimWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(243432);
      return;
    }
    aa.c("MicroMsg.GCSemiSpaceTrimWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(243432);
  }
  
  public static void markEnabled(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(243428);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243428);
        return;
      }
      aa.a("MicroMsg.GCSemiSpaceTrimWrapper", "[+] markEnabled called.", new Object[0]);
      if (paramBoolean)
      {
        localObject = getMarkerFileName(paramContext, "enabled_marked_once");
        localObject = new File(getDataStoreDir(paramContext), (String)localObject);
        if (((File)localObject).exists())
        {
          aa.b("MicroMsg.GCSemiSpaceTrimWrapper", "[!] Marked before, skip marking this time.", new Object[0]);
          AppMethodBeat.o(243428);
          return;
        }
        ((File)localObject).createNewFile();
      }
      Object localObject = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        aa.c("MicroMsg.GCSemiSpaceTrimWrapper", "[-] Fail to get marker file name, skip marking enabled.", new Object[0]);
        AppMethodBeat.o(243428);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), (String)localObject);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        aa.a("MicroMsg.GCSemiSpaceTrimWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(243428);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.GCSemiSpaceTrimWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(243428);
      return;
    }
    aa.c("MicroMsg.GCSemiSpaceTrimWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(243428);
  }
  
  public static void tryToInstall(Context paramContext)
  {
    AppMethodBeat.i(243420);
    if (!isPreconditionsSatisfied(paramContext))
    {
      aa.a("MicroMsg.GCSemiSpaceTrimWrapper", "[+] Env condition is not satisfied, skip installation.", new Object[0]);
      AppMethodBeat.o(243420);
      return;
    }
    if (!isEnabled(paramContext))
    {
      aa.a("MicroMsg.GCSemiSpaceTrimWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(243420);
      return;
    }
    try
    {
      GCSemiSpaceTrimmer.eUR.eUQ = new HookManager.b()
      {
        public void loadLibrary(String paramAnonymousString)
        {
          AppMethodBeat.i(243815);
          k.load(paramAnonymousString);
          AppMethodBeat.o(243815);
        }
      };
      bool = GCSemiSpaceTrimmer.eUR.dJ(TimeUnit.MINUTES.toMillis(5L));
      if ((bool) && (GCSemiSpaceTrimmer.eUR.axM()))
      {
        if (!REPORT_FREQ_LIMIT.isExpired("do_rpt")) {
          break label181;
        }
        StartupILogsReport.reportNumericValue(paramContext, -536739836, Integer.valueOf(1));
        StartupILogsReport.reportNumericValue(paramContext, -536739836, Integer.valueOf(2));
        AppMethodBeat.o(243420);
      }
    }
    finally
    {
      for (;;)
      {
        aa.a("MicroMsg.GCSemiSpaceTrimWrapper", localThrowable, "[-] install failed.", new Object[0]);
        boolean bool = false;
      }
      if (REPORT_FREQ_LIMIT.isExpired("do_rpt"))
      {
        StartupILogsReport.reportNumericValue(paramContext, -536739836, Integer.valueOf(1));
        StartupILogsReport.reportNumericValue(paramContext, -536739836, Integer.valueOf(3));
      }
      label181:
      AppMethodBeat.o(243420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.GCSemiSpaceTrimWrapper
 * JD-Core Version:    0.7.0.1
 */