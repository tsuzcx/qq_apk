package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class e
{
  private static final int KrG;
  private static final boolean KrH;
  
  static
  {
    AppMethodBeat.i(90204);
    int i = fNO();
    KrG = i;
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      KrH = bool;
      AppMethodBeat.o(90204);
      return;
    }
  }
  
  public static int fNN()
  {
    return KrG;
  }
  
  private static int fNO()
  {
    AppMethodBeat.i(90203);
    try
    {
      if (System.getSecurityManager() == null) {}
      for (ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();; localClassLoader = (ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {}))
      {
        int i = ((Integer)Class.forName("android.os.Build$VERSION", true, localClassLoader).getField("SDK_INT").get(null)).intValue();
        AppMethodBeat.o(90203);
        return i;
      }
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(90203);
    }
  }
  
  public static boolean isAndroid()
  {
    return KrH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.util.e
 * JD-Core Version:    0.7.0.1
 */