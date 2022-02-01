package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueWorkerThread
{
  private static final long DEF_WAIT_OFFER = 1L;
  private static final int MAX_WAIT_COUNT = 60;
  private static final String TAG = "QueueWorkerThread.QueueWorkerThread";
  private static final int WAIT_MILL_TIME = 2000;
  private Object lock;
  private String name;
  private MMHandler onPostExc;
  private boolean pause;
  private int priority;
  private LinkedBlockingQueue<QueueWorkerThread.ThreadObject> queueToReq;
  private int threadCount;
  private Vector<WorkerThread> vectorThread;
  
  public QueueWorkerThread(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
  }
  
  public QueueWorkerThread(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, paramInt2, Looper.myLooper());
    AppMethodBeat.i(157795);
    AppMethodBeat.o(157795);
  }
  
  public QueueWorkerThread(int paramInt1, String paramString, int paramInt2, Looper paramLooper)
  {
    AppMethodBeat.i(157796);
    this.queueToReq = new LinkedBlockingQueue();
    this.pause = false;
    this.threadCount = 1;
    this.priority = 1;
    this.name = "";
    this.lock = new byte[0];
    this.vectorThread = new Vector();
    this.threadCount = paramInt2;
    this.name = paramString;
    this.priority = paramInt1;
    paramString = paramLooper;
    if (paramLooper == null)
    {
      paramString = paramLooper;
      if (Looper.getMainLooper() != null)
      {
        paramString = Looper.getMainLooper();
        Log.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
      }
    }
    this.onPostExc = new QueueWorkerThread.1(this, paramString);
    AppMethodBeat.o(157796);
  }
  
  public int add(QueueWorkerThread.ThreadObject paramThreadObject)
  {
    AppMethodBeat.i(157797);
    if (paramThreadObject == null)
    {
      Log.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      AppMethodBeat.o(157797);
      return -1;
    }
    try
    {
      if (!this.queueToReq.offer(paramThreadObject, 1L, TimeUnit.MILLISECONDS))
      {
        Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
        AppMethodBeat.o(157797);
        return -2;
      }
    }
    catch (Exception paramThreadObject)
    {
      Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + paramThreadObject.getMessage());
      Log.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", paramThreadObject, "", new Object[0]);
      AppMethodBeat.o(157797);
      return -3;
    }
    if ((this.vectorThread.size() == 0) || ((this.queueToReq.size() > 0) && (this.threadCount > this.vectorThread.size()))) {
      new WorkerThread(null).start();
    }
    AppMethodBeat.o(157797);
    return 0;
  }
  
  public void clear()
  {
    AppMethodBeat.i(243905);
    this.queueToReq.clear();
    AppMethodBeat.o(243905);
  }
  
  public int getQueueSize()
  {
    AppMethodBeat.i(243901);
    int i = this.queueToReq.size();
    AppMethodBeat.o(243901);
    return i;
  }
  
  @Deprecated
  public boolean isDead()
  {
    AppMethodBeat.i(157798);
    if ((this.vectorThread == null) || (this.vectorThread.size() == 0))
    {
      AppMethodBeat.o(157798);
      return true;
    }
    AppMethodBeat.o(157798);
    return false;
  }
  
  public void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(157799);
    synchronized (this.lock)
    {
      this.pause = paramBoolean;
      if (!paramBoolean) {}
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        AppMethodBeat.o(157799);
        return;
      }
    }
  }
  
  final class WorkerThread
    extends Thread
  {
    private int waitTimes;
    
    private WorkerThread()
    {
      super();
      AppMethodBeat.i(157793);
      this.waitTimes = 60;
      setPriority(QueueWorkerThread.this.priority);
      QueueWorkerThread.this.vectorThread.add(this);
      AppMethodBeat.o(157793);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 60
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 31	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:waitTimes	I
      //   9: ifle +157 -> 166
      //   12: aload_0
      //   13: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   16: invokestatic 64	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$400	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
      //   19: astore_1
      //   20: aload_1
      //   21: monitorenter
      //   22: aload_0
      //   23: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   26: invokestatic 68	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$500	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Z
      //   29: ifeq +13 -> 42
      //   32: aload_0
      //   33: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   36: invokestatic 64	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$400	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
      //   39: invokevirtual 73	java/lang/Object:wait	()V
      //   42: aload_1
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   48: invokestatic 77	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$600	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
      //   51: ldc2_w 78
      //   54: getstatic 85	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   57: invokevirtual 91	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
      //   60: checkcast 93	com/tencent/mm/sdk/platformtools/QueueWorkerThread$ThreadObject
      //   63: astore_1
      //   64: aload_1
      //   65: ifnonnull +60 -> 125
      //   68: aload_0
      //   69: aload_0
      //   70: getfield 31	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:waitTimes	I
      //   73: iconst_1
      //   74: isub
      //   75: putfield 31	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:waitTimes	I
      //   78: goto -73 -> 5
      //   81: astore_2
      //   82: ldc 95
      //   84: aload_2
      //   85: ldc 97
      //   87: iconst_0
      //   88: anewarray 70	java/lang/Object
      //   91: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   94: goto -52 -> 42
      //   97: astore_2
      //   98: aload_1
      //   99: monitorexit
      //   100: ldc 60
      //   102: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   105: aload_2
      //   106: athrow
      //   107: astore_1
      //   108: ldc 95
      //   110: aload_1
      //   111: ldc 97
      //   113: iconst_0
      //   114: anewarray 70	java/lang/Object
      //   117: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aconst_null
      //   121: astore_1
      //   122: goto -58 -> 64
      //   125: aload_0
      //   126: bipush 60
      //   128: putfield 31	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:waitTimes	I
      //   131: aload_1
      //   132: invokeinterface 107 1 0
      //   137: ifeq -132 -> 5
      //   140: aload_0
      //   141: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   144: invokestatic 111	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$700	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   147: aload_0
      //   148: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   151: invokestatic 111	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$700	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   154: iconst_0
      //   155: aload_1
      //   156: invokevirtual 117	com/tencent/mm/sdk/platformtools/MMHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   159: invokevirtual 121	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
      //   162: pop
      //   163: goto -158 -> 5
      //   166: aload_0
      //   167: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   170: invokestatic 42	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$300	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
      //   173: aload_0
      //   174: invokevirtual 124	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   177: pop
      //   178: ldc 95
      //   180: new 126	java/lang/StringBuilder
      //   183: dup
      //   184: ldc 128
      //   186: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   189: aload_0
      //   190: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   193: invokestatic 77	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$600	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
      //   196: invokevirtual 133	java/util/concurrent/LinkedBlockingQueue:size	()I
      //   199: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   202: ldc 139
      //   204: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: aload_0
      //   208: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:this$0	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   211: invokestatic 42	com/tencent/mm/sdk/platformtools/QueueWorkerThread:access$300	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
      //   214: invokevirtual 143	java/util/Vector:size	()I
      //   217: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   220: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   223: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   226: ldc 60
      //   228: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   231: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	WorkerThread
      //   19	80	1	localObject1	Object
      //   107	4	1	localException1	Exception
      //   121	35	1	localObject2	Object
      //   81	4	2	localException2	Exception
      //   97	9	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   22	42	81	java/lang/Exception
      //   22	42	97	finally
      //   42	44	97	finally
      //   82	94	97	finally
      //   44	64	107	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread
 * JD-Core Version:    0.7.0.1
 */