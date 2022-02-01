package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.g.a.m;
import d.l;
import d.y;
import kotlinx.coroutines.a.a;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "kotlinx-coroutines-core"})
final class bv
  extends cc
{
  private final d<y> LRr;
  
  public bv(f paramf, m<? super ag, ? super d<? super y>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118153);
    this.LRr = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118153);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118152);
    a.a(this.LRr, (d)this);
    AppMethodBeat.o(118152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bv
 * JD-Core Version:    0.7.0.1
 */