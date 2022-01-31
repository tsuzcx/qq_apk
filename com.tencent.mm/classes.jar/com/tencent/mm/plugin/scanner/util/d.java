package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import f.a;

public final class d
  extends a
{
  public final byte[] cFD;
  public int height;
  public int left;
  final int qCl;
  final int qCm;
  public int top;
  public int width;
  
  public d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    super(paramRect.width(), paramRect.height());
    AppMethodBeat.i(81373);
    ab.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramRect.left), Integer.valueOf(paramRect.top), Integer.valueOf(paramRect.width()), Integer.valueOf(paramRect.height()) });
    this.cFD = paramArrayOfByte;
    this.qCl = paramInt1;
    this.qCm = paramInt2;
    if ((paramRect.left < 0) || (paramRect.left >= paramInt1))
    {
      i = 0;
      this.left = i;
      i = j;
      if (paramRect.top >= 0)
      {
        if (paramRect.top < paramInt2) {
          break label282;
        }
        i = j;
      }
      label167:
      this.top = i;
      if (this.left + paramRect.width() <= paramInt1) {
        break label292;
      }
      i = paramInt1 - this.left;
      label195:
      this.width = i;
      if (this.top + paramRect.height() <= paramInt2) {
        break label302;
      }
    }
    label282:
    label292:
    label302:
    for (int i = paramInt2 - this.top;; i = paramRect.height())
    {
      this.height = i;
      if ((this.left + this.width <= paramInt1) && (this.top + this.height <= paramInt2)) {
        break label312;
      }
      paramArrayOfByte = new IllegalArgumentException("Crop rectangle does not fit within image data.");
      AppMethodBeat.o(81373);
      throw paramArrayOfByte;
      i = paramRect.left;
      break;
      i = paramRect.top;
      break label167;
      i = paramRect.width();
      break label195;
    }
    label312:
    AppMethodBeat.o(81373);
  }
  
  public static void cjp()
  {
    AppMethodBeat.i(81375);
    n.cjJ().cjK();
    System.gc();
    AppMethodBeat.o(81375);
  }
  
  public final byte[] cjq()
  {
    int i = 0;
    AppMethodBeat.i(81376);
    Object localObject;
    if ((this.width == this.qCl) && (this.height == this.qCm))
    {
      localObject = this.cFD;
      AppMethodBeat.o(81376);
      return localObject;
    }
    int k;
    int j;
    try
    {
      k = this.width * this.height;
      localObject = n.cjJ();
      if (((n)localObject).qDs == null) {
        ((n)localObject).qDs = new byte[k];
      }
      for (;;)
      {
        localObject = ((n)localObject).qDs;
        j = this.top * this.qCl + this.left;
        if (this.width != this.qCl) {
          break;
        }
        System.arraycopy(this.cFD, j, localObject, 0, k);
        AppMethodBeat.o(81376);
        return localObject;
        if (((n)localObject).qDs.length != k)
        {
          ((n)localObject).qDs = null;
          ((n)localObject).qDs = new byte[k];
        }
      }
      arrayOfByte = this.cFD;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.cFD.length + " dataWidth:" + this.qCl + " dataHeight:" + this.qCm + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + localException.toString());
      AppMethodBeat.o(81376);
      return null;
    }
    byte[] arrayOfByte;
    while (i < this.height)
    {
      System.arraycopy(arrayOfByte, j, localException, this.width * i, this.width);
      k = this.qCl;
      j += k;
      i += 1;
    }
    AppMethodBeat.o(81376);
    return localException;
  }
  
  public final byte[] cjr()
  {
    int i = 0;
    AppMethodBeat.i(81377);
    byte[] arrayOfByte1;
    if ((this.width == this.qCl) && (this.height == this.qCm))
    {
      arrayOfByte1 = this.cFD;
      AppMethodBeat.o(81377);
      return arrayOfByte1;
    }
    try
    {
      int k = this.width * this.height;
      arrayOfByte1 = new byte[k];
      int j = this.top * this.qCl + this.left;
      if (this.width == this.qCl)
      {
        System.arraycopy(this.cFD, j, arrayOfByte1, 0, k);
        AppMethodBeat.o(81377);
        return arrayOfByte1;
      }
      byte[] arrayOfByte2 = this.cFD;
      while (i < this.height)
      {
        System.arraycopy(arrayOfByte2, j, arrayOfByte1, this.width * i, this.width);
        k = this.qCl;
        j += k;
        i += 1;
      }
      AppMethodBeat.o(81377);
      return arrayOfByte1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.cFD.length + " dataWidth:" + this.qCl + " dataHeight:" + this.qCm + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + localException.toString());
      AppMethodBeat.o(81377);
    }
    return null;
  }
  
  public final byte[] o(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(81374);
    if ((paramInt < 0) || (paramInt >= this.height))
    {
      paramArrayOfByte = new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(81374);
      throw paramArrayOfByte;
    }
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= this.width) {}
    }
    else
    {
      arrayOfByte = new byte[this.width];
    }
    int i = this.top;
    int j = this.qCl;
    int k = this.left;
    System.arraycopy(this.cFD, (i + paramInt) * j + k, arrayOfByte, 0, this.width);
    AppMethodBeat.o(81374);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d
 * JD-Core Version:    0.7.0.1
 */