package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Log
{
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_FATAL = 5;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARNING = 3;
  private static String SYS_INFO;
  private static final String TAG = "MicroMsg.SDK.Log";
  private static LogImp debugLog;
  private static int level = 6;
  private static LogImp logImp;
  private static Map<String, LogInstance> sLogInstanceMap = new HashMap();
  
  static
  {
    LogImp local1 = new LogImp()
    {
      private Handler handler = new Handler(Looper.getMainLooper());
      
      public void appenderClose() {}
      
      public void appenderFlush(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
      
      public void appenderOpen(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3) {}
      
      public int getLogLevel(long paramAnonymousLong)
      {
        return Log.level;
      }
      
      public long getXlogInstance(String paramAnonymousString)
      {
        return 0L;
      }
      
      public void logD(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public void logE(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public void logF(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4)
      {
        if (Log.level > 5) {}
      }
      
      public void logI(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public void logV(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public void logW(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong2, long paramAnonymousLong3, String paramAnonymousString4) {}
      
      public void moveLogsFromCacheDirToLogDir() {}
      
      public long openLogInstance(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3)
      {
        return 0L;
      }
      
      public void releaseXlogInstance(String paramAnonymousString) {}
      
      public void setAppenderMode(long paramAnonymousLong, int paramAnonymousInt) {}
      
      public void setConsoleLogOpen(long paramAnonymousLong, boolean paramAnonymousBoolean) {}
      
      public void setMaxAliveTime(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void setMaxFileSize(long paramAnonymousLong1, long paramAnonymousLong2) {}
    };
    debugLog = local1;
    logImp = local1;
  }
  
  public static void appenderClose()
  {
    if (logImp != null)
    {
      logImp.appenderClose();
      sLogInstanceMap.size();
      Object localObject = new ArrayList();
      Iterator localIterator = sLogInstanceMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)((Map.Entry)localIterator.next()).getKey());
      }
      localObject = ((List)localObject).listIterator();
      while (((ListIterator)localObject).hasNext()) {
        closeLogInstance((String)((ListIterator)localObject).next());
      }
    }
  }
  
  public static void appenderFlush()
  {
    if (logImp != null)
    {
      logImp.appenderFlush(0L, false);
      Iterator localIterator = sLogInstanceMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((LogInstance)((Map.Entry)localIterator.next()).getValue()).appenderFlush();
      }
    }
  }
  
  public static void appenderFlushSync()
  {
    if (logImp != null) {
      logImp.appenderFlush(0L, true);
    }
  }
  
  public static void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    if (logImp != null) {
      logImp.appenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
    }
  }
  
  public static void closeLogInstance(String paramString)
  {
    synchronized (sLogInstanceMap)
    {
      if ((logImp != null) && (sLogInstanceMap.containsKey(paramString)))
      {
        LogInstance localLogInstance = (LogInstance)sLogInstanceMap.remove(paramString);
        logImp.releaseXlogInstance(paramString);
        LogInstance.access$202(localLogInstance, -1L);
      }
      return;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 1)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label74;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logD(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label74:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 4)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label74;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logE(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label74:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 5)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label65;
      }
    }
    for (;;)
    {
      logImp.logF(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      return;
      label65:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static LogImp getImpl()
  {
    return logImp;
  }
  
  public static LogInstance getLogInstance(String paramString)
  {
    synchronized (sLogInstanceMap)
    {
      if (sLogInstanceMap.containsKey(paramString))
      {
        paramString = (LogInstance)sLogInstanceMap.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public static int getLogLevel()
  {
    if (logImp != null) {
      return logImp.getLogLevel(0L);
    }
    return 6;
  }
  
  public static String getSysInfo()
  {
    StringBuilder localStringBuilder;
    if (SYS_INFO == null) {
      localStringBuilder = new StringBuilder();
    }
    try
    {
      localStringBuilder.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
      localStringBuilder.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
      localStringBuilder.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
      localStringBuilder.append("] BOARD:[" + Build.BOARD);
      localStringBuilder.append("] DEVICE:[" + Build.DEVICE);
      localStringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
      localStringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
      localStringBuilder.append("] HOST:[" + Build.HOST);
      localStringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
      localStringBuilder.append("] MODEL:[" + Build.MODEL);
      localStringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
      localStringBuilder.append("] TAGS:[" + Build.TAGS);
      localStringBuilder.append("] TYPE:[" + Build.TYPE);
      localStringBuilder.append("] USER:[" + Build.USER + "]");
      SYS_INFO = localStringBuilder.toString();
      return SYS_INFO;
    }
    finally
    {
      for (;;)
      {
        printErrStackTrace("MicroMsg.SDK.Log", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 2)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label74;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label74:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void moveLogsFromCacheDirToLogDir()
  {
    if (logImp != null) {
      logImp.moveLogsFromCacheDirToLogDir();
    }
  }
  
  public static LogInstance openLogInstance(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    synchronized (sLogInstanceMap)
    {
      if (sLogInstanceMap.containsKey(paramString3))
      {
        paramString1 = (LogInstance)sLogInstanceMap.get(paramString3);
        return paramString1;
      }
      paramString1 = new LogInstance(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, null);
      sLogInstanceMap.put(paramString3, paramString1);
      return paramString1;
    }
  }
  
  public static void printDebugStack(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 1)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label101;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = paramVarArgs + "  " + Util.getStack();
      logImp.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      return;
      label101:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 4)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label102;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramThrowable = paramVarArgs + "  " + android.util.Log.getStackTraceString(paramThrowable);
      logImp.logE(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
      return;
      label102:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void printInfoStack(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 2)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label101;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = paramVarArgs + "  " + Util.getStack();
      logImp.logI(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
      return;
      label101:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void setConsoleLogOpen(boolean paramBoolean)
  {
    if (logImp != null) {
      logImp.setConsoleLogOpen(0L, paramBoolean);
    }
  }
  
  public static void setLevel(int paramInt, boolean paramBoolean)
  {
    level = paramInt;
  }
  
  public static void setLogImp(LogImp paramLogImp)
  {
    logImp = paramLogImp;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 0)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label73;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logV(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label73:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((logImp != null) && (logImp.getLogLevel(0L) <= 3)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label74;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logW(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      return;
      label74:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface LogImp
  {
    public abstract void appenderClose();
    
    public abstract void appenderFlush(long paramLong, boolean paramBoolean);
    
    public abstract void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3);
    
    public abstract int getLogLevel(long paramLong);
    
    public abstract long getXlogInstance(String paramString);
    
    public abstract void logD(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logE(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logF(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logI(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logV(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void logW(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4);
    
    public abstract void moveLogsFromCacheDirToLogDir();
    
    public abstract long openLogInstance(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3);
    
    public abstract void releaseXlogInstance(String paramString);
    
    public abstract void setAppenderMode(long paramLong, int paramInt);
    
    public abstract void setConsoleLogOpen(long paramLong, boolean paramBoolean);
    
    public abstract void setMaxAliveTime(long paramLong1, long paramLong2);
    
    public abstract void setMaxFileSize(long paramLong1, long paramLong2);
  }
  
  public static class LogInstance
  {
    private long mLogInstancePtr = -1L;
    private String mPrefix = null;
    
    private LogInstance(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
    {
      if (Log.logImp != null)
      {
        this.mLogInstancePtr = Log.logImp.openLogInstance(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
        this.mPrefix = paramString3;
      }
    }
    
    public void appenderFlush()
    {
      if ((Log.logImp != null) && (this.mLogInstancePtr != -1L)) {
        Log.logImp.appenderFlush(this.mLogInstancePtr, false);
      }
    }
    
    public void appenderFlushSync()
    {
      if ((Log.logImp != null) && (this.mLogInstancePtr != -1L)) {
        Log.logImp.appenderFlush(this.mLogInstancePtr, true);
      }
    }
    
    public void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 1) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label83;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Log.logImp.logD(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
        return;
        label83:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 4) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label83;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Log.logImp.logE(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
        return;
        label83:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void f(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 5) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label74;
        }
      }
      for (;;)
      {
        Log.logImp.logF(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
        return;
        label74:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public int getLogLevel()
    {
      if ((Log.logImp != null) && (this.mLogInstancePtr != -1L)) {
        return Log.logImp.getLogLevel(this.mLogInstancePtr);
      }
      return 6;
    }
    
    public void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 2) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label83;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Log.logImp.logI(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
        return;
        label83:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void iNoFormat(String paramString1, String paramString2)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 2) && (this.mLogInstancePtr != -1L))
      {
        if (paramString2 != null) {
          break label72;
        }
        paramString2 = "";
      }
      label72:
      for (;;)
      {
        Log.logImp.logI(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
        return;
      }
    }
    
    public void printDebugStack(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 1) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label109;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        paramString2 = paramVarArgs + "  " + Util.getStack();
        Log.logImp.logI(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
        return;
        label109:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 4) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label115;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        paramThrowable = paramVarArgs + "  " + android.util.Log.getStackTraceString(paramThrowable);
        Log.logImp.logE(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
        return;
        label115:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void printInfoStack(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 2) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label109;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        paramString2 = paramVarArgs + "  " + Util.getStack();
        Log.logImp.logI(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
        return;
        label109:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void setConsoleLogOpen(boolean paramBoolean)
    {
      if ((Log.logImp != null) && (this.mLogInstancePtr != -1L)) {
        Log.logImp.setConsoleLogOpen(this.mLogInstancePtr, paramBoolean);
      }
    }
    
    public void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 0) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label82;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Log.logImp.logV(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
        return;
        label82:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
    
    public void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      if ((Log.logImp != null) && (getLogLevel() <= 3) && (this.mLogInstancePtr != -1L)) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label83;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Log.logImp.logW(this.mLogInstancePtr, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
        return;
        label83:
        paramString2 = String.format(paramString2, paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Log
 * JD-Core Version:    0.7.0.1
 */