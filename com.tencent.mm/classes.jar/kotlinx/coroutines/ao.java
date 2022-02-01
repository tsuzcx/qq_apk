package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.a.b;
import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class ao
{
  public static final Object a(long paramLong, d<? super y> paramd)
  {
    AppMethodBeat.i(118246);
    if (paramLong <= 0L)
    {
      paramd = y.JfV;
      AppMethodBeat.o(118246);
      return paramd;
    }
    Object localObject = new i(b.d(paramd));
    h localh = (h)localObject;
    c(localh.fvA()).a(paramLong, localh);
    localObject = ((i)localObject).getResult();
    if (localObject == a.JgJ) {
      k.h(paramd, "frame");
    }
    AppMethodBeat.o(118246);
    return localObject;
  }
  
  private static an c(f paramf)
  {
    AppMethodBeat.i(118247);
    Object localObject = paramf.get((f.c)e.JgC);
    paramf = (f)localObject;
    if (!(localObject instanceof an)) {
      paramf = null;
    }
    localObject = (an)paramf;
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = ak.fLd();
    }
    AppMethodBeat.o(118247);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.ao
 * JD-Core Version:    0.7.0.1
 */