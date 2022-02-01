package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class c
{
  public static final boolean r(Throwable paramThrowable)
  {
    AppMethodBeat.i(61356);
    k.h(paramThrowable, "$this$isProcessCanceledException");
    paramThrowable = paramThrowable.getClass();
    Class localClass;
    do
    {
      if (k.g(paramThrowable.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException"))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.c
 * JD-Core Version:    0.7.0.1
 */