package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class aa<T>
  extends ci
  implements z<T>
{
  public aa(cb paramcb)
  {
    super(true);
    AppMethodBeat.i(188864);
    f(null);
    AppMethodBeat.o(188864);
  }
  
  public final Object e(d<? super T> paramd)
  {
    AppMethodBeat.i(188877);
    paramd = az(paramd);
    AppMethodBeat.o(188877);
    return paramd;
  }
  
  public final boolean iC(T paramT)
  {
    AppMethodBeat.i(188888);
    boolean bool = iJ(paramT);
    AppMethodBeat.o(188888);
    return bool;
  }
  
  public final boolean kBR()
  {
    return true;
  }
  
  public final T kBS()
  {
    AppMethodBeat.i(188872);
    Object localObject = kCA();
    AppMethodBeat.o(188872);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.aa
 * JD-Core Version:    0.7.0.1
 */