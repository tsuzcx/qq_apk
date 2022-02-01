package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.b;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.a;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.y;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"})
public class t<T>
  extends a<T>
  implements e
{
  public final d<T> abzw;
  
  public t(f paramf, d<? super T> paramd)
  {
    super(paramf, true);
    this.abzw = paramd;
  }
  
  public void fT(Object paramObject)
  {
    AppMethodBeat.i(205089);
    this.abzw.resumeWith(y.b(paramObject, this.abzw));
    AppMethodBeat.o(205089);
  }
  
  public void fU(Object paramObject)
  {
    AppMethodBeat.i(205088);
    ay.a(b.k(this.abzw), y.b(paramObject, this.abzw));
    AppMethodBeat.o(205088);
  }
  
  public final e getCallerFrame()
  {
    return (e)this.abzw;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final boolean iQJ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.t
 * JD-Core Version:    0.7.0.1
 */