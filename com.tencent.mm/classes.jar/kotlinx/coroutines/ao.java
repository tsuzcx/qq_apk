package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class ao
{
  public static final String f(d<?> paramd)
  {
    AppMethodBeat.i(192388);
    if ((paramd instanceof av))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(192388);
      return paramd;
    }
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (Result.exceptionOrNull-impl(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(192388);
        return paramd;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Result.Companion localCompanion = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
        continue;
        localObject2 = paramd.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(paramd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ao
 * JD-Core Version:    0.7.0.1
 */