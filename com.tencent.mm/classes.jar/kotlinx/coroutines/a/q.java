package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.b;
import d.g.b.k;
import d.v;
import kotlinx.coroutines.by;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class q
{
  private static final m KfB;
  private static final d.g.a.m<Object, f.b, Object> KfC;
  private static final d.g.a.m<by<?>, f.b, by<?>> KfD;
  private static final d.g.a.m<t, f.b, t> KfE;
  private static final d.g.a.m<t, f.b, t> KfF;
  
  static
  {
    AppMethodBeat.i(118075);
    KfB = new m("ZERO");
    KfC = (d.g.a.m)q.a.KfG;
    KfD = (d.g.a.m)q.b.KfH;
    KfE = (d.g.a.m)d.KfJ;
    KfF = (d.g.a.m)c.KfI;
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
        paramf = KfB;
        AppMethodBeat.o(118073);
        return paramf;
      }
      if ((paramObject instanceof Integer))
      {
        paramf = paramf.fold(new t(paramf, ((Number)paramObject).intValue()), KfE);
        AppMethodBeat.o(118073);
        return paramf;
      }
      if (paramObject == null)
      {
        paramf = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        AppMethodBeat.o(118073);
        throw paramf;
      }
      paramf = ((by)paramObject).b(paramf);
      AppMethodBeat.o(118073);
      return paramf;
    }
  }
  
  public static final void b(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118074);
    if (paramObject == KfB)
    {
      AppMethodBeat.o(118074);
      return;
    }
    if ((paramObject instanceof t))
    {
      ((t)paramObject).i = 0;
      paramf.fold(paramObject, KfF);
      AppMethodBeat.o(118074);
      return;
    }
    paramf = paramf.fold(null, KfD);
    if (paramf == null)
    {
      paramf = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      AppMethodBeat.o(118074);
      throw paramf;
    }
    ((by)paramf).fC(paramObject);
    AppMethodBeat.o(118074);
  }
  
  public static final Object d(f paramf)
  {
    AppMethodBeat.i(118072);
    paramf = paramf.fold(Integer.valueOf(0), KfC);
    if (paramf == null) {
      k.fvU();
    }
    AppMethodBeat.o(118072);
    return paramf;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.m<t, f.b, t>
  {
    public static final c KfI;
    
    static
    {
      AppMethodBeat.i(118079);
      KfI = new c();
      AppMethodBeat.o(118079);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.m<t, f.b, t>
  {
    public static final d KfJ;
    
    static
    {
      AppMethodBeat.i(118110);
      KfJ = new d();
      AppMethodBeat.o(118110);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.q
 * JD-Core Version:    0.7.0.1
 */