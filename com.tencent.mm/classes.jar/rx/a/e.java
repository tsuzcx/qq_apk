package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends RuntimeException
{
  public e(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public e(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage(), paramThrowable);
    AppMethodBeat.i(90050);
    AppMethodBeat.o(90050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.a.e
 * JD-Core Version:    0.7.0.1
 */