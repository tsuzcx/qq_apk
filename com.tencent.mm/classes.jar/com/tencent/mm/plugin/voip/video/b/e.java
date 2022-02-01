package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
{
  private static e zxX;
  public d zpx;
  public AtomicBoolean zxY;
  public l zxZ;
  public a zya;
  
  public e()
  {
    AppMethodBeat.i(192193);
    this.zxY = new AtomicBoolean(false);
    this.zpx = null;
    AppMethodBeat.o(192193);
  }
  
  public static e dXC()
  {
    AppMethodBeat.i(115738);
    if (zxX == null) {
      zxX = new e();
    }
    e locale = zxX;
    AppMethodBeat.o(115738);
    return locale;
  }
  
  public final l dXD()
  {
    try
    {
      AppMethodBeat.i(115739);
      this.zpx = c.a(false, 14L);
      Object localObject1 = t.zlN;
      t.dUb();
      if (this.zpx.gro <= 0)
      {
        localObject1 = t.zlN;
        t.dUc();
      }
      this.zxZ = new l(this.zpx.gro);
      this.zpx.close();
      this.zpx = null;
      localObject1 = this.zxZ;
      AppMethodBeat.o(115739);
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean dXE()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 87
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 89
    //   11: ldc 91
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 35	com/tencent/mm/plugin/voip/video/b/e:zxY	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: aastore
    //   24: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 37	com/tencent/mm/plugin/voip/video/b/e:zpx	Lcom/tencent/mm/media/f/d;
    //   31: ifnonnull +39 -> 70
    //   34: aload_0
    //   35: iconst_0
    //   36: ldc2_w 51
    //   39: invokestatic 57	com/tencent/mm/media/f/c:a	(ZJ)Lcom/tencent/mm/media/f/d;
    //   42: putfield 37	com/tencent/mm/plugin/voip/video/b/e:zpx	Lcom/tencent/mm/media/f/d;
    //   45: aload_0
    //   46: getfield 37	com/tencent/mm/plugin/voip/video/b/e:zpx	Lcom/tencent/mm/media/f/d;
    //   49: putstatic 99	com/tencent/mm/plugin/voip/model/v2protocal:zpx	Lcom/tencent/mm/media/f/d;
    //   52: ldc 89
    //   54: ldc 101
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: getfield 37	com/tencent/mm/plugin/voip/video/b/e:zpx	Lcom/tencent/mm/media/f/d;
    //   66: aastore
    //   67: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 35	com/tencent/mm/plugin/voip/video/b/e:zxY	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: iconst_0
    //   76: invokevirtual 105	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   79: ifeq +19 -> 98
    //   82: ldc 89
    //   84: ldc 107
    //   86: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 87
    //   91: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 35	com/tencent/mm/plugin/voip/video/b/e:zxY	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 105	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: ifeq +26 -> 133
    //   110: aload_0
    //   111: getfield 81	com/tencent/mm/plugin/voip/video/b/e:zxZ	Lcom/tencent/mm/plugin/voip/video/l;
    //   114: aload_0
    //   115: getfield 37	com/tencent/mm/plugin/voip/video/b/e:zpx	Lcom/tencent/mm/media/f/d;
    //   118: getfield 72	com/tencent/mm/media/f/d:gro	I
    //   121: invokevirtual 113	com/tencent/mm/plugin/voip/video/l:attachToGLContext	(I)V
    //   124: aload_0
    //   125: getfield 115	com/tencent/mm/plugin/voip/video/b/e:zya	Lcom/tencent/mm/plugin/voip/video/b/e$a;
    //   128: invokeinterface 118 1 0
    //   133: aload_0
    //   134: getfield 35	com/tencent/mm/plugin/voip/video/b/e:zxY	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   137: invokevirtual 121	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   140: istore_1
    //   141: ldc 87
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
  
  public final void dXz()
  {
    try
    {
      AppMethodBeat.i(192195);
      ad.m("MicroMsg.VoipHardDecodeUtil", "detachGLContext, isContextAttached %s", new Object[] { this.zxY });
      if (this.zxY.compareAndSet(false, false)) {
        ad.i("MicroMsg.VoipHardDecodeUtil", "current has attach and it need to detach ");
      }
      if ((this.zxY.compareAndSet(true, false)) && (this.zxZ != null))
      {
        this.zxZ.detachFromGLContext();
        if (this.zpx != null)
        {
          this.zpx.close();
          this.zpx = null;
        }
      }
      AppMethodBeat.o(192195);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void Ca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.e
 * JD-Core Version:    0.7.0.1
 */