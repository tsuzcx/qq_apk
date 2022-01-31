package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.y;

final class f$3
  implements Runnable
{
  f$3(f paramf, long paramLong) {}
  
  public final void run()
  {
    y.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", new Object[] { Long.valueOf(this.ucW) });
    f.b(this.ucU, f.b(this.ucU) + Math.max(0L, this.ucW));
    f.a(this.ucU, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f.3
 * JD-Core Version:    0.7.0.1
 */