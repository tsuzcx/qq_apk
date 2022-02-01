package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowOperatorImpl;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "dropChannelOperators", "flowCollect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<T>
  extends h<T, T>
{
  public i(kotlinx.coroutines.b.g<? extends T> paramg, f paramf, int paramInt, kotlinx.coroutines.a.g paramg1)
  {
    super(paramg, paramf, paramInt, paramg1);
  }
  
  protected final e<T> a(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189219);
    paramf = (e)new i(this.bLH, paramf, paramInt, paramg);
    AppMethodBeat.o(189219);
    return paramf;
  }
  
  protected final Object c(kotlinx.coroutines.b.h<? super T> paramh, d<? super ah> paramd)
  {
    AppMethodBeat.i(189228);
    paramh = this.bLH.a(paramh, paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(189228);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(189228);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.i
 * JD-Core Version:    0.7.0.1
 */