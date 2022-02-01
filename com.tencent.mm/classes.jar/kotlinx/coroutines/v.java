package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.e;
import d.d.d;
import d.l;
import d.p;
import d.q;
import kotlinx.coroutines.internal.s;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class v
{
  public static final <T> Object b(Object paramObject, d<? super T> paramd)
  {
    AppMethodBeat.i(190862);
    if ((paramObject instanceof u))
    {
      Object localObject = p.MKe;
      localObject = ((u)paramObject).cause;
      paramObject = localObject;
      if (am.gve()) {
        if ((paramd instanceof e)) {
          break label56;
        }
      }
      label56:
      for (paramObject = localObject;; paramObject = s.a((Throwable)localObject, (e)paramd))
      {
        paramObject = p.eL(q.o(paramObject));
        AppMethodBeat.o(190862);
        return paramObject;
      }
    }
    paramd = p.MKe;
    paramObject = p.eL(paramObject);
    AppMethodBeat.o(190862);
    return paramObject;
  }
  
  public static final <T> Object fJ(Object paramObject)
  {
    AppMethodBeat.i(118154);
    Throwable localThrowable = p.eK(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(118154);
      return paramObject;
    }
    paramObject = new u(localThrowable);
    AppMethodBeat.o(118154);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.v
 * JD-Core Version:    0.7.0.1
 */