package kotlinx.coroutines;

import a.c.a;
import a.c.c;
import a.c.d;
import a.c.e;
import a.c.e.b;
import a.c.e.c;
import a.c.f;
import a.f.b.j;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "toString", "", "kotlinx-coroutines-core"})
public abstract class w
  extends a
  implements d
{
  public w()
  {
    super((e.c)d.BML);
  }
  
  public final <T> c<T> a(c<? super T> paramc)
  {
    j.q(paramc, "continuation");
    return (c)new al(this, paramc);
  }
  
  public abstract void a(e parame, Runnable paramRunnable);
  
  public final void b(c<?> paramc)
  {
    j.q(paramc, "continuation");
    j.q(paramc, "continuation");
  }
  
  public boolean b(e parame)
  {
    j.q(parame, "context");
    return true;
  }
  
  public <E extends e.b> E get(e.c<E> paramc)
  {
    j.q(paramc, "key");
    j.q(paramc, "key");
    if (paramc == d.BML) {
      return (e.b)this;
    }
    return null;
  }
  
  public e minusKey(e.c<?> paramc)
  {
    j.q(paramc, "key");
    j.q(paramc, "key");
    if (paramc == d.BML) {
      return (e)f.BMO;
    }
    return (e)this;
  }
  
  public String toString()
  {
    return af.ea(this) + '@' + af.dZ(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.w
 * JD-Core Version:    0.7.0.1
 */