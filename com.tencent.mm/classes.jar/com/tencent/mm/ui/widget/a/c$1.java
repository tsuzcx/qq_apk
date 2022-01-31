package com.tencent.mm.ui.widget.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc, c.a.c paramc1, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    if (this.wmL != null) {
      this.wmL.cmH();
    }
    if (this.wmM.isSelected())
    {
      c.b(this.wmN).startAnimation(c.a(this.wmN));
      c.a(this.wmN).setAnimationListener(new c.1.1(this));
      ObjectAnimator.ofFloat(this.wmM, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
      this.wmM.setSelected(false);
      return;
    }
    c.b(this.wmN).startAnimation(c.d(this.wmN));
    c.d(this.wmN).setAnimationListener(new c.1.2(this));
    ObjectAnimator.ofFloat(this.wmM, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
    this.wmM.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c.1
 * JD-Core Version:    0.7.0.1
 */