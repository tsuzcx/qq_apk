package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.l;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
{
  private static e CHM;
  public AtomicBoolean CHN;
  public l CHO;
  public a CHP;
  public d CyO;
  
  public e()
  {
    AppMethodBeat.i(210258);
    this.CHN = new AtomicBoolean(false);
    this.CyO = null;
    AppMethodBeat.o(210258);
  }
  
  public static e eED()
  {
    AppMethodBeat.i(115738);
    if (CHM == null) {
      CHM = new e();
    }
    e locale = CHM;
    AppMethodBeat.o(115738);
    return locale;
  }
  
  public final void eEA()
  {
    try
    {
      AppMethodBeat.i(210260);
      ae.m("MicroMsg.VoipHardDecodeUtil", "detachGLContext, isContextAttached %s", new Object[] { this.CHN });
      if (this.CHN.compareAndSet(false, false)) {
        ae.i("MicroMsg.VoipHardDecodeUtil", "current has attach and it need to detach ");
      }
      if ((this.CHN.compareAndSet(true, false)) && (this.CHO != null))
      {
        this.CHO.detachFromGLContext();
        if (this.CyO != null)
        {
          this.CyO.close();
          this.CyO = null;
        }
      }
      AppMethodBeat.o(210260);
      return;
    }
    finally {}
  }
  
  public final l eEE()
  {
    try
    {
      AppMethodBeat.i(115739);
      this.CyO = c.a(false, 14L);
      Object localObject1 = t.Cvc;
      t.eAF();
      if (this.CyO.hnc <= 0)
      {
        localObject1 = t.Cvc;
        t.eAG();
      }
      this.CHO = new l(this.CyO.hnc);
      this.CyO.close();
      this.CyO = null;
      localObject1 = this.CHO;
      AppMethodBeat.o(115739);
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean eEF()
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
    //   20: getfield 35	com/tencent/mm/plugin/voip/video/b/e:CHN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: aastore
    //   24: invokestatic 115	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 37	com/tencent/mm/plugin/voip/video/b/e:CyO	Lcom/tencent/mm/media/g/d;
    //   31: ifnonnull +39 -> 70
    //   34: aload_0
    //   35: iconst_0
    //   36: ldc2_w 84
    //   39: invokestatic 90	com/tencent/mm/media/g/c:a	(ZJ)Lcom/tencent/mm/media/g/d;
    //   42: putfield 37	com/tencent/mm/plugin/voip/video/b/e:CyO	Lcom/tencent/mm/media/g/d;
    //   45: aload_0
    //   46: getfield 37	com/tencent/mm/plugin/voip/video/b/e:CyO	Lcom/tencent/mm/media/g/d;
    //   49: putstatic 118	com/tencent/mm/plugin/voip/model/v2protocal:CyO	Lcom/tencent/mm/media/g/d;
    //   52: ldc 51
    //   54: ldc 120
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: getfield 37	com/tencent/mm/plugin/voip/video/b/e:CyO	Lcom/tencent/mm/media/g/d;
    //   66: aastore
    //   67: invokestatic 115	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 35	com/tencent/mm/plugin/voip/video/b/e:CHN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: iconst_0
    //   76: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   79: ifeq +19 -> 98
    //   82: ldc 51
    //   84: ldc 122
    //   86: invokestatic 68	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 111
    //   91: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 35	com/tencent/mm/plugin/voip/video/b/e:CHN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: ifeq +26 -> 133
    //   110: aload_0
    //   111: getfield 70	com/tencent/mm/plugin/voip/video/b/e:CHO	Lcom/tencent/mm/plugin/voip/video/l;
    //   114: aload_0
    //   115: getfield 37	com/tencent/mm/plugin/voip/video/b/e:CyO	Lcom/tencent/mm/media/g/d;
    //   118: getfield 103	com/tencent/mm/media/g/d:hnc	I
    //   121: invokevirtual 125	com/tencent/mm/plugin/voip/video/l:attachToGLContext	(I)V
    //   124: aload_0
    //   125: getfield 127	com/tencent/mm/plugin/voip/video/b/e:CHP	Lcom/tencent/mm/plugin/voip/video/b/e$a;
    //   128: invokeinterface 130 1 0
    //   133: aload_0
    //   134: getfield 35	com/tencent/mm/plugin/voip/video/b/e:CHN	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    public abstract void Dg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.e
 * JD-Core Version:    0.7.0.1
 */