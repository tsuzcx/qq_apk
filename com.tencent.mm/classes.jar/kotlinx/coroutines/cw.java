package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.y;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"})
final class cw<T>
  extends s<T>
{
  public cw(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  public final void fM(Object paramObject)
  {
    AppMethodBeat.i(192322);
    Object localObject2 = w.a(paramObject, this.TWf);
    paramObject = this.TWf.getContext();
    Object localObject1 = y.a(paramObject, null);
    try
    {
      this.TWf.resumeWith(localObject2);
      localObject2 = x.SXb;
      return;
    }
    finally
    {
      y.b(paramObject, localObject1);
      AppMethodBeat.o(192322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cw
 * JD-Core Version:    0.7.0.1
 */