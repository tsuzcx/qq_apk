package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class MultiSelectContactView$6
  implements Animation.AnimationListener
{
  MultiSelectContactView$6(MultiSelectContactView paramMultiSelectContactView, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.post(new Runnable()
    {
      public final void run()
      {
        MultiSelectContactView.h(MultiSelectContactView.6.this.saw).removeView(MultiSelectContactView.6.this.val$view);
        MultiSelectContactView.i(MultiSelectContactView.6.this.saw);
        MultiSelectContactView.a(MultiSelectContactView.6.this.saw, MultiSelectContactView.h(MultiSelectContactView.6.this.saw).getChildCount());
      }
    });
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.6
 * JD-Core Version:    0.7.0.1
 */