package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class ai
{
  public static final String e(d<?> paramd)
  {
    AppMethodBeat.i(190036);
    if ((paramd instanceof ap))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(190036);
      return paramd;
    }
    try
    {
      Object localObject1 = p.JfM;
      localObject1 = p.eF(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (p.eE(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(190036);
        return paramd;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.JfM;
        Object localObject2 = p.eF(q.n(localThrowable));
        continue;
        localObject2 = paramd.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(paramd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ai
 * JD-Core Version:    0.7.0.1
 */