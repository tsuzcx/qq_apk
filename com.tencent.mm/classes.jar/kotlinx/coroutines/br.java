package kotlinx.coroutines;

import d.d.f.b;
import d.g.a.b;
import d.l;
import d.z;
import java.util.concurrent.CancellationException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
public abstract interface br
  extends f.b
{
  public static final br.b NIM = br.b.NIN;
  
  public abstract ba L(b<? super Throwable, z> paramb);
  
  public abstract q a(s params);
  
  public abstract ba b(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, z> paramb);
  
  public abstract CancellationException gvC();
  
  public abstract void gvD();
  
  public abstract boolean isActive();
  
  public abstract boolean start();
  
  @l(gfx={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.br
 * JD-Core Version:    0.7.0.1
 */