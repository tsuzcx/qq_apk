package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.h;
import d.l;
import kotlinx.coroutines.ab;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.u;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c
  extends d
{
  private static final ab LRx;
  public static final c LTU;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(117977);
    Object localObject = new c();
    LTU = (c)localObject;
    int j = t.f("kotlinx.coroutines.io.parallelism", h.la(64, u.geJ()), 0, 0, 12);
    if (j > 0) {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(j)).toString());
      AppMethodBeat.o(117977);
      throw ((Throwable)localObject);
    }
    LRx = (ab)new f((d)localObject, j);
    AppMethodBeat.o(117977);
  }
  
  public static ab gdP()
  {
    return LRx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.c
 * JD-Core Version:    0.7.0.1
 */