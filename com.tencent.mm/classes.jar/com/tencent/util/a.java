package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public final class a
{
  private static final float[] tz = new float[16];
  private static final String[] xct = { "orientation" };
  private static final String[] xcu = { "_data" };
  private static final float[] xcv = new float[32];
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    Object localObject2 = null;
    Canvas localCanvas = new Canvas();
    Object localObject1;
    if (paramMatrix.isIdentity()) {
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
    }
    for (;;)
    {
      ((Bitmap)localObject1).setDensity(paramBitmap.getDensity());
      localCanvas.setBitmap((Bitmap)localObject1);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramInt1 + 0, paramInt2 + 0), new RectF(0.0F, 0.0F, paramInt1, paramInt2), (Paint)localObject2);
      return localObject1;
      localObject1 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
      paramMatrix.mapRect((RectF)localObject1);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(Math.round(((RectF)localObject1).width()), Math.round(((RectF)localObject1).height()), paramBitmap.getConfig());
        localCanvas.translate(-((RectF)localObject1).left, -((RectF)localObject1).top);
        localCanvas.concat(paramMatrix);
        Paint localPaint = new Paint(2);
        localObject2 = localPaint;
        localObject1 = localBitmap;
        if (!paramMatrix.rectStaysRect())
        {
          localPaint.setAntiAlias(true);
          localObject2 = localPaint;
          localObject1 = localBitmap;
        }
      }
      catch (OutOfMemoryError paramBitmap) {}
    }
    return null;
  }
  
  public static Bitmap e(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    j = 1;
    l = System.currentTimeMillis();
    k = paramBitmap.getWidth();
    m = paramBitmap.getHeight();
    i = 0;
    try
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Bitmap localBitmap1;
      for (;;)
      {
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
          Object localObject = localBitmap2;
          i = j;
          if ((i != 0) && (localObject != null)) {
            break;
          }
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localBitmap1 = null;
      }
      Canvas localCanvas = new Canvas(localBitmap1);
      localCanvas.translate((paramInt1 - k) / 2, (paramInt2 - m) / 2);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
      g.h("BitmapUtils", "crop bitmap - " + (System.currentTimeMillis() - l));
      return localBitmap1;
    }
    if (i != 0) {}
  }
  
  public static boolean recycle(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.util.a
 * JD-Core Version:    0.7.0.1
 */