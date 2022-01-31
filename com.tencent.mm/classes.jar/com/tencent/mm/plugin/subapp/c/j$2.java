package com.tencent.mm.plugin.subapp.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class j$2
  implements Runnable
{
  j$2(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(25308);
    long l = System.currentTimeMillis() - j.j(this.sXD);
    ab.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(this.sXD) + " timeWait:" + l + " sending:" + j.g(this.sXD) + " recving:" + j.f(this.sXD));
    if (j.e(this.sXD))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(25308);
        return;
      }
      ab.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(this.sXD) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.g(this.sXD) + " recving:" + j.f(this.sXD));
    }
    j.k(this.sXD);
    j.b(this.sXD);
    j.a(this.sXD, 3);
    j.a(this.sXD);
    this.sXD.ckQ.etf = SystemClock.elapsedRealtime();
    j.l(this.sXD).ag(10L, 10L);
    AppMethodBeat.o(25308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j.2
 * JD-Core Version:    0.7.0.1
 */