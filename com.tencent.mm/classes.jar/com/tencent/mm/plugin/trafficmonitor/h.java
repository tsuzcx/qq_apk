package com.tencent.mm.plugin.trafficmonitor;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  private static final Map<Integer, f> TSu;
  private static h TSv;
  public static boolean TSw;
  
  static
  {
    AppMethodBeat.i(123929);
    TSu = new ConcurrentHashMap();
    TSw = false;
    AppMethodBeat.o(123929);
  }
  
  private h()
  {
    AppMethodBeat.i(123923);
    u(1, 471859200L, 300000L);
    u(2, 838860800L, 600000L);
    u(3, 1887436800L, 1800000L);
    AppMethodBeat.o(123923);
  }
  
  public static h hPo()
  {
    AppMethodBeat.i(123924);
    if (TSv == null) {}
    try
    {
      if (TSv == null) {
        TSv = new h();
      }
      h localh = TSv;
      AppMethodBeat.o(123924);
      return localh;
    }
    finally
    {
      AppMethodBeat.o(123924);
    }
  }
  
  public static void hPp()
  {
    AppMethodBeat.i(123926);
    Iterator localIterator = TSu.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (Build.VERSION.SDK_INT >= 28)
        {
          localf.TSk = e.hPm();
          if (localf.started) {
            continue;
          }
          localf.currentIndex = 0;
          localf.TSk.sE(localf.id);
          localf.TSk.iF(localf.id);
          localf.TSk.update(localf.id);
          localf.TSj = new f.2(localf);
        }
        try
        {
          localf.pen = com.tencent.threadpool.h.ahAA.b(localf.TSj, 0L, localf.interval);
          localf.started = true;
          continue;
          localf.TSk = b.hPk();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Log.e("MicroMsg.TrafficInspector", "timer.schedule got an IllegalArgumentException, %s", new Object[] { localIllegalArgumentException.getMessage() });
          }
        }
      }
    }
    AppMethodBeat.o(123926);
  }
  
  public static void hPq()
  {
    AppMethodBeat.i(123927);
    Iterator localIterator = TSu.values().iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).currentIndex = 0;
    }
    AppMethodBeat.o(123927);
  }
  
  public static int hPr()
  {
    AppMethodBeat.i(123928);
    int i = -1;
    Iterator localIterator = TSu.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (localf.interval <= l) {
        break label75;
      }
      l = localf.interval;
      i = localf.id;
    }
    label75:
    for (;;)
    {
      break;
      AppMethodBeat.o(123928);
      return i;
    }
  }
  
  private void u(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(123925);
    g localg = new g(paramLong1);
    f localf = new f();
    localf.id = paramInt;
    localf.interval = paramLong2;
    localf.type = 0;
    localf.TRI = localg;
    localf.TRJ = new h..ExternalSyntheticLambda0(this, paramInt);
    TSu.put(Integer.valueOf(paramInt), localf);
    AppMethodBeat.o(123925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.h
 * JD-Core Version:    0.7.0.1
 */