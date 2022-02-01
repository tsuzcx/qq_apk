package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.l;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"})
public final class an
{
  private static final boolean DEBUG;
  private static final boolean TUc;
  private static final boolean TUd;
  private static final AtomicLong TUe;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(118233);
    TUc = ag.class.desiredAssertionStatus();
    Object localObject = w.buC("kotlinx.coroutines.debug");
    if (localObject == null)
    {
      bool1 = TUc;
      label29:
      DEBUG = bool1;
      if ((!bool1) || (!x.buD("kotlinx.coroutines.stacktrace.recovery"))) {
        break label210;
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      TUd = bool1;
      TUe = new AtomicLong(0L);
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
  
  public static final boolean hMK()
  {
    return TUc;
  }
  
  public static final boolean hML()
  {
    return TUd;
  }
  
  public static final AtomicLong hMM()
  {
    return TUe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.an
 * JD-Core Version:    0.7.0.1
 */