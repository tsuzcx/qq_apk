package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class bp<R>
{
  private final long cBo;
  long cBp;
  long cBq;
  boolean cBr = false;
  private Runnable cBs = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(157837);
      ae.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + bp.this.cBr);
      if (bp.this.cBr) {
        bp.this.run();
      }
      for (;;)
      {
        bp.this.cBq = bu.aO(bp.this.cBp);
        AppMethodBeat.o(157837);
        return;
        bp.this.aG(bp.this.run());
      }
    }
  };
  private Object lock = new Object();
  private R result;
  
  public bp()
  {
    this(0L, null, (byte)0);
  }
  
  public bp(long paramLong, R paramR)
  {
    this.cBo = paramLong;
    this.result = paramR;
    this.cBr = true;
  }
  
  public bp(long paramLong, R paramR, byte paramByte)
  {
    this.cBo = paramLong;
    this.result = paramR;
  }
  
  public final void aG(R arg1)
  {
    ae.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
    this.result = ???;
    synchronized (this.lock)
    {
      ae.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
      this.lock.notify();
      return;
    }
  }
  
  /* Error */
  public final R b(aq paramaq)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +15 -> 16
    //   4: ldc 48
    //   6: ldc 68
    //   8: invokestatic 71	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 75	com/tencent/mm/sdk/platformtools/bp:run	()Ljava/lang/Object;
    //   15: areturn
    //   16: ldc 48
    //   18: ldc 77
    //   20: invokestatic 56	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 83	com/tencent/mm/sdk/platformtools/aq:getLooper	()Landroid/os/Looper;
    //   27: ifnull +46 -> 73
    //   30: invokestatic 89	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   33: invokevirtual 93	java/lang/Thread:getId	()J
    //   36: aload_1
    //   37: invokevirtual 83	com/tencent/mm/sdk/platformtools/aq:getLooper	()Landroid/os/Looper;
    //   40: invokevirtual 98	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   43: invokevirtual 93	java/lang/Thread:getId	()J
    //   46: lcmp
    //   47: ifne +21 -> 68
    //   50: iconst_1
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq +34 -> 87
    //   56: ldc 48
    //   58: ldc 100
    //   60: invokestatic 56	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: invokevirtual 75	com/tencent/mm/sdk/platformtools/bp:run	()Ljava/lang/Object;
    //   67: areturn
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -18 -> 52
    //   73: aload_1
    //   74: invokevirtual 104	com/tencent/mm/sdk/platformtools/aq:getSerialTag	()Ljava/lang/String;
    //   77: invokestatic 109	com/tencent/e/j/a:gau	()Ljava/lang/String;
    //   80: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: istore_2
    //   84: goto -32 -> 52
    //   87: aload_0
    //   88: invokestatic 120	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   91: putfield 122	com/tencent/mm/sdk/platformtools/bp:cBp	J
    //   94: aload_0
    //   95: getfield 30	com/tencent/mm/sdk/platformtools/bp:lock	Ljava/lang/Object;
    //   98: astore 5
    //   100: aload 5
    //   102: monitorenter
    //   103: ldc 48
    //   105: ldc 124
    //   107: invokestatic 56	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 37	com/tencent/mm/sdk/platformtools/bp:cBs	Ljava/lang/Runnable;
    //   115: invokevirtual 128	com/tencent/mm/sdk/platformtools/aq:post	(Ljava/lang/Runnable;)Z
    //   118: pop
    //   119: aload_0
    //   120: getfield 30	com/tencent/mm/sdk/platformtools/bp:lock	Ljava/lang/Object;
    //   123: aload_0
    //   124: getfield 39	com/tencent/mm/sdk/platformtools/bp:cBo	J
    //   127: invokevirtual 132	java/lang/Object:wait	(J)V
    //   130: aload 5
    //   132: monitorexit
    //   133: aload_0
    //   134: getfield 122	com/tencent/mm/sdk/platformtools/bp:cBp	J
    //   137: invokestatic 136	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   140: lstore_3
    //   141: ldc 48
    //   143: ldc 138
    //   145: iconst_4
    //   146: anewarray 5	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: new 140	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   158: aload_0
    //   159: getfield 41	com/tencent/mm/sdk/platformtools/bp:result	Ljava/lang/Object;
    //   162: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: lload_3
    //   172: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_0
    //   179: getfield 156	com/tencent/mm/sdk/platformtools/bp:cBq	J
    //   182: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: dup
    //   187: iconst_3
    //   188: lload_3
    //   189: aload_0
    //   190: getfield 156	com/tencent/mm/sdk/platformtools/bp:cBq	J
    //   193: lsub
    //   194: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: aastore
    //   198: invokestatic 159	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload_0
    //   202: getfield 41	com/tencent/mm/sdk/platformtools/bp:result	Ljava/lang/Object;
    //   205: areturn
    //   206: astore_1
    //   207: aload 5
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: ldc 48
    //   215: aload_1
    //   216: ldc 161
    //   218: iconst_0
    //   219: anewarray 5	java/lang/Object
    //   222: invokestatic 165	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -92 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	bp
    //   0	228	1	paramaq	aq
    //   51	33	2	bool	boolean
    //   140	49	3	l	long
    // Exception table:
    //   from	to	target	type
    //   103	133	206	finally
    //   207	210	206	finally
    //   94	103	212	java/lang/InterruptedException
    //   210	212	212	java/lang/InterruptedException
  }
  
  protected abstract R run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bp
 * JD-Core Version:    0.7.0.1
 */