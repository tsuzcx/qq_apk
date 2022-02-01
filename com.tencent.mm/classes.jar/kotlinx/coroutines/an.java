package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.b;
import kotlin.d.f;
import kotlin.d.f.c;

@Metadata(d1={""}, d2={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class an
{
  public static final Throwable b(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(118053);
    if (paramThrowable1 == paramThrowable2)
    {
      AppMethodBeat.o(118053);
      return paramThrowable1;
    }
    paramThrowable2 = new RuntimeException("Exception while trying to handle coroutine exception", paramThrowable2);
    b.a((Throwable)paramThrowable2, paramThrowable1);
    paramThrowable1 = (Throwable)paramThrowable2;
    AppMethodBeat.o(118053);
    return paramThrowable1;
  }
  
  public static final void b(f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(188845);
    try
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)paramf.get((f.c)CoroutineExceptionHandler.ajvG);
      if (localCoroutineExceptionHandler != null)
      {
        localCoroutineExceptionHandler.handleException(paramf, paramThrowable);
        AppMethodBeat.o(188845);
        return;
      }
    }
    finally
    {
      am.a(paramf, b(paramThrowable, localThrowable));
      AppMethodBeat.o(188845);
      return;
    }
    am.a(paramf, paramThrowable);
    AppMethodBeat.o(188845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.an
 * JD-Core Version:    0.7.0.1
 */