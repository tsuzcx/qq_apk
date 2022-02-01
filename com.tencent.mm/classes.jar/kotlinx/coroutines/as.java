package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
class as<T>
  extends a<T>
  implements ar<T>
{
  public as(kotlin.d.f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    AppMethodBeat.i(118061);
    AppMethodBeat.o(118061);
  }
  
  public final Object g(kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(118059);
    paramd = a(this, paramd);
    AppMethodBeat.o(118059);
    return paramd;
  }
  
  public final T hMS()
  {
    AppMethodBeat.i(192516);
    Object localObject = hNm();
    if (!(localObject instanceof bp)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("This job has not completed yet".toString());
      AppMethodBeat.o(192516);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof v))
    {
      localObject = ((v)localObject).cause;
      AppMethodBeat.o(192516);
      throw ((Throwable)localObject);
    }
    localObject = cb.gd(localObject);
    AppMethodBeat.o(192516);
    return localObject;
  }
  
  @kotlin.d.b.a.f(c="kotlinx.coroutines.DeferredCoroutine", f="Builders.common.kt", hxM={99}, m="await$suspendImpl")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"})
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(as paramas, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(118042);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = as.a(this.TUi, this);
      AppMethodBeat.o(118042);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.as
 * JD-Core Version:    0.7.0.1
 */