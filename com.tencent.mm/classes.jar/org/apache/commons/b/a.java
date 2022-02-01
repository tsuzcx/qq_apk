package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.a.b;

public final class a
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final short[] IBd;
  public static final Long[] KkA;
  public static final Integer[] KkB;
  public static final Short[] KkC;
  public static final Byte[] KkD;
  public static final Double[] KkE;
  public static final Float[] KkF;
  public static final Boolean[] KkG = new Boolean[0];
  public static final char[] KkH = new char[0];
  public static final Character[] KkI = new Character[0];
  public static final Object[] Kky = new Object[0];
  public static final Class[] Kkz = new Class[0];
  public static final int[] bIT;
  public static final long[] bIU;
  public static final float[] bIV;
  public static final double[] bIW;
  public static final boolean[] bIX;
  
  static
  {
    EMPTY_STRING_ARRAY = new String[0];
    bIU = new long[0];
    KkA = new Long[0];
    bIT = new int[0];
    KkB = new Integer[0];
    IBd = new short[0];
    KkC = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    KkD = new Byte[0];
    bIW = new double[0];
    KkE = new Double[0];
    bIV = new float[0];
    KkF = new Float[0];
    bIX = new boolean[0];
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
    paramObject = new org.apache.commons.b.a.a(paramObject, b.KmJ).fP(paramObject).toString();
    AppMethodBeat.o(40693);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */