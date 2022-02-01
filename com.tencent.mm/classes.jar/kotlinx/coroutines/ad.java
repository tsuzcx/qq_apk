package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.l;
import d.m.i;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
public final class ad
{
  private static final List<CoroutineExceptionHandler> NHU;
  
  static
  {
    AppMethodBeat.i(118160);
    NHU = i.c(i.d(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    AppMethodBeat.o(118160);
  }
  
  public static final void a(f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(118159);
    Iterator localIterator = NHU.iterator();
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
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, ae.b(paramThrowable, localThrowable));
      }
    }
    paramf = Thread.currentThread();
    paramf.getUncaughtExceptionHandler().uncaughtException(paramf, paramThrowable);
    AppMethodBeat.o(118159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ad
 * JD-Core Version:    0.7.0.1
 */