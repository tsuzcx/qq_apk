package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s ajAH;
  private static final boolean ajAI;
  public static final cm ajAJ;
  
  static
  {
    AppMethodBeat.i(189409);
    ajAH = new s();
    ajAI = af.bJM("kotlinx.coroutines.fast.service.loader");
    ajAJ = kEj();
    AppMethodBeat.o(189409);
  }
  
  private static cm kEj()
  {
    AppMethodBeat.i(189398);
    for (;;)
    {
      try
      {
        if (!ajAI) {
          continue;
        }
        localObject1 = k.ajAu;
        localList = k.kDW();
        localIterator = ((Iterable)localList).iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        localObject2 = null;
        localObject1 = (MainDispatcherFactory)localObject2;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = (cm)t.b(null, 3);
      }
      finally
      {
        Object localObject1;
        List localList;
        Iterator localIterator;
        Object localObject2;
        int i;
        int j;
        cm localcm = (cm)t.b(localThrowable, 2);
        continue;
        continue;
      }
      AppMethodBeat.o(189398);
      return localObject1;
      localList = kotlin.m.k.d(kotlin.m.k.d(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
      continue;
      localObject1 = localIterator.next();
      if (!localIterator.hasNext())
      {
        localObject2 = localObject1;
      }
      else
      {
        i = ((MainDispatcherFactory)localObject1).getLoadPriority();
        localObject2 = localIterator.next();
        j = ((MainDispatcherFactory)localObject2).getLoadPriority();
        if (i >= j) {
          continue;
        }
        localObject1 = localObject2;
        i = j;
        localObject2 = localObject1;
        if (localIterator.hasNext())
        {
          continue;
          localObject1 = t.a((MainDispatcherFactory)localObject1, localList);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.s
 * JD-Core Version:    0.7.0.1
 */