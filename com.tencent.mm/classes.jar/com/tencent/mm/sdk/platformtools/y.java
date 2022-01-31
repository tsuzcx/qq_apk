package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

public final class y
{
  private static final String SYS_INFO;
  private static int level = 6;
  private static a ueV;
  private static a ueW;
  
  static
  {
    Object localObject = new a()
    {
      private Handler handler = new Handler(Looper.getMainLooper());
      
      public final void appenderClose() {}
      
      public final void appenderFlush(boolean paramAnonymousBoolean) {}
      
      public final int getLogLevel()
      {
        return y.level;
      }
      
      public final void logD(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4) {}
      
      public final void logE(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4) {}
      
      public final void logF(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4)
      {
        if (y.level > 5) {}
      }
      
      public final void logI(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4) {}
      
      public final void logV(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4) {}
      
      public final void logW(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4) {}
      
      public final void moveLogsFromCacheDirToLogDir() {}
    };
    ueV = (a)localObject;
    ueW = (a)localObject;
    localObject = new StringBuilder();
    try
    {
      ((StringBuilder)localObject).append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
      ((StringBuilder)localObject).append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
      ((StringBuilder)localObject).append("] BOARD:[" + Build.BOARD);
      ((StringBuilder)localObject).append("] DEVICE:[" + Build.DEVICE);
      ((StringBuilder)localObject).append("] DISPLAY:[" + Build.DISPLAY);
      ((StringBuilder)localObject).append("] FINGERPRINT:[" + Build.FINGERPRINT);
      ((StringBuilder)localObject).append("] HOST:[" + Build.HOST);
      ((StringBuilder)localObject).append("] MANUFACTURER:[" + Build.MANUFACTURER);
      ((StringBuilder)localObject).append("] MODEL:[" + Build.MODEL);
      ((StringBuilder)localObject).append("] PRODUCT:[" + Build.PRODUCT);
      ((StringBuilder)localObject).append("] TAGS:[" + Build.TAGS);
      ((StringBuilder)localObject).append("] TYPE:[" + Build.TYPE);
      ((StringBuilder)localObject).append("] USER:[" + Build.USER + "]");
      SYS_INFO = ((StringBuilder)localObject).toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        printErrStackTrace("MicroMsg.SDK.Log", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static void Fc(int paramInt)
  {
    level = paramInt;
  }
  
  public static void a(a parama)
  {
    ueW = parama;
  }
  
  public static void appenderClose()
  {
    if (ueW != null) {
      ueW.appenderClose();
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 1))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + bk.csb();
      ueW.logI(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static a cqK()
  {
    return ueW;
  }
  
  public static void cqL()
  {
    if (ueW != null) {
      ueW.appenderFlush(false);
    }
  }
  
  public static void cqM()
  {
    if (ueW != null) {
      ueW.appenderFlush(true);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 1)) {
      if (paramVarArgs != null) {
        break label67;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      ueW.logD(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label67:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 4)) {
      if (paramVarArgs != null) {
        break label67;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      ueW.logE(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label67:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 5)) {
      if (paramVarArgs != null) {
        break label58;
      }
    }
    for (;;)
    {
      ueW.logF(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      return;
      label58:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static int getLogLevel()
  {
    if (ueW != null) {
      return ueW.getLogLevel();
    }
    return 6;
  }
  
  public static String getSysInfo()
  {
    return SYS_INFO;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 2)) {
      if (paramVarArgs != null) {
        break label67;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      ueW.logI(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label67:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void l(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 2))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + bk.csb();
      ueW.logI(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void moveLogsFromCacheDirToLogDir()
  {
    if (ueW != null) {
      ueW.moveLogsFromCacheDirToLogDir();
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 4)) {
      if (paramVarArgs != null) {
        break label94;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramThrowable = paramVarArgs + "  " + Log.getStackTraceString(paramThrowable);
      ueW.logE(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
      return;
      label94:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 0)) {
      if (paramVarArgs != null) {
        break label66;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      ueW.logV(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label66:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((ueW != null) && (ueW.getLogLevel() <= 3)) {
      if (paramVarArgs != null) {
        break label67;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      ueW.logW(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label67:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface a
  {
    public abstract void appenderClose();
    
    public abstract void appenderFlush(boolean paramBoolean);
    
    public abstract int getLogLevel();
    
    public abstract void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4);
    
    public abstract void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4);
    
    public abstract void logF(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4);
    
    public abstract void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4);
    
    public abstract void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4);
    
    public abstract void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4);
    
    public abstract void moveLogsFromCacheDirToLogDir();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.y
 * JD-Core Version:    0.7.0.1
 */