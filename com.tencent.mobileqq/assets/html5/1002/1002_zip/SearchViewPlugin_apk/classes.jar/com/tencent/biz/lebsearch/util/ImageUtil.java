package com.tencent.biz.lebsearch.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class ImageUtil
{
  public static Bitmap round(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = null;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Paint localPaint;
          Rect localRect;
          RectF localRectF;
          localOutOfMemoryError.printStackTrace();
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    Object localObject2 = new Canvas(localObject1);
    localPaint = new Paint();
    localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localObject1;
  }
  
  public static Drawable round(Drawable paramDrawable, float paramFloat)
  {
    if (paramDrawable == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramDrawable;
    } while (paramFloat <= 0.0F);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      return new BitmapDrawable(round((Bitmap)localObject, paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */