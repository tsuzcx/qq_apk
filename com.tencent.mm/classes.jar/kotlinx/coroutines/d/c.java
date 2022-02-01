package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.k.i;
import kotlin.l;
import kotlinx.coroutines.af;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c
  extends d
{
  public static final c abAj;
  private static final af abwW;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(117977);
    Object localObject = new c();
    abAj = (c)localObject;
    int j = w.i("kotlinx.coroutines.io.parallelism", i.ov(64, x.iSX()), 0, 0, 12);
    if (j > 0) {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(j)).toString());
      AppMethodBeat.o(117977);
      throw ((Throwable)localObject);
    }
    abwW = (af)new f((d)localObject, j);
    AppMethodBeat.o(117977);
  }
  
  public static af iRs()
  {
    return abwW;
  }
  
  public final void close()
  {
    AppMethodBeat.i(117976);
    Throwable localThrowable = (Throwable)new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    AppMethodBeat.o(117976);
    throw localThrowable;
  }
  
  public final String toString()
  {
    return "DefaultDispatcher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.d.c
 * JD-Core Version:    0.7.0.1
 */