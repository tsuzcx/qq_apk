package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends bn
  implements Runnable
{
  private static volatile Thread _thread;
  public static final aw ajvR;
  private static final long ajvS;
  private static volatile int debugStatus;
  
  static
  {
    AppMethodBeat.i(118144);
    Object localObject = new aw();
    ajvR = (aw)localObject;
    bm.a((bm)localObject);
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      localObject = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
      ajvS = localTimeUnit.toNanos(((Long)localObject).longValue());
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
  
  private static boolean kCb()
  {
    int i = debugStatus;
    return (i == 2) || (i == 3);
  }
  
  /* Error */
  private final Thread kCc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 123	kotlinx/coroutines/aw:_thread	Ljava/lang/Thread;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +39 -> 51
    //   15: new 125	java/lang/Thread
    //   18: dup
    //   19: aload_0
    //   20: checkcast 6	java/lang/Runnable
    //   23: ldc 127
    //   25: invokespecial 130	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: putstatic 123	kotlinx/coroutines/aw:_thread	Ljava/lang/Thread;
    //   33: aload_1
    //   34: iconst_1
    //   35: invokevirtual 134	java/lang/Thread:setDaemon	(Z)V
    //   38: aload_1
    //   39: invokevirtual 137	java/lang/Thread:start	()V
    //   42: ldc 121
    //   44: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: ldc 121
    //   53: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -9 -> 47
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	aw
    //   10	40	1	localThread	Thread
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   15	47	59	finally
    //   51	56	59	finally
  }
  
  /* Error */
  private final boolean kCd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 139
    //   4: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 141	kotlinx/coroutines/aw:kCb	()Z
    //   10: ifeq +14 -> 24
    //   13: iconst_0
    //   14: istore_1
    //   15: ldc 139
    //   17: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_1
    //   25: putstatic 119	kotlinx/coroutines/aw:debugStatus	I
    //   28: aload_0
    //   29: checkcast 143	java/lang/Object
    //   32: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   35: ldc 139
    //   37: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	50	0	this	aw
    //   14	28	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	45	finally
    //   15	20	45	finally
    //   24	40	45	finally
  }
  
  /* Error */
  private final void kCe()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 148
    //   4: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 141	kotlinx/coroutines/aw:kCb	()Z
    //   10: ifne +11 -> 21
    //   13: ldc 148
    //   15: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: iconst_3
    //   22: putstatic 119	kotlinx/coroutines/aw:debugStatus	I
    //   25: aload_0
    //   26: invokevirtual 151	kotlinx/coroutines/aw:kCp	()V
    //   29: aload_0
    //   30: checkcast 143	java/lang/Object
    //   33: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   36: ldc 148
    //   38: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -23 -> 18
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	aw
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	44	finally
    //   21	41	44	finally
  }
  
  public final bi a(long paramLong, Runnable paramRunnable, f paramf)
  {
    AppMethodBeat.i(188900);
    paramLong = bp.BL(paramLong);
    if (paramLong < 4611686018427387903L)
    {
      if (c.ajvf == null)
      {
        long l = System.nanoTime();
        paramRunnable = new bn.b(paramLong + l, paramRunnable);
        a(l, (bn.c)paramRunnable);
        paramRunnable = (bi)paramRunnable;
        AppMethodBeat.o(188900);
        return paramRunnable;
      }
      AppMethodBeat.o(188900);
      throw null;
    }
    paramRunnable = (bi)co.ajwK;
    AppMethodBeat.o(188900);
    return paramRunnable;
  }
  
  protected final Thread getThread()
  {
    AppMethodBeat.i(188893);
    Thread localThread = _thread;
    if (localThread == null)
    {
      localThread = kCc();
      AppMethodBeat.o(188893);
      return localThread;
    }
    AppMethodBeat.o(188893);
    return localThread;
  }
  
  public final void run()
  {
    AppMethodBeat.i(118138);
    cz localcz = cz.ajwN;
    cz.c((bm)this);
    boolean bool;
    try
    {
      bool = kCd();
      if (bool) {
        break label256;
      }
      return;
    }
    finally
    {
      Object localObject1;
      Object localObject2;
      _thread = null;
      kCe();
      if (isEmpty()) {
        break label188;
      }
      getThread();
      AppMethodBeat.o(118138);
    }
    long l1 = localObject1;
    if (c.ajvf == null)
    {
      LockSupport.parkNanos(this, localObject2);
      l1 = localObject1;
    }
    for (;;)
    {
      label70:
      Thread.interrupted();
      long l3 = kCk();
      long l2;
      if (l3 == 9223372036854775807L)
      {
        if (c.ajvf == null)
        {
          long l4 = System.nanoTime();
          l2 = l1;
          if (l1 == 9223372036854775807L)
          {
            l1 = ajvS;
            l2 = l1 + l4;
          }
          l1 = l2 - l4;
          if (l1 <= 0L)
          {
            _thread = null;
            kCe();
            if (!isEmpty()) {
              getThread();
            }
            AppMethodBeat.o(118138);
          }
        }
        else
        {
          AppMethodBeat.o(118138);
          throw null;
        }
        label188:
        l3 = k.bS(l3, l1);
      }
      for (;;)
      {
        l1 = l2;
        if (l3 <= 0L) {
          break label70;
        }
        bool = kCb();
        if (!bool) {
          break;
        }
        _thread = null;
        kCe();
        if (!isEmpty()) {
          getThread();
        }
        AppMethodBeat.o(118138);
        return;
        l2 = 9223372036854775807L;
      }
      label256:
      l1 = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.aw
 * JD-Core Version:    0.7.0.1
 */