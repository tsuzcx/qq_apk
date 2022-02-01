package kotlin.d.b.a;

import java.io.Serializable;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class a
  implements Serializable, e, d<Object>
{
  private final d<Object> completion;
  
  public a(d<Object> paramd)
  {
    this.completion = paramd;
  }
  
  public d<ah> create(Object paramObject, d<?> paramd)
  {
    s.u(paramd, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  public d<ah> create(d<?> paramd)
  {
    s.u(paramd, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Continuation) has not been overridden"));
  }
  
  public e getCallerFrame()
  {
    d locald2 = this.completion;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final d<Object> getCompletion()
  {
    return this.completion;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    Object localObject3 = null;
    s.u(this, "$this$getStackTraceElementImpl");
    f localf = (f)getClass().getAnnotation(f.class);
    if (localf == null) {
      return null;
    }
    int i = localf.v();
    if (i > 1) {
      throw ((Throwable)new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + i + ". Please update the Kotlin standard library.").toString()));
    }
    i = g.a(this);
    Object localObject2;
    if (i < 0)
    {
      i = -1;
      localObject1 = h.aiwu;
      s.u(this, "continuation");
      localObject2 = h.aiwt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = h.b(this);
      }
      if (localObject1 != h.aiws) {
        break label173;
      }
      localObject2 = localObject3;
      label124:
      if (localObject2 != null) {
        break label289;
      }
    }
    label289:
    for (Object localObject1 = localf.c();; localObject1 = (String)localObject2 + '/' + localf.c())
    {
      return new StackTraceElement((String)localObject1, localf.m(), localf.f(), i);
      i = localf.klj()[i];
      break;
      label173:
      Object localObject4 = ((h.a)localObject1).aiwv;
      localObject2 = localObject3;
      if (localObject4 == null) {
        break label124;
      }
      localObject4 = ((Method)localObject4).invoke(getClass(), new Object[0]);
      localObject2 = localObject3;
      if (localObject4 == null) {
        break label124;
      }
      Method localMethod = ((h.a)localObject1).aiww;
      localObject2 = localObject3;
      if (localMethod == null) {
        break label124;
      }
      localObject4 = localMethod.invoke(localObject4, new Object[0]);
      localObject2 = localObject3;
      if (localObject4 == null) {
        break label124;
      }
      localObject1 = ((h.a)localObject1).aiwx;
      if (localObject1 != null) {}
      for (localObject1 = ((Method)localObject1).invoke(localObject4, new Object[0]);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof String)) {
          localObject2 = null;
        }
        localObject2 = (String)localObject2;
        break;
      }
    }
  }
  
  protected abstract Object invokeSuspend(Object paramObject);
  
  protected void releaseIntercepted() {}
  
  public final void resumeWith(Object paramObject)
  {
    d locald;
    for (a locala = (a)this;; locala = (a)locald)
    {
      s.u((d)locala, "frame");
      locald = locala.completion;
      s.checkNotNull(locald);
      try
      {
        paramObject = locala.invokeSuspend(paramObject);
        if (paramObject == kotlin.d.a.a.aiwj) {
          return;
        }
        localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramObject);
      }
      finally
      {
        for (;;)
        {
          Result.Companion localCompanion = Result.Companion;
          paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
        }
        locald.resumeWith(paramObject);
      }
      locala.releaseIntercepted();
      if (!(locald instanceof a)) {
        break;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Continuation at ");
    Object localObject = getStackTraceElement();
    if (localObject != null) {}
    for (localObject = (Serializable)localObject;; localObject = (Serializable)getClass().getName()) {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */