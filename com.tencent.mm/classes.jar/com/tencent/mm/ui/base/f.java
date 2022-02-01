package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
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
    float f1 = j(paramMotionEvent, 0);
    float f2 = j(paramMotionEvent, 1);
    float f3 = k(paramMotionEvent, 0);
    float f4 = k(paramMotionEvent, 1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    AppMethodBeat.o(141643);
  }
  
  private static boolean ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141641);
    if (hJp())
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
  
  public static float aq(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141642);
    float f1 = j(paramMotionEvent, 0) - j(paramMotionEvent, 1);
    float f2 = k(paramMotionEvent, 0) - k(paramMotionEvent, 1);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(141642);
    return f1;
  }
  
  public static int ar(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141647);
    if (hJp())
    {
      new e();
      int i = paramMotionEvent.getPointerCount();
      AppMethodBeat.o(141647);
      return i;
    }
    AppMethodBeat.o(141647);
    return 1;
  }
  
  public static void f(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141648);
    if (hJp())
    {
      new e();
      paramKeyEvent.startTracking();
    }
    AppMethodBeat.o(141648);
  }
  
  public static boolean g(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141649);
    if (hJp())
    {
      new e();
      boolean bool = paramKeyEvent.isTracking();
      AppMethodBeat.o(141649);
      return bool;
    }
    AppMethodBeat.o(141649);
    return false;
  }
  
  public static boolean h(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141650);
    if (hJp())
    {
      new e();
      boolean bool = paramKeyEvent.isCanceled();
      AppMethodBeat.o(141650);
      return bool;
    }
    AppMethodBeat.o(141650);
    return false;
  }
  
  private static boolean hJp()
  {
    return Build.VERSION.SDK_INT >= 5;
  }
  
  public static float j(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(141645);
    if (ap(paramMotionEvent))
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
  
  public static float k(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(141646);
    if (ap(paramMotionEvent))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.f
 * JD-Core Version:    0.7.0.1
 */