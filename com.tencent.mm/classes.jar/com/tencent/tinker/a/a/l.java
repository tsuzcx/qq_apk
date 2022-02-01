package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.b;

public final class l
{
  public static int a(a parama, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    while (i >= 0)
    {
      j = j >>> 8 | (parama.readByte() & 0xFF) << 24;
      i -= 1;
    }
    return j >> (3 - paramInt) * 8;
  }
  
  public static int a(a parama, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    int k = 0;
    int j = paramInt;
    if (!paramBoolean)
    {
      i = paramInt;
      j = k;
      while (i >= 0)
      {
        j = j >>> 8 | (parama.readByte() & 0xFF) << 24;
        i -= 1;
      }
      paramInt = j >>> (3 - paramInt) * 8;
      return paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (j < 0) {
        break;
      }
      i = i >>> 8 | (parama.readByte() & 0xFF) << 24;
      j -= 1;
    }
  }
  
  public static void a(b paramb, int paramInt, long paramLong)
  {
    int i = 65 - Long.numberOfLeadingZeros(paramLong >> 63 ^ paramLong) + 7 >> 3;
    paramb.writeByte(i - 1 << 5 | paramInt);
    paramInt = i;
    while (paramInt > 0)
    {
      paramb.writeByte((byte)(int)paramLong);
      paramLong >>= 8;
      paramInt -= 1;
    }
  }
  
  public static void b(b paramb, int paramInt, long paramLong)
  {
    int j = 64 - Long.numberOfLeadingZeros(paramLong);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    i = i + 7 >> 3;
    paramb.writeByte(i - 1 << 5 | paramInt);
    paramInt = i;
    while (paramInt > 0)
    {
      paramb.writeByte((byte)(int)paramLong);
      paramLong >>= 8;
      paramInt -= 1;
    }
  }
  
  public static void c(b paramb, int paramInt, long paramLong)
  {
    int j = 64 - Long.numberOfTrailingZeros(paramLong);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    i = i + 7 >> 3;
    paramLong >>= 64 - i * 8;
    paramb.writeByte(i - 1 << 5 | paramInt);
    paramInt = i;
    while (paramInt > 0)
    {
      paramb.writeByte((byte)(int)paramLong);
      paramLong >>= 8;
      paramInt -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.l
 * JD-Core Version:    0.7.0.1
 */