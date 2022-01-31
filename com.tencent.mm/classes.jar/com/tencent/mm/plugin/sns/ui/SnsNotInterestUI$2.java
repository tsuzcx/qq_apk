package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsNotInterestUI$2
  implements View.OnClickListener
{
  SnsNotInterestUI$2(SnsNotInterestUI paramSnsNotInterestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39124);
    SnsNotInterestUI.a(this.rTQ).requestFocus();
    this.rTQ.hideVKB();
    AppMethodBeat.o(39124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.2
 * JD-Core Version:    0.7.0.1
 */