package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlinx.coroutines.internal.ag;

@Metadata(d1={""}, d2={"withContextUndispatched", "T", "V", "newContext", "Lkotlin/coroutines/CoroutineContext;", "value", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final <T, V> Object a(kotlin.d.f paramf, V paramV, Object paramObject, m<? super V, ? super d<? super T>, ? extends Object> paramm, d<? super T> paramd)
  {
    AppMethodBeat.i(189188);
    paramObject = ag.b(paramf, paramObject);
    d locald;
    try
    {
      locald = (d)new z(paramd, paramf);
      if (paramm == null)
      {
        paramV = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(189188);
        throw paramV;
      }
    }
    finally
    {
      ag.c(paramf, paramObject);
      AppMethodBeat.o(189188);
    }
    paramV = ((m)an.y(paramm, 2)).invoke(paramV, locald);
    ag.c(paramf, paramObject);
    if (paramV == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(189188);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.f
 * JD-Core Version:    0.7.0.1
 */