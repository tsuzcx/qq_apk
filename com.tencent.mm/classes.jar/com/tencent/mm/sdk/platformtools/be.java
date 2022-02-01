package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class be
{
  public LinkedBlockingQueue<be.a> Ifr;
  private int Ifs;
  Vector<b> Ift;
  ap Ifu;
  boolean dCv;
  Object lock;
  String name;
  int priority;
  
  public be(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
  }
  
  public be(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, paramInt2, Looper.myLooper());
    AppMethodBeat.i(157795);
    AppMethodBeat.o(157795);
  }
  
  public be(int paramInt1, String paramString, int paramInt2, Looper paramLooper)
  {
    AppMethodBeat.i(157796);
    this.Ifr = new LinkedBlockingQueue();
    this.dCv = false;
    this.Ifs = 1;
    this.priority = 1;
    this.name = "";
    this.lock = new byte[0];
    this.Ift = new Vector();
    this.Ifs = paramInt2;
    this.name = paramString;
    this.priority = paramInt1;
    paramString = paramLooper;
    if (paramLooper == null)
    {
      paramString = paramLooper;
      if (Looper.getMainLooper() != null)
      {
        paramString = Looper.getMainLooper();
        ad.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
      }
    }
    this.Ifu = new be.1(this, paramString);
    AppMethodBeat.o(157796);
  }
  
  public final int c(be.a parama)
  {
    AppMethodBeat.i(157797);
    if (parama == null)
    {
      ad.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      AppMethodBeat.o(157797);
      return -1;
    }
    try
    {
      if (!this.Ifr.offer(parama, 1L, TimeUnit.MILLISECONDS))
      {
        ad.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
        AppMethodBeat.o(157797);
        return -2;
      }
    }
    catch (Exception parama)
    {
      ad.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + parama.getMessage());
      ad.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", parama, "", new Object[0]);
      AppMethodBeat.o(157797);
      return -3;
    }
    if ((this.Ift.size() == 0) || ((this.Ifr.size() > 0) && (this.Ifs > this.Ift.size()))) {
      new b((byte)0).start();
    }
    AppMethodBeat.o(157797);
    return 0;
  }
  
  @Deprecated
  public final boolean flo()
  {
    AppMethodBeat.i(157798);
    if ((this.Ift == null) || (this.Ift.size() == 0))
    {
      AppMethodBeat.o(157798);
      return true;
    }
    AppMethodBeat.o(157798);
    return false;
  }
  
  public final void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(157799);
    synchronized (this.lock)
    {
      this.dCv = paramBoolean;
      if (!paramBoolean) {}
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        AppMethodBeat.o(157799);
        return;
      }
    }
  }
  
  final class b
    extends Thread
  {
    private int DYT;
    
    private b()
    {
      super();
      AppMethodBeat.i(157793);
      this.DYT = 60;
      setPriority(be.this.priority);
      be.this.Ift.add(this);
      AppMethodBeat.o(157793);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 59
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 31	com/tencent/mm/sdk/platformtools/be$b:DYT	I
      //   9: ifle +157 -> 166
      //   12: aload_0
      //   13: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   16: getfield 63	com/tencent/mm/sdk/platformtools/be:lock	Ljava/lang/Object;
      //   19: astore_1
      //   20: aload_1
      //   21: monitorenter
      //   22: aload_0
      //   23: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   26: getfield 67	com/tencent/mm/sdk/platformtools/be:dCv	Z
      //   29: ifeq +13 -> 42
      //   32: aload_0
      //   33: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   36: getfield 63	com/tencent/mm/sdk/platformtools/be:lock	Ljava/lang/Object;
      //   39: invokevirtual 72	java/lang/Object:wait	()V
      //   42: aload_1
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   48: getfield 76	com/tencent/mm/sdk/platformtools/be:Ifr	Ljava/util/concurrent/LinkedBlockingQueue;
      //   51: ldc2_w 77
      //   54: getstatic 84	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   57: invokevirtual 90	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
      //   60: checkcast 92	com/tencent/mm/sdk/platformtools/be$a
      //   63: astore_1
      //   64: aload_1
      //   65: ifnonnull +60 -> 125
      //   68: aload_0
      //   69: aload_0
      //   70: getfield 31	com/tencent/mm/sdk/platformtools/be$b:DYT	I
      //   73: iconst_1
      //   74: isub
      //   75: putfield 31	com/tencent/mm/sdk/platformtools/be$b:DYT	I
      //   78: goto -73 -> 5
      //   81: astore_2
      //   82: ldc 94
      //   84: aload_2
      //   85: ldc 96
      //   87: iconst_0
      //   88: anewarray 69	java/lang/Object
      //   91: invokestatic 102	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   94: goto -52 -> 42
      //   97: astore_2
      //   98: aload_1
      //   99: monitorexit
      //   100: ldc 59
      //   102: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   105: aload_2
      //   106: athrow
      //   107: astore_1
      //   108: ldc 94
      //   110: aload_1
      //   111: ldc 96
      //   113: iconst_0
      //   114: anewarray 69	java/lang/Object
      //   117: invokestatic 102	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aconst_null
      //   121: astore_1
      //   122: goto -58 -> 64
      //   125: aload_0
      //   126: bipush 60
      //   128: putfield 31	com/tencent/mm/sdk/platformtools/be$b:DYT	I
      //   131: aload_1
      //   132: invokeinterface 106 1 0
      //   137: ifeq -132 -> 5
      //   140: aload_0
      //   141: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   144: getfield 110	com/tencent/mm/sdk/platformtools/be:Ifu	Lcom/tencent/mm/sdk/platformtools/ap;
      //   147: aload_0
      //   148: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   151: getfield 110	com/tencent/mm/sdk/platformtools/be:Ifu	Lcom/tencent/mm/sdk/platformtools/ap;
      //   154: iconst_0
      //   155: aload_1
      //   156: invokevirtual 116	com/tencent/mm/sdk/platformtools/ap:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   159: invokevirtual 120	com/tencent/mm/sdk/platformtools/ap:sendMessage	(Landroid/os/Message;)Z
      //   162: pop
      //   163: goto -158 -> 5
      //   166: aload_0
      //   167: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   170: getfield 41	com/tencent/mm/sdk/platformtools/be:Ift	Ljava/util/Vector;
      //   173: aload_0
      //   174: invokevirtual 123	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   177: pop
      //   178: ldc 94
      //   180: new 125	java/lang/StringBuilder
      //   183: dup
      //   184: ldc 127
      //   186: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   189: aload_0
      //   190: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   193: getfield 76	com/tencent/mm/sdk/platformtools/be:Ifr	Ljava/util/concurrent/LinkedBlockingQueue;
      //   196: invokevirtual 132	java/util/concurrent/LinkedBlockingQueue:size	()I
      //   199: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   202: ldc 138
      //   204: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: aload_0
      //   208: getfield 15	com/tencent/mm/sdk/platformtools/be$b:Ifv	Lcom/tencent/mm/sdk/platformtools/be;
      //   211: getfield 41	com/tencent/mm/sdk/platformtools/be:Ift	Ljava/util/Vector;
      //   214: invokevirtual 142	java/util/Vector:size	()I
      //   217: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   220: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   223: invokestatic 150	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   226: ldc 59
      //   228: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   231: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	b
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
      //   98	100	97	finally
      //   44	64	107	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.be
 * JD-Core Version:    0.7.0.1
 */