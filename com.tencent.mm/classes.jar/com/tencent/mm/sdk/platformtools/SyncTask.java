package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SyncTask<R>
{
  private static final String TAG = "MicroMsg.SDK.SyncTask";
  private long begin;
  private Object lock = new Object();
  private boolean manualFinish = false;
  private R result;
  private Runnable task = new Runnable()
  {
    public void run()
    {
      AppMethodBeat.i(157837);
      Log.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + SyncTask.this.manualFinish);
      if (SyncTask.this.manualFinish) {
        SyncTask.this.run();
      }
      for (;;)
      {
        SyncTask.access$102(SyncTask.this, Util.ticksToNow(SyncTask.this.begin));
        AppMethodBeat.o(157837);
        return;
        SyncTask.this.setResultFinish(SyncTask.this.run());
      }
    }
  };
  private final long timeout;
  private long wait;
  
  public SyncTask()
  {
    this(0L, null);
  }
  
  public SyncTask(long paramLong, R paramR)
  {
    this.timeout = paramLong;
    this.result = paramR;
  }
  
  public SyncTask(long paramLong, R paramR, boolean paramBoolean)
  {
    this.timeout = paramLong;
    this.result = paramR;
    this.manualFinish = paramBoolean;
  }
  
  /* Error */
  public R exec(MMHandler paramMMHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +15 -> 16
    //   4: ldc 11
    //   6: ldc 64
    //   8: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 74	com/tencent/mm/sdk/platformtools/SyncTask:run	()Ljava/lang/Object;
    //   15: areturn
    //   16: ldc 11
    //   18: ldc 76
    //   20: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 85	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   27: ifnull +46 -> 73
    //   30: invokestatic 91	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   33: invokevirtual 95	java/lang/Thread:getId	()J
    //   36: aload_1
    //   37: invokevirtual 85	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   40: invokevirtual 100	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   43: invokevirtual 95	java/lang/Thread:getId	()J
    //   46: lcmp
    //   47: ifne +21 -> 68
    //   50: iconst_1
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq +34 -> 87
    //   56: ldc 11
    //   58: ldc 102
    //   60: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: invokevirtual 74	com/tencent/mm/sdk/platformtools/SyncTask:run	()Ljava/lang/Object;
    //   67: areturn
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -18 -> 52
    //   73: aload_1
    //   74: invokevirtual 106	com/tencent/mm/sdk/platformtools/MMHandler:getSerialTag	()Ljava/lang/String;
    //   77: invokestatic 111	com/tencent/e/j/a:iqg	()Ljava/lang/String;
    //   80: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: istore_2
    //   84: goto -32 -> 52
    //   87: aload_0
    //   88: invokestatic 122	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   91: putfield 58	com/tencent/mm/sdk/platformtools/SyncTask:begin	J
    //   94: aload_0
    //   95: getfield 33	com/tencent/mm/sdk/platformtools/SyncTask:lock	Ljava/lang/Object;
    //   98: astore 5
    //   100: aload 5
    //   102: monitorenter
    //   103: ldc 11
    //   105: ldc 124
    //   107: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 40	com/tencent/mm/sdk/platformtools/SyncTask:task	Ljava/lang/Runnable;
    //   115: invokevirtual 128	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   118: pop
    //   119: aload_0
    //   120: getfield 33	com/tencent/mm/sdk/platformtools/SyncTask:lock	Ljava/lang/Object;
    //   123: aload_0
    //   124: getfield 42	com/tencent/mm/sdk/platformtools/SyncTask:timeout	J
    //   127: invokevirtual 131	java/lang/Object:wait	(J)V
    //   130: aload 5
    //   132: monitorexit
    //   133: aload_0
    //   134: getfield 58	com/tencent/mm/sdk/platformtools/SyncTask:begin	J
    //   137: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   140: lstore_3
    //   141: ldc 11
    //   143: ldc 137
    //   145: iconst_4
    //   146: anewarray 5	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: new 139	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   158: aload_0
    //   159: getfield 44	com/tencent/mm/sdk/platformtools/SyncTask:result	Ljava/lang/Object;
    //   162: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: lload_3
    //   172: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_0
    //   179: getfield 54	com/tencent/mm/sdk/platformtools/SyncTask:wait	J
    //   182: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: dup
    //   187: iconst_3
    //   188: lload_3
    //   189: aload_0
    //   190: getfield 54	com/tencent/mm/sdk/platformtools/SyncTask:wait	J
    //   193: lsub
    //   194: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: aastore
    //   198: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload_0
    //   202: getfield 44	com/tencent/mm/sdk/platformtools/SyncTask:result	Ljava/lang/Object;
    //   205: areturn
    //   206: astore_1
    //   207: aload 5
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: ldc 11
    //   215: aload_1
    //   216: ldc 158
    //   218: iconst_0
    //   219: anewarray 5	java/lang/Object
    //   222: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -92 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	SyncTask
    //   0	228	1	paramMMHandler	MMHandler
    //   51	33	2	bool	boolean
    //   140	49	3	l	long
    // Exception table:
    //   from	to	target	type
    //   103	133	206	finally
    //   94	103	212	java/lang/InterruptedException
    //   207	212	212	java/lang/InterruptedException
  }
  
  protected abstract R run();
  
  public void setResultFinish(R arg1)
  {
    Log.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
    this.result = ???;
    synchronized (this.lock)
    {
      Log.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
      this.lock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SyncTask
 * JD-Core Version:    0.7.0.1
 */