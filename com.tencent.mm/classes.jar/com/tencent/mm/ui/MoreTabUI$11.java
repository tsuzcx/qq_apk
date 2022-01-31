package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MoreTabUI$11
  implements Runnable
{
  MoreTabUI$11(MoreTabUI paramMoreTabUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(29713);
    this.yWT.setVisibility(8);
    this.yWT.startAnimation(AnimationUtils.loadAnimation(this.zdu.getContext(), 2131034182));
    AppMethodBeat.o(29713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.11
 * JD-Core Version:    0.7.0.1
 */