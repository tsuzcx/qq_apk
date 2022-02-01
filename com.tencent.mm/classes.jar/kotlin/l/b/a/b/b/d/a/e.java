package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class e
{
  public static final Class<?> a(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(57363);
    p.k(paramClassLoader, "$this$tryLoadClass");
    p.k(paramString, "fqName");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.e
 * JD-Core Version:    0.7.0.1
 */