package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.a;
import kotlinx.coroutines.by;
import kotlinx.coroutines.bz;
import kotlinx.coroutines.ce;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "isFull", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "getOnReceiveOrClosed", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFair", "kotlinx-coroutines-core"})
public class h<E>
  extends a<x>
  implements g<E>
{
  private final g<E> abyt;
  
  public h(f paramf, g<E> paramg)
  {
    super(paramf, true);
    this.abyt = paramg;
  }
  
  public final void D(Throwable paramThrowable)
  {
    AppMethodBeat.i(204366);
    paramThrowable = ce.a(this, paramThrowable);
    this.abyt.a(paramThrowable);
    E((Throwable)paramThrowable);
    AppMethodBeat.o(204366);
  }
  
  public final boolean I(Throwable paramThrowable)
  {
    AppMethodBeat.i(204368);
    boolean bool = this.abyt.I(paramThrowable);
    AppMethodBeat.o(204368);
    return bool;
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    AppMethodBeat.i(204365);
    if (paramCancellationException != null) {}
    for (paramCancellationException = (Throwable)paramCancellationException;; paramCancellationException = (Throwable)new bz(ce.a(paramCancellationException), null, (by)paramCancellationException))
    {
      D(paramCancellationException);
      AppMethodBeat.o(204365);
      return;
      paramCancellationException = (ce)this;
    }
  }
  
  public final Object c(E paramE, d<? super x> paramd)
  {
    AppMethodBeat.i(204373);
    paramE = this.abyt.c(paramE, paramd);
    AppMethodBeat.o(204373);
    return paramE;
  }
  
  protected final g<E> iSx()
  {
    return this.abyt;
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(204369);
    boolean bool = this.abyt.offer(paramE);
    AppMethodBeat.o(204369);
    return bool;
  }
  
  public final Object q(d<? super E> paramd)
  {
    AppMethodBeat.i(204371);
    paramd = this.abyt.q(paramd);
    AppMethodBeat.o(204371);
    return paramd;
  }
  
  public final Object r(d<? super z<? extends E>> paramd)
  {
    AppMethodBeat.i(204372);
    paramd = this.abyt.r(paramd);
    AppMethodBeat.o(204372);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.h
 * JD-Core Version:    0.7.0.1
 */