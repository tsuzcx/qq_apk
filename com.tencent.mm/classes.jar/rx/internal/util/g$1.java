package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;

final class g$1
  implements ThreadFactory
{
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(90205);
    paramRunnable = new AssertionError("No threads allowed.");
    AppMethodBeat.o(90205);
    throw paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     rx.internal.util.g.1
 * JD-Core Version:    0.7.0.1
 */