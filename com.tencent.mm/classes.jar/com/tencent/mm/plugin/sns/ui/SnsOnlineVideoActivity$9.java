package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsOnlineVideoActivity$9
  implements View.OnTouchListener
{
  SnsOnlineVideoActivity$9(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(39154);
    SnsOnlineVideoActivity.f(this.rUf).onTouchEvent(paramMotionEvent);
    if (SnsOnlineVideoActivity.g(this.rUf) == null) {
      SnsOnlineVideoActivity.a(this.rUf, VelocityTracker.obtain());
    }
    if (SnsOnlineVideoActivity.g(this.rUf) != null) {
      SnsOnlineVideoActivity.g(this.rUf).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        AppMethodBeat.o(39154);
        return false;
        SnsOnlineVideoActivity.a(this.rUf, paramMotionEvent.getX());
        SnsOnlineVideoActivity.b(this.rUf, paramMotionEvent.getY());
        if (SnsOnlineVideoActivity.h(this.rUf))
        {
          SnsOnlineVideoActivity.i(this.rUf);
          SnsOnlineVideoActivity.c(this.rUf, false);
          continue;
          if (SnsOnlineVideoActivity.h(this.rUf))
          {
            SnsOnlineVideoActivity.d(this.rUf).setPivotX(SnsOnlineVideoActivity.b(this.rUf).getWidth() / 2);
            SnsOnlineVideoActivity.d(this.rUf).setPivotY(SnsOnlineVideoActivity.b(this.rUf).getHeight() / 2);
            SnsOnlineVideoActivity.d(this.rUf).setScaleX(1.0F);
            SnsOnlineVideoActivity.d(this.rUf).setScaleY(1.0F);
            SnsOnlineVideoActivity.d(this.rUf).setTranslationX(0.0F);
            SnsOnlineVideoActivity.d(this.rUf).setTranslationY(0.0F);
            SnsOnlineVideoActivity.j(this.rUf).setAlpha(1.0F);
            SnsOnlineVideoActivity.c(this.rUf, 1.0F);
            SnsOnlineVideoActivity.d(this.rUf, false);
            SnsOnlineVideoActivity.b(this.rUf, false);
            AppMethodBeat.o(39154);
            return true;
          }
          if ((SnsOnlineVideoActivity.c(this.rUf)) && (!SnsOnlineVideoActivity.k(this.rUf)))
          {
            this.rUf.bdV();
            SnsOnlineVideoActivity.b(this.rUf, false);
            AppMethodBeat.o(39154);
            return true;
          }
          SnsOnlineVideoActivity.b(this.rUf, false);
        }
      }
    }
    paramView = SnsOnlineVideoActivity.g(this.rUf);
    paramView.computeCurrentVelocity(1000);
    int i = (int)paramView.getXVelocity();
    int j = (int)paramView.getYVelocity();
    float f2 = SnsOnlineVideoActivity.d(this.rUf).getTranslationX();
    float f3 = SnsOnlineVideoActivity.d(this.rUf).getTranslationY();
    SnsOnlineVideoActivity.a(this.rUf, (int)f2);
    SnsOnlineVideoActivity.b(this.rUf, (int)f3);
    ab.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(this.rUf)), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
    if (((Math.abs(f2) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(this.rUf))) || (SnsOnlineVideoActivity.c(this.rUf)))
    {
      f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(this.rUf).getHeight();
      if (f2 > 1.0F)
      {
        label561:
        if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(this.rUf))) || ((j < 0) && (f1 >= 0.5D)))
        {
          ab.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
          SnsOnlineVideoActivity.c(this.rUf, f1);
          SnsOnlineVideoActivity.d(this.rUf).setPivotX(SnsOnlineVideoActivity.b(this.rUf).getWidth() / 2);
          SnsOnlineVideoActivity.d(this.rUf).setPivotY(SnsOnlineVideoActivity.b(this.rUf).getHeight() / 2);
          SnsOnlineVideoActivity.d(this.rUf).setScaleX(f1);
          SnsOnlineVideoActivity.d(this.rUf).setScaleY(f1);
          SnsOnlineVideoActivity.d(this.rUf).setTranslationY(f3);
          SnsOnlineVideoActivity.j(this.rUf).setAlpha(f1);
        }
        SnsOnlineVideoActivity.d(this.rUf, true);
        label719:
        if (f3 <= 200.0F) {
          break label819;
        }
        SnsOnlineVideoActivity.c(this.rUf, false);
      }
    }
    for (;;)
    {
      if (f3 > 50.0F) {
        SnsOnlineVideoActivity.d(this.rUf).setOnLongClickListener(null);
      }
      if (SnsOnlineVideoActivity.g(this.rUf) != null)
      {
        SnsOnlineVideoActivity.g(this.rUf).recycle();
        SnsOnlineVideoActivity.a(this.rUf, null);
      }
      if (!SnsOnlineVideoActivity.c(this.rUf)) {
        break;
      }
      AppMethodBeat.o(39154);
      return true;
      f1 = f2;
      break label561;
      SnsOnlineVideoActivity.d(this.rUf, false);
      break label719;
      label819:
      if (f3 > 10.0F) {
        SnsOnlineVideoActivity.c(this.rUf, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.9
 * JD-Core Version:    0.7.0.1
 */