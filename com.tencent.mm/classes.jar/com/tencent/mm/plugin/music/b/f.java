package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f
{
  private static f AgQ = null;
  
  private f()
  {
    AppMethodBeat.i(137012);
    h.esH();
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
    //   8: getstatic 10	com/tencent/mm/plugin/music/b/f:AgQ	Lcom/tencent/mm/plugin/music/b/f;
    //   11: ifnull +12 -> 23
    //   14: ldc 31
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 33
    //   25: ldc 35
    //   27: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 2	com/tencent/mm/plugin/music/b/f
    //   33: dup
    //   34: invokespecial 41	com/tencent/mm/plugin/music/b/f:<init>	()V
    //   37: putstatic 10	com/tencent/mm/plugin/music/b/f:AgQ	Lcom/tencent/mm/plugin/music/b/f;
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
        h localh = h.esI();
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
        localh._release();
        localh.bLZ();
        localObject2 = localh.Ahp;
        ((com.tencent.mm.audio.mix.g.c)localObject2).dxb.stopAll();
        localObject2 = ((com.tencent.mm.audio.mix.g.c)localObject2).dxa;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
        ((com.tencent.mm.audio.mix.g.d)localObject2).dxo.Zt();
        ((com.tencent.mm.audio.mix.g.d)localObject2).ZP();
        ((com.tencent.mm.audio.mix.g.d)localObject2).ZL();
        localObject2 = localh.Ahp;
        Object localObject3 = ((com.tencent.mm.audio.mix.g.c)localObject2).dxb;
        ((com.tencent.mm.audio.mix.d.a)localObject3).stopAll();
        ((com.tencent.mm.audio.mix.d.a)localObject3).clearCache();
        ((com.tencent.mm.audio.mix.d.a)localObject3).dva = null;
        localObject3 = ((com.tencent.mm.audio.mix.g.c)localObject2).dxa;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
        ((com.tencent.mm.audio.mix.g.d)localObject3).dxh.set(false);
        ((com.tencent.mm.audio.mix.g.d)localObject3).ZP();
        ((com.tencent.mm.audio.mix.g.d)localObject3).ZL();
        localObject4 = ((com.tencent.mm.audio.mix.g.d)localObject3).dxo;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "onRelease");
        ((com.tencent.mm.audio.mix.f.c)localObject4).ZB();
        ((com.tencent.mm.audio.mix.f.c)localObject4).clearCache();
        ((com.tencent.mm.audio.mix.g.d)localObject3).dxb = null;
        ((com.tencent.mm.audio.mix.g.d)localObject3).clearCache();
        SilkResampleJni.clearResampleAll();
        com.tencent.mm.audio.mix.f.g.ZG();
        ((com.tencent.mm.audio.mix.g.c)localObject2).clearCache();
        localObject2 = com.tencent.mm.audio.mix.b.c.YF();
        i = 0;
        if (i < ((com.tencent.mm.audio.mix.b.c)localObject2).duk.size())
        {
          ((com.tencent.mm.audio.mix.a.c)((com.tencent.mm.audio.mix.b.c)localObject2).duk.get(i)).dtQ = null;
          i += 1;
          continue;
        }
        ((com.tencent.mm.audio.mix.b.c)localObject2).duk.clear();
        localObject2 = com.tencent.mm.audio.mix.b.a.Yw();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioCachePathMgr", "close");
        ((com.tencent.mm.audio.mix.b.a)localObject2).Yy();
        localObject2 = localh.Ahp;
        localObject3 = ((com.tencent.mm.audio.mix.g.c)localObject2).appId;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", new Object[] { localObject3 });
        com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.b((String)localObject3), "AudioPcmDataTrackCleanTask");
        ((com.tencent.mm.audio.mix.g.c)localObject2).dxc.clear();
        localh.Ahp.a(null);
        localh.Ahp.a(null);
        localh.Ahu.dvT = null;
        localObject2 = localh.Ahu;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "stopAll");
        localObject3 = ((com.tencent.mm.audio.mix.e.a)localObject2).dvR.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject4 = (com.tencent.mm.audio.mix.e.c)((com.tencent.mm.audio.mix.e.a)localObject2).dvb.get(localObject4);
          if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.e.c)localObject4).dvh))
          {
            if (((com.tencent.mm.audio.mix.e.c)localObject4).dvY == null)
            {
              i = 1;
              break label480;
            }
          }
          else
          {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "task is not exist");
            ((com.tencent.mm.audio.mix.e.c)localObject4).dvY = null;
            ((com.tencent.mm.audio.mix.e.a)localObject2).dvb.remove(localObject4);
            continue;
          }
          i = 0;
        }
      }
      finally {}
      label480:
      while (i == 0)
      {
        com.tencent.mm.audio.mix.e.g localg = ((com.tencent.mm.audio.mix.e.c)localObject4).dvX;
        if (localg != null) {
          localg.stop();
        }
        ((com.tencent.mm.audio.mix.e.c)localObject4).dvY = null;
        ((com.tencent.mm.audio.mix.e.a)localObject2).dvb.remove(localObject4);
        break;
        localObject1.Ahu.dvb.clear();
        localObject1.cdV();
        AgQ = null;
        AppMethodBeat.o(137014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f
 * JD-Core Version:    0.7.0.1
 */