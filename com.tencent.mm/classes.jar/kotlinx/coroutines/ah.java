package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CompletionHandlerException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends RuntimeException
{
  public ah(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    AppMethodBeat.i(118265);
    AppMethodBeat.o(118265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ah
 * JD-Core Version:    0.7.0.1
 */