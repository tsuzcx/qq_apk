package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;
import kotlinx.coroutines.bz;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"})
public final class n
{
  private static final boolean NJY = true;
  
  public static final bz a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(190808);
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
    AppMethodBeat.o(190808);
    return paramMainDispatcherFactory;
  }
  
  private static final o d(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(190809);
    if (NJY)
    {
      paramThrowable = new o(paramThrowable, paramString);
      AppMethodBeat.o(190809);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(190809);
      throw paramThrowable;
    }
    gwg();
    AppMethodBeat.o(190809);
    throw null;
  }
  
  public static final Void gwg()
  {
    AppMethodBeat.i(190811);
    Throwable localThrowable = (Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(190811);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.n
 * JD-Core Version:    0.7.0.1
 */