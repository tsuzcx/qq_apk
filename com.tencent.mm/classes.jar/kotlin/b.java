package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.e.a;
import kotlin.g.b.p;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "stackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "kotlin-stdlib"}, iBN=1)
public class b
{
  public static final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(129002);
    p.k(paramThrowable1, "$this$addSuppressed");
    p.k(paramThrowable2, "exception");
    kotlin.e.b.aaAQ.a(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(129002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.b
 * JD-Core Version:    0.7.0.1
 */