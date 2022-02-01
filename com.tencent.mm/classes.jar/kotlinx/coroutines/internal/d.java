package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", "E", "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "subscriberList", "", "Lkotlinx/coroutines/internal/SubscribersList;", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final Method ajAi;
  
  static
  {
    AppMethodBeat.i(118114);
    try
    {
      Method localMethod = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[] { Boolean.TYPE });
      ajAi = localMethod;
      AppMethodBeat.o(118114);
      return;
    }
    finally
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public static final boolean h(Executor paramExecutor)
  {
    AppMethodBeat.i(189404);
    for (;;)
    {
      Method localMethod;
      try
      {
        if (!(paramExecutor instanceof ScheduledThreadPoolExecutor)) {
          break label74;
        }
        paramExecutor = (ScheduledThreadPoolExecutor)paramExecutor;
        if (paramExecutor == null)
        {
          AppMethodBeat.o(189404);
          return false;
        }
        localMethod = ajAi;
        if (localMethod != null) {}
      }
      finally
      {
        AppMethodBeat.o(189404);
        return false;
      }
      localMethod.invoke(paramExecutor, new Object[] { Boolean.TRUE });
      AppMethodBeat.o(189404);
      return true;
      label74:
      paramExecutor = null;
    }
  }
  
  public static final <E> List<E> kDO()
  {
    AppMethodBeat.i(189395);
    List localList = (List)new CopyOnWriteArrayList();
    AppMethodBeat.o(189395);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.d
 * JD-Core Version:    0.7.0.1
 */