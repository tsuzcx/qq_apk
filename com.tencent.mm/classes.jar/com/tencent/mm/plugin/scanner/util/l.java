package com.tencent.mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class l
  extends b
{
  private Object ceY;
  private byte[] hJl;
  private boolean isDecoding;
  public boolean oIC;
  private int outHeight;
  private int outWidth;
  private final int qDg;
  private boolean qDh;
  private final int qDi;
  private int qDj;
  private boolean qDk;
  private volatile boolean qDl;
  public volatile boolean qDm;
  private long qDn;
  private int quality;
  private boolean qyz;
  
  public l(b.a parama, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(parama);
    AppMethodBeat.i(81452);
    this.qDg = 25;
    this.quality = 50;
    this.qDh = false;
    this.qDi = 1;
    this.qDj = 0;
    this.isDecoding = false;
    this.oIC = true;
    this.ceY = new Object();
    this.qyz = false;
    this.quality = paramInt;
    this.oIC = paramBoolean2;
    this.qDk = paramBoolean1;
    ab.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], needRotate = [%s], ocrMode=[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    AppMethodBeat.o(81452);
  }
  
  private static int CT(int paramInt)
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
  
  private static int a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(81456);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(81456);
      return -1;
    }
    if (paramInt3 == 1)
    {
      paramInt1 = QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 6, 140);
      AppMethodBeat.o(81456);
      return paramInt1;
    }
    if (paramInt3 == 2)
    {
      paramInt1 = QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 8, 120);
      AppMethodBeat.o(81456);
      return paramInt1;
    }
    if (paramInt3 == 4)
    {
      paramInt1 = QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 13, 80);
      AppMethodBeat.o(81456);
      return paramInt1;
    }
    if (paramInt3 == 5)
    {
      paramInt1 = QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 15, 65);
      AppMethodBeat.o(81456);
      return paramInt1;
    }
    paramInt1 = QbarNative.FocusInit(paramInt1, paramInt2, paramBoolean, 10, 100);
    AppMethodBeat.o(81456);
    return paramInt1;
  }
  
  @TargetApi(8)
  public final boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect)
  {
    AppMethodBeat.i(81453);
    if (this.isDecoding)
    {
      ab.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
      AppMethodBeat.o(81453);
      return false;
    }
    this.isDecoding = true;
    boolean bool1;
    if ((paramArrayOfByte == null) || (paramPoint == null) || (paramRect == null))
    {
      boolean bool2;
      if (paramArrayOfByte == null)
      {
        bool1 = true;
        if (paramPoint != null) {
          break label117;
        }
        bool2 = true;
        label57:
        if (paramRect != null) {
          break label123;
        }
      }
      label117:
      label123:
      for (boolean bool3 = true;; bool3 = false)
      {
        ab.e("MicroMsg.scanner.ScanImageDecoder", "decode() data null:[%s], resolution null:[%s], coverage null:[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        this.isDecoding = false;
        AppMethodBeat.o(81453);
        return false;
        bool1 = false;
        break;
        bool2 = false;
        break label57;
      }
    }
    int i;
    int j;
    try
    {
      if (this.qDj <= 0)
      {
        this.qDj += 1;
        this.isDecoding = false;
        AppMethodBeat.o(81453);
        return false;
      }
      synchronized (this.ceY)
      {
        Rect localRect = new Rect();
        if ((com.tencent.mm.compatible.e.d.Ll()) || (!this.oIC))
        {
          i = paramRect.width();
          j = paramRect.height();
          localRect.left = paramRect.left;
          paramRect.right -= i % 4;
          localRect.top = paramRect.top;
          paramRect.bottom -= j % 4;
          if ((localRect.right <= localRect.left) || (localRect.bottom <= localRect.top))
          {
            this.isDecoding = false;
            AppMethodBeat.o(81453);
            return false;
          }
        }
        else
        {
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
          i = localRect.width() % 4;
          j = localRect.height() % 4;
          if (i != 0) {
            localRect.right -= i;
          }
          if (j != 0) {
            localRect.bottom -= j;
          }
          if ((localRect.right <= localRect.left) || (localRect.bottom <= localRect.top))
          {
            this.isDecoding = false;
            AppMethodBeat.o(81453);
            return false;
          }
        }
        paramArrayOfByte = new d(paramArrayOfByte, paramPoint.x, paramPoint.y, localRect);
        if ((paramArrayOfByte.height == 0) || (paramArrayOfByte.width == 0))
        {
          this.isDecoding = false;
          AppMethodBeat.o(81453);
          return false;
        }
        if (this.qyz)
        {
          ab.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
          AppMethodBeat.o(81453);
          return false;
        }
        paramPoint = paramArrayOfByte.cjq();
        if (paramPoint == null)
        {
          this.isDecoding = false;
          AppMethodBeat.o(81453);
          return false;
        }
        if (this.qDh) {
          break label917;
        }
        if ((!com.tencent.mm.compatible.e.d.Ll()) || (this.oIC))
        {
          i = a(localRect.height(), localRect.width(), this.qDk, CT(ac.eru.eoj));
          ab.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[] { Integer.valueOf(localRect.height()), Integer.valueOf(localRect.width()), Boolean.valueOf(this.qDk), Integer.valueOf(ac.eru.eoj) });
          if (i != -1) {
            break label912;
          }
          ab.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(81453);
          return false;
        }
        i = a(localRect.width(), localRect.height(), this.qDk, CT(ac.eru.eoj));
        ab.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[] { Integer.valueOf(localRect.width()), Integer.valueOf(localRect.height()), Boolean.valueOf(this.qDk), Integer.valueOf(ac.eru.eoj) });
      }
      this.qBZ = null;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", new Object[] { paramArrayOfByte.toString() });
      ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", paramArrayOfByte, "", new Object[0]);
    }
    label1675:
    for (;;)
    {
      this.isDecoding = false;
      AppMethodBeat.o(81453);
      return false;
      label912:
      this.qDh = true;
      label917:
      paramRect = new boolean[2];
      long l = bo.yB();
      if ((com.tencent.mm.compatible.e.d.Ll()) && (!this.oIC)) {}
      for (bool1 = true;; bool1 = false)
      {
        QbarNative.FocusPro(paramPoint, bool1, paramRect);
        ab.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", new Object[] { Boolean.valueOf(paramRect[0]), Boolean.valueOf(paramRect[1]), Long.valueOf(bo.av(l)) });
        this.qDl = paramRect[0];
        this.qDm = paramRect[1];
        if (this.qDn == 0L) {
          this.qDn = System.currentTimeMillis();
        }
        if ((!this.qDm) && (System.currentTimeMillis() - this.qDn > 9000L))
        {
          ab.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
          this.qDm = true;
          this.qDn = System.currentTimeMillis();
        }
        if (this.qDl != true) {
          break label1675;
        }
        if (!this.qyz) {
          break;
        }
        ab.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
        AppMethodBeat.o(81453);
        return false;
      }
      this.outWidth = paramArrayOfByte.width;
      this.outHeight = paramArrayOfByte.height;
      i = 0;
      if (!com.tencent.mm.compatible.e.d.Ll())
      {
        i = 1;
        this.outWidth = paramArrayOfByte.height;
        this.outHeight = paramArrayOfByte.width;
      }
      if (this.hJl == null)
      {
        this.hJl = new byte[this.outWidth * this.outHeight * 3 / 2];
        ab.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(this.outWidth * this.outHeight * 3 / 2) });
      }
      for (;;)
      {
        j = QbarNative.b(this.hJl, paramPoint, this.outWidth, this.outHeight);
        ab.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(i), Integer.valueOf(0) });
        if (j == 0) {
          break;
        }
        this.qBZ = null;
        this.isDecoding = false;
        AppMethodBeat.o(81453);
        return false;
        if (this.hJl.length != this.outWidth * this.outHeight * 3 / 2)
        {
          this.hJl = null;
          this.hJl = new byte[this.outWidth * this.outHeight * 3 / 2];
          ab.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(this.outWidth * this.outHeight * 3 / 2) });
        }
      }
      if (this.qyz)
      {
        ab.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
        AppMethodBeat.o(81453);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.fv(8)) {
        com.tencent.mm.compatible.a.a.a(8, new l.1(this));
      }
      for (;;)
      {
        ab.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", new Object[] { Integer.valueOf(this.qBZ.length) });
        this.isDecoding = false;
        AppMethodBeat.o(81453);
        return true;
        ab.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
        paramPoint = new d(this.hJl, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
        paramRect = new int[paramPoint.width * paramPoint.height];
        QbarNative.a(paramPoint.cFD, paramRect, paramPoint.qCl, paramPoint.qCm, paramPoint.left, paramPoint.top, paramPoint.width, paramPoint.height);
        QbarNative.nativeRelease();
        paramArrayOfByte = Bitmap.createBitmap(paramPoint.width, paramPoint.height, Bitmap.Config.ARGB_8888);
        paramArrayOfByte.setPixels(paramRect, 0, paramPoint.width, 0, 0, paramPoint.width, paramPoint.height);
        paramPoint = new ByteArrayOutputStream();
        paramArrayOfByte.compress(Bitmap.CompressFormat.JPEG, this.quality, paramPoint);
        this.qBZ = paramPoint.toByteArray();
        paramPoint.close();
        if (ae.gky) {
          com.tencent.mm.sdk.platformtools.d.a(paramArrayOfByte, this.quality, Bitmap.CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
        }
        paramArrayOfByte.recycle();
      }
    }
  }
  
  public final void pJ()
  {
    AppMethodBeat.i(81454);
    ab.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
    this.qyz = true;
    if (this.ceY != null) {}
    synchronized (this.ceY)
    {
      if (this.qDh)
      {
        ab.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", new Object[] { Integer.valueOf(0) });
        this.qDh = false;
        ab.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", new Object[] { Integer.valueOf(QbarNative.FocusRelease()) });
      }
      this.hJl = null;
      d.cjp();
      ab.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
      AppMethodBeat.o(81454);
      return;
    }
  }
  
  public final void restartDecoder()
  {
    AppMethodBeat.i(81455);
    if (this.qDh) {
      pJ();
    }
    this.isDecoding = false;
    this.qyz = false;
    this.qDh = false;
    AppMethodBeat.o(81455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.l
 * JD-Core Version:    0.7.0.1
 */