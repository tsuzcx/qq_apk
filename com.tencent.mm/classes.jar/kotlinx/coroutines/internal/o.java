package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;
import kotlinx.coroutines.ce;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"})
public final class o
{
  private static final boolean TWc = true;
  
  public static final ce a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(192441);
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      paramMainDispatcherFactory = paramList;
    }
    catch (Throwable paramList)
    {
      for (;;)
      {
        paramMainDispatcherFactory = (ce)e(paramList, paramMainDispatcherFactory.hintOnError());
      }
    }
    AppMethodBeat.o(192441);
    return paramMainDispatcherFactory;
  }
  
  private static final p e(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(192442);
    if (TWc)
    {
      paramThrowable = new p(paramThrowable, paramString);
      AppMethodBeat.o(192442);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(192442);
      throw paramThrowable;
    }
    hNP();
    AppMethodBeat.o(192442);
    throw null;
  }
  
  public static final Void hNP()
  {
    AppMethodBeat.i(192444);
    Throwable localThrowable = (Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(192444);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.o
 * JD-Core Version:    0.7.0.1
 */