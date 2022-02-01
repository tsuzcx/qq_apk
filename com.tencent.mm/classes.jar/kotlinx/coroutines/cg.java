package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.c.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/LazyDeferredCoroutine;", "T", "Lkotlinx/coroutines/DeferredCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "", "onStart", "kotlinx-coroutines-core"})
final class cg<T>
  extends au<T>
{
  private final d<x> abwQ;
  
  public cg(f paramf, m<? super ak, ? super d<? super T>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118208);
    this.abwQ = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118208);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118207);
    a.a(this.abwQ, (d)this);
    AppMethodBeat.o(118207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cg
 * JD-Core Version:    0.7.0.1
 */