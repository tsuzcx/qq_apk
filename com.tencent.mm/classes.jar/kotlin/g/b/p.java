package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.e;
import kotlin.w;

public class p
{
  public static String I(String paramString, Object paramObject)
  {
    AppMethodBeat.i(128973);
    paramString = paramString + paramObject;
    AppMethodBeat.o(128973);
    return paramString;
  }
  
  public static boolean a(Float paramFloat)
  {
    AppMethodBeat.i(128979);
    if ((paramFloat != null) && (paramFloat.floatValue() == 0.0F))
    {
      AppMethodBeat.o(128979);
      return true;
    }
    AppMethodBeat.o(128979);
    return false;
  }
  
  public static void btv(String paramString)
  {
    AppMethodBeat.i(128975);
    paramString = (w)r(new w("lateinit property " + paramString + " has not been initialized"));
    AppMethodBeat.o(128975);
    throw paramString;
  }
  
  static <T extends Throwable> T c(T paramT, String paramString)
  {
    AppMethodBeat.i(128981);
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int k = arrayOfStackTraceElement.length;
    int j = -1;
    int i = 0;
    while (i < k)
    {
      if (paramString.equals(arrayOfStackTraceElement[i].getClassName())) {
        j = i;
      }
      i += 1;
    }
    paramT.setStackTrace((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, j + 1, k));
    AppMethodBeat.o(128981);
    return paramT;
  }
  
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public static void g(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128976);
    if (paramObject == null)
    {
      paramObject = (IllegalStateException)r(new IllegalStateException(paramString + " must not be null"));
      AppMethodBeat.o(128976);
      throw paramObject;
    }
    AppMethodBeat.o(128976);
  }
  
  public static void h(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128977);
    if (paramObject == null)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      paramObject = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      paramObject = (IllegalArgumentException)r(new IllegalArgumentException("Parameter specified as non-null is null: method " + paramObject + "." + (String)localObject + ", parameter " + paramString));
      AppMethodBeat.o(128977);
      throw paramObject;
    }
    AppMethodBeat.o(128977);
  }
  
  public static void hyc()
  {
    AppMethodBeat.i(128974);
    e locale = (e)r(new e());
    AppMethodBeat.o(128974);
    throw locale;
  }
  
  public static void hyd()
  {
    AppMethodBeat.i(206191);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    AppMethodBeat.o(206191);
    throw localUnsupportedOperationException;
  }
  
  public static boolean j(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(128978);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(128978);
        return true;
      }
      AppMethodBeat.o(128978);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(128978);
    return bool;
  }
  
  private static <T extends Throwable> T r(T paramT)
  {
    AppMethodBeat.i(128980);
    paramT = c(paramT, p.class.getName());
    AppMethodBeat.o(128980);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.p
 * JD-Core Version:    0.7.0.1
 */