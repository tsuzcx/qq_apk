package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a;
import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.d.g;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"})
public abstract class ab
  extends a
  implements e
{
  public static final a LQV = new a((byte)0);
  
  public ab()
  {
    super((f.c)e.KTW);
  }
  
  public abstract void a(f paramf, Runnable paramRunnable);
  
  public final <T> d<T> b(d<? super T> paramd)
  {
    return (d)new at(this, paramd);
  }
  
  public final void c(d<?> paramd)
  {
    if (paramd == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }
    Object localObject = ((at)paramd)._reusableCancellableContinuation;
    paramd = localObject;
    if (!(localObject instanceof k)) {
      paramd = null;
    }
    paramd = (k)paramd;
    if (paramd != null) {
      paramd.gdr();
    }
  }
  
  public boolean gdB()
  {
    return true;
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    d.g.b.k.h(paramc, "key");
    if ((paramc instanceof d.d.b))
    {
      if (((d.d.b)paramc).a(getKey()))
      {
        f.b localb = ((d.d.b)paramc).a((f.b)this);
        paramc = localb;
        if ((localb instanceof f.b)) {}
      }
      else
      {
        paramc = null;
      }
      return paramc;
    }
    if (e.KTW == paramc) {
      return (f.b)this;
    }
    return null;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    d.g.b.k.h(paramc, "key");
    if ((paramc instanceof d.d.b))
    {
      if ((((d.d.b)paramc).a(getKey())) && (((d.d.b)paramc).a((f.b)this) != null)) {
        return (f)g.KTZ;
      }
      return (f)this;
    }
    if (e.KTW == paramc) {
      return (f)g.KTZ;
    }
    return (f)this;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends d.d.b<e, ab>
  {
    private a()
    {
      super((d.g.a.b)1.LQW);
      AppMethodBeat.i(191094);
      AppMethodBeat.o(191094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ab
 * JD-Core Version:    0.7.0.1
 */