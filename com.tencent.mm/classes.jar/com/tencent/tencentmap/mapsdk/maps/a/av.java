package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class av
{
  private static av a;
  private Timer b;
  private Map<Runnable, TimerTask> c;
  
  static
  {
    AppMethodBeat.i(147258);
    a = new av();
    AppMethodBeat.o(147258);
  }
  
  private av()
  {
    AppMethodBeat.i(147253);
    this.c = new ConcurrentHashMap();
    this.b = new Timer("halley_" + ac.c() + "_" + "ConnectionTimer", true);
    AppMethodBeat.o(147253);
  }
  
  public static av a()
  {
    return a;
  }
  
  /* Error */
  private void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 76	com/tencent/tencentmap/mapsdk/maps/a/av:a	(Ljava/lang/Runnable;)Z
    //   12: pop
    //   13: new 78	com/tencent/tencentmap/mapsdk/maps/a/aw
    //   16: dup
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 81	com/tencent/tencentmap/mapsdk/maps/a/aw:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/av;Ljava/lang/Runnable;)V
    //   22: astore 5
    //   24: iload_2
    //   25: ifeq +35 -> 60
    //   28: aload_0
    //   29: getfield 70	com/tencent/tencentmap/mapsdk/maps/a/av:b	Ljava/util/Timer;
    //   32: aload 5
    //   34: lload_3
    //   35: lload_3
    //   36: invokevirtual 85	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   39: aload_0
    //   40: getfield 36	com/tencent/tencentmap/mapsdk/maps/a/av:c	Ljava/util/Map;
    //   43: aload_1
    //   44: aload 5
    //   46: invokeinterface 91 3 0
    //   51: pop
    //   52: aload_1
    //   53: monitorexit
    //   54: ldc 73
    //   56: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: aload_0
    //   61: getfield 70	com/tencent/tencentmap/mapsdk/maps/a/av:b	Ljava/util/Timer;
    //   64: aload 5
    //   66: lload_3
    //   67: invokevirtual 94	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   70: goto -31 -> 39
    //   73: astore 5
    //   75: aload_1
    //   76: monitorexit
    //   77: ldc 73
    //   79: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload 5
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	av
    //   0	85	1	paramRunnable	Runnable
    //   0	85	2	paramBoolean	boolean
    //   0	85	3	paramLong	long
    //   22	43	5	localaw	aw
    //   73	10	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	24	73	finally
    //   28	39	73	finally
    //   39	54	73	finally
    //   60	70	73	finally
    //   75	77	73	finally
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(147254);
    a(paramRunnable, false, paramLong);
    AppMethodBeat.o(147254);
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    AppMethodBeat.i(147257);
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
    finally
    {
      AppMethodBeat.o(147257);
    }
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(147255);
    a(paramRunnable, true, paramLong);
    AppMethodBeat.o(147255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.av
 * JD-Core Version:    0.7.0.1
 */