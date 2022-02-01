package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class e
{
  public static final Class<?> e(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(57363);
    s.u(paramClassLoader, "<this>");
    s.u(paramString, "fqName");
    try
    {
      paramClassLoader = Class.forName(paramString, false, paramClassLoader);
      AppMethodBeat.o(57363);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      for (;;)
      {
        paramClassLoader = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.e
 * JD-Core Version:    0.7.0.1
 */