package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import org.apache.commons.b.a.b;

public final class a
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final short[] Sgj;
  public static final Object[] UeK = new Object[0];
  public static final Class[] UeL = new Class[0];
  public static final Long[] UeM;
  public static final Integer[] UeN;
  public static final Short[] UeO;
  public static final Byte[] UeP;
  public static final Double[] UeQ;
  public static final Float[] UeR;
  public static final Boolean[] UeS = new Boolean[0];
  public static final char[] UeT = new char[0];
  public static final Character[] UeU = new Character[0];
  public static final int[] bYn;
  public static final long[] cbp;
  public static final float[] cbq;
  public static final double[] cbr;
  public static final boolean[] cbs;
  
  static
  {
    EMPTY_STRING_ARRAY = new String[0];
    cbp = new long[0];
    UeM = new Long[0];
    bYn = new int[0];
    UeN = new Integer[0];
    Sgj = new short[0];
    UeO = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    UeP = new Byte[0];
    cbr = new double[0];
    UeQ = new Double[0];
    cbq = new float[0];
    UeR = new Float[0];
    cbs = new boolean[0];
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
    AppMethodBeat.i(193641);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(193641);
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
      AppMethodBeat.o(193641);
      return paramArrayOfObject;
    }
    localObject = (Object[])Array.newInstance((Class)localObject, paramInt);
    System.arraycopy(paramArrayOfObject, 1, localObject, 0, paramInt);
    AppMethodBeat.o(193641);
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
    paramObject = new org.apache.commons.b.a.a(paramObject, b.UgV).gB(paramObject).toString();
    AppMethodBeat.o(40693);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */