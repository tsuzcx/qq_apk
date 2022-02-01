package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f.b;
import d.d.f.c;
import d.g.b.q;
import d.l;
import java.io.Closeable;
import java.util.concurrent.Executor;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"})
public abstract class bh
  extends ac
  implements Closeable
{
  public static final a OfL = new a((byte)0);
  
  public abstract Executor getExecutor();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    extends d.d.b<ac, bh>
  {
    private a()
    {
      super((d.g.a.b)1.OfM);
      AppMethodBeat.i(209286);
      AppMethodBeat.o(209286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bh
 * JD-Core Version:    0.7.0.1
 */