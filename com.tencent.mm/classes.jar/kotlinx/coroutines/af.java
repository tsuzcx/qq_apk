package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"})
public final class af
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
    a.a((Throwable)paramThrowable2, paramThrowable1);
    paramThrowable1 = (Throwable)paramThrowable2;
    AppMethodBeat.o(118053);
    return paramThrowable1;
  }
  
  public static final void b(f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(192334);
    try
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)paramf.get((f.c)CoroutineExceptionHandler.TTS);
      if (localCoroutineExceptionHandler != null)
      {
        localCoroutineExceptionHandler.handleException(paramf, paramThrowable);
        AppMethodBeat.o(192334);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.a(paramf, b(paramThrowable, localThrowable));
      AppMethodBeat.o(192334);
      return;
    }
    ae.a(paramf, paramThrowable);
    AppMethodBeat.o(192334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.af
 * JD-Core Version:    0.7.0.1
 */