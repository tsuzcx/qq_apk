package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

final class b$1
  extends TimerTask
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(114756);
    a.update(this.toh.id);
    long l3 = 0L;
    long l2 = 0L;
    int i = this.toh.type;
    long l6 = System.currentTimeMillis();
    Object localObject = as.eu("trafficmonitor", 1);
    long l7 = ((as)localObject).aps("trafficmonitor_" + this.toh.interval);
    ((as)localObject).encode("trafficmonitor_" + this.toh.interval, l6);
    long l5;
    long l1;
    long l4;
    if (i == 0)
    {
      l3 = a.GS(this.toh.id);
      l2 = a.GR(this.toh.id);
      l5 = l3 + l2;
      l1 = l5;
      l4 = 0L;
    }
    for (;;)
    {
      long l8 = a.GO(this.toh.id);
      long l9 = a.GN(this.toh.id);
      if ((l8 >= l3) && (l9 >= l2)) {
        break label299;
      }
      AppMethodBeat.o(114756);
      return;
      if (i == 1)
      {
        l4 = a.GQ(this.toh.id) + a.GP(this.toh.id);
        l1 = l4;
        l5 = 0L;
      }
      else
      {
        if (i != 2) {
          break;
        }
        l3 = a.GS(this.toh.id);
        l2 = a.GR(this.toh.id);
        l5 = l3 + l2;
        l4 = a.GQ(this.toh.id) + a.GP(this.toh.id);
        l1 = l4 + l5;
      }
    }
    AppMethodBeat.o(114756);
    return;
    label299:
    localObject = new ArrayList();
    i = TrafficClickFlowReceiver.a(this.toh.currentIndex, l6 - this.toh.interval, (List)localObject);
    if (i == -1)
    {
      AppMethodBeat.o(114756);
      return;
    }
    this.toh.currentIndex = i;
    if (b.ne(l7))
    {
      ab.i("MicroMsg.FileTrafficStatsInspector", "isDownloadAndNormal");
      this.toh.cKO();
      AppMethodBeat.o(114756);
      return;
    }
    ab.i("MicroMsg.FileTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.toh.interval) });
    String str;
    int j;
    if (this.toh.tot.a((List)localObject, l1, this.toh.interval, l6 - l7))
    {
      Double localDouble = Double.valueOf(this.toh.tot.toz);
      str = String.valueOf(localDouble);
      j = (int)Math.round(localDouble.doubleValue());
      i = 0;
      if ((j <= 3) || (j > 4)) {
        break label614;
      }
      i = 60;
    }
    for (;;)
    {
      ab.i("MicroMsg.FileTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", new Object[] { str });
      e.qrI.idkeyStat(877L, i, 1L, true);
      e.qrI.e(15856, new Object[] { Long.valueOf(this.toh.interval), localObject.toString(), Long.valueOf(l1), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(this.toh.tot.toy), str, Integer.valueOf(j) });
      this.toh.cKO();
      AppMethodBeat.o(114756);
      return;
      label614:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.b.1
 * JD-Core Version:    0.7.0.1
 */