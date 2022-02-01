package com.tencent.mm.plugin.performance.b;

import com.tencent.e.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.n.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
public final class a$i
  implements g.b
{
  private final boolean wJh;
  private final ConcurrentHashMap<String, String> wJi;
  
  a$i()
  {
    AppMethodBeat.i(211729);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qsk, true);
    ad.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(bool)));
    this.wJh = bool;
    this.wJi = new ConcurrentHashMap();
    AppMethodBeat.o(211729);
  }
  
  public final void a(Thread paramThread, String paramString)
  {
    AppMethodBeat.i(211728);
    p.h(paramThread, "thread");
    p.h(paramString, "task");
    if (a.c(this.wJg))
    {
      Object localObject = (CharSequence)paramString;
      localObject = new k("[0-9]\\d*").e((CharSequence)localObject, "?");
      if (!this.wJi.contains(localObject))
      {
        String str = "task=" + (String)localObject + ' ' + paramThread;
        ad.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str)));
        e.ygI.f(18762, new Object[] { Integer.valueOf(a.e.wJd.value), str, paramString, Integer.valueOf(17), aj.getProcessName() });
        ((Map)this.wJi).put(localObject, String.valueOf(paramThread));
      }
    }
    AppMethodBeat.o(211728);
  }
  
  public final boolean dyV()
  {
    return true;
  }
  
  public final boolean dyW()
  {
    return this.wJh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.i
 * JD-Core Version:    0.7.0.1
 */