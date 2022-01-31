package com.tencent.voip.mars.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
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
  private static Log.LogImp debugLog;
  private static int level;
  private static Log.LogImp logImp;
  public static Context toastSupportContext;
  
  static
  {
    AppMethodBeat.i(92808);
    level = 6;
    toastSupportContext = null;
    Object localObject = new Log.1();
    debugLog = (Log.LogImp)localObject;
    logImp = (Log.LogImp)localObject;
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
      AppMethodBeat.o(92808);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label365;
    }
  }
  
  public static void appenderClose()
  {
    AppMethodBeat.i(92791);
    if (logImp != null) {
      logImp.appenderClose();
    }
    AppMethodBeat.o(92791);
  }
  
  public static void appenderFlush(boolean paramBoolean)
  {
    AppMethodBeat.i(92792);
    if (logImp != null) {
      logImp.appenderFlush(paramBoolean);
    }
    AppMethodBeat.o(92792);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92799);
    d(paramString1, paramString2, null);
    AppMethodBeat.o(92799);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92805);
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
      AppMethodBeat.o(92805);
      return;
      label63:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92796);
    e(paramString1, paramString2, null);
    AppMethodBeat.o(92796);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92802);
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
      AppMethodBeat.o(92802);
      return;
      label63:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92795);
    f(paramString1, paramString2, null);
    AppMethodBeat.o(92795);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92801);
    if (logImp != null) {
      if (paramVarArgs != null) {
        break label54;
      }
    }
    for (;;)
    {
      logImp.logF(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      AppMethodBeat.o(92801);
      return;
      label54:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static Log.LogImp getImpl()
  {
    return logImp;
  }
  
  public static int getLogLevel()
  {
    AppMethodBeat.i(92793);
    if (logImp != null)
    {
      int i = logImp.getLogLevel();
      AppMethodBeat.o(92793);
      return i;
    }
    AppMethodBeat.o(92793);
    return 6;
  }
  
  public static String getSysInfo()
  {
    return SYS_INFO;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92798);
    i(paramString1, paramString2, null);
    AppMethodBeat.o(92798);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92804);
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
      AppMethodBeat.o(92804);
      return;
      label63:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92807);
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
      AppMethodBeat.o(92807);
      return;
      label90:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void setLevel(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92794);
    level = paramInt;
    if (paramBoolean) {
      Xlog.setLogLevel(paramInt);
    }
    AppMethodBeat.o(92794);
  }
  
  public static void setLogImp(Log.LogImp paramLogImp)
  {
    logImp = paramLogImp;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92800);
    v(paramString1, paramString2, null);
    AppMethodBeat.o(92800);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92806);
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
      AppMethodBeat.o(92806);
      return;
      label65:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92797);
    w(paramString1, paramString2, null);
    AppMethodBeat.o(92797);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(92803);
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
      AppMethodBeat.o(92803);
      return;
      label65:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.voip.mars.xlog.Log
 * JD-Core Version:    0.7.0.1
 */