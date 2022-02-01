package com.tencent.mm.plugin.trafficmonitor;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class g
{
  private static Map<Integer, e> GsX;
  private static g GsY;
  
  static
  {
    AppMethodBeat.i(123929);
    GsX = new ConcurrentHashMap();
    AppMethodBeat.o(123929);
  }
  
  private g()
  {
    AppMethodBeat.i(123923);
    o(1, 471859200L, 300000L);
    o(2, 838860800L, 600000L);
    o(3, 1887436800L, 1800000L);
    o(4, -1673527296L, 3603000L);
    AppMethodBeat.o(123923);
  }
  
  public static g fAk()
  {
    AppMethodBeat.i(123924);
    if (GsY == null) {}
    try
    {
      if (GsY == null) {
        GsY = new g();
      }
      g localg = GsY;
      AppMethodBeat.o(123924);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(123924);
    }
  }
  
  public static void fAl()
  {
    AppMethodBeat.i(123926);
    Iterator localIterator = GsX.values().iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).fAh();
    }
    AppMethodBeat.o(123926);
  }
  
  public static void fAm()
  {
    AppMethodBeat.i(123927);
    Iterator localIterator = GsX.values().iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).currentIndex = 0;
    }
    AppMethodBeat.o(123927);
  }
  
  public static int fAn()
  {
    AppMethodBeat.i(123928);
    int i = -1;
    Iterator localIterator = GsX.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.interval <= l) {
        break label75;
      }
      l = locale.interval;
      i = locale.id;
    }
    label75:
    for (;;)
    {
      break;
      AppMethodBeat.o(123928);
      return i;
    }
  }
  
  private void o(final int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(123925);
    f localf = new f(paramLong1);
    if (Build.VERSION.SDK_INT >= 28) {}
    for (Object localObject = new d();; localObject = new b())
    {
      ((e)localObject).id = paramInt;
      ((e)localObject).interval = paramLong2;
      ((e)localObject).type = 0;
      ((e)localObject).GsO = localf;
      ((e)localObject).GsP = new e.a() {};
      GsX.put(Integer.valueOf(paramInt), localObject);
      AppMethodBeat.o(123925);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.g
 * JD-Core Version:    0.7.0.1
 */