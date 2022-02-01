package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"})
public final class g
  extends m
{
  public static final g Kgp;
  
  static
  {
    AppMethodBeat.i(118030);
    Kgp = new g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.g
 * JD-Core Version:    0.7.0.1
 */