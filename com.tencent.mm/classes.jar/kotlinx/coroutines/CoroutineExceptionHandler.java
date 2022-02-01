package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"})
public abstract interface CoroutineExceptionHandler
  extends f.b
{
  public static final a abww = a.abwx;
  
  public abstract void handleException(f paramf, Throwable paramThrowable);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    implements f.c<CoroutineExceptionHandler>
  {
    static
    {
      AppMethodBeat.i(118049);
      abwx = new a();
      AppMethodBeat.o(118049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandler
 * JD-Core Version:    0.7.0.1
 */