package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.d;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"})
public final class bj
  extends bi
{
  private final Executor executor;
  
  public bj(Executor paramExecutor)
  {
    AppMethodBeat.i(209193);
    this.executor = paramExecutor;
    this.OfN = d.b(getExecutor());
    AppMethodBeat.o(209193);
  }
  
  public final Executor getExecutor()
  {
    return this.executor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bj
 * JD-Core Version:    0.7.0.1
 */