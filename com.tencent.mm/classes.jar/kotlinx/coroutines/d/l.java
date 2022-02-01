package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlin.k.i;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l
{
  public static final long abAs;
  public static final int abAt;
  public static final long abAu;
  public static m abAv;
  public static final int avU;
  public static final int avV;
  
  static
  {
    AppMethodBeat.i(117978);
    abAs = w.cw("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    abAt = w.i("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    avU = w.i("kotlinx.coroutines.scheduler.core.pool.size", i.ov(x.iSX(), 2), 1, 0, 8);
    avV = w.i("kotlinx.coroutines.scheduler.max.pool.size", i.bm(x.iSX() * 128, avU, 2097150), 0, 2097150, 4);
    abAu = TimeUnit.SECONDS.toNanos(w.cw("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    abAv = (m)g.abAo;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.d.l
 * JD-Core Version:    0.7.0.1
 */