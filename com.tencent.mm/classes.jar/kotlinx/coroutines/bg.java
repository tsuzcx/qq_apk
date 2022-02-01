package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.internal.t;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "DISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"})
public final class bg
{
  private static final t OfJ;
  private static final t OfK;
  
  static
  {
    AppMethodBeat.i(209251);
    OfJ = new t("REMOVED_TASK");
    OfK = new t("CLOSED_EMPTY");
    AppMethodBeat.o(209251);
  }
  
  public static final long Gf(long paramLong)
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
 * Qualified Name:     kotlinx.coroutines.bg
 * JD-Core Version:    0.7.0.1
 */