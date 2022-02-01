package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.internal.s;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "DISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"})
public final class bf
{
  private static final s LRI;
  private static final s LRJ;
  
  static
  {
    AppMethodBeat.i(191150);
    LRI = new s("REMOVED_TASK");
    LRJ = new s("CLOSED_EMPTY");
    AppMethodBeat.o(191150);
  }
  
  public static final long Cy(long paramLong)
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    if (paramLong >= 9223372036854L) {
      return 9223372036854775807L;
    }
    return 1000000L * paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bf
 * JD-Core Version:    0.7.0.1
 */