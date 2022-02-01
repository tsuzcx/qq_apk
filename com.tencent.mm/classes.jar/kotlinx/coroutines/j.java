package kotlinx.coroutines;

import d.d.d;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "", "token", "", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "resume", "value", "onCancellation", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"})
public abstract interface j<T>
  extends d<T>
{
  public abstract void K(b<? super Throwable, y> paramb);
  
  public abstract void a(ab paramab, T paramT);
  
  public abstract void fD(Object paramObject);
  
  public abstract boolean isCompleted();
  
  public abstract Object v(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.j
 * JD-Core Version:    0.7.0.1
 */