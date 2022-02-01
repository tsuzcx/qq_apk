package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f.b;
import d.d.f.c;
import java.io.Closeable;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"})
public abstract class bg
  extends ab
  implements Closeable
{
  public static final a LRK = new a((byte)0);
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends d.d.b<ab, bg>
  {
    private a()
    {
      super((d.g.a.b)1.LRL);
      AppMethodBeat.i(191184);
      AppMethodBeat.o(191184);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bg
 * JD-Core Version:    0.7.0.1
 */