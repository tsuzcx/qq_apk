package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class SnsAdNativeLandingTestUI$1
  implements View.OnClickListener
{
  SnsAdNativeLandingTestUI$1(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38702);
    paramView = new Intent();
    paramView.putExtra("Select_Conv_Type", 259);
    paramView.putExtra("select_is_ret", true);
    d.a(this.rNi, ".ui.transmit.SelectConversationUI", paramView, 0, new SnsAdNativeLandingTestUI.1.1(this));
    AppMethodBeat.o(38702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1
 * JD-Core Version:    0.7.0.1
 */