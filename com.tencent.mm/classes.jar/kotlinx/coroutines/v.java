package kotlinx.coroutines;

import a.c.d;
import a.c.e;
import a.c.e.c;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.c.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "resetCoroutineId", "", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class v
{
  private static final AtomicLong CHv;
  private static final boolean CHw;
  
  static
  {
    AppMethodBeat.i(118503);
    CHv = new AtomicLong();
    Object localObject = n.azw("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label27:
      CHw = bool;
      AppMethodBeat.o(118503);
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
            AppMethodBeat.o(118503);
            throw ((Throwable)localObject);
          } while (!((String)localObject).equals(""));
          break;
        } while (!((String)localObject).equals("off"));
        bool = false;
        break label27;
      } while (!((String)localObject).equals("on"));
    }
  }
  
  public static final e a(ac paramac, e parame)
  {
    AppMethodBeat.i(118501);
    j.q(paramac, "receiver$0");
    j.q(parame, "context");
    parame = paramac.epr().plus(parame);
    if (af.epy()) {}
    for (paramac = parame.plus((e)new aa(CHv.incrementAndGet())); (parame != ao.epH()) && (parame.get((e.c)d.BML) == null); paramac = parame)
    {
      paramac = paramac.plus((e)ao.epH());
      AppMethodBeat.o(118501);
      return paramac;
    }
    AppMethodBeat.o(118501);
    return paramac;
  }
  
  public static final String a(e parame)
  {
    AppMethodBeat.i(118502);
    j.q(parame, "receiver$0");
    if (!af.epy())
    {
      AppMethodBeat.o(118502);
      return null;
    }
    aa localaa = (aa)parame.get((e.c)aa.CHz);
    if (localaa == null)
    {
      AppMethodBeat.o(118502);
      return null;
    }
    parame = (ab)parame.get((e.c)ab.CHA);
    if (parame != null)
    {
      String str = parame.name;
      parame = str;
      if (str != null) {}
    }
    else
    {
      parame = "coroutine";
    }
    parame = parame + '#' + localaa.id;
    AppMethodBeat.o(118502);
    return parame;
  }
  
  public static final w epx()
  {
    if (CHw) {
      return (w)c.CKp;
    }
    return (w)p.CHs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlinx.coroutines.v
 * JD-Core Version:    0.7.0.1
 */