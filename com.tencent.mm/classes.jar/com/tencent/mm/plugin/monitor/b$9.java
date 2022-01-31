package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class b$9
  implements Runnable
{
  b$9(b paramb) {}
  
  public final void run()
  {
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
    b.b(this.msl);
    b.c(this.msl);
    b.d(this.msl);
    b.e(this.msl);
    b.f(this.msl);
    g.DS();
    ai.S(b.g(this.msl));
    g.DS().k(b.g(this.msl), 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.9
 * JD-Core Version:    0.7.0.1
 */