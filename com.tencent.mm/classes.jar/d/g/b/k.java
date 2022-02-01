package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e;
import d.x;
import java.util.Arrays;

public class k
{
  public static String E(String paramString, Object paramObject)
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
  
  public static void aVY(String paramString)
  {
    AppMethodBeat.i(128975);
    paramString = (x)o(new x("lateinit property " + paramString + " has not been initialized"));
    AppMethodBeat.o(128975);
    throw paramString;
  }
  
  static <T extends Throwable> T b(T paramT, String paramString)
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
  
  public static void fOy()
  {
    AppMethodBeat.i(128974);
    e locale = (e)o(new e());
    AppMethodBeat.o(128974);
    throw locale;
  }
  
  public static void g(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128976);
    if (paramObject == null)
    {
      paramObject = (IllegalStateException)o(new IllegalStateException(paramString + " must not be null"));
      AppMethodBeat.o(128976);
      throw paramObject;
    }
    AppMethodBeat.o(128976);
  }
  
  public static boolean g(Object paramObject1, Object paramObject2)
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
  
  public static void h(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128977);
    if (paramObject == null)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      paramObject = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      paramObject = (IllegalArgumentException)o(new IllegalArgumentException("Parameter specified as non-null is null: method " + paramObject + "." + (String)localObject + ", parameter " + paramString));
      AppMethodBeat.o(128977);
      throw paramObject;
    }
    AppMethodBeat.o(128977);
  }
  
  private static <T extends Throwable> T o(T paramT)
  {
    AppMethodBeat.i(128980);
    paramT = b(paramT, k.class.getName());
    AppMethodBeat.o(128980);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.k
 * JD-Core Version:    0.7.0.1
 */