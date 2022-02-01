package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.l;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.internal.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class ab
{
  private static final boolean OeV;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = v.beN("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label17:
      OeV = bool;
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
  
  public static final f a(ah paramah, f paramf)
  {
    AppMethodBeat.i(118185);
    paramf = paramah.gzg().plus(paramf);
    if (am.getDEBUG()) {}
    for (paramah = paramf.plus((f)new af(am.gzH().incrementAndGet())); (paramf != az.gzP()) && (paramf.get((f.c)e.NhY) == null); paramah = paramf)
    {
      paramah = paramah.plus((f)az.gzP());
      AppMethodBeat.o(118185);
      return paramah;
    }
    AppMethodBeat.o(118185);
    return paramah;
  }
  
  public static final String a(f paramf)
  {
    AppMethodBeat.i(118186);
    if (!am.getDEBUG())
    {
      AppMethodBeat.o(118186);
      return null;
    }
    af localaf = (af)paramf.get((f.c)af.Ofb);
    if (localaf == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    paramf = (ag)paramf.get((f.c)ag.Ofc);
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
    paramf = paramf + '#' + localaf.id;
    AppMethodBeat.o(118186);
    return paramf;
  }
  
  public static final ac gzC()
  {
    if (OeV) {
      return (ac)c.OhV;
    }
    return (ac)t.OeQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ab
 * JD-Core Version:    0.7.0.1
 */