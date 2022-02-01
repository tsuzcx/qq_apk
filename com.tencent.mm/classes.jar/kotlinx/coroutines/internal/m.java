package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;
import kotlinx.coroutines.bw;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"})
public final class m
{
  private static final boolean LTb = true;
  
  public static final bw a(MainDispatcherFactory paramMainDispatcherFactory, List<? extends MainDispatcherFactory> paramList)
  {
    AppMethodBeat.i(191197);
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      paramMainDispatcherFactory = paramList;
    }
    catch (Throwable paramList)
    {
      for (;;)
      {
        paramMainDispatcherFactory = (bw)d(paramList, paramMainDispatcherFactory.hintOnError());
      }
    }
    AppMethodBeat.o(191197);
    return paramMainDispatcherFactory;
  }
  
  private static final n d(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(191198);
    if (LTb)
    {
      paramThrowable = new n(paramThrowable, paramString);
      AppMethodBeat.o(191198);
      return paramThrowable;
    }
    if (paramThrowable != null)
    {
      AppMethodBeat.o(191198);
      throw paramThrowable;
    }
    geH();
    AppMethodBeat.o(191198);
    throw null;
  }
  
  public static final Void geH()
  {
    AppMethodBeat.i(191200);
    Throwable localThrowable = (Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    AppMethodBeat.o(191200);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.m
 * JD-Core Version:    0.7.0.1
 */