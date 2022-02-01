package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.h;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.a.o;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l
{
  public static final long Kgu;
  public static final int Kgv;
  public static final long Kgw;
  public static m Kgx;
  public static final int ayR;
  public static final int ayS;
  
  static
  {
    AppMethodBeat.i(117978);
    Kgu = n.ch("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    Kgv = n.f("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    ayR = n.f("kotlinx.coroutines.scheduler.core.pool.size", h.kK(o.fLT(), 2), 1, 0, 8);
    ayS = n.f("kotlinx.coroutines.scheduler.max.pool.size", h.aX(o.fLT() * 128, ayR, 2097150), 0, 2097150, 4);
    Kgw = TimeUnit.SECONDS.toNanos(n.ch("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    Kgx = (m)g.Kgp;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.l
 * JD-Core Version:    0.7.0.1
 */