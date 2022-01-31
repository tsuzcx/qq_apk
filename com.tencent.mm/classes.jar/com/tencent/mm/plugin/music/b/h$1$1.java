package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(137347);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(this.oXz) });
    if (this.oXA.oXy.startTime != 0)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(this.oXA.oXy.startTime) });
      this.oXA.oXy.startTime = 0;
      h.1.a(this.oXA);
      AppMethodBeat.o(137347);
      return;
    }
    h.1 local1 = this.oXA;
    ab.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
    local1.oXy.bUv();
    if (local1.oXy.aiw())
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
      local1.oXy.bUs();
    }
    AppMethodBeat.o(137347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h.1.1
 * JD-Core Version:    0.7.0.1
 */