package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.cu;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class z
{
  private static final v abzA;
  private static final m<Object, f.b, Object> abzB;
  private static final m<cu<?>, f.b, cu<?>> abzC;
  private static final m<ac, f.b, ac> abzD;
  private static final m<ac, f.b, ac> abzE;
  
  static
  {
    AppMethodBeat.i(118075);
    abzA = new v("ZERO");
    abzB = (m)z.a.abzF;
    abzC = (m)z.b.abzG;
    abzD = (m)d.abzI;
    abzE = (m)c.abzH;
    AppMethodBeat.o(118075);
  }
  
  public static final Object a(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118073);
    if (paramObject == null) {
      paramObject = f(paramf);
    }
    for (;;)
    {
      if (paramObject == Integer.valueOf(0))
      {
        paramf = abzA;
        AppMethodBeat.o(118073);
        return paramf;
      }
      if ((paramObject instanceof Integer))
      {
        paramf = paramf.fold(new ac(paramf, ((Number)paramObject).intValue()), abzD);
        AppMethodBeat.o(118073);
        return paramf;
      }
      if (paramObject == null)
      {
        paramf = new t("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        AppMethodBeat.o(118073);
        throw paramf;
      }
      paramf = ((cu)paramObject).b(paramf);
      AppMethodBeat.o(118073);
      return paramf;
    }
  }
  
  public static final void b(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118074);
    if (paramObject == abzA)
    {
      AppMethodBeat.o(118074);
      return;
    }
    if ((paramObject instanceof ac))
    {
      ((ac)paramObject).i = 0;
      paramf.fold(paramObject, abzE);
      AppMethodBeat.o(118074);
      return;
    }
    paramf = paramf.fold(null, abzC);
    if (paramf == null)
    {
      paramf = new t("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      AppMethodBeat.o(118074);
      throw paramf;
    }
    ((cu)paramf).gb(paramObject);
    AppMethodBeat.o(118074);
  }
  
  public static final Object f(f paramf)
  {
    AppMethodBeat.i(118072);
    paramf = paramf.fold(Integer.valueOf(0), abzB);
    if (paramf == null) {
      p.iCn();
    }
    AppMethodBeat.o(118072);
    return paramf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class c
    extends q
    implements m<ac, f.b, ac>
  {
    public static final c abzH;
    
    static
    {
      AppMethodBeat.i(118079);
      abzH = new c();
      AppMethodBeat.o(118079);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class d
    extends q
    implements m<ac, f.b, ac>
  {
    public static final d abzI;
    
    static
    {
      AppMethodBeat.i(118110);
      abzI = new d();
      AppMethodBeat.o(118110);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.z
 * JD-Core Version:    0.7.0.1
 */