package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.f;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "getSUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class t
{
  private static final boolean ajAK = true;
  
  public static final cm a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(189389);
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      paramMainDispatcherFactory = paramList;
    }
    finally
    {
      for (;;)
      {
        paramMainDispatcherFactory = (cm)e(paramList, paramMainDispatcherFactory.hintOnError());
      }
    }
    AppMethodBeat.o(189389);
    return paramMainDispatcherFactory;
  }
  
  private static final u e(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(189393);
    if (ajAK)
    {
      paramThrowable = new u(paramThrowable, paramString);
      AppMethodBeat.o(189393);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(189393);
      throw paramThrowable;
    }
    kEk();
    paramThrowable = new f();
    AppMethodBeat.o(189393);
    throw paramThrowable;
  }
  
  public static final Void kEk()
  {
    AppMethodBeat.i(189410);
    IllegalStateException localIllegalStateException = new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(189410);
    throw localIllegalStateException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.t
 * JD-Core Version:    0.7.0.1
 */