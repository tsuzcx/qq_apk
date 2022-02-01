package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.a.b;
import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.g.b.p;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class at
{
  public static final Object a(long paramLong, d<? super z> paramd)
  {
    AppMethodBeat.i(118246);
    if (paramLong <= 0L)
    {
      paramd = z.Nhr;
      AppMethodBeat.o(118246);
      return paramd;
    }
    Object localObject = new l(b.d(paramd));
    k localk = (k)localObject;
    c(localk.gkg()).a(paramLong, localk);
    localObject = ((l)localObject).getResult();
    if (localObject == a.Nif) {
      p.h(paramd, "frame");
    }
    AppMethodBeat.o(118246);
    return localObject;
  }
  
  private static as c(f paramf)
  {
    AppMethodBeat.i(118247);
    Object localObject = paramf.get((f.c)e.NhY);
    paramf = (f)localObject;
    if (!(localObject instanceof as)) {
      paramf = null;
    }
    localObject = (as)paramf;
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = ap.gzM();
    }
    AppMethodBeat.o(118247);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.at
 * JD-Core Version:    0.7.0.1
 */