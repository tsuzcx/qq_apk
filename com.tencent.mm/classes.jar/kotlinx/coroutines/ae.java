package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;
import kotlinx.coroutines.d.c;
import kotlinx.coroutines.internal.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class ae
{
  private static final boolean abwt;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = x.bHF("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label17:
      abwt = bool;
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
    if (!ap.getDEBUG())
    {
      AppMethodBeat.o(118186);
      return null;
    }
    ai localai = (ai)paramf.get((f.c)ai.abwy);
    if (localai == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    if ((aj)paramf.get((f.c)aj.abwz) != null)
    {
      AppMethodBeat.o(118186);
      throw null;
    }
    paramf = "coroutine" + '#' + localai.id;
    AppMethodBeat.o(118186);
    return paramf;
  }
  
  public static final f a(ak paramak, f paramf)
  {
    AppMethodBeat.i(118185);
    paramf = paramak.getCoroutineContext().plus(paramf);
    if (ap.getDEBUG()) {}
    for (paramak = paramf.plus((f)new ai(ap.iRi().incrementAndGet())); (paramf != bc.iRq()) && (paramf.get((f.c)e.aaAt) == null); paramak = paramf)
    {
      paramak = paramak.plus((f)bc.iRq());
      AppMethodBeat.o(118185);
      return paramak;
    }
    AppMethodBeat.o(118185);
    return paramak;
  }
  
  public static final af iRc()
  {
    if (abwt) {
      return (af)c.abAj;
    }
    return (af)v.abwp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ae
 * JD-Core Version:    0.7.0.1
 */