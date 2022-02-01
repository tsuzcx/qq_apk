package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;
import kotlinx.coroutines.ci;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"})
public final class p
{
  private static final boolean abzt = true;
  
  public static final ci a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(205104);
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      paramMainDispatcherFactory = paramList;
    }
    catch (Throwable paramList)
    {
      for (;;)
      {
        paramMainDispatcherFactory = (ci)e(paramList, paramMainDispatcherFactory.hintOnError());
      }
    }
    AppMethodBeat.o(205104);
    return paramMainDispatcherFactory;
  }
  
  private static final q e(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(205105);
    if (abzt)
    {
      paramThrowable = new q(paramThrowable, paramString);
      AppMethodBeat.o(205105);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(205105);
      throw paramThrowable;
    }
    iSV();
    AppMethodBeat.o(205105);
    throw null;
  }
  
  public static final Void iSV()
  {
    AppMethodBeat.i(205107);
    Throwable localThrowable = (Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(205107);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.p
 * JD-Core Version:    0.7.0.1
 */