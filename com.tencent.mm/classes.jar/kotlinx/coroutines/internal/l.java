package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;

@Metadata(d1={""}, d2={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  static final boolean ajAv;
  
  static
  {
    AppMethodBeat.i(189416);
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("android.os.Build"));
      ajAv = Result.isSuccess-impl(localObject1);
      AppMethodBeat.o(189416);
      return;
    }
    finally
    {
      for (;;)
      {
        Result.Companion localCompanion = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.l
 * JD-Core Version:    0.7.0.1
 */