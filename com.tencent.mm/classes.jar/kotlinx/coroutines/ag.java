package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.d.f;
import kotlin.l;
import kotlin.m.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
public final class ag
{
  private static final List<CoroutineExceptionHandler> tKi;
  
  static
  {
    AppMethodBeat.i(118160);
    tKi = i.c(i.d(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    AppMethodBeat.o(118160);
  }
  
  public static final void a(f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(118159);
    Iterator localIterator = tKi.iterator();
    while (localIterator.hasNext())
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)localIterator.next();
      try
      {
        localCoroutineExceptionHandler.handleException(paramf, paramThrowable);
      }
      catch (Throwable localThrowable)
      {
        Thread localThread = Thread.currentThread();
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, ah.b(paramThrowable, localThrowable));
      }
    }
    paramf = Thread.currentThread();
    paramf.getUncaughtExceptionHandler().uncaughtException(paramf, paramThrowable);
    AppMethodBeat.o(118159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ag
 * JD-Core Version:    0.7.0.1
 */