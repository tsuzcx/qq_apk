package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.l;
import d.p.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class h<T>
  implements e, d<T>
{
  private static final AtomicReferenceFieldUpdater<h<?>, Object> Nid;
  @Deprecated
  public static final a Nie;
  private final d<T> Nic;
  private volatile Object result;
  
  static
  {
    AppMethodBeat.i(129640);
    Nie = new a((byte)0);
    Nid = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    AppMethodBeat.o(129640);
  }
  
  public h(d<? super T> paramd)
  {
    this(paramd, a.Nig);
    AppMethodBeat.i(129639);
    AppMethodBeat.o(129639);
  }
  
  private h(d<? super T> paramd, Object paramObject)
  {
    AppMethodBeat.i(129638);
    this.Nic = paramd;
    this.result = paramObject;
    AppMethodBeat.o(129638);
  }
  
  public final void eQ(Object paramObject)
  {
    AppMethodBeat.i(129635);
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != a.Nig) {
          break;
        }
      } while (!Nid.compareAndSet(this, a.Nig, paramObject));
      AppMethodBeat.o(129635);
      return;
      if (localObject != a.Nif) {
        break;
      }
    } while (!Nid.compareAndSet(this, a.Nif, a.Nih));
    this.Nic.eQ(paramObject);
    AppMethodBeat.o(129635);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    AppMethodBeat.o(129635);
    throw paramObject;
  }
  
  public final f gkg()
  {
    AppMethodBeat.i(129634);
    f localf = this.Nic.gkg();
    AppMethodBeat.o(129634);
    return localf;
  }
  
  public final Object gkh()
  {
    AppMethodBeat.i(129636);
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == a.Nig)
    {
      if (Nid.compareAndSet(this, a.Nig, a.Nif))
      {
        localObject1 = a.Nif;
        AppMethodBeat.o(129636);
        return localObject1;
      }
      localObject1 = this.result;
    }
    if (localObject1 == a.Nih)
    {
      localObject1 = a.Nif;
      AppMethodBeat.o(129636);
      return localObject1;
    }
    if ((localObject1 instanceof p.b))
    {
      localObject1 = ((p.b)localObject1).Nhi;
      AppMethodBeat.o(129636);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(129636);
    return localObject1;
  }
  
  public final e gki()
  {
    d locald2 = this.Nic;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement gkj()
  {
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129637);
    String str = "SafeContinuation for " + this.Nic;
    AppMethodBeat.o(129637);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "kotlin-stdlib"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.h
 * JD-Core Version:    0.7.0.1
 */