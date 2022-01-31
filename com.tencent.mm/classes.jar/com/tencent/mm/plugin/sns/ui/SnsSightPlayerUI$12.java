package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

final class SnsSightPlayerUI$12
  extends GestureDetector.SimpleOnGestureListener
{
  SnsSightPlayerUI$12(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    SnsSightPlayerUI.b(this.pdk, true);
    super.onLongPress(paramMotionEvent);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = ((View)SnsSightPlayerUI.g(this.pdk)).getTranslationX();
    paramFloat2 = paramMotionEvent2.getX();
    float f1 = paramMotionEvent1.getX();
    float f2 = ((View)SnsSightPlayerUI.g(this.pdk)).getTranslationY();
    float f3 = paramMotionEvent2.getY();
    float f4 = paramMotionEvent1.getY();
    if (SnsSightPlayerUI.m(this.pdk))
    {
      ((View)SnsSightPlayerUI.g(this.pdk)).setTranslationX(paramFloat1 + paramFloat2 - f1);
      ((View)SnsSightPlayerUI.g(this.pdk)).setTranslationY(f2 + f3 - f4);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.12
 * JD-Core Version:    0.7.0.1
 */