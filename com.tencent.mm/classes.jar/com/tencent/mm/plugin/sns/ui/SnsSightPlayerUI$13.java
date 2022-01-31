package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;

final class SnsSightPlayerUI$13
  implements View.OnTouchListener
{
  SnsSightPlayerUI$13(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    SnsSightPlayerUI.n(this.pdk).onTouchEvent(paramMotionEvent);
    if (SnsSightPlayerUI.o(this.pdk) == null) {
      SnsSightPlayerUI.a(this.pdk, VelocityTracker.obtain());
    }
    SnsSightPlayerUI.o(this.pdk).addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        return false;
        SnsSightPlayerUI.a(this.pdk, paramMotionEvent.getX());
        SnsSightPlayerUI.b(this.pdk, paramMotionEvent.getY());
        continue;
        if (SnsSightPlayerUI.p(this.pdk))
        {
          ((View)SnsSightPlayerUI.g(this.pdk)).setPivotX(this.pdk.oge.getWidth() / 2);
          ((View)SnsSightPlayerUI.g(this.pdk)).setPivotY(this.pdk.oge.getHeight() / 2);
          ((View)SnsSightPlayerUI.g(this.pdk)).setScaleX(1.0F);
          ((View)SnsSightPlayerUI.g(this.pdk)).setScaleY(1.0F);
          ((View)SnsSightPlayerUI.g(this.pdk)).setTranslationX(0.0F);
          ((View)SnsSightPlayerUI.g(this.pdk)).setTranslationY(0.0F);
          paramView = this.pdk;
          if (paramView.contextMenuHelper == null) {
            paramView.contextMenuHelper = new j(paramView.mController.uMN);
          }
          paramView.contextMenuHelper.a((View)paramView.iuC, paramView.pdj, paramView.ifj);
          if (SnsSightPlayerUI.q(this.pdk) != null) {
            SnsSightPlayerUI.q(this.pdk).setVisibility(0);
          }
          SnsSightPlayerUI.c(this.pdk, false);
          SnsSightPlayerUI.b(this.pdk, false);
        }
        else
        {
          if ((SnsSightPlayerUI.m(this.pdk)) && (!SnsSightPlayerUI.r(this.pdk)))
          {
            this.pdk.aBR();
            SnsSightPlayerUI.b(this.pdk, false);
            return true;
          }
          SnsSightPlayerUI.b(this.pdk, false);
        }
      }
    }
    float f3 = ((View)SnsSightPlayerUI.g(this.pdk)).getTranslationX();
    float f4 = ((View)SnsSightPlayerUI.g(this.pdk)).getTranslationY();
    paramView = SnsSightPlayerUI.o(this.pdk);
    paramView.computeCurrentVelocity(1000);
    int i = (int)paramView.getXVelocity();
    int j = (int)paramView.getYVelocity();
    float f2;
    if (((Math.abs(f3) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsSightPlayerUI.r(this.pdk))) || (SnsSightPlayerUI.m(this.pdk)))
    {
      f2 = 1.0F - f4 / this.pdk.oge.getHeight();
      if (f2 > 1.0F)
      {
        label504:
        if (((j > 0) && (f1 < SnsSightPlayerUI.s(this.pdk))) || ((j < 0) && (f1 >= 0.5D)))
        {
          SnsSightPlayerUI.a(this.pdk, (int)f3);
          SnsSightPlayerUI.b(this.pdk, (int)f4);
          SnsSightPlayerUI.c(this.pdk, f1);
          if (SnsSightPlayerUI.q(this.pdk) != null) {
            SnsSightPlayerUI.q(this.pdk).setVisibility(8);
          }
          ((View)SnsSightPlayerUI.g(this.pdk)).setPivotX(this.pdk.oge.getWidth() / 2);
          ((View)SnsSightPlayerUI.g(this.pdk)).setPivotY(this.pdk.oge.getHeight() / 2);
          ((View)SnsSightPlayerUI.g(this.pdk)).setScaleX(f1);
          ((View)SnsSightPlayerUI.g(this.pdk)).setScaleY(f1);
          SnsSightPlayerUI.t(this.pdk).setAlpha(f1);
        }
        SnsSightPlayerUI.c(this.pdk, true);
        label688:
        if (f4 <= 200.0F) {
          break label786;
        }
        SnsSightPlayerUI.d(this.pdk, false);
      }
    }
    for (;;)
    {
      if (f4 > 50.0F) {
        ((View)SnsSightPlayerUI.g(this.pdk)).setOnLongClickListener(null);
      }
      if (SnsSightPlayerUI.o(this.pdk) != null)
      {
        SnsSightPlayerUI.o(this.pdk).recycle();
        SnsSightPlayerUI.a(this.pdk, null);
      }
      if (!SnsSightPlayerUI.m(this.pdk)) {
        break;
      }
      return true;
      f1 = f2;
      break label504;
      SnsSightPlayerUI.c(this.pdk, false);
      break label688;
      label786:
      if (f4 > 10.0F) {
        SnsSightPlayerUI.d(this.pdk, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.13
 * JD-Core Version:    0.7.0.1
 */