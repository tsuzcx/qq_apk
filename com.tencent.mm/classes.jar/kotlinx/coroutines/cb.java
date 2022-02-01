package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f.b;
import kotlin.g.a.b;
import kotlin.m.h;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface cb
  extends f.b
{
  public static final cb.b ajws = cb.b.ajwt;
  
  public abstract bi a(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, ah> paramb);
  
  public abstract v a(x paramx);
  
  public abstract void a(CancellationException paramCancellationException);
  
  public abstract Object ay(d<? super ah> paramd);
  
  public abstract bi bh(b<? super Throwable, ah> paramb);
  
  public abstract boolean isActive();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isCompleted();
  
  public abstract CancellationException kCu();
  
  public abstract h<cb> kCv();
  
  public abstract boolean start();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cb
 * JD-Core Version:    0.7.0.1
 */