package com.tencent.mm.pluginsdk.model.app;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class ak$a$3
  implements Runnable
{
  ak$a$3(ak.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(27397);
    long l = System.currentTimeMillis() - ak.a.k(this.vLU);
    ab.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + ak.a.f(this.vLU) + " timeWait:" + l + " sending:" + ak.a.h(this.vLU) + " recving:" + ak.a.g(this.vLU));
    if (ak.a.f(this.vLU))
    {
      if (l < 180000L)
      {
        AppMethodBeat.o(27397);
        return;
      }
      ab.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + ak.a.f(this.vLU) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ak.a.h(this.vLU) + " recving:" + ak.a.g(this.vLU));
    }
    ak.a.l(this.vLU);
    ak.a.b(this.vLU);
    ak.a.m(this.vLU);
    ak.a.a(this.vLU);
    this.vLU.ckQ.etf = SystemClock.elapsedRealtime();
    ak.a.n(this.vLU).ag(10L, 10L);
    AppMethodBeat.o(27397);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(27398);
    String str = super.toString() + "|run";
    AppMethodBeat.o(27398);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak.a.3
 * JD-Core Version:    0.7.0.1
 */