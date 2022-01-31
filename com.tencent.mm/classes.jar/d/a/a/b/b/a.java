package d.a.a.b.b;

import java.io.UnsupportedEncodingException;

public final class a
{
  private final byte[] buffer;
  private final int limit;
  private int position;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = (paramInt + 0);
  }
  
  public static int dQ(int paramInt)
  {
    return dS(d.a.a.b.a.aQ(paramInt, 0));
  }
  
  public static int dS(int paramInt)
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
      paramInt = dQ(paramInt);
      int i = dS(paramString.length);
      int j = paramString.length;
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("UTF-8 not supported.");
    }
  }
  
  public final void aP(int paramInt1, int paramInt2)
  {
    dR(d.a.a.b.a.aQ(paramInt1, paramInt2));
  }
  
  public final void ab(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        dP((int)paramLong);
        return;
      }
      dP((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public final void dP(int paramInt)
  {
    int i = (byte)paramInt;
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  public final void dR(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        dP(paramInt);
        return;
      }
      dP(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void j(byte[] paramArrayOfByte)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */