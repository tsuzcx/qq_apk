package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "", "token", "", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "resume", "value", "onCancellation", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"})
public abstract interface k<T>
  extends d<T>
{
  public abstract void W(b<? super Throwable, x> paramb);
  
  public abstract void a(ad paramad, T paramT);
  
  public abstract void fN(Object paramObject);
  
  public abstract boolean isCompleted();
  
  public abstract Object z(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.k
 * JD-Core Version:    0.7.0.1
 */