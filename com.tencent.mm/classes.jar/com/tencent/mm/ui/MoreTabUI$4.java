package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MoreTabUI$4
  implements Runnable
{
  MoreTabUI$4(MoreTabUI paramMoreTabUI, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(33536);
    this.OBn.setVisibility(8);
    this.OBn.startAnimation(AnimationUtils.loadAnimation(this.OJa.getContext(), 2130772060));
    AppMethodBeat.o(33536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.4
 * JD-Core Version:    0.7.0.1
 */