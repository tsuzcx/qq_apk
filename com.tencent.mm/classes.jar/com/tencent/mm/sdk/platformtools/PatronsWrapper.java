package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.android.patronus.Patrons;
import com.alibaba.android.patronus.Patrons.PatronsConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.app.x;
import java.io.File;

public class PatronsWrapper
{
  private static final String DATA_DIR_NAME = "patrons";
  private static final String ENABLED_MARK_FILE_NAME = "enabled";
  private static final String ENABLED_MARK_ONCE_FILE_NAME = "enabled_marked_once";
  private static final String TAG = "MicroMsg.PatronsWrapper";
  
  private static File getDataStoreDir(Context paramContext)
  {
    AppMethodBeat.i(292742);
    paramContext = paramContext.getDir("patrons", 0);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(292742);
    return paramContext;
  }
  
  private static String getMarkerFileName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(292743);
    String str2 = d.cQP;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Util.getProcessNameByPid(paramContext, Process.myPid());
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(292743);
      return null;
    }
    paramContext = str1.replace('.', '_').replace(":", "__") + "_" + paramString;
    AppMethodBeat.o(292743);
    return paramContext;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    AppMethodBeat.i(292741);
    if (!isPreconditionsSatisfied(paramContext))
    {
      AppMethodBeat.o(292741);
      return false;
    }
    String str = getMarkerFileName(paramContext, "enabled");
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = new File(getDataStoreDir(paramContext), str).exists();
      AppMethodBeat.o(292741);
      return bool;
    }
    x.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, treat as disabled.", new Object[0]);
    AppMethodBeat.o(292741);
    return false;
  }
  
  private static boolean isPreconditionsSatisfied(Context paramContext)
  {
    return !BuildInfo.IS_ARM64;
  }
  
  public static void markDisabled(Context paramContext)
  {
    AppMethodBeat.i(292740);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(292740);
        return;
      }
      String str = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty(str))
      {
        x.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking disabled.", new Object[0]);
        AppMethodBeat.o(292740);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), str);
      if ((!paramContext.exists()) || (paramContext.delete()))
      {
        x.a("MicroMsg.PatronsWrapper", "[+] Mark disabled successfully.", new Object[0]);
        AppMethodBeat.o(292740);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      x.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark disabled.", new Object[0]);
      AppMethodBeat.o(292740);
      return;
    }
    x.c("MicroMsg.PatronsWrapper", "[-] Fail to mark disabled.", new Object[0]);
    AppMethodBeat.o(292740);
  }
  
  public static void markEnabled(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(292739);
    try
    {
      boolean bool = isPreconditionsSatisfied(paramContext);
      if (!bool)
      {
        AppMethodBeat.o(292739);
        return;
      }
      x.a("MicroMsg.PatronsWrapper", "[+] markEnabled called.", new Object[0]);
      if (paramBoolean)
      {
        localObject = getMarkerFileName(paramContext, "enabled_marked_once");
        localObject = new File(getDataStoreDir(paramContext), (String)localObject);
        if (((File)localObject).exists())
        {
          x.b("MicroMsg.PatronsWrapper", "[!] Marked before, skip marking this time.", new Object[0]);
          AppMethodBeat.o(292739);
          return;
        }
        ((File)localObject).createNewFile();
      }
      Object localObject = getMarkerFileName(paramContext, "enabled");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        x.c("MicroMsg.PatronsWrapper", "[-] Fail to get marker file name, skip marking enabled.", new Object[0]);
        AppMethodBeat.o(292739);
        return;
      }
      paramContext = new File(getDataStoreDir(paramContext), (String)localObject);
      if ((paramContext.exists()) || (paramContext.createNewFile()))
      {
        x.a("MicroMsg.PatronsWrapper", "[+] Mark enabled successfully.", new Object[0]);
        AppMethodBeat.o(292739);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      x.a("MicroMsg.PatronsWrapper", paramContext, "[-] Fail to mark enabled.", new Object[0]);
      AppMethodBeat.o(292739);
      return;
    }
    x.c("MicroMsg.PatronsWrapper", "[-] Fail to mark enabled.", new Object[0]);
    AppMethodBeat.o(292739);
  }
  
  public static void tryToInstall(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(292738);
    if (!isPreconditionsSatisfied(paramContext))
    {
      x.a("MicroMsg.PatronsWrapper", "[+] Env condition is not satisfied, skip installation.", new Object[0]);
      AppMethodBeat.o(292738);
      return;
    }
    if (!isEnabled(paramContext))
    {
      x.a("MicroMsg.PatronsWrapper", "[+] Not enabled, skip installation.", new Object[0]);
      AppMethodBeat.o(292738);
      return;
    }
    StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(1));
    for (;;)
    {
      try
      {
        Patrons.PatronsConfig localPatronsConfig = new Patrons.PatronsConfig();
        localPatronsConfig.periodOfShrink = 0.75F;
        int j = Patrons.init(paramContext, localPatronsConfig);
        if (j != 0) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        x.a("MicroMsg.PatronsWrapper", localThrowable, "[-] install failed.", new Object[0]);
        i = 0;
        continue;
        StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(3));
        AppMethodBeat.o(292738);
      }
      if (i == 0) {
        continue;
      }
      StartupILogsReport.reportNumericValue(paramContext, -536739837, Integer.valueOf(2));
      AppMethodBeat.o(292738);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PatronsWrapper
 * JD-Core Version:    0.7.0.1
 */