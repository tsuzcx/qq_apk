package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/AbstractContinuation;", "Lkotlinx/coroutines/CancellableContinuation;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "completeResume", "", "token", "", "getSuccessfulResult", "state", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "nameString", "", "tryResume", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"})
public final class j<T>
  extends a<T>
  implements Runnable, i<T>
{
  private final e CHl;
  
  public j(c<? super T> paramc)
  {
    super(paramc);
    AppMethodBeat.i(118526);
    this.CHl = paramc.eaV();
    AppMethodBeat.o(118526);
  }
  
  public final void a(w paramw, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118524);
    a.f.b.j.q(paramw, "receiver$0");
    Object localObject3 = this.BMP;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof al)) {
      localObject1 = null;
    }
    localObject3 = (al)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((al)localObject3).CHN;
    }
    if (localObject1 == paramw) {}
    for (int i = 3;; i = this.CHQ)
    {
      k(paramT, i);
      AppMethodBeat.o(118524);
      return;
    }
  }
  
  public final <T> T dX(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof s)) {
      localObject = ((s)paramObject).result;
    }
    return localObject;
  }
  
  public final e eaV()
  {
    return this.CHl;
  }
  
  protected final String epo()
  {
    AppMethodBeat.i(118525);
    String str = "CancellableContinuation(" + af.d(this.BMP) + ')';
    AppMethodBeat.o(118525);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.j
 * JD-Core Version:    0.7.0.1
 */