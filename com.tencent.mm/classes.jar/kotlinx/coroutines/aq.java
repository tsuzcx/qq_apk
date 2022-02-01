package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class aq
{
  public static final String m(d<?> paramd)
  {
    AppMethodBeat.i(204180);
    if ((paramd instanceof ax))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(204180);
      return paramd;
    }
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (Result.exceptionOrNull-impl(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(204180);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.aq
 * JD-Core Version:    0.7.0.1
 */