package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;

final class ac$6
  implements Runnable
{
  ac$6(ac paramac, View paramView) {}
  
  public final void run()
  {
    this.uJv.setVisibility(8);
    this.uJv.startAnimation(AnimationUtils.loadAnimation(this.uPi.getContext(), R.a.fast_faded_out));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ac.6
 * JD-Core Version:    0.7.0.1
 */