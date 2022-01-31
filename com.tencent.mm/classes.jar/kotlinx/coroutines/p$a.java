package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Ljava/lang/Thread;", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"})
final class p$a
  implements ThreadFactory
{
  p$a(AtomicInteger paramAtomicInteger) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(118523);
    paramRunnable = new Thread(paramRunnable, "CommonPool-worker-" + this.CHt.incrementAndGet());
    paramRunnable.setDaemon(true);
    AppMethodBeat.o(118523);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.p.a
 * JD-Core Version:    0.7.0.1
 */