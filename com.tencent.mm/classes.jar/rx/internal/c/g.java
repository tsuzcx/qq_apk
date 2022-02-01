package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import rx.g.a;

public final class g
  extends rx.g
{
  private final ThreadFactory LTn;
  
  public g(ThreadFactory paramThreadFactory)
  {
    this.LTn = paramThreadFactory;
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90385);
    h localh = new h(this.LTn);
    AppMethodBeat.o(90385);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.g
 * JD-Core Version:    0.7.0.1
 */