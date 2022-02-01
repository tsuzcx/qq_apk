package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.d.f.b;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
public abstract interface by
  extends f.b
{
  public static final by.b abxs = by.b.abxt;
  
  public abstract be a(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, x> paramb);
  
  public abstract s a(u paramu);
  
  public abstract void a(CancellationException paramCancellationException);
  
  public abstract be an(b<? super Throwable, x> paramb);
  
  public abstract CancellationException iRF();
  
  public abstract boolean isActive();
  
  public abstract boolean isCompleted();
  
  public abstract Object o(d<? super x> paramd);
  
  public abstract boolean start();
  
  @l(iBK={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.by
 * JD-Core Version:    0.7.0.1
 */