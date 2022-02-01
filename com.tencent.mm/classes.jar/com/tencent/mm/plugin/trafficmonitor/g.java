package com.tencent.mm.plugin.trafficmonitor;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class g
{
  private static Map<Integer, e> NfJ;
  private static g NfK;
  
  static
  {
    AppMethodBeat.i(123929);
    NfJ = new ConcurrentHashMap();
    AppMethodBeat.o(123929);
  }
  
  private g()
  {
    AppMethodBeat.i(123923);
    v(1, 471859200L, 300000L);
    v(2, 838860800L, 600000L);
    v(3, 1887436800L, 1800000L);
    v(4, -1673527296L, 3603000L);
    AppMethodBeat.o(123923);
  }
  
  public static g gsl()
  {
    AppMethodBeat.i(123924);
    if (NfK == null) {}
    try
    {
      if (NfK == null) {
        NfK = new g();
      }
      g localg = NfK;
      AppMethodBeat.o(123924);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(123924);
    }
  }
  
  public static void gsm()
  {
    AppMethodBeat.i(123926);
    Iterator localIterator = NfJ.values().iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).gsi();
    }
    AppMethodBeat.o(123926);
  }
  
  public static void gsn()
  {
    AppMethodBeat.i(123927);
    Iterator localIterator = NfJ.values().iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).currentIndex = 0;
    }
    AppMethodBeat.o(123927);
  }
  
  public static int gso()
  {
    AppMethodBeat.i(123928);
    int i = -1;
    Iterator localIterator = NfJ.values().iterator();
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
  
  private void v(final int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(123925);
    f localf = new f(paramLong1);
    if (Build.VERSION.SDK_INT >= 28) {}
    for (Object localObject = new d();; localObject = new b())
    {
      ((e)localObject).id = paramInt;
      ((e)localObject).interval = paramLong2;
      ((e)localObject).type = 0;
      ((e)localObject).NfA = localf;
      ((e)localObject).NfB = new e.a() {};
      NfJ.put(Integer.valueOf(paramInt), localObject);
      AppMethodBeat.o(123925);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.g
 * JD-Core Version:    0.7.0.1
 */