package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  implements GestureDetector.OnGestureListener
{
  private final int EM;
  private final int EN;
  public final GestureDetector apX;
  private final Context context;
  public i.a wcW;
  private final float wcX;
  private final float wcY;
  
  public i(Context paramContext)
  {
    this.context = paramContext;
    this.apX = new GestureDetector(this.context, this);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.EM = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.EN = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.wcX = BackwardSupportUtil.b.b(paramContext, 70.0F);
    this.wcY = BackwardSupportUtil.b.b(paramContext, 50.0F);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.wcW == null) {}
    float f1;
    float f2;
    do
    {
      return true;
      y.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", new Object[] { Float.valueOf(paramMotionEvent1.getX()), Float.valueOf(paramMotionEvent2.getX()), Float.valueOf(paramMotionEvent1.getY()), Float.valueOf(paramMotionEvent2.getY()), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      f1 = Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY());
      f2 = Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX());
    } while (((f1 < this.wcY) && (paramFloat1 > 800.0F) && (f2 > this.wcX)) || ((f1 < this.wcY) && (paramFloat1 < -800.0F) && (f2 < -this.wcX)) || ((f2 < this.wcY) && (paramFloat2 > 800.0F)) || ((f2 < this.wcY) && (paramFloat2 < -800.0F)));
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */