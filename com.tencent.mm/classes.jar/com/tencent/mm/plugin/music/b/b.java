package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private static long cyn = 0L;
  private static boolean vcq = false;
  
  public static boolean dhj()
  {
    AppMethodBeat.i(137011);
    long l = System.currentTimeMillis();
    if (l - cyn < 120000L)
    {
      bool = vcq;
      AppMethodBeat.o(137011);
      return bool;
    }
    cyn = l;
    if (e.dip())
    {
      bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dil();
      vcq = bool;
      ac.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(vcq) });
      if (!vcq) {
        if (!e.dip()) {
          break label153;
        }
      }
    }
    for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dim();; bool = false)
    {
      vcq = bool;
      ac.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(vcq) });
      bool = vcq;
      AppMethodBeat.o(137011);
      return bool;
      ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      bool = false;
      break;
      label153:
      ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */