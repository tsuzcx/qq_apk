package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.k.h;
import d.l;
import d.n.n;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class t
  extends bh
{
  private static final int NHI;
  private static boolean NHJ;
  public static final t NHK = new t();
  private static volatile Executor pool;
  
  static
  {
    AppMethodBeat.i(118258);
    try
    {
      String str = System.getProperty("kotlinx.coroutines.default.parallelism");
      if (str == null)
      {
        i = -1;
        NHI = i;
        AppMethodBeat.o(118258);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        Integer localInteger = n.bdh((String)localObject);
        if ((localInteger == null) || (localInteger.intValue() <= 0))
        {
          localObject = (Throwable)new IllegalStateException("Expected positive number in kotlinx.coroutines.default.parallelism, but has ".concat(String.valueOf(localObject)).toString());
          AppMethodBeat.o(118258);
          throw ((Throwable)localObject);
        }
        int i = localInteger.intValue();
      }
    }
  }
  
  private static boolean a(Class<?> paramClass, ExecutorService paramExecutorService)
  {
    AppMethodBeat.i(118253);
    paramExecutorService.submit((Runnable)b.NHM);
    try
    {
      paramExecutorService = paramClass.getMethod("getPoolSize", new Class[0]).invoke(paramExecutorService, new Object[0]);
      paramClass = paramExecutorService;
      if (!(paramExecutorService instanceof Integer)) {
        paramClass = null;
      }
      paramClass = (Integer)paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
      AppMethodBeat.o(118253);
      return false;
    }
    if (paramClass != null)
    {
      if (paramClass.intValue() <= 0) {
        break label84;
      }
      AppMethodBeat.o(118253);
      return true;
    }
    label84:
    AppMethodBeat.o(118253);
    return false;
  }
  
  private static int getParallelism()
  {
    AppMethodBeat.i(118251);
    Integer localInteger = Integer.valueOf(NHI);
    if (((Number)localInteger).intValue() > 0)
    {
      i = 1;
      if (i == 0) {
        break label49;
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label54;
      }
      i = localInteger.intValue();
      AppMethodBeat.o(118251);
      return i;
      i = 0;
      break;
      label49:
      localInteger = null;
    }
    label54:
    int i = h.lp(Runtime.getRuntime().availableProcessors() - 1, 1);
    AppMethodBeat.o(118251);
    return i;
  }
  
  private static ExecutorService guV()
  {
    AppMethodBeat.i(118252);
    ExecutorService localExecutorService1;
    if (System.getSecurityManager() != null)
    {
      localExecutorService1 = guW();
      AppMethodBeat.o(118252);
      return localExecutorService1;
    }
    try
    {
      localObject3 = Class.forName("java.util.concurrent.ForkJoinPool");
      if (localObject3 == null)
      {
        localExecutorService1 = guW();
        AppMethodBeat.o(118252);
        return localExecutorService1;
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject3;
      for (;;)
      {
        localObject3 = null;
      }
      if ((!NHJ) && (NHI < 0)) {
        for (;;)
        {
          try
          {
            localObject1 = ((Class)localObject3).getMethod("commonPool", new Class[0]);
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
            Object localObject4 = localObject1;
            if (!(localObject1 instanceof ExecutorService)) {
              localObject4 = null;
            }
            localObject1 = (ExecutorService)localObject4;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject1;
            localObject2 = null;
            continue;
            localObject2 = null;
            continue;
          }
          if (localObject1 == null) {
            break label141;
          }
          if (!a((Class)localObject3, (ExecutorService)localObject1)) {
            continue;
          }
          if (localObject1 == null) {
            break label141;
          }
          AppMethodBeat.o(118252);
          return localObject1;
          localObject1 = null;
        }
      }
      try
      {
        label141:
        localObject3 = ((Class)localObject3).getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(getParallelism()) });
        localObject2 = localObject3;
        if (!(localObject3 instanceof ExecutorService)) {
          localObject2 = null;
        }
        localObject2 = (ExecutorService)localObject2;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          Object localObject2;
          localExecutorService2 = null;
        }
        ExecutorService localExecutorService2 = guW();
        AppMethodBeat.o(118252);
        return localExecutorService2;
      }
      if (localObject2 != null)
      {
        AppMethodBeat.o(118252);
        return localObject2;
      }
    }
  }
  
  private static ExecutorService guW()
  {
    AppMethodBeat.i(118254);
    Object localObject = new AtomicInteger();
    localObject = Executors.newFixedThreadPool(getParallelism(), (ThreadFactory)new a((AtomicInteger)localObject));
    AppMethodBeat.o(118254);
    return localObject;
  }
  
  private final Executor guX()
  {
    try
    {
      AppMethodBeat.i(118255);
      Executor localExecutor = pool;
      Object localObject1 = localExecutor;
      if (localExecutor == null)
      {
        localObject1 = guV();
        pool = (Executor)localObject1;
        localObject1 = (Executor)localObject1;
      }
      AppMethodBeat.o(118255);
      return localObject1;
    }
    finally {}
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118256);
    for (;;)
    {
      try
      {
        paramf = pool;
        if (paramf == null)
        {
          paramf = guX();
          localObject = ck.NJi;
          if (localObject == null) {
            break label75;
          }
          Runnable localRunnable = ((cj)localObject).gvS();
          localObject = localRunnable;
          if (localRunnable == null) {
            break label75;
          }
          paramf.execute((Runnable)localObject);
          AppMethodBeat.o(118256);
          return;
        }
      }
      catch (RejectedExecutionException paramf)
      {
        ao.NIf.aW(paramRunnable);
        AppMethodBeat.o(118256);
        return;
      }
      continue;
      label75:
      Object localObject = paramRunnable;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(118257);
    Throwable localThrowable = (Throwable)new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    AppMethodBeat.o(118257);
    throw localThrowable;
  }
  
  public final Executor getExecutor()
  {
    AppMethodBeat.i(190764);
    Executor localExecutor2 = pool;
    Executor localExecutor1 = localExecutor2;
    if (localExecutor2 == null) {
      localExecutor1 = guX();
    }
    AppMethodBeat.o(190764);
    return localExecutor1;
  }
  
  public final String toString()
  {
    return "CommonPool";
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/Thread;", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"})
  static final class a
    implements ThreadFactory
  {
    a(AtomicInteger paramAtomicInteger) {}
    
    public final Thread newThread(Runnable paramRunnable)
    {
      AppMethodBeat.i(118209);
      paramRunnable = new Thread(paramRunnable, "CommonPool-worker-" + this.NHL.incrementAndGet());
      paramRunnable.setDaemon(true);
      AppMethodBeat.o(118209);
      return paramRunnable;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b NHM;
    
    static
    {
      AppMethodBeat.i(118054);
      NHM = new b();
      AppMethodBeat.o(118054);
    }
    
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.t
 * JD-Core Version:    0.7.0.1
 */