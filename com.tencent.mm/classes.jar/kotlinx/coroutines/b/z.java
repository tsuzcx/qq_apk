package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.b.a.r;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/ReadonlyStateFlow;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "flow", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/Job;)V", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "value", "getValue", "()Ljava/lang/Object;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class z<T>
  implements r<T>, af<T>, c<T>
{
  private final cb job = null;
  
  public z(af<? extends T> paramaf)
  {
    this.ajyS = paramaf;
  }
  
  public final Object a(h<? super T> paramh, d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(189255);
    paramh = this.ajyS.a(paramh, paramd);
    AppMethodBeat.o(189255);
    return paramh;
  }
  
  public final g<T> b(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189267);
    paramf = ah.a((af)this, paramf, paramInt, paramg);
    AppMethodBeat.o(189267);
    return paramf;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(189261);
    Object localObject = this.ajyS.getValue();
    AppMethodBeat.o(189261);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.z
 * JD-Core Version:    0.7.0.1
 */