package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "clearDeadline", "clearTimeout", "deadlineNanoTime", "", "hasDeadline", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "okio"}, k=1, mv={1, 4, 1})
public final class l
  extends ab
{
  public ab ajTi;
  
  public l(ab paramab)
  {
    AppMethodBeat.i(186238);
    this.ajTi = paramab;
    AppMethodBeat.o(186238);
  }
  
  public final ab Cn(long paramLong)
  {
    AppMethodBeat.i(186253);
    ab localab = this.ajTi.Cn(paramLong);
    AppMethodBeat.o(186253);
    return localab;
  }
  
  public final ab b(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(186242);
    s.u(paramTimeUnit, "unit");
    paramTimeUnit = this.ajTi.b(paramLong, paramTimeUnit);
    AppMethodBeat.o(186242);
    return paramTimeUnit;
  }
  
  public final long kIQ()
  {
    AppMethodBeat.i(186245);
    long l = this.ajTi.kIQ();
    AppMethodBeat.o(186245);
    return l;
  }
  
  public final boolean kIR()
  {
    AppMethodBeat.i(186247);
    boolean bool = this.ajTi.kIR();
    AppMethodBeat.o(186247);
    return bool;
  }
  
  public final long kIS()
  {
    AppMethodBeat.i(186251);
    long l = this.ajTi.kIS();
    AppMethodBeat.o(186251);
    return l;
  }
  
  public final ab kIT()
  {
    AppMethodBeat.i(186256);
    ab localab = this.ajTi.kIT();
    AppMethodBeat.o(186256);
    return localab;
  }
  
  public final ab kIU()
  {
    AppMethodBeat.i(186260);
    ab localab = this.ajTi.kIU();
    AppMethodBeat.o(186260);
    return localab;
  }
  
  public final void kIV()
  {
    AppMethodBeat.i(186261);
    this.ajTi.kIV();
    AppMethodBeat.o(186261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.l
 * JD-Core Version:    0.7.0.1
 */