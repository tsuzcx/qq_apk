package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class am
{
  public static final String e(d<?> paramd)
  {
    AppMethodBeat.i(191151);
    if ((paramd instanceof at))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(191151);
      return paramd;
    }
    try
    {
      Object localObject1 = p.KTg;
      localObject1 = p.eI(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (p.eH(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(191151);
        return paramd;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.KTg;
        Object localObject2 = p.eI(q.n(localThrowable));
        continue;
        localObject2 = paramd.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(paramd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.am
 * JD-Core Version:    0.7.0.1
 */