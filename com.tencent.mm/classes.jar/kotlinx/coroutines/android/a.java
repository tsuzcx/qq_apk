package kotlinx.coroutines.android;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"getter", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"})
public final class a
{
  private static final Method CIJ;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(118246);
    for (;;)
    {
      try
      {
        localMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
        j.p(localMethod, "it");
        int i = j;
        if (Modifier.isPublic(localMethod.getModifiers()))
        {
          boolean bool = Modifier.isStatic(localMethod.getModifiers());
          i = j;
          if (bool) {
            i = 1;
          }
        }
        if (i == 0) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Method localMethod;
        Object localObject = null;
        continue;
      }
      CIJ = localMethod;
      AppMethodBeat.o(118246);
      return;
      localMethod = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.android.a
 * JD-Core Version:    0.7.0.1
 */