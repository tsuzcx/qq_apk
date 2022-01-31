package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.TimerTask;

final class b$1
  extends TimerTask
{
  b$1(b paramb) {}
  
  public final void run()
  {
    a.update(this.pJT.id);
    long l4 = 0L;
    long l2 = 0L;
    int i = this.pJT.type;
    long l6 = System.currentTimeMillis();
    long l1;
    long l3;
    long l5;
    if (i == 0)
    {
      l4 = a.zM(this.pJT.id);
      l2 = a.zL(this.pJT.id);
      l1 = l4 + l2;
      l3 = 0L;
      l5 = l1;
      long l7 = a.zI(this.pJT.id);
      long l8 = a.zH(this.pJT.id);
      if ((l7 >= l4) && (l8 >= l2)) {
        break label214;
      }
    }
    label214:
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (i == 1)
        {
          l1 = a.zK(this.pJT.id) + a.zJ(this.pJT.id);
          l3 = l1;
          l5 = 0L;
          break;
        }
      } while (i != 2);
      l4 = a.zM(this.pJT.id);
      l2 = a.zL(this.pJT.id);
      l5 = l4 + l2;
      l3 = a.zK(this.pJT.id) + a.zJ(this.pJT.id);
      l1 = l3 + l5;
      break;
      localArrayList = new ArrayList();
      i = TrafficClickFlowReceiver.a(this.pJT.currentIndex, l6 - this.pJT.dFf, localArrayList);
    } while (i == -1);
    this.pJT.currentIndex = i;
    l2 = l1 / this.pJT.dFf;
    l2 = this.pJT.i(l6, l1, 1000L * l2);
    y.i("MicroMsg.FileTrafficStatsInspector", "wxComputeTraffic : %d, wxTotalTraffic : %d , interval : %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(this.pJT.dFf) });
    String str;
    int j;
    if (this.pJT.pKf.b(localArrayList, l2, this.pJT.dFf))
    {
      Double localDouble = Double.valueOf(this.pJT.pKf.pKl);
      str = String.valueOf(localDouble);
      j = (int)Math.round(localDouble.doubleValue());
      i = 0;
      if ((j <= 3) || (j > 4)) {
        break label541;
      }
      i = 60;
    }
    for (;;)
    {
      f.nEG.a(877L, i, 1L, true);
      f.nEG.f(15856, new Object[] { Long.valueOf(this.pJT.dFf), localArrayList.toString(), Long.valueOf(l1), Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(this.pJT.pKf.pKk), str, Integer.valueOf(j) });
      this.pJT.pKg.bOS();
      e.bOT();
      i = e.bOV();
      if (this.pJT.id != i) {
        break;
      }
      TrafficClickFlowReceiver.bOR();
      e.bOT();
      e.resetIndex();
      return;
      label541:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.b.1
 * JD-Core Version:    0.7.0.1
 */