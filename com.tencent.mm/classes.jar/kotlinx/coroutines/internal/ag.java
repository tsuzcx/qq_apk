package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.cy;

@Metadata(d1={""}, d2={"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ag
{
  public static final ac ajAT;
  private static final m<Object, f.b, Object> ajAU;
  private static final m<cy<?>, f.b, cy<?>> ajAV;
  private static final m<aj, f.b, aj> ajAW;
  
  static
  {
    AppMethodBeat.i(118075);
    ajAT = new ac("NO_THREAD_ELEMENTS");
    ajAU = (m)ag.a.ajAX;
    ajAV = (m)ag.b.ajAY;
    ajAW = (m)c.ajAZ;
    AppMethodBeat.o(118075);
  }
  
  public static final Object b(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118073);
    if (paramObject == null) {
      paramObject = i(paramf);
    }
    while (paramObject == Integer.valueOf(0))
    {
      paramf = ajAT;
      AppMethodBeat.o(118073);
      return paramf;
    }
    if ((paramObject instanceof Integer))
    {
      paramf = paramf.fold(new aj(paramf, ((Number)paramObject).intValue()), ajAW);
      AppMethodBeat.o(118073);
      return paramf;
    }
    paramf = ((cy)paramObject).c(paramf);
    AppMethodBeat.o(118073);
    return paramf;
  }
  
  public static final void c(f paramf, Object paramObject)
  {
    AppMethodBeat.i(118074);
    if (paramObject == ajAT)
    {
      AppMethodBeat.o(118074);
      return;
    }
    int i;
    if ((paramObject instanceof aj))
    {
      paramf = (aj)paramObject;
      i = paramf.ajBb.length - 1;
      if (i < 0) {}
    }
    for (;;)
    {
      int j = i - 1;
      paramObject = paramf.ajBb[i];
      s.checkNotNull(paramObject);
      paramObject.iD(paramf.aqm[i]);
      if (j < 0)
      {
        AppMethodBeat.o(118074);
        return;
        paramf = paramf.fold(null, ajAV);
        if (paramf == null)
        {
          paramf = new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
          AppMethodBeat.o(118074);
          throw paramf;
        }
        ((cy)paramf).iD(paramObject);
        AppMethodBeat.o(118074);
        return;
      }
      i = j;
    }
  }
  
  public static final Object i(f paramf)
  {
    AppMethodBeat.i(118072);
    paramf = paramf.fold(Integer.valueOf(0), ajAU);
    s.checkNotNull(paramf);
    AppMethodBeat.o(118072);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<aj, f.b, aj>
  {
    public static final c ajAZ;
    
    static
    {
      AppMethodBeat.i(118110);
      ajAZ = new c();
      AppMethodBeat.o(118110);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.ag
 * JD-Core Version:    0.7.0.1
 */