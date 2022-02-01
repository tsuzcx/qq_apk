package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"})
public abstract interface CoroutineExceptionHandler
  extends f.b
{
  public static final a TTS = a.TTT;
  
  public abstract void handleException(f paramf, Throwable paramThrowable);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    implements f.c<CoroutineExceptionHandler>
  {
    static
    {
      AppMethodBeat.i(118049);
      TTT = new a();
      AppMethodBeat.o(118049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandler
 * JD-Core Version:    0.7.0.1
 */