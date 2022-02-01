package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a;
import d.d.f;
import d.d.f.c;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"})
public final class ae
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
    AppMethodBeat.i(209205);
    try
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)paramf.get((f.c)CoroutineExceptionHandler.OeY);
      if (localCoroutineExceptionHandler != null)
      {
        localCoroutineExceptionHandler.handleException(paramf, paramThrowable);
        AppMethodBeat.o(209205);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.a(paramf, b(paramThrowable, localThrowable));
      AppMethodBeat.o(209205);
      return;
    }
    ad.a(paramf, paramThrowable);
    AppMethodBeat.o(209205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ae
 * JD-Core Version:    0.7.0.1
 */