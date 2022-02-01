package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", "E", "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "subscriberList", "", "Lkotlinx/coroutines/internal/SubscribersList;", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"})
public final class d
{
  private static final Method NJz;
  
  static
  {
    AppMethodBeat.i(118114);
    try
    {
      Method localMethod = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[] { Boolean.TYPE });
      NJz = localMethod;
      AppMethodBeat.o(118114);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public static final boolean b(Executor paramExecutor)
  {
    AppMethodBeat.i(190843);
    for (;;)
    {
      try
      {
        if (!(paramExecutor instanceof ScheduledExecutorService))
        {
          paramExecutor = null;
          paramExecutor = (ScheduledExecutorService)paramExecutor;
          if (paramExecutor == null)
          {
            AppMethodBeat.o(190843);
            return false;
          }
          Method localMethod = NJz;
          if (localMethod == null)
          {
            AppMethodBeat.o(190843);
            return false;
          }
          localMethod.invoke(paramExecutor, new Object[] { Boolean.TRUE });
          AppMethodBeat.o(190843);
          return true;
        }
      }
      catch (Throwable paramExecutor)
      {
        AppMethodBeat.o(190843);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.d
 * JD-Core Version:    0.7.0.1
 */