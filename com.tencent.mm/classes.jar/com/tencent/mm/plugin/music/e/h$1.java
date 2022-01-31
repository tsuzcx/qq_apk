package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(137531);
    boolean bool1 = this.oZd.bVu().aiy();
    boolean bool2 = this.oZd.bVu().aiw();
    ab.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2)) {
      this.oZd.bVu().stopPlay();
    }
    AppMethodBeat.o(137531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h.1
 * JD-Core Version:    0.7.0.1
 */