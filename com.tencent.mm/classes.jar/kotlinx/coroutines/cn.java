package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.d.f;
import d.l;
import d.z;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.x;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"})
final class cn<T>
  extends r<T>
{
  public cn(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  public final void fF(Object paramObject)
  {
    AppMethodBeat.i(190703);
    Object localObject2 = v.b(paramObject, this.NKb);
    paramObject = this.NKb.gfE();
    Object localObject1 = x.a(paramObject, null);
    try
    {
      this.NKb.eN(localObject2);
      localObject2 = z.MKo;
      return;
    }
    finally
    {
      x.b(paramObject, localObject1);
      AppMethodBeat.o(190703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cn
 * JD-Core Version:    0.7.0.1
 */