package d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a;
import d.l;
import java.io.Closeable;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class b
{
  public static final void a(Closeable paramCloseable, Throwable paramThrowable)
  {
    AppMethodBeat.i(129275);
    if (paramCloseable != null)
    {
      if (paramThrowable == null)
      {
        paramCloseable.close();
        AppMethodBeat.o(129275);
        return;
      }
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(129275);
        return;
      }
      catch (Throwable paramCloseable)
      {
        a.a(paramThrowable, paramCloseable);
      }
    }
    AppMethodBeat.o(129275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.f.b
 * JD-Core Version:    0.7.0.1
 */