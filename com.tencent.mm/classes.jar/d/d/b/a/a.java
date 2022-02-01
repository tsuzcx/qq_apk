package d.d.b.a;

import d.g.b.k;
import d.l;
import d.p;
import d.p.a;
import d.q;
import d.y;
import java.io.Serializable;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class a
  implements d, d.d.d<Object>, Serializable
{
  final d.d.d<Object> KUl;
  
  public a(d.d.d<Object> paramd)
  {
    this.KUl = paramd;
  }
  
  public d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
  {
    k.h(paramd, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  protected abstract Object cO(Object paramObject);
  
  public final void eK(Object paramObject)
  {
    d.d.d locald;
    for (a locala = (a)this;; locala = (a)locald)
    {
      k.h((d.d.d)locala, "frame");
      locald = locala.KUl;
      if (locald == null) {
        k.fOy();
      }
      try
      {
        paramObject = locala.cO(paramObject);
        if (paramObject == d.d.a.a.KUd) {
          return;
        }
        locala1 = p.KTg;
        paramObject = p.eI(paramObject);
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          p.a locala1 = p.KTg;
          paramObject = p.eI(q.n(paramObject));
        }
        locald.eK(paramObject);
      }
      locala.fOj();
      if (!(locald instanceof a)) {
        break;
      }
    }
  }
  
  public final d fOh()
  {
    d.d.d locald2 = this.KUl;
    d.d.d locald1 = locald2;
    if (!(locald2 instanceof d)) {
      locald1 = null;
    }
    return (d)locald1;
  }
  
  public final StackTraceElement fOi()
  {
    return f.a(this);
  }
  
  protected void fOj() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Continuation at ");
    Object localObject = f.a(this);
    if (localObject != null) {}
    for (localObject = (Serializable)localObject;; localObject = (Serializable)getClass().getName()) {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */