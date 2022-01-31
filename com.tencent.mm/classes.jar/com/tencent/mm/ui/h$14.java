package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;

final class h$14
  implements Runnable
{
  h$14(h paramh, View paramView) {}
  
  public final void run()
  {
    this.uJv.setVisibility(8);
    this.uJv.startAnimation(AnimationUtils.loadAnimation(this.uJi.getContext(), R.a.fast_faded_out));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.h.14
 * JD-Core Version:    0.7.0.1
 */