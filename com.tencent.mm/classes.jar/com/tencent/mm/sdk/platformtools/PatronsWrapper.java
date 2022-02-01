package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.android.patronus.Patrons;
import com.alibaba.android.patronus.Patrons.PatronsConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.aa;
import com.tencent.mm.app.e;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.TimeUnit;

public class PatronsWrapper
{
  private static final String DATA_DIR_NAME = "patrons";
  private static final String ENABLED_3G_STRATEY_MARK_FILE_NAME = "3g_strategy_enabled";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final String ENABLED_MARK_ONCE_FILE_NAME = "enabled_marked_once";
  private static final String FUSE_BROKEN_FILE_NAME_PREFIX = "fuse_broken_";
  private static final PeriodRecorder REPORT_FREQ_LIMIT;
  private static final String TAG = "MicroMsg.PatronsWrapper";
  private static boolean sFuseInstalled;
  
  static
  {
    AppMethodBeat.i(244074);
    REPORT_FREQ_LIMIT = new PeriodRecorder("patrons_w", TimeUnit.HOURS.toMillis(24L), true, true);
    sFuseInstalled = false;
    AppMethodBeat.o(244074);
  }
  
  private static void clearFuseBrokenMarkAsync(Context paramContext)
  {
    AppMethodBeat.i(244038);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(244038);
      return;
    }
    h.ahAA.bm(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(243813);
        Object localObject1 = PatronsWrapper.access$000(PatronsWrapper.this);
        if ((localObject1 == null) || (!((File)localObject1).exists()))
        {
          AppMethodBeat.o(243813);
          return;
        }
        localObject1 = ((File)localObject1).listFiles(new FilenameFilter()
        {
          final String actualPrefix;
          
          public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
          {
            AppMethodBeat.i(243511);
            boolean bool = paramAnonymous2String.startsWith(this.actualPrefix);
            AppMethodBeat.o(243511);
            return bool;
          }
        });
        if (localObject1 == null)
        {
          AppMethodBeat.o(243813);
          return;
        }
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!localObject2.getName().endsWith("_" + BuildInfo.CLIENT_VERSION_INT))
          {
            aa.a("MicroMsg.PatronsWrapper", "Fuse broken marker %s was removed.", new Object[] { localObject2.getName() });
            localObject2.delete();
          }
          i += 1;
        }
        AppMethodBeat.o(243813);
      }
    });
    AppMethodBeat.o(244038);
  }
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(244051);
    paramContext = paramContext.getDir("patrons", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(244051);
    return paramContext;
  }
  
  private static String getMarkerFileName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(244054);
    String str2 = e.eMg;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Util.getProcessNameByPid(paramContext, Process.myPid());
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(244054);
      return null;
    }
    paramContext = str1.replace('.', '_').replace(":", "__") + "_" + paramString;
    AppMethodBeat.o(244054);
    return paramContext;
  }
  
  public static void installExceptionFuse()
  {
    AppMethodBeat.i(244048);
    if (sFuseInstalled)
    {
      AppMethodBeat.o(244048);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    if (!isFuseBroken(localContext)) {
      clearFuseBrokenMarkAsync(localContext);
    }
    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(243792);
        if (!(paramAnonymousThrowable instanceof OutOfMemoryError))
        {
          AppMethodBeat.o(243792);
          return;
        }
        if ((paramAnonymousString != null) && (!paramAnonymousString.contains("failed due to fragmentation")))
        {
          AppMethodBeat.o(243792);
          return;
        }
        PatronsWrapper.access$200(PatronsWrapper.this);
        AppMethodBeat.o(243792);
      }
    });
    sFuseInstalled = true;
    AppMethodBeat.o(244048);
  }
  
  public static boolean isAggressiveStrategyEnabled(Context paramContext)
  {
    AppMethodBeat.i(244024);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(244024);
      return false;
    }
    String str = getMarkerFileName(paramContext, "3g_strategy_enabled");
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(244024);
      return bool;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, treat as aggressive strategy disabled.", new Object[0]);
    AppMethodBeat.o(244024);
    return false;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(244003);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(244003);
      return false;
    }
    String str = getMarkerFileName(paramContext, "enabled");
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(244003);
      return bool;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, treat as disabled.", new Object[0]);
    AppMethodBeat.o(244003);
    return false;
  }
  
  private static boolean isFuseBroken(Context paramContext)
  {
    AppMethodBeat.i(244045);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(244045);
      return false;
    }
    String str = getMarkerFileName(paramContext, "fuse_broken_" + BuildInfo.CLIENT_VERSION_INT);
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(244045);
      return bool;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, treat as fuse not broken.", new Object[0]);
    AppMethodBeat.o(244045);
    return false;
  }
  
  private static boolean isPreconditionsSatisfied(Context paramContext)
  {
    return (!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 26);
  }
  
  public static void markAggressiveStrategyDisabled(Context paramContext)
  {
    AppMethodBeat.i(244017);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(244017);
        return;
      }
      String str = getMarkerFileName(paramContext, "3g_strategy_enabled");
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking aggressive strategy disabled.", new Object[0]);
        AppMethodBeat.o(244017);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        aa.a("MicroMsg.PatronsWrapper", "[+] Mark aggressive strategy disabled successfully.", new Object[0]);
        AppMethodBeat.o(244017);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark aggressive strategy disabled.", new Object[0]);
      AppMethodBeat.o(244017);
      return;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to mark aggressive strategy disabled.", new Object[0]);
    AppMethodBeat.o(244017);
  }
  
  public static void markAggressiveStrategyEnabled(Context paramContext)
  {
    AppMethodBeat.i(244009);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(244009);
        return;
      }
      aa.a("MicroMsg.PatronsWrapper", "[+] markAggressiveStrategyEnabled called.", new Object[0]);
      String str = getMarkerFileName(paramContext, "3g_strategy_enabled");
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking aggressive strategy enabled.", new Object[0]);
        AppMethodBeat.o(244009);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        aa.a("MicroMsg.PatronsWrapper", "[+] Mark aggressive strategy enabled successfully.", new Object[0]);
        AppMethodBeat.o(244009);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark aggressive strategy enabled.", new Object[0]);
      AppMethodBeat.o(244009);
      return;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to mark aggressive strategy enabled.", new Object[0]);
    AppMethodBeat.o(244009);
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(243997);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243997);
        return;
      }
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking disabled.", new Object[0]);
        AppMethodBeat.o(243997);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        aa.a("MicroMsg.PatronsWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(243997);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(243997);
      return;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(243997);
  }
  
  public static void markEnabled(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(243988);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(243988);
        return;
      }
      aa.a("MicroMsg.PatronsWrapper", "[+] markEnabled called.", new Object[0]);
      if (paramBoolean)
      {
        localObject = getMarkerFileName(paramContext, "enabled_marked_once");
        localObject = new File(getDataStoreDir(paramContext), (String)localObject);
        if (((File)localObject).exists())
        {
          aa.b("MicroMsg.PatronsWrapper", "[!] Marked before, skip marking this time.", new Object[0]);
          AppMethodBeat.o(243988);
          return;
        }
        ((File)localObject).createNewFile();
      }
      Object localObject = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking enabled.", new Object[0]);
        AppMethodBeat.o(243988);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), (String)localObject);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        aa.a("MicroMsg.PatronsWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(243988);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(243988);
      return;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(243988);
  }
  
  private static void markFuseBroken(Context paramContext)
  {
    AppMethodBeat.i(244032);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(244032);
        return;
      }
      aa.a("MicroMsg.PatronsWrapper", "[+] markFuseBroken called.", new Object[0]);
      String str = getMarkerFileName(paramContext, "fuse_broken_" + BuildInfo.CLIENT_VERSION_INT);
      if (TextUtils.isEmpty(str))
      {
        aa.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking fuse broken.", new Object[0]);
        AppMethodBeat.o(244032);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        aa.a("MicroMsg.PatronsWrapper", "[+] Mark fuse broken successfully.", new Object[0]);
        AppMethodBeat.o(244032);
        return;
      }
    }
    finally
    {
      aa.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark fuse broken.", new Object[0]);
      AppMethodBeat.o(244032);
      return;
    }
    aa.c("MicroMsg.PatronsWrapper", "[-] Fail to mark fuse broken.", new Object[0]);
    AppMethodBeat.o(244032);
  }
  
  public static void tryToInstall(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(243971);
    if (!isPreconditionsSatisfied(paramContext))
    {
      aa.a("MicroMsg.PatronsWrapper", "[+] Env condition is not satisfied, skip installation.", new Object[0]);
      AppMethodBeat.o(243971);
      return;
    }
    if (!isEnabled(paramContext))
    {
      aa.a("MicroMsg.PatronsWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(243971);
      return;
    }
    if (isFuseBroken(paramContext))
    {
      aa.c("MicroMsg.PatronsWrapper", "[-] Fuse was broken, skip installation.", new Object[0]);
      AppMethodBeat.o(243971);
      return;
    }
    for (;;)
    {
      try
      {
        localPatronsConfig = new Patrons.PatronsConfig();
        if ((!isAggressiveStrategyEnabled(paramContext)) || (Patrons.getCurrentMaxAvailableVMAddr() >= 3221225472L)) {
          continue;
        }
        aa.a("MicroMsg.PatronsWrapper", "Use aggressive strategy for 3G VmSize.", new Object[0]);
        localPatronsConfig.periodOfCheck = 10;
        localPatronsConfig.periodOfShrink = 0.2F;
        localPatronsConfig.lowerLimit = 96;
        localPatronsConfig.shrinkStep = 64;
        int j = Patrons.init(paramContext, localPatronsConfig);
        if (j == 0) {
          i = 1;
        }
      }
      finally
      {
        Patrons.PatronsConfig localPatronsConfig;
        aa.a("MicroMsg.PatronsWrapper", localThrowable, "[-] install failed.", new Object[0]);
        continue;
        if (!REPORT_FREQ_LIMIT.isExpired("do_rpt")) {
          continue;
        }
        StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(1));
        StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(3));
        AppMethodBeat.o(243971);
      }
      if (i == 0) {
        continue;
      }
      if (!REPORT_FREQ_LIMIT.isExpired("do_rpt")) {
        continue;
      }
      StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(1));
      StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(2));
      AppMethodBeat.o(243971);
      return;
      localPatronsConfig.periodOfShrink = 0.75F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PatronsWrapper
 * JD-Core Version:    0.7.0.1
 */