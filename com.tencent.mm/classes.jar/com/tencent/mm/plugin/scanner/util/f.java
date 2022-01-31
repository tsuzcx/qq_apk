package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import e.a;

public final class f
  extends a
{
  private static int nOM = 10;
  private final byte[] nOL;
  
  public f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    super(paramBitmap.getWidth() - paramInt1, paramBitmap.getHeight() - paramInt2);
    int i = paramBitmap.getWidth() - paramInt1;
    int j = paramBitmap.getHeight() - paramInt2;
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, paramInt1 / 2, paramInt2 / 2, i, j);
    this.nOL = new byte[i * j];
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      int k = paramInt1 * i;
      paramInt2 = 0;
      if (paramInt2 < i)
      {
        int i1 = arrayOfInt[(k + paramInt2)];
        int m = i1 >> 16 & 0xFF;
        int n = i1 >> 8 & 0xFF;
        i1 &= 0xFF;
        if ((m == n) && (n == i1)) {
          this.nOL[(k + paramInt2)] = ((byte)m);
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.nOL[(k + paramInt2)] = ((byte)(i1 + (m + n + n) >> 2));
        }
      }
      paramInt1 += 1;
    }
  }
  
  public final byte[] byj()
  {
    return this.nOL;
  }
  
  public final byte[] n(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt < 0) || (paramInt >= this.height)) {
      throw new IllegalArgumentException("Requested row is outside the image: " + paramInt);
    }
    int i = this.width;
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= i) {}
    }
    else
    {
      arrayOfByte = new byte[i];
    }
    System.arraycopy(this.nOL, paramInt * i, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f
 * JD-Core Version:    0.7.0.1
 */