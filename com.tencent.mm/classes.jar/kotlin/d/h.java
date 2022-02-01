package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result.Failure;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class h<T>
  implements e, d<T>
{
  private static final AtomicReferenceFieldUpdater<h<?>, Object> aaAy;
  @Deprecated
  public static final h.a aaAz;
  private final d<T> aaAx;
  private volatile Object result;
  
  static
  {
    AppMethodBeat.i(129640);
    aaAz = new h.a((byte)0);
    aaAy = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    AppMethodBeat.o(129640);
  }
  
  public h(d<? super T> paramd)
  {
    this(paramd, a.aaAB);
    AppMethodBeat.i(129639);
    AppMethodBeat.o(129639);
  }
  
  private h(d<? super T> paramd, Object paramObject)
  {
    AppMethodBeat.i(129638);
    this.aaAx = paramd;
    this.result = paramObject;
    AppMethodBeat.o(129638);
  }
  
  public final e getCallerFrame()
  {
    d locald2 = this.aaAx;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(129634);
    f localf = this.aaAx.getContext();
    AppMethodBeat.o(129634);
    return localf;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object iBS()
  {
    AppMethodBeat.i(129636);
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == a.aaAB)
    {
      if (aaAy.compareAndSet(this, a.aaAB, a.aaAA))
      {
        localObject1 = a.aaAA;
        AppMethodBeat.o(129636);
        return localObject1;
      }
      localObject1 = this.result;
    }
    if (localObject1 == a.aaAC)
    {
      localObject1 = a.aaAA;
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
        if (localObject != a.aaAB) {
          break;
        }
      } while (!aaAy.compareAndSet(this, a.aaAB, paramObject));
      AppMethodBeat.o(129635);
      return;
      if (localObject != a.aaAA) {
        break;
      }
    } while (!aaAy.compareAndSet(this, a.aaAA, a.aaAC));
    this.aaAx.resumeWith(paramObject);
    AppMethodBeat.o(129635);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    AppMethodBeat.o(129635);
    throw paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129637);
    String str = "SafeContinuation for " + this.aaAx;
    AppMethodBeat.o(129637);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.d.h
 * JD-Core Version:    0.7.0.1
 */