package d.d.b.a;

import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class d
  extends a
{
  private transient d.d.d<Object> MLm;
  private final f MLn;
  
  public d(d.d.d<Object> paramd) {}
  
  public d(d.d.d<Object> paramd, f paramf)
  {
    super(paramd);
    this.MLn = paramf;
  }
  
  public final f gfE()
  {
    f localf = this.MLn;
    if (localf == null) {
      p.gfZ();
    }
    return localf;
  }
  
  protected final void gfI()
  {
    d.d.d locald = this.MLm;
    if ((locald != null) && (locald != (d)this))
    {
      f.b localb = gfE().get((f.c)e.MKV);
      if (localb == null) {
        p.gfZ();
      }
      ((e)localb).c(locald);
    }
    this.MLm = ((d.d.d)c.MLl);
  }
  
  public final d.d.d<Object> gfJ()
  {
    d.d.d locald = this.MLm;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (e)gfE().get((f.c)e.MKV);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((e)localObject).b((d.d.d)this);; localObject = (d.d.d)this)
    {
      this.MLm = ((d.d.d)localObject);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */