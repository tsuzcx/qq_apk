package kotlin.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "kotlin-stdlib-jdk7"}, k=1, mv={1, 5, 1})
public class a
  extends kotlin.e.a
{
  public final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(108133);
    s.u(paramThrowable1, "cause");
    s.u(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
    AppMethodBeat.o(108133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.a.a
 * JD-Core Version:    0.7.0.1
 */