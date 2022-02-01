package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
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
      finally
      {
        kotlin.b.a(paramThrowable, paramCloseable);
      }
    }
    AppMethodBeat.o(129275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.f.b
 * JD-Core Version:    0.7.0.1
 */