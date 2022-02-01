package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.j;
import d.l;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c
  extends d
{
  private static final ac Ofy;
  public static final c OhV;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(117977);
    Object localObject = new c();
    OhV = (c)localObject;
    int j = u.g("kotlinx.coroutines.io.parallelism", j.lw(64, v.gAK()), 0, 0, 12);
    if (j > 0) {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(j)).toString());
      AppMethodBeat.o(117977);
      throw ((Throwable)localObject);
    }
    Ofy = (ac)new f((d)localObject, j);
    AppMethodBeat.o(117977);
  }
  
  public static ac gzR()
  {
    return Ofy;
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