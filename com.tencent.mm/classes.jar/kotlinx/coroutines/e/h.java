package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.internal.ad;

@Metadata(d1={""}, d2={"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "getBROKEN$annotations", "()V", "CANCELLED", "getCANCELLED$annotations", "MAX_SPIN_CYCLES", "", "getMAX_SPIN_CYCLES$annotations", "PERMIT", "getPERMIT$annotations", "SEGMENT_SIZE", "getSEGMENT_SIZE$annotations", "TAKEN", "getTAKEN$annotations", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final int ajCo;
  private static final ac ajCp;
  private static final ac ajCq;
  private static final ac ajCr;
  private static final ac ajCs;
  private static final int ajCt;
  
  static
  {
    AppMethodBeat.i(188991);
    ajCo = ad.h("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
    ajCp = new ac("PERMIT");
    ajCq = new ac("TAKEN");
    ajCr = new ac("BROKEN");
    ajCs = new ac("CANCELLED");
    ajCt = ad.h("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);
    AppMethodBeat.o(188991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e.h
 * JD-Core Version:    0.7.0.1
 */