package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.text.SimpleDateFormat;
import java.util.Date;

final class b$4
  implements Runnable
{
  b$4(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(163485);
    try
    {
      com.tencent.mm.kernel.g.ajD();
      int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IwY, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.ajD();
      long l1 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IwX, Long.valueOf(0L))).longValue();
      long l2 = b.r(this.vYI);
      Object localObject;
      if ((j > 0) && (d.Fnj != j))
      {
        i = 0;
        localObject = new StringBuilder().append(j).append(";").append(d.Fnj).append(";");
        if (i == 0) {
          break label239;
        }
      }
      label239:
      for (int i = 1;; i = 0)
      {
        localObject = i + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(l1)) + ";" + l2;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(418L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yhR.a(13778, false, false, true, new Object[] { Integer.valueOf(3), Integer.valueOf(1), localObject });
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[] { localObject });
        AppMethodBeat.o(163485);
        return;
        i = 1;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportVersion err!", new Object[0]);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(418L, 2L, 1L, true);
      AppMethodBeat.o(163485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.4
 * JD-Core Version:    0.7.0.1
 */