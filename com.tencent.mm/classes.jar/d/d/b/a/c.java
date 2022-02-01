package d.d.b.a;

import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class c
  extends a
{
  private transient d<Object> KUn;
  private final f KUo;
  
  public c(d<Object> paramd) {}
  
  public c(d<Object> paramd, f paramf)
  {
    super(paramd);
    this.KUo = paramf;
  }
  
  public final f fOf()
  {
    f localf = this.KUo;
    if (localf == null) {
      k.fOy();
    }
    return localf;
  }
  
  protected final void fOj()
  {
    d locald = this.KUn;
    if ((locald != null) && (locald != (c)this))
    {
      f.b localb = fOf().get((f.c)e.KTW);
      if (localb == null) {
        k.fOy();
      }
      ((e)localb).c(locald);
    }
    this.KUn = ((d)b.KUm);
  }
  
  public final d<Object> fOk()
  {
    d locald = this.KUn;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (e)fOf().get((f.c)e.KTW);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((e)localObject).b((d)this);; localObject = (d)this)
    {
      this.KUn = ((d)localObject);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */