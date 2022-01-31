package com.tencent.mm.plugin.sight.decode.ui;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AdVideoPlayerLoadingBar$2
  implements Runnable
{
  AdVideoPlayerLoadingBar$2(AdVideoPlayerLoadingBar paramAdVideoPlayerLoadingBar) {}
  
  public final void run()
  {
    AppMethodBeat.i(117916);
    int i = (this.qTQ.getBarPointWidth() - this.qTQ.qTE.getPaddingLeft() - this.qTQ.qTE.getPaddingRight()) / 2;
    int j = ((FrameLayout.LayoutParams)this.qTQ.qTD.getLayoutParams()).leftMargin;
    int k = this.qTQ.qTE.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTQ.qTE.getLayoutParams();
    localLayoutParams.leftMargin = (j - k - i);
    this.qTQ.qTE.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(117916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.2
 * JD-Core Version:    0.7.0.1
 */