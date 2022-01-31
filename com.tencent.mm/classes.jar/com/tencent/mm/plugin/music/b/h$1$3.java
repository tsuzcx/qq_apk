package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1$3
  implements Runnable
{
  h$1$3(h.1 param1, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(137349);
    String str = this.oXA.oXy.ceu;
    ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(this.gB), str });
    if (this.gB == 3)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
      h.1.b(this.oXA);
      this.oXA.oXy.oXv = System.currentTimeMillis();
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 2)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
      ab.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - this.oXA.oXy.oXv) });
      h.1.a(this.oXA);
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 4)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
      ab.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - this.oXA.oXy.oXv) });
      h.1.c(this.oXA);
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 5)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
      h.1.d(this.oXA);
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 6)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
      h.1.e(this.oXA);
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 7)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
      h.1.f(this.oXA);
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 8)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
      h.1.bUK();
      AppMethodBeat.o(137349);
      return;
    }
    if (this.gB == 9) {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
    }
    AppMethodBeat.o(137349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h.1.3
 * JD-Core Version:    0.7.0.1
 */