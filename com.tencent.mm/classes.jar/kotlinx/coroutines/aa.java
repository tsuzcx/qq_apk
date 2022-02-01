package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.l;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.internal.u;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class aa
{
  private static final boolean LQU;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = u.aXg("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label17:
      LQU = bool;
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
  
  public static final f a(ag paramag, f paramf)
  {
    AppMethodBeat.i(118185);
    paramf = paramag.gde().plus(paramf);
    if (al.getDEBUG()) {}
    for (paramag = paramf.plus((f)new ae(al.gdF().incrementAndGet())); (paramf != ay.gdN()) && (paramf.get((f.c)e.KTW) == null); paramag = paramf)
    {
      paramag = paramag.plus((f)ay.gdN());
      AppMethodBeat.o(118185);
      return paramag;
    }
    AppMethodBeat.o(118185);
    return paramag;
  }
  
  public static final String a(f paramf)
  {
    AppMethodBeat.i(118186);
    if (!al.getDEBUG())
    {
      AppMethodBeat.o(118186);
      return null;
    }
    ae localae = (ae)paramf.get((f.c)ae.LRa);
    if (localae == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    paramf = (af)paramf.get((f.c)af.LRb);
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
    paramf = paramf + '#' + localae.id;
    AppMethodBeat.o(118186);
    return paramf;
  }
  
  public static final ab gdA()
  {
    if (LQU) {
      return (ab)c.LTU;
    }
    return (ab)s.LQP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.aa
 * JD-Core Version:    0.7.0.1
 */