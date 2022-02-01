package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/util/ScanYuvUtils;", "", "()V", "encodeYUV420SP", "", "yuv420sp", "", "argb", "", "width", "", "height", "getNV21", "inputWidth", "inputHeight", "scaled", "Landroid/graphics/Bitmap;", "plugin-scan_release"})
public final class l
{
  public static final l yAq;
  
  static
  {
    AppMethodBeat.i(161063);
    yAq = new l();
    AppMethodBeat.o(161063);
  }
  
  public static final byte[] a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(161062);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(161062);
      return null;
    }
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt1 * paramInt2 * 3 / 2];
    int k = paramInt1 * paramInt2;
    int i = 0;
    int j = 0;
    int n = 0;
    int i1;
    label68:
    int m;
    int i4;
    int i3;
    int i2;
    if (n < paramInt2)
    {
      i1 = 0;
      if (i1 < paramInt1)
      {
        m = (arrayOfInt[j] & 0xFF0000) >> 16;
        i4 = (arrayOfInt[j] & 0xFF00) >> 8;
        int i5 = (arrayOfInt[j] & 0xFF) >> 0;
        i3 = (m * 66 + i4 * 129 + i5 * 25 + 128 >> 8) + 16;
        i2 = (m * -38 - i4 * 74 + i5 * 112 + 128 >> 8) + 128;
        i4 = (m * 112 - i4 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i3 < 0)
        {
          m = 0;
          label211:
          arrayOfByte[i] = ((byte)m);
          if ((n % 2 != 0) || (j % 2 != 0)) {
            break label382;
          }
          i3 = k + 1;
          if (i4 >= 0) {
            break label315;
          }
          m = 0;
          label246:
          arrayOfByte[k] = ((byte)m);
          if (i2 >= 0) {
            break label338;
          }
          k = 0;
          label262:
          arrayOfByte[i3] = ((byte)k);
          k = i3 + 1;
        }
      }
    }
    label315:
    label338:
    label382:
    for (;;)
    {
      i1 += 1;
      j += 1;
      i += 1;
      break label68;
      m = i3;
      if (i3 <= 255) {
        break label211;
      }
      m = 255;
      break label211;
      if (i4 > 255)
      {
        m = 255;
        break label246;
      }
      m = i4;
      break label246;
      if (i2 > 255)
      {
        k = 255;
        break label262;
      }
      k = i2;
      break label262;
      n += 1;
      break;
      paramBitmap.recycle();
      AppMethodBeat.o(161062);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.l
 * JD-Core Version:    0.7.0.1
 */