package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.j;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l
{
  public static final long Oif;
  public static final int Oig;
  public static final long Oih;
  public static m Oii;
  public static final int aBC;
  public static final int aBD;
  
  static
  {
    AppMethodBeat.i(117978);
    Oif = u.cr("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    Oig = u.g("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    aBC = u.g("kotlinx.coroutines.scheduler.core.pool.size", j.lw(v.gAK(), 2), 1, 0, 8);
    aBD = u.g("kotlinx.coroutines.scheduler.max.pool.size", j.bb(v.gAK() * 128, aBC, 2097150), 0, 2097150, 4);
    Oih = TimeUnit.SECONDS.toNanos(u.cr("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    Oii = (m)g.Oia;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.l
 * JD-Core Version:    0.7.0.1
 */