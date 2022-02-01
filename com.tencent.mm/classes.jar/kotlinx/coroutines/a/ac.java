package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlinx.coroutines.au;
import kotlinx.coroutines.p;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/SendElement;", "E", "Lkotlinx/coroutines/channels/Send;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class ac<E>
  extends aa
{
  public final p<ah> ajwe;
  private final E ajxP;
  
  public ac(E paramE, p<? super ah> paramp)
  {
    this.ajxP = paramE;
    this.ajwe = paramp;
  }
  
  public final void d(n<?> paramn)
  {
    AppMethodBeat.i(189343);
    d locald = (d)this.ajwe;
    paramn = paramn.kDr();
    Result.Companion localCompanion = Result.Companion;
    locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramn)));
    AppMethodBeat.o(189343);
  }
  
  public final E kDg()
  {
    return this.ajxP;
  }
  
  public final kotlinx.coroutines.internal.ac kDh()
  {
    AppMethodBeat.i(189324);
    Object localObject = this.ajwe.ix(ah.aiuX);
    if (localObject == null)
    {
      AppMethodBeat.o(189324);
      return null;
    }
    if (au.ASSERTIONS_ENABLED)
    {
      if (localObject == r.ajvr) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new AssertionError();
        AppMethodBeat.o(189324);
        throw ((Throwable)localObject);
      }
    }
    localObject = r.ajvr;
    AppMethodBeat.o(189324);
    return localObject;
  }
  
  public final void kDi()
  {
    AppMethodBeat.i(189334);
    this.ajwe.iy(r.ajvr);
    AppMethodBeat.o(189334);
  }
  
  public String toString()
  {
    AppMethodBeat.i(189354);
    String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + '(' + this.ajxP + ')';
    AppMethodBeat.o(189354);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.ac
 * JD-Core Version:    0.7.0.1
 */