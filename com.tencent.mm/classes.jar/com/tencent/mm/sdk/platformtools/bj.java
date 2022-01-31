package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class bj<R>
{
  long fnj;
  private final long ftP;
  private Object lock = new Object();
  private R result;
  private Runnable yol = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(52277);
      ab.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + bj.this.yqw);
      if (bj.this.yqw) {
        bj.this.run();
      }
      for (;;)
      {
        bj.this.yqv = bo.av(bj.this.fnj);
        AppMethodBeat.o(52277);
        return;
        bj.this.cv(bj.this.run());
      }
    }
  };
  long yqv;
  boolean yqw = false;
  
  public bj()
  {
    this(0L, null, (byte)0);
  }
  
  public bj(long paramLong, R paramR)
  {
    this.ftP = paramLong;
    this.result = paramR;
    this.yqw = true;
  }
  
  public bj(long paramLong, R paramR, byte paramByte)
  {
    this.ftP = paramLong;
    this.result = paramR;
  }
  
  /* Error */
  public final R b(ak paramak)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +15 -> 16
    //   4: ldc 50
    //   6: ldc 52
    //   8: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 62	com/tencent/mm/sdk/platformtools/bj:run	()Ljava/lang/Object;
    //   15: areturn
    //   16: ldc 50
    //   18: ldc 64
    //   20: invokestatic 67	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: invokestatic 73	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   26: invokevirtual 77	java/lang/Thread:getId	()J
    //   29: aload_1
    //   30: invokevirtual 83	com/tencent/mm/sdk/platformtools/ak:getLooper	()Landroid/os/Looper;
    //   33: invokevirtual 88	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   36: invokevirtual 77	java/lang/Thread:getId	()J
    //   39: lcmp
    //   40: ifne +15 -> 55
    //   43: ldc 50
    //   45: ldc 90
    //   47: invokestatic 67	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 62	com/tencent/mm/sdk/platformtools/bj:run	()Ljava/lang/Object;
    //   54: areturn
    //   55: aload_0
    //   56: invokestatic 95	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   59: putfield 97	com/tencent/mm/sdk/platformtools/bj:fnj	J
    //   62: aload_0
    //   63: getfield 30	com/tencent/mm/sdk/platformtools/bj:lock	Ljava/lang/Object;
    //   66: astore 4
    //   68: aload 4
    //   70: monitorenter
    //   71: ldc 50
    //   73: ldc 99
    //   75: invokestatic 67	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 37	com/tencent/mm/sdk/platformtools/bj:yol	Ljava/lang/Runnable;
    //   83: invokevirtual 103	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 30	com/tencent/mm/sdk/platformtools/bj:lock	Ljava/lang/Object;
    //   91: aload_0
    //   92: getfield 39	com/tencent/mm/sdk/platformtools/bj:ftP	J
    //   95: invokevirtual 107	java/lang/Object:wait	(J)V
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_0
    //   102: getfield 97	com/tencent/mm/sdk/platformtools/bj:fnj	J
    //   105: invokestatic 111	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   108: lstore_2
    //   109: ldc 50
    //   111: ldc 113
    //   113: iconst_4
    //   114: anewarray 5	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: new 115	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   126: aload_0
    //   127: getfield 41	com/tencent/mm/sdk/platformtools/bj:result	Ljava/lang/Object;
    //   130: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: lload_2
    //   140: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: aload_0
    //   147: getfield 132	com/tencent/mm/sdk/platformtools/bj:yqv	J
    //   150: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   153: aastore
    //   154: dup
    //   155: iconst_3
    //   156: lload_2
    //   157: aload_0
    //   158: getfield 132	com/tencent/mm/sdk/platformtools/bj:yqv	J
    //   161: lsub
    //   162: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: aastore
    //   166: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: getfield 41	com/tencent/mm/sdk/platformtools/bj:result	Ljava/lang/Object;
    //   173: areturn
    //   174: astore_1
    //   175: aload 4
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: ldc 50
    //   183: aload_1
    //   184: ldc 137
    //   186: iconst_0
    //   187: anewarray 5	java/lang/Object
    //   190: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto -92 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	bj
    //   0	196	1	paramak	ak
    //   108	49	2	l	long
    // Exception table:
    //   from	to	target	type
    //   71	101	174	finally
    //   175	178	174	finally
    //   62	71	180	java/lang/InterruptedException
    //   178	180	180	java/lang/InterruptedException
  }
  
  public final void cv(R arg1)
  {
    ab.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
    this.result = ???;
    synchronized (this.lock)
    {
      ab.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
      this.lock.notify();
      return;
    }
  }
  
  protected abstract R run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bj
 * JD-Core Version:    0.7.0.1
 */