package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"})
public abstract class bn
  extends af
  implements Closeable
{
  public static final a abxl = new a((byte)0);
  
  public abstract void close();
  
  public abstract Executor getExecutor();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends kotlin.d.b<af, bn>
  {
    private a()
    {
      super((kotlin.g.a.b)1.abxm);
      AppMethodBeat.i(204652);
      AppMethodBeat.o(204652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bn
 * JD-Core Version:    0.7.0.1
 */