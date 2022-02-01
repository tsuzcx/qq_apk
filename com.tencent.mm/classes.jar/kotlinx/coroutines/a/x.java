package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;
import kotlinx.coroutines.br;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"})
public final class x
{
  private static final boolean LEH = true;
  
  public static final br a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(202351);
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      paramMainDispatcherFactory = paramList;
    }
    catch (Throwable paramList)
    {
      for (;;)
      {
        paramMainDispatcherFactory = (br)f(paramList, paramMainDispatcherFactory.hintOnError());
      }
    }
    AppMethodBeat.o(202351);
    return paramMainDispatcherFactory;
  }
  
  private static final y f(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(202352);
    if (LEH)
    {
      paramThrowable = new y(paramThrowable, paramString);
      AppMethodBeat.o(202352);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(202352);
      throw paramThrowable;
    }
    gaL();
    AppMethodBeat.o(202352);
    throw null;
  }
  
  public static final Void gaL()
  {
    AppMethodBeat.i(202354);
    Throwable localThrowable = (Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(202354);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.x
 * JD-Core Version:    0.7.0.1
 */