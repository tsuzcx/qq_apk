package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a;
import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.d.g;
import d.g.b.p;
import d.g.b.q;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"})
public abstract class ac
  extends a
  implements e
{
  public static final a NHQ = new a((byte)0);
  
  public ac()
  {
    super((f.c)e.MKV);
  }
  
  public abstract void a(f paramf, Runnable paramRunnable);
  
  public final <T> d<T> b(d<? super T> paramd)
  {
    return (d)new au(this, paramd);
  }
  
  public final void c(d<?> paramd)
  {
    if (paramd == null) {
      throw new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }
    Object localObject = ((au)paramd)._reusableCancellableContinuation;
    paramd = localObject;
    if (!(localObject instanceof l)) {
      paramd = null;
    }
    paramd = (l)paramd;
    if (paramd != null) {
      paramd.guR();
    }
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    p.h(paramc, "key");
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
    if (e.MKV == paramc) {
      return (f.b)this;
    }
    return null;
  }
  
  public boolean gvb()
  {
    return true;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    p.h(paramc, "key");
    if ((paramc instanceof d.d.b))
    {
      if ((((d.d.b)paramc).a(getKey())) && (((d.d.b)paramc).a((f.b)this) != null)) {
        return (f)g.MKY;
      }
      return (f)this;
    }
    if (e.MKV == paramc) {
      return (f)g.MKY;
    }
    return (f)this;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends d.d.b<e, ac>
  {
    private a()
    {
      super((d.g.a.b)1.NHR);
      AppMethodBeat.i(190704);
      AppMethodBeat.o(190704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ac
 * JD-Core Version:    0.7.0.1
 */