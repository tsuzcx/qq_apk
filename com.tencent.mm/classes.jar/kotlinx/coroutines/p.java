package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "", "token", "", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "resume", "value", "onCancellation", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface p<T>
  extends d<T>
{
  public abstract Object O(Throwable paramThrowable);
  
  public abstract boolean P(Throwable paramThrowable);
  
  public abstract void a(al paramal, T paramT);
  
  public abstract void bg(b<? super Throwable, ah> paramb);
  
  public abstract Object c(T paramT, b<? super Throwable, ah> paramb);
  
  public abstract void d(T paramT, b<? super Throwable, ah> paramb);
  
  public abstract boolean isActive();
  
  public abstract boolean isCompleted();
  
  public abstract Object ix(T paramT);
  
  public abstract void iy(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.p
 * JD-Core Version:    0.7.0.1
 */