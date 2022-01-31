package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.a.b;

public final class a
{
  public static final short[] Bpi;
  public static final Object[] COH = new Object[0];
  public static final Class[] COI = new Class[0];
  public static final Long[] COJ;
  public static final Integer[] COK;
  public static final Short[] COL;
  public static final Byte[] COM;
  public static final Double[] CON;
  public static final Float[] COO;
  public static final Boolean[] COP = new Boolean[0];
  public static final char[] COQ = new char[0];
  public static final Character[] COR = new Character[0];
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int[] bgZ;
  public static final long[] bha = new long[0];
  public static final float[] bhb;
  public static final double[] bhc;
  public static final boolean[] bhd;
  
  static
  {
    COJ = new Long[0];
    bgZ = new int[0];
    COK = new Integer[0];
    Bpi = new short[0];
    COL = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    COM = new Byte[0];
    bhc = new double[0];
    CON = new Double[0];
    bhb = new float[0];
    COO = new Float[0];
    bhd = new boolean[0];
  }
  
  public static boolean b(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return ((paramArrayOfObject1 != null) || (paramArrayOfObject2 == null) || (paramArrayOfObject2.length <= 0)) && ((paramArrayOfObject2 != null) || (paramArrayOfObject1 == null) || (paramArrayOfObject1.length <= 0)) && ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length == paramArrayOfObject2.length));
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
    AppMethodBeat.i(116927);
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
      AppMethodBeat.o(116927);
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
    AppMethodBeat.o(116927);
    return false;
  }
  
  public static String toString(Object paramObject)
  {
    AppMethodBeat.i(142932);
    paramObject = toString(paramObject, "{}");
    AppMethodBeat.o(142932);
    return paramObject;
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    AppMethodBeat.i(142933);
    if (paramObject == null)
    {
      AppMethodBeat.o(142933);
      return paramString;
    }
    paramObject = new org.apache.commons.b.a.a(paramObject, b.CQR).ek(paramObject).toString();
    AppMethodBeat.o(142933);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */