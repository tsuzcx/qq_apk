package kotlinx.coroutines.c;

import a.i.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.w;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c
  extends d
{
  private static final w CHT;
  public static final c CKp;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(118301);
    Object localObject = new c();
    CKp = (c)localObject;
    int j = n.g("kotlinx.coroutines.io.parallelism", e.iE(64, n.eqo()), 0, 0, 12);
    if (j > 0) {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(j)).toString());
      AppMethodBeat.o(118301);
      throw ((Throwable)localObject);
    }
    CHT = (w)new f((d)localObject, j, l.CKD);
    AppMethodBeat.o(118301);
  }
  
  public static w epI()
  {
    return CHT;
  }
  
  public final void close()
  {
    AppMethodBeat.i(118300);
    Throwable localThrowable = (Throwable)new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    AppMethodBeat.o(118300);
    throw localThrowable;
  }
  
  public final String toString()
  {
    return "DefaultDispatcher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.c.c
 * JD-Core Version:    0.7.0.1
 */