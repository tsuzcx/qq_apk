package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.l;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.internal.y;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"})
public final class ap
{
  private static final boolean DEBUG;
  private static final boolean abwF;
  private static final boolean abwG;
  private static final AtomicLong abwH;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(118233);
    abwF = ai.class.desiredAssertionStatus();
    Object localObject = x.bHF("kotlinx.coroutines.debug");
    if (localObject == null)
    {
      bool1 = abwF;
      label29:
      DEBUG = bool1;
      if ((!bool1) || (!y.bHG("kotlinx.coroutines.stacktrace.recovery"))) {
        break label210;
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      abwG = bool1;
      abwH = new AtomicLong(0L);
      AppMethodBeat.o(118233);
      return;
      switch (((String)localObject).hashCode())
      {
      default: 
      case 0: 
        label116:
        do
        {
          localObject = (Throwable)new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + (String)localObject + '\'').toString());
          AppMethodBeat.o(118233);
          throw ((Throwable)localObject);
        } while (!((String)localObject).equals(""));
      }
      for (;;)
      {
        bool1 = true;
        break label29;
        if (!((String)localObject).equals("auto")) {
          break label116;
        }
        break;
        if (!((String)localObject).equals("off")) {
          break label116;
        }
        bool1 = false;
        break label29;
        if (!((String)localObject).equals("on")) {
          break label116;
        }
      }
    }
  }
  
  public static final boolean getDEBUG()
  {
    return DEBUG;
  }
  
  public static final boolean iRg()
  {
    return abwF;
  }
  
  public static final boolean iRh()
  {
    return abwG;
  }
  
  public static final AtomicLong iRi()
  {
    return abwH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ap
 * JD-Core Version:    0.7.0.1
 */