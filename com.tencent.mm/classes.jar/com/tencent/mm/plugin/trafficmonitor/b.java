package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends e
{
  private com.tencent.f.i.b GsA = null;
  public final String TAG = "MicroMsg.FileTrafficStatsInspector";
  private boolean started;
  
  public final void fAh()
  {
    AppMethodBeat.i(123889);
    if (this.started)
    {
      AppMethodBeat.o(123889);
      return;
    }
    this.currentIndex = 0;
    a.init(this.id);
    a.reset(this.id);
    a.update(this.id);
    this.GsA = new com.tencent.f.i.b()
    {
      public final String getKey()
      {
        return "FileTrafficStatsInspector";
      }
      
      public final void run()
      {
        AppMethodBeat.i(123888);
        a.update(b.this.id);
        long l3 = 0L;
        long l2 = 0L;
        int i = b.this.type;
        long l6 = System.currentTimeMillis();
        Object localObject = MultiProcessMMKV.getSingleMMKV("trafficmonitor");
        long l7 = ((MultiProcessMMKV)localObject).decodeLong("trafficmonitor_" + b.this.interval, 0L);
        ((MultiProcessMMKV)localObject).encode("trafficmonitor_" + b.this.interval, l6);
        long l5;
        long l1;
        long l4;
        if (i == 0)
        {
          l3 = a.acm(b.this.id);
          l2 = a.acl(b.this.id);
          l5 = l3 + l2;
          l1 = l5;
          l4 = 0L;
        }
        for (;;)
        {
          long l8 = a.aci(b.this.id);
          long l9 = a.ach(b.this.id);
          if ((l8 >= l3) && (l9 >= l2)) {
            break label299;
          }
          AppMethodBeat.o(123888);
          return;
          if (i == 1)
          {
            l4 = a.ack(b.this.id) + a.acj(b.this.id);
            l1 = l4;
            l5 = 0L;
          }
          else
          {
            if (i != 2) {
              break;
            }
            l3 = a.acm(b.this.id);
            l2 = a.acl(b.this.id);
            l5 = l3 + l2;
            l4 = a.ack(b.this.id) + a.acj(b.this.id);
            l1 = l4 + l5;
          }
        }
        AppMethodBeat.o(123888);
        return;
        label299:
        localObject = new ArrayList();
        i = TrafficClickFlowReceiver.a(b.this.currentIndex, l6 - b.this.interval, (List)localObject);
        if (i == -1)
        {
          AppMethodBeat.o(123888);
          return;
        }
        b.this.currentIndex = i;
        if (b.KL(l7))
        {
          Log.i("MicroMsg.FileTrafficStatsInspector", "isDownloadAndNormal");
          b.this.fAj();
          AppMethodBeat.o(123888);
          return;
        }
        Log.i("MicroMsg.FileTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", new Object[] { Long.valueOf(l1), Long.valueOf(b.this.interval) });
        String str;
        int j;
        if (b.this.GsO.a((List)localObject, l1, b.this.interval, l6 - l7))
        {
          Double localDouble = Double.valueOf(b.this.GsO.GsU);
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
          Log.i("MicroMsg.FileTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", new Object[] { str });
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(877L, i, 1L, true);
          com.tencent.mm.plugin.report.e.Cxv.a(15856, new Object[] { Long.valueOf(b.this.interval), localObject.toString(), Long.valueOf(l1), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(b.this.GsO.GsT), str, Integer.valueOf(j) });
          b.this.fAj();
          AppMethodBeat.o(123888);
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
    };
    try
    {
      h.RTc.p(this.GsA, this.interval);
      this.started = true;
      AppMethodBeat.o(123889);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FileTrafficStatsInspector", "timer.schedule got an IllegalArgumentException, %s", new Object[] { localIllegalArgumentException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.b
 * JD-Core Version:    0.7.0.1
 */