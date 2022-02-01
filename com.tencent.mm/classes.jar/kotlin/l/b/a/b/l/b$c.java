package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public abstract interface b$c
{
  public static final c abpw = new c()
  {
    public final RuntimeException t(Throwable paramAnonymousThrowable)
    {
      AppMethodBeat.i(60507);
      p.k(paramAnonymousThrowable, "e");
      AppMethodBeat.o(60507);
      throw paramAnonymousThrowable;
    }
  };
  
  public abstract RuntimeException t(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.l.b.c
 * JD-Core Version:    0.7.0.1
 */