package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  private static long bQx = 0L;
  private static boolean oWC = false;
  
  public static boolean bTW()
  {
    AppMethodBeat.i(137261);
    long l = System.currentTimeMillis();
    if (l - bQx < 120000L)
    {
      bool = oWC;
      AppMethodBeat.o(137261);
      return bool;
    }
    bQx = l;
    if (e.bVi())
    {
      bool = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).bVe();
      oWC = bool;
      ab.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(oWC) });
      if (!oWC) {
        if (!e.bVi()) {
          break label153;
        }
      }
    }
    for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).bVf();; bool = false)
    {
      oWC = bool;
      ab.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(oWC) });
      bool = oWC;
      AppMethodBeat.o(137261);
      return bool;
      ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      bool = false;
      break;
      label153:
      ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */