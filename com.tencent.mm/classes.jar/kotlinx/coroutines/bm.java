package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "addSuppressedThrowable", "", "other", "kotlinx-coroutines-core"})
public final class bm
{
  public static final CancellationException c(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(204273);
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    AppMethodBeat.o(204273);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bm
 * JD-Core Version:    0.7.0.1
 */