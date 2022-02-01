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
  private static int Idt;
  private static Map<Integer, ah> Idv;
  private static boolean Idx;
  private static boolean Idy;
  private static b fDS;
  private final int Idu;
  private final a Idw;
  private long hKv;
  private long interval;
  private final boolean loop;
  
  static
  {
    AppMethodBeat.i(157607);
    Idv = new HashMap();
    Idx = false;
    AppMethodBeat.o(157607);
  }
  
  public ah(a parama)
  {
    AppMethodBeat.i(157602);
    this.hKv = 0L;
    this.interval = 0L;
    Assert.assertTrue("bumper not initialized", Idx);
    this.Idw = parama;
    this.loop = true;
    if (Idt >= 8192) {
      Idt = 0;
    }
    int i = Idt + 1;
    Idt = i;
    this.Idu = i;
    AppMethodBeat.o(157602);
  }
  
  private static boolean CW(long paramLong)
  {
    AppMethodBeat.i(157606);
    ad.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(paramLong)));
    Iterator localIterator = Idv.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      ah localah = (ah)((Map.Entry)localIterator.next()).getValue();
      if (localah == null) {
        break label162;
      }
      long l3 = bt.aO(localah.hKv);
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
  
  public static void a(b paramb)
  {
    Idx = true;
    fDS = paramb;
  }
  
  public static long fkx()
  {
    AppMethodBeat.i(157603);
    Idy = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(Idv.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ah localah = (ah)Idv.get(localInteger);
      if (localah == null) {
        break label283;
      }
      long l3 = bt.aO(localah.hKv);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localah.interval)
      {
        if ((!localah.Idw.onTimerExpired()) || (!localah.loop)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localah.hKv = bt.HI();
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
        Idv.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!Idy) && (l1 == 9223372036854775807L) && (fDS != null))
      {
        fDS.cancel();
        ad.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      AppMethodBeat.o(157603);
      return l1;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(157601);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(157601);
  }
  
  public final void fky()
  {
    AppMethodBeat.i(157604);
    Idy = true;
    this.interval = 50000L;
    this.hKv = bt.HI();
    boolean bool = CW(this.interval);
    stopTimer();
    Idv.put(Integer.valueOf(this.Idu), this);
    if ((fDS != null) && (bool))
    {
      ad.v("MicroMsg.MAlarmHandler", "prepare bumper");
      fDS.prepare();
    }
    AppMethodBeat.o(157604);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157605);
    Idv.remove(Integer.valueOf(this.Idu));
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