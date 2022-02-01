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

public final class ah
{
  private static int EUr;
  private static Map<Integer, ah> EUt;
  private static boolean EUv;
  private static boolean EUw;
  private static b fiq;
  private final int EUs;
  private final a EUu;
  private long gRD;
  private long interval;
  private final boolean loop;
  
  static
  {
    AppMethodBeat.i(157607);
    EUt = new HashMap();
    EUv = false;
    AppMethodBeat.o(157607);
  }
  
  public ah(a parama)
  {
    AppMethodBeat.i(157602);
    this.gRD = 0L;
    this.interval = 0L;
    Assert.assertTrue("bumper not initialized", EUv);
    this.EUu = parama;
    this.loop = true;
    if (EUr >= 8192) {
      EUr = 0;
    }
    int i = EUr + 1;
    EUr = i;
    this.EUs = i;
    AppMethodBeat.o(157602);
  }
  
  public static void a(b paramb)
  {
    EUv = true;
    fiq = paramb;
  }
  
  public static long eFy()
  {
    AppMethodBeat.i(157603);
    EUw = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(EUt.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ah localah = (ah)EUt.get(localInteger);
      if (localah == null) {
        break label283;
      }
      long l3 = bt.aS(localah.gRD);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localah.interval)
      {
        if ((!localah.EUu.onTimerExpired()) || (!localah.loop)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localah.gRD = bt.GC();
          break;
          l1 = localah.interval;
        }
      }
      if (localah.interval - l2 >= l1) {
        break label283;
      }
      l1 = localah.interval - l2;
    }
    label283:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        EUt.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!EUw) && (l1 == 9223372036854775807L) && (fiq != null))
      {
        fiq.cancel();
        ad.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      AppMethodBeat.o(157603);
      return l1;
    }
  }
  
  private static boolean vD(long paramLong)
  {
    AppMethodBeat.i(157606);
    ad.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(paramLong)));
    Iterator localIterator = EUt.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      ah localah = (ah)((Map.Entry)localIterator.next()).getValue();
      if (localah == null) {
        break label162;
      }
      long l3 = bt.aS(localah.gRD);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localah.interval)
      {
        l1 = localah.interval;
      }
      else
      {
        if (localah.interval - l2 >= l1) {
          break label162;
        }
        l1 = localah.interval - l2;
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
  
  public final void eFz()
  {
    AppMethodBeat.i(157604);
    EUw = true;
    this.interval = 50000L;
    this.gRD = bt.GC();
    boolean bool = vD(this.interval);
    stopTimer();
    EUt.put(Integer.valueOf(this.EUs), this);
    if ((fiq != null) && (bool))
    {
      ad.v("MicroMsg.MAlarmHandler", "prepare bumper");
      fiq.prepare();
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
    EUt.remove(Integer.valueOf(this.EUs));
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ah
 * JD-Core Version:    0.7.0.1
 */