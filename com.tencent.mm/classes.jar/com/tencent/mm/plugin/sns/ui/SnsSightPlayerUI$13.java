package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class SnsSightPlayerUI$13
  implements View.OnTouchListener
{
  SnsSightPlayerUI$13(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(39267);
    SnsSightPlayerUI.n(this.rVT).onTouchEvent(paramMotionEvent);
    if (SnsSightPlayerUI.o(this.rVT) == null) {
      SnsSightPlayerUI.a(this.rVT, VelocityTracker.obtain());
    }
    SnsSightPlayerUI.o(this.rVT).addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        AppMethodBeat.o(39267);
        return false;
        SnsSightPlayerUI.a(this.rVT, paramMotionEvent.getX());
        SnsSightPlayerUI.b(this.rVT, paramMotionEvent.getY());
        continue;
        if (SnsSightPlayerUI.p(this.rVT))
        {
          ((View)SnsSightPlayerUI.g(this.rVT)).setPivotX(this.rVT.qUt.getWidth() / 2);
          ((View)SnsSightPlayerUI.g(this.rVT)).setPivotY(this.rVT.qUt.getHeight() / 2);
          ((View)SnsSightPlayerUI.g(this.rVT)).setScaleX(1.0F);
          ((View)SnsSightPlayerUI.g(this.rVT)).setScaleY(1.0F);
          ((View)SnsSightPlayerUI.g(this.rVT)).setTranslationX(0.0F);
          ((View)SnsSightPlayerUI.g(this.rVT)).setTranslationY(0.0F);
          paramView = this.rVT;
          if (paramView.contextMenuHelper == null) {
            paramView.contextMenuHelper = new l(paramView.getContext());
          }
          paramView.contextMenuHelper.a((View)paramView.kvG, paramView.rVS, paramView.jWw);
          if (SnsSightPlayerUI.q(this.rVT) != null) {
            SnsSightPlayerUI.q(this.rVT).setVisibility(0);
          }
          SnsSightPlayerUI.c(this.rVT, false);
          SnsSightPlayerUI.b(this.rVT, false);
        }
        else
        {
          if ((SnsSightPlayerUI.m(this.rVT)) && (!SnsSightPlayerUI.r(this.rVT)))
          {
            this.rVT.bdV();
            SnsSightPlayerUI.b(this.rVT, false);
            AppMethodBeat.o(39267);
            return true;
          }
          SnsSightPlayerUI.b(this.rVT, false);
        }
      }
    }
    float f3 = ((View)SnsSightPlayerUI.g(this.rVT)).getTranslationX();
    float f4 = ((View)SnsSightPlayerUI.g(this.rVT)).getTranslationY();
    paramView = SnsSightPlayerUI.o(this.rVT);
    paramView.computeCurrentVelocity(1000);
    int i = (int)paramView.getXVelocity();
    int j = (int)paramView.getYVelocity();
    float f2;
    if (((Math.abs(f3) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsSightPlayerUI.r(this.rVT))) || (SnsSightPlayerUI.m(this.rVT)))
    {
      f2 = 1.0F - f4 / this.rVT.qUt.getHeight();
      if (f2 > 1.0F)
      {
        label515:
        if (((j > 0) && (f1 < SnsSightPlayerUI.s(this.rVT))) || ((j < 0) && (f1 >= 0.5D)))
        {
          SnsSightPlayerUI.a(this.rVT, (int)f3);
          SnsSightPlayerUI.b(this.rVT, (int)f4);
          SnsSightPlayerUI.c(this.rVT, f1);
          if (SnsSightPlayerUI.q(this.rVT) != null) {
            SnsSightPlayerUI.q(this.rVT).setVisibility(8);
          }
          ((View)SnsSightPlayerUI.g(this.rVT)).setPivotX(this.rVT.qUt.getWidth() / 2);
          ((View)SnsSightPlayerUI.g(this.rVT)).setPivotY(this.rVT.qUt.getHeight() / 2);
          ((View)SnsSightPlayerUI.g(this.rVT)).setScaleX(f1);
          ((View)SnsSightPlayerUI.g(this.rVT)).setScaleY(f1);
          SnsSightPlayerUI.t(this.rVT).setAlpha(f1);
        }
        SnsSightPlayerUI.c(this.rVT, true);
        label699:
        if (f4 <= 200.0F) {
          break label802;
        }
        SnsSightPlayerUI.d(this.rVT, false);
      }
    }
    for (;;)
    {
      if (f4 > 50.0F) {
        ((View)SnsSightPlayerUI.g(this.rVT)).setOnLongClickListener(null);
      }
      if (SnsSightPlayerUI.o(this.rVT) != null)
      {
        SnsSightPlayerUI.o(this.rVT).recycle();
        SnsSightPlayerUI.a(this.rVT, null);
      }
      if (!SnsSightPlayerUI.m(this.rVT)) {
        break;
      }
      AppMethodBeat.o(39267);
      return true;
      f1 = f2;
      break label515;
      SnsSightPlayerUI.c(this.rVT, false);
      break label699;
      label802:
      if (f4 > 10.0F) {
        SnsSightPlayerUI.d(this.rVT, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.13
 * JD-Core Version:    0.7.0.1
 */