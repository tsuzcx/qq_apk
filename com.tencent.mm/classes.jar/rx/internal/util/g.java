package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class g
  extends AtomicLong
  implements ThreadFactory
{
  public static final ThreadFactory KrM;
  final String htS;
  
  static
  {
    AppMethodBeat.i(90207);
    KrM = new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(90205);
        paramAnonymousRunnable = new AssertionError("No threads allowed.");
        AppMethodBeat.o(90205);
        throw paramAnonymousRunnable;
      }
    };
    AppMethodBeat.o(90207);
  }
  
  public g(String paramString)
  {
    this.htS = paramString;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(90206);
    paramRunnable = new Thread(paramRunnable, this.htS + incrementAndGet());
    paramRunnable.setDaemon(true);
    AppMethodBeat.o(90206);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     rx.internal.util.g
 * JD-Core Version:    0.7.0.1
 */