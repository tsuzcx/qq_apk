package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import org.apache.commons.b.a.b;

public final class a
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final short[] MAf;
  public static final Object[] OpM = new Object[0];
  public static final Class[] OpN = new Class[0];
  public static final Long[] OpO;
  public static final Integer[] OpP;
  public static final Short[] OpQ;
  public static final Byte[] OpR;
  public static final Double[] OpS;
  public static final Float[] OpT;
  public static final Boolean[] OpU = new Boolean[0];
  public static final char[] OpV = new char[0];
  public static final Character[] OpW = new Character[0];
  public static final int[] bQP;
  public static final long[] bQQ;
  public static final float[] bQR;
  public static final double[] bQS;
  public static final boolean[] bQT;
  
  static
  {
    EMPTY_STRING_ARRAY = new String[0];
    bQQ = new long[0];
    OpO = new Long[0];
    bQP = new int[0];
    OpP = new Integer[0];
    MAf = new short[0];
    OpQ = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    OpR = new Byte[0];
    bQS = new double[0];
    OpS = new Double[0];
    bQR = new float[0];
    OpT = new Float[0];
    bQT = new boolean[0];
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = false;
    int i;
    if (paramArrayOfInt != null)
    {
      i = 0;
      if (i < paramArrayOfInt.length) {
        if (paramInt != paramArrayOfInt[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        bool = true;
      }
      return bool;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(40694);
    int i;
    if (paramArrayOfObject != null) {
      if (paramObject == null)
      {
        i = 0;
        if (i >= paramArrayOfObject.length) {
          break label87;
        }
        if (paramArrayOfObject[i] != null) {}
      }
    }
    for (;;)
    {
      if (i == -1) {
        break label92;
      }
      AppMethodBeat.o(40694);
      return true;
      i += 1;
      break;
      if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject))
      {
        int j = 0;
        for (;;)
        {
          if (j >= paramArrayOfObject.length) {
            break label87;
          }
          i = j;
          if (paramObject.equals(paramArrayOfObject[j])) {
            break;
          }
          j += 1;
        }
      }
      label87:
      i = -1;
    }
    label92:
    AppMethodBeat.o(40694);
    return false;
  }
  
  public static Object[] g(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(193961);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(193961);
      return null;
    }
    int i = paramInt;
    if (paramInt > paramArrayOfObject.length) {
      i = paramArrayOfObject.length;
    }
    paramInt = i - 1;
    Object localObject = paramArrayOfObject.getClass().getComponentType();
    if (paramInt <= 0)
    {
      paramArrayOfObject = (Object[])Array.newInstance((Class)localObject, 0);
      AppMethodBeat.o(193961);
      return paramArrayOfObject;
    }
    localObject = (Object[])Array.newInstance((Class)localObject, paramInt);
    System.arraycopy(paramArrayOfObject, 1, localObject, 0, paramInt);
    AppMethodBeat.o(193961);
    return localObject;
  }
  
  public static String toString(Object paramObject)
  {
    AppMethodBeat.i(40692);
    paramObject = toString(paramObject, "{}");
    AppMethodBeat.o(40692);
    return paramObject;
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    AppMethodBeat.i(40693);
    if (paramObject == null)
    {
      AppMethodBeat.o(40693);
      return paramString;
    }
    paramObject = new org.apache.commons.b.a.a(paramObject, b.OrX).gw(paramObject).toString();
    AppMethodBeat.o(40693);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */