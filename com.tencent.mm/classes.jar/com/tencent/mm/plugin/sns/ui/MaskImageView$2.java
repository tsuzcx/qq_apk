package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class MaskImageView$2
  implements View.OnTouchListener
{
  MaskImageView$2(MaskImageView paramMaskImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!MaskImageView.a(this.oQE)) {
      return false;
    }
    return this.oQE.d(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskImageView.2
 * JD-Core Version:    0.7.0.1
 */