package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.d.a;
import kotlin.d.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.d.f.c<TE;>;
import kotlin.d.g;
import kotlin.g.b.s;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class al
  extends a
  implements e
{
  public static final al.a ajvE = new al.a((byte)0);
  
  public al()
  {
    super((f.c)e.aiwc);
  }
  
  public abstract void a(f paramf, Runnable paramRunnable);
  
  public final <T> d<T> as(d<? super T> paramd)
  {
    return (d)new h(this, paramd);
  }
  
  public final void at(d<?> paramd)
  {
    paramd = (h)paramd;
    while (paramd._reusableCancellableContinuation == i.ajAn) {}
    paramd = paramd._reusableCancellableContinuation;
    if ((paramd instanceof q)) {}
    for (paramd = (q)paramd;; paramd = null)
    {
      if (paramd != null) {
        paramd.kBI();
      }
      return;
    }
  }
  
  public void b(f paramf, Runnable paramRunnable)
  {
    a(paramf, paramRunnable);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    Object localObject = (e)this;
    s.u(paramc, "key");
    if ((paramc instanceof b))
    {
      if (((b)paramc).a(((e)localObject).getKey()))
      {
        localObject = ((b)paramc).a((f.b)localObject);
        paramc = (f.c<E>)localObject;
        if ((localObject instanceof f.b)) {}
      }
      else
      {
        paramc = null;
      }
      return paramc;
    }
    if (e.aiwc == paramc) {
      return (f.b)localObject;
    }
    return null;
  }
  
  public boolean kBY()
  {
    return true;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    e locale = (e)this;
    s.u(paramc, "key");
    if ((paramc instanceof b))
    {
      if ((((b)paramc).a(locale.getKey())) && (((b)paramc).a((f.b)locale) != null)) {
        return (f)g.aiwf;
      }
      return (f)locale;
    }
    if (e.aiwc == paramc) {
      return (f)g.aiwf;
    }
    return (f)locale;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.al
 * JD-Core Version:    0.7.0.1
 */