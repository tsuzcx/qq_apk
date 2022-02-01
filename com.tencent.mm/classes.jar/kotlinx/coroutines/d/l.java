package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.k.k;
import kotlinx.coroutines.internal.ad;
import kotlinx.coroutines.internal.ae;

@Metadata(d1={""}, d2={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_DISPATCHER_NAME", "", "DEFAULT_SCHEDULER_NAME", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final long ajBJ;
  public static final int ajBK;
  public static final long ajBL;
  public static h ajBM;
  public static final int ckq;
  public static final int ckr;
  
  static
  {
    AppMethodBeat.i(117978);
    ajBJ = ad.cI("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    ajBK = ad.h("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    ckq = ad.h("kotlinx.coroutines.scheduler.core.pool.size", k.qu(ae.kEp(), 2), 1, 0, 8);
    ckr = ad.h("kotlinx.coroutines.scheduler.max.pool.size", k.bQ(ae.kEp() * 128, ckq, 2097150), 0, 2097150, 4);
    ajBL = TimeUnit.SECONDS.toNanos(ad.cI("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    ajBM = (h)f.ajBF;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.l
 * JD-Core Version:    0.7.0.1
 */