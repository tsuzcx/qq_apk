package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
      g.aAi();
      int j = ((Integer)g.aAh().azQ().get(ar.a.NZy, Integer.valueOf(0))).intValue();
      g.aAi();
      long l1 = ((Long)g.aAh().azQ().get(ar.a.NZx, Long.valueOf(0L))).longValue();
      long l2 = b.r(this.zFo);
      Object localObject;
      if ((j > 0) && (d.KyO != j))
      {
        i = 0;
        localObject = new StringBuilder().append(j).append(";").append(d.KyO).append(";");
        if (i == 0) {
          break label239;
        }
      }
      label239:
      for (int i = 1;; i = 0)
      {
        localObject = i + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(l1)) + ";" + l2;
        h.CyF.idkeyStat(418L, 1L, 1L, true);
        h.CyF.a(13778, false, false, true, new Object[] { Integer.valueOf(3), Integer.valueOf(1), localObject });
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[] { localObject });
        AppMethodBeat.o(163485);
        return;
        i = 1;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportVersion err!", new Object[0]);
      h.CyF.idkeyStat(418L, 2L, 1L, true);
      AppMethodBeat.o(163485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.4
 * JD-Core Version:    0.7.0.1
 */