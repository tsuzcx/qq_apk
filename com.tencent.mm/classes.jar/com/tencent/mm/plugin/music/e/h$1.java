package com.tencent.mm.plugin.music.e;

import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.sdk.platformtools.y;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    boolean bool1 = this.myX.bmY().Pv();
    boolean bool2 = this.myX.bmY().Pu();
    y.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2)) {
      this.myX.bmY().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h.1
 * JD-Core Version:    0.7.0.1
 */