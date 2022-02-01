package com.tencent.tav.core.parallel.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/util/ParallelSPStorage;", "", "()V", "DEBUG_COUNT", "", "DEBUG_ERROR_FREQUENCY", "makeDebugError", "", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class ParallelSPStorage
{
  private static int DEBUG_COUNT;
  private static int DEBUG_ERROR_FREQUENCY;
  public static final ParallelSPStorage INSTANCE;
  
  static
  {
    AppMethodBeat.i(215546);
    INSTANCE = new ParallelSPStorage();
    DEBUG_ERROR_FREQUENCY = 4;
    AppMethodBeat.o(215546);
  }
  
  public final void makeDebugError()
  {
    AppMethodBeat.i(215555);
    int i = DEBUG_COUNT + 1;
    DEBUG_COUNT = i;
    if (i % DEBUG_ERROR_FREQUENCY == 0)
    {
      Throwable localThrowable = (Throwable)new Exception("debug error");
      AppMethodBeat.o(215555);
      throw localThrowable;
    }
    AppMethodBeat.o(215555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tav.core.parallel.util.ParallelSPStorage
 * JD-Core Version:    0.7.0.1
 */