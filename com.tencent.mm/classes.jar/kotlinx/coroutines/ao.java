package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.j;
import d.l;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"})
public final class ao
  extends be
  implements Runnable
{
  private static final long Ofk;
  public static final ao Ofl;
  private static volatile Thread _thread;
  private static volatile int debugStatus;
  
  static
  {
    AppMethodBeat.i(118144);
    Object localObject = new ao();
    Ofl = (ao)localObject;
    ((bd)localObject).AH(false);
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      localObject = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
      Ofk = localTimeUnit.toNanos(((Long)localObject).longValue());
      AppMethodBeat.o(118144);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Long localLong = Long.valueOf(1000L);
      }
    }
  }
  
  private static boolean gzI()
  {
    int i = debugStatus;
    return (i == 2) || (i == 3);
  }
  
  private final Thread gzJ()
  {
    try
    {
      AppMethodBeat.i(118140);
      Thread localThread2 = _thread;
      Thread localThread1 = localThread2;
      if (localThread2 == null)
      {
        localThread1 = new Thread((Runnable)this, "kotlinx.coroutines.DefaultExecutor");
        _thread = localThread1;
        localThread1.setDaemon(true);
        localThread1.start();
      }
      AppMethodBeat.o(118140);
      return localThread1;
    }
    finally {}
  }
  
  /* Error */
  private final boolean gzK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 131
    //   4: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 133	kotlinx/coroutines/ao:gzI	()Z
    //   10: ifeq +14 -> 24
    //   13: iconst_0
    //   14: istore_1
    //   15: ldc 131
    //   17: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_1
    //   25: putstatic 112	kotlinx/coroutines/ao:debugStatus	I
    //   28: aload_0
    //   29: checkcast 135	java/lang/Object
    //   32: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   35: ldc 131
    //   37: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_1
    //   41: istore_1
    //   42: goto -22 -> 20
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ao
    //   14	28	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	45	finally
    //   15	20	45	finally
    //   24	40	45	finally
  }
  
  /* Error */
  private final void gzL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 140
    //   4: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 133	kotlinx/coroutines/ao:gzI	()Z
    //   10: ifne +11 -> 21
    //   13: ldc 140
    //   15: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: iconst_3
    //   22: putstatic 112	kotlinx/coroutines/ao:debugStatus	I
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 144	kotlinx/coroutines/be:_queue	Ljava/lang/Object;
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 147	kotlinx/coroutines/be:_delayed	Ljava/lang/Object;
    //   35: aload_0
    //   36: checkcast 135	java/lang/Object
    //   39: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   42: ldc 140
    //   44: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -29 -> 18
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ao
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	50	finally
    //   21	47	50	finally
  }
  
  protected final Thread getThread()
  {
    AppMethodBeat.i(209360);
    Thread localThread2 = _thread;
    Thread localThread1 = localThread2;
    if (localThread2 == null) {
      localThread1 = gzJ();
    }
    AppMethodBeat.o(209360);
    return localThread1;
  }
  
  public final void run()
  {
    AppMethodBeat.i(118138);
    Object localObject3 = ci.Ogn;
    ci.a((bd)this);
    try
    {
      bool = gzK();
      if (bool) {
        break label294;
      }
      return;
    }
    finally
    {
      boolean bool;
      Object localObject2;
      Object localObject1;
      label70:
      label248:
      _thread = null;
      gzL();
      if (isEmpty()) {
        break label286;
      }
      getThread();
      label286:
      AppMethodBeat.o(118138);
    }
    long l1 = localObject2;
    if (ck.Ogo == null)
    {
      LockSupport.parkNanos(this, localObject1);
      l1 = localObject2;
    }
    for (;;)
    {
      Thread.interrupted();
      long l4 = gzT();
      long l2 = l4;
      long l3 = l1;
      if (l4 == 9223372036854775807L)
      {
        if (l1 != 9223372036854775807L) {
          break label248;
        }
        localObject3 = ck.Ogo;
        if (localObject3 != null) {}
        for (l3 = ((cj)localObject3).nanoTime();; l3 = System.nanoTime())
        {
          l2 = l1;
          if (l1 == 9223372036854775807L)
          {
            l1 = Ofk;
            l2 = l1 + l3;
          }
          l1 = l2 - l3;
          if (l1 > 0L) {
            break;
          }
          _thread = null;
          gzL();
          if (!isEmpty()) {
            getThread();
          }
          AppMethodBeat.o(118138);
          return;
        }
        l1 = j.aH(l4, l1);
        l3 = l2;
        l2 = l1;
      }
      for (;;)
      {
        l1 = l3;
        if (l2 <= 0L) {
          break label70;
        }
        bool = gzI();
        if (!bool) {
          break;
        }
        _thread = null;
        gzL();
        if (!isEmpty()) {
          getThread();
        }
        AppMethodBeat.o(118138);
        return;
        l2 = j.aH(l4, Ofk);
        l3 = l1;
      }
      label294:
      l1 = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ao
 * JD-Core Version:    0.7.0.1
 */