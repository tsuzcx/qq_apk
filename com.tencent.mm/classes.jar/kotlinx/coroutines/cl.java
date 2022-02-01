package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.c.a;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class cl
  extends cv
{
  private final d<ah> alw;
  
  public cl(f paramf, m<? super aq, ? super d<? super ah>, ? extends Object> paramm)
  {
    super(paramf, false);
    AppMethodBeat.i(118153);
    this.alw = b.a(paramm, this, (d)this);
    AppMethodBeat.o(118153);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(118152);
    a.a(this.alw, (d)this);
    AppMethodBeat.o(118152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cl
 * JD-Core Version:    0.7.0.1
 */