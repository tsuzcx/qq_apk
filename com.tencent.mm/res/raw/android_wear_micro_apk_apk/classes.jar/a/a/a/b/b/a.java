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
  
  private void ao(int paramInt1, int paramInt2)
  {
    cq(a.a.a.b.a.al(paramInt1, paramInt2));
  }
  
  private void co(int paramInt)
  {
    int i = (byte)paramInt;
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  public static int cp(int paramInt)
  {
    return cr(a.a.a.b.a.al(paramInt, 0));
  }
  
  private void cq(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        co(paramInt);
        return;
      }
      co(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static int cr(int paramInt)
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
      paramInt = cp(paramInt);
      int i = cr(paramString.length);
      int j = paramString.length;
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("UTF-8 not supported.");
    }
  }
  
  private void l(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        co((int)paramLong);
        return;
      }
      co((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public static a r(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void s(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    int j;
    int i;
    do
    {
      do
      {
        return;
        j = paramArrayOfByte.length;
      } while (paramArrayOfByte == null);
      if (this.limit - this.position >= j)
      {
        System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, j);
        this.position = (j + this.position);
        return;
      }
      i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      j -= i;
      this.position = this.limit;
    } while (j > this.limit);
    System.arraycopy(paramArrayOfByte, i + 0, this.buffer, 0, j);
    this.position = j;
  }
  
  public final void a(int paramInt, double paramDouble)
  {
    ao(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    co((int)l & 0xFF);
    co((int)(l >> 8) & 0xFF);
    co((int)(l >> 16) & 0xFF);
    co((int)(l >> 24) & 0xFF);
    co((int)(l >> 32) & 0xFF);
    co((int)(l >> 40) & 0xFF);
    co((int)(l >> 48) & 0xFF);
    co((int)(l >> 56) & 0xFF);
  }
  
  public final void am(int paramInt1, int paramInt2)
  {
    ao(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      cq(paramInt2);
      return;
    }
    l(paramInt2);
  }
  
  public final void an(int paramInt1, int paramInt2)
  {
    ao(paramInt1, 2);
    cq(paramInt2);
  }
  
  public final void b(int paramInt, b paramb)
  {
    if (paramb == null) {
      return;
    }
    ao(paramInt, 2);
    paramb = paramb.toByteArray();
    cq(paramb.length);
    s(paramb);
  }
  
  public final void c(int paramInt, float paramFloat)
  {
    ao(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    co(paramInt & 0xFF);
    co(paramInt >> 8 & 0xFF);
    co(paramInt >> 16 & 0xFF);
    co(paramInt >> 24 & 0xFF);
  }
  
  public final void d(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    ao(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    cq(paramString.length);
    s(paramString);
  }
  
  public final void f(int paramInt, long paramLong)
  {
    ao(paramInt, 0);
    l(paramLong);
  }
  
  public final void f(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    ao(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    co(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */