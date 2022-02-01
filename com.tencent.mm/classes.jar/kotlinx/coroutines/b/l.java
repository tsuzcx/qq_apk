package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlin.k.j;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l
{
  public static final long TXb;
  public static final int TXc;
  public static final long TXd;
  public static m TXe;
  public static final int aBA;
  public static final int aBB;
  
  static
  {
    AppMethodBeat.i(117978);
    TXb = v.cm("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    TXc = v.h("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    aBA = v.h("kotlinx.coroutines.scheduler.core.pool.size", j.mZ(w.hNR(), 2), 1, 0, 8);
    aBB = v.h("kotlinx.coroutines.scheduler.max.pool.size", j.bh(w.hNR() * 128, aBA, 2097150), 0, 2097150, 4);
    TXd = TimeUnit.SECONDS.toNanos(v.cm("kotlinx.coroutines.scheduler.keep.alive.sec", 60L));
    TXe = (m)g.TWX;
    AppMethodBeat.o(117978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.b.l
 * JD-Core Version:    0.7.0.1
 */