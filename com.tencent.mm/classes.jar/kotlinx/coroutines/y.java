package kotlinx.coroutines;

import a.c.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
public final class y
{
  private static final List<x> ytr;
  
  static
  {
    AppMethodBeat.i(118477);
    ServiceLoader localServiceLoader = ServiceLoader.load(x.class, x.class.getClassLoader());
    a.f.b.j.p(localServiceLoader, "ServiceLoader.load(servi…serviceClass.classLoader)");
    ytr = a.a.j.m((Iterable)localServiceLoader);
    AppMethodBeat.o(118477);
  }
  
  public static final void a(e parame, Throwable paramThrowable)
  {
    AppMethodBeat.i(118476);
    a.f.b.j.q(parame, "context");
    a.f.b.j.q(paramThrowable, "exception");
    Iterator localIterator = ytr.iterator();
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      try
      {
        localx.handleException(parame, paramThrowable);
      }
      catch (Throwable localThrowable)
      {
        Thread localThread = Thread.currentThread();
        a.f.b.j.p(localThread, "currentThread");
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, z.b(paramThrowable, localThrowable));
      }
    }
    parame = Thread.currentThread();
    a.f.b.j.p(parame, "currentThread");
    parame.getUncaughtExceptionHandler().uncaughtException(parame, paramThrowable);
    AppMethodBeat.o(118476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.y
 * JD-Core Version:    0.7.0.1
 */