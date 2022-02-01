package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a;
import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.d.g;
import d.g.b.k;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"})
public abstract class y
  extends a
  implements e
{
  public static final a Kdt = new a((byte)0);
  
  public y()
  {
    super((f.c)e.JgC);
  }
  
  public abstract void a(f paramf, Runnable paramRunnable);
  
  public final <T> d<T> b(d<? super T> paramd)
  {
    return (d)new ap(this, paramd);
  }
  
  public final void c(d<?> paramd)
  {
    if (paramd == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }
    Object localObject = ((ap)paramd)._reusableCancellableContinuation;
    paramd = localObject;
    if (!(localObject instanceof i)) {
      paramd = null;
    }
    paramd = (i)paramd;
    if (paramd != null) {
      paramd.fKK();
    }
  }
  
  public boolean fKU()
  {
    return true;
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    k.h(paramc, "key");
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
    if (e.JgC == paramc) {
      return (f.b)this;
    }
    return null;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    k.h(paramc, "key");
    if ((paramc instanceof d.d.b))
    {
      if ((((d.d.b)paramc).a(getKey())) && (((d.d.b)paramc).a((f.b)this) != null)) {
        return (f)g.JgF;
      }
      return (f)this;
    }
    if (e.JgC == paramc) {
      return (f)g.JgF;
    }
    return (f)this;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends d.d.b<e, y>
  {
    private a()
    {
      super((d.g.a.b)1.Kdu);
      AppMethodBeat.i(189985);
      AppMethodBeat.o(189985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.y
 * JD-Core Version:    0.7.0.1
 */