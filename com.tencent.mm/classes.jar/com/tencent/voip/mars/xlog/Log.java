package com.tencent.voip.mars.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log
{
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_FATAL = 5;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARNING = 3;
  private static final String SYS_INFO;
  private static final String TAG = "mars.xlog.log";
  private static LogImp debugLog;
  private static int level;
  private static LogImp logImp;
  public static Context toastSupportContext;
  
  static
  {
    AppMethodBeat.i(55645);
    level = 6;
    toastSupportContext = null;
    Object localObject = new LogImp()
    {
      private Handler handler;
      
      public final void appenderClose() {}
      
      public final void appenderFlush(boolean paramAnonymousBoolean) {}
      
      public final int getLogLevel()
      {
        AppMethodBeat.i(55653);
        int i = Log.level;
        AppMethodBeat.o(55653);
        return i;
      }
      
      public final void logD(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4)
      {
        AppMethodBeat.i(55649);
        AppMethodBeat.o(55649);
      }
      
      public final void logE(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4)
      {
        AppMethodBeat.i(55651);
        AppMethodBeat.o(55651);
      }
      
      public final void logF(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, final String paramAnonymousString4)
      {
        AppMethodBeat.i(55652);
        if (Log.level > 5)
        {
          AppMethodBeat.o(55652);
          return;
        }
        if (Log.toastSupportContext != null) {
          this.handler.post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(55627);
              Toast.makeText(Log.toastSupportContext, paramAnonymousString4, 1).show();
              AppMethodBeat.o(55627);
            }
          });
        }
        AppMethodBeat.o(55652);
      }
      
      public final void logI(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4)
      {
        AppMethodBeat.i(55648);
        AppMethodBeat.o(55648);
      }
      
      public final void logV(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4)
      {
        AppMethodBeat.i(55647);
        AppMethodBeat.o(55647);
      }
      
      public final void logW(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString4)
      {
        AppMethodBeat.i(55650);
        AppMethodBeat.o(55650);
      }
    };
    debugLog = (LogImp)localObject;
    logImp = (LogImp)localObject;
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
      label365:
      SYS_INFO = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(55645);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label365;
    }
  }
  
  public static void appenderClose()
  {
    AppMethodBeat.i(55628);
    if (logImp != null) {
      logImp.appenderClose();
    }
    AppMethodBeat.o(55628);
  }
  
  public static void appenderFlush(boolean paramBoolean)
  {
    AppMethodBeat.i(55629);
    if (logImp != null) {
      logImp.appenderFlush(paramBoolean);
    }
    AppMethodBeat.o(55629);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55636);
    d(paramString1, paramString2, null);
    AppMethodBeat.o(55636);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55642);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label63;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logD(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(55642);
      return;
      label63:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55633);
    e(paramString1, paramString2, null);
    AppMethodBeat.o(55633);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55639);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label63;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logE(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(55639);
      return;
      label63:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55632);
    f(paramString1, paramString2, null);
    AppMethodBeat.o(55632);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55638);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label54;
      }
    }
    for (;;)
    {
      logImp.logF(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      AppMethodBeat.o(55638);
      return;
      label54:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static LogImp getImpl()
  {
    return logImp;
  }
  
  public static int getLogLevel()
  {
    AppMethodBeat.i(55630);
    if (logImp != null)
    {
      int i = logImp.getLogLevel();
      AppMethodBeat.o(55630);
      return i;
    }
    AppMethodBeat.o(55630);
    return 6;
  }
  
  public static String getSysInfo()
  {
    return SYS_INFO;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55635);
    i(paramString1, paramString2, null);
    AppMethodBeat.o(55635);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55641);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label63;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logI(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(55641);
      return;
      label63:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55644);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label90;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramThrowable = paramVarArgs + "  " + android.util.Log.getStackTraceString(paramThrowable);
      logImp.logE(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
      AppMethodBeat.o(55644);
      return;
      label90:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void setLevel(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(55631);
    level = paramInt;
    if (paramBoolean) {
      Xlog.setLogLevel(paramInt);
    }
    AppMethodBeat.o(55631);
  }
  
  public static void setLogImp(LogImp paramLogImp)
  {
    logImp = paramLogImp;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55637);
    v(paramString1, paramString2, null);
    AppMethodBeat.o(55637);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55643);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label65;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logV(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(55643);
      return;
      label65:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55634);
    w(paramString1, paramString2, null);
    AppMethodBeat.o(55634);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(55640);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label65;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logW(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(55640);
      return;
      label65:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface LogImp
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.xlog.Log
 * JD-Core Version:    0.7.0.1
 */