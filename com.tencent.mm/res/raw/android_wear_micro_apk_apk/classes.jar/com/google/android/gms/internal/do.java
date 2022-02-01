package com.google.android.gms.internal;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class do
{
  private final ByteBuffer Tf;
  
  private do(ByteBuffer paramByteBuffer)
  {
    this.Tf = paramByteBuffer;
    this.Tf.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private do(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        i = k;
        j = paramInt;
        if (55296 <= n)
        {
          i = k;
          j = paramInt;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
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
  
  private void a(byte paramByte)
  {
    if (!this.Tf.hasRemaining()) {
      throw new dp(this.Tf.position(), this.Tf.limit());
    }
    this.Tf.put(paramByte);
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
  
  public static int ad(int paramInt1, int paramInt2)
  {
    int i = bQ(paramInt1);
    if (paramInt2 >= 0) {}
    for (paramInt1 = bS(paramInt2);; paramInt1 = 10) {
      return paramInt1 + i;
    }
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return bQ(paramInt) + e(paramLong);
  }
  
  public static int b(int paramInt, dw paramdw)
  {
    return bQ(paramInt) * 2 + paramdw.ks();
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
  
  public static int bQ(int paramInt)
  {
    return bS(dz.af(paramInt, 0));
  }
  
  public static int bS(int paramInt)
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
  
  public static int bT(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int c(int paramInt, dw paramdw)
  {
    paramInt = bQ(paramInt);
    int i = paramdw.ks();
    return paramInt + (i + bS(i));
  }
  
  public static int c(int paramInt, String paramString)
  {
    return bQ(paramInt) + r(paramString);
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
        a((byte)(int)paramLong);
        return;
      }
      a((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public static int e(long paramLong)
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
  
  private static int i(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int j = 0;
    while ((j < m) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      int k = i;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          i += (127 - k >>> 31);
          j += 1;
        }
        else
        {
          k = i + a(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m)
        {
          long l = k;
          throw new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + (l + 4294967296L));
        }
        return k;
        i = m;
      }
    }
  }
  
  public static int r(String paramString)
  {
    int i = i(paramString);
    return i + bS(i);
  }
  
  public final void a(int paramInt, long paramLong)
  {
    ae(paramInt, 0);
    d(paramLong);
  }
  
  public final void a(int paramInt, dw paramdw)
  {
    ae(paramInt, 2);
    b(paramdw);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    ae(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      bR(paramInt2);
      return;
    }
    d(paramInt2);
  }
  
  public final void ae(int paramInt1, int paramInt2)
  {
    bR(dz.af(paramInt1, paramInt2));
  }
  
  public final void b(int paramInt, String paramString)
  {
    ae(paramInt, 2);
    int i;
    try
    {
      paramInt = bS(paramString.length());
      if (paramInt != bS(paramString.length() * 3)) {
        break label156;
      }
      i = this.Tf.position();
      if (this.Tf.remaining() < paramInt) {
        throw new dp(paramInt + i, this.Tf.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      dp localdp = new dp(this.Tf.position(), this.Tf.limit());
      localdp.initCause(paramString);
      throw localdp;
    }
    this.Tf.position(i + paramInt);
    a(paramString, this.Tf);
    int j = this.Tf.position();
    this.Tf.position(i);
    bR(j - i - paramInt);
    this.Tf.position(j);
    return;
    label156:
    bR(i(paramString));
    a(paramString, this.Tf);
  }
  
  public final void b(dw paramdw)
  {
    bR(paramdw.kr());
    paramdw.a(this);
  }
  
  public final void bP(int paramInt)
  {
    a((byte)paramInt);
  }
  
  public final void bR(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        a((byte)paramInt);
        return;
      }
      a((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void c(int paramInt, float paramFloat)
  {
    ae(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    if (this.Tf.remaining() < 4) {
      throw new dp(this.Tf.position(), this.Tf.limit());
    }
    this.Tf.putInt(paramInt);
  }
  
  public final void d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (this.Tf.remaining() >= i)
    {
      this.Tf.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new dp(this.Tf.position(), this.Tf.limit());
  }
  
  public final void f(long paramLong)
  {
    if (this.Tf.remaining() < 8) {
      throw new dp(this.Tf.position(), this.Tf.limit());
    }
    this.Tf.putLong(paramLong);
  }
  
  public final void kh()
  {
    if (this.Tf.remaining() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.do
 * JD-Core Version:    0.7.0.1
 */