package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeAccess
{
  private static final boolean DISABLED_BY_USER;
  public static final Unsafe UNSAFE;
  
  static
  {
    boolean bool = true;
    AppMethodBeat.i(90130);
    if (System.getProperty("rx.unsafe-disable") != null) {}
    for (;;)
    {
      DISABLED_BY_USER = bool;
      try
      {
        Object localObject1 = Unsafe.class.getDeclaredField("theUnsafe");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (Unsafe)((Field)localObject1).get(null);
        UNSAFE = (Unsafe)localObject1;
        AppMethodBeat.o(90130);
        return;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  private UnsafeAccess()
  {
    AppMethodBeat.i(90124);
    IllegalStateException localIllegalStateException = new IllegalStateException("No instances!");
    AppMethodBeat.o(90124);
    throw localIllegalStateException;
  }
  
  public static long addressOf(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(90129);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      long l = UNSAFE.objectFieldOffset(paramClass);
      AppMethodBeat.o(90129);
      return l;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramString = new InternalError();
      paramString.initCause(paramClass);
      AppMethodBeat.o(90129);
      throw paramString;
    }
  }
  
  public static boolean compareAndSwapInt(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90128);
    boolean bool = UNSAFE.compareAndSwapInt(paramObject, paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(90128);
    return bool;
  }
  
  public static int getAndAddInt(Object paramObject, long paramLong, int paramInt)
  {
    AppMethodBeat.i(90126);
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, i + paramInt));
    AppMethodBeat.o(90126);
    return i;
  }
  
  public static int getAndIncrementInt(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(90125);
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, i + 1));
    AppMethodBeat.o(90125);
    return i;
  }
  
  public static int getAndSetInt(Object paramObject, long paramLong, int paramInt)
  {
    AppMethodBeat.i(90127);
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, paramInt));
    AppMethodBeat.o(90127);
    return i;
  }
  
  public static boolean isUnsafeAvailable()
  {
    return (UNSAFE != null) && (!DISABLED_BY_USER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.util.unsafe.UnsafeAccess
 * JD-Core Version:    0.7.0.1
 */