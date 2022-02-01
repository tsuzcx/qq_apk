package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
{
  private static e Cqi;
  public d Chn;
  public AtomicBoolean Cqj;
  public l Cqk;
  public a Cql;
  
  public e()
  {
    AppMethodBeat.i(216579);
    this.Cqj = new AtomicBoolean(false);
    this.Chn = null;
    AppMethodBeat.o(216579);
  }
  
  public static e eAV()
  {
    AppMethodBeat.i(115738);
    if (Cqi == null) {
      Cqi = new e();
    }
    e locale = Cqi;
    AppMethodBeat.o(115738);
    return locale;
  }
  
  public final void eAS()
  {
    try
    {
      AppMethodBeat.i(216581);
      ad.m("MicroMsg.VoipHardDecodeUtil", "detachGLContext, isContextAttached %s", new Object[] { this.Cqj });
      if (this.Cqj.compareAndSet(false, false)) {
        ad.i("MicroMsg.VoipHardDecodeUtil", "current has attach and it need to detach ");
      }
      if ((this.Cqj.compareAndSet(true, false)) && (this.Cqk != null))
      {
        this.Cqk.detachFromGLContext();
        if (this.Chn != null)
        {
          this.Chn.close();
          this.Chn = null;
        }
      }
      AppMethodBeat.o(216581);
      return;
    }
    finally {}
  }
  
  public final l eAW()
  {
    try
    {
      AppMethodBeat.i(115739);
      this.Chn = c.a(false, 14L);
      Object localObject1 = t.CdB;
      t.ewY();
      if (this.Chn.hko <= 0)
      {
        localObject1 = t.CdB;
        t.ewZ();
      }
      this.Cqk = new l(this.Chn.hko);
      this.Chn.close();
      this.Chn = null;
      localObject1 = this.Cqk;
      AppMethodBeat.o(115739);
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean eAX()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 111
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 51
    //   11: ldc 113
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 35	com/tencent/mm/plugin/voip/video/b/e:Cqj	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: aastore
    //   24: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 37	com/tencent/mm/plugin/voip/video/b/e:Chn	Lcom/tencent/mm/media/g/d;
    //   31: ifnonnull +39 -> 70
    //   34: aload_0
    //   35: iconst_0
    //   36: ldc2_w 84
    //   39: invokestatic 90	com/tencent/mm/media/g/c:a	(ZJ)Lcom/tencent/mm/media/g/d;
    //   42: putfield 37	com/tencent/mm/plugin/voip/video/b/e:Chn	Lcom/tencent/mm/media/g/d;
    //   45: aload_0
    //   46: getfield 37	com/tencent/mm/plugin/voip/video/b/e:Chn	Lcom/tencent/mm/media/g/d;
    //   49: putstatic 118	com/tencent/mm/plugin/voip/model/v2protocal:Chn	Lcom/tencent/mm/media/g/d;
    //   52: ldc 51
    //   54: ldc 120
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: getfield 37	com/tencent/mm/plugin/voip/video/b/e:Chn	Lcom/tencent/mm/media/g/d;
    //   66: aastore
    //   67: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 35	com/tencent/mm/plugin/voip/video/b/e:Cqj	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: iconst_0
    //   76: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   79: ifeq +19 -> 98
    //   82: ldc 51
    //   84: ldc 122
    //   86: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 111
    //   91: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 35	com/tencent/mm/plugin/voip/video/b/e:Cqj	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: ifeq +26 -> 133
    //   110: aload_0
    //   111: getfield 70	com/tencent/mm/plugin/voip/video/b/e:Cqk	Lcom/tencent/mm/plugin/voip/video/l;
    //   114: aload_0
    //   115: getfield 37	com/tencent/mm/plugin/voip/video/b/e:Chn	Lcom/tencent/mm/media/g/d;
    //   118: getfield 103	com/tencent/mm/media/g/d:hko	I
    //   121: invokevirtual 125	com/tencent/mm/plugin/voip/video/l:attachToGLContext	(I)V
    //   124: aload_0
    //   125: getfield 127	com/tencent/mm/plugin/voip/video/b/e:Cql	Lcom/tencent/mm/plugin/voip/video/b/e$a;
    //   128: invokeinterface 130 1 0
    //   133: aload_0
    //   134: getfield 35	com/tencent/mm/plugin/voip/video/b/e:Cqj	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   137: invokevirtual 133	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   140: istore_1
    //   141: ldc 111
    //   143: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: goto -52 -> 94
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	e
    //   1	140	1	bool	boolean
    //   149	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	70	149	finally
    //   70	94	149	finally
    //   98	133	149	finally
    //   133	146	149	finally
  }
  
  public static abstract interface a
  {
    public abstract void Dd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.e
 * JD-Core Version:    0.7.0.1
 */