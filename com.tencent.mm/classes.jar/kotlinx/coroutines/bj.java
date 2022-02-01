package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.internal.u;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "DISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"})
public final class bj
{
  private static final u TUF;
  private static final u TUG;
  
  static
  {
    AppMethodBeat.i(192386);
    TUF = new u("REMOVED_TASK");
    TUG = new u("CLOSED_EMPTY");
    AppMethodBeat.o(192386);
  }
  
  public static final long Pl(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bj
 * JD-Core Version:    0.7.0.1
 */