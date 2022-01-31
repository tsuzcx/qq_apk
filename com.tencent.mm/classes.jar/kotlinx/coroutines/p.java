package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class p
  extends av
{
  private static final int CHp;
  private static boolean CHq;
  private static volatile Executor CHr;
  public static final p CHs = new p();
  
  static
  {
    AppMethodBeat.i(118569);
    try
    {
      String str = System.getProperty("kotlinx.coroutines.default.parallelism");
      if (str == null)
      {
        i = -1;
        CHp = i;
        AppMethodBeat.o(118569);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        Integer localInteger = m.azu((String)localObject);
        if ((localInteger == null) || (localInteger.intValue() <= 0))
        {
          localObject = (Throwable)new IllegalStateException("Expected positive number in kotlinx.coroutines.default.parallelism, but has ".concat(String.valueOf(localObject)).toString());
          AppMethodBeat.o(118569);
          throw ((Throwable)localObject);
        }
        int i = localInteger.intValue();
      }
    }
  }
  
  private static boolean a(Class<?> paramClass, ExecutorService paramExecutorService)
  {
    AppMethodBeat.i(118564);
    j.q(paramClass, "fjpClass");
    j.q(paramExecutorService, "executor");
    paramExecutorService.submit((Runnable)p.b.CHu);
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
      AppMethodBeat.o(118564);
      return false;
    }
    if (paramClass != null)
    {
      if (paramClass.intValue() <= 0) {
        break label96;
      }
      AppMethodBeat.o(118564);
      return true;
    }
    label96:
    AppMethodBeat.o(118564);
    return false;
  }
  
  private static ExecutorService epu()
  {
    AppMethodBeat.i(118563);
    ExecutorService localExecutorService1;
    if (System.getSecurityManager() != null)
    {
      localExecutorService1 = epv();
      AppMethodBeat.o(118563);
      return localExecutorService1;
    }
    try
    {
      localObject3 = Class.forName("java.util.concurrent.ForkJoinPool");
      if (localObject3 == null)
      {
        localExecutorService1 = epv();
        AppMethodBeat.o(118563);
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
      if ((!CHq) && (CHp < 0)) {
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
          AppMethodBeat.o(118563);
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
        ExecutorService localExecutorService2 = epv();
        AppMethodBeat.o(118563);
        return localExecutorService2;
      }
      if (localObject2 != null)
      {
        AppMethodBeat.o(118563);
        return localObject2;
      }
    }
  }
  
  private static ExecutorService epv()
  {
    AppMethodBeat.i(118565);
    Object localObject = new AtomicInteger();
    localObject = Executors.newFixedThreadPool(getParallelism(), (ThreadFactory)new p.a((AtomicInteger)localObject));
    j.p(localObject, "Executors.newFixedThread…Daemon = true }\n        }");
    AppMethodBeat.o(118565);
    return localObject;
  }
  
  private final Executor epw()
  {
    try
    {
      AppMethodBeat.i(118566);
      Executor localExecutor = CHr;
      Object localObject1 = localExecutor;
      if (localExecutor == null)
      {
        localObject1 = epu();
        CHr = (Executor)localObject1;
        localObject1 = (Executor)localObject1;
      }
      AppMethodBeat.o(118566);
      return localObject1;
    }
    finally {}
  }
  
  private static int getParallelism()
  {
    AppMethodBeat.i(118562);
    Integer localInteger = Integer.valueOf(CHp);
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
      AppMethodBeat.o(118562);
      return i;
      i = 0;
      break;
      label49:
      localInteger = null;
    }
    label54:
    int i = a.i.e.iE(Runtime.getRuntime().availableProcessors() - 1, 1);
    AppMethodBeat.o(118562);
    return i;
  }
  
  public final void a(a.c.e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(118567);
    j.q(parame, "context");
    j.q(paramRunnable, "block");
    try
    {
      Executor localExecutor = CHr;
      parame = localExecutor;
      if (localExecutor == null) {
        parame = epw();
      }
      parame.execute(bs.eqa().aB(paramRunnable));
      AppMethodBeat.o(118567);
      return;
    }
    catch (RejectedExecutionException parame)
    {
      bs.eqa();
      ag.CHJ.aC(paramRunnable);
      AppMethodBeat.o(118567);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(118568);
    Throwable localThrowable = (Throwable)new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    AppMethodBeat.o(118568);
    throw localThrowable;
  }
  
  public final String toString()
  {
    return "CommonPool";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.p
 * JD-Core Version:    0.7.0.1
 */