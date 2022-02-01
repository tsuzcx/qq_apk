package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Constructor;

public class ShareTinkerLog
{
  public static final int FN_LOG_PRINT_PENDING_LOGS = 4002;
  public static final int FN_LOG_PRINT_STACKTRACE = 4001;
  private static final String TAG = "Tinker.ShareTinkerLog";
  private static final TinkerLogImp debugLog = new ShareTinkerLog.1();
  private static final TinkerLogImp[] tinkerLogImpRef = { debugLog };
  private static final Handler[] tinkerLogInlineFenceRef = { null };
  
  static
  {
    synchronized (tinkerLogInlineFenceRef)
    {
      try
      {
        Constructor localConstructor = Class.forName("com.tencent.tinker.loader.shareutil.TinkerLogInlineFence").getDeclaredConstructor(new Class[0]);
        localConstructor.setAccessible(true);
        tinkerLogInlineFenceRef[0] = ((Handler)localConstructor.newInstance(new Object[0]));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          tinkerLogInlineFenceRef[0] = null;
        }
      }
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    printLog(3, paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    printLog(6, paramString1, paramString2, paramVarArgs);
  }
  
  public static TinkerLogImp getDefaultImpl()
  {
    return debugLog;
  }
  
  public static TinkerLogImp getImpl()
  {
    synchronized (tinkerLogImpRef)
    {
      TinkerLogImp localTinkerLogImp = tinkerLogImpRef[0];
      return localTinkerLogImp;
    }
  }
  
  private static Handler getInlineFence()
  {
    synchronized (tinkerLogInlineFenceRef)
    {
      Handler localHandler = tinkerLogInlineFenceRef[0];
      return localHandler;
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    printLog(4, paramString1, paramString2, paramVarArgs);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    printLog(paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  private static void printLog(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    Handler localHandler = getInlineFence();
    if (localHandler != null)
    {
      paramString1 = Message.obtain(localHandler, paramInt, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), paramString1, paramString2, paramVarArgs });
      localHandler.handleMessage(paramString1);
      paramString1.recycle();
      return;
    }
    debugLog.e(paramString1, "!! NO_LOG_IMPL !! Original Log: ".concat(String.valueOf(paramString2)), paramVarArgs);
  }
  
  private static void printLog(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    Handler localHandler = getInlineFence();
    if (localHandler != null)
    {
      paramString1 = Message.obtain(localHandler, 4001, new Object[] { Integer.valueOf(4001), Long.valueOf(l), paramString1, paramThrowable, paramString2, paramVarArgs });
      localHandler.handleMessage(paramString1);
      paramString1.recycle();
      return;
    }
    debugLog.printErrStackTrace(paramString1, paramThrowable, "!! NO_LOG_IMPL !! Original Log: ".concat(String.valueOf(paramString2)), paramVarArgs);
  }
  
  public static void printPendingLogs()
  {
    Handler localHandler = getInlineFence();
    if (localHandler != null)
    {
      Message localMessage = Message.obtain(localHandler, 4002);
      localHandler.handleMessage(localMessage);
      localMessage.recycle();
    }
  }
  
  public static void setTinkerLogImp(TinkerLogImp paramTinkerLogImp)
  {
    synchronized (tinkerLogImpRef)
    {
      tinkerLogImpRef[0] = paramTinkerLogImp;
      if ((paramTinkerLogImp != null) && (paramTinkerLogImp != debugLog)) {
        printPendingLogs();
      }
      return;
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    printLog(2, paramString1, paramString2, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    printLog(5, paramString1, paramString2, paramVarArgs);
  }
  
  public static abstract interface TinkerLogImp
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerLog
 * JD-Core Version:    0.7.0.1
 */