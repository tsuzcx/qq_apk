package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.k.j;
import kotlin.l;
import kotlinx.coroutines.ad;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c
  extends d
{
  private static final ad TUt;
  public static final c TWS;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(117977);
    Object localObject = new c();
    TWS = (c)localObject;
    int j = v.h("kotlinx.coroutines.io.parallelism", j.mZ(64, w.hNR()), 0, 0, 12);
    if (j > 0) {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(j)).toString());
      AppMethodBeat.o(117977);
      throw ((Throwable)localObject);
    }
    TUt = (ad)new f((d)localObject, j);
    AppMethodBeat.o(117977);
  }
  
  public static ad hMW()
  {
    return TUt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.b.c
 * JD-Core Version:    0.7.0.1
 */