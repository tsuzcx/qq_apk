package kotlin.d.b.a;

import kotlin.Metadata;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
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
    s.checkNotNull(localf);
    return localf;
  }
  
  public final kotlin.d.d<Object> intercepted()
  {
    kotlin.d.d locald = this.intercepted;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (e)getContext().get((f.c)e.aiwc);
      if (localObject != null)
      {
        locald = ((e)localObject).as((kotlin.d.d)this);
        localObject = locald;
        if (locald != null) {}
      }
      else
      {
        localObject = (kotlin.d.d)this;
      }
      this.intercepted = ((kotlin.d.d)localObject);
    }
    return localObject;
  }
  
  protected void releaseIntercepted()
  {
    kotlin.d.d locald = this.intercepted;
    if ((locald != null) && (locald != (d)this))
    {
      f.b localb = getContext().get((f.c)e.aiwc);
      s.checkNotNull(localb);
      ((e)localb).at(locald);
    }
    this.intercepted = ((kotlin.d.d)c.aiwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */