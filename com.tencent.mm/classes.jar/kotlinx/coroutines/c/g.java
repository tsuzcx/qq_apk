package kotlinx.coroutines.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"})
public final class g
  extends n
{
  public static final g CKx;
  
  static
  {
    AppMethodBeat.i(118354);
    CKx = new g();
    AppMethodBeat.o(118354);
  }
  
  public final long nanoTime()
  {
    AppMethodBeat.i(118353);
    long l = System.nanoTime();
    AppMethodBeat.o(118353);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.c.g
 * JD-Core Version:    0.7.0.1
 */