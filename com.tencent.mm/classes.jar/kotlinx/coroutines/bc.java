package kotlinx.coroutines;

import a.c.e.b;
import a.f.a.b;
import a.l;
import a.y;
import java.util.concurrent.CancellationException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "cancel0", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
public abstract interface bc
  extends e.b
{
  public static final bc.b CIk = bc.b.CIl;
  
  public abstract ap a(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, y> paramb);
  
  public abstract m a(o paramo);
  
  public abstract CancellationException epQ();
  
  public abstract boolean isActive();
  
  public abstract boolean start();
  
  public abstract boolean y(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bc
 * JD-Core Version:    0.7.0.1
 */