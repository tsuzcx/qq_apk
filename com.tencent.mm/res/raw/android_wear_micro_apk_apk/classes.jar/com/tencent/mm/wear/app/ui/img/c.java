package com.tencent.mm.wear.app.ui.img;

import android.graphics.drawable.Drawable;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.wear.app.ui.MMActivity;

final class c
  extends GestureDetector.SimpleOnGestureListener
{
  private c(DetailImgUI paramDetailImgUI) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    if (DetailImgUI.a(this.aga).getDrawable() == null) {
      return false;
    }
    paramFloat1 = DetailImgUI.a(this.aga).getScrollX() + paramFloat1;
    float f1 = DetailImgUI.a(this.aga).getDrawable().getIntrinsicWidth() * DetailImgUI.a(this.aga).np() - MMActivity.nc();
    if (f1 > 0.0F)
    {
      if (paramFloat1 <= f1) {
        break label197;
      }
      paramFloat1 = f1;
    }
    label191:
    label197:
    for (;;)
    {
      f1 = paramFloat1;
      if (paramFloat1 < 0.0F) {
        f1 = 0.0F;
      }
      paramFloat2 = DetailImgUI.a(this.aga).getScrollY() + paramFloat2;
      float f3 = DetailImgUI.a(this.aga).getDrawable().getIntrinsicHeight() * DetailImgUI.a(this.aga).np() - MMActivity.nb();
      paramFloat1 = f2;
      if (f3 > 0.0F) {
        if (paramFloat2 <= f3) {
          break label191;
        }
      }
      for (paramFloat1 = f3;; paramFloat1 = paramFloat2)
      {
        if (paramFloat1 < 0.0F) {
          paramFloat1 = f2;
        }
        for (;;)
        {
          DetailImgUI.a(this.aga).scrollTo((int)f1, (int)paramFloat1);
          return true;
        }
      }
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.aga.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.img.c
 * JD-Core Version:    0.7.0.1
 */