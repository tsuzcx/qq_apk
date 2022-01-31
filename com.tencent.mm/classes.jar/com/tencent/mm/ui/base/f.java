package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private static boolean R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106277);
    if (dDB())
    {
      if (paramMotionEvent.getPointerCount() >= 2)
      {
        AppMethodBeat.o(106277);
        return true;
      }
      AppMethodBeat.o(106277);
      return false;
    }
    AppMethodBeat.o(106277);
    return false;
  }
  
  public static float S(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106278);
    float f1 = c(paramMotionEvent, 0) - c(paramMotionEvent, 1);
    float f2 = d(paramMotionEvent, 0) - d(paramMotionEvent, 1);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(106278);
    return f1;
  }
  
  public static int T(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106283);
    if (dDB())
    {
      new e();
      int i = paramMotionEvent.getPointerCount();
      AppMethodBeat.o(106283);
      return i;
    }
    AppMethodBeat.o(106283);
    return 1;
  }
  
  public static void a(PointF paramPointF, Bitmap paramBitmap)
  {
    AppMethodBeat.i(106280);
    if ((paramPointF == null) || (paramBitmap == null))
    {
      AppMethodBeat.o(106280);
      return;
    }
    paramPointF.set(paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    AppMethodBeat.o(106280);
  }
  
  public static void a(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106279);
    if ((paramPointF == null) || (paramMotionEvent == null))
    {
      AppMethodBeat.o(106279);
      return;
    }
    float f1 = c(paramMotionEvent, 0);
    float f2 = c(paramMotionEvent, 1);
    float f3 = d(paramMotionEvent, 0);
    float f4 = d(paramMotionEvent, 1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    AppMethodBeat.o(106279);
  }
  
  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(106281);
    if (R(paramMotionEvent))
    {
      new e();
      f = paramMotionEvent.getX(paramInt);
      AppMethodBeat.o(106281);
      return f;
    }
    float f = paramMotionEvent.getX();
    AppMethodBeat.o(106281);
    return f;
  }
  
  public static void c(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106284);
    if (dDB())
    {
      new e();
      paramKeyEvent.startTracking();
    }
    AppMethodBeat.o(106284);
  }
  
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(106282);
    if (R(paramMotionEvent))
    {
      new e();
      f = paramMotionEvent.getY(paramInt);
      AppMethodBeat.o(106282);
      return f;
    }
    float f = paramMotionEvent.getY();
    AppMethodBeat.o(106282);
    return f;
  }
  
  public static boolean d(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106285);
    if (dDB())
    {
      new e();
      boolean bool = paramKeyEvent.isTracking();
      AppMethodBeat.o(106285);
      return bool;
    }
    AppMethodBeat.o(106285);
    return false;
  }
  
  public static boolean dDB()
  {
    return Build.VERSION.SDK_INT >= 5;
  }
  
  public static boolean e(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106286);
    if (dDB())
    {
      new e();
      boolean bool = paramKeyEvent.isCanceled();
      AppMethodBeat.o(106286);
      return bool;
    }
    AppMethodBeat.o(106286);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.f
 * JD-Core Version:    0.7.0.1
 */