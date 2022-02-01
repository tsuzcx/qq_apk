package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"})
public final class g
  extends m
{
  public static final g Oia;
  
  static
  {
    AppMethodBeat.i(118030);
    Oia = new g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.g
 * JD-Core Version:    0.7.0.1
 */