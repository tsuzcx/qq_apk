package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.m;
import kotlinx.coroutines.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/SendElement;", "Lkotlinx/coroutines/channels/Send;", "pollResult", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"})
public final class y
  extends w
{
  public final m<x> abxd;
  private final Object abyD;
  
  public y(Object paramObject, m<? super x> paramm)
  {
    this.abyD = paramObject;
    this.abxd = paramm;
  }
  
  public final void d(k<?> paramk)
  {
    AppMethodBeat.i(204557);
    d locald = (d)this.abxd;
    paramk = paramk.iSy();
    Result.Companion localCompanion = Result.Companion;
    locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramk)));
    AppMethodBeat.o(204557);
  }
  
  public final Object iSo()
  {
    return this.abyD;
  }
  
  public final v iSp()
  {
    AppMethodBeat.i(204555);
    Object localObject = this.abxd.fV(x.aazN);
    if (localObject == null)
    {
      AppMethodBeat.o(204555);
      return null;
    }
    if (ap.iRg())
    {
      if (localObject == o.abwj) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new AssertionError();
        AppMethodBeat.o(204555);
        throw ((Throwable)localObject);
      }
    }
    localObject = o.abwj;
    AppMethodBeat.o(204555);
    return localObject;
  }
  
  public final void iSq()
  {
    AppMethodBeat.i(204556);
    this.abxd.fW(o.abwj);
    AppMethodBeat.o(204556);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204558);
    String str = "SendElement@" + Integer.toHexString(System.identityHashCode(this)) + '(' + this.abyD + ')';
    AppMethodBeat.o(204558);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.y
 * JD-Core Version:    0.7.0.1
 */