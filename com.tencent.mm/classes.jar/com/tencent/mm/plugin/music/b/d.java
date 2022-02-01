package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.e.g;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  private static d vcr = null;
  
  private d()
  {
    AppMethodBeat.i(137012);
    f.dhl();
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
    //   8: getstatic 10	com/tencent/mm/plugin/music/b/d:vcr	Lcom/tencent/mm/plugin/music/b/d;
    //   11: ifnull +12 -> 23
    //   14: ldc 31
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 33
    //   25: ldc 35
    //   27: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 2	com/tencent/mm/plugin/music/b/d
    //   33: dup
    //   34: invokespecial 41	com/tencent/mm/plugin/music/b/d:<init>	()V
    //   37: putstatic 10	com/tencent/mm/plugin/music/b/d:vcr	Lcom/tencent/mm/plugin/music/b/d;
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
      ac.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
      f localf = f.dhm();
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
      localf._release();
      localf.bjF();
      Object localObject2 = localf.vcN;
      ((com.tencent.mm.audio.mix.f.c)localObject2).cTz.MT();
      localObject2 = ((com.tencent.mm.audio.mix.f.c)localObject2).cTy;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
      ((com.tencent.mm.audio.mix.f.d)localObject2).cTM.Ns();
      ((com.tencent.mm.audio.mix.f.d)localObject2).NO();
      ((com.tencent.mm.audio.mix.f.d)localObject2).NK();
      localObject2 = localf.vcN;
      Object localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).cTz;
      ((a)localObject3).MT();
      ((a)localObject3).clearCache();
      ((a)localObject3).cRM = null;
      localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).cTy;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
      ((com.tencent.mm.audio.mix.f.d)localObject3).cTF.set(false);
      ((com.tencent.mm.audio.mix.f.d)localObject3).NO();
      ((com.tencent.mm.audio.mix.f.d)localObject3).NK();
      com.tencent.mm.audio.mix.e.c localc = ((com.tencent.mm.audio.mix.f.d)localObject3).cTM;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onRelease");
      localc.NA();
      localc.clearCache();
      ((com.tencent.mm.audio.mix.f.d)localObject3).cTz = null;
      ((com.tencent.mm.audio.mix.f.d)localObject3).clearCache();
      SilkResampleJni.clearResampleAll();
      g.NF();
      ((com.tencent.mm.audio.mix.f.c)localObject2).clearCache();
      localObject2 = com.tencent.mm.audio.mix.b.b.MF();
      int i = 0;
      while (i < ((com.tencent.mm.audio.mix.b.b)localObject2).cQW.size())
      {
        ((com.tencent.mm.audio.mix.a.c)((com.tencent.mm.audio.mix.b.b)localObject2).cQW.get(i)).cQH = null;
        i += 1;
      }
      ((com.tencent.mm.audio.mix.b.b)localObject2).cQW.clear();
      localObject2 = localf.vcN;
      localObject3 = ((com.tencent.mm.audio.mix.f.c)localObject2).appId;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", new Object[] { localObject3 });
      com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.b((String)localObject3), "AudioPcmDataTrackCleanTask");
      ((com.tencent.mm.audio.mix.f.c)localObject2).cTA.clear();
      localf.vcN.a(null);
      localf.vcN.a(null);
      vcr = null;
      AppMethodBeat.o(137014);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.d
 * JD-Core Version:    0.7.0.1
 */