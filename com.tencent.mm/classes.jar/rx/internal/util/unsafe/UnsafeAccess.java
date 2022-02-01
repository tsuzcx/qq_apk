package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import sun.misc.Unsafe;

public final class UnsafeAccess
{
  private static final boolean DISABLED_BY_USER;
  public static final Unsafe UNSAFE;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 11
    //   4: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 19
    //   9: invokestatic 25	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   12: ifnull +39 -> 51
    //   15: iload_0
    //   16: putstatic 27	rx/internal/util/unsafe/UnsafeAccess:DISABLED_BY_USER	Z
    //   19: ldc 29
    //   21: ldc 31
    //   23: invokevirtual 37	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   26: astore_1
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 43	java/lang/reflect/Field:setAccessible	(Z)V
    //   32: aload_1
    //   33: aconst_null
    //   34: invokevirtual 47	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 29	sun/misc/Unsafe
    //   40: astore_1
    //   41: aload_1
    //   42: putstatic 49	rx/internal/util/unsafe/UnsafeAccess:UNSAFE	Lsun/misc/Unsafe;
    //   45: ldc 11
    //   47: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: iconst_0
    //   52: istore_0
    //   53: goto -38 -> 15
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -18 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	52	0	bool	boolean
    //   26	16	1	localObject1	Object
    //   56	1	1	localObject2	Object
    //   58	1	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   19	41	56	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.unsafe.UnsafeAccess
 * JD-Core Version:    0.7.0.1
 */