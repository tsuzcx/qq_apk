package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/StackFrameContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "uCont", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class z<T>
  implements e, d<T>
{
  private final f aMa;
  private final d<T> ajzY;
  
  public z(d<? super T> paramd, f paramf)
  {
    this.ajzY = paramd;
    this.aMa = paramf;
  }
  
  public final e getCallerFrame()
  {
    d locald = this.ajzY;
    if ((locald instanceof e)) {
      return (e)locald;
    }
    return null;
  }
  
  public final f getContext()
  {
    return this.aMa;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(189262);
    this.ajzY.resumeWith(paramObject);
    AppMethodBeat.o(189262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.z
 * JD-Core Version:    0.7.0.1
 */