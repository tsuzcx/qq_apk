package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class m
  extends b
{
  private final Object lock;
  private final int nIH;
  private boolean[] qCH;
  private boolean qCI;
  private boolean qCK;
  private Bitmap qDp;
  public Bitmap qDq;
  
  public m(b.a parama, int paramInt)
  {
    super(parama);
    AppMethodBeat.i(81457);
    this.lock = new Object();
    this.qCI = false;
    this.qCK = false;
    this.qCH = new boolean[4];
    this.nIH = paramInt;
    AppMethodBeat.o(81457);
  }
  
  private static void cjI()
  {
    AppMethodBeat.i(81460);
    ab.i("MicroMsg.ScanLicenceDecoder", "lib release");
    try
    {
      LibCardRecog.recognizeCardRelease();
      AppMethodBeat.o(81460);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", new Object[] { localException });
      AppMethodBeat.o(81460);
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect)
  {
    AppMethodBeat.i(81458);
    ab.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", new Object[] { paramPoint, paramRect, Integer.valueOf(paramArrayOfByte.length) });
    synchronized (this.lock)
    {
      if ((this.qDp != null) && (!this.qDp.isRecycled()))
      {
        ab.i("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap %s", new Object[] { this.qDp.toString() });
        this.qDp.recycle();
      }
      ab.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", new Object[] { paramPoint, paramRect });
      if (this.qCI)
      {
        ab.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
        AppMethodBeat.o(81458);
        return false;
      }
      int i = 0;
      while (i < 4)
      {
        this.qCH[i] = false;
        i += 1;
      }
      float f = Math.min(Math.min(paramPoint.x / paramRect.width(), paramPoint.y / paramRect.height()), 1.0F);
      i = paramRect.width();
      int j = paramRect.height();
      ab.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[] { Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(j) });
      if (!this.qCK) {
        ab.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRect.width()), Integer.valueOf(paramRect.height()) });
      }
      CardInfo localCardInfo;
      try
      {
        LibCardRecog.recognizeCardInit(i, j, this.nIH);
        this.qCK = true;
        long l = System.currentTimeMillis();
        localCardInfo = new CardInfo(i, j);
        int k = paramRect.top;
        int m = paramRect.left;
        if (1 == i) {
          break label557;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          i = LibCardRecog.recognizeCardProcess(paramArrayOfByte, paramPoint.y, paramPoint.x, m, k, j, i, localCardInfo, this.qCH);
          ab.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", new Object[] { Integer.valueOf(i) });
          ab.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - l));
          ab.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", new Object[] { Arrays.toString(this.qCH) });
          if (i != 0) {
            break label508;
          }
          AppMethodBeat.o(81458);
          return false;
        }
        catch (Exception paramArrayOfByte)
        {
          ab.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", new Object[] { paramArrayOfByte });
          this.qCI = false;
          AppMethodBeat.o(81458);
          return false;
        }
        paramArrayOfByte = paramArrayOfByte;
        ab.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", new Object[] { paramArrayOfByte });
        this.qCK = false;
        cjI();
        AppMethodBeat.o(81458);
        return false;
      }
      label508:
      i = 0;
      while (i < 4)
      {
        this.qCH[i] = false;
        i += 1;
      }
      ab.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
      AppMethodBeat.o(81458);
      return false;
      label557:
      i = 0;
      while (i < 4)
      {
        this.qCH[i] = true;
        i += 1;
      }
      this.qDp = BitmapFactory.decodeByteArray(localCardInfo.bitmapData, 0, localCardInfo.bitmapLen);
      this.qDq = this.qDp.copy(Bitmap.Config.ARGB_8888, true);
      this.qCI = true;
      AppMethodBeat.o(81458);
      return true;
    }
  }
  
  public final boolean[] cjH()
  {
    synchronized (this.lock)
    {
      boolean[] arrayOfBoolean = this.qCH;
      return arrayOfBoolean;
    }
  }
  
  public final void pJ()
  {
    AppMethodBeat.i(81459);
    if ((this.qDp != null) && (!this.qDp.isRecycled()))
    {
      ab.i("MicroMsg.ScanLicenceDecoder", "bitmap recycle %s", new Object[] { this.qDp.toString() });
      this.qDp.recycle();
    }
    cjI();
    AppMethodBeat.o(81459);
  }
  
  public final void restartDecoder()
  {
    this.qCI = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.m
 * JD-Core Version:    0.7.0.1
 */