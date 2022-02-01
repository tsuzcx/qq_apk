package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class c
{
  public static final boolean u(Throwable paramThrowable)
  {
    AppMethodBeat.i(61356);
    p.k(paramThrowable, "$this$isProcessCanceledException");
    paramThrowable = paramThrowable.getClass();
    Class localClass;
    do
    {
      if (p.h(paramThrowable.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException"))
      {
        AppMethodBeat.o(61356);
        return true;
      }
      localClass = paramThrowable.getSuperclass();
      paramThrowable = localClass;
    } while (localClass != null);
    AppMethodBeat.o(61356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.o.c
 * JD-Core Version:    0.7.0.1
 */