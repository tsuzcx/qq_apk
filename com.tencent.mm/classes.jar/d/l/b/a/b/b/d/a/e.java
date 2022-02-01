package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class e
{
  public static final Class<?> a(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(57363);
    k.h(paramClassLoader, "$this$tryLoadClass");
    k.h(paramString, "fqName");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.e
 * JD-Core Version:    0.7.0.1
 */