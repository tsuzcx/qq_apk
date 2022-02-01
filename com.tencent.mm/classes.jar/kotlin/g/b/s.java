package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.ag;
import kotlin.g;

public class s
{
  private static <T extends Throwable> T H(T paramT)
  {
    AppMethodBeat.i(128980);
    paramT = c(paramT, s.class.getName());
    AppMethodBeat.o(128980);
    return paramT;
  }
  
  public static String X(String paramString, Object paramObject)
  {
    AppMethodBeat.i(128973);
    paramString = paramString + paramObject;
    AppMethodBeat.o(128973);
    return paramString;
  }
  
  public static boolean a(Float paramFloat, float paramFloat1)
  {
    AppMethodBeat.i(191000);
    if ((paramFloat != null) && (paramFloat.floatValue() == paramFloat1))
    {
      AppMethodBeat.o(191000);
      return true;
    }
    AppMethodBeat.o(191000);
    return false;
  }
  
  public static void bIx(String paramString)
  {
    AppMethodBeat.i(128975);
    paramString = (ag)H(new ag("lateinit property " + paramString + " has not been initialized"));
    AppMethodBeat.o(128975);
    throw paramString;
  }
  
  private static String bIy(String paramString)
  {
    AppMethodBeat.i(190996);
    Object localObject = java.lang.Thread.currentThread().getStackTrace()[4];
    String str = ((StackTraceElement)localObject).getClassName();
    localObject = ((StackTraceElement)localObject).getMethodName();
    paramString = "Parameter specified as non-null is null: method " + str + "." + (String)localObject + ", parameter " + paramString;
    AppMethodBeat.o(190996);
    return paramString;
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
  
  public static void checkNotNull(Object paramObject)
  {
    AppMethodBeat.i(190977);
    if (paramObject == null)
    {
      paramObject = (NullPointerException)H(new NullPointerException());
      AppMethodBeat.o(190977);
      throw paramObject;
    }
    AppMethodBeat.o(190977);
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
  
  public static int compare(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static void klw()
  {
    AppMethodBeat.i(128974);
    g localg = (g)H(new g());
    AppMethodBeat.o(128974);
    throw localg;
  }
  
  private static void klx()
  {
    AppMethodBeat.i(191002);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    AppMethodBeat.o(191002);
    throw localUnsupportedOperationException;
  }
  
  public static void kly()
  {
    AppMethodBeat.i(191004);
    klx();
    AppMethodBeat.o(191004);
  }
  
  public static void klz()
  {
    AppMethodBeat.i(191008);
    klx();
    AppMethodBeat.o(191008);
  }
  
  public static boolean p(Object paramObject1, Object paramObject2)
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
  
  public static void r(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128976);
    if (paramObject == null)
    {
      paramObject = (IllegalStateException)H(new IllegalStateException(paramString + " must not be null"));
      AppMethodBeat.o(128976);
      throw paramObject;
    }
    AppMethodBeat.o(128976);
  }
  
  public static void s(Object paramObject, String paramString)
  {
    AppMethodBeat.i(190991);
    if (paramObject == null)
    {
      paramObject = (NullPointerException)H(new NullPointerException(paramString + " must not be null"));
      AppMethodBeat.o(190991);
      throw paramObject;
    }
    AppMethodBeat.o(190991);
  }
  
  public static void t(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128977);
    if (paramObject == null)
    {
      paramObject = (IllegalArgumentException)H(new IllegalArgumentException(bIy(paramString)));
      AppMethodBeat.o(128977);
      throw paramObject;
    }
    AppMethodBeat.o(128977);
  }
  
  public static void u(Object paramObject, String paramString)
  {
    AppMethodBeat.i(190993);
    if (paramObject == null)
    {
      paramObject = (NullPointerException)H(new NullPointerException(bIy(paramString)));
      AppMethodBeat.o(190993);
      throw paramObject;
    }
    AppMethodBeat.o(190993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.g.b.s
 * JD-Core Version:    0.7.0.1
 */