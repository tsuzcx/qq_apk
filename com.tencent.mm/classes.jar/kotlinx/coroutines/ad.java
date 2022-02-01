package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "idempotentResume", "cancelCause", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelled", "", "getCancelled", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class ad
{
  public final Object ajvA;
  public final Throwable ajvB;
  public final n ajvy;
  public final b<Throwable, ah> ajvz;
  public final Object result;
  
  private ad(Object paramObject1, n paramn, b<? super Throwable, ah> paramb, Object paramObject2, Throwable paramThrowable)
  {
    this.result = paramObject1;
    this.ajvy = paramn;
    this.ajvz = paramb;
    this.ajvA = paramObject2;
    this.ajvB = paramThrowable;
  }
  
  private static ad a(Object paramObject1, n paramn, b<? super Throwable, ah> paramb, Object paramObject2, Throwable paramThrowable)
  {
    AppMethodBeat.i(188891);
    paramObject1 = new ad(paramObject1, paramn, paramb, paramObject2, paramThrowable);
    AppMethodBeat.o(188891);
    return paramObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188926);
    if (this == paramObject)
    {
      AppMethodBeat.o(188926);
      return true;
    }
    if (!(paramObject instanceof ad))
    {
      AppMethodBeat.o(188926);
      return false;
    }
    paramObject = (ad)paramObject;
    if (!s.p(this.result, paramObject.result))
    {
      AppMethodBeat.o(188926);
      return false;
    }
    if (!s.p(this.ajvy, paramObject.ajvy))
    {
      AppMethodBeat.o(188926);
      return false;
    }
    if (!s.p(this.ajvz, paramObject.ajvz))
    {
      AppMethodBeat.o(188926);
      return false;
    }
    if (!s.p(this.ajvA, paramObject.ajvA))
    {
      AppMethodBeat.o(188926);
      return false;
    }
    if (!s.p(this.ajvB, paramObject.ajvB))
    {
      AppMethodBeat.o(188926);
      return false;
    }
    AppMethodBeat.o(188926);
    return true;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(188918);
    int i;
    int j;
    label26:
    int k;
    label35:
    int m;
    if (this.result == null)
    {
      i = 0;
      if (this.ajvy != null) {
        break label92;
      }
      j = 0;
      if (this.ajvz != null) {
        break label103;
      }
      k = 0;
      if (this.ajvA != null) {
        break label114;
      }
      m = 0;
      label45:
      if (this.ajvB != null) {
        break label126;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(188918);
      return (m + (k + (j + i * 31) * 31) * 31) * 31 + n;
      i = this.result.hashCode();
      break;
      label92:
      j = this.ajvy.hashCode();
      break label26;
      label103:
      k = this.ajvz.hashCode();
      break label35;
      label114:
      m = this.ajvA.hashCode();
      break label45;
      label126:
      n = this.ajvB.hashCode();
    }
  }
  
  public final boolean kBU()
  {
    return this.ajvB != null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188910);
    String str = "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.ajvy + ", onCancellation=" + this.ajvz + ", idempotentResume=" + this.ajvA + ", cancelCause=" + this.ajvB + ')';
    AppMethodBeat.o(188910);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ad
 * JD-Core Version:    0.7.0.1
 */