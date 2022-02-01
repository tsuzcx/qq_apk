package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.l;
import kotlinx.coroutines.a;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.r;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"})
public class z<T>
  extends a<T>
  implements e
{
  public final d<T> LEJ;
  
  public z(f paramf, d<? super T> paramd)
  {
    super(paramf, true);
    this.LEJ = paramd;
  }
  
  public final e fvC()
  {
    return (e)this.LEJ;
  }
  
  public final StackTraceElement fvD()
  {
    return null;
  }
  
  public final boolean gaH()
  {
    return true;
  }
  
  public void gg(Object paramObject)
  {
    AppMethodBeat.i(202363);
    this.LEJ.eH(r.b(paramObject, this.LEJ));
    AppMethodBeat.o(202363);
  }
  
  public void gi(Object paramObject)
  {
    AppMethodBeat.i(202362);
    aq.a(b.d(this.LEJ), r.b(paramObject, this.LEJ));
    AppMethodBeat.o(202362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.z
 * JD-Core Version:    0.7.0.1
 */