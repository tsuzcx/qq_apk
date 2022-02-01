package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
public final class h
{
  private static final boolean abzc;
  
  static
  {
    AppMethodBeat.i(205102);
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("android.os.Build"));
      abzc = Result.isSuccess-impl(localObject1);
      AppMethodBeat.o(205102);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Result.Companion localCompanion = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
      }
    }
  }
  
  public static final boolean iSI()
  {
    return abzc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.h
 * JD-Core Version:    0.7.0.1
 */