package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.a.b;
import d.d.d;
import d.d.e;
import d.d.f;
import d.d.f.c;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class as
{
  public static final Object b(long paramLong, d<? super y> paramd)
  {
    AppMethodBeat.i(118246);
    if (paramLong <= 0L)
    {
      paramd = y.KTp;
      AppMethodBeat.o(118246);
      return paramd;
    }
    Object localObject = new k(b.d(paramd));
    j localj = (j)localObject;
    c(localj.fOf()).a(paramLong, localj);
    localObject = ((k)localObject).getResult();
    if (localObject == a.KUd) {
      d.g.b.k.h(paramd, "frame");
    }
    AppMethodBeat.o(118246);
    return localObject;
  }
  
  private static ar c(f paramf)
  {
    AppMethodBeat.i(118247);
    Object localObject = paramf.get((f.c)e.KTW);
    paramf = (f)localObject;
    if (!(localObject instanceof ar)) {
      paramf = null;
    }
    localObject = (ar)paramf;
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = ao.gdK();
    }
    AppMethodBeat.o(118247);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.as
 * JD-Core Version:    0.7.0.1
 */