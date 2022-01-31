package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  implements GestureDetector.OnGestureListener
{
  public k.a AvD;
  private final float AvE;
  private final float AvF;
  private final int Fv;
  private final int Fw;
  public final GestureDetector asq;
  private final Context context;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(107656);
    this.context = paramContext;
    this.asq = new GestureDetector(this.context, this);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.Fv = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.Fw = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.AvE = BackwardSupportUtil.b.b(paramContext, 70.0F);
    this.AvF = BackwardSupportUtil.b.b(paramContext, 50.0F);
    AppMethodBeat.o(107656);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107657);
    if (this.AvD == null)
    {
      AppMethodBeat.o(107657);
      return true;
    }
    ab.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", new Object[] { Float.valueOf(paramMotionEvent1.getX()), Float.valueOf(paramMotionEvent2.getX()), Float.valueOf(paramMotionEvent1.getY()), Float.valueOf(paramMotionEvent2.getY()), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    float f1 = Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY());
    float f2 = Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX());
    if ((f1 < this.AvF) && (paramFloat1 > 800.0F) && (f2 > this.AvE))
    {
      AppMethodBeat.o(107657);
      return true;
    }
    if ((f1 < this.AvF) && (paramFloat1 < -800.0F) && (f2 < -this.AvE))
    {
      AppMethodBeat.o(107657);
      return true;
    }
    if ((f2 < this.AvF) && (paramFloat2 > 800.0F))
    {
      AppMethodBeat.o(107657);
      return true;
    }
    if ((f2 < this.AvF) && (paramFloat2 < -800.0F))
    {
      AppMethodBeat.o(107657);
      return true;
    }
    AppMethodBeat.o(107657);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */