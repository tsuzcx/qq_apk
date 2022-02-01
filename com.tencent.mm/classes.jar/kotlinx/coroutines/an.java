package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class an
{
  public static final String e(d<?> paramd)
  {
    AppMethodBeat.i(209252);
    if ((paramd instanceof au))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(209252);
      return paramd;
    }
    try
    {
      Object localObject1 = p.Nhh;
      localObject1 = p.eO(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (p.eN(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(209252);
        return paramd;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.Nhh;
        Object localObject2 = p.eO(q.p(localThrowable));
        continue;
        localObject2 = paramd.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(paramd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.an
 * JD-Core Version:    0.7.0.1
 */