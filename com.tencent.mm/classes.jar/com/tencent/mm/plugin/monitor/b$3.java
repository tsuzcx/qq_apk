package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    try
    {
      g.DQ();
      int j = ((Integer)g.DP().Dz().get(ac.a.uui, Integer.valueOf(0))).intValue();
      g.DQ();
      long l1 = ((Long)g.DP().Dz().get(ac.a.uuh, Long.valueOf(0L))).longValue();
      long l2 = b.q(this.msl);
      Object localObject;
      if ((j > 0) && (d.spa != j))
      {
        i = 0;
        localObject = new StringBuilder().append(j).append(";").append(d.spa).append(";");
        if (i == 0) {
          break label226;
        }
      }
      label226:
      for (int i = 1;; i = 0)
      {
        localObject = i + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(l1)) + ";" + l2;
        h.nFQ.a(418L, 1L, 1L, true);
        h.nFQ.f(13778, new Object[] { Integer.valueOf(3), Integer.valueOf(1), localObject });
        y.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[] { localObject });
        return;
        i = 1;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportVersion err!", new Object[0]);
      h.nFQ.a(418L, 2L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.3
 * JD-Core Version:    0.7.0.1
 */