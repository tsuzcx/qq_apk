package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
class ar<T>
  extends a<T>
  implements aq<T>
{
  public ar(d.d.f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    AppMethodBeat.i(118061);
    AppMethodBeat.o(118061);
  }
  
  public final Object f(d.d.d<? super T> paramd)
  {
    AppMethodBeat.i(118059);
    paramd = a(this, paramd);
    AppMethodBeat.o(118059);
    return paramd;
  }
  
  public final T gzN()
  {
    AppMethodBeat.i(209361);
    Object localObject = gAg();
    if (!(localObject instanceof bm)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("This job has not completed yet".toString());
      AppMethodBeat.o(209361);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof u))
    {
      localObject = ((u)localObject).cause;
      AppMethodBeat.o(209361);
      throw ((Throwable)localObject);
    }
    localObject = bw.fY(localObject);
    AppMethodBeat.o(209361);
    return localObject;
  }
  
  @d.d.b.a.f(c="kotlinx.coroutines.DeferredCoroutine", f="Builders.common.kt", gkn={99}, m="await$suspendImpl")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"})
  static final class a
    extends d.d.b.a.d
  {
    int label;
    Object ocA;
    
    a(ar paramar, d.d.d paramd)
    {
      super();
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(118042);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = ar.a(this.Ofn, this);
      AppMethodBeat.o(118042);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ar
 * JD-Core Version:    0.7.0.1
 */