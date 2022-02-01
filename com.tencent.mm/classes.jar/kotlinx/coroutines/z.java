package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.l;
import d.m.i;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
public final class z
{
  private static final List<CoroutineExceptionHandler> Kdx;
  
  static
  {
    AppMethodBeat.i(118160);
    Kdx = i.c(i.d(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    AppMethodBeat.o(118160);
  }
  
  public static final void a(f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(118159);
    Iterator localIterator = Kdx.iterator();
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
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, aa.b(paramThrowable, localThrowable));
      }
    }
    paramf = Thread.currentThread();
    paramf.getUncaughtExceptionHandler().uncaughtException(paramf, paramThrowable);
    AppMethodBeat.o(118159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.z
 * JD-Core Version:    0.7.0.1
 */