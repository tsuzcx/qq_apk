package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.l;
import kotlinx.coroutines.a;
import kotlinx.coroutines.av;
import kotlinx.coroutines.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"})
public class r<T>
  extends a<T>
  implements e
{
  public final d<T> NKb;
  
  public r(f paramf, d<? super T> paramd)
  {
    super(paramf, true);
    this.NKb = paramd;
  }
  
  public void fF(Object paramObject)
  {
    AppMethodBeat.i(190833);
    this.NKb.eN(v.b(paramObject, this.NKb));
    AppMethodBeat.o(190833);
  }
  
  public void fL(Object paramObject)
  {
    AppMethodBeat.i(190832);
    av.a(b.d(this.NKb), v.b(paramObject, this.NKb));
    AppMethodBeat.o(190832);
  }
  
  public final e gfG()
  {
    return (e)this.NKb;
  }
  
  public final StackTraceElement gfH()
  {
    return null;
  }
  
  public final boolean gvG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.r
 * JD-Core Version:    0.7.0.1
 */