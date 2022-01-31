package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  implements Runnable
{
  f$2(f paramf, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(28900);
    ab.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", new Object[] { Long.valueOf(this.ylk) });
    f.a(this.ylj, f.a(this.ylj) + Math.max(0L, this.ylk));
    f.a(this.ylj, false);
    AppMethodBeat.o(28900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f.2
 * JD-Core Version:    0.7.0.1
 */