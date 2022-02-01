package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.b;
import d.g.a.m;
import d.g.b.k;
import d.v;
import kotlinx.coroutines.cd;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class w
{
  private static final s LTj;
  private static final m<Object, f.b, Object> LTk;
  private static final m<cd<?>, f.b, cd<?>> LTl;
  private static final m<z, f.b, z> LTm;
  private static final m<z, f.b, z> LTn;
  
  static
  {
    AppMethodBeat.i(118075);
    LTj = new s("ZERO");
    LTk = (m)w.a.LTo;
    LTl = (m)w.b.LTp;
    LTm = (m)d.LTr;
    LTn = (m)c.LTq;
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
        paramf = LTj;
        AppMethodBeat.o(118073);
        return paramf;
      }
      if ((paramObject instanceof Integer))
      {
        paramf = paramf.fold(new z(paramf, ((Number)paramObject).intValue()), LTm);
        AppMethodBeat.o(118073);
        return paramf;
      }
      if (paramObject == null)
      {
        paramf = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        AppMethodBeat.o(118073);
        throw paramf;
      }
      paramf = ((cd)paramObject).b(paramf);
      AppMethodBeat.o(118073);
      return paramf;
    }
  }
  
  public static final void b(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118074);
    if (paramObject == LTj)
    {
      AppMethodBeat.o(118074);
      return;
    }
    if ((paramObject instanceof z))
    {
      ((z)paramObject).i = 0;
      paramf.fold(paramObject, LTn);
      AppMethodBeat.o(118074);
      return;
    }
    paramf = paramf.fold(null, LTl);
    if (paramf == null)
    {
      paramf = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      AppMethodBeat.o(118074);
      throw paramf;
    }
    ((cd)paramf).fH(paramObject);
    AppMethodBeat.o(118074);
  }
  
  public static final Object d(f paramf)
  {
    AppMethodBeat.i(118072);
    paramf = paramf.fold(Integer.valueOf(0), LTk);
    if (paramf == null) {
      k.fOy();
    }
    AppMethodBeat.o(118072);
    return paramf;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<z, f.b, z>
  {
    public static final c LTq;
    
    static
    {
      AppMethodBeat.i(118079);
      LTq = new c();
      AppMethodBeat.o(118079);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class d
    extends d.g.b.l
    implements m<z, f.b, z>
  {
    public static final d LTr;
    
    static
    {
      AppMethodBeat.i(118110);
      LTr = new d();
      AppMethodBeat.o(118110);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.w
 * JD-Core Version:    0.7.0.1
 */