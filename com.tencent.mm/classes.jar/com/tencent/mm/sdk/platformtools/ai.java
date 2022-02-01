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

public final class ai
{
  private static int IxE;
  private static Map<Integer, ai> IxG;
  private static boolean IxI;
  private static boolean IxJ;
  private static b fFW;
  private final int IxF;
  private final a IxH;
  private long hNo;
  private long interval;
  private final boolean loop;
  
  static
  {
    AppMethodBeat.i(157607);
    IxG = new HashMap();
    IxI = false;
    AppMethodBeat.o(157607);
  }
  
  public ai(a parama)
  {
    AppMethodBeat.i(157602);
    this.hNo = 0L;
    this.interval = 0L;
    Assert.assertTrue("bumper not initialized", IxI);
    this.IxH = parama;
    this.loop = true;
    if (IxE >= 8192) {
      IxE = 0;
    }
    int i = IxE + 1;
    IxE = i;
    this.IxF = i;
    AppMethodBeat.o(157602);
  }
  
  private static boolean Du(long paramLong)
  {
    AppMethodBeat.i(157606);
    ae.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(paramLong)));
    Iterator localIterator = IxG.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      ai localai = (ai)((Map.Entry)localIterator.next()).getValue();
      if (localai == null) {
        break label162;
      }
      long l3 = bu.aO(localai.hNo);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localai.interval)
      {
        l1 = localai.interval;
      }
      else
      {
        if (localai.interval - l2 >= l1) {
          break label162;
        }
        l1 = localai.interval - l2;
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
    IxI = true;
    fFW = paramb;
  }
  
  public static long jdMethod_for()
  {
    AppMethodBeat.i(157603);
    IxJ = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(IxG.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ai localai = (ai)IxG.get(localInteger);
      if (localai == null) {
        break label283;
      }
      long l3 = bu.aO(localai.hNo);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localai.interval)
      {
        if ((!localai.IxH.onTimerExpired()) || (!localai.loop)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localai.hNo = bu.HQ();
          break;
          l1 = localai.interval;
        }
      }
      if (localai.interval - l2 >= l1) {
        break label283;
      }
      l1 = localai.interval - l2;
    }
    label283:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        IxG.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!IxJ) && (l1 == 9223372036854775807L) && (fFW != null))
      {
        fFW.cancel();
        ae.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
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
  
  public final void fos()
  {
    AppMethodBeat.i(157604);
    IxJ = true;
    this.interval = 50000L;
    this.hNo = bu.HQ();
    boolean bool = Du(this.interval);
    stopTimer();
    IxG.put(Integer.valueOf(this.IxF), this);
    if ((fFW != null) && (bool))
    {
      ae.v("MicroMsg.MAlarmHandler", "prepare bumper");
      fFW.prepare();
    }
    AppMethodBeat.o(157604);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157605);
    IxG.remove(Integer.valueOf(this.IxF));
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ai
 * JD-Core Version:    0.7.0.1
 */