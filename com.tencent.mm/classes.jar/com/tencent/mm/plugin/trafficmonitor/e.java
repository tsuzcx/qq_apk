package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static Map<Integer, c> toC;
  private static e toD;
  
  static
  {
    AppMethodBeat.i(114787);
    toC = new ConcurrentHashMap();
    AppMethodBeat.o(114787);
  }
  
  private e()
  {
    AppMethodBeat.i(114781);
    l(1, 471859200L, 300000L);
    l(2, 838860800L, 600000L);
    l(3, 1887436800L, 1800000L);
    l(4, -1673527296L, 3603000L);
    AppMethodBeat.o(114781);
  }
  
  public static e cKP()
  {
    AppMethodBeat.i(114782);
    if (toD == null) {}
    try
    {
      if (toD == null) {
        toD = new e();
      }
      e locale = toD;
      AppMethodBeat.o(114782);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(114782);
    }
  }
  
  public static void cKQ()
  {
    AppMethodBeat.i(114784);
    Iterator localIterator = toC.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).cKM();
    }
    AppMethodBeat.o(114784);
  }
  
  public static void cKR()
  {
    AppMethodBeat.i(114785);
    Iterator localIterator = toC.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).currentIndex = 0;
    }
    AppMethodBeat.o(114785);
  }
  
  public static int cKS()
  {
    AppMethodBeat.i(114786);
    int i = -1;
    Iterator localIterator = toC.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.interval <= l) {
        break label75;
      }
      l = localc.interval;
      i = localc.id;
    }
    label75:
    for (;;)
    {
      break;
      AppMethodBeat.o(114786);
      return i;
    }
  }
  
  private void l(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(114783);
    d locald = new d(paramLong1);
    b localb = new b();
    localb.id = paramInt;
    localb.interval = paramLong2;
    localb.type = 0;
    localb.tot = locald;
    localb.tou = new e.1(this, paramInt);
    toC.put(Integer.valueOf(paramInt), localb);
    AppMethodBeat.o(114783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */