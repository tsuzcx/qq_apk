package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ac;

@Metadata(d1={""}, d2={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "getDISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class bp
{
  private static final ac ajwk;
  private static final ac ajwl;
  
  static
  {
    AppMethodBeat.i(188822);
    ajwk = new ac("REMOVED_TASK");
    ajwl = new ac("CLOSED_EMPTY");
    AppMethodBeat.o(188822);
  }
  
  public static final long BL(long paramLong)
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
 * Qualified Name:     kotlinx.coroutines.bp
 * JD-Core Version:    0.7.0.1
 */