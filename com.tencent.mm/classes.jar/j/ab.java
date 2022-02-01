package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "", "other", "block", "Lkotlin/Function0;", "throwIfReached", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, k=1, mv={1, 4, 1})
public class ab
{
  public static final ab ajTJ;
  public static final ab.a ajTK;
  private boolean ajTG;
  private long ajTH;
  private long ajTI;
  
  static
  {
    AppMethodBeat.i(186448);
    ajTK = new ab.a((byte)0);
    ajTJ = (ab)new b();
    AppMethodBeat.o(186448);
  }
  
  public ab Cn(long paramLong)
  {
    this.ajTG = true;
    this.ajTH = paramLong;
    return this;
  }
  
  public ab b(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(186454);
    s.u(paramTimeUnit, "unit");
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramTimeUnit = (Throwable)new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186454);
      throw paramTimeUnit;
    }
    this.ajTI = paramTimeUnit.toNanos(paramLong);
    AppMethodBeat.o(186454);
    return this;
  }
  
  public long kIQ()
  {
    return this.ajTI;
  }
  
  public boolean kIR()
  {
    return this.ajTG;
  }
  
  public long kIS()
  {
    AppMethodBeat.i(186461);
    if (!this.ajTG)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException("No deadline".toString());
      AppMethodBeat.o(186461);
      throw localThrowable;
    }
    long l = this.ajTH;
    AppMethodBeat.o(186461);
    return l;
  }
  
  public ab kIT()
  {
    this.ajTI = 0L;
    return this;
  }
  
  public ab kIU()
  {
    this.ajTG = false;
    return this;
  }
  
  public void kIV()
  {
    AppMethodBeat.i(186469);
    Object localObject = Thread.currentThread();
    s.s(localObject, "Thread.currentThread()");
    if (((Thread)localObject).isInterrupted())
    {
      localObject = (Throwable)new InterruptedIOException("interrupted");
      AppMethodBeat.o(186469);
      throw ((Throwable)localObject);
    }
    if ((this.ajTG) && (this.ajTH - System.nanoTime() <= 0L))
    {
      localObject = (Throwable)new InterruptedIOException("deadline reached");
      AppMethodBeat.o(186469);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(186469);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Timeout$Companion$NONE$1", "Lokio/Timeout;", "deadlineNanoTime", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "okio"}, k=1, mv={1, 4, 1})
  public static final class b
    extends ab
  {
    public final ab Cn(long paramLong)
    {
      return (ab)this;
    }
    
    public final ab b(long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(186450);
      s.u(paramTimeUnit, "unit");
      paramTimeUnit = (ab)this;
      AppMethodBeat.o(186450);
      return paramTimeUnit;
    }
    
    public final void kIV() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.ab
 * JD-Core Version:    0.7.0.1
 */