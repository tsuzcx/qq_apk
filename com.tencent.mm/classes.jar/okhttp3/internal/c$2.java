package okhttp3.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;

final class c$2
  implements ThreadFactory
{
  c$2(String paramString, boolean paramBoolean) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(186739);
    paramRunnable = new Thread(paramRunnable, this.val$name);
    paramRunnable.setDaemon(this.val$daemon);
    AppMethodBeat.o(186739);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     okhttp3.internal.c.2
 * JD-Core Version:    0.7.0.1
 */