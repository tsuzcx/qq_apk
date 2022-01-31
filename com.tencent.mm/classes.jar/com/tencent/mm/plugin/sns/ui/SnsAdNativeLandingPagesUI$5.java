package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsAdNativeLandingPagesUI$5
  implements View.OnClickListener
{
  SnsAdNativeLandingPagesUI$5(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154484);
    if (this.rMW.keyboardState() == 1) {
      this.rMW.hideVKB();
    }
    this.rMW.bdV();
    AppMethodBeat.o(154484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.5
 * JD-Core Version:    0.7.0.1
 */