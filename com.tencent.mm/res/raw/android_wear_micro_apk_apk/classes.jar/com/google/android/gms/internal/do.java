package com.google.android.gms.internal;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class do
{
  private final ByteBuffer Rq;
  
  private do(ByteBuffer paramByteBuffer)
  {
    this.Rq = paramByteBuffer;
    this.Rq.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private do(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label444;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label444:
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void a(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(a(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    b(paramCharSequence, paramByteBuffer);
  }
  
  public static int ab(int paramInt1, int paramInt2)
  {
    int i = bw(paramInt1);
    if (paramInt2 >= 0) {}
    for (paramInt1 = by(paramInt2);; paramInt1 = 10) {
      return paramInt1 + i;
    }
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return bw(paramInt) + c(paramLong);
  }
  
  public static int b(int paramInt, dw paramdw)
  {
    paramInt = bw(paramInt);
    int i = paramdw.kj();
    return paramInt + (i + by(i));
  }
  
  public static do b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new do(paramArrayOfByte, 0, paramInt2);
  }
  
  private static void b(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static int bw(int paramInt)
  {
    return by(dz.ad(paramInt, 0));
  }
  
  public static int by(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int bz(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int c(int paramInt, String paramString)
  {
    return bw(paramInt) + r(paramString);
  }
  
  public static int c(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static do c(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void d(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        bv((int)paramLong);
        return;
      }
      bv((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static int i(CharSequence paramCharSequence)
  {
    int k = 0;
    int n = paramCharSequence.length();
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      if (j < n)
      {
        int m = paramCharSequence.charAt(j);
        if (m < 2048)
        {
          i += (127 - m >>> 31);
          j += 1;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (j < i2)
          {
            int i3 = paramCharSequence.charAt(j);
            if (i3 < 2048)
            {
              k += (127 - i3 >>> 31);
              m = j;
            }
            for (;;)
            {
              j = m + 1;
              break;
              int i1 = k + 2;
              k = i1;
              m = j;
              if (55296 <= i3)
              {
                k = i1;
                m = j;
                if (i3 <= 57343)
                {
                  if (Character.codePointAt(paramCharSequence, j) < 65536) {
                    throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + j);
                  }
                  m = j + 1;
                  k = i1;
                }
              }
            }
          }
          i = k + i;
        }
      }
      else
      {
        for (;;)
        {
          if (i < n)
          {
            long l = i;
            throw new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + (l + 4294967296L));
          }
          return i;
        }
        i = n;
      }
    }
  }
  
  public static int r(String paramString)
  {
    int i = i(paramString);
    return i + by(i);
  }
  
  public final void a(int paramInt, long paramLong)
  {
    ac(paramInt, 0);
    d(paramLong);
  }
  
  public final void a(int paramInt, dw paramdw)
  {
    ac(paramInt, 2);
    b(paramdw);
  }
  
  public final void aa(int paramInt1, int paramInt2)
  {
    ac(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      bx(paramInt2);
      return;
    }
    d(paramInt2);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    bx(dz.ad(paramInt1, paramInt2));
  }
  
  public final void b(int paramInt, float paramFloat)
  {
    ac(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    if (this.Rq.remaining() < 4) {
      throw new dp(this.Rq.position(), this.Rq.limit());
    }
    this.Rq.putInt(paramInt);
  }
  
  public final void b(int paramInt, String paramString)
  {
    ac(paramInt, 2);
    int i;
    try
    {
      paramInt = by(paramString.length());
      if (paramInt != by(paramString.length() * 3)) {
        break label156;
      }
      i = this.Rq.position();
      if (this.Rq.remaining() < paramInt) {
        throw new dp(paramInt + i, this.Rq.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      dp localdp = new dp(this.Rq.position(), this.Rq.limit());
      localdp.initCause(paramString);
      throw localdp;
    }
    this.Rq.position(i + paramInt);
    a(paramString, this.Rq);
    int j = this.Rq.position();
    this.Rq.position(i);
    bx(j - i - paramInt);
    this.Rq.position(j);
    return;
    label156:
    bx(i(paramString));
    a(paramString, this.Rq);
  }
  
  public final void b(dw paramdw)
  {
    bx(paramdw.ki());
    paramdw.a(this);
  }
  
  public final void bv(int paramInt)
  {
    byte b = (byte)paramInt;
    if (!this.Rq.hasRemaining()) {
      throw new dp(this.Rq.position(), this.Rq.limit());
    }
    this.Rq.put(b);
  }
  
  public final void bx(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        bv(paramInt);
        return;
      }
      bv(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (this.Rq.remaining() >= i)
    {
      this.Rq.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new dp(this.Rq.position(), this.Rq.limit());
  }
  
  public final void e(long paramLong)
  {
    if (this.Rq.remaining() < 8) {
      throw new dp(this.Rq.position(), this.Rq.limit());
    }
    this.Rq.putLong(paramLong);
  }
  
  public final void jY()
  {
    if (this.Rq.remaining() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.do
 * JD-Core Version:    0.7.0.1
 */