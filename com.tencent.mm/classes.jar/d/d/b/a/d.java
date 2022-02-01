package d.d.b.a;

import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class d
  extends a
{
  private transient d.d.d<Object> Nip;
  private final f Niq;
  
  public d(d.d.d<Object> paramd) {}
  
  public d(d.d.d<Object> paramd, f paramf)
  {
    super(paramd);
    this.Niq = paramf;
  }
  
  public final f gkg()
  {
    f localf = this.Niq;
    if (localf == null) {
      p.gkB();
    }
    return localf;
  }
  
  protected final void gkk()
  {
    d.d.d locald = this.Nip;
    if ((locald != null) && (locald != (d)this))
    {
      f.b localb = gkg().get((f.c)e.NhY);
      if (localb == null) {
        p.gkB();
      }
      ((e)localb).c(locald);
    }
    this.Nip = ((d.d.d)c.Nio);
  }
  
  public final d.d.d<Object> gkl()
  {
    d.d.d locald = this.Nip;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (e)gkg().get((f.c)e.NhY);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((e)localObject).b((d.d.d)this);; localObject = (d.d.d)this)
    {
      this.Nip = ((d.d.d)localObject);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */