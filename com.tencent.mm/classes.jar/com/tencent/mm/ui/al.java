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

public final class al
{
  public static Bitmap c(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(159110);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      an.e("WeUIBitmapUtil", "getRoundedCornerBitmap in bitmap is null", new Object[0]);
      AppMethodBeat.o(159110);
      return null;
    }
    Bitmap localBitmap = j(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null)
    {
      AppMethodBeat.o(159110);
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
    an.i("WeUIBitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    AppMethodBeat.o(159110);
    return localBitmap;
  }
  
  private static Bitmap j(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(159111);
    Object localObject = null;
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      AppMethodBeat.o(159111);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.al
 * JD-Core Version:    0.7.0.1
 */