package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f.b;
import d.d.f.c;
import d.g.b.q;
import d.l;
import java.io.Closeable;
import java.util.concurrent.Executor;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"})
public abstract class bh
  extends ac
  implements Closeable
{
  public static final a NIF = new a((byte)0);
  
  public abstract Executor getExecutor();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends d.d.b<ac, bh>
  {
    private a()
    {
      super((d.g.a.b)1.NIG);
      AppMethodBeat.i(190795);
      AppMethodBeat.o(190795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bh
 * JD-Core Version:    0.7.0.1
 */