package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/FlowCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class o<T>
  extends y<T>
{
  public o(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  public final boolean Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(189212);
    if ((paramThrowable instanceof l))
    {
      AppMethodBeat.o(189212);
      return true;
    }
    boolean bool = iF(paramThrowable);
    AppMethodBeat.o(189212);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.o
 * JD-Core Version:    0.7.0.1
 */