package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$3
  implements Runnable
{
  f$3(f paramf, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(28901);
    ab.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", new Object[] { Long.valueOf(this.yll) });
    f.b(this.ylj, f.b(this.ylj) + Math.max(0L, this.yll));
    f.a(this.ylj, false);
    AppMethodBeat.o(28901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f.3
 * JD-Core Version:    0.7.0.1
 */