package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class d
  extends e
{
  public final String TAG = "MicroMsg.NsmTrafficStatsInspector";
  private Timer cOI = null;
  private TimerTask cOJ = null;
  private boolean started;
  
  public final void euO()
  {
    AppMethodBeat.i(123899);
    if (this.started)
    {
      AppMethodBeat.o(123899);
      return;
    }
    this.currentIndex = 0;
    c.init(this.id);
    c.reset(this.id);
    c.update(this.id);
    this.cOJ = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(123898);
        c.update(d.this.id);
        int i = d.this.type;
        long l5 = System.currentTimeMillis();
        Object localObject = ay.aRX("trafficmonitor");
        long l6 = ((ay)localObject).decodeLong("trafficmonitor_" + d.this.interval, 0L);
        ((ay)localObject).encode("trafficmonitor_" + d.this.interval, l5);
        long l2;
        long l1;
        long l3;
        if (i == 0)
        {
          l2 = c.TW(d.this.id) + c.TV(d.this.id);
          l1 = l2;
          long l4 = 0L;
          l3 = l2;
          l2 = l4;
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = TrafficClickFlowReceiver.a(d.this.currentIndex, l5 - d.this.interval, (List)localObject);
          if (i != -1) {
            break label282;
          }
          AppMethodBeat.o(123898);
          return;
          if (i == 1)
          {
            l2 = c.TU(d.this.id) + c.TT(d.this.id);
            l1 = l2;
            l3 = 0L;
          }
          else
          {
            if (i != 2) {
              break;
            }
            l3 = c.TW(d.this.id) + c.TV(d.this.id);
            l2 = c.TU(d.this.id) + c.TT(d.this.id);
            l1 = l2 + l3;
          }
        }
        AppMethodBeat.o(123898);
        return;
        label282:
        d.this.currentIndex = i;
        if (d.BE(l6))
        {
          ae.i("MicroMsg.NsmTrafficStatsInspector", "isDownloadAndNormal");
          d.this.euQ();
          AppMethodBeat.o(123898);
          return;
        }
        ae.i("MicroMsg.NsmTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", new Object[] { Long.valueOf(l1), Long.valueOf(d.this.interval) });
        String str;
        int j;
        if (d.this.BSi.a((List)localObject, l1, d.this.interval, l5 - l6))
        {
          Double localDouble = Double.valueOf(d.this.BSi.BSo);
          str = String.valueOf(localDouble);
          j = (int)Math.round(localDouble.doubleValue());
          i = 0;
          if ((j <= 3) || (j > 4)) {
            break label554;
          }
          i = 60;
        }
        for (;;)
        {
          ae.i("MicroMsg.NsmTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", new Object[] { str });
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(877L, i, 1L, true);
          com.tencent.mm.plugin.report.e.ywz.f(15856, new Object[] { Long.valueOf(d.this.interval), localObject.toString(), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(d.this.BSi.BSn), str, Integer.valueOf(j) });
          d.this.euQ();
          AppMethodBeat.o(123898);
          return;
          label554:
          if ((j > 4) && (j <= 5)) {
            i = 61;
          } else if ((j > 5) && (j <= 6)) {
            i = 62;
          } else if ((j > 6) && (j <= 7)) {
            i = 63;
          } else if (j > 7) {
            i = 64;
          }
        }
      }
    };
    this.cOI = new Timer();
    try
    {
      this.cOI.schedule(this.cOJ, 0L, this.interval);
      this.started = true;
      AppMethodBeat.o(123899);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ae.e("MicroMsg.NsmTrafficStatsInspector", "timer.schedule got an IllegalArgumentException, %s", new Object[] { localIllegalArgumentException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.d
 * JD-Core Version:    0.7.0.1
 */