package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.g;
import rx.g.a;

@Deprecated
public final class ImmediateScheduler
  extends g
{
  private ImmediateScheduler()
  {
    AppMethodBeat.i(90088);
    IllegalStateException localIllegalStateException = new IllegalStateException("No instances!");
    AppMethodBeat.o(90088);
    throw localIllegalStateException;
  }
  
  public final g.a createWorker()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.schedulers.ImmediateScheduler
 * JD-Core Version:    0.7.0.1
 */