package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  implements GestureDetector.OnGestureListener
{
  public a Lfx;
  private final float Lfy;
  private final float Lfz;
  private final int Ph;
  private final int Pi;
  public final GestureDetector aYl;
  private final Context context;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(143111);
    this.context = paramContext;
    this.aYl = new GestureDetector(this.context, this);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.Ph = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.Pi = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.Lfy = BackwardSupportUtil.b.h(paramContext, 70.0F);
    this.Lfz = BackwardSupportUtil.b.h(paramContext, 50.0F);
    AppMethodBeat.o(143111);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143112);
    if (this.Lfx == null)
    {
      AppMethodBeat.o(143112);
      return true;
    }
    ae.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", new Object[] { Float.valueOf(paramMotionEvent1.getX()), Float.valueOf(paramMotionEvent2.getX()), Float.valueOf(paramMotionEvent1.getY()), Float.valueOf(paramMotionEvent2.getY()), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    float f1 = Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY());
    float f2 = Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX());
    if ((f1 < this.Lfz) && (paramFloat1 > 800.0F) && (f2 > this.Lfy))
    {
      AppMethodBeat.o(143112);
      return true;
    }
    if ((f1 < this.Lfz) && (paramFloat1 < -800.0F) && (f2 < -this.Lfy))
    {
      AppMethodBeat.o(143112);
      return true;
    }
    if ((f2 < this.Lfz) && (paramFloat2 > 800.0F))
    {
      AppMethodBeat.o(143112);
      return true;
    }
    if ((f2 < this.Lfz) && (paramFloat2 < -800.0F))
    {
      AppMethodBeat.o(143112);
      return true;
    }
    AppMethodBeat.o(143112);
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193751);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(193751);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193750);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    a.a(false, this, "com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(193750);
    return false;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */