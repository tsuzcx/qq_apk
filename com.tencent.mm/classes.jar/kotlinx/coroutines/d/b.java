package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.k.k;
import kotlinx.coroutines.al;
import kotlinx.coroutines.internal.ad;
import kotlinx.coroutines.internal.ae;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  public static final b ajBA;
  private static final al ajvY;
  
  static
  {
    AppMethodBeat.i(117977);
    ajBA = new b();
    ajvY = (al)new e((c)ajBA, ad.h("kotlinx.coroutines.io.parallelism", k.qu(64, ae.kEp()), 0, 0, 12), "Dispatchers.IO");
    AppMethodBeat.o(117977);
  }
  
  public static al kCi()
  {
    return ajvY;
  }
  
  public final void close()
  {
    AppMethodBeat.i(117976);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    AppMethodBeat.o(117976);
    throw localUnsupportedOperationException;
  }
  
  public final String toString()
  {
    return "Dispatchers.Default";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.b
 * JD-Core Version:    0.7.0.1
 */