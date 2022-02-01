package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.a.b;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.a;
import kotlinx.coroutines.ai;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class y<T>
  extends a<T>
  implements e
{
  public final d<T> ajzY;
  
  public y(f paramf, d<? super T> paramd)
  {
    super(paramf, true);
    this.ajzY = paramd;
  }
  
  public final e getCallerFrame()
  {
    d locald = this.ajzY;
    if ((locald instanceof e)) {
      return (e)locald;
    }
    return null;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public void iv(Object paramObject)
  {
    AppMethodBeat.i(189420);
    this.ajzY.resumeWith(ai.e(paramObject, this.ajzY));
    AppMethodBeat.o(189420);
  }
  
  public void iw(Object paramObject)
  {
    AppMethodBeat.i(189412);
    i.a(b.au(this.ajzY), ai.e(paramObject, this.ajzY));
    AppMethodBeat.o(189412);
  }
  
  public final boolean kBx()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.y
 * JD-Core Version:    0.7.0.1
 */