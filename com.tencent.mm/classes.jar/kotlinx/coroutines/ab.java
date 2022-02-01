package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.l;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.internal.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class ab
{
  private static final boolean NHP;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = v.bdj("kotlinx.coroutines.scheduler");
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = true;
      label17:
      NHP = bool;
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
    paramf = paramah.guE().plus(paramf);
    if (am.getDEBUG()) {}
    for (paramah = paramf.plus((f)new af(am.gvf().incrementAndGet())); (paramf != az.gvn()) && (paramf.get((f.c)e.MKV) == null); paramah = paramf)
    {
      paramah = paramah.plus((f)az.gvn());
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
    af localaf = (af)paramf.get((f.c)af.NHV);
    if (localaf == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    paramf = (ag)paramf.get((f.c)ag.NHW);
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
  
  public static final ac gva()
  {
    if (NHP) {
      return (ac)c.NKP;
    }
    return (ac)t.NHK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ab
 * JD-Core Version:    0.7.0.1
 */