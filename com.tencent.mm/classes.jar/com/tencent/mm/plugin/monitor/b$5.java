package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.text.SimpleDateFormat;
import java.util.Date;

final class b$5
  implements Runnable
{
  b$5(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(51504);
    try
    {
      com.tencent.mm.kernel.h.aHH();
      int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vny, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.aHH();
      long l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vnx, Long.valueOf(0L))).longValue();
      long l2 = b.r(this.Fkn);
      Object localObject;
      if ((j > 0) && (d.RAD != j))
      {
        i = 0;
        localObject = new StringBuilder().append(j).append(";").append(d.RAD).append(";");
        if (i == 0) {
          break label239;
        }
      }
      label239:
      for (int i = 1;; i = 0)
      {
        localObject = i + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(l1)) + ";" + l2;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(418L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.a(13778, false, false, true, new Object[] { Integer.valueOf(3), Integer.valueOf(1), localObject });
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[] { localObject });
        AppMethodBeat.o(51504);
        return;
        i = 1;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportVersion err!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(418L, 2L, 1L, true);
      AppMethodBeat.o(51504);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.5
 * JD-Core Version:    0.7.0.1
 */