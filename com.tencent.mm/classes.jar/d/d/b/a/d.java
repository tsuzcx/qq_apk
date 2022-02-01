package d.d.b.a;

import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class d
  extends a
{
  private transient d.d.d<Object> JgT;
  private final f JgU;
  
  public d(d.d.d<Object> paramd) {}
  
  public d(d.d.d<Object> paramd, f paramf)
  {
    super(paramd);
    this.JgU = paramf;
  }
  
  public final f fvA()
  {
    f localf = this.JgU;
    if (localf == null) {
      k.fvU();
    }
    return localf;
  }
  
  protected final void fvE()
  {
    d.d.d locald = this.JgT;
    if ((locald != null) && (locald != (d)this))
    {
      f.b localb = fvA().get((f.c)e.JgC);
      if (localb == null) {
        k.fvU();
      }
      ((e)localb).c(locald);
    }
    this.JgT = ((d.d.d)c.JgS);
  }
  
  public final d.d.d<Object> fvF()
  {
    d.d.d locald = this.JgT;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (e)fvA().get((f.c)e.JgC);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((e)localObject).b((d.d.d)this);; localObject = (d.d.d)this)
    {
      this.JgT = ((d.d.d)localObject);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */