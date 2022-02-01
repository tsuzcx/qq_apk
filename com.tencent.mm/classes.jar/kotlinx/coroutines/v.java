package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.e;
import d.d.d;
import d.l;
import d.p;
import d.q;
import kotlinx.coroutines.internal.s;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class v
{
  public static final <T> Object b(Object paramObject, d<? super T> paramd)
  {
    AppMethodBeat.i(209353);
    if ((paramObject instanceof u))
    {
      Object localObject = p.Nhh;
      localObject = ((u)paramObject).cause;
      paramObject = localObject;
      if (am.gzG()) {
        if ((paramd instanceof e)) {
          break label56;
        }
      }
      label56:
      for (paramObject = localObject;; paramObject = s.a((Throwable)localObject, (e)paramd))
      {
        paramObject = p.eO(q.p(paramObject));
        AppMethodBeat.o(209353);
        return paramObject;
      }
    }
    paramd = p.Nhh;
    paramObject = p.eO(paramObject);
    AppMethodBeat.o(209353);
    return paramObject;
  }
  
  public static final <T> Object fM(Object paramObject)
  {
    AppMethodBeat.i(118154);
    Throwable localThrowable = p.eN(paramObject);
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