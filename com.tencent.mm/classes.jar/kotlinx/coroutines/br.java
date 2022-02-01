package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class br
  extends al
  implements Closeable
{
  public static final a ajwm = new a((byte)0);
  
  public abstract void close();
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends kotlin.d.b<al, br>
  {
    private a()
    {
      super((kotlin.g.a.b)1.ajwn);
      AppMethodBeat.i(188851);
      AppMethodBeat.o(188851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.br
 * JD-Core Version:    0.7.0.1
 */