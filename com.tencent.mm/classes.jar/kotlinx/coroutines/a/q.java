package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.ah;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "isActive", "", "()Z", "onCancelled", "", "cause", "", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "kotlinx-coroutines-core"})
public final class q<E>
  extends h<E>
  implements r<E>
{
  public q(f paramf, g<E> paramg)
  {
    super(paramf, paramg);
  }
  
  public final void b(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(204483);
    if ((!iSx().I(paramThrowable)) && (!paramBoolean)) {
      ah.b(getContext(), paramThrowable);
    }
    AppMethodBeat.o(204483);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(204480);
    boolean bool = super.isActive();
    AppMethodBeat.o(204480);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.q
 * JD-Core Version:    0.7.0.1
 */