package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.m.i;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.bw;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"})
public final class l
{
  private static final boolean LSY;
  public static final bw LSZ;
  public static final l LTa;
  
  static
  {
    AppMethodBeat.i(191224);
    LTa = new l();
    LSY = v.aXh("kotlinx.coroutines.fast.service.loader");
    LSZ = geG();
    AppMethodBeat.o(191224);
  }
  
  private static bw geG()
  {
    AppMethodBeat.i(191223);
    for (;;)
    {
      try
      {
        if (!LSY) {
          continue;
        }
        localObject1 = e.LSJ;
        localList = e.gex();
        localIterator = ((Iterable)localList).iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        localObject2 = null;
        localObject1 = (MainDispatcherFactory)localObject2;
        if (localObject1 != null)
        {
          localObject2 = m.a((MainDispatcherFactory)localObject1, localList);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (bw)m.b(null, 3);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        List localList;
        Iterator localIterator;
        Object localObject2;
        int i;
        bw localbw = (bw)m.b(localThrowable, 2);
        continue;
        continue;
      }
      AppMethodBeat.o(191223);
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
 * Qualified Name:     kotlinx.coroutines.internal.l
 * JD-Core Version:    0.7.0.1
 */