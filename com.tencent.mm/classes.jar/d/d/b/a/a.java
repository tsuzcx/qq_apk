package d.d.b.a;

import d.d.d;
import d.l;
import d.p.a;
import d.q;
import d.z;
import java.io.Serializable;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class a
  implements e, d<Object>, Serializable
{
  final d<Object> MLk;
  
  public a(d<Object> paramd)
  {
    this.MLk = paramd;
  }
  
  public d<z> a(Object paramObject, d<?> paramd)
  {
    d.g.b.p.h(paramd, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  protected abstract Object cQ(Object paramObject);
  
  public final void eN(Object paramObject)
  {
    d locald;
    for (a locala = (a)this;; locala = (a)locald)
    {
      d.g.b.p.h((d)locala, "frame");
      locald = locala.MLk;
      if (locald == null) {
        d.g.b.p.gfZ();
      }
      try
      {
        paramObject = locala.cQ(paramObject);
        if (paramObject == d.d.a.a.MLc) {
          return;
        }
        locala1 = d.p.MKe;
        paramObject = d.p.eL(paramObject);
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          p.a locala1 = d.p.MKe;
          paramObject = d.p.eL(q.o(paramObject));
        }
        locald.eN(paramObject);
      }
      locala.gfI();
      if (!(locald instanceof a)) {
        break;
      }
    }
  }
  
  public final e gfG()
  {
    d locald2 = this.MLk;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement gfH()
  {
    return g.a(this);
  }
  
  protected void gfI() {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */