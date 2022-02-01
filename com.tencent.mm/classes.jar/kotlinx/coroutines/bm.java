package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import kotlin.l;
import kotlinx.coroutines.internal.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"})
public final class bm
  extends bl
{
  private final Executor executor;
  
  public bm(Executor paramExecutor)
  {
    AppMethodBeat.i(192321);
    this.executor = paramExecutor;
    this.TUJ = d.b(getExecutor());
    AppMethodBeat.o(192321);
  }
  
  public final Executor getExecutor()
  {
    return this.executor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bm
 * JD-Core Version:    0.7.0.1
 */