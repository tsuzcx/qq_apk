package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.h;
import d.l;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c
  extends d
{
  private static final y KdW;
  public static final c Kgk;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(117977);
    Object localObject = new c();
    Kgk = (c)localObject;
    int j = n.f("kotlinx.coroutines.io.parallelism", h.kK(64, o.fLT()), 0, 0, 12);
    if (j > 0) {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(j)).toString());
      AppMethodBeat.o(117977);
      throw ((Throwable)localObject);
    }
    KdW = (y)new f((d)localObject, j);
    AppMethodBeat.o(117977);
  }
  
  public static y fLg()
  {
    return KdW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.c
 * JD-Core Version:    0.7.0.1
 */