package kotlin.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "kotlin-stdlib-jdk7"})
public class a
  extends kotlin.e.a
{
  public final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(108133);
    p.k(paramThrowable1, "cause");
    p.k(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
    AppMethodBeat.o(108133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.a.a
 * JD-Core Version:    0.7.0.1
 */