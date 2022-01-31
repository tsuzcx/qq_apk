package kotlinx.coroutines;

import a.f.b.j;
import a.i.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "_thread", "Ljava/lang/Thread;", "_thread$annotations", "debugStatus", "isCompleted", "", "()Z", "isShutdownRequested", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "isCorrectThread", "notifyStartup", "run", "shutdown", "timeout", "thread", "unpark", "kotlinx-coroutines-core"})
public final class ag
  extends at
  implements Runnable
{
  private static final long CHG;
  private static volatile Thread CHH;
  private static volatile int CHI;
  public static final ag CHJ;
  
  static
  {
    AppMethodBeat.i(118461);
    CHJ = new ag();
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      Long localLong1 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
      j.p(localLong1, "try {\n            java.l…AULT_KEEP_ALIVE\n        }");
      CHG = localTimeUnit.toNanos(localLong1.longValue());
      AppMethodBeat.o(118461);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Long localLong2 = Long.valueOf(1000L);
      }
    }
  }
  
  private final Thread epA()
  {
    AppMethodBeat.i(118456);
    Thread localThread2 = CHH;
    Thread localThread1 = localThread2;
    if (localThread2 == null) {
      localThread1 = epB();
    }
    AppMethodBeat.o(118456);
    return localThread1;
  }
  
  private final Thread epB()
  {
    try
    {
      AppMethodBeat.i(118457);
      Thread localThread2 = CHH;
      Thread localThread1 = localThread2;
      if (localThread2 == null)
      {
        localThread1 = new Thread((Runnable)this, "kotlinx.coroutines.DefaultExecutor");
        CHH = localThread1;
        localThread1.setDaemon(true);
        localThread1.start();
      }
      AppMethodBeat.o(118457);
      return localThread1;
    }
    finally {}
  }
  
  /* Error */
  private final boolean epD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 141	kotlinx/coroutines/ag:epz	()Z
    //   10: ifeq +14 -> 24
    //   13: iconst_0
    //   14: istore_1
    //   15: ldc 138
    //   17: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_1
    //   25: putstatic 143	kotlinx/coroutines/ag:CHI	I
    //   28: aload_0
    //   29: checkcast 145	java/lang/Object
    //   32: invokevirtual 148	java/lang/Object:notifyAll	()V
    //   35: ldc 138
    //   37: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	50	0	this	ag
    //   14	28	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	45	finally
    //   15	20	45	finally
    //   24	40	45	finally
  }
  
  /* Error */
  private final void epE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 150
    //   4: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 141	kotlinx/coroutines/ag:epz	()Z
    //   10: ifne +11 -> 21
    //   13: ldc 150
    //   15: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: iconst_3
    //   22: putstatic 143	kotlinx/coroutines/ag:CHI	I
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 154	kotlinx/coroutines/at:CHW	Ljava/lang/Object;
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 157	kotlinx/coroutines/at:CHY	Ljava/lang/Object;
    //   35: aload_0
    //   36: checkcast 145	java/lang/Object
    //   39: invokevirtual 148	java/lang/Object:notifyAll	()V
    //   42: ldc 150
    //   44: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -29 -> 18
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ag
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	50	finally
    //   21	47	50	finally
  }
  
  private static boolean epz()
  {
    int i = CHI;
    return (i == 2) || (i == 3);
  }
  
  protected final void epC()
  {
    AppMethodBeat.i(118458);
    bs.eqa().unpark(epA());
    AppMethodBeat.o(118458);
  }
  
  public final void run()
  {
    AppMethodBeat.i(118455);
    bs.eqa();
    try
    {
      bool = epD();
      if (bool) {
        break label281;
      }
      return;
    }
    finally
    {
      boolean bool;
      Object localObject1;
      Object localObject2;
      label62:
      label231:
      CHH = null;
      epE();
      bs.eqa();
      if (isEmpty()) {
        break label273;
      }
      epA();
      label273:
      AppMethodBeat.o(118455);
    }
    bs.eqa().parkNanos(this, localObject1);
    long l1 = localObject2;
    for (;;)
    {
      Thread.interrupted();
      long l4 = epM();
      long l2 = l4;
      long l3 = l1;
      if (l4 == 9223372036854775807L)
      {
        if (l1 != 9223372036854775807L) {
          break label231;
        }
        l3 = bs.eqa().nanoTime();
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          l1 = CHG;
          l2 = l1 + l3;
        }
        l1 = l2 - l3;
        if (l1 <= 0L)
        {
          CHH = null;
          epE();
          bs.eqa();
          if (!isEmpty()) {
            epA();
          }
          AppMethodBeat.o(118455);
          return;
        }
        l1 = e.al(l4, l1);
        l3 = l2;
        l2 = l1;
      }
      for (;;)
      {
        l1 = l3;
        if (l2 <= 0L) {
          break label62;
        }
        bool = epz();
        if (!bool) {
          break;
        }
        CHH = null;
        epE();
        bs.eqa();
        if (!isEmpty()) {
          epA();
        }
        AppMethodBeat.o(118455);
        return;
        l2 = e.al(l4, CHG);
        l3 = l1;
      }
      label281:
      l1 = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ag
 * JD-Core Version:    0.7.0.1
 */