package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends h
{
  public static final f ajBF;
  
  static
  {
    AppMethodBeat.i(118030);
    ajBF = new f();
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
 * Qualified Name:     kotlinx.coroutines.d.f
 * JD-Core Version:    0.7.0.1
 */