package com.tencent.tencentmap.mapsdk.a;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class fg
{
  private static fg a = new fg();
  private Timer b = new Timer("halley_" + em.c() + "_" + "ConnectionTimer", true);
  private Map<Runnable, TimerTask> c = new ConcurrentHashMap();
  
  public static fg a()
  {
    return a;
  }
  
  /* Error */
  private void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 64	com/tencent/tencentmap/mapsdk/a/fg:a	(Ljava/lang/Runnable;)Z
    //   7: pop
    //   8: new 66	com/tencent/tencentmap/mapsdk/a/fh
    //   11: dup
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 69	com/tencent/tencentmap/mapsdk/a/fh:<init>	(Lcom/tencent/tencentmap/mapsdk/a/fg;Ljava/lang/Runnable;)V
    //   17: astore 5
    //   19: iload_2
    //   20: ifeq +30 -> 50
    //   23: aload_0
    //   24: getfield 59	com/tencent/tencentmap/mapsdk/a/fg:b	Ljava/util/Timer;
    //   27: aload 5
    //   29: lload_3
    //   30: lload_3
    //   31: invokevirtual 73	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   34: aload_0
    //   35: getfield 25	com/tencent/tencentmap/mapsdk/a/fg:c	Ljava/util/Map;
    //   38: aload_1
    //   39: aload 5
    //   41: invokeinterface 79 3 0
    //   46: pop
    //   47: aload_1
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 59	com/tencent/tencentmap/mapsdk/a/fg:b	Ljava/util/Timer;
    //   54: aload 5
    //   56: lload_3
    //   57: invokevirtual 82	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   60: goto -26 -> 34
    //   63: astore 5
    //   65: aload_1
    //   66: monitorexit
    //   67: aload 5
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	fg
    //   0	70	1	paramRunnable	Runnable
    //   0	70	2	paramBoolean	boolean
    //   0	70	3	paramLong	long
    //   17	38	5	localfh	fh
    //   63	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	63	finally
    //   23	34	63	finally
    //   34	49	63	finally
    //   50	60	63	finally
    //   65	67	63	finally
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, false, paramLong);
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    try
    {
      TimerTask localTimerTask = (TimerTask)this.c.get(paramRunnable);
      if (localTimerTask != null)
      {
        this.c.remove(paramRunnable);
        boolean bool = localTimerTask.cancel();
        return bool;
      }
      return true;
    }
    finally {}
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, true, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fg
 * JD-Core Version:    0.7.0.1
 */