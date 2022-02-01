package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"})
public abstract class bk
  extends ad
  implements Closeable
{
  public static final a TUH = new a((byte)0);
  
  public abstract Executor getExecutor();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends kotlin.d.b<ad, bk>
  {
    private a()
    {
      super((kotlin.g.a.b)1.TUI);
      AppMethodBeat.i(192428);
      AppMethodBeat.o(192428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bk
 * JD-Core Version:    0.7.0.1
 */