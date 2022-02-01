package com.tencent.mm.plugin.performance.b;

import com.tencent.e.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
public final class a$n
  implements d.f
{
  public final void a(Thread paramThread, String paramString, long paramLong)
  {
    AppMethodBeat.i(184674);
    p.h(paramThread, "thread");
    p.h(paramString, "name");
    ad.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
    AppMethodBeat.o(184674);
  }
  
  public final void b(Thread paramThread, String paramString, long paramLong)
  {
    AppMethodBeat.i(184675);
    p.h(paramThread, "thread");
    p.h(paramString, "name");
    ad.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
    a.b(this.wJg).incrementAndGet();
    AppMethodBeat.o(184675);
  }
  
  public final void c(Thread paramThread, String paramString, long paramLong)
  {
    AppMethodBeat.i(184676);
    p.h(paramThread, "thread");
    p.h(paramString, "name");
    ad.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
    a.b(this.wJg).decrementAndGet();
    AppMethodBeat.o(184676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.n
 * JD-Core Version:    0.7.0.1
 */