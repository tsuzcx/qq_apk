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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"})
public class r<T>
  extends a<T>
  implements e
{
  public final d<T> Ohh;
  
  public r(f paramf, d<? super T> paramd)
  {
    super(paramf, true);
    this.Ohh = paramd;
  }
  
  public void fI(Object paramObject)
  {
    AppMethodBeat.i(209324);
    this.Ohh.eQ(v.b(paramObject, this.Ohh));
    AppMethodBeat.o(209324);
  }
  
  public void fO(Object paramObject)
  {
    AppMethodBeat.i(209323);
    av.a(b.d(this.Ohh), v.b(paramObject, this.Ohh));
    AppMethodBeat.o(209323);
  }
  
  public final boolean gAi()
  {
    return true;
  }
  
  public final e gki()
  {
    return (e)this.Ohh;
  }
  
  public final StackTraceElement gkj()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.r
 * JD-Core Version:    0.7.0.1
 */