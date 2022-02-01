package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.a.b;

public final class a
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final short[] Knm;
  public static final Object[] LYh = new Object[0];
  public static final Class[] LYi = new Class[0];
  public static final Long[] LYj;
  public static final Integer[] LYk;
  public static final Short[] LYl;
  public static final Byte[] LYm;
  public static final Double[] LYn;
  public static final Float[] LYo;
  public static final Boolean[] LYp = new Boolean[0];
  public static final char[] LYq = new char[0];
  public static final Character[] LYr = new Character[0];
  public static final int[] bGB;
  public static final long[] bGC;
  public static final float[] bGD;
  public static final double[] bGE;
  public static final boolean[] bGF;
  
  static
  {
    EMPTY_STRING_ARRAY = new String[0];
    bGC = new long[0];
    LYj = new Long[0];
    bGB = new int[0];
    LYk = new Integer[0];
    Knm = new short[0];
    LYl = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    LYm = new Byte[0];
    bGE = new double[0];
    LYn = new Double[0];
    bGD = new float[0];
    LYo = new Float[0];
    bGF = new boolean[0];
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
    paramObject = new org.apache.commons.b.a.a(paramObject, b.Mas).fX(paramObject).toString();
    AppMethodBeat.o(40693);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */