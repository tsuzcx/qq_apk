package kotlinx.coroutines;

import a.a;
import a.c.e;
import a.c.e.c;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "caller", "Lkotlinx/coroutines/Job;", "handleExceptionViaHandler", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"})
public final class z
{
  public static final void a(e parame, Throwable paramThrowable, bc parambc)
  {
    AppMethodBeat.i(118374);
    j.q(parame, "context");
    j.q(paramThrowable, "exception");
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(118374);
      return;
    }
    bc localbc = (bc)parame.get((e.c)bc.CIk);
    if ((localbc != null) && (localbc != parambc) && (localbc.y(paramThrowable)))
    {
      AppMethodBeat.o(118374);
      return;
    }
    b(parame, paramThrowable);
    AppMethodBeat.o(118374);
  }
  
  public static final Throwable b(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(118376);
    j.q(paramThrowable1, "originalException");
    j.q(paramThrowable2, "thrownException");
    if (paramThrowable1 == paramThrowable2)
    {
      AppMethodBeat.o(118376);
      return paramThrowable1;
    }
    paramThrowable2 = new RuntimeException("Exception while trying to handle coroutine exception", paramThrowable2);
    a.a((Throwable)paramThrowable2, paramThrowable1);
    paramThrowable1 = (Throwable)paramThrowable2;
    AppMethodBeat.o(118376);
    return paramThrowable1;
  }
  
  public static final void b(e parame, Throwable paramThrowable)
  {
    AppMethodBeat.i(118375);
    j.q(parame, "context");
    j.q(paramThrowable, "exception");
    try
    {
      x localx = (x)parame.get((e.c)x.CHx);
      if (localx != null)
      {
        localx.handleException(parame, paramThrowable);
        AppMethodBeat.o(118375);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      y.a(parame, b(paramThrowable, localThrowable));
      AppMethodBeat.o(118375);
      return;
    }
    y.a(parame, paramThrowable);
    AppMethodBeat.o(118375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.z
 * JD-Core Version:    0.7.0.1
 */