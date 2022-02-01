package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.a.p;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"})
public final class ah
{
  private static final boolean DEBUG;
  private static final boolean KdF;
  private static final boolean KdG;
  private static final AtomicLong KdH;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(118233);
    KdF = ab.class.desiredAssertionStatus();
    Object localObject = o.aRh("kotlinx.coroutines.debug");
    if (localObject == null)
    {
      bool1 = KdF;
      label29:
      DEBUG = bool1;
      if ((!bool1) || (!p.aWl("kotlinx.coroutines.stacktrace.recovery"))) {
        break label210;
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      KdG = bool1;
      KdH = new AtomicLong(0L);
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
  
  public static final boolean fKW()
  {
    return KdF;
  }
  
  public static final boolean fKX()
  {
    return KdG;
  }
  
  public static final AtomicLong fKY()
  {
    return KdH;
  }
  
  public static final boolean getDEBUG()
  {
    return DEBUG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ah
 * JD-Core Version:    0.7.0.1
 */