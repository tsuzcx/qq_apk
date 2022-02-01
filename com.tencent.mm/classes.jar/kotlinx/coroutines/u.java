package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.p;
import d.q;
import kotlinx.coroutines.internal.r;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class u
{
  public static final <T> Object b(Object paramObject, d.d.d<? super T> paramd)
  {
    AppMethodBeat.i(191249);
    if ((paramObject instanceof t))
    {
      Object localObject = p.KTg;
      localObject = ((t)paramObject).cause;
      paramObject = localObject;
      if (al.gdE()) {
        if ((paramd instanceof d.d.b.a.d)) {
          break label56;
        }
      }
      label56:
      for (paramObject = localObject;; paramObject = r.a((Throwable)localObject, (d.d.b.a.d)paramd))
      {
        paramObject = p.eI(q.n(paramObject));
        AppMethodBeat.o(191249);
        return paramObject;
      }
    }
    paramd = p.KTg;
    paramObject = p.eI(paramObject);
    AppMethodBeat.o(191249);
    return paramObject;
  }
  
  public static final <T> Object fG(Object paramObject)
  {
    AppMethodBeat.i(118154);
    Throwable localThrowable = p.eH(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(118154);
      return paramObject;
    }
    paramObject = new t(localThrowable);
    AppMethodBeat.o(118154);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.u
 * JD-Core Version:    0.7.0.1
 */