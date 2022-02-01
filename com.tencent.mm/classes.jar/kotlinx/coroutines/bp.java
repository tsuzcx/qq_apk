package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.g.a.m;
import d.l;
import d.y;
import kotlinx.coroutines.b.a;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/LazyDeferredCoroutine;", "T", "Lkotlinx/coroutines/DeferredCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "", "onStart", "kotlinx-coroutines-core"})
final class bp<T>
  extends am<T>
{
  private final d<y> KdQ;
  
  public bp(f paramf, m<? super ad, ? super d<? super T>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118208);
    this.KdQ = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118208);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118207);
    a.a(this.KdQ, (d)this);
    AppMethodBeat.o(118207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.bp
 * JD-Core Version:    0.7.0.1
 */