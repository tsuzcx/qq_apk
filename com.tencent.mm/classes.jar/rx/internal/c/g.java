package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import rx.g.a;

public final class g
  extends rx.g
{
  private final ThreadFactory IxJ;
  
  public g(ThreadFactory paramThreadFactory)
  {
    this.IxJ = paramThreadFactory;
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90385);
    h localh = new h(this.IxJ);
    AppMethodBeat.o(90385);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.g
 * JD-Core Version:    0.7.0.1
 */