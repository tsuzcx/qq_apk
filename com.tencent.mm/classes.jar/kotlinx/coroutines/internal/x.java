package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import kotlinx.coroutines.ch;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class x
{
  private static final t NKg;
  private static final m<Object, f.b, Object> NKh;
  private static final m<ch<?>, f.b, ch<?>> NKi;
  private static final m<aa, f.b, aa> NKj;
  private static final m<aa, f.b, aa> NKk;
  
  static
  {
    AppMethodBeat.i(118075);
    NKg = new t("ZERO");
    NKh = (m)x.a.NKl;
    NKi = (m)x.b.NKm;
    NKj = (m)d.NKo;
    NKk = (m)c.NKn;
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
        paramf = NKg;
        AppMethodBeat.o(118073);
        return paramf;
      }
      if ((paramObject instanceof Integer))
      {
        paramf = paramf.fold(new aa(paramf, ((Number)paramObject).intValue()), NKj);
        AppMethodBeat.o(118073);
        return paramf;
      }
      if (paramObject == null)
      {
        paramf = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        AppMethodBeat.o(118073);
        throw paramf;
      }
      paramf = ((ch)paramObject).b(paramf);
      AppMethodBeat.o(118073);
      return paramf;
    }
  }
  
  public static final void b(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118074);
    if (paramObject == NKg)
    {
      AppMethodBeat.o(118074);
      return;
    }
    if ((paramObject instanceof aa))
    {
      ((aa)paramObject).i = 0;
      paramf.fold(paramObject, NKk);
      AppMethodBeat.o(118074);
      return;
    }
    paramf = paramf.fold(null, NKi);
    if (paramf == null)
    {
      paramf = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      AppMethodBeat.o(118074);
      throw paramf;
    }
    ((ch)paramf).fK(paramObject);
    AppMethodBeat.o(118074);
  }
  
  public static final Object d(f paramf)
  {
    AppMethodBeat.i(118072);
    paramf = paramf.fold(Integer.valueOf(0), NKh);
    if (paramf == null) {
      p.gfZ();
    }
    AppMethodBeat.o(118072);
    return paramf;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class c
    extends q
    implements m<aa, f.b, aa>
  {
    public static final c NKn;
    
    static
    {
      AppMethodBeat.i(118079);
      NKn = new c();
      AppMethodBeat.o(118079);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class d
    extends q
    implements m<aa, f.b, aa>
  {
    public static final d NKo;
    
    static
    {
      AppMethodBeat.i(118110);
      NKo = new d();
      AppMethodBeat.o(118110);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.x
 * JD-Core Version:    0.7.0.1
 */