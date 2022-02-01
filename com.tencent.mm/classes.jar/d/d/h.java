package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.l;
import d.p.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class h<T>
  implements d.d.b.a.d, d<T>
{
  private static final AtomicReferenceFieldUpdater<h<?>, Object> KUb;
  @Deprecated
  public static final a KUc;
  private final d<T> KUa;
  private volatile Object result;
  
  static
  {
    AppMethodBeat.i(129640);
    KUc = new a((byte)0);
    KUb = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    AppMethodBeat.o(129640);
  }
  
  public h(d<? super T> paramd)
  {
    this(paramd, a.KUe);
    AppMethodBeat.i(129639);
    AppMethodBeat.o(129639);
  }
  
  private h(d<? super T> paramd, Object paramObject)
  {
    AppMethodBeat.i(129638);
    this.KUa = paramd;
    this.result = paramObject;
    AppMethodBeat.o(129638);
  }
  
  public final void eK(Object paramObject)
  {
    AppMethodBeat.i(129635);
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != a.KUe) {
          break;
        }
      } while (!KUb.compareAndSet(this, a.KUe, paramObject));
      AppMethodBeat.o(129635);
      return;
      if (localObject != a.KUd) {
        break;
      }
    } while (!KUb.compareAndSet(this, a.KUd, a.KUf));
    this.KUa.eK(paramObject);
    AppMethodBeat.o(129635);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    AppMethodBeat.o(129635);
    throw paramObject;
  }
  
  public final f fOf()
  {
    AppMethodBeat.i(129634);
    f localf = this.KUa.fOf();
    AppMethodBeat.o(129634);
    return localf;
  }
  
  public final Object fOg()
  {
    AppMethodBeat.i(129636);
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == a.KUe)
    {
      if (KUb.compareAndSet(this, a.KUe, a.KUd))
      {
        localObject1 = a.KUd;
        AppMethodBeat.o(129636);
        return localObject1;
      }
      localObject1 = this.result;
    }
    if (localObject1 == a.KUf)
    {
      localObject1 = a.KUd;
      AppMethodBeat.o(129636);
      return localObject1;
    }
    if ((localObject1 instanceof p.b))
    {
      localObject1 = ((p.b)localObject1).KTh;
      AppMethodBeat.o(129636);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(129636);
    return localObject1;
  }
  
  public final d.d.b.a.d fOh()
  {
    d locald2 = this.KUa;
    d locald1 = locald2;
    if (!(locald2 instanceof d.d.b.a.d)) {
      locald1 = null;
    }
    return (d.d.b.a.d)locald1;
  }
  
  public final StackTraceElement fOi()
  {
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129637);
    String str = "SafeContinuation for " + this.KUa;
    AppMethodBeat.o(129637);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "kotlin-stdlib"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.h
 * JD-Core Version:    0.7.0.1
 */