package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.d.f;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
class am<T>
  extends a<T>
  implements al<T>
{
  public am(f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    AppMethodBeat.i(118061);
    AppMethodBeat.o(118061);
  }
  
  public final Object f(d<? super T> paramd)
  {
    AppMethodBeat.i(118059);
    paramd = a(this, paramd);
    AppMethodBeat.o(118059);
    return paramd;
  }
  
  public final T gaF()
  {
    AppMethodBeat.i(202373);
    Object localObject = fLv();
    if (!(localObject instanceof be)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("This job has not completed yet".toString());
      AppMethodBeat.o(202373);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof q))
    {
      localObject = ((q)localObject).cause;
      AppMethodBeat.o(202373);
      throw ((Throwable)localObject);
    }
    localObject = bo.fK(localObject);
    AppMethodBeat.o(202373);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.am
 * JD-Core Version:    0.7.0.1
 */