package com.tencent.wxperf.thread;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ThreadInspect
{
  private static final int ALL_THREAD_FLAG = -2;
  private static final int CURR_PID_FLAG = -1;
  private static final int CURR_TID_FLAG = -1;
  private static final String TAG = "ThreadInspect";
  private static volatile boolean initialized;
  private static final Map<Integer, WeakReference<Thread>> sTidThreads;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(210460);
    sTidThreads = new HashMap();
    init();
    AppMethodBeat.o(210460);
  }
  
  private static String currJavaThrowable()
  {
    AppMethodBeat.i(210401);
    synchronized (sTidThreads)
    {
      sTidThreads.put(Integer.valueOf(Process.myTid()), new WeakReference(Thread.currentThread()));
      AppMethodBeat.o(210401);
      return null;
    }
  }
  
  private static void dump(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(210423);
    if (!initialized)
    {
      AppMethodBeat.o(210423);
      return;
    }
    nativeDump(paramInt1, paramInt2, paramInt3, paramString);
    AppMethodBeat.o(210423);
  }
  
  public static void dumpLocalAllThread(int paramInt)
  {
    AppMethodBeat.i(210437);
    dump(-1, -2, paramInt, null);
    AppMethodBeat.o(210437);
  }
  
  public static void dumpLocalAllThread(int paramInt, String paramString)
  {
    AppMethodBeat.i(210435);
    dump(-1, -2, paramInt, paramString);
    AppMethodBeat.o(210435);
  }
  
  public static void dumpLocalCurrentThread(int paramInt)
  {
    AppMethodBeat.i(210429);
    dump(-1, -1, paramInt, null);
    AppMethodBeat.o(210429);
  }
  
  public static void dumpLocalCurrentThread(int paramInt, String paramString)
  {
    AppMethodBeat.i(210426);
    dump(-1, -1, paramInt, paramString);
    AppMethodBeat.o(210426);
  }
  
  public static void dumpLocalThread(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210432);
    dump(-1, paramInt1, paramInt2, null);
    AppMethodBeat.o(210432);
  }
  
  public static void dumpLocalThread(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(210431);
    dump(-1, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(210431);
  }
  
  public static void dumpRemoteAllThread(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210445);
    dump(paramInt1, -2, paramInt2, null);
    AppMethodBeat.o(210445);
  }
  
  public static void dumpRemoteAllThread(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(210444);
    dump(paramInt1, -2, paramInt2, paramString);
    AppMethodBeat.o(210444);
  }
  
  public static void dumpRemoteThread(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(210441);
    dump(paramInt1, paramInt2, paramInt3, null);
    AppMethodBeat.o(210441);
  }
  
  public static void dumpRemoteThread(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(210440);
    dump(paramInt1, paramInt2, paramInt3, paramString);
    AppMethodBeat.o(210440);
  }
  
  private static String get(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(210446);
    if (!initialized)
    {
      AppMethodBeat.o(210446);
      return null;
    }
    paramString = nativeGet(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(210446);
    return paramString;
  }
  
  public static String getLocalAllThread()
  {
    AppMethodBeat.i(210453);
    String str = get(-1, -2, null);
    AppMethodBeat.o(210453);
    return str;
  }
  
  public static String getLocalAllThread(String paramString)
  {
    AppMethodBeat.i(210451);
    paramString = get(-1, -2, paramString);
    AppMethodBeat.o(210451);
    return paramString;
  }
  
  public static String getLocalCurrentThread()
  {
    AppMethodBeat.i(210448);
    String str = get(-1, -1, null);
    AppMethodBeat.o(210448);
    return str;
  }
  
  public static String getLocalCurrentThread(String paramString)
  {
    AppMethodBeat.i(210447);
    paramString = get(-1, -1, paramString);
    AppMethodBeat.o(210447);
    return paramString;
  }
  
  public static String getLocalThread(int paramInt)
  {
    AppMethodBeat.i(210450);
    String str = get(-1, paramInt, null);
    AppMethodBeat.o(210450);
    return str;
  }
  
  public static String getLocalThread(int paramInt, String paramString)
  {
    AppMethodBeat.i(210449);
    paramString = get(-1, paramInt, paramString);
    AppMethodBeat.o(210449);
    return paramString;
  }
  
  public static String getRemoteAllThread(int paramInt)
  {
    AppMethodBeat.i(210457);
    String str = get(paramInt, -2, null);
    AppMethodBeat.o(210457);
    return str;
  }
  
  public static String getRemoteAllThread(int paramInt, String paramString)
  {
    AppMethodBeat.i(210456);
    paramString = get(paramInt, -2, paramString);
    AppMethodBeat.o(210456);
    return paramString;
  }
  
  public static String getRemoteThread(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210455);
    String str = get(paramInt1, paramInt2, null);
    AppMethodBeat.o(210455);
    return str;
  }
  
  public static String getRemoteThread(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(210454);
    paramString = get(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(210454);
    return paramString;
  }
  
  private static Thread getThreadByTid(int paramInt)
  {
    AppMethodBeat.i(210396);
    synchronized (sTidThreads)
    {
      WeakReference localWeakReference = (WeakReference)sTidThreads.get(Integer.valueOf(paramInt));
      if (localWeakReference != null)
      {
        ??? = (Thread)localWeakReference.get();
        AppMethodBeat.o(210396);
        return ???;
      }
    }
    AppMethodBeat.o(210396);
    return null;
  }
  
  private static String getThreadStack(Thread paramThread)
  {
    AppMethodBeat.i(210399);
    if (paramThread != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramThread = paramThread.getStackTrace();
      int j = paramThread.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramThread[i];
        localStringBuilder.append("\nat ").append(localObject);
        i += 1;
      }
      if (localStringBuilder.length() > 0)
      {
        paramThread = "JUnwind" + localStringBuilder.toString();
        AppMethodBeat.o(210399);
        return paramThread;
      }
      AppMethodBeat.o(210399);
      return null;
    }
    AppMethodBeat.o(210399);
    return null;
  }
  
  /* Error */
  public static boolean init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 174
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 83	com/tencent/wxperf/thread/ThreadInspect:initialized	Z
    //   11: istore_0
    //   12: iload_0
    //   13: ifne +75 -> 88
    //   16: new 176	com/tencent/mm/hellhoundlib/b/a
    //   19: dup
    //   20: invokespecial 177	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   23: ldc 179
    //   25: invokevirtual 183	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   28: astore_1
    //   29: new 4	java/lang/Object
    //   32: dup
    //   33: invokespecial 46	java/lang/Object:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 187	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   42: ldc 188
    //   44: ldc 189
    //   46: ldc 190
    //   48: ldc 192
    //   50: ldc 194
    //   52: ldc 195
    //   54: invokestatic 201	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_1
    //   58: iconst_0
    //   59: invokevirtual 205	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   62: checkcast 207	java/lang/String
    //   65: invokestatic 211	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   68: aload_2
    //   69: ldc 188
    //   71: ldc 189
    //   73: ldc 190
    //   75: ldc 192
    //   77: ldc 194
    //   79: ldc 195
    //   81: invokestatic 215	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   84: iconst_1
    //   85: putstatic 83	com/tencent/wxperf/thread/ThreadInspect:initialized	Z
    //   88: getstatic 83	com/tencent/wxperf/thread/ThreadInspect:initialized	Z
    //   91: istore_0
    //   92: ldc 174
    //   94: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: ldc 2
    //   99: monitorexit
    //   100: iload_0
    //   101: ireturn
    //   102: astore_1
    //   103: bipush 6
    //   105: ldc 14
    //   107: aload_1
    //   108: invokestatic 221	com/tencent/stubs/logger/Log:printStack	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: iconst_0
    //   112: putstatic 83	com/tencent/wxperf/thread/ThreadInspect:initialized	Z
    //   115: goto -27 -> 88
    //   118: astore_1
    //   119: ldc 2
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	90	0	bool	boolean
    //   28	30	1	locala	com.tencent.mm.hellhoundlib.b.a
    //   102	6	1	localThrowable	java.lang.Throwable
    //   118	5	1	localObject1	Object
    //   36	33	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	88	102	finally
    //   3	12	118	finally
    //   88	97	118	finally
    //   103	115	118	finally
  }
  
  public static String jUnwindCurr()
  {
    AppMethodBeat.i(210392);
    try
    {
      String str = getThreadStack(Thread.currentThread());
      AppMethodBeat.o(210392);
      return str;
    }
    catch (Exception localException)
    {
      Log.w("ThreadInspect", localException, "jUnwindCurr failed");
      AppMethodBeat.o(210392);
    }
    return null;
  }
  
  public static String jUnwindR(int paramInt)
  {
    AppMethodBeat.i(210394);
    Thread localThread2 = getThreadByTid(paramInt);
    Object localObject = localThread2;
    if (localThread2 == null)
    {
      localObject = localThread2;
      if (!initialized) {}
    }
    try
    {
      nativeJUnwindR(paramInt);
      localObject = getThreadByTid(paramInt);
      localObject = getThreadStack((Thread)localObject);
      AppMethodBeat.o(210394);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("ThreadInspect", localException, "jUnwindR failed");
        Thread localThread1 = localThread2;
      }
    }
  }
  
  private static void log(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(210402);
    if (!initialized)
    {
      AppMethodBeat.o(210402);
      return;
    }
    nativeLog(paramInt1, paramInt2, paramString1, paramInt3, paramString2);
    AppMethodBeat.o(210402);
  }
  
  public static void logLocalAllThread(String paramString, int paramInt)
  {
    AppMethodBeat.i(210410);
    log(-1, -2, paramString, paramInt, null);
    AppMethodBeat.o(210410);
  }
  
  public static void logLocalAllThread(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(210408);
    log(-1, -2, paramString1, paramInt, paramString2);
    AppMethodBeat.o(210408);
  }
  
  public static void logLocalCurrentThread(String paramString, int paramInt)
  {
    AppMethodBeat.i(210404);
    log(-1, -1, paramString, paramInt, null);
    AppMethodBeat.o(210404);
  }
  
  public static void logLocalCurrentThread(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(210403);
    log(-1, -1, paramString1, paramInt, paramString2);
    AppMethodBeat.o(210403);
  }
  
  public static void logLocalThread(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(210407);
    log(-1, paramInt1, paramString, paramInt2, null);
    AppMethodBeat.o(210407);
  }
  
  public static void logLocalThread(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(210406);
    log(-1, paramInt1, paramString1, paramInt2, paramString2);
    AppMethodBeat.o(210406);
  }
  
  public static void logRemoteAllThread(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(210420);
    log(paramInt1, -2, paramString, paramInt2, null);
    AppMethodBeat.o(210420);
  }
  
  public static void logRemoteAllThread(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(210417);
    log(paramInt1, -2, paramString1, paramInt2, paramString2);
    AppMethodBeat.o(210417);
  }
  
  public static void logRemoteThread(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(210415);
    log(paramInt1, paramInt2, paramString, paramInt3, null);
    AppMethodBeat.o(210415);
  }
  
  public static void logRemoteThread(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(210413);
    log(paramInt1, paramInt2, paramString1, paramInt3, paramString2);
    AppMethodBeat.o(210413);
  }
  
  private static native void nativeDump(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  private static native String nativeGet(int paramInt1, int paramInt2, String paramString);
  
  private static native String nativeJUnwindR(int paramInt);
  
  public static native void nativeLog(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2);
  
  private static native void nativeTgkill(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeTkill(int paramInt1, int paramInt2);
  
  public static void tgkill(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(210387);
    if (initialized) {
      nativeTgkill(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(210387);
  }
  
  public static void tkill(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210386);
    if (initialized) {
      nativeTkill(paramInt1, paramInt2);
    }
    AppMethodBeat.o(210386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wxperf.thread.ThreadInspect
 * JD-Core Version:    0.7.0.1
 */