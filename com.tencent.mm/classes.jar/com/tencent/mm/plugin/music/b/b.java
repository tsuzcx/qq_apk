package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static long cBe = 0L;
  private static boolean tTI = false;
  
  public static boolean cTz()
  {
    AppMethodBeat.i(137011);
    long l = System.currentTimeMillis();
    if (l - cBe < 120000L)
    {
      bool = tTI;
      AppMethodBeat.o(137011);
      return bool;
    }
    cBe = l;
    if (e.cUJ())
    {
      bool = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).cUF();
      tTI = bool;
      ad.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(tTI) });
      if (!tTI) {
        if (!e.cUJ()) {
          break label153;
        }
      }
    }
    for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).cUG();; bool = false)
    {
      tTI = bool;
      ad.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(tTI) });
      bool = tTI;
      AppMethodBeat.o(137011);
      return bool;
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      bool = false;
      break;
      label153:
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */