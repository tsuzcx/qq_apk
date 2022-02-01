package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"})
public final class g
  extends m
{
  public static final g abAo;
  
  static
  {
    AppMethodBeat.i(118030);
    abAo = new g();
    AppMethodBeat.o(118030);
  }
  
  public final long nanoTime()
  {
    AppMethodBeat.i(118029);
    long l = System.nanoTime();
    AppMethodBeat.o(118029);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.d.g
 * JD-Core Version:    0.7.0.1
 */