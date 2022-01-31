package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class SnsAdNativeLandingPagesUI$2
  implements View.OnClickListener
{
  SnsAdNativeLandingPagesUI$2(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38624);
    paramView = new d(this.rMW, 1, false);
    paramView.sao = new SnsAdNativeLandingPagesUI.2.1(this);
    paramView.vnV = true;
    paramView.sap = new SnsAdNativeLandingPagesUI.2.2(this);
    this.rMW.hideVKB();
    paramView.crd();
    AppMethodBeat.o(38624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.2
 * JD-Core Version:    0.7.0.1
 */