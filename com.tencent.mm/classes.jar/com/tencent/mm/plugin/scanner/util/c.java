package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.y;
import e.a;

public final class c
  extends a
{
  public final byte[] bXE;
  public int height;
  public int left;
  final int nOv;
  final int nOw;
  public int top;
  public int width;
  
  public c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    super(paramRect.width(), paramRect.height());
    y.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramRect.left), Integer.valueOf(paramRect.top), Integer.valueOf(paramRect.width()), Integer.valueOf(paramRect.height()) });
    this.bXE = paramArrayOfByte;
    this.nOv = paramInt1;
    this.nOw = paramInt2;
    if ((paramRect.left < 0) || (paramRect.left >= paramInt1))
    {
      i = 0;
      this.left = i;
      i = j;
      if (paramRect.top >= 0)
      {
        if (paramRect.top < paramInt2) {
          break label270;
        }
        i = j;
      }
      label162:
      this.top = i;
      if (this.left + paramRect.width() <= paramInt1) {
        break label280;
      }
      i = paramInt1 - this.left;
      label190:
      this.width = i;
      if (this.top + paramRect.height() <= paramInt2) {
        break label290;
      }
    }
    label270:
    label280:
    label290:
    for (int i = paramInt2 - this.top;; i = paramRect.height())
    {
      this.height = i;
      if ((this.left + this.width <= paramInt1) && (this.top + this.height <= paramInt2)) {
        return;
      }
      throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
      i = paramRect.left;
      break;
      i = paramRect.top;
      break label162;
      i = paramRect.width();
      break label190;
    }
  }
  
  public static void byh()
  {
    l locall = l.byz();
    if (locall.nPz != null) {
      locall.nPz = null;
    }
    if (locall.nPA != null) {
      locall.nPA = null;
    }
    System.gc();
  }
  
  public final byte[] byi()
  {
    int i = 0;
    Object localObject1;
    if ((this.width == this.nOv) && (this.height == this.nOw))
    {
      localObject1 = this.bXE;
      return localObject1;
    }
    int k;
    byte[] arrayOfByte1;
    int j;
    for (;;)
    {
      try
      {
        k = this.width * this.height;
        localObject1 = l.byz();
        if (((l)localObject1).nPz == null)
        {
          ((l)localObject1).nPz = new byte[k];
          arrayOfByte1 = ((l)localObject1).nPz;
          j = this.top * this.nOv + this.left;
          if (this.width != this.nOv) {
            break;
          }
          System.arraycopy(this.bXE, j, arrayOfByte1, 0, k);
          return arrayOfByte1;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.bXE.length + " dataWidth:" + this.nOv + " dataHeight:" + this.nOw + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + localException.toString());
        return null;
      }
      if (localException.nPz.length != k)
      {
        localException.nPz = null;
        localException.nPz = new byte[k];
      }
    }
    byte[] arrayOfByte2 = this.bXE;
    for (;;)
    {
      Object localObject2 = arrayOfByte1;
      if (i >= this.height) {
        break;
      }
      System.arraycopy(arrayOfByte2, j, arrayOfByte1, this.width * i, this.width);
      k = this.nOv;
      j += k;
      i += 1;
    }
  }
  
  public final byte[] byj()
  {
    int i = 0;
    if ((this.width == this.nOv) && (this.height == this.nOw))
    {
      byte[] arrayOfByte1 = this.bXE;
      return arrayOfByte1;
    }
    int k;
    byte[] arrayOfByte2;
    int j;
    try
    {
      k = this.width * this.height;
      arrayOfByte2 = new byte[k];
      j = this.top * this.nOv + this.left;
      if (this.width == this.nOv)
      {
        System.arraycopy(this.bXE, j, arrayOfByte2, 0, k);
        return arrayOfByte2;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.bXE.length + " dataWidth:" + this.nOv + " dataHeight:" + this.nOw + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + localException.toString());
      return null;
    }
    byte[] arrayOfByte3 = this.bXE;
    for (;;)
    {
      Object localObject = arrayOfByte2;
      if (i >= this.height) {
        break;
      }
      System.arraycopy(arrayOfByte3, j, arrayOfByte2, this.width * i, this.width);
      k = this.nOv;
      j += k;
      i += 1;
    }
  }
  
  public final byte[] n(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt < 0) || (paramInt >= this.height)) {
      throw new IllegalArgumentException("Requested row is outside the image: " + paramInt);
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
    int j = this.nOv;
    int k = this.left;
    System.arraycopy(this.bXE, (i + paramInt) * j + k, arrayOfByte, 0, this.width);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */