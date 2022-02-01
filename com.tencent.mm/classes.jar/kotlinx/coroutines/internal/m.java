package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.m.i;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.bz;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"})
public final class m
{
  private static final boolean NJV;
  public static final bz NJW;
  public static final m NJX;
  
  static
  {
    AppMethodBeat.i(190835);
    NJX = new m();
    NJV = w.bdk("kotlinx.coroutines.fast.service.loader");
    NJW = gwf();
    AppMethodBeat.o(190835);
  }
  
  private static bz gwf()
  {
    AppMethodBeat.i(190834);
    for (;;)
    {
      try
      {
        if (!NJV) {
          continue;
        }
        localObject1 = f.NJG;
        localList = f.gvW();
        localIterator = ((Iterable)localList).iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        localObject2 = null;
        localObject1 = (MainDispatcherFactory)localObject2;
        if (localObject1 != null)
        {
          localObject2 = n.a((MainDispatcherFactory)localObject1, localList);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (bz)n.b(null, 3);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        List localList;
        Iterator localIterator;
        Object localObject2;
        int i;
        bz localbz = (bz)n.b(localThrowable, 2);
        continue;
        continue;
      }
      AppMethodBeat.o(190834);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.m
 * JD-Core Version:    0.7.0.1
 */