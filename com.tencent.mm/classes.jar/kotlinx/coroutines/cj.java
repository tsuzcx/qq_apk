package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.d.f;
import d.l;
import d.y;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.z;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"})
final class cj<T>
  extends z<T>
{
  public cj(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  public final void gg(Object paramObject)
  {
    AppMethodBeat.i(202324);
    Object localObject2 = r.b(paramObject, this.LEJ);
    paramObject = this.LEJ.fvA();
    Object localObject1 = q.a(paramObject, null);
    try
    {
      this.LEJ.eH(localObject2);
      localObject2 = y.JfV;
      return;
    }
    finally
    {
      q.b(paramObject, localObject1);
      AppMethodBeat.o(202324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.cj
 * JD-Core Version:    0.7.0.1
 */