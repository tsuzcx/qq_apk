package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.e.a;
import kotlin.e.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/ExceptionsKt")
public class c
{
  public static final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(129002);
    s.u(paramThrowable1, "$this$addSuppressed");
    s.u(paramThrowable2, "exception");
    if (paramThrowable1 != paramThrowable2) {
      b.aiwB.a(paramThrowable1, paramThrowable2);
    }
    AppMethodBeat.o(129002);
  }
  
  public static final String stackTraceToString(Throwable paramThrowable)
  {
    AppMethodBeat.i(190960);
    s.u(paramThrowable, "$this$stackTraceToString");
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    paramThrowable = localStringWriter.toString();
    s.s(paramThrowable, "sw.toString()");
    AppMethodBeat.o(190960);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.c
 * JD-Core Version:    0.7.0.1
 */