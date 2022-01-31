package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsSightPlayerUI$12
  extends GestureDetector.SimpleOnGestureListener
{
  SnsSightPlayerUI$12(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39266);
    SnsSightPlayerUI.b(this.rVT, true);
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(39266);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(39265);
    paramFloat1 = ((View)SnsSightPlayerUI.g(this.rVT)).getTranslationX();
    paramFloat2 = paramMotionEvent2.getX();
    float f1 = paramMotionEvent1.getX();
    float f2 = ((View)SnsSightPlayerUI.g(this.rVT)).getTranslationY();
    float f3 = paramMotionEvent2.getY();
    float f4 = paramMotionEvent1.getY();
    if (SnsSightPlayerUI.m(this.rVT))
    {
      ((View)SnsSightPlayerUI.g(this.rVT)).setTranslationX(paramFloat1 + paramFloat2 - f1);
      ((View)SnsSightPlayerUI.g(this.rVT)).setTranslationY(f2 + f3 - f4);
    }
    AppMethodBeat.o(39265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.12
 * JD-Core Version:    0.7.0.1
 */