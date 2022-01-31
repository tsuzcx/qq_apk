package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$9
  implements View.OnClickListener
{
  ShakeReportUI$9(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24786);
    paramView = new Intent(this.qRs, ShakeMsgListUI.class);
    paramView.putExtra("shake_msg_from", 1);
    paramView.putExtra("shake_msg_list_title", this.qRs.getString(2131303655));
    this.qRs.startActivity(paramView);
    AppMethodBeat.o(24786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.9
 * JD-Core Version:    0.7.0.1
 */