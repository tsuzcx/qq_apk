package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"})
public final class am
{
  private static final boolean ASSERTIONS_ENABLED;
  private static final boolean DEBUG;
  private static final boolean Ofi;
  private static final AtomicLong Ofj;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(118233);
    ASSERTIONS_ENABLED = af.class.desiredAssertionStatus();
    Object localObject = v.beN("kotlinx.coroutines.debug");
    if (localObject == null)
    {
      bool1 = ASSERTIONS_ENABLED;
      label29:
      DEBUG = bool1;
      if ((!bool1) || (!w.beO("kotlinx.coroutines.stacktrace.recovery"))) {
        break label210;
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Ofi = bool1;
      Ofj = new AtomicLong(0L);
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
  
  public static final boolean gzF()
  {
    return ASSERTIONS_ENABLED;
  }
  
  public static final boolean gzG()
  {
    return Ofi;
  }
  
  public static final AtomicLong gzH()
  {
    return Ofj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.am
 * JD-Core Version:    0.7.0.1
 */