package kotlinx.coroutines.c;

import a.i.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "QUEUE_SIZE_OFFLOAD_THRESHOLD", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "kotlinx-coroutines-core"})
public final class m
{
  public static final long CKF;
  public static final int CKG;
  public static final int CKH;
  public static final int CKI;
  public static final long CKJ;
  public static n CKK;
  public static final int CORE_POOL_SIZE;
  
  static
  {
    AppMethodBeat.i(118302);
    CKF = kotlinx.coroutines.a.n.bk("kotlinx.coroutines.scheduler.resolution.ns", 100000L);
    CKG = kotlinx.coroutines.a.n.g("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4);
    CKH = kotlinx.coroutines.a.n.g("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    CORE_POOL_SIZE = kotlinx.coroutines.a.n.g("kotlinx.coroutines.scheduler.core.pool.size", e.iE(kotlinx.coroutines.a.n.eqo(), 2), 1, 0, 8);
    CKI = kotlinx.coroutines.a.n.g("kotlinx.coroutines.scheduler.max.pool.size", e.aP(kotlinx.coroutines.a.n.eqo() * 128, CORE_POOL_SIZE, 2097150), 0, 2097150, 4);
    CKJ = TimeUnit.SECONDS.toNanos(kotlinx.coroutines.a.n.bk("kotlinx.coroutines.scheduler.keep.alive.sec", 5L));
    CKK = (n)g.CKx;
    AppMethodBeat.o(118302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.c.m
 * JD-Core Version:    0.7.0.1
 */