package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.h;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l
{
  public static final long NKZ;
  public static final int NLa;
  public static final long NLb;
  public static m NLc;
  public static final int aBC;
  public static final int aBD;
  
  static
  {
    AppMethodBeat.i(117978);
    NKZ = u.cp("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    NLa = u.g("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    aBC = u.g("kotlinx.coroutines.scheduler.core.pool.size", h.lp(v.gwi(), 2), 1, 0, 8);
    aBD = u.g("kotlinx.coroutines.scheduler.max.pool.size", h.ba(v.gwi() * 128, aBC, 2097150), 0, 2097150, 4);
    NLb = TimeUnit.SECONDS.toNanos(u.cp("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    NLc = (m)g.NKU;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.l
 * JD-Core Version:    0.7.0.1
 */