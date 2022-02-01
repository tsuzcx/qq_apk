package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

public final class k
  implements d
{
  private MediaMetadataRetriever KZG;
  private Canvas cxr;
  private int dstHeight;
  private int dstWidth;
  private Matrix matrix;
  private Paint paint;
  private Bitmap reuse;
  
  public k()
  {
    AppMethodBeat.i(107680);
    this.reuse = null;
    this.paint = new Paint(1);
    this.cxr = new Canvas();
    AppMethodBeat.o(107680);
  }
  
  private int getDuration()
  {
    AppMethodBeat.i(107684);
    String str = this.KZG.extractMetadata(9);
    if (str == null)
    {
      AppMethodBeat.o(107684);
      return 0;
    }
    try
    {
      int i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(107684);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MediaCodecThumbFetcher", "getDuration error %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(107684);
    }
    return 0;
  }
  
  private static Bitmap jK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107686);
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      AppMethodBeat.o(107686);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e("MediaCodecThumbFetcher", "%s OutOfMemory %s", new Object[] { f.aPX(), localOutOfMemoryError.getMessage() });
        System.gc();
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        }
        catch (Exception localException)
        {
          Log.e("MediaCodecThumbFetcher", "%s try again Exception %s", new Object[] { f.aPX(), localException.getMessage() });
          Object localObject = null;
        }
      }
    }
  }
  
  public final int getDurationMs()
  {
    AppMethodBeat.i(107683);
    int i = getDuration();
    AppMethodBeat.o(107683);
    return i;
  }
  
  public final Bitmap getFrameAtTime(long paramLong)
  {
    AppMethodBeat.i(107682);
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = this.KZG.getFrameAtTime(1000L * paramLong);
    if (localBitmap2 == null)
    {
      Log.w("MediaCodecThumbFetcher", "get frame fail at time:%s, rawBitmap is null", new Object[] { Long.valueOf(1000L * paramLong) });
      AppMethodBeat.o(107682);
      return null;
    }
    int i = this.dstWidth;
    int j = this.dstHeight;
    if ((localBitmap2 == null) || (localBitmap2.isRecycled()) || (i <= 0) || (j <= 0)) {}
    for (Bitmap localBitmap1 = null;; localBitmap1 = null)
    {
      localBitmap2.recycle();
      Log.d("MediaCodecThumbFetcher", "time flee : get video thumb bitmap cost time %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(107682);
      return localBitmap1;
      Log.d("MediaCodecThumbFetcher", "scaleBitmap(60) largeBitmap(width : %d, height : %d)", new Object[] { Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
      localBitmap1 = jK(i, j);
      if (localBitmap1 != null) {
        break;
      }
    }
    int k;
    int m;
    Matrix localMatrix;
    if (this.matrix == null)
    {
      k = localBitmap2.getWidth();
      m = localBitmap2.getHeight();
      localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.setTranslate((i - k) / 2.0F, (j - m) / 2.0F);
      if (m / k <= j / i) {
        break label320;
      }
    }
    label320:
    for (float f = i / k;; f = j / m)
    {
      localMatrix.postScale(f, f, i / 2.0F, j / 2.0F);
      this.matrix = localMatrix;
      this.cxr.setBitmap(localBitmap1);
      this.cxr.drawBitmap(localBitmap2, this.matrix, this.paint);
      break;
    }
  }
  
  public final int getScaledHeight()
  {
    return this.dstHeight;
  }
  
  public final int getScaledWidth()
  {
    return this.dstWidth;
  }
  
  public final void init(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107681);
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      paramString = new IllegalArgumentException(String.format(Locale.CHINA, "destination width and height error, width %d, height %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      AppMethodBeat.o(107681);
      throw paramString;
    }
    try
    {
      this.KZG = new com.tencent.mm.compatible.i.d();
      this.KZG.setDataSource(paramString);
      this.dstWidth = paramInt2;
      this.dstHeight = paramInt3;
      AppMethodBeat.o(107681);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MediaCodecThumbFetcher", paramString, "init error:%s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(107685);
    if (this.KZG != null) {
      this.KZG.release();
    }
    this.matrix = null;
    this.paint = null;
    this.cxr = null;
    AppMethodBeat.o(107685);
  }
  
  public final void reuseBitmap(Bitmap paramBitmap)
  {
    this.reuse = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.k
 * JD-Core Version:    0.7.0.1
 */