package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.l;
import d.p.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class h<T>
  implements e, d<T>
{
  private static final AtomicReferenceFieldUpdater<h<?>, Object> JgH;
  @Deprecated
  public static final a JgI;
  private final d<T> JgG;
  private volatile Object result;
  
  static
  {
    AppMethodBeat.i(129640);
    JgI = new a((byte)0);
    JgH = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    AppMethodBeat.o(129640);
  }
  
  public h(d<? super T> paramd)
  {
    this(paramd, a.JgK);
    AppMethodBeat.i(129639);
    AppMethodBeat.o(129639);
  }
  
  private h(d<? super T> paramd, Object paramObject)
  {
    AppMethodBeat.i(129638);
    this.JgG = paramd;
    this.result = paramObject;
    AppMethodBeat.o(129638);
  }
  
  public final void eH(Object paramObject)
  {
    AppMethodBeat.i(129635);
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != a.JgK) {
          break;
        }
      } while (!JgH.compareAndSet(this, a.JgK, paramObject));
      AppMethodBeat.o(129635);
      return;
      if (localObject != a.JgJ) {
        break;
      }
    } while (!JgH.compareAndSet(this, a.JgJ, a.JgL));
    this.JgG.eH(paramObject);
    AppMethodBeat.o(129635);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    AppMethodBeat.o(129635);
    throw paramObject;
  }
  
  public final f fvA()
  {
    AppMethodBeat.i(129634);
    f localf = this.JgG.fvA();
    AppMethodBeat.o(129634);
    return localf;
  }
  
  public final Object fvB()
  {
    AppMethodBeat.i(129636);
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == a.JgK)
    {
      if (JgH.compareAndSet(this, a.JgK, a.JgJ))
      {
        localObject1 = a.JgJ;
        AppMethodBeat.o(129636);
        return localObject1;
      }
      localObject1 = this.result;
    }
    if (localObject1 == a.JgL)
    {
      localObject1 = a.JgJ;
      AppMethodBeat.o(129636);
      return localObject1;
    }
    if ((localObject1 instanceof p.b))
    {
      localObject1 = ((p.b)localObject1).JfN;
      AppMethodBeat.o(129636);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(129636);
    return localObject1;
  }
  
  public final e fvC()
  {
    d locald2 = this.JgG;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement fvD()
  {
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129637);
    String str = "SafeContinuation for " + this.JgG;
    AppMethodBeat.o(129637);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "kotlin-stdlib"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.d.h
 * JD-Core Version:    0.7.0.1
 */