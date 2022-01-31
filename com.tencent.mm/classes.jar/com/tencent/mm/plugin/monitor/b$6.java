package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$6
  implements Runnable
{
  b$6(b paramb, long paramLong1, ac.a parama, long paramLong2) {}
  
  public final void run()
  {
    g.DQ();
    g.DP().Dz().c(ac.a.uuZ, Long.valueOf(this.mss));
    if (this.mst != null)
    {
      g.DQ();
      g.DP().Dz().c(this.mst, Long.valueOf(this.dCp));
    }
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.mss), Long.valueOf(b.r(this.msl)), this.mst, Long.valueOf(this.dCp) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.6
 * JD-Core Version:    0.7.0.1
 */