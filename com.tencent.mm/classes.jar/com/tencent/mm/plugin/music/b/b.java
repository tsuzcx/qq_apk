package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static long cJi = 0L;
  private static boolean whM = false;
  
  public static boolean drw()
  {
    AppMethodBeat.i(137011);
    long l = System.currentTimeMillis();
    if (l - cJi < 120000L)
    {
      bool = whM;
      AppMethodBeat.o(137011);
      return bool;
    }
    cJi = l;
    if (e.dsB())
    {
      bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dsx();
      whM = bool;
      ad.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(whM) });
      if (!whM) {
        if (!e.dsB()) {
          break label153;
        }
      }
    }
    for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dsy();; bool = false)
    {
      whM = bool;
      ad.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(whM) });
      bool = whM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */