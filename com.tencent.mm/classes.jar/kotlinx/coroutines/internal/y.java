package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.co;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class y
{
  private static final u TWj;
  private static final m<Object, f.b, Object> TWk;
  private static final m<co<?>, f.b, co<?>> TWl;
  private static final m<ab, f.b, ab> TWm;
  private static final m<ab, f.b, ab> TWn;
  
  static
  {
    AppMethodBeat.i(118075);
    TWj = new u("ZERO");
    TWk = (m)y.a.TWo;
    TWl = (m)y.b.TWp;
    TWm = (m)d.TWr;
    TWn = (m)c.TWq;
    AppMethodBeat.o(118075);
  }
  
  public static final Object a(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118073);
    if (paramObject == null) {
      paramObject = d(paramf);
    }
    for (;;)
    {
      if (paramObject == Integer.valueOf(0))
      {
        paramf = TWj;
        AppMethodBeat.o(118073);
        return paramf;
      }
      if ((paramObject instanceof Integer))
      {
        paramf = paramf.fold(new ab(paramf, ((Number)paramObject).intValue()), TWm);
        AppMethodBeat.o(118073);
        return paramf;
      }
      if (paramObject == null)
      {
        paramf = new t("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        AppMethodBeat.o(118073);
        throw paramf;
      }
      paramf = ((co)paramObject).b(paramf);
      AppMethodBeat.o(118073);
      return paramf;
    }
  }
  
  public static final void b(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118074);
    if (paramObject == TWj)
    {
      AppMethodBeat.o(118074);
      return;
    }
    if ((paramObject instanceof ab))
    {
      ((ab)paramObject).i = 0;
      paramf.fold(paramObject, TWn);
      AppMethodBeat.o(118074);
      return;
    }
    paramf = paramf.fold(null, TWl);
    if (paramf == null)
    {
      paramf = new t("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      AppMethodBeat.o(118074);
      throw paramf;
    }
    ((co)paramf).fR(paramObject);
    AppMethodBeat.o(118074);
  }
  
  public static final Object d(f paramf)
  {
    AppMethodBeat.i(118072);
    paramf = paramf.fold(Integer.valueOf(0), TWk);
    if (paramf == null) {
      p.hyc();
    }
    AppMethodBeat.o(118072);
    return paramf;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class c
    extends q
    implements m<ab, f.b, ab>
  {
    public static final c TWq;
    
    static
    {
      AppMethodBeat.i(118079);
      TWq = new c();
      AppMethodBeat.o(118079);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class d
    extends q
    implements m<ab, f.b, ab>
  {
    public static final d TWr;
    
    static
    {
      AppMethodBeat.i(118110);
      TWr = new d();
      AppMethodBeat.o(118110);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.y
 * JD-Core Version:    0.7.0.1
 */