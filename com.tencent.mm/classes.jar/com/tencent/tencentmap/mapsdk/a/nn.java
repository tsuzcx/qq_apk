package com.tencent.tencentmap.mapsdk.a;

import java.nio.ByteBuffer;

public final class nn
{
  private static final byte[] a;
  private static final byte[] b;
  
  static
  {
    byte[] arrayOfByte1 = new byte[16];
    byte[] tmp6_5 = arrayOfByte1;
    tmp6_5[0] = 48;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    byte[] arrayOfByte2 = new byte[256];
    byte[] arrayOfByte3 = new byte[256];
    int i = 0;
    while (i < 256)
    {
      arrayOfByte2[i] = arrayOfByte1[(i >>> 4)];
      arrayOfByte3[i] = arrayOfByte1[(i & 0xF)];
      i += 1;
    }
    a = arrayOfByte2;
    b = arrayOfByte3;
  }
  
  public static int a(int paramInt)
  {
    return paramInt + 629;
  }
  
  public static <T extends Comparable<T>> int a(T paramT1, T paramT2)
  {
    return paramT1.compareTo(paramT2);
  }
  
  public static int a(Object paramObject)
  {
    for (;;)
    {
      if (paramObject == null) {
        return 629;
      }
      if (!paramObject.getClass().isArray()) {
        break;
      }
      if ((paramObject instanceof long[])) {
        return a((long[])paramObject);
      }
      if ((paramObject instanceof int[])) {
        return a((int[])paramObject);
      }
      if ((paramObject instanceof short[])) {
        return a((short[])paramObject);
      }
      if ((paramObject instanceof char[])) {
        return a((char[])paramObject);
      }
      if ((paramObject instanceof byte[])) {
        return a((byte[])paramObject);
      }
      if ((paramObject instanceof double[])) {
        return a((double[])paramObject);
      }
      if ((paramObject instanceof float[])) {
        return a((float[])paramObject);
      }
      if ((paramObject instanceof boolean[])) {
        return a((boolean[])paramObject);
      }
      if ((paramObject instanceof nm[])) {
        return a((nm[])paramObject);
      }
      paramObject = (Object[])paramObject;
    }
    if ((paramObject instanceof nm)) {
      return paramObject.hashCode();
    }
    return paramObject.hashCode() + 629;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int k;
    if (paramArrayOfByte == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      i = i * 37 + paramArrayOfByte[j];
      j += 1;
    }
  }
  
  public static int a(char[] paramArrayOfChar)
  {
    int k;
    if (paramArrayOfChar == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfChar.length) {
        break;
      }
      i = i * 37 + paramArrayOfChar[j];
      j += 1;
    }
  }
  
  public static int a(double[] paramArrayOfDouble)
  {
    int k;
    if (paramArrayOfDouble == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfDouble.length) {
        break;
      }
      i = i * 37 + (int)(Double.doubleToLongBits(paramArrayOfDouble[j]) ^ Double.doubleToLongBits(paramArrayOfDouble[j]) >> 32);
      j += 1;
    }
  }
  
  public static int a(float[] paramArrayOfFloat)
  {
    int k;
    if (paramArrayOfFloat == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfFloat.length) {
        break;
      }
      i = i * 37 + Float.floatToIntBits(paramArrayOfFloat[j]);
      j += 1;
    }
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    int k;
    if (paramArrayOfInt == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfInt.length) {
        break;
      }
      i = i * 37 + paramArrayOfInt[j];
      j += 1;
    }
  }
  
  public static int a(long[] paramArrayOfLong)
  {
    int k;
    if (paramArrayOfLong == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfLong.length) {
        break;
      }
      i = i * 37 + (int)(paramArrayOfLong[j] ^ paramArrayOfLong[j] >> 32);
      j += 1;
    }
  }
  
  public static int a(nm[] paramArrayOfnm)
  {
    int k;
    if (paramArrayOfnm == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfnm.length) {
        break;
      }
      i = i * 37 + paramArrayOfnm[j].hashCode();
      j += 1;
    }
  }
  
  public static int a(short[] paramArrayOfShort)
  {
    int k;
    if (paramArrayOfShort == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfShort.length) {
        break;
      }
      i = i * 37 + paramArrayOfShort[j];
      j += 1;
    }
  }
  
  public static int a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      k = 629;
    }
    int i;
    int j;
    do
    {
      return k;
      i = 17;
      j = 0;
      k = i;
    } while (j >= paramArrayOfBoolean.length);
    if (paramArrayOfBoolean[j] != 0) {}
    for (int k = 0;; k = 1)
    {
      i = k + i * 37;
      j += 1;
      break;
    }
  }
  
  public static boolean a(byte paramByte1, byte paramByte2)
  {
    return paramByte1 == paramByte2;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject1 == paramObject2;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(short paramShort1, short paramShort2)
  {
    return paramShort1 == paramShort2;
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 > paramInt2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nn
 * JD-Core Version:    0.7.0.1
 */