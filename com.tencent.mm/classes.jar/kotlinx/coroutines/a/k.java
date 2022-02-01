package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"})
public final class k<E>
  extends w
  implements u<E>
{
  public final Throwable abyu;
  
  public k(Throwable paramThrowable)
  {
    this.abyu = paramThrowable;
  }
  
  public final void d(k<?> paramk)
  {
    AppMethodBeat.i(204386);
    if (ap.iRg())
    {
      paramk = (Throwable)new AssertionError();
      AppMethodBeat.o(204386);
      throw paramk;
    }
    AppMethodBeat.o(204386);
  }
  
  public final v gn(E paramE)
  {
    return o.abwj;
  }
  
  public final void iSf() {}
  
  public final v iSp()
  {
    return o.abwj;
  }
  
  public final void iSq() {}
  
  public final Throwable iSy()
  {
    AppMethodBeat.i(204379);
    Throwable localThrowable2 = this.abyu;
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 == null) {
      localThrowable1 = (Throwable)new m("Channel was closed");
    }
    AppMethodBeat.o(204379);
    return localThrowable1;
  }
  
  public final Throwable iSz()
  {
    AppMethodBeat.i(204381);
    Throwable localThrowable2 = this.abyu;
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 == null) {
      localThrowable1 = (Throwable)new l("Channel was closed");
    }
    AppMethodBeat.o(204381);
    return localThrowable1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204387);
    String str = "Closed@" + Integer.toHexString(System.identityHashCode(this)) + '[' + this.abyu + ']';
    AppMethodBeat.o(204387);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.k
 * JD-Core Version:    0.7.0.1
 */