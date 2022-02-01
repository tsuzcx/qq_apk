package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class bt
{
  public static final br b(ExecutorService paramExecutorService)
  {
    AppMethodBeat.i(188815);
    paramExecutorService = (br)new bs((Executor)paramExecutorService);
    AppMethodBeat.o(188815);
    return paramExecutorService;
  }
  
  public static final al g(Executor paramExecutor)
  {
    AppMethodBeat.i(188819);
    if ((paramExecutor instanceof bf)) {}
    for (bf localbf = (bf)paramExecutor; localbf == null; localbf = null)
    {
      paramExecutor = (al)new bs(paramExecutor);
      AppMethodBeat.o(188819);
      return paramExecutor;
    }
    AppMethodBeat.o(188819);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bt
 * JD-Core Version:    0.7.0.1
 */