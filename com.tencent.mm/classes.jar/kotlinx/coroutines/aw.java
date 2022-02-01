package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-p9JZ4hM", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDelayMillis", "toDelayMillis-LRDsOJo", "(D)J", "kotlinx-coroutines-core"})
public final class aw
{
  public static final Object a(long paramLong, d<? super x> paramd)
  {
    AppMethodBeat.i(118246);
    if (paramLong <= 0L)
    {
      paramd = x.aazN;
      AppMethodBeat.o(118246);
      return paramd;
    }
    Object localObject = new n(b.k(paramd), 1);
    ((n)localObject).iQM();
    m localm = (m)localObject;
    d(localm.getContext()).a(paramLong, localm);
    localObject = ((n)localObject).getResult();
    if (localObject == a.aaAA) {
      p.k(paramd, "frame");
    }
    AppMethodBeat.o(118246);
    return localObject;
  }
  
  public static final av d(f paramf)
  {
    AppMethodBeat.i(118247);
    Object localObject = paramf.get((f.c)e.aaAt);
    paramf = (f)localObject;
    if (!(localObject instanceof av)) {
      paramf = null;
    }
    localObject = (av)paramf;
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = as.iRn();
    }
    AppMethodBeat.o(118247);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.aw
 * JD-Core Version:    0.7.0.1
 */