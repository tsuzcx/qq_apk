package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

public final class k
  implements d
{
  private Canvas aNT = new Canvas();
  private Matrix aqv;
  private Paint gaZ = new Paint(1);
  private MediaMetadataRetriever mlV;
  private int mlW;
  private int mlX;
  private Bitmap reuse = null;
  
  private static Bitmap dh(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      y.e("MediaCodecThumbFetcher", "%s OutOfMemory %s", new Object[] { g.zI(), localOutOfMemoryError.getMessage() });
      System.gc();
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return localBitmap2;
      }
      catch (Exception localException)
      {
        y.e("MediaCodecThumbFetcher", "%s try again Exception %s", new Object[] { g.zI(), localException.getMessage() });
      }
    }
    return null;
  }
  
  private int getDuration()
  {
    String str = this.mlV.extractMetadata(9);
    if (str == null) {
      return 0;
    }
    try
    {
      int i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (Exception localException)
    {
      y.e("MediaCodecThumbFetcher", "getDuration error %s", new Object[] { localException.getMessage() });
    }
    return 0;
  }
  
  public final int getDurationMs()
  {
    return getDuration();
  }
  
  public final Bitmap getFrameAtTime(long paramLong)
  {
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = this.mlV.getFrameAtTime(1000L * paramLong);
    int i = this.mlW;
    int j = this.mlX;
    if ((localBitmap2 == null) || (localBitmap2.isRecycled()) || (i <= 0) || (j <= 0)) {}
    for (Bitmap localBitmap1 = null;; localBitmap1 = null)
    {
      localBitmap2.recycle();
      y.d("MediaCodecThumbFetcher", "time flee : get video thumb bitmap cost time %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return localBitmap1;
      y.d("MediaCodecThumbFetcher", "scaleBitmap(60) largeBitmap(width : %d, height : %d)", new Object[] { Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
      localBitmap1 = dh(i, j);
      if (localBitmap1 != null) {
        break;
      }
    }
    int k;
    int m;
    Matrix localMatrix;
    if (this.aqv == null)
    {
      k = localBitmap2.getWidth();
      m = localBitmap2.getHeight();
      localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.setTranslate((i - k) / 2.0F, (j - m) / 2.0F);
      if (m / k <= j / i) {
        break label276;
      }
    }
    label276:
    for (float f = i / k;; f = j / m)
    {
      localMatrix.postScale(f, f, i / 2.0F, j / 2.0F);
      this.aqv = localMatrix;
      this.aNT.setBitmap(localBitmap1);
      this.aNT.drawBitmap(localBitmap2, this.aqv, this.gaZ);
      break;
    }
  }
  
  public final int getScaledHeight()
  {
    return this.mlX;
  }
  
  public final int getScaledWidth()
  {
    return this.mlW;
  }
  
  public final void init(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 <= 0) || (paramInt3 <= 0)) {
      throw new IllegalArgumentException(String.format(Locale.CHINA, "destination width and height error, width %d, height %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    this.mlV = new MediaMetadataRetriever();
    this.mlV.setDataSource(paramString);
    this.mlW = paramInt2;
    this.mlX = paramInt3;
  }
  
  public final void release()
  {
    if (this.mlV != null) {
      this.mlV.release();
    }
    this.aqv = null;
    this.gaZ = null;
    this.aNT = null;
  }
  
  public final void reuseBitmap(Bitmap paramBitmap)
  {
    this.reuse = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.k
 * JD-Core Version:    0.7.0.1
 */