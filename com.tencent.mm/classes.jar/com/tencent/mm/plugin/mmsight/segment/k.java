package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;

public final class k
  implements d
{
  private Canvas aVn;
  private Matrix asO;
  private MediaMetadataRetriever oLc;
  private int oLd;
  private int oLe;
  private Paint paint;
  private Bitmap reuse;
  
  public k()
  {
    AppMethodBeat.i(3678);
    this.reuse = null;
    this.paint = new Paint(1);
    this.aVn = new Canvas();
    AppMethodBeat.o(3678);
  }
  
  private static Bitmap eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3684);
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      AppMethodBeat.o(3684);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ab.e("MediaCodecThumbFetcher", "%s OutOfMemory %s", new Object[] { g.Ml(), localOutOfMemoryError.getMessage() });
        System.gc();
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        }
        catch (Exception localException)
        {
          ab.e("MediaCodecThumbFetcher", "%s try again Exception %s", new Object[] { g.Ml(), localException.getMessage() });
          Object localObject = null;
        }
      }
    }
  }
  
  private int getDuration()
  {
    AppMethodBeat.i(3682);
    String str = this.oLc.extractMetadata(9);
    if (str == null)
    {
      AppMethodBeat.o(3682);
      return 0;
    }
    try
    {
      int i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(3682);
      return i;
    }
    catch (Exception localException)
    {
      ab.e("MediaCodecThumbFetcher", "getDuration error %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(3682);
    }
    return 0;
  }
  
  public final int getDurationMs()
  {
    AppMethodBeat.i(3681);
    int i = getDuration();
    AppMethodBeat.o(3681);
    return i;
  }
  
  public final Bitmap getFrameAtTime(long paramLong)
  {
    AppMethodBeat.i(3680);
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = this.oLc.getFrameAtTime(1000L * paramLong);
    if (localBitmap2 == null)
    {
      ab.w("MediaCodecThumbFetcher", "get frame fail at time:%s, rawBitmap is null", new Object[] { Long.valueOf(1000L * paramLong) });
      AppMethodBeat.o(3680);
      return null;
    }
    int i = this.oLd;
    int j = this.oLe;
    if ((localBitmap2 == null) || (localBitmap2.isRecycled()) || (i <= 0) || (j <= 0)) {}
    for (Bitmap localBitmap1 = null;; localBitmap1 = null)
    {
      localBitmap2.recycle();
      ab.d("MediaCodecThumbFetcher", "time flee : get video thumb bitmap cost time %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(3680);
      return localBitmap1;
      ab.d("MediaCodecThumbFetcher", "scaleBitmap(60) largeBitmap(width : %d, height : %d)", new Object[] { Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
      localBitmap1 = eG(i, j);
      if (localBitmap1 != null) {
        break;
      }
    }
    int k;
    int m;
    Matrix localMatrix;
    if (this.asO == null)
    {
      k = localBitmap2.getWidth();
      m = localBitmap2.getHeight();
      localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.setTranslate((i - k) / 2.0F, (j - m) / 2.0F);
      if (m / k <= j / i) {
        break label323;
      }
    }
    label323:
    for (float f = i / k;; f = j / m)
    {
      localMatrix.postScale(f, f, i / 2.0F, j / 2.0F);
      this.asO = localMatrix;
      this.aVn.setBitmap(localBitmap1);
      this.aVn.drawBitmap(localBitmap2, this.asO, this.paint);
      break;
    }
  }
  
  public final int getScaledHeight()
  {
    return this.oLe;
  }
  
  public final int getScaledWidth()
  {
    return this.oLd;
  }
  
  public final void init(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(3679);
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      paramString = new IllegalArgumentException(String.format(Locale.CHINA, "destination width and height error, width %d, height %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      AppMethodBeat.o(3679);
      throw paramString;
    }
    try
    {
      this.oLc = new MediaMetadataRetriever();
      this.oLc.setDataSource(paramString);
      this.oLd = paramInt2;
      this.oLe = paramInt3;
      AppMethodBeat.o(3679);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MediaCodecThumbFetcher", paramString, "init error:%s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(3683);
    if (this.oLc != null) {
      this.oLc.release();
    }
    this.asO = null;
    this.paint = null;
    this.aVn = null;
    AppMethodBeat.o(3683);
  }
  
  public final void reuseBitmap(Bitmap paramBitmap)
  {
    this.reuse = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.k
 * JD-Core Version:    0.7.0.1
 */