package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class b$9
  implements Runnable
{
  b$9(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(84526);
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
    if (!g.RG())
    {
      ab.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
      AppMethodBeat.o(84526);
      return;
    }
    b.b(this.oRW);
    b.c(this.oRW);
    b.d(this.oRW);
    b.e(this.oRW);
    b.f(this.oRW);
    d.ysn.ak(b.g(this.oRW));
    d.ysn.q(b.g(this.oRW), 10000L);
    AppMethodBeat.o(84526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.9
 * JD-Core Version:    0.7.0.1
 */