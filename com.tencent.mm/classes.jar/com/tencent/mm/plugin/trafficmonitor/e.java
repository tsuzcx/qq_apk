package com.tencent.mm.plugin.trafficmonitor;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static Map<Integer, c> pKo = new ConcurrentHashMap();
  private static e pKp;
  public e.a pKq;
  
  private e()
  {
    j(1, 471859200L, 300000L);
    j(2, 838860800L, 600000L);
    j(3, 1887436800L, 1800000L);
    j(4, -1673527296L, 3603000L);
  }
  
  public static e bOT()
  {
    if (pKp == null) {}
    try
    {
      if (pKp == null) {
        pKp = new e();
      }
      return pKp;
    }
    finally {}
  }
  
  public static void bOU()
  {
    Iterator localIterator = pKo.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).bOQ();
    }
  }
  
  public static int bOV()
  {
    int i = -1;
    Iterator localIterator = pKo.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.dFf <= l) {
        break label65;
      }
      l = localc.dFf;
      i = localc.id;
    }
    label65:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void j(int paramInt, long paramLong1, long paramLong2)
  {
    d locald = new d(paramLong1);
    b localb = new b();
    localb.id = paramInt;
    localb.dFf = paramLong2;
    localb.type = 0;
    localb.pKf = locald;
    localb.pKg = new e.1(this, paramInt);
    pKo.put(Integer.valueOf(paramInt), localb);
  }
  
  public static void resetIndex()
  {
    Iterator localIterator = pKo.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).currentIndex = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */