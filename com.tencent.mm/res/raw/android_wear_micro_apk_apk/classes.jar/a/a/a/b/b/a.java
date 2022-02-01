package a.a.a.b.b;

import com.tencent.mm.d.b;
import java.io.UnsupportedEncodingException;

public final class a
{
  private final byte[] buffer;
  private final int limit;
  private int position;
  
  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = (paramInt2 + 0);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    int i;
    do
    {
      return;
      if (this.limit - this.position >= paramInt)
      {
        System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
        this.position += paramInt;
        return;
      }
      i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      paramInt -= i;
      this.position = this.limit;
    } while (paramInt > this.limit);
    System.arraycopy(paramArrayOfByte, i + 0, this.buffer, 0, paramInt);
    this.position = paramInt;
  }
  
  private void ar(int paramInt1, int paramInt2)
  {
    cL(a.a.a.b.a.ao(paramInt1, paramInt2));
  }
  
  public static int b(int paramInt, b paramb)
  {
    if (paramb == null) {
      return 0;
    }
    return cK(paramInt) + cM(paramb.size()) + paramb.size();
  }
  
  private void b(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public static int cK(int paramInt)
  {
    return cM(a.a.a.b.a.ao(paramInt, 0));
  }
  
  private void cL(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        b((byte)paramInt);
        return;
      }
      b((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public static int cM(int paramInt)
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
  
  public static int e(int paramInt, String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramInt = cK(paramInt);
      int i = cM(paramString.length);
      int j = paramString.length;
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("UTF-8 not supported.");
    }
  }
  
  public static int f(int paramInt, long paramLong)
  {
    int i = cK(paramInt);
    if ((0xFFFFFF80 & paramLong) == 0L) {
      paramInt = 1;
    }
    for (;;)
    {
      return paramInt + i;
      if ((0xFFFFC000 & paramLong) == 0L) {
        paramInt = 2;
      } else if ((0xFFE00000 & paramLong) == 0L) {
        paramInt = 3;
      } else if ((0xF0000000 & paramLong) == 0L) {
        paramInt = 4;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 5;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 6;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 7;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 8;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 9;
      } else {
        paramInt = 10;
      }
    }
  }
  
  private void o(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        b((byte)(int)paramLong);
        return;
      }
      b((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public static a r(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void s(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void a(int paramInt, double paramDouble)
  {
    ar(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    b((byte)((int)l & 0xFF));
    b((byte)((int)(l >> 8) & 0xFF));
    b((byte)((int)(l >> 16) & 0xFF));
    b((byte)((int)(l >> 24) & 0xFF));
    b((byte)((int)(l >> 32) & 0xFF));
    b((byte)((int)(l >> 40) & 0xFF));
    b((byte)((int)(l >> 48) & 0xFF));
    b((byte)((int)(l >> 56) & 0xFF));
  }
  
  public final void a(int paramInt, b paramb)
  {
    if (paramb == null) {
      return;
    }
    ar(paramInt, 2);
    paramb = paramb.toByteArray();
    cL(paramb.length);
    s(paramb);
  }
  
  public final void ap(int paramInt1, int paramInt2)
  {
    ar(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      cL(paramInt2);
      return;
    }
    o(paramInt2);
  }
  
  public final void aq(int paramInt1, int paramInt2)
  {
    ar(paramInt1, 2);
    cL(paramInt2);
  }
  
  public final void d(int paramInt, float paramFloat)
  {
    ar(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    b((byte)(paramInt & 0xFF));
    b((byte)(paramInt >> 8 & 0xFF));
    b((byte)(paramInt >> 16 & 0xFF));
    b((byte)(paramInt >> 24 & 0xFF));
  }
  
  public final void d(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    ar(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    cL(paramString.length);
    s(paramString);
  }
  
  public final void e(int paramInt, long paramLong)
  {
    ar(paramInt, 0);
    o(paramLong);
  }
  
  public final void g(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    ar(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    b((byte)paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */