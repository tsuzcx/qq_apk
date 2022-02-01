package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.a.m;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "DISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"})
public final class ba
{
  private static final m Kei;
  private static final m Kej;
  
  static
  {
    AppMethodBeat.i(190035);
    Kei = new m("REMOVED_TASK");
    Kej = new m("CLOSED_EMPTY");
    AppMethodBeat.o(190035);
  }
  
  public static final long xL(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ba
 * JD-Core Version:    0.7.0.1
 */