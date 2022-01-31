package com.tencent.mm.plugin.sight.decode.ui;

import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.ai.a.a;

final class c$1$2
  implements Runnable
{
  c$1$2(c.1 param1) {}
  
  public final void run()
  {
    c.d(this.ofX.ofW).setVisibility(0);
    c.d(this.ofX.ofW).startAnimation(AnimationUtils.loadAnimation(this.ofX.ofW.getContext(), a.a.fast_faded_in));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c.1.2
 * JD-Core Version:    0.7.0.1
 */