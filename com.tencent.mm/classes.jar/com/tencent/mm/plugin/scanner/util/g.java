package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a;

public final class g
  extends a
{
  private static int qCD = 10;
  private final byte[] qCC;
  
  public g(Bitmap paramBitmap)
  {
    super(paramBitmap.getWidth() + 0, paramBitmap.getHeight() + 0);
    AppMethodBeat.i(81414);
    int k = paramBitmap.getWidth() + 0;
    int m = paramBitmap.getHeight() + 0;
    int[] arrayOfInt = new int[k * m];
    paramBitmap.getPixels(arrayOfInt, 0, k, 0, 0, k, m);
    this.qCC = new byte[k * m];
    int i = 0;
    while (i < m)
    {
      int n = i * k;
      int j = 0;
      if (j < k)
      {
        int i3 = arrayOfInt[(n + j)];
        int i1 = i3 >> 16 & 0xFF;
        int i2 = i3 >> 8 & 0xFF;
        i3 &= 0xFF;
        if ((i1 == i2) && (i2 == i3)) {
          this.qCC[(n + j)] = ((byte)i1);
        }
        for (;;)
        {
          j += 1;
          break;
          this.qCC[(n + j)] = ((byte)(i3 + (i1 + i2 + i2) >> 2));
        }
      }
      i += 1;
    }
    AppMethodBeat.o(81414);
  }
  
  public final byte[] cjr()
  {
    return this.qCC;
  }
  
  public final byte[] o(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(81415);
    if ((paramInt < 0) || (paramInt >= this.height))
    {
      paramArrayOfByte = new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(81415);
      throw paramArrayOfByte;
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
    System.arraycopy(this.qCC, paramInt * i, arrayOfByte, 0, i);
    AppMethodBeat.o(81415);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */