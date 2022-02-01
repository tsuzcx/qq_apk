package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  private static long cJR = 0L;
  private static boolean wxq = false;
  
  public static boolean duI()
  {
    AppMethodBeat.i(137011);
    long l = System.currentTimeMillis();
    if (l - cJR < 120000L)
    {
      bool = wxq;
      AppMethodBeat.o(137011);
      return bool;
    }
    cJR = l;
    if (e.dvQ())
    {
      bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dvM();
      wxq = bool;
      ae.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(wxq) });
      if (!wxq) {
        if (!e.dvQ()) {
          break label153;
        }
      }
    }
    for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dvN();; bool = false)
    {
      wxq = bool;
      ae.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(wxq) });
      bool = wxq;
      AppMethodBeat.o(137011);
      return bool;
      ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      bool = false;
      break;
      label153:
      ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */