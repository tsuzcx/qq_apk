package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ac
{
  public static ac.b dhs;
  private static int ufa;
  public static Map<Integer, ac> ufc = new HashMap();
  private static boolean ufe = false;
  public static boolean uff;
  public long dFf = 0L;
  private final boolean eaP;
  public long ts = 0L;
  public final int ufb;
  private final ac.a ufd;
  
  public ac(ac.a parama)
  {
    Assert.assertTrue("bumper not initialized", ufe);
    this.ufd = parama;
    this.eaP = true;
    if (ufa >= 8192) {
      ufa = 0;
    }
    int i = ufa + 1;
    ufa = i;
    this.ufb = i;
  }
  
  public static void a(ac.b paramb)
  {
    ufe = true;
    dhs = paramb;
  }
  
  public static long cqN()
  {
    uff = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(ufc.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ac localac = (ac)ufc.get(localInteger);
      if (localac == null) {
        break label273;
      }
      long l3 = bk.cp(localac.ts);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localac.dFf)
      {
        if ((!localac.ufd.tC()) || (!localac.eaP)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localac.ts = bk.UZ();
          break;
          l1 = localac.dFf;
        }
      }
      if (localac.dFf - l2 >= l1) {
        break label273;
      }
      l1 = localac.dFf - l2;
    }
    label273:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        ufc.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!uff) && (l1 == 9223372036854775807L) && (dhs != null))
      {
        dhs.cancel();
        y.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      return l1;
    }
  }
  
  public static boolean hp(long paramLong)
  {
    y.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + paramLong);
    Iterator localIterator = ufc.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      ac localac = (ac)((Map.Entry)localIterator.next()).getValue();
      if (localac == null) {
        break label154;
      }
      long l3 = bk.cp(localac.ts);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localac.dFf)
      {
        l1 = localac.dFf;
      }
      else
      {
        if (localac.dFf - l2 >= l1) {
          break label154;
        }
        l1 = localac.dFf - l2;
      }
    }
    label154:
    for (;;)
    {
      break;
      return l1 > paramLong;
    }
  }
  
  protected final void finalize()
  {
    stopTimer();
    super.finalize();
  }
  
  public final void stopTimer()
  {
    ufc.remove(Integer.valueOf(this.ufb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ac
 * JD-Core Version:    0.7.0.1
 */