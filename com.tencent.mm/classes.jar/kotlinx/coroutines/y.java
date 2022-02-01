package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CompletionHandlerException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
public final class y
  extends RuntimeException
{
  public y(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    AppMethodBeat.i(118265);
    AppMethodBeat.o(118265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.y
 * JD-Core Version:    0.7.0.1
 */