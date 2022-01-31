package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends b
{
  private final int lll;
  private final Object lock = new Object();
  private boolean[] nOQ = new boolean[4];
  private boolean nOR = false;
  private boolean nOT = false;
  private Bitmap nPw;
  public Bitmap nPx;
  
  public k(b.a parama, int paramInt)
  {
    super(parama);
    this.lll = paramInt;
  }
  
  private static void byy()
  {
    y.i("MicroMsg.ScanLicenceDecoder", "lib release");
    try
    {
      LibCardRecog.recognizeCardRelease();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", new Object[] { localException });
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect)
  {
    y.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", new Object[] { paramPoint, paramRect, Integer.valueOf(paramArrayOfByte.length) });
    int i;
    int j;
    long l;
    CardInfo localCardInfo;
    int k;
    int m;
    synchronized (this.lock)
    {
      if ((this.nPw != null) && (!this.nPw.isRecycled()))
      {
        y.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap");
        this.nPw.recycle();
      }
      y.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", new Object[] { paramPoint, paramRect });
      if (!this.nOR) {
        break label573;
      }
      y.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
      return false;
      while (i < 4)
      {
        this.nOQ[i] = false;
        i += 1;
      }
      float f = Math.min(Math.min(paramPoint.x / paramRect.width(), paramPoint.y / paramRect.height()), 1.0F);
      i = paramRect.width();
      j = paramRect.height();
      y.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[] { Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(j) });
      if (!this.nOT) {
        y.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRect.width()), Integer.valueOf(paramRect.height()) });
      }
    }
    label472:
    while (i < 4)
    {
      this.nOQ[i] = false;
      i += 1;
    }
    y.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
    return false;
    for (;;)
    {
      if (i < 4)
      {
        this.nOQ[i] = true;
        i += 1;
      }
      else
      {
        this.nPw = BitmapFactory.decodeByteArray(localCardInfo.bitmapData, 0, localCardInfo.bitmapLen);
        this.nPx = this.nPw.copy(Bitmap.Config.ARGB_8888, true);
        this.nOR = true;
        return true;
        label573:
        i = 0;
        break;
        if (1 != i)
        {
          i = 0;
          break label472;
        }
        i = 0;
      }
    }
  }
  
  public final void byg()
  {
    this.nOR = false;
  }
  
  public final boolean[] byx()
  {
    synchronized (this.lock)
    {
      boolean[] arrayOfBoolean = this.nOQ;
      return arrayOfBoolean;
    }
  }
  
  public final void nm()
  {
    if ((this.nPw != null) && (!this.nPw.isRecycled())) {
      this.nPw.recycle();
    }
    byy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.k
 * JD-Core Version:    0.7.0.1
 */