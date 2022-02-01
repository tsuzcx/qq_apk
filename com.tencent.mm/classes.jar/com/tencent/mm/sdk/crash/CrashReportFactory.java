package com.tencent.mm.sdk.crash;

import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public class CrashReportFactory
{
  private static boolean backupMerge;
  public static String currentActivity;
  public static boolean foreground = false;
  public static long heavyUserFlag = 0L;
  private static boolean isDualByTools;
  private static boolean isHookedByXposed;
  private static boolean isX86Env;
  private static boolean onlinePatchBlocked;
  public static String recentlyDbPoolBusyRunningSql = "";
  private static ICrashReporter reporter;
  
  static
  {
    currentActivity = "unknow";
    reporter = null;
    backupMerge = false;
    onlinePatchBlocked = false;
    isX86Env = false;
    isDualByTools = false;
    isHookedByXposed = false;
  }
  
  public static void addCrashReportExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter paramICrashReportExtraMessageGetter)
  {
    ICrashReporter localICrashReporter = reporter;
    if (localICrashReporter != null) {
      localICrashReporter.addExtraMessageGetter(paramICrashReportExtraMessageGetter);
    }
  }
  
  public static void addCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    ICrashReporter localICrashReporter = reporter;
    if (localICrashReporter != null) {
      localICrashReporter.addCrashReportListener(paramICrashReportListener);
    }
  }
  
  @Deprecated
  public static String getDebugerApiLevel()
  {
    return WeChatEnvironment.getDebuggerApiLevel();
  }
  
  @Deprecated
  public static boolean hasDebuger()
  {
    return WeChatEnvironment.hasDebugger();
  }
  
  public static boolean isBackupMerge()
  {
    return backupMerge;
  }
  
  public static boolean isDualByTools()
  {
    try
    {
      boolean bool = isDualByTools;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isHookedByXposed()
  {
    try
    {
      boolean bool = isHookedByXposed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public static boolean isMonkeyEnv()
  {
    return WeChatEnvironment.isMonkeyEnv();
  }
  
  public static boolean isOnlinePatchBlocked()
  {
    return onlinePatchBlocked;
  }
  
  public static boolean isX86Env()
  {
    try
    {
      boolean bool = isX86Env;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void removeCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    ICrashReporter localICrashReporter = reporter;
    if (localICrashReporter != null) {
      localICrashReporter.removeCrashReportListener(paramICrashReportListener);
    }
  }
  
  public static void reportCrashMessage(String paramString1, String paramString2)
  {
    if (reporter != null) {
      reporter.reportCrashMessage(paramString1, paramString2);
    }
  }
  
  public static void reportJniCrash(int paramInt, String paramString1, String paramString2)
  {
    if (reporter != null) {
      reporter.reportJniCrash(paramInt, paramString1, paramString2);
    }
  }
  
  public static void reportRawMessage(String paramString1, String paramString2)
  {
    if (reporter != null) {
      reporter.reportRawMessage(paramString1, paramString2);
    }
  }
  
  public static void setBackupMerge(boolean paramBoolean)
  {
    backupMerge = paramBoolean;
  }
  
  public static void setCallbackForReset(CallbackForReset paramCallbackForReset)
  {
    if (reporter != null) {
      reporter.setCallbackForReset(paramCallbackForReset);
    }
  }
  
  public static void setCurrentActivity(String paramString)
  {
    currentActivity = paramString;
  }
  
  @Deprecated
  public static void setDebugerApiLevel(String paramString)
  {
    WeChatEnvironment.setDebuggerApiLevel(paramString);
  }
  
  public static void setDualByTools(boolean paramBoolean)
  {
    try
    {
      isDualByTools = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setForeground(boolean paramBoolean)
  {
    foreground = paramBoolean;
  }
  
  @Deprecated
  public static void setHasDebuger(boolean paramBoolean)
  {
    WeChatEnvironment.setHasDebugger(paramBoolean);
  }
  
  public static void setHeavyUserFlag(long paramLong)
  {
    heavyUserFlag = paramLong;
  }
  
  public static void setHookedByXposed(boolean paramBoolean)
  {
    try
    {
      isHookedByXposed = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setOnlinePatchBlocked(boolean paramBoolean)
  {
    onlinePatchBlocked = paramBoolean;
  }
  
  public static void setReportID(String paramString)
  {
    if (reporter != null) {
      reporter.setReportID(paramString);
    }
  }
  
  public static void setX86Env(boolean paramBoolean)
  {
    try
    {
      isX86Env = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setupCrashReporter(ICrashReporter paramICrashReporter)
  {
    reporter = paramICrashReporter;
  }
  
  public static void setupSubReporter(ISubReporter paramISubReporter)
  {
    if (reporter != null) {
      reporter.setupSubReporter(paramISubReporter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.crash.CrashReportFactory
 * JD-Core Version:    0.7.0.1
 */