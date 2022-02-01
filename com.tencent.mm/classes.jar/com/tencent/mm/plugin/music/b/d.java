package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  private static boolean AgP = false;
  private static long dap = 0L;
  
  public static boolean esF()
  {
    AppMethodBeat.i(137011);
    long l = System.currentTimeMillis();
    if (l - dap < 120000L)
    {
      bool = AgP;
      AppMethodBeat.o(137011);
      return bool;
    }
    dap = l;
    if (e.etK())
    {
      bool = ((c)b.aS(c.class)).etG();
      AgP = bool;
      Log.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(AgP) });
      if (!AgP) {
        if (!e.etK()) {
          break label153;
        }
      }
    }
    for (boolean bool = ((c)b.aS(c.class)).etH();; bool = false)
    {
      AgP = bool;
      Log.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(AgP) });
      bool = AgP;
      AppMethodBeat.o(137011);
      return bool;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      bool = false;
      break;
      label153:
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.d
 * JD-Core Version:    0.7.0.1
 */