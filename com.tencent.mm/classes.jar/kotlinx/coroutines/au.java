package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.m;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "MAX_MS", "", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"})
public final class au
{
  private static final m CId;
  private static final m CIe;
  
  static
  {
    AppMethodBeat.i(118373);
    CId = new m("REMOVED_TASK");
    CIe = new m("CLOSED_EMPTY");
    AppMethodBeat.o(118373);
  }
  
  public static final long pv(long paramLong)
  {
    if (1000L <= 0L) {
      return 0L;
    }
    if (1000L >= 9223372036854L) {
      return 9223372036854775807L;
    }
    return 1000000000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.au
 * JD-Core Version:    0.7.0.1
 */