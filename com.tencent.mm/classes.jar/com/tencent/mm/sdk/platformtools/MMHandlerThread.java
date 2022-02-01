package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;

@Deprecated
public class MMHandlerThread
{
  private static final String TAG = "MicroMsg.MMHandlerThread";
  private static final int WORKER_THREAD_HIGH_PRIROITY = -8;
  private static final int WORKER_THREAD_LOWEST_PRIROITY = 19;
  private static final int WORKER_THREAD_LOW_PRIROITY = 0;
  private static MMHandler mainHandler = null;
  private HandlerThread thread;
  private String threadName;
  private MMHandler workerHandler;
  
  @Deprecated
  public MMHandlerThread(HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(182963);
    this.thread = null;
    this.workerHandler = null;
    this.threadName = null;
    this.workerHandler = null;
    this.thread = paramHandlerThread;
    this.threadName = paramHandlerThread.getName();
    AppMethodBeat.o(182963);
  }
  
  private static MMHandler getMainHandler()
  {
    AppMethodBeat.i(157694);
    if (mainHandler == null) {
      mainHandler = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = mainHandler;
    AppMethodBeat.o(157694);
    return localMMHandler;
  }
  
  private void init(String paramString)
  {
    AppMethodBeat.i(157675);
    this.workerHandler = null;
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "MMHandlerThread";
    }
    this.threadName = str;
    this.thread = DeprecatedThreadFactory.createHandlerThread(this.threadName);
    AppMethodBeat.o(157675);
  }
  
  public static boolean isMainThread()
  {
    AppMethodBeat.i(157692);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      AppMethodBeat.o(157692);
      return true;
    }
    AppMethodBeat.o(157692);
    return false;
  }
  
  public static void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(157695);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157695);
      return;
    }
    getMainHandler().post(paramRunnable);
    AppMethodBeat.o(157695);
  }
  
  private static void postToMainThreadAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(244104);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(244104);
      return;
    }
    getMainHandler().postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(244104);
  }
  
  public static void postToMainThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157696);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157696);
      return;
    }
    getMainHandler().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157696);
  }
  
  public static void removeRunnable(Runnable paramRunnable)
  {
    AppMethodBeat.i(157697);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157697);
      return;
    }
    getMainHandler().removeCallbacks(paramRunnable);
    AppMethodBeat.o(157697);
  }
  
  public static void setCurrentPriority(int paramInt)
  {
    AppMethodBeat.i(157676);
    try
    {
      Process.setThreadPriority(paramInt);
      Log.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(157676);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157676);
    }
  }
  
  public String dump(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(244180);
    Object localObject = getWorkerHandler().getRunningMessage();
    if (localObject == null)
    {
      AppMethodBeat.o(244180);
      return null;
    }
    localObject = ((Message)localObject).toString();
    AppMethodBeat.o(244180);
    return localObject;
  }
  
  public Runnable findTaskByRunTime(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(244183);
    Object localObject = getWorkerHandler().getRunningMessage();
    if (localObject == null)
    {
      AppMethodBeat.o(244183);
      return null;
    }
    localObject = ((Message)localObject).getCallback();
    AppMethodBeat.o(244183);
    return localObject;
  }
  
  public Looper getLooper()
  {
    AppMethodBeat.i(186050);
    Looper localLooper = this.thread.getLooper();
    AppMethodBeat.o(186050);
    return localLooper;
  }
  
  public int getProcessTid()
  {
    AppMethodBeat.i(157678);
    if (this.thread == null)
    {
      AppMethodBeat.o(157678);
      return -1;
    }
    int i = this.thread.getThreadId();
    AppMethodBeat.o(157678);
    return i;
  }
  
  public MMHandler getWorkerHandler()
  {
    AppMethodBeat.i(157684);
    if (this.workerHandler == null) {
      this.workerHandler = new MMHandler(this.thread.getLooper());
    }
    MMHandler localMMHandler = this.workerHandler;
    AppMethodBeat.o(157684);
    return localMMHandler;
  }
  
  public boolean inHighPriority()
  {
    AppMethodBeat.i(244138);
    if ((this.thread == null) || (!this.thread.isAlive()))
    {
      Log.e("MicroMsg.MMHandlerThread", "check inHighPriority failed thread is dead");
      AppMethodBeat.o(244138);
      return false;
    }
    int i = this.thread.getThreadId();
    try
    {
      int j = Process.getThreadPriority(i);
      if (-8 == j)
      {
        AppMethodBeat.o(244138);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.MMHandlerThread", "thread:%d  check inHighPriority failed", new Object[] { Integer.valueOf(i) });
      Log.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(244138);
    }
    return false;
  }
  
  public void interrupt()
  {
    AppMethodBeat.i(244146);
    this.thread.interrupt();
    AppMethodBeat.o(244146);
  }
  
  public boolean isThisHandlerThread()
  {
    AppMethodBeat.i(157693);
    if (Thread.currentThread().getId() == this.thread.getId())
    {
      AppMethodBeat.o(157693);
      return true;
    }
    AppMethodBeat.o(157693);
    return false;
  }
  
  public int postAtFrontOfQueueToWorker(Runnable paramRunnable)
  {
    AppMethodBeat.i(157689);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157689);
      return -1;
    }
    getWorkerHandler().postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(157689);
    return 0;
  }
  
  public int postAtFrontOfWorker(final IWaitWorkThread paramIWaitWorkThread)
  {
    AppMethodBeat.i(157691);
    if (paramIWaitWorkThread == null)
    {
      AppMethodBeat.o(157691);
      return -1;
    }
    if (new MMHandler(getLooper()).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(157673);
        paramIWaitWorkThread.doInBackground();
        MMHandlerThread.access$200(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(157672);
            MMHandlerThread.3.this.val$waitWorkThread.onPostExecute();
            AppMethodBeat.o(157672);
          }
        });
        AppMethodBeat.o(157673);
      }
      
      public String toString()
      {
        AppMethodBeat.i(157674);
        String str = super.toString() + "|" + paramIWaitWorkThread.toString();
        AppMethodBeat.o(157674);
        return str;
      }
    }))
    {
      AppMethodBeat.o(157691);
      return 0;
    }
    AppMethodBeat.o(157691);
    return -2;
  }
  
  public int postToWorker(Runnable paramRunnable)
  {
    AppMethodBeat.i(157688);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157688);
      return -1;
    }
    getWorkerHandler().post(paramRunnable);
    AppMethodBeat.o(157688);
    return 0;
  }
  
  public int postToWorkerDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157690);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157690);
      return -1;
    }
    getWorkerHandler().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157690);
    return 0;
  }
  
  public boolean quit()
  {
    AppMethodBeat.i(244158);
    boolean bool = this.thread.quit();
    AppMethodBeat.o(244158);
    return bool;
  }
  
  public boolean quitSafely()
  {
    AppMethodBeat.i(177914);
    boolean bool = this.thread.quitSafely();
    AppMethodBeat.o(177914);
    return bool;
  }
  
  public int reset(final IWaitWorkThread paramIWaitWorkThread)
  {
    AppMethodBeat.i(244150);
    Log.i("MicroMsg.MMHandlerThread", "reset stack:%s", new Object[] { Util.getStack() });
    int i = postAtFrontOfWorker(new IWaitWorkThread()
    {
      public boolean doInBackground()
      {
        AppMethodBeat.i(244126);
        if (paramIWaitWorkThread != null)
        {
          boolean bool = paramIWaitWorkThread.doInBackground();
          AppMethodBeat.o(244126);
          return bool;
        }
        MMHandlerThread.this.thread.quit();
        MMHandlerThread.access$100(MMHandlerThread.this, this.val$threadName);
        AppMethodBeat.o(244126);
        return true;
      }
      
      public boolean onPostExecute()
      {
        AppMethodBeat.i(244116);
        if (paramIWaitWorkThread != null)
        {
          boolean bool = paramIWaitWorkThread.onPostExecute();
          AppMethodBeat.o(244116);
          return bool;
        }
        AppMethodBeat.o(244116);
        return true;
      }
    });
    AppMethodBeat.o(244150);
    return i;
  }
  
  public void setHighPriority()
  {
    AppMethodBeat.i(157679);
    if ((this.thread == null) || (!this.thread.isAlive()))
    {
      Log.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
      AppMethodBeat.o(157679);
      return;
    }
    int i = this.thread.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        Log.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
        AppMethodBeat.o(157679);
        return;
      }
      Process.setThreadPriority(i, -8);
      Log.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157679);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      Log.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157679);
    }
  }
  
  public void setLowPriority()
  {
    AppMethodBeat.i(157680);
    if ((this.thread == null) || (!this.thread.isAlive()))
    {
      Log.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
      AppMethodBeat.o(157680);
      return;
    }
    int i = this.thread.getThreadId();
    try
    {
      if (Process.getThreadPriority(i) == 0)
      {
        Log.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
        AppMethodBeat.o(157680);
        return;
      }
      Process.setThreadPriority(i, 0);
      Log.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157680);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", new Object[] { Integer.valueOf(i) });
      Log.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157680);
    }
  }
  
  public void setLowestPriority()
  {
    AppMethodBeat.i(157677);
    if ((this.thread == null) || (!this.thread.isAlive()))
    {
      Log.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
      AppMethodBeat.o(157677);
      return;
    }
    int i = this.thread.getThreadId();
    try
    {
      if (19 == Process.getThreadPriority(i))
      {
        Log.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
        AppMethodBeat.o(157677);
        return;
      }
      Process.setThreadPriority(i, 19);
      Log.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157677);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", new Object[] { Integer.valueOf(i) });
      Log.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157677);
    }
  }
  
  /* Error */
  public int syncReset(final ResetCallback paramResetCallback)
  {
    // Byte code:
    //   0: ldc_w 319
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 23
    //   8: ldc_w 321
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: invokestatic 121	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   20: invokevirtual 125	java/lang/Thread:getId	()J
    //   23: invokestatic 326	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   32: aastore
    //   33: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 328
    //   39: invokestatic 330	com/tencent/mm/sdk/platformtools/MMHandlerThread:isMainThread	()Z
    //   42: invokestatic 336	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   45: aload_0
    //   46: getfield 54	com/tencent/mm/sdk/platformtools/MMHandlerThread:thread	Landroid/os/HandlerThread;
    //   49: invokevirtual 245	android/os/HandlerThread:getId	()J
    //   52: lstore_3
    //   53: iconst_0
    //   54: newarray byte
    //   56: astore 7
    //   58: new 8	com/tencent/mm/sdk/platformtools/MMHandlerThread$2
    //   61: dup
    //   62: aload_0
    //   63: aload_1
    //   64: aload_0
    //   65: getfield 58	com/tencent/mm/sdk/platformtools/MMHandlerThread:threadName	Ljava/lang/String;
    //   68: aload 7
    //   70: invokespecial 339	com/tencent/mm/sdk/platformtools/MMHandlerThread$2:<init>	(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$ResetCallback;Ljava/lang/String;Ljava/lang/Object;)V
    //   73: astore_1
    //   74: aload 7
    //   76: monitorenter
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 281	com/tencent/mm/sdk/platformtools/MMHandlerThread:postAtFrontOfWorker	(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;)I
    //   82: istore_2
    //   83: aload_0
    //   84: getfield 54	com/tencent/mm/sdk/platformtools/MMHandlerThread:thread	Landroid/os/HandlerThread;
    //   87: invokevirtual 245	android/os/HandlerThread:getId	()J
    //   90: lstore 5
    //   92: ldc 23
    //   94: ldc_w 341
    //   97: iconst_3
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: iload_2
    //   104: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: lload_3
    //   111: invokestatic 326	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: aastore
    //   115: dup
    //   116: iconst_2
    //   117: lload 5
    //   119: invokestatic 326	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: iload_2
    //   127: ifne +15 -> 142
    //   130: lload_3
    //   131: lload 5
    //   133: lcmp
    //   134: ifne +8 -> 142
    //   137: aload 7
    //   139: invokevirtual 344	java/lang/Object:wait	()V
    //   142: aload 7
    //   144: monitorexit
    //   145: ldc_w 319
    //   148: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: iload_2
    //   152: ireturn
    //   153: astore_1
    //   154: ldc 23
    //   156: ldc_w 346
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 349	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: goto -31 -> 142
    //   176: astore_1
    //   177: aload 7
    //   179: monitorexit
    //   180: ldc_w 319
    //   183: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	MMHandlerThread
    //   0	188	1	paramResetCallback	ResetCallback
    //   82	70	2	i	int
    //   52	79	3	l1	long
    //   90	42	5	l2	long
    //   56	122	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   137	142	153	java/lang/Exception
    //   77	126	176	finally
    //   137	142	176	finally
    //   142	145	176	finally
    //   154	173	176	finally
  }
  
  public static abstract interface IWaitWorkThread
  {
    public abstract boolean doInBackground();
    
    public abstract boolean onPostExecute();
  }
  
  public static abstract interface ResetCallback
  {
    public abstract void callback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread
 * JD-Core Version:    0.7.0.1
 */