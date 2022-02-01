package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.g.a.m;
import d.l;
import d.z;
import kotlinx.coroutines.a.a;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "kotlinx-coroutines-core"})
final class by
  extends cg
{
  private final d<z> Ofs;
  
  public by(f paramf, m<? super ah, ? super d<? super z>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118153);
    this.Ofs = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118153);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118152);
    a.a(this.Ofs, (d)this);
    AppMethodBeat.o(118152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.by
 * JD-Core Version:    0.7.0.1
 */