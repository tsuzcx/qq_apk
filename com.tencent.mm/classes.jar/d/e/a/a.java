package d.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "kotlin-stdlib-jdk7"})
public class a
  extends d.e.a
{
  public final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(108133);
    k.h(paramThrowable1, "cause");
    k.h(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
    AppMethodBeat.o(108133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.e.a.a
 * JD-Core Version:    0.7.0.1
 */