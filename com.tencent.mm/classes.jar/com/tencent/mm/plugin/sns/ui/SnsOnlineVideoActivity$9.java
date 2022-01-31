package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;

final class SnsOnlineVideoActivity$9
  implements View.OnTouchListener
{
  SnsOnlineVideoActivity$9(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    SnsOnlineVideoActivity.f(this.pbr).onTouchEvent(paramMotionEvent);
    if (SnsOnlineVideoActivity.g(this.pbr) == null) {
      SnsOnlineVideoActivity.a(this.pbr, VelocityTracker.obtain());
    }
    if (SnsOnlineVideoActivity.g(this.pbr) != null) {
      SnsOnlineVideoActivity.g(this.pbr).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        return false;
        SnsOnlineVideoActivity.a(this.pbr, paramMotionEvent.getX());
        SnsOnlineVideoActivity.b(this.pbr, paramMotionEvent.getY());
        if (SnsOnlineVideoActivity.h(this.pbr))
        {
          SnsOnlineVideoActivity.i(this.pbr);
          SnsOnlineVideoActivity.c(this.pbr, false);
          continue;
          if (SnsOnlineVideoActivity.h(this.pbr))
          {
            SnsOnlineVideoActivity.d(this.pbr).setPivotX(SnsOnlineVideoActivity.b(this.pbr).getWidth() / 2);
            SnsOnlineVideoActivity.d(this.pbr).setPivotY(SnsOnlineVideoActivity.b(this.pbr).getHeight() / 2);
            SnsOnlineVideoActivity.d(this.pbr).setScaleX(1.0F);
            SnsOnlineVideoActivity.d(this.pbr).setScaleY(1.0F);
            SnsOnlineVideoActivity.d(this.pbr).setTranslationX(0.0F);
            SnsOnlineVideoActivity.d(this.pbr).setTranslationY(0.0F);
            SnsOnlineVideoActivity.j(this.pbr).setAlpha(1.0F);
            SnsOnlineVideoActivity.c(this.pbr, 1.0F);
            SnsOnlineVideoActivity.d(this.pbr, false);
            SnsOnlineVideoActivity.b(this.pbr, false);
            return true;
          }
          if ((SnsOnlineVideoActivity.c(this.pbr)) && (!SnsOnlineVideoActivity.k(this.pbr)))
          {
            this.pbr.aBR();
            SnsOnlineVideoActivity.b(this.pbr, false);
            return true;
          }
          SnsOnlineVideoActivity.b(this.pbr, false);
        }
      }
    }
    paramView = SnsOnlineVideoActivity.g(this.pbr);
    paramView.computeCurrentVelocity(1000);
    int i = (int)paramView.getXVelocity();
    int j = (int)paramView.getYVelocity();
    float f2 = SnsOnlineVideoActivity.d(this.pbr).getTranslationX();
    float f3 = SnsOnlineVideoActivity.d(this.pbr).getTranslationY();
    SnsOnlineVideoActivity.a(this.pbr, (int)f2);
    SnsOnlineVideoActivity.b(this.pbr, (int)f3);
    y.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(this.pbr)), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
    if (((Math.abs(f2) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(this.pbr))) || (SnsOnlineVideoActivity.c(this.pbr)))
    {
      f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(this.pbr).getHeight();
      if (f2 > 1.0F)
      {
        label542:
        if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(this.pbr))) || ((j < 0) && (f1 >= 0.5D)))
        {
          y.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
          SnsOnlineVideoActivity.c(this.pbr, f1);
          SnsOnlineVideoActivity.d(this.pbr).setPivotX(SnsOnlineVideoActivity.b(this.pbr).getWidth() / 2);
          SnsOnlineVideoActivity.d(this.pbr).setPivotY(SnsOnlineVideoActivity.b(this.pbr).getHeight() / 2);
          SnsOnlineVideoActivity.d(this.pbr).setScaleX(f1);
          SnsOnlineVideoActivity.d(this.pbr).setScaleY(f1);
          SnsOnlineVideoActivity.d(this.pbr).setTranslationY(f3);
          SnsOnlineVideoActivity.j(this.pbr).setAlpha(f1);
        }
        SnsOnlineVideoActivity.d(this.pbr, true);
        label700:
        if (f3 <= 200.0F) {
          break label795;
        }
        SnsOnlineVideoActivity.c(this.pbr, false);
      }
    }
    for (;;)
    {
      if (f3 > 50.0F) {
        SnsOnlineVideoActivity.d(this.pbr).setOnLongClickListener(null);
      }
      if (SnsOnlineVideoActivity.g(this.pbr) != null)
      {
        SnsOnlineVideoActivity.g(this.pbr).recycle();
        SnsOnlineVideoActivity.a(this.pbr, null);
      }
      if (!SnsOnlineVideoActivity.c(this.pbr)) {
        break;
      }
      return true;
      f1 = f2;
      break label542;
      SnsOnlineVideoActivity.d(this.pbr, false);
      break label700;
      label795:
      if (f3 > 10.0F) {
        SnsOnlineVideoActivity.c(this.pbr, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.9
 * JD-Core Version:    0.7.0.1
 */