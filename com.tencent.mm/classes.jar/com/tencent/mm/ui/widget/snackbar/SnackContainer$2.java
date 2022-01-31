package com.tencent.mm.ui.widget.snackbar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.Queue;

final class SnackContainer$2
  implements Animation.AnimationListener
{
  SnackContainer$2(SnackContainer paramSnackContainer) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.wqa.removeAllViews();
    if (!SnackContainer.b(this.wqa).isEmpty()) {
      SnackContainer.c((SnackContainer.a)SnackContainer.b(this.wqa).poll());
    }
    if (!this.wqa.isEmpty())
    {
      SnackContainer.a(this.wqa, (SnackContainer.a)SnackContainer.b(this.wqa).peek());
      return;
    }
    this.wqa.setVisibility(8);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    if ((!this.wqa.isEmpty()) && (SnackContainer.b(this.wqa).peek() != null) && (((SnackContainer.a)SnackContainer.b(this.wqa).peek()).wqg != null))
    {
      b.nZ(false);
      ((SnackContainer.a)SnackContainer.b(this.wqa).peek()).wqg.bSd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.2
 * JD-Core Version:    0.7.0.1
 */