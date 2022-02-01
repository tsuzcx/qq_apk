package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ae
{
  private static a Ixx;
  private static a Ixy;
  private static Map<String, b> Ixz;
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
        return ae.level;
      }
      
      public final void logD(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void logE(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public final void logF(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4)
      {
        if (ae.level > 5) {}
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
    Ixx = (a)localObject;
    Ixy = (a)localObject;
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
      Ixz = new HashMap();
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
    Ixy = parama;
  }
  
  public static void abd(int paramInt)
  {
    level = paramInt;
  }
  
  public static void appenderClose()
  {
    if (Ixy != null)
    {
      Ixy.appenderClose();
      Ixz.size();
      ??? = new ArrayList();
      Object localObject2 = Ixz.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)???).add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
      localObject2 = ((List)???).listIterator();
      while (((ListIterator)localObject2).hasNext())
      {
        String str = (String)((ListIterator)localObject2).next();
        synchronized (Ixz)
        {
          if ((Ixy != null) && (Ixz.containsKey(str)))
          {
            b localb = (b)Ixz.remove(str);
            Ixy.releaseXlogInstance(str);
            localb.IxA = -1L;
          }
        }
      }
    }
  }
  
  public static void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    if (Ixy != null) {
      Ixy.appenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
    }
  }
  
  public static b bd(String paramString1, String paramString2, String paramString3)
  {
    synchronized (Ixz)
    {
      if (Ixz.containsKey(paramString3))
      {
        paramString1 = (b)Ixz.get(paramString3);
        return paramString1;
      }
      paramString1 = new b(paramString1, paramString2, paramString3, (byte)0);
      Ixz.put(paramString3, paramString1);
      return paramString1;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 1)) {
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
      Ixy.logD(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
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
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 4)) {
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
      Ixy.logE(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
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
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 5)) {
      if (paramVarArgs != null) {
        break label60;
      }
    }
    for (;;)
    {
      Ixy.logF(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      return;
      label60:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static a fon()
  {
    return Ixy;
  }
  
  public static void foo()
  {
    if (Ixy != null)
    {
      Ixy.appenderFlush(0L, false);
      Iterator localIterator = Ixz.entrySet().iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)((Map.Entry)localIterator.next()).getValue();
        if ((Ixy != null) && (localb.IxA != -1L)) {
          Ixy.appenderFlush(localb.IxA, false);
        }
      }
    }
  }
  
  public static void fop()
  {
    if (Ixy != null) {
      Ixy.appenderFlush(0L, true);
    }
  }
  
  public static int getLogLevel()
  {
    if (Ixy != null) {
      return Ixy.getLogLevel(0L);
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
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 2)) {
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
      Ixy.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void l(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 1))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + bu.fpN();
      Ixy.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void m(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 2))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + bu.fpN();
      Ixy.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void moveLogsFromCacheDirToLogDir()
  {
    if (Ixy != null) {
      Ixy.moveLogsFromCacheDirToLogDir();
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 4)) {
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
      Ixy.logE(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
      return;
      label97:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void setConsoleLogOpen(boolean paramBoolean)
  {
    if (Ixy != null) {
      Ixy.setConsoleLogOpen(0L, paramBoolean);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 0)) {
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
      Ixy.logV(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
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
    if ((Ixy != null) && (Ixy.getLogLevel(0L) <= 3)) {
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
      Ixy.logW(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
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
    public long IxA = -1L;
    private String mPrefix = null;
    
    private b(String paramString1, String paramString2, String paramString3)
    {
      if (ae.foq() != null)
      {
        this.IxA = ae.foq().openLogInstance(2, 0, paramString1, paramString2, paramString3, 0);
        this.mPrefix = paramString3;
      }
    }
    
    private int getLogLevel()
    {
      if ((ae.foq() != null) && (this.IxA != -1L)) {
        return ae.foq().getLogLevel(this.IxA);
      }
      return 6;
    }
    
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ae.foq() != null) && (getLogLevel() <= 1) && (this.IxA != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ae.foq().logD(this.IxA, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ae.foq() != null) && (getLogLevel() <= 4) && (this.IxA != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ae.foq().logE(this.IxA, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ae.foq() != null) && (getLogLevel() <= 2) && (this.IxA != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ae.foq().logI(this.IxA, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void nV(String paramString1, String paramString2)
    {
      if ((ae.foq() != null) && (getLogLevel() <= 2) && (this.IxA != -1L))
      {
        if (paramString2 != null) {
          break label72;
        }
        paramString2 = "";
      }
      label72:
      for (;;)
      {
        ae.foq().logI(this.IxA, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
        return;
      }
    }
    
    public final void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ae.foq() != null) && (getLogLevel() <= 0) && (this.IxA != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ae.foq().logV(this.IxA, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((ae.foq() != null) && (getLogLevel() <= 3) && (this.IxA != -1L))
      {
        paramVarArgs = String.format(paramString2, paramVarArgs);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = "";
        }
        ae.foq().logW(this.IxA, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */