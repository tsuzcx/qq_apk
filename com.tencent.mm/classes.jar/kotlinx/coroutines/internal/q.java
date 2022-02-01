package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.f;
import d.l;
import kotlinx.coroutines.a;
import kotlinx.coroutines.au;
import kotlinx.coroutines.u;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"})
public class q<T>
  extends a<T>
  implements d.d.b.a.d
{
  public final d.d.d<T> LTe;
  
  public q(f paramf, d.d.d<? super T> paramd)
  {
    super(paramf, true);
    this.LTe = paramd;
  }
  
  public void fC(Object paramObject)
  {
    AppMethodBeat.i(191222);
    this.LTe.eK(u.b(paramObject, this.LTe));
    AppMethodBeat.o(191222);
  }
  
  public void fI(Object paramObject)
  {
    AppMethodBeat.i(191221);
    au.a(b.d(this.LTe), u.b(paramObject, this.LTe));
    AppMethodBeat.o(191221);
  }
  
  public final d.d.b.a.d fOh()
  {
    return (d.d.b.a.d)this.LTe;
  }
  
  public final StackTraceElement fOi()
  {
    return null;
  }
  
  public final boolean geg()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.q
 * JD-Core Version:    0.7.0.1
 */