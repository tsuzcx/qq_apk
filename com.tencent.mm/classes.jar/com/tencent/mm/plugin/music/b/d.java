package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.e.g;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  private static d wxr = null;
  
  private d()
  {
    AppMethodBeat.i(137012);
    f.duK();
    AppMethodBeat.o(137012);
  }
  
  /* Error */
  public static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 31
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 10	com/tencent/mm/plugin/music/b/d:wxr	Lcom/tencent/mm/plugin/music/b/d;
    //   11: ifnull +12 -> 23
    //   14: ldc 31
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 33
    //   25: ldc 35
    //   27: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 2	com/tencent/mm/plugin/music/b/d
    //   33: dup
    //   34: invokespecial 41	com/tencent/mm/plugin/music/b/d:<init>	()V
    //   37: putstatic 10	com/tencent/mm/plugin/music/b/d:wxr	Lcom/tencent/mm/plugin/music/b/d;
    //   40: ldc 31
    //   42: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -26 -> 19
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	48	finally
    //   23	45	48	finally
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(137014);
      ae.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
      f localf = f.duL();
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
      localf._release();
      localf.bqr();
      Object localObject2 = localf.wxN;
      ((com.tencent.mm.audio.mix.f.c)localObject2).dfR.OA();
      localObject2 = ((com.tencent.mm.audio.mix.f.c)localObject2).dfQ;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
      ((com.tencent.mm.audio.mix.f.d)localObject2).dge.OZ();
      ((com.tencent.mm.audio.mix.f.d)localObject2).Pv();
      ((com.tencent.mm.audio.mix.f.d)localObject2).Pr();
      localObject2 = localf.wxN;
      Object localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).dfR;
      ((a)localObject3).OA();
      ((a)localObject3).clearCache();
      ((a)localObject3).dee = null;
      localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).dfQ;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
      ((com.tencent.mm.audio.mix.f.d)localObject3).dfX.set(false);
      ((com.tencent.mm.audio.mix.f.d)localObject3).Pv();
      ((com.tencent.mm.audio.mix.f.d)localObject3).Pr();
      com.tencent.mm.audio.mix.e.c localc = ((com.tencent.mm.audio.mix.f.d)localObject3).dge;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onRelease");
      localc.Ph();
      localc.clearCache();
      ((com.tencent.mm.audio.mix.f.d)localObject3).dfR = null;
      ((com.tencent.mm.audio.mix.f.d)localObject3).clearCache();
      SilkResampleJni.clearResampleAll();
      g.Pm();
      ((com.tencent.mm.audio.mix.f.c)localObject2).clearCache();
      localObject2 = com.tencent.mm.audio.mix.b.b.Om();
      int i = 0;
      while (i < ((com.tencent.mm.audio.mix.b.b)localObject2).ddo.size())
      {
        ((com.tencent.mm.audio.mix.a.c)((com.tencent.mm.audio.mix.b.b)localObject2).ddo.get(i)).dcZ = null;
        i += 1;
      }
      ((com.tencent.mm.audio.mix.b.b)localObject2).ddo.clear();
      localObject2 = localf.wxN;
      localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).appId;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", new Object[] { localObject3 });
      com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.b((String)localObject3), "AudioPcmDataTrackCleanTask");
      ((com.tencent.mm.audio.mix.f.c)localObject2).dfS.clear();
      localf.wxN.a(null);
      localf.wxN.a(null);
      localf.bHs();
      wxr = null;
      AppMethodBeat.o(137014);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.d
 * JD-Core Version:    0.7.0.1
 */