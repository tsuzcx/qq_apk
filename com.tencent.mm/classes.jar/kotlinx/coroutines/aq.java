package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.c;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
class aq<T>
  extends a<T>
  implements ap<T>
{
  public aq(f paramf, boolean paramBoolean)
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
  
  public final T gdL()
  {
    AppMethodBeat.i(191257);
    Object localObject = gee();
    if (!(localObject instanceof bj)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("This job has not completed yet".toString());
      AppMethodBeat.o(191257);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof t))
    {
      localObject = ((t)localObject).cause;
      AppMethodBeat.o(191257);
      throw ((Throwable)localObject);
    }
    localObject = bt.fS(localObject);
    AppMethodBeat.o(191257);
    return localObject;
  }
  
  @e(c="kotlinx.coroutines.DeferredCoroutine", f="Builders.common.kt", l={99}, m="await$suspendImpl")
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"})
  static final class a
    extends c
  {
    int label;
    Object nvt;
    
    a(aq paramaq, d paramd)
    {
      super();
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(118042);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = aq.a(this.LRm, this);
      AppMethodBeat.o(118042);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.aq
 * JD-Core Version:    0.7.0.1
 */