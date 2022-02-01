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
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"})
public abstract class ad
  extends a
  implements e
{
  public static final a TTQ = new a((byte)0);
  
  public ad()
  {
    super((f.c)e.SXH);
  }
  
  public abstract void a(f paramf, Runnable paramRunnable);
  
  public final <T> d<T> c(d<? super T> paramd)
  {
    return (d)new av(this, paramd);
  }
  
  public final void d(d<?> paramd)
  {
    if (paramd == null) {
      throw new t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }
    Object localObject = ((av)paramd)._reusableCancellableContinuation;
    paramd = localObject;
    if (!(localObject instanceof l)) {
      paramd = null;
    }
    paramd = (l)paramd;
    if (paramd != null) {
      paramd.hMx();
    }
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    p.h(paramc, "key");
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
    if (e.SXH == paramc) {
      return (f.b)this;
    }
    return null;
  }
  
  public boolean hMH()
  {
    return true;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    p.h(paramc, "key");
    if ((paramc instanceof kotlin.d.b))
    {
      if ((((kotlin.d.b)paramc).a(getKey())) && (((kotlin.d.b)paramc).a((f.b)this) != null)) {
        return (f)g.SXK;
      }
      return (f)this;
    }
    if (e.SXH == paramc) {
      return (f)g.SXK;
    }
    return (f)this;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends kotlin.d.b<e, ad>
  {
    private a()
    {
      super((kotlin.g.a.b)1.TTR);
      AppMethodBeat.i(192323);
      AppMethodBeat.o(192323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ad
 * JD-Core Version:    0.7.0.1
 */