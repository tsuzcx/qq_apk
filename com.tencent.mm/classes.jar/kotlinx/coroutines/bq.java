package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "addSuppressedThrowable", "", "other", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class bq
{
  public static final CancellationException i(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(188803);
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    AppMethodBeat.o(188803);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bq
 * JD-Core Version:    0.7.0.1
 */