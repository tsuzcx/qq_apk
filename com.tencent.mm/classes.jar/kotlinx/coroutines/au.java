package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ae;
import kotlinx.coroutines.internal.af;

@Metadata(d1={""}, d2={"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class au
{
  public static final boolean ASSERTIONS_ENABLED;
  public static final boolean DEBUG;
  public static final boolean ajvP;
  static final AtomicLong ajvQ;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(118233);
    ASSERTIONS_ENABLED = ao.class.desiredAssertionStatus();
    Object localObject = ae.bJL("kotlinx.coroutines.debug");
    if (localObject != null) {
      switch (((String)localObject).hashCode())
      {
      default: 
      case 0: 
        do
        {
          localObject = (Throwable)new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + localObject + '\'').toString());
          AppMethodBeat.o(118233);
          throw ((Throwable)localObject);
        } while (!((String)localObject).equals(""));
        label123:
        bool1 = true;
        label125:
        DEBUG = bool1;
        if ((!bool1) || (!af.bJM("kotlinx.coroutines.stacktrace.recovery"))) {
          break;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ajvP = bool1;
      ajvQ = new AtomicLong(0L);
      AppMethodBeat.o(118233);
      return;
      if (!((String)localObject).equals("auto")) {
        break;
      }
      bool1 = ASSERTIONS_ENABLED;
      break label125;
      if (!((String)localObject).equals("off")) {
        break;
      }
      bool1 = false;
      break label125;
      if (((String)localObject).equals("on")) {
        break label123;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.au
 * JD-Core Version:    0.7.0.1
 */