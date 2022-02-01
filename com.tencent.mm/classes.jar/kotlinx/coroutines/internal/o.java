package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.l;
import kotlin.m.i;
import kotlinx.coroutines.ci;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"})
public final class o
{
  private static final boolean abzq;
  public static final ci abzr;
  public static final o abzs;
  
  static
  {
    AppMethodBeat.i(204990);
    abzs = new o();
    abzq = y.bHG("kotlinx.coroutines.fast.service.loader");
    abzr = iSU();
    AppMethodBeat.o(204990);
  }
  
  private static ci iSU()
  {
    AppMethodBeat.i(204989);
    for (;;)
    {
      try
      {
        if (!abzq) {
          continue;
        }
        localObject1 = g.abzb;
        localList = g.iSH();
        localIterator = ((Iterable)localList).iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        localObject2 = null;
        localObject1 = (MainDispatcherFactory)localObject2;
        if (localObject1 != null)
        {
          localObject2 = p.a((MainDispatcherFactory)localObject1, localList);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (ci)p.b(null, 3);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        List localList;
        Iterator localIterator;
        Object localObject2;
        int i;
        ci localci = (ci)p.b(localThrowable, 2);
        continue;
        continue;
      }
      AppMethodBeat.o(204989);
      return localObject1;
      localList = i.c(i.d(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
      continue;
      localObject1 = localIterator.next();
      if (localIterator.hasNext()) {
        continue;
      }
      localObject2 = localObject1;
    }
    i = ((MainDispatcherFactory)localObject1).getLoadPriority();
    for (;;)
    {
      localObject2 = localIterator.next();
      int j = ((MainDispatcherFactory)localObject2).getLoadPriority();
      if (i >= j) {
        break label206;
      }
      localObject1 = localObject2;
      i = j;
      boolean bool = localIterator.hasNext();
      localObject2 = localObject1;
      if (!bool) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.o
 * JD-Core Version:    0.7.0.1
 */