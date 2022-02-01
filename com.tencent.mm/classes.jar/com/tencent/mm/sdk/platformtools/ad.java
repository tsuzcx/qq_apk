package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ad
{
  private static a Idm;
  private static a Idn;
  private static Map<String, b> Ido;
  private static final String SYS_INFO;
  private static int level = 6;
  
  static
  {
    Object localObject = new a()
    {
      private Handler handler = new Handler(Looper.getMainLooper());
      
      public final void appenderClose() {}
      
      public final void appenderFlush(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
      
      public final void appenderOpen(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3) {}
      
      public final int getLogLevel(long paramAnonymousLong)
      {
        return ad.level;
      }
      
      public final void logD(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void logE(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void logF(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4)
      {
        if (ad.level > 5) {}
      }
      
      public final void logI(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void logV(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void logW(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void moveLogsFromCacheDirToLogDir() {}
      
      public final long openLogInstance(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3)
      {
        return 0L;
      }
      
      public final void releaseXlogInstance(String paramAnonymousString) {}
      
      public final void setConsoleLogOpen(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
    };
    Idm = (a)localObject;
    Idn = (a)localObject;
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
      Ido = new HashMap();
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
  
  public static void a(a parama)
  {
    Idn = parama;
  }
  
  public static void aax(int paramInt)
  {
    level = paramInt;
  }
  
  public static void appenderClose()
  {
    if (Idn != null)
    {
      Idn.appenderClose();
      Iterator localIterator = Ido.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        synchronized (Ido)
        {
          if ((Idn != null) && (Ido.containsKey(str)))
          {
            b localb = (b)Ido.remove(str);
            Idn.releaseXlogInstance(str);
            localb.Idp = -1L;
          }
        }
      }
    }
  }
  
  public static void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    if (Idn != null) {
      Idn.appenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
    }
  }
  
  public static b bc(String paramString1, String paramString2, String paramString3)
  {
    synchronized (Ido)
    {
      if (Ido.containsKey(paramString3))
      {
        paramString1 = (b)Ido.get(paramString3);
        return paramString1;
      }
      paramString1 = new b(paramString1, paramString2, paramString3, (byte)0);
      Ido.put(paramString3, paramString1);
      return paramString1;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 1)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      Idn.logD(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 4)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      Idn.logE(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 5)) {
      if (paramVarArgs != null) {
        break label60;
      }
    }
    for (;;)
    {
      Idn.logF(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      return;
      label60:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static a fkt()
  {
    return Idn;
  }
  
  public static void fku()
  {
    if (Idn != null)
    {
      Idn.appenderFlush(0L, false);
      Iterator localIterator = Ido.entrySet().iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)((Map.Entry)localIterator.next()).getValue();
        if ((Idn != null) && (localb.Idp != -1L)) {
          Idn.appenderFlush(localb.Idp, false);
        }
      }
    }
  }
  
  public static void fkv()
  {
    if (Idn != null) {
      Idn.appenderFlush(0L, true);
    }
  }
  
  public static int getLogLevel()
  {
    if (Idn != null) {
      return Idn.getLogLevel(0L);
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
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 2)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      Idn.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void l(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 1))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + bt.flS();
      Idn.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void m(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 2))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + bt.flS();
      Idn.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void moveLogsFromCacheDirToLogDir()
  {
    if (Idn != null) {
      Idn.moveLogsFromCacheDirToLogDir();
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 4)) {
      if (paramVarArgs != null) {
        break label97;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramThrowable = paramVarArgs + "  " + Log.getStackTraceString(paramThrowable);
      Idn.logE(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
      return;
      label97:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void setConsoleLogOpen(boolean paramBoolean)
  {
    if (Idn != null) {
      Idn.setConsoleLogOpen(0L, paramBoolean);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 0)) {
      if (paramVarArgs != null) {
        break label68;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      Idn.logV(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label68:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Idn != null) && (Idn.getLogLevel(0L) <= 3)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      Idn.logW(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface a
  {
    public abstract void appenderClose();
    
    public abstract void appenderFlush(long paramLong, boolean paramBoolean);
    
    public abstract void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3);
    
    public abstract int getLogLevel(long paramLong);
    
    public abstract void logD(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logE(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logF(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logI(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logV(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logW(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void moveLogsFromCacheDirToLogDir();
    
    public abstract long openLogInstance(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3);
    
    public abstract void releaseXlogInstance(String paramString);
    
    public abstract void setConsoleLogOpen(long paramLong, boolean paramBoolean);
  }
  
  public static final class b
  {
    long Idp = -1L;
    private String mPrefix = null;
    
    private b(String paramString1, String paramString2, String paramString3)
    {
      if (ad.fkw() != null)
      {
        this.Idp = ad.fkw().openLogInstance(2, 0, paramString1, paramString2, paramString3, 0);
        this.mPrefix = paramString3;
      }
    }
    
    private int getLogLevel()
    {
      if ((ad.fkw() != null) && (this.Idp != -1L)) {
        return ad.fkw().getLogLevel(this.Idp);
      }
      return 6;
    }
    
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ad.fkw() != null) && (getLogLevel() <= 1) && (this.Idp != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ad.fkw().logD(this.Idp, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ad.fkw() != null) && (getLogLevel() <= 4) && (this.Idp != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ad.fkw().logE(this.Idp, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ad.fkw() != null) && (getLogLevel() <= 2) && (this.Idp != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ad.fkw().logI(this.Idp, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ad.fkw() != null) && (getLogLevel() <= 0) && (this.Idp != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ad.fkw().logV(this.Idp, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ad.fkw() != null) && (getLogLevel() <= 3) && (this.Idp != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ad.fkw().logW(this.Idp, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */