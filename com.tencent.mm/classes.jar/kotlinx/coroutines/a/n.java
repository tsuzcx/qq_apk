package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class n<E>
  extends aa
  implements y<E>
{
  public final Throwable aoY;
  
  public n(Throwable paramThrowable)
  {
    this.aoY = paramThrowable;
  }
  
  public final void d(n<?> paramn)
  {
    AppMethodBeat.i(189321);
    if (au.ASSERTIONS_ENABLED)
    {
      paramn = new AssertionError();
      AppMethodBeat.o(189321);
      throw paramn;
    }
    AppMethodBeat.o(189321);
  }
  
  public final ac iQ(E paramE)
  {
    return r.ajvr;
  }
  
  public final void iR(E paramE) {}
  
  public final ac kDh()
  {
    return r.ajvr;
  }
  
  public final void kDi() {}
  
  public final Throwable kDr()
  {
    AppMethodBeat.i(189278);
    Throwable localThrowable = this.aoY;
    if (localThrowable == null)
    {
      localThrowable = (Throwable)new p("Channel was closed");
      AppMethodBeat.o(189278);
      return localThrowable;
    }
    AppMethodBeat.o(189278);
    return localThrowable;
  }
  
  public final Throwable kDs()
  {
    AppMethodBeat.i(189285);
    Throwable localThrowable = this.aoY;
    if (localThrowable == null)
    {
      localThrowable = (Throwable)new o("Channel was closed");
      AppMethodBeat.o(189285);
      return localThrowable;
    }
    AppMethodBeat.o(189285);
    return localThrowable;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189329);
    String str = "Closed@" + Integer.toHexString(System.identityHashCode(this)) + '[' + this.aoY + ']';
    AppMethodBeat.o(189329);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.n
 * JD-Core Version:    0.7.0.1
 */