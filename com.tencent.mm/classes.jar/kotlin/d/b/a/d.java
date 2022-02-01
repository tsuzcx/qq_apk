package kotlin.d.b.a;

import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class d
  extends a
{
  private final f _context;
  private transient kotlin.d.d<Object> intercepted;
  
  public d(kotlin.d.d<Object> paramd) {}
  
  public d(kotlin.d.d<Object> paramd, f paramf)
  {
    super(paramd);
    this._context = paramf;
  }
  
  public f getContext()
  {
    f localf = this._context;
    if (localf == null) {
      p.iCn();
    }
    return localf;
  }
  
  public final kotlin.d.d<Object> intercepted()
  {
    kotlin.d.d locald = this.intercepted;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (e)getContext().get((f.c)e.aaAt);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((e)localObject).i((kotlin.d.d)this);; localObject = (kotlin.d.d)this)
    {
      this.intercepted = ((kotlin.d.d)localObject);
      return localObject;
    }
  }
  
  protected void releaseIntercepted()
  {
    kotlin.d.d locald = this.intercepted;
    if ((locald != null) && (locald != (d)this))
    {
      f.b localb = getContext().get((f.c)e.aaAt);
      if (localb == null) {
        p.iCn();
      }
      ((e)localb).j(locald);
    }
    this.intercepted = ((kotlin.d.d)c.aaAI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */