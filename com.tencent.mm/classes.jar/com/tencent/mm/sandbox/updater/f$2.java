package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements Runnable
{
  f$2(f paramf, long paramLong) {}
  
  public final void run()
  {
    y.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", new Object[] { Long.valueOf(this.ucV) });
    f.a(this.ucU, f.a(this.ucU) + Math.max(0L, this.ucV));
    f.a(this.ucU, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f.2
 * JD-Core Version:    0.7.0.1
 */