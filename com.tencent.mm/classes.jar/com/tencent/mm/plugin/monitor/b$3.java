package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(84519);
    try
    {
      g.RM();
      int j = ((Integer)g.RL().Ru().get(ac.a.yEl, Integer.valueOf(0))).intValue();
      g.RM();
      long l1 = ((Long)g.RL().Ru().get(ac.a.yEk, Long.valueOf(0L))).longValue();
      long l2 = b.r(this.oRW);
      Object localObject;
      if ((j > 0) && (d.whH != j))
      {
        i = 0;
        localObject = new StringBuilder().append(j).append(";").append(d.whH).append(";");
        if (i == 0) {
          break label236;
        }
      }
      label236:
      for (int i = 1;; i = 0)
      {
        localObject = i + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(l1)) + ";" + l2;
        h.qsU.idkeyStat(418L, 1L, 1L, true);
        h.qsU.e(13778, new Object[] { Integer.valueOf(3), Integer.valueOf(1), localObject });
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[] { localObject });
        AppMethodBeat.o(84519);
        return;
        i = 1;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportVersion err!", new Object[0]);
      h.qsU.idkeyStat(418L, 2L, 1L, true);
      AppMethodBeat.o(84519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.3
 * JD-Core Version:    0.7.0.1
 */