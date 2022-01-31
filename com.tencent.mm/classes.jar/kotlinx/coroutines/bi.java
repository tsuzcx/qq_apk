package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.f.a.m;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onStart", "kotlinx-coroutines-core"})
final class bi
  extends bp
{
  private final m<ac, c<? super y>, Object> CIB;
  
  public bi(e parame, m<? super ac, ? super c<? super y>, ? extends Object> paramm)
  {
    super(parame, false);
    AppMethodBeat.i(118470);
    this.CIB = paramm;
    AppMethodBeat.o(118470);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118469);
    a.b(this.CIB, this, (c)this);
    AppMethodBeat.o(118469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bi
 * JD-Core Version:    0.7.0.1
 */