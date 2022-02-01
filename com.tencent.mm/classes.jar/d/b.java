package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.a;
import d.g.b.k;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "stackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "kotlin-stdlib"}, fOb=1)
public class b
{
  public static final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(129002);
    k.h(paramThrowable1, "$this$addSuppressed");
    k.h(paramThrowable2, "exception");
    d.e.b.KUw.a(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(129002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.b
 * JD-Core Version:    0.7.0.1
 */