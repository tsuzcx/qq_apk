package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a;
import d.d.f;
import d.d.f.c;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"})
public final class aa
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
    AppMethodBeat.i(189994);
    try
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)paramf.get((f.c)CoroutineExceptionHandler.Kdv);
      if (localCoroutineExceptionHandler != null)
      {
        localCoroutineExceptionHandler.handleException(paramf, paramThrowable);
        AppMethodBeat.o(189994);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      z.a(paramf, b(paramThrowable, localThrowable));
      AppMethodBeat.o(189994);
      return;
    }
    z.a(paramf, paramThrowable);
    AppMethodBeat.o(189994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.aa
 * JD-Core Version:    0.7.0.1
 */