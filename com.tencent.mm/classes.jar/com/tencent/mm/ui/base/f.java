package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;

public final class f
{
  private static boolean H(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (cAr())
    {
      bool1 = bool2;
      if (paramMotionEvent.getPointerCount() >= 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static float I(MotionEvent paramMotionEvent)
  {
    float f1 = c(paramMotionEvent, 0) - c(paramMotionEvent, 1);
    float f2 = d(paramMotionEvent, 0) - d(paramMotionEvent, 1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static int J(MotionEvent paramMotionEvent)
  {
    if (cAr())
    {
      new e();
      return paramMotionEvent.getPointerCount();
    }
    return 1;
  }
  
  public static void a(PointF paramPointF, Bitmap paramBitmap)
  {
    if ((paramPointF == null) || (paramBitmap == null)) {
      return;
    }
    paramPointF.set(paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
  }
  
  public static void a(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    if ((paramPointF == null) || (paramMotionEvent == null)) {
      return;
    }
    float f1 = c(paramMotionEvent, 0);
    float f2 = c(paramMotionEvent, 1);
    float f3 = d(paramMotionEvent, 0);
    float f4 = d(paramMotionEvent, 1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
  }
  
  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    if (H(paramMotionEvent))
    {
      new e();
      return paramMotionEvent.getX(paramInt);
    }
    return paramMotionEvent.getX();
  }
  
  public static void c(KeyEvent paramKeyEvent)
  {
    if (cAr())
    {
      new e();
      paramKeyEvent.startTracking();
    }
  }
  
  public static boolean cAr()
  {
    return Build.VERSION.SDK_INT >= 5;
  }
  
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    if (H(paramMotionEvent))
    {
      new e();
      return paramMotionEvent.getY(paramInt);
    }
    return paramMotionEvent.getY();
  }
  
  public static boolean d(KeyEvent paramKeyEvent)
  {
    if (cAr())
    {
      new e();
      return paramKeyEvent.isTracking();
    }
    return false;
  }
  
  public static boolean e(KeyEvent paramKeyEvent)
  {
    if (cAr())
    {
      new e();
      return paramKeyEvent.isCanceled();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.f
 * JD-Core Version:    0.7.0.1
 */