package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class i<T>
  extends j<T>
  implements Iterator<T>, d<ah>, kotlin.g.b.a.a
{
  private T ajum;
  private Iterator<? extends T> ajun;
  d<? super ah> ajuo;
  private int state;
  
  private final Throwable kBm()
  {
    AppMethodBeat.i(190941);
    switch (this.state)
    {
    default: 
      localThrowable = (Throwable)new IllegalStateException("Unexpected state of the iterator: " + this.state);
      AppMethodBeat.o(190941);
      return localThrowable;
    case 4: 
      localThrowable = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(190941);
      return localThrowable;
    }
    Throwable localThrowable = (Throwable)new IllegalStateException("Iterator has failed.");
    AppMethodBeat.o(190941);
    return localThrowable;
  }
  
  public final Object d(T paramT, d<? super ah> paramd)
  {
    AppMethodBeat.i(190952);
    this.ajum = paramT;
    this.state = 3;
    this.ajuo = paramd;
    paramT = kotlin.d.a.a.aiwj;
    if (paramT == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    if (paramT == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(190952);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(190952);
    return paramT;
  }
  
  public final f getContext()
  {
    return (f)g.aiwf;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(190946);
    for (;;)
    {
      Object localObject;
      switch (this.state)
      {
      default: 
        localObject = kBm();
        AppMethodBeat.o(190946);
        throw ((Throwable)localObject);
      case 1: 
        localObject = this.ajun;
        s.checkNotNull(localObject);
        if (((Iterator)localObject).hasNext())
        {
          this.state = 2;
          AppMethodBeat.o(190946);
          return true;
        }
        this.ajun = null;
      case 0: 
        this.state = 5;
        localObject = this.ajuo;
        s.checkNotNull(localObject);
        this.ajuo = null;
        ah localah = ah.aiuX;
        Result.Companion localCompanion = Result.Companion;
        ((d)localObject).resumeWith(Result.constructor-impl(localah));
      }
    }
    AppMethodBeat.o(190946);
    return false;
    AppMethodBeat.o(190946);
    return true;
  }
  
  public final T next()
  {
    AppMethodBeat.i(190949);
    do
    {
      switch (this.state)
      {
      default: 
        localObject = kBm();
        AppMethodBeat.o(190949);
        throw ((Throwable)localObject);
      }
    } while (hasNext());
    Object localObject = (Throwable)new NoSuchElementException();
    AppMethodBeat.o(190949);
    throw ((Throwable)localObject);
    this.state = 1;
    localObject = this.ajun;
    s.checkNotNull(localObject);
    localObject = ((Iterator)localObject).next();
    AppMethodBeat.o(190949);
    return localObject;
    this.state = 0;
    localObject = this.ajum;
    this.ajum = null;
    AppMethodBeat.o(190949);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(190958);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190958);
    throw localUnsupportedOperationException;
  }
  
  public final void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(190954);
    ResultKt.throwOnFailure(paramObject);
    this.state = 4;
    AppMethodBeat.o(190954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.i
 * JD-Core Version:    0.7.0.1
 */