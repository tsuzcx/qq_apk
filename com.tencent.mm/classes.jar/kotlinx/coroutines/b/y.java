package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.b.a.r;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/ReadonlySharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "flow", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlinx/coroutines/Job;)V", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class y<T>
  implements r<T>, ab<T>, c<T>
{
  private final cb job = null;
  
  public y(ab<? extends T> paramab)
  {
    this.ajyR = paramab;
  }
  
  public final Object a(h<? super T> paramh, d<? super ah> paramd)
  {
    AppMethodBeat.i(189247);
    paramh = this.ajyR.a(paramh, paramd);
    AppMethodBeat.o(189247);
    return paramh;
  }
  
  public final g<T> b(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189256);
    paramf = ad.a((ab)this, paramf, paramInt, paramg);
    AppMethodBeat.o(189256);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.y
 * JD-Core Version:    0.7.0.1
 */