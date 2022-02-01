package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private static boolean Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141641);
    if (eSr())
    {
      if (paramMotionEvent.getPointerCount() >= 2)
      {
        AppMethodBeat.o(141641);
        return true;
      }
      AppMethodBeat.o(141641);
      return false;
    }
    AppMethodBeat.o(141641);
    return false;
  }
  
  public static void a(PointF paramPointF, Bitmap paramBitmap)
  {
    AppMethodBeat.i(141644);
    if ((paramPointF == null) || (paramBitmap == null))
    {
      AppMethodBeat.o(141644);
      return;
    }
    paramPointF.set(paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    AppMethodBeat.o(141644);
  }
  
  public static void a(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141643);
    if ((paramPointF == null) || (paramMotionEvent == null))
    {
      AppMethodBeat.o(141643);
      return;
    }
    float f1 = d(paramMotionEvent, 0);
    float f2 = d(paramMotionEvent, 1);
    float f3 = e(paramMotionEvent, 0);
    float f4 = e(paramMotionEvent, 1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    AppMethodBeat.o(141643);
  }
  
  public static float aa(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141642);
    float f1 = d(paramMotionEvent, 0) - d(paramMotionEvent, 1);
    float f2 = e(paramMotionEvent, 0) - e(paramMotionEvent, 1);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(141642);
    return f1;
  }
  
  public static int ab(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141647);
    if (eSr())
    {
      new e();
      int i = paramMotionEvent.getPointerCount();
      AppMethodBeat.o(141647);
      return i;
    }
    AppMethodBeat.o(141647);
    return 1;
  }
  
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(141645);
    if (Z(paramMotionEvent))
    {
      new e();
      f = paramMotionEvent.getX(paramInt);
      AppMethodBeat.o(141645);
      return f;
    }
    float f = paramMotionEvent.getX();
    AppMethodBeat.o(141645);
    return f;
  }
  
  public static float e(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(141646);
    if (Z(paramMotionEvent))
    {
      new e();
      f = paramMotionEvent.getY(paramInt);
      AppMethodBeat.o(141646);
      return f;
    }
    float f = paramMotionEvent.getY();
    AppMethodBeat.o(141646);
    return f;
  }
  
  public static void e(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141648);
    if (eSr())
    {
      new e();
      paramKeyEvent.startTracking();
    }
    AppMethodBeat.o(141648);
  }
  
  private static boolean eSr()
  {
    return Build.VERSION.SDK_INT >= 5;
  }
  
  public static boolean f(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141649);
    if (eSr())
    {
      new e();
      boolean bool = paramKeyEvent.isTracking();
      AppMethodBeat.o(141649);
      return bool;
    }
    AppMethodBeat.o(141649);
    return false;
  }
  
  public static boolean g(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141650);
    if (eSr())
    {
      new e();
      boolean bool = paramKeyEvent.isCanceled();
      AppMethodBeat.o(141650);
      return bool;
    }
    AppMethodBeat.o(141650);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.f
 * JD-Core Version:    0.7.0.1
 */