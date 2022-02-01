package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import org.apache.commons.b.a.b;

public final class a
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final short[] ZIU;
  public static final Object[] abHY = new Object[0];
  public static final Class[] abHZ = new Class[0];
  public static final Long[] abIa;
  public static final Integer[] abIb;
  public static final Short[] abIc;
  public static final Byte[] abId;
  public static final Double[] abIe;
  public static final Float[] abIf;
  public static final Boolean[] abIg = new Boolean[0];
  public static final char[] abIh = new char[0];
  public static final Character[] abIi = new Character[0];
  public static final int[] bZR;
  public static final long[] ccS;
  public static final float[] ccT;
  public static final double[] ccU;
  public static final boolean[] ccV;
  
  static
  {
    EMPTY_STRING_ARRAY = new String[0];
    ccS = new long[0];
    abIa = new Long[0];
    bZR = new int[0];
    abIb = new Integer[0];
    ZIU = new short[0];
    abIc = new Short[0];
    EMPTY_BYTE_ARRAY = new byte[0];
    abId = new Byte[0];
    ccU = new double[0];
    abIe = new Double[0];
    ccT = new float[0];
    abIf = new Float[0];
    ccV = new boolean[0];
  }
  
  public static Object[] a(Object[] paramArrayOfObject, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(218490);
    Object localObject;
    if (paramArrayOfObject != null) {
      localObject = paramArrayOfObject.getClass().getComponentType();
    }
    while (paramArrayOfObject == null) {
      if (paramInt != 0)
      {
        paramArrayOfObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Length: 0");
        AppMethodBeat.o(218490);
        throw paramArrayOfObject;
        if (paramObject != null)
        {
          localObject = paramObject.getClass();
        }
        else
        {
          AppMethodBeat.o(218490);
          return new Object[] { null };
        }
      }
      else
      {
        paramArrayOfObject = Array.newInstance((Class)localObject, 1);
        Array.set(paramArrayOfObject, 0, paramObject);
        paramObject = paramArrayOfObject;
      }
    }
    for (;;)
    {
      paramArrayOfObject = (Object[])paramObject;
      AppMethodBeat.o(218490);
      return paramArrayOfObject;
      int i = Array.getLength(paramArrayOfObject);
      if ((paramInt > i) || (paramInt < 0))
      {
        paramArrayOfObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
        AppMethodBeat.o(218490);
        throw paramArrayOfObject;
      }
      localObject = Array.newInstance((Class)localObject, i + 1);
      System.arraycopy(paramArrayOfObject, 0, localObject, 0, paramInt);
      Array.set(localObject, paramInt, paramObject);
      paramObject = localObject;
      if (paramInt < i)
      {
        System.arraycopy(paramArrayOfObject, paramInt, localObject, paramInt + 1, i - paramInt);
        paramObject = localObject;
      }
    }
  }
  
  public static Object[] b(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(218488);
    Object localObject;
    if (paramArrayOfObject != null)
    {
      localObject = paramArrayOfObject.getClass();
      if (paramArrayOfObject == null) {
        break label77;
      }
      int i = Array.getLength(paramArrayOfObject);
      localObject = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i + 1);
      System.arraycopy(paramArrayOfObject, 0, localObject, 0, i);
    }
    label77:
    for (paramArrayOfObject = (Object[])localObject;; paramArrayOfObject = Array.newInstance((Class)localObject, 1))
    {
      paramArrayOfObject = (Object[])paramArrayOfObject;
      paramArrayOfObject[(paramArrayOfObject.length - 1)] = paramObject;
      AppMethodBeat.o(218488);
      return paramArrayOfObject;
      localObject = paramObject.getClass();
      break;
    }
  }
  
  public static String cG(Object paramObject)
  {
    AppMethodBeat.i(40692);
    paramObject = m(paramObject, "{}");
    AppMethodBeat.o(40692);
    return paramObject;
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
  
  public static Object[] h(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(218486);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(218486);
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
      AppMethodBeat.o(218486);
      return paramArrayOfObject;
    }
    localObject = (Object[])Array.newInstance((Class)localObject, paramInt);
    System.arraycopy(paramArrayOfObject, 1, localObject, 0, paramInt);
    AppMethodBeat.o(218486);
    return localObject;
  }
  
  public static String m(Object paramObject, String paramString)
  {
    AppMethodBeat.i(40693);
    if (paramObject == null)
    {
      AppMethodBeat.o(40693);
      return paramString;
    }
    paramObject = new org.apache.commons.b.a.a(paramObject, b.abKk).gT(paramObject).toString();
    AppMethodBeat.o(40693);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */