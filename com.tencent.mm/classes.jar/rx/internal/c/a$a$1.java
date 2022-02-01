package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;

final class a$a$1
  implements ThreadFactory
{
  a$a$1(a.a parama, ThreadFactory paramThreadFactory) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(90310);
    paramRunnable = this.OvS.newThread(paramRunnable);
    paramRunnable.setName(paramRunnable.getName() + " (Evictor)");
    AppMethodBeat.o(90310);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.a.a.1
 * JD-Core Version:    0.7.0.1
 */