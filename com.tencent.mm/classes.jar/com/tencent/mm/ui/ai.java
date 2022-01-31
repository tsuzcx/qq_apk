package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
{
  private static Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(112469);
    Object localObject = null;
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      AppMethodBeat.o(112469);
      return paramConfig;
    }
    catch (Throwable paramConfig)
    {
      for (;;)
      {
        paramConfig = localObject;
      }
    }
  }
  
  public static Bitmap d(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(112468);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ak.e("WeUIBitmapUtil", "getRoundedCornerBitmap in bitmap is null", new Object[0]);
      AppMethodBeat.o(112468);
      return null;
    }
    Bitmap localBitmap = b(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null)
    {
      AppMethodBeat.o(112468);
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    ak.i("WeUIBitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    AppMethodBeat.o(112468);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ai
 * JD-Core Version:    0.7.0.1
 */