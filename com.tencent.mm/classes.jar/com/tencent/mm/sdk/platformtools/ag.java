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

public final class ag
{
  private static int GrD;
  private static Map<Integer, ag> GrF;
  private static boolean GrH;
  private static boolean GrI;
  private static b flL;
  private final int GrE;
  private final a GrG;
  private long hsd;
  private long interval;
  private final boolean loop;
  
  static
  {
    AppMethodBeat.i(157607);
    GrF = new HashMap();
    GrH = false;
    AppMethodBeat.o(157607);
  }
  
  public ag(a parama)
  {
    AppMethodBeat.i(157602);
    this.hsd = 0L;
    this.interval = 0L;
    Assert.assertTrue("bumper not initialized", GrH);
    this.GrG = parama;
    this.loop = true;
    if (GrD >= 8192) {
      GrD = 0;
    }
    int i = GrD + 1;
    GrD = i;
    this.GrE = i;
    AppMethodBeat.o(157602);
  }
  
  private static boolean Ag(long paramLong)
  {
    AppMethodBeat.i(157606);
    ac.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(paramLong)));
    Iterator localIterator = GrF.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      ag localag = (ag)((Map.Entry)localIterator.next()).getValue();
      if (localag == null) {
        break label162;
      }
      long l3 = bs.aO(localag.hsd);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localag.interval)
      {
        l1 = localag.interval;
      }
      else
      {
        if (localag.interval - l2 >= l1) {
          break label162;
        }
        l1 = localag.interval - l2;
      }
    }
    label162:
    for (;;)
    {
      break;
      if (l1 > paramLong)
      {
        AppMethodBeat.o(157606);
        return true;
      }
      AppMethodBeat.o(157606);
      return false;
    }
  }
  
  public static void a(b paramb)
  {
    GrH = true;
    flL = paramb;
  }
  
  public static long eUS()
  {
    AppMethodBeat.i(157603);
    GrI = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(GrF.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ag localag = (ag)GrF.get(localInteger);
      if (localag == null) {
        break label283;
      }
      long l3 = bs.aO(localag.hsd);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localag.interval)
      {
        if ((!localag.GrG.onTimerExpired()) || (!localag.loop)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localag.hsd = bs.Gn();
          break;
          l1 = localag.interval;
        }
      }
      if (localag.interval - l2 >= l1) {
        break label283;
      }
      l1 = localag.interval - l2;
    }
    label283:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        GrF.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!GrI) && (l1 == 9223372036854775807L) && (flL != null))
      {
        flL.cancel();
        ac.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      AppMethodBeat.o(157603);
      return l1;
    }
  }
  
  public final void eUT()
  {
    AppMethodBeat.i(157604);
    GrI = true;
    this.interval = 50000L;
    this.hsd = bs.Gn();
    boolean bool = Ag(this.interval);
    stopTimer();
    GrF.put(Integer.valueOf(this.GrE), this);
    if ((flL != null) && (bool))
    {
      ac.v("MicroMsg.MAlarmHandler", "prepare bumper");
      flL.prepare();
    }
    AppMethodBeat.o(157604);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(157601);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(157601);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157605);
    GrF.remove(Integer.valueOf(this.GrE));
    AppMethodBeat.o(157605);
  }
  
  public static abstract interface a
  {
    public abstract boolean onTimerExpired();
  }
  
  public static abstract interface b
  {
    public abstract void cancel();
    
    public abstract void prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ag
 * JD-Core Version:    0.7.0.1
 */