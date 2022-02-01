package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
{
  private static g FNK = null;
  
  private g()
  {
    AppMethodBeat.i(137012);
    i.fcR();
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
    //   8: getstatic 10	com/tencent/mm/plugin/music/b/g:FNK	Lcom/tencent/mm/plugin/music/b/g;
    //   11: ifnull +12 -> 23
    //   14: ldc 31
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 33
    //   25: ldc 35
    //   27: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 2	com/tencent/mm/plugin/music/b/g
    //   33: dup
    //   34: invokespecial 41	com/tencent/mm/plugin/music/b/g:<init>	()V
    //   37: putstatic 10	com/tencent/mm/plugin/music/b/g:FNK	Lcom/tencent/mm/plugin/music/b/g;
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
    for (;;)
    {
      Object localObject2;
      Object localObject4;
      int i;
      try
      {
        AppMethodBeat.i(137014);
        Log.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
        i locali = i.fcS();
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
        locali._release();
        locali.bYq();
        localObject2 = locali.FOj;
        ((com.tencent.mm.audio.mix.f.c)localObject2).fpN.stopAll();
        localObject2 = ((com.tencent.mm.audio.mix.f.c)localObject2).fpM;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
        ((com.tencent.mm.audio.mix.f.d)localObject2).fqa.aec();
        ((com.tencent.mm.audio.mix.f.d)localObject2).aey();
        ((com.tencent.mm.audio.mix.f.d)localObject2).aeu();
        localObject2 = locali.FOj;
        Object localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).fpN;
        ((com.tencent.mm.audio.mix.decode.a)localObject3).stopAll();
        ((com.tencent.mm.audio.mix.decode.a)localObject3).clearCache();
        ((com.tencent.mm.audio.mix.decode.a)localObject3).fnI = null;
        localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).fpM;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
        ((com.tencent.mm.audio.mix.f.d)localObject3).fpT.set(false);
        ((com.tencent.mm.audio.mix.f.d)localObject3).aey();
        ((com.tencent.mm.audio.mix.f.d)localObject3).aeu();
        localObject4 = ((com.tencent.mm.audio.mix.f.d)localObject3).fqa;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onRelease");
        ((com.tencent.mm.audio.mix.e.c)localObject4).aek();
        ((com.tencent.mm.audio.mix.e.c)localObject4).clearCache();
        ((com.tencent.mm.audio.mix.f.d)localObject3).fpN = null;
        ((com.tencent.mm.audio.mix.f.d)localObject3).clearCache();
        SilkResampleJni.clearResampleAll();
        com.tencent.mm.audio.mix.e.g.aep();
        ((com.tencent.mm.audio.mix.f.c)localObject2).clearCache();
        localObject2 = com.tencent.mm.audio.mix.b.c.adm();
        i = 0;
        if (i < ((com.tencent.mm.audio.mix.b.c)localObject2).fmS.size())
        {
          ((com.tencent.mm.audio.mix.a.c)((com.tencent.mm.audio.mix.b.c)localObject2).fmS.get(i)).fmy = null;
          i += 1;
          continue;
        }
        ((com.tencent.mm.audio.mix.b.c)localObject2).fmS.clear();
        localObject2 = com.tencent.mm.audio.mix.b.a.adc();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioCachePathMgr", "close");
        ((com.tencent.mm.audio.mix.b.a)localObject2).adf();
        localObject2 = locali.FOj;
        localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).appId;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", new Object[] { localObject3 });
        com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.b((String)localObject3), "AudioPcmDataTrackCleanTask");
        ((com.tencent.mm.audio.mix.f.c)localObject2).fpO.clear();
        locali.FOj.a(null);
        locali.FOj.a(null);
        locali.FOo.foC = null;
        localObject2 = locali.FOo;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Audio.AudioDownloadMgr", "stopAll");
        localObject3 = ((com.tencent.mm.audio.mix.d.a)localObject2).foA.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject4 = (com.tencent.mm.audio.mix.d.c)((com.tencent.mm.audio.mix.d.a)localObject2).fnJ.get(localObject4);
          if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.c)localObject4).fnP))
          {
            if (((com.tencent.mm.audio.mix.d.c)localObject4).foH == null)
            {
              i = 1;
              break label480;
            }
          }
          else
          {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Audio.AudioDownloadMgr", "task is not exist");
            ((com.tencent.mm.audio.mix.d.c)localObject4).foH = null;
            ((com.tencent.mm.audio.mix.d.a)localObject2).fnJ.remove(localObject4);
            continue;
          }
          i = 0;
        }
      }
      finally {}
      label480:
      while (i == 0)
      {
        com.tencent.mm.audio.mix.d.g localg = ((com.tencent.mm.audio.mix.d.c)localObject4).foG;
        if (localg != null) {
          localg.stop();
        }
        ((com.tencent.mm.audio.mix.d.c)localObject4).foH = null;
        ((com.tencent.mm.audio.mix.d.a)localObject2).fnJ.remove(localObject4);
        break;
        localObject1.FOo.fnJ.clear();
        localObject1.crg();
        FNK = null;
        AppMethodBeat.o(137014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */