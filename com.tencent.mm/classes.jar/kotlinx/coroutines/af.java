package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.d.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"})
public abstract class af
  extends a
  implements e
{
  public static final a abwu = new a((byte)0);
  
  public af()
  {
    super((f.c)e.aaAt);
  }
  
  public abstract void a(f paramf, Runnable paramRunnable);
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    p.k(paramc, "key");
    if ((paramc instanceof kotlin.d.b))
    {
      if (((kotlin.d.b)paramc).a(getKey()))
      {
        f.b localb = ((kotlin.d.b)paramc).a((f.b)this);
        paramc = localb;
        if ((localb instanceof f.b)) {}
      }
      else
      {
        paramc = null;
      }
      return paramc;
    }
    if (e.aaAt == paramc) {
      return (f.b)this;
    }
    return null;
  }
  
  public final <T> d<T> i(d<? super T> paramd)
  {
    return (d)new ax(this, paramd);
  }
  
  public boolean iRd()
  {
    return true;
  }
  
  public final void j(d<?> paramd)
  {
    if (paramd == null) {
      throw new t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }
    Object localObject = ((ax)paramd)._reusableCancellableContinuation;
    paramd = localObject;
    if (!(localObject instanceof n)) {
      paramd = null;
    }
    paramd = (n)paramd;
    if (paramd != null) {
      paramd.iQS();
    }
  }
  
  public f minusKey(f.c<?> paramc)
  {
    p.k(paramc, "key");
    if ((paramc instanceof kotlin.d.b))
    {
      if ((((kotlin.d.b)paramc).a(getKey())) && (((kotlin.d.b)paramc).a((f.b)this) != null)) {
        return (f)g.aaAw;
      }
      return (f)this;
    }
    if (e.aaAt == paramc) {
      return (f)g.aaAw;
    }
    return (f)this;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends kotlin.d.b<e, af>
  {
    private a()
    {
      super((kotlin.g.a.b)1.abwv);
      AppMethodBeat.i(204315);
      AppMethodBeat.o(204315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.af
 * JD-Core Version:    0.7.0.1
 */