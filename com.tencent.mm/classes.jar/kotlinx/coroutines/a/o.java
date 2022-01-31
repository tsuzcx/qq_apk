package kotlinx.coroutines.a;

import a.c.e;
import a.c.e.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.bq;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class o
{
  private static final m CJv;
  private static final a.f.a.m<Object, e.b, Object> CJw;
  private static final a.f.a.m<bq<?>, e.b, bq<?>> CJx;
  private static final a.f.a.m<s, e.b, s> CJy;
  private static final a.f.a.m<s, e.b, s> CJz;
  
  static
  {
    AppMethodBeat.i(118395);
    CJv = new m("ZERO");
    CJw = (a.f.a.m)o.a.CJA;
    CJx = (a.f.a.m)o.b.CJB;
    CJy = (a.f.a.m)o.d.CJD;
    CJz = (a.f.a.m)c.CJC;
    AppMethodBeat.o(118395);
  }
  
  public static final void a(e parame, Object paramObject)
  {
    AppMethodBeat.i(118394);
    j.q(parame, "context");
    if (paramObject == CJv)
    {
      AppMethodBeat.o(118394);
      return;
    }
    if ((paramObject instanceof s))
    {
      ((s)paramObject).i = 0;
      parame.fold(paramObject, CJz);
      AppMethodBeat.o(118394);
      return;
    }
    Object localObject = parame.fold(null, CJx);
    if (localObject == null)
    {
      parame = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      AppMethodBeat.o(118394);
      throw parame;
    }
    ((bq)localObject).a(parame, paramObject);
    AppMethodBeat.o(118394);
  }
  
  public static final Object b(e parame, Object paramObject)
  {
    AppMethodBeat.i(118393);
    j.q(parame, "context");
    if (paramObject == null) {
      paramObject = d(parame);
    }
    for (;;)
    {
      if (paramObject == Integer.valueOf(0))
      {
        parame = CJv;
        AppMethodBeat.o(118393);
        return parame;
      }
      if ((paramObject instanceof Integer))
      {
        parame = parame.fold(new s(parame, ((Number)paramObject).intValue()), CJy);
        AppMethodBeat.o(118393);
        return parame;
      }
      if (paramObject == null)
      {
        parame = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        AppMethodBeat.o(118393);
        throw parame;
      }
      parame = ((bq)paramObject).c(parame);
      AppMethodBeat.o(118393);
      return parame;
    }
  }
  
  public static final Object d(e parame)
  {
    AppMethodBeat.i(118392);
    j.q(parame, "context");
    parame = parame.fold(Integer.valueOf(0), CJw);
    if (parame == null) {
      j.ebi();
    }
    AppMethodBeat.o(118392);
    return parame;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class c
    extends k
    implements a.f.a.m<s, e.b, s>
  {
    public static final c CJC;
    
    static
    {
      AppMethodBeat.i(118399);
      CJC = new c();
      AppMethodBeat.o(118399);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.o
 * JD-Core Version:    0.7.0.1
 */