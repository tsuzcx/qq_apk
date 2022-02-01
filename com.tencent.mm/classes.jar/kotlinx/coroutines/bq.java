package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"})
public final class bq
{
  public static final bn a(ExecutorService paramExecutorService)
  {
    AppMethodBeat.i(205119);
    paramExecutorService = (bn)new bp((Executor)paramExecutorService);
    AppMethodBeat.o(205119);
    return paramExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.bq
 * JD-Core Version:    0.7.0.1
 */