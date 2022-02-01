package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result.Failure;
import kotlin.d.a.a;
import kotlin.d.b.a.e;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class h<T>
  implements e, d<T>
{
  @Deprecated
  private static final AtomicReferenceFieldUpdater<h<?>, Object> aiwh;
  private static final a aiwi;
  private final d<T> aiwg;
  private volatile Object result;
  
  static
  {
    AppMethodBeat.i(129640);
    aiwi = new a((byte)0);
    aiwh = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    AppMethodBeat.o(129640);
  }
  
  public h(d<? super T> paramd)
  {
    this(paramd, a.aiwk);
    AppMethodBeat.i(129639);
    AppMethodBeat.o(129639);
  }
  
  public h(d<? super T> paramd, Object paramObject)
  {
    AppMethodBeat.i(129638);
    this.aiwg = paramd;
    this.result = paramObject;
    AppMethodBeat.o(129638);
  }
  
  public final e getCallerFrame()
  {
    d locald2 = this.aiwg;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(129634);
    f localf = this.aiwg.getContext();
    AppMethodBeat.o(129634);
    return localf;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object kli()
  {
    AppMethodBeat.i(129636);
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == a.aiwk)
    {
      if (aiwh.compareAndSet(this, a.aiwk, a.aiwj))
      {
        localObject1 = a.aiwj;
        AppMethodBeat.o(129636);
        return localObject1;
      }
      localObject1 = this.result;
    }
    if (localObject1 == a.aiwl)
    {
      localObject1 = a.aiwj;
      AppMethodBeat.o(129636);
      return localObject1;
    }
    if ((localObject1 instanceof Result.Failure))
    {
      localObject1 = ((Result.Failure)localObject1).exception;
      AppMethodBeat.o(129636);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(129636);
    return localObject1;
  }
  
  public final void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(129635);
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != a.aiwk) {
          break;
        }
      } while (!aiwh.compareAndSet(this, a.aiwk, paramObject));
      AppMethodBeat.o(129635);
      return;
      if (localObject != a.aiwj) {
        break;
      }
    } while (!aiwh.compareAndSet(this, a.aiwj, a.aiwl));
    this.aiwg.resumeWith(paramObject);
    AppMethodBeat.o(129635);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    AppMethodBeat.o(129635);
    throw paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129637);
    String str = "SafeContinuation for " + this.aiwg;
    AppMethodBeat.o(129637);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.h
 * JD-Core Version:    0.7.0.1
 */