package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.l;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.c.c;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class x
{
  private static final boolean Kds;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = o.aRh("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label17:
      Kds = bool;
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
  
  public static final f a(ad paramad, f paramf)
  {
    AppMethodBeat.i(118185);
    paramf = paramad.fKB().plus(paramf);
    if (ah.getDEBUG()) {}
    for (paramad = paramf.plus((f)new ab(ah.fKY().incrementAndGet())); (paramf != at.fLf()) && (paramf.get((f.c)e.JgC) == null); paramad = paramf)
    {
      paramad = paramad.plus((f)at.fLf());
      AppMethodBeat.o(118185);
      return paramad;
    }
    AppMethodBeat.o(118185);
    return paramad;
  }
  
  public static final String a(f paramf)
  {
    AppMethodBeat.i(118186);
    if (!ah.getDEBUG())
    {
      AppMethodBeat.o(118186);
      return null;
    }
    ab localab = (ab)paramf.get((f.c)ab.Kdy);
    if (localab == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    paramf = (ac)paramf.get((f.c)ac.Kdz);
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
    paramf = paramf + '#' + localab.id;
    AppMethodBeat.o(118186);
    return paramf;
  }
  
  public static final y fKT()
  {
    if (Kds) {
      return (y)c.Kgk;
    }
    return (y)p.Kdn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.x
 * JD-Core Version:    0.7.0.1
 */