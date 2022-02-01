package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface CoroutineExceptionHandler
  extends f.b
{
  public static final a ajvG = a.ajvH;
  
  public abstract void handleException(f paramf, Throwable paramThrowable);
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.c<CoroutineExceptionHandler>
  {
    static
    {
      AppMethodBeat.i(118049);
      ajvH = new a();
      AppMethodBeat.o(118049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandler
 * JD-Core Version:    0.7.0.1
 */