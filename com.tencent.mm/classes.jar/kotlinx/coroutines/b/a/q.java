package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.a.u;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/FlowProduceCoroutine;", "T", "Lkotlinx/coroutines/channels/ProducerCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class q<T>
  extends u<T>
{
  public q(f paramf, h<T> paramh)
  {
    super(paramf, paramh);
  }
  
  public final boolean Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(189232);
    if ((paramThrowable instanceof l))
    {
      AppMethodBeat.o(189232);
      return true;
    }
    boolean bool = iF(paramThrowable);
    AppMethodBeat.o(189232);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.q
 * JD-Core Version:    0.7.0.1
 */