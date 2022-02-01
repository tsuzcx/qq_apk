package kotlinx.coroutines;

import d.d.f.b;
import d.g.a.b;
import d.l;
import d.y;
import java.util.concurrent.CancellationException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
public abstract interface bj
  extends f.b
{
  public static final bj.b Keq = bj.b.Ker;
  
  public abstract au L(b<? super Throwable, y> paramb);
  
  public abstract au a(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, y> paramb);
  
  public abstract m a(o paramo);
  
  public abstract CancellationException fLt();
  
  public abstract void fLu();
  
  public abstract boolean isActive();
  
  public abstract boolean start();
  
  @l(fvt={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bj
 * JD-Core Version:    0.7.0.1
 */