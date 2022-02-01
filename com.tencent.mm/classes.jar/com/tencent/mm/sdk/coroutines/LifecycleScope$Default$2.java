package com.tencent.mm.sdk.coroutines;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bq;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "invoke"})
final class LifecycleScope$Default$2
  extends q
  implements a<bn>
{
  LifecycleScope$Default$2(LifecycleScope paramLifecycleScope)
  {
    super(0);
  }
  
  public final bn invoke()
  {
    AppMethodBeat.i(190101);
    Object localObject = h.ZvG.bDi(this.this$0.getName());
    p.j(localObject, "ThreadPool.INSTANCE.fork…ngleExecutorService(name)");
    localObject = bq.a((ExecutorService)localObject);
    AppMethodBeat.o(190101);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.coroutines.LifecycleScope.Default.2
 * JD-Core Version:    0.7.0.1
 */