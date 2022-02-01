package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.b;
import d.d.f.c;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"})
public abstract interface CoroutineExceptionHandler
  extends f.b
{
  public static final a Kdv = a.Kdw;
  
  public abstract void handleException(f paramf, Throwable paramThrowable);
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    implements f.c<CoroutineExceptionHandler>
  {
    static
    {
      AppMethodBeat.i(118049);
      Kdw = new a();
      AppMethodBeat.o(118049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandler
 * JD-Core Version:    0.7.0.1
 */