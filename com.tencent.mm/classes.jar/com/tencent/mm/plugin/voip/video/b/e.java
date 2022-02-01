package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
{
  private static e UQK;
  public d UFV;
  public AtomicBoolean UQL;
  public g UQM;
  public a UQN;
  
  public e()
  {
    AppMethodBeat.i(292875);
    this.UQL = new AtomicBoolean(false);
    this.UFV = null;
    AppMethodBeat.o(292875);
  }
  
  public static e idb()
  {
    AppMethodBeat.i(115738);
    if (UQK == null) {
      UQK = new e();
    }
    e locale = UQK;
    AppMethodBeat.o(115738);
    return locale;
  }
  
  public final void icZ()
  {
    try
    {
      AppMethodBeat.i(292894);
      Log.printInfoStack("MicroMsg.VoipHardDecodeUtil", "detachGLContext, isContextAttached %s", new Object[] { this.UQL });
      if (this.UQL.compareAndSet(false, false)) {
        Log.i("MicroMsg.VoipHardDecodeUtil", "current has attach and it need to detach ");
      }
      if ((this.UQL.compareAndSet(true, false)) && (this.UQM != null))
      {
        this.UQM.detachFromGLContext();
        if (this.UFV != null)
        {
          this.UFV.close();
          this.UFV = null;
        }
      }
      AppMethodBeat.o(292894);
      return;
    }
    finally {}
  }
  
  public final g idc()
  {
    try
    {
      AppMethodBeat.i(115739);
      this.UFV = c.d(false, 14L);
      Object localObject1 = t.UBA;
      t.hXR();
      if (this.UFV.nAF <= 0)
      {
        localObject1 = t.UBA;
        t.hXS();
      }
      this.UQM = new g(this.UFV.nAF);
      this.UFV.close();
      this.UFV = null;
      localObject1 = this.UQM;
      AppMethodBeat.o(115739);
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean idd()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 112
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 51
    //   11: ldc 114
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 35	com/tencent/mm/plugin/voip/video/b/e:UQL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: aastore
    //   24: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 37	com/tencent/mm/plugin/voip/video/b/e:UFV	Lcom/tencent/mm/media/g/d;
    //   31: ifnonnull +39 -> 70
    //   34: aload_0
    //   35: iconst_0
    //   36: ldc2_w 84
    //   39: invokestatic 91	com/tencent/mm/media/g/c:d	(ZJ)Lcom/tencent/mm/media/g/d;
    //   42: putfield 37	com/tencent/mm/plugin/voip/video/b/e:UFV	Lcom/tencent/mm/media/g/d;
    //   45: aload_0
    //   46: getfield 37	com/tencent/mm/plugin/voip/video/b/e:UFV	Lcom/tencent/mm/media/g/d;
    //   49: putstatic 119	com/tencent/mm/plugin/voip/model/v2protocal:UFV	Lcom/tencent/mm/media/g/d;
    //   52: ldc 51
    //   54: ldc 121
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: getfield 37	com/tencent/mm/plugin/voip/video/b/e:UFV	Lcom/tencent/mm/media/g/d;
    //   66: aastore
    //   67: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 35	com/tencent/mm/plugin/voip/video/b/e:UQL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: iconst_0
    //   76: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   79: ifeq +19 -> 98
    //   82: ldc 51
    //   84: ldc 123
    //   86: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 112
    //   91: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: aload_0
    //   99: getfield 35	com/tencent/mm/plugin/voip/video/b/e:UQL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: ifeq +26 -> 133
    //   110: aload_0
    //   111: getfield 70	com/tencent/mm/plugin/voip/video/b/e:UQM	Lcom/tencent/mm/plugin/voip/video/g;
    //   114: aload_0
    //   115: getfield 37	com/tencent/mm/plugin/voip/video/b/e:UFV	Lcom/tencent/mm/media/g/d;
    //   118: getfield 104	com/tencent/mm/media/g/d:nAF	I
    //   121: invokevirtual 126	com/tencent/mm/plugin/voip/video/g:attachToGLContext	(I)V
    //   124: aload_0
    //   125: getfield 128	com/tencent/mm/plugin/voip/video/b/e:UQN	Lcom/tencent/mm/plugin/voip/video/b/e$a;
    //   128: invokeinterface 131 1 0
    //   133: aload_0
    //   134: getfield 35	com/tencent/mm/plugin/voip/video/b/e:UQL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   137: invokevirtual 134	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   140: istore_1
    //   141: ldc 112
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
    public abstract void apC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.e
 * JD-Core Version:    0.7.0.1
 */