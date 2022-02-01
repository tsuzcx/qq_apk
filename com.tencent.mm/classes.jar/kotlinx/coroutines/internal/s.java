package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.b;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.a;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.w;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"})
public class s<T>
  extends a<T>
  implements e
{
  public final d<T> TWf;
  
  public s(f paramf, d<? super T> paramd)
  {
    super(paramf, true);
    this.TWf = paramd;
  }
  
  public void fM(Object paramObject)
  {
    AppMethodBeat.i(192468);
    this.TWf.resumeWith(w.a(paramObject, this.TWf));
    AppMethodBeat.o(192468);
  }
  
  public void fS(Object paramObject)
  {
    AppMethodBeat.i(192467);
    aw.a(b.e(this.TWf), w.a(paramObject, this.TWf));
    AppMethodBeat.o(192467);
  }
  
  public final e getCallerFrame()
  {
    return (e)this.TWf;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final boolean hNo()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.s
 * JD-Core Version:    0.7.0.1
 */