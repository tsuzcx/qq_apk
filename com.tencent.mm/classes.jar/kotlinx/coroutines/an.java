package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class an
{
  public static final String e(d<?> paramd)
  {
    AppMethodBeat.i(190761);
    if ((paramd instanceof au))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(190761);
      return paramd;
    }
    try
    {
      Object localObject1 = p.MKe;
      localObject1 = p.eL(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (p.eK(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(190761);
        return paramd;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.MKe;
        Object localObject2 = p.eL(q.o(localThrowable));
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