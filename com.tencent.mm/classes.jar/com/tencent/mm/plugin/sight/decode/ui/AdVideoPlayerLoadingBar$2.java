package com.tencent.mm.plugin.sight.decode.ui;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

final class AdVideoPlayerLoadingBar$2
  implements Runnable
{
  AdVideoPlayerLoadingBar$2(AdVideoPlayerLoadingBar paramAdVideoPlayerLoadingBar) {}
  
  public final void run()
  {
    int i = (this.ofC.getBarPointWidth() - this.ofC.ofq.getPaddingLeft() - this.ofC.ofq.getPaddingRight()) / 2;
    int j = ((FrameLayout.LayoutParams)this.ofC.ofp.getLayoutParams()).leftMargin;
    int k = this.ofC.ofq.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ofC.ofq.getLayoutParams();
    localLayoutParams.leftMargin = (j - k - i);
    this.ofC.ofq.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.2
 * JD-Core Version:    0.7.0.1
 */