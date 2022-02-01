package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlinx.coroutines.internal.h;

@Metadata(d1={""}, d2={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class av
{
  public static final String aw(d<?> paramd)
  {
    AppMethodBeat.i(188857);
    if ((paramd instanceof h))
    {
      paramd = paramd.toString();
      AppMethodBeat.o(188857);
      return paramd;
    }
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(paramd + '@' + Integer.toHexString(System.identityHashCode(paramd)));
      if (Result.exceptionOrNull-impl(localObject1) == null)
      {
        paramd = (String)localObject1;
        AppMethodBeat.o(188857);
        return paramd;
      }
    }
    finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.av
 * JD-Core Version:    0.7.0.1
 */