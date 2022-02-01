package com.tencent.tinker.a.a.b;

public final class c
{
  public static int a(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 == paramByte2) {
      return 0;
    }
    if ((paramByte1 & 0xFF) < (paramByte2 & 0xFF)) {
      return -1;
    }
    return 1;
  }
  
  public static int a(short paramShort1, short paramShort2)
  {
    if (paramShort1 == paramShort2) {
      return 0;
    }
    if ((paramShort1 & 0xFFFF) < (0xFFFF & paramShort2)) {
      return -1;
    }
    return 1;
  }
  
  public static <T extends Comparable<T>> int a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    int m = paramArrayOfT1.length;
    int i = paramArrayOfT2.length;
    if (m < i)
    {
      i = -1;
      return i;
    }
    if (m > i) {
      return 1;
    }
    int j = 0;
    for (;;)
    {
      if (j >= m) {
        break label61;
      }
      int k = paramArrayOfT1[j].compareTo(paramArrayOfT2[j]);
      i = k;
      if (k != 0) {
        break;
      }
      j += 1;
    }
    label61:
    return 0;
  }
  
  public static int a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    int m = paramArrayOfShort1.length;
    int i = paramArrayOfShort2.length;
    if (m < i)
    {
      i = -1;
      return i;
    }
    if (m > i) {
      return 1;
    }
    int j = 0;
    for (;;)
    {
      if (j >= m) {
        break label59;
      }
      int k = a(paramArrayOfShort1[j], paramArrayOfShort2[j]);
      i = k;
      if (k != 0) {
        break;
      }
      j += 1;
    }
    label59:
    return 0;
  }
  
  public static int c(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramArrayOfInt1.length;
    int i = paramArrayOfInt2.length;
    if (m < i)
    {
      i = -1;
      return i;
    }
    if (m > i) {
      return 1;
    }
    int j = 0;
    for (;;)
    {
      if (j >= m) {
        break label59;
      }
      int k = nV(paramArrayOfInt1[j], paramArrayOfInt2[j]);
      i = k;
      if (k != 0) {
        break;
      }
      j += 1;
    }
    label59:
    return 0;
  }
  
  public static int nU(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return 0;
    }
    if ((paramInt1 & 0xFFFFFFFF) < (paramInt2 & 0xFFFFFFFF)) {
      return -1;
    }
    return 1;
  }
  
  public static int nV(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return 0;
    }
    if (paramInt1 < paramInt2) {
      return -1;
    }
    return 1;
  }
  
  public static int r(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = paramArrayOfByte1.length;
    int i = paramArrayOfByte2.length;
    if (m < i)
    {
      i = -1;
      return i;
    }
    if (m > i) {
      return 1;
    }
    int j = 0;
    for (;;)
    {
      if (j >= m) {
        break label59;
      }
      int k = a(paramArrayOfByte1[j], paramArrayOfByte2[j]);
      i = k;
      if (k != 0) {
        break;
      }
      j += 1;
    }
    label59:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */