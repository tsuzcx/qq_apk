package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.m.i;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.br;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"})
public final class w
{
  private static final boolean LEE;
  public static final br LEF;
  public static final w LEG;
  
  static
  {
    AppMethodBeat.i(202365);
    LEG = new w();
    LEE = p.aWl("kotlinx.coroutines.fast.service.loader");
    LEF = gaK();
    AppMethodBeat.o(202365);
  }
  
  private static br gaK()
  {
    AppMethodBeat.i(202364);
    for (;;)
    {
      try
      {
        if (!LEE) {
          continue;
        }
        localObject1 = u.LEC;
        localList = u.gaI();
        localIterator = ((Iterable)localList).iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        localObject2 = null;
        localObject1 = (MainDispatcherFactory)localObject2;
        if (localObject1 != null)
        {
          localObject2 = x.a((MainDispatcherFactory)localObject1, localList);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (br)x.b(null, 3);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        List localList;
        Iterator localIterator;
        Object localObject2;
        int i;
        br localbr = (br)x.b(localThrowable, 2);
        continue;
        continue;
      }
      AppMethodBeat.o(202364);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.w
 * JD-Core Version:    0.7.0.1
 */