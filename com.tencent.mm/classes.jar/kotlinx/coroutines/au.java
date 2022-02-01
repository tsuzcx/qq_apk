package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class au
{
  public static final Object a(long paramLong, d<? super x> paramd)
  {
    AppMethodBeat.i(118246);
    if (paramLong <= 0L)
    {
      paramd = x.SXb;
      AppMethodBeat.o(118246);
      return paramd;
    }
    Object localObject = new l(b.e(paramd));
    k localk = (k)localObject;
    c(localk.getContext()).a(paramLong, localk);
    localObject = ((l)localObject).getResult();
    if (localObject == a.SXO) {
      p.h(paramd, "frame");
    }
    AppMethodBeat.o(118246);
    return localObject;
  }
  
  public static final at c(f paramf)
  {
    AppMethodBeat.i(118247);
    Object localObject = paramf.get((f.c)e.SXH);
    paramf = (f)localObject;
    if (!(localObject instanceof at)) {
      paramf = null;
    }
    localObject = (at)paramf;
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = aq.hMR();
    }
    AppMethodBeat.o(118247);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.au
 * JD-Core Version:    0.7.0.1
 */