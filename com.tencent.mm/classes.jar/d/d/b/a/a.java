package d.d.b.a;

import d.d.d;
import d.g.b.k;
import d.l;
import d.p;
import d.p.a;
import d.q;
import d.y;
import java.io.Serializable;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class a
  implements e, d<Object>, Serializable
{
  final d<Object> JgR;
  
  public a(d<Object> paramd)
  {
    this.JgR = paramd;
  }
  
  public d<y> a(Object paramObject, d<?> paramd)
  {
    k.h(paramd, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  protected abstract Object cP(Object paramObject);
  
  public final void eH(Object paramObject)
  {
    d locald;
    for (a locala = (a)this;; locala = (a)locald)
    {
      k.h((d)locala, "frame");
      locald = locala.JgR;
      if (locald == null) {
        k.fvU();
      }
      try
      {
        paramObject = locala.cP(paramObject);
        if (paramObject == d.d.a.a.JgJ) {
          return;
        }
        locala1 = p.JfM;
        paramObject = p.eF(paramObject);
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          p.a locala1 = p.JfM;
          paramObject = p.eF(q.n(paramObject));
        }
        locald.eH(paramObject);
      }
      locala.fvE();
      if (!(locald instanceof a)) {
        break;
      }
    }
  }
  
  public final e fvC()
  {
    d locald2 = this.JgR;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement fvD()
  {
    return g.a(this);
  }
  
  protected void fvE() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Continuation at ");
    Object localObject = g.a(this);
    if (localObject != null) {}
    for (localObject = (Serializable)localObject;; localObject = (Serializable)getClass().getName()) {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */