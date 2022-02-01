package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.a.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "kotlinx-coroutines-core"})
final class cd
  extends cl
{
  private final d<x> TUn;
  
  public cd(f paramf, m<? super ai, ? super d<? super x>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118153);
    this.TUn = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118153);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118152);
    a.a(this.TUn, (d)this);
    AppMethodBeat.o(118152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cd
 * JD-Core Version:    0.7.0.1
 */