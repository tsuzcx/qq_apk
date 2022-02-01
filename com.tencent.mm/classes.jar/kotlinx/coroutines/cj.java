package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.d.f;
import d.l;
import d.y;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.w;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"})
final class cj<T>
  extends q<T>
{
  public cj(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  public final void fC(Object paramObject)
  {
    AppMethodBeat.i(191093);
    Object localObject2 = u.b(paramObject, this.LTe);
    paramObject = this.LTe.fOf();
    Object localObject1 = w.a(paramObject, null);
    try
    {
      this.LTe.eK(localObject2);
      localObject2 = y.KTp;
      return;
    }
    finally
    {
      w.b(paramObject, localObject1);
      AppMethodBeat.o(191093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cj
 * JD-Core Version:    0.7.0.1
 */