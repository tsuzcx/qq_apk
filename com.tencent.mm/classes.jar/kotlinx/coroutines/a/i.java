package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cc;
import kotlinx.coroutines.ci;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "initParentJob", "", "active", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive", "tryReceive-PtdJZtk", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class i<E>
  extends kotlinx.coroutines.a<ah>
  implements h<E>
{
  private final h<E> ajxE;
  
  public i(f paramf, h<E> paramh)
  {
    super(paramf, true);
    this.ajxE = paramh;
  }
  
  public final boolean Ij()
  {
    AppMethodBeat.i(189313);
    boolean bool = this.ajxE.Ij();
    AppMethodBeat.o(189313);
    return bool;
  }
  
  public final void T(Throwable paramThrowable)
  {
    AppMethodBeat.i(189382);
    paramThrowable = ci.a((ci)this, paramThrowable);
    this.ajxE.a(paramThrowable);
    U((Throwable)paramThrowable);
    AppMethodBeat.o(189382);
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    AppMethodBeat.i(189374);
    if (isCancelled())
    {
      AppMethodBeat.o(189374);
      return;
    }
    if (paramCancellationException == null) {
      paramCancellationException = (CancellationException)new cc(ci.a((ci)this), null, (cb)this);
    }
    for (;;)
    {
      T((Throwable)paramCancellationException);
      AppMethodBeat.o(189374);
      return;
    }
  }
  
  public final Object aA(d<? super E> paramd)
  {
    AppMethodBeat.i(189349);
    paramd = this.ajxE.aA(paramd);
    AppMethodBeat.o(189349);
    return paramd;
  }
  
  public final Object aB(d<? super l<? extends E>> paramd)
  {
    AppMethodBeat.i(189359);
    paramd = this.ajxE.aB(paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(189359);
      return paramd;
    }
    AppMethodBeat.o(189359);
    return paramd;
  }
  
  public final Object b(E paramE, d<? super ah> paramd)
  {
    AppMethodBeat.i(189366);
    paramE = this.ajxE.b(paramE, paramd);
    AppMethodBeat.o(189366);
    return paramE;
  }
  
  public final Object iV(E paramE)
  {
    AppMethodBeat.i(189340);
    paramE = this.ajxE.iV(paramE);
    AppMethodBeat.o(189340);
    return paramE;
  }
  
  public final boolean k(Throwable paramThrowable)
  {
    AppMethodBeat.i(189319);
    boolean bool = this.ajxE.k(paramThrowable);
    AppMethodBeat.o(189319);
    return bool;
  }
  
  public final Object kCV()
  {
    AppMethodBeat.i(189333);
    Object localObject = this.ajxE.kCV();
    AppMethodBeat.o(189333);
    return localObject;
  }
  
  public final j<E> kCW()
  {
    AppMethodBeat.i(189323);
    j localj = this.ajxE.kCW();
    AppMethodBeat.o(189323);
    return localj;
  }
  
  protected final h<E> kDp()
  {
    return this.ajxE;
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(189298);
    boolean bool = this.ajxE.offer(paramE);
    AppMethodBeat.o(189298);
    return bool;
  }
  
  public final void p(b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(189305);
    this.ajxE.p(paramb);
    AppMethodBeat.o(189305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.i
 * JD-Core Version:    0.7.0.1
 */