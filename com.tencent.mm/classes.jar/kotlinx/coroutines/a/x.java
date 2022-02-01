package kotlinx.coroutines.a;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveOrNull", "tryReceive", "tryReceive-PtdJZtk", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface x<E>
{
  public abstract void a(CancellationException paramCancellationException);
  
  public abstract Object aA(d<? super E> paramd);
  
  public abstract Object aB(d<? super l<? extends E>> paramd);
  
  public abstract Object kCV();
  
  public abstract j<E> kCW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.x
 * JD-Core Version:    0.7.0.1
 */