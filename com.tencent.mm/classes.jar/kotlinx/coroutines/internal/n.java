package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;
import kotlinx.coroutines.bz;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"})
public final class n
{
  private static final boolean Ohe = true;
  
  public static final bz a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(209299);
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      paramMainDispatcherFactory = paramList;
    }
    catch (Throwable paramList)
    {
      for (;;)
      {
        paramMainDispatcherFactory = (bz)d(paramList, paramMainDispatcherFactory.hintOnError());
      }
    }
    AppMethodBeat.o(209299);
    return paramMainDispatcherFactory;
  }
  
  private static final o d(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(209300);
    if (Ohe)
    {
      paramThrowable = new o(paramThrowable, paramString);
      AppMethodBeat.o(209300);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(209300);
      throw paramThrowable;
    }
    gAI();
    AppMethodBeat.o(209300);
    throw null;
  }
  
  public static final Void gAI()
  {
    AppMethodBeat.i(209302);
    Throwable localThrowable = (Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(209302);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.n
 * JD-Core Version:    0.7.0.1
 */