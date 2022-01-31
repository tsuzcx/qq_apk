package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import java.io.ByteArrayOutputStream;

public class li
{
  protected static Paint a;
  private static final String b = Bitmap.class.getCanonicalName();
  
  static
  {
    Paint localPaint = new Paint();
    a = localPaint;
    localPaint.setAntiAlias(true);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
        return paramConfig;
      }
      catch (OutOfMemoryError paramConfig) {}
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    return a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {}
    while (paramFloat == 1.0F) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    localBitmap.eraseColor(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, a);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 > 2048) {
      i = 2048;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > 2048) {
      paramInt1 = 2048;
    }
    Bitmap localBitmap = a(i, paramInt1, Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {
      return null;
    }
    localBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(localBitmap);
    paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    paramBitmap.setBounds(0, 0, i, paramInt1);
    paramBitmap.draw(localCanvas);
    return localBitmap;
  }
  
  public static Bitmap a(View paramView)
  {
    if (paramView != null)
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.setDrawingCacheEnabled(true);
      try
      {
        paramView.buildDrawingCache();
        Bitmap localBitmap = a(paramView.getDrawingCache());
        paramView.destroyDrawingCache();
        return localBitmap;
      }
      catch (NullPointerException paramView) {}
    }
    return null;
  }
  
  public static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.li
 * JD-Core Version:    0.7.0.1
 */