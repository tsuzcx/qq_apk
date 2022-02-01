package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
class au<T>
  extends a<T>
  implements at<T>
{
  public au(f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    AppMethodBeat.i(118061);
    AppMethodBeat.o(118061);
  }
  
  public final T iRo()
  {
    AppMethodBeat.i(204630);
    Object localObject = iRJ();
    if (!(localObject instanceof bt)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("This job has not completed yet".toString());
      AppMethodBeat.o(204630);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof x))
    {
      localObject = ((x)localObject).cause;
      AppMethodBeat.o(204630);
      throw ((Throwable)localObject);
    }
    localObject = cf.gl(localObject);
    AppMethodBeat.o(204630);
    return localObject;
  }
  
  public final Object n(kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(118059);
    paramd = a(this, paramd);
    AppMethodBeat.o(118059);
    return paramd;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"})
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(au paramau, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(118042);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = au.a(this.abwL, this);
      AppMethodBeat.o(118042);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.au
 * JD-Core Version:    0.7.0.1
 */