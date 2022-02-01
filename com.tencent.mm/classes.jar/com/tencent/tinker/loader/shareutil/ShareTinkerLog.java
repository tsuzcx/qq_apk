package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Message;

public class ShareTinkerLog
{
  public static final int FN_LOG_PRINT_PENDING_LOGS = 4002;
  public static final int FN_LOG_PRINT_STACKTRACE = 4001;
  private static final String TAG = "Tinker.ShareTinkerLog";
  private static final TinkerLogImp debugLog;
  private static final TinkerLogImp[] tinkerLogImpRef;
  private static final Handler[] tinkerLogInlineFenceRef;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 26	android/os/Handler
    //   4: dup
    //   5: iconst_0
    //   6: aconst_null
    //   7: aastore
    //   8: putstatic 28	com/tencent/tinker/loader/shareutil/ShareTinkerLog:tinkerLogInlineFenceRef	[Landroid/os/Handler;
    //   11: new 30	com/tencent/tinker/loader/shareutil/ShareTinkerLog$1
    //   14: dup
    //   15: invokespecial 33	com/tencent/tinker/loader/shareutil/ShareTinkerLog$1:<init>	()V
    //   18: putstatic 35	com/tencent/tinker/loader/shareutil/ShareTinkerLog:debugLog	Lcom/tencent/tinker/loader/shareutil/ShareTinkerLog$TinkerLogImp;
    //   21: iconst_1
    //   22: anewarray 6	com/tencent/tinker/loader/shareutil/ShareTinkerLog$TinkerLogImp
    //   25: dup
    //   26: iconst_0
    //   27: getstatic 35	com/tencent/tinker/loader/shareutil/ShareTinkerLog:debugLog	Lcom/tencent/tinker/loader/shareutil/ShareTinkerLog$TinkerLogImp;
    //   30: aastore
    //   31: putstatic 37	com/tencent/tinker/loader/shareutil/ShareTinkerLog:tinkerLogImpRef	[Lcom/tencent/tinker/loader/shareutil/ShareTinkerLog$TinkerLogImp;
    //   34: getstatic 28	com/tencent/tinker/loader/shareutil/ShareTinkerLog:tinkerLogInlineFenceRef	[Landroid/os/Handler;
    //   37: astore_0
    //   38: aload_0
    //   39: monitorenter
    //   40: ldc 39
    //   42: invokestatic 45	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   45: iconst_0
    //   46: anewarray 41	java/lang/Class
    //   49: invokevirtual 49	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   52: astore_1
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual 55	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   58: getstatic 28	com/tencent/tinker/loader/shareutil/ShareTinkerLog:tinkerLogInlineFenceRef	[Landroid/os/Handler;
    //   61: iconst_0
    //   62: aload_1
    //   63: iconst_0
    //   64: anewarray 4	java/lang/Object
    //   67: invokevirtual 59	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 26	android/os/Handler
    //   73: aastore
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: getstatic 28	com/tencent/tinker/loader/shareutil/ShareTinkerLog:tinkerLogInlineFenceRef	[Landroid/os/Handler;
    //   81: iconst_0
    //   82: aconst_null
    //   83: aastore
    //   84: goto -10 -> 74
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	52	0	arrayOfHandler	Handler[]
    //   52	11	1	localConstructor	java.lang.reflect.Constructor
    //   77	1	1	localObject1	Object
    //   87	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	74	77	finally
    //   74	76	87	finally
    //   78	84	87	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerLog
 * JD-Core Version:    0.7.0.1
 */