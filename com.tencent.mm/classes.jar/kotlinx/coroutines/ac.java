package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.internal.w;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class ac
{
  private static final boolean TTP;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = w.buC("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label17:
      TTP = bool;
      AppMethodBeat.o(118187);
      return;
      switch (((String)localObject).hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            localObject = (Throwable)new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + (String)localObject + '\'').toString());
            AppMethodBeat.o(118187);
            throw ((Throwable)localObject);
          } while (!((String)localObject).equals(""));
          break;
        } while (!((String)localObject).equals("off"));
        bool = false;
        break label17;
      } while (!((String)localObject).equals("on"));
    }
  }
  
  public static final String a(f paramf)
  {
    AppMethodBeat.i(118186);
    if (!an.getDEBUG())
    {
      AppMethodBeat.o(118186);
      return null;
    }
    ag localag = (ag)paramf.get((f.c)ag.TTV);
    if (localag == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    paramf = (ah)paramf.get((f.c)ah.TTW);
    if (paramf != null)
    {
      String str = paramf.name;
      paramf = str;
      if (str != null) {}
    }
    else
    {
      paramf = "coroutine";
    }
    paramf = paramf + '#' + localag.id;
    AppMethodBeat.o(118186);
    return paramf;
  }
  
  public static final f a(ai paramai, f paramf)
  {
    AppMethodBeat.i(118185);
    paramf = paramai.hMk().plus(paramf);
    if (an.getDEBUG()) {}
    for (paramai = paramf.plus((f)new ag(an.hMM().incrementAndGet())); (paramf != ba.hMU()) && (paramf.get((f.c)e.SXH) == null); paramai = paramf)
    {
      paramai = paramai.plus((f)ba.hMU());
      AppMethodBeat.o(118185);
      return paramai;
    }
    AppMethodBeat.o(118185);
    return paramai;
  }
  
  public static final ad hMG()
  {
    if (TTP) {
      return (ad)c.TWS;
    }
    return (ad)t.TTK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ac
 * JD-Core Version:    0.7.0.1
 */