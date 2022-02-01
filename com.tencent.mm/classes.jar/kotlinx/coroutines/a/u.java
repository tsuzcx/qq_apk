package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.an;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "isActive", "", "()Z", "onCancelled", "", "cause", "", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class u<E>
  extends i<E>
  implements v<E>
{
  public u(f paramf, h<E> paramh)
  {
    super(paramf, paramh);
  }
  
  public final void b(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(189275);
    if ((!kDp().k(paramThrowable)) && (!paramBoolean)) {
      an.b(getContext(), paramThrowable);
    }
    AppMethodBeat.o(189275);
  }
  
  public final boolean isActive()
  {
    AppMethodBeat.i(189269);
    boolean bool = super.isActive();
    AppMethodBeat.o(189269);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.u
 * JD-Core Version:    0.7.0.1
 */