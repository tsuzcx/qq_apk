package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.g.a.m;
import d.l;
import d.y;
import kotlinx.coroutines.b.a;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "kotlinx-coroutines-core"})
final class bq
  extends bx
{
  private final d<y> KdQ;
  
  public bq(f paramf, m<? super ad, ? super d<? super y>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118153);
    this.KdQ = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118153);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118152);
    a.a(this.KdQ, (d)this);
    AppMethodBeat.o(118152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.bq
 * JD-Core Version:    0.7.0.1
 */