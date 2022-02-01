package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.l;
import kotlin.m.i;
import kotlinx.coroutines.ce;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"})
public final class n
{
  private static final boolean TVZ;
  public static final ce TWa;
  public static final n TWb;
  
  static
  {
    AppMethodBeat.i(192470);
    TWb = new n();
    TVZ = x.buD("kotlinx.coroutines.fast.service.loader");
    TWa = hNO();
    AppMethodBeat.o(192470);
  }
  
  private static ce hNO()
  {
    AppMethodBeat.i(192469);
    for (;;)
    {
      try
      {
        if (!TVZ) {
          continue;
        }
        localObject1 = g.TVK;
        localList = g.hNF();
        localIterator = ((Iterable)localList).iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        localObject2 = null;
        localObject1 = (MainDispatcherFactory)localObject2;
        if (localObject1 != null)
        {
          localObject2 = o.a((MainDispatcherFactory)localObject1, localList);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (ce)o.b(null, 3);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        List localList;
        Iterator localIterator;
        Object localObject2;
        int i;
        ce localce = (ce)o.b(localThrowable, 2);
        continue;
        continue;
      }
      AppMethodBeat.o(192469);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.n
 * JD-Core Version:    0.7.0.1
 */