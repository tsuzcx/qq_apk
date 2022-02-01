package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MoreTabUI$3
  implements Runnable
{
  MoreTabUI$3(MoreTabUI paramMoreTabUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(33535);
    this.IWz.setVisibility(8);
    this.IWz.startAnimation(AnimationUtils.loadAnimation(this.JdT.getContext(), 2130772048));
    AppMethodBeat.o(33535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.3
 * JD-Core Version:    0.7.0.1
 */