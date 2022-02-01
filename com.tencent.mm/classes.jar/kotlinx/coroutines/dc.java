package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"})
final class dc<T>
  extends t<T>
{
  public dc(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  public final void fT(Object paramObject)
  {
    AppMethodBeat.i(204259);
    Object localObject2 = y.b(paramObject, this.abzw);
    paramObject = this.abzw.getContext();
    Object localObject1 = z.a(paramObject, null);
    try
    {
      this.abzw.resumeWith(localObject2);
      localObject2 = x.aazN;
      return;
    }
    finally
    {
      z.b(paramObject, localObject1);
      AppMethodBeat.o(204259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.dc
 * JD-Core Version:    0.7.0.1
 */