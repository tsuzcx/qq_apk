package com.tencent.mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class j
  extends b
{
  private Object bjn = new Object();
  private byte[] gph;
  private boolean isDecoding = false;
  public boolean miw = true;
  private boolean nKU = false;
  private final int nPn = 25;
  private boolean nPo = false;
  private final int nPp = 1;
  private int nPq = 0;
  private boolean nPr;
  private volatile boolean nPs;
  public volatile boolean nPt;
  private long nPu;
  private int outHeight;
  private int outWidth;
  private int quality = 50;
  
  public j(b.a parama, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(parama);
    this.quality = paramInt;
    this.miw = paramBoolean2;
    this.nPr = paramBoolean1;
    y.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], needRotate = [%s], ocrMode=[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
  }
  
  private static int a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return -1;
    }
    if (paramInt3 == 1) {
      return QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 6, 140);
    }
    if (paramInt3 == 2) {
      return QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 8, 120);
    }
    if (paramInt3 == 4) {
      return QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 13, 80);
    }
    if (paramInt3 == 5) {
      return QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 15, 65);
    }
    return QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 10, 100);
  }
  
  private static int wY(int paramInt)
  {
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramInt <= 5) {}
    }
    else
    {
      i = 3;
    }
    return i;
  }
  
  @TargetApi(8)
  public final boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect)
  {
    if (this.isDecoding)
    {
      y.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
      return false;
    }
    this.isDecoding = true;
    if ((paramArrayOfByte == null) || (paramPoint == null) || (paramRect == null))
    {
      boolean bool2;
      if (paramArrayOfByte == null)
      {
        bool1 = true;
        if (paramPoint != null) {
          break label102;
        }
        bool2 = true;
        label47:
        if (paramRect != null) {
          break label108;
        }
      }
      label102:
      label108:
      for (boolean bool3 = true;; bool3 = false)
      {
        y.e("MicroMsg.scanner.ScanImageDecoder", "decode() data null:[%s], resolution null:[%s], coverage null:[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        this.isDecoding = false;
        return false;
        bool1 = false;
        break;
        bool2 = false;
        break label47;
      }
    }
    Rect localRect;
    try
    {
      if (this.nPq <= 0)
      {
        this.nPq += 1;
        this.isDecoding = false;
        return false;
      }
      synchronized (this.bjn)
      {
        localRect = new Rect();
        if ((!com.tencent.mm.compatible.e.d.yN()) && (this.miw)) {
          break label312;
        }
        i = paramRect.width();
        j = paramRect.height();
        localRect.left = paramRect.left;
        paramRect.right -= i % 4;
        localRect.top = paramRect.top;
        paramRect.bottom -= j % 4;
        if ((localRect.right > localRect.left) && (localRect.bottom > localRect.top)) {
          break label552;
        }
        this.isDecoding = false;
        return false;
      }
      this.nOo = null;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", new Object[] { paramArrayOfByte.toString() });
      y.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", paramArrayOfByte, "", new Object[0]);
    }
    this.isDecoding = false;
    return false;
    label312:
    localRect.left = (paramPoint.x / 2 - paramRect.height() / 2);
    localRect.right = (paramPoint.x / 2 + paramRect.height() / 2);
    localRect.top = (paramPoint.y / 2 - paramRect.width() / 2);
    localRect.bottom = (paramPoint.y / 2 + paramRect.width() / 2);
    if (localRect.left < 0) {
      localRect.left = 0;
    }
    if (localRect.right > paramPoint.x - 1) {
      localRect.right = (paramPoint.x - 1);
    }
    if (localRect.top < 0) {
      localRect.top = 0;
    }
    if (localRect.bottom > paramPoint.y - 1) {
      localRect.bottom = (paramPoint.y - 1);
    }
    int i = localRect.width() % 4;
    int j = localRect.height() % 4;
    if (i != 0) {
      localRect.right -= i;
    }
    if (j != 0) {
      localRect.bottom -= j;
    }
    if ((localRect.right <= localRect.left) || (localRect.bottom <= localRect.top))
    {
      this.isDecoding = false;
      return false;
    }
    label552:
    paramArrayOfByte = new c(paramArrayOfByte, paramPoint.x, paramPoint.y, localRect);
    if ((paramArrayOfByte.height == 0) || (paramArrayOfByte.width == 0))
    {
      this.isDecoding = false;
      return false;
    }
    if (this.nKU)
    {
      y.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
      return false;
    }
    paramPoint = paramArrayOfByte.byi();
    if (paramPoint == null)
    {
      this.isDecoding = false;
      return false;
    }
    if (!this.nPo)
    {
      if ((!com.tencent.mm.compatible.e.d.yN()) || (this.miw))
      {
        i = a(localRect.height(), localRect.width(), this.nPr, wY(q.dyd.dwp));
        y.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[] { Integer.valueOf(localRect.height()), Integer.valueOf(localRect.width()), Boolean.valueOf(this.nPr), Integer.valueOf(q.dyd.dwp) });
      }
      while (i == -1)
      {
        y.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", new Object[] { Integer.valueOf(i) });
        return false;
        i = a(localRect.width(), localRect.height(), this.nPr, wY(q.dyd.dwp));
        y.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[] { Integer.valueOf(localRect.width()), Integer.valueOf(localRect.height()), Boolean.valueOf(this.nPr), Integer.valueOf(q.dyd.dwp) });
      }
      this.nPo = true;
    }
    paramRect = new boolean[2];
    long l = bk.UZ();
    if ((com.tencent.mm.compatible.e.d.yN()) && (!this.miw)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QbarNative.FocusPro(paramPoint, bool1, paramRect);
      y.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", new Object[] { Boolean.valueOf(paramRect[0]), Boolean.valueOf(paramRect[1]), Long.valueOf(bk.cp(l)) });
      this.nPs = paramRect[0];
      this.nPt = paramRect[1];
      if (this.nPu == 0L) {
        this.nPu = System.currentTimeMillis();
      }
      if ((!this.nPt) && (System.currentTimeMillis() - this.nPu > 9000L))
      {
        y.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
        this.nPt = true;
        this.nPu = System.currentTimeMillis();
      }
      if (this.nPs == true)
      {
        if (this.nKU)
        {
          y.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
          return false;
        }
        this.outWidth = paramArrayOfByte.width;
        this.outHeight = paramArrayOfByte.height;
        i = 0;
        if (!com.tencent.mm.compatible.e.d.yN())
        {
          i = 1;
          this.outWidth = paramArrayOfByte.height;
          this.outHeight = paramArrayOfByte.width;
        }
        if (this.gph == null)
        {
          this.gph = new byte[this.outWidth * this.outHeight * 3 / 2];
          y.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(this.outWidth * this.outHeight * 3 / 2) });
        }
        for (;;)
        {
          j = QbarNative.b(this.gph, paramPoint, this.outWidth, this.outHeight);
          y.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(i), Integer.valueOf(0) });
          if (j == 0) {
            break;
          }
          this.nOo = null;
          this.isDecoding = false;
          return false;
          if (this.gph.length != this.outWidth * this.outHeight * 3 / 2)
          {
            this.gph = null;
            this.gph = new byte[this.outWidth * this.outHeight * 3 / 2];
            y.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(this.outWidth * this.outHeight * 3 / 2) });
          }
        }
        if (this.nKU)
        {
          y.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
          return false;
        }
        if (com.tencent.mm.compatible.util.d.gF(8)) {
          com.tencent.mm.compatible.a.a.a(8, new j.1(this));
        }
        for (;;)
        {
          y.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", new Object[] { Integer.valueOf(this.nOo.length) });
          this.isDecoding = false;
          return true;
          y.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
          paramPoint = new c(this.gph, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
          paramRect = new int[paramPoint.width * paramPoint.height];
          QbarNative.a(paramPoint.bXE, paramRect, paramPoint.nOv, paramPoint.nOw, paramPoint.left, paramPoint.top, paramPoint.width, paramPoint.height);
          QbarNative.nativeRelease();
          paramArrayOfByte = Bitmap.createBitmap(paramPoint.width, paramPoint.height, Bitmap.Config.ARGB_8888);
          paramArrayOfByte.setPixels(paramRect, 0, paramPoint.width, 0, 0, paramPoint.width, paramPoint.height);
          paramPoint = new ByteArrayOutputStream();
          paramArrayOfByte.compress(Bitmap.CompressFormat.JPEG, this.quality, paramPoint);
          this.nOo = paramPoint.toByteArray();
          paramPoint.close();
          if (ae.eSD) {
            com.tencent.mm.sdk.platformtools.c.a(paramArrayOfByte, this.quality, Bitmap.CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
          }
          paramArrayOfByte.recycle();
        }
      }
      break;
    }
  }
  
  public final void byg()
  {
    if (this.nPo) {
      nm();
    }
    this.isDecoding = false;
    this.nKU = false;
    this.nPo = false;
  }
  
  public final void nm()
  {
    y.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
    this.nKU = true;
    if (this.bjn != null) {}
    synchronized (this.bjn)
    {
      if (this.nPo)
      {
        y.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", new Object[] { Integer.valueOf(0) });
        this.nPo = false;
        y.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", new Object[] { Integer.valueOf(QbarNative.FocusRelease()) });
      }
      this.gph = null;
      c.byh();
      y.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.j
 * JD-Core Version:    0.7.0.1
 */