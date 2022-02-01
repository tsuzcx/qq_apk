package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"})
public final class ar
  extends bj
  implements Runnable
{
  private static volatile Thread _thread;
  private static final long abwI;
  public static final ar abwJ;
  private static volatile int debugStatus;
  
  static
  {
    AppMethodBeat.i(118144);
    Object localObject = new ar();
    abwJ = (ar)localObject;
    bi.a((bi)localObject);
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      localObject = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
      abwI = localTimeUnit.toNanos(((Long)localObject).longValue());
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
  
  private static boolean iRj()
  {
    int i = debugStatus;
    return (i == 2) || (i == 3);
  }
  
  private final Thread iRk()
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
  private final boolean iRl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 134
    //   4: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 136	kotlinx/coroutines/ar:iRj	()Z
    //   10: ifeq +14 -> 24
    //   13: iconst_0
    //   14: istore_1
    //   15: ldc 134
    //   17: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_1
    //   25: putstatic 114	kotlinx/coroutines/ar:debugStatus	I
    //   28: aload_0
    //   29: checkcast 138	java/lang/Object
    //   32: invokevirtual 141	java/lang/Object:notifyAll	()V
    //   35: ldc 134
    //   37: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	50	0	this	ar
    //   14	28	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	45	finally
    //   15	20	45	finally
    //   24	40	45	finally
  }
  
  /* Error */
  private final void iRm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 143
    //   4: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 136	kotlinx/coroutines/ar:iRj	()Z
    //   10: ifne +11 -> 21
    //   13: ldc 143
    //   15: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: iconst_3
    //   22: putstatic 114	kotlinx/coroutines/ar:debugStatus	I
    //   25: aload_0
    //   26: invokevirtual 146	kotlinx/coroutines/ar:iRy	()V
    //   29: aload_0
    //   30: checkcast 138	java/lang/Object
    //   33: invokevirtual 141	java/lang/Object:notifyAll	()V
    //   36: ldc 143
    //   38: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -23 -> 18
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	ar
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	44	finally
    //   21	41	44	finally
  }
  
  public final be d(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(204253);
    long l = bl.XB(paramLong);
    if (l < 4611686018427387903L)
    {
      cw localcw = cx.abxP;
      if (localcw != null) {}
      for (paramLong = localcw.nanoTime();; paramLong = System.nanoTime())
      {
        paramRunnable = new bj.b(l + paramLong, paramRunnable);
        a(paramLong, (bj.c)paramRunnable);
        paramRunnable = (be)paramRunnable;
        AppMethodBeat.o(204253);
        return paramRunnable;
      }
    }
    paramRunnable = (be)ck.abxK;
    AppMethodBeat.o(204253);
    return paramRunnable;
  }
  
  protected final Thread getThread()
  {
    AppMethodBeat.i(204252);
    Thread localThread2 = _thread;
    Thread localThread1 = localThread2;
    if (localThread2 == null) {
      localThread1 = iRk();
    }
    AppMethodBeat.o(204252);
    return localThread1;
  }
  
  public final void run()
  {
    AppMethodBeat.i(118138);
    Object localObject3 = cv.abxO;
    cv.c((bi)this);
    try
    {
      bool = iRl();
      if (bool) {
        break label269;
      }
      return;
    }
    finally
    {
      boolean bool;
      Object localObject1;
      Object localObject2;
      label70:
      _thread = null;
      iRm();
      if (isEmpty()) {
        break label261;
      }
      getThread();
      label261:
      AppMethodBeat.o(118138);
    }
    long l1 = localObject1;
    if (cx.abxP == null)
    {
      LockSupport.parkNanos(this, localObject2);
      l1 = localObject1;
    }
    for (;;)
    {
      Thread.interrupted();
      long l4 = iRu();
      long l2;
      if (l4 == 9223372036854775807L)
      {
        localObject3 = cx.abxP;
        if (localObject3 != null) {}
        for (l3 = ((cw)localObject3).nanoTime();; l3 = System.nanoTime())
        {
          l2 = l1;
          if (l1 == 9223372036854775807L)
          {
            l1 = abwI;
            l2 = l1 + l3;
          }
          l1 = l2 - l3;
          if (l1 > 0L) {
            break;
          }
          _thread = null;
          iRm();
          if (!isEmpty()) {
            getThread();
          }
          AppMethodBeat.o(118138);
          return;
        }
      }
      for (long l3 = i.bf(l4, l1);; l3 = l4)
      {
        l1 = l2;
        if (l3 <= 0L) {
          break label70;
        }
        bool = iRj();
        if (!bool) {
          break;
        }
        _thread = null;
        iRm();
        if (!isEmpty()) {
          getThread();
        }
        AppMethodBeat.o(118138);
        return;
        l2 = 9223372036854775807L;
      }
      label269:
      l1 = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ar
 * JD-Core Version:    0.7.0.1
 */