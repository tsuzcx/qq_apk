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

public class MAlarmHandler
{
  private static final int MAX_TIMERID = 8192;
  public static final long NEXT_FIRE_INTERVAL = 9223372036854775807L;
  private static final String TAG = "MicroMsg.MAlarmHandler";
  private static IBumper bumper;
  private static boolean initilized;
  private static Map<Integer, MAlarmHandler> maps;
  private static int timerID;
  private static boolean withNewStart;
  private final CallBack callback;
  private long interval;
  private final boolean loop;
  private final int myTimerID;
  private long ts;
  
  static
  {
    AppMethodBeat.i(157607);
    maps = new HashMap();
    initilized = false;
    AppMethodBeat.o(157607);
  }
  
  public MAlarmHandler(CallBack paramCallBack, boolean paramBoolean)
  {
    AppMethodBeat.i(230326);
    this.ts = 0L;
    this.interval = 0L;
    Assert.assertTrue("bumper not initialized", initilized);
    this.callback = paramCallBack;
    this.loop = paramBoolean;
    this.myTimerID = incTimerID();
    AppMethodBeat.o(230326);
  }
  
  public static long fire()
  {
    AppMethodBeat.i(157603);
    withNewStart = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(maps.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      MAlarmHandler localMAlarmHandler = (MAlarmHandler)maps.get(localInteger);
      if (localMAlarmHandler == null) {
        break label283;
      }
      long l3 = Util.ticksToNow(localMAlarmHandler.ts);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localMAlarmHandler.interval)
      {
        if ((!localMAlarmHandler.callback.onTimerExpired()) || (!localMAlarmHandler.loop)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localMAlarmHandler.ts = Util.currentTicks();
          break;
          l1 = localMAlarmHandler.interval;
        }
      }
      if (localMAlarmHandler.interval - l2 >= l1) {
        break label283;
      }
      l1 = localMAlarmHandler.interval - l2;
    }
    label283:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        maps.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((!withNewStart) && (l1 == 9223372036854775807L) && (bumper != null))
      {
        bumper.cancel();
        Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      AppMethodBeat.o(157603);
      return l1;
    }
  }
  
  private static int incTimerID()
  {
    if (timerID >= 8192) {
      timerID = 0;
    }
    int i = timerID + 1;
    timerID = i;
    return i;
  }
  
  public static void initAlarmBumper(IBumper paramIBumper)
  {
    initilized = true;
    bumper = paramIBumper;
  }
  
  private static boolean needPrepare(long paramLong)
  {
    AppMethodBeat.i(157606);
    Log.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(paramLong)));
    Iterator localIterator = maps.entrySet().iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      MAlarmHandler localMAlarmHandler = (MAlarmHandler)((Map.Entry)localIterator.next()).getValue();
      if (localMAlarmHandler == null) {
        break label162;
      }
      long l3 = Util.ticksToNow(localMAlarmHandler.ts);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localMAlarmHandler.interval)
      {
        l1 = localMAlarmHandler.interval;
      }
      else
      {
        if (localMAlarmHandler.interval - l2 >= l1) {
          break label162;
        }
        l1 = localMAlarmHandler.interval - l2;
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
  
  protected void finalize()
  {
    AppMethodBeat.i(157601);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(157601);
  }
  
  public void startTimer(long paramLong)
  {
    AppMethodBeat.i(230327);
    withNewStart = true;
    this.interval = paramLong;
    this.ts = Util.currentTicks();
    boolean bool = needPrepare(this.interval);
    stopTimer();
    maps.put(Integer.valueOf(this.myTimerID), this);
    if ((bumper != null) && (bool))
    {
      Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
      bumper.prepare();
    }
    AppMethodBeat.o(230327);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(157605);
    maps.remove(Integer.valueOf(this.myTimerID));
    AppMethodBeat.o(157605);
  }
  
  public boolean stopped()
  {
    AppMethodBeat.i(230328);
    if (!maps.containsKey(Integer.valueOf(this.myTimerID)))
    {
      AppMethodBeat.o(230328);
      return true;
    }
    AppMethodBeat.o(230328);
    return false;
  }
  
  public static abstract interface CallBack
  {
    public abstract boolean onTimerExpired();
  }
  
  public static abstract interface IBumper
  {
    public abstract void cancel();
    
    public abstract void prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MAlarmHandler
 * JD-Core Version:    0.7.0.1
 */