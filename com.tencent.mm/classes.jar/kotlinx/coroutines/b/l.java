package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.h;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.u;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l
{
  public static final long LUe;
  public static final int LUf;
  public static final long LUg;
  public static m LUh;
  public static final int azL;
  public static final int azM;
  
  static
  {
    AppMethodBeat.i(117978);
    LUe = t.cj("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    LUf = t.f("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    azL = t.f("kotlinx.coroutines.scheduler.core.pool.size", h.la(u.geJ(), 2), 1, 0, 8);
    azM = t.f("kotlinx.coroutines.scheduler.max.pool.size", h.aZ(u.geJ() * 128, azL, 2097150), 0, 2097150, 4);
    LUg = TimeUnit.SECONDS.toNanos(t.cj("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    LUh = (m)g.LTZ;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.l
 * JD-Core Version:    0.7.0.1
 */