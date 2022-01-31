package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class af
{
  private static af.b dYE;
  private static int ynB;
  private static Map<Integer, af> ynD;
  private static boolean ynF;
  private static boolean ynG;
  private final boolean fqY;
  private long interval;
  private long ts;
  private final int ynC;
  private final af.a ynE;
  
  static
  {
    AppMethodBeat.i(52050);
    ynD = new HashMap();
    ynF = false;
    AppMethodBeat.o(52050);
  }
  
  public af(af.a parama)
  {
    AppMethodBeat.i(52045);
    this.ts = 0L;
    this.interval = 0L;
    Assert.assertTrue("bumper not initialized", ynF);
    this.ynE = parama;
    this.fqY = true;
    if (ynB >= 8192) {
      ynB = 0;
    }
    int i = ynB + 1;
    ynB = i;
    this.ynC = i;
    AppMethodBeat.o(52045);
  }
  
  public static void a(af.b paramb)
  {
    ynF = true;
    dYE = paramb;
  }
  
  public static long dsK()
  {
    AppMethodBeat.i(52046);
    ynG = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(ynD.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      af localaf = (af)ynD.get(localInteger);
      if (localaf == null) {
        break label283;
      }
      long l3 = bo.av(localaf.ts);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localaf.interval)
      {
        if ((!localaf.ynE.onTimerExpired()) || (!localaf.fqY)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localaf.ts = bo.yB();
          break;
          l1 = localaf.interval;
        }
      }
      if (localaf.interval - l2 >= l1) {
        break label283;
      }
      l1 = localaf.interval - l2;
    }
    label283:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        ynD.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!ynG) && (l1 == 9223372036854775807L) && (dYE != null))
      {
        dYE.cancel();
        ab.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      AppMethodBeat.o(52046);
      return l1;
    }
  }
  
  private static boolean nO(long paramLong)
  {
    AppMethodBeat.i(52049);
    ab.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(paramLong)));
    Iterator localIterator = ynD.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      af localaf = (af)((Map.Entry)localIterator.next()).getValue();
      if (localaf == null) {
        break label162;
      }
      long l3 = bo.av(localaf.ts);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localaf.interval)
      {
        l1 = localaf.interval;
      }
      else
      {
        if (localaf.interval - l2 >= l1) {
          break label162;
        }
        l1 = localaf.interval - l2;
      }
    }
    label162:
    for (;;)
    {
      break;
      if (l1 > paramLong)
      {
        AppMethodBeat.o(52049);
        return true;
      }
      AppMethodBeat.o(52049);
      return false;
    }
  }
  
  public final void dsL()
  {
    AppMethodBeat.i(52047);
    ynG = true;
    this.interval = 50000L;
    this.ts = bo.yB();
    boolean bool = nO(this.interval);
    stopTimer();
    ynD.put(Integer.valueOf(this.ynC), this);
    if ((dYE != null) && (bool))
    {
      ab.v("MicroMsg.MAlarmHandler", "prepare bumper");
      dYE.prepare();
    }
    AppMethodBeat.o(52047);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(52044);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(52044);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(52048);
    ynD.remove(Integer.valueOf(this.ynC));
    AppMethodBeat.o(52048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.af
 * JD-Core Version:    0.7.0.1
 */