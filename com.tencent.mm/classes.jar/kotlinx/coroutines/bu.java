package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
public abstract interface bu
  extends f.b
{
  public static final b TUO = b.TUP;
  
  public abstract bc X(b<? super Throwable, x> paramb);
  
  public abstract q a(s params);
  
  public abstract void a(CancellationException paramCancellationException);
  
  public abstract bc b(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, x> paramb);
  
  public abstract CancellationException hNj();
  
  public abstract boolean isActive();
  
  public abstract boolean isCompleted();
  
  public abstract boolean start();
  
  @l(hxD={1, 1, 16})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"})
  public static final class b
    implements f.c<bu>
  {
    static
    {
      AppMethodBeat.i(118188);
      TUP = new b();
      CoroutineExceptionHandler.a locala = CoroutineExceptionHandler.TTS;
      AppMethodBeat.o(118188);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bu
 * JD-Core Version:    0.7.0.1
 */