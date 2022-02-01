package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.e;
import d.d.d;
import d.p;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class r
{
  public static final <T> Object b(Object paramObject, d<? super T> paramd)
  {
    AppMethodBeat.i(202369);
    if ((paramObject instanceof q))
    {
      Object localObject = p.JfM;
      localObject = ((q)paramObject).cause;
      paramObject = localObject;
      if (ah.fKX()) {
        if ((paramd instanceof e)) {
          break label56;
        }
      }
      label56:
      for (paramObject = localObject;; paramObject = kotlinx.coroutines.a.l.a((Throwable)localObject, (e)paramd))
      {
        paramObject = p.eF(d.q.n(paramObject));
        AppMethodBeat.o(202369);
        return paramObject;
      }
    }
    paramd = p.JfM;
    paramObject = p.eF(paramObject);
    AppMethodBeat.o(202369);
    return paramObject;
  }
  
  public static final <T> Object fB(Object paramObject)
  {
    AppMethodBeat.i(118154);
    Throwable localThrowable = p.eE(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(118154);
      return paramObject;
    }
    paramObject = new q(localThrowable);
    AppMethodBeat.o(118154);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.r
 * JD-Core Version:    0.7.0.1
 */