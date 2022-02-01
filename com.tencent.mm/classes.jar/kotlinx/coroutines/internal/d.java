package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", "E", "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "subscriberList", "", "Lkotlinx/coroutines/internal/SubscribersList;", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"})
public final class d
{
  private static final Method abyT;
  
  static
  {
    AppMethodBeat.i(118114);
    try
    {
      Method localMethod = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[] { Boolean.TYPE });
      abyT = localMethod;
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
    AppMethodBeat.i(205101);
    for (;;)
    {
      try
      {
        if (!(paramExecutor instanceof ScheduledThreadPoolExecutor))
        {
          paramExecutor = null;
          paramExecutor = (ScheduledThreadPoolExecutor)paramExecutor;
          if (paramExecutor == null)
          {
            AppMethodBeat.o(205101);
            return false;
          }
          Method localMethod = abyT;
          if (localMethod == null)
          {
            AppMethodBeat.o(205101);
            return false;
          }
          localMethod.invoke(paramExecutor, new Object[] { Boolean.TRUE });
          AppMethodBeat.o(205101);
          return true;
        }
      }
      catch (Throwable paramExecutor)
      {
        AppMethodBeat.o(205101);
        return false;
      }
    }
  }
  
  public static final <E> List<E> iSG()
  {
    AppMethodBeat.i(205100);
    List localList = (List)new CopyOnWriteArrayList();
    AppMethodBeat.o(205100);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.internal.d
 * JD-Core Version:    0.7.0.1
 */