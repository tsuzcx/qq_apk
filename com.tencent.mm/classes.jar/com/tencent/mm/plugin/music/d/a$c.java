package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$c
  implements a.b
{
  public a$c(a parama) {}
  
  public final void Ae(int paramInt)
  {
    AppMethodBeat.i(137488);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(137488);
  }
  
  public final void bVm()
  {
    AppMethodBeat.i(137482);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
    if (this.oYW.oYI != null) {
      this.oYW.z(this.oYW.oYI);
    }
    if (this.oYW.startTime > 0)
    {
      ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(this.oYW.startTime) });
      this.oYW.lN(this.oYW.startTime);
    }
    if ((this.oYW.startTime == 0) && (!this.oYW.oYL.mK()))
    {
      ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
      this.oYW.oYL.aC(true);
    }
    AppMethodBeat.o(137482);
  }
  
  public final void bVn()
  {
    AppMethodBeat.i(137483);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
    if (this.oYW.oYI != null) {
      this.oYW.A(this.oYW.oYI);
    }
    AppMethodBeat.o(137483);
  }
  
  public final void bVo()
  {
    AppMethodBeat.i(137484);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
    if ((this.oYW.oYI != null) && (!this.oYW.oYL.mK())) {
      this.oYW.C(this.oYW.oYI);
    }
    AppMethodBeat.o(137484);
  }
  
  public final void bVp()
  {
    AppMethodBeat.i(137485);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
    if (this.oYW.oYI != null) {
      this.oYW.D(this.oYW.oYI);
    }
    AppMethodBeat.o(137485);
  }
  
  public final void bVq()
  {
    AppMethodBeat.i(137486);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
    if (this.oYW.oYI != null) {
      this.oYW.E(this.oYW.oYI);
    }
    if ((this.oYW.startTime > 0) && (this.oYW.oYL != null) && (!this.oYW.oYL.mK()))
    {
      ab.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
      this.oYW.startTime = 0;
      this.oYW.oYL.aC(true);
    }
    AppMethodBeat.o(137486);
  }
  
  public final void bVr()
  {
    AppMethodBeat.i(137487);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
    if (this.oYW.oYI != null) {
      this.oYW.G(this.oYW.oYI);
    }
    this.oYW.oXo = false;
    this.oYW.bTu.removeMessages(100);
    AppMethodBeat.o(137487);
  }
  
  public final void eQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137489);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.oYW.oYI != null) {
      this.oYW.a(this.oYW.oYI, paramInt1, paramInt2);
    }
    if (this.oYW.oYL != null)
    {
      this.oYW.oYL.aC(false);
      this.oYW.oYL.stop();
    }
    this.oYW.oXo = false;
    this.oYW.bTu.removeMessages(100);
    a locala = this.oYW;
    locala.aZy += 1;
    if (this.oYW.aZy == 1) {
      a.a(this.oYW, this.oYW.oYI, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.c
 * JD-Core Version:    0.7.0.1
 */