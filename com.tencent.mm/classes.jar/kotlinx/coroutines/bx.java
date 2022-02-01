package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.g.a.m;
import d.l;
import d.z;
import kotlinx.coroutines.a.a;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/LazyDeferredCoroutine;", "T", "Lkotlinx/coroutines/DeferredCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "", "onStart", "kotlinx-coroutines-core"})
final class bx<T>
  extends ar<T>
{
  private final d<z> NIm;
  
  public bx(f paramf, m<? super ah, ? super d<? super T>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118208);
    this.NIm = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118208);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118207);
    a.a(this.NIm, (d)this);
    AppMethodBeat.o(118207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bx
 * JD-Core Version:    0.7.0.1
 */