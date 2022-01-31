package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$21
  implements View.OnClickListener
{
  ComposeUI$21(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68204);
    paramView = new Intent(this.pLX, MailAddrListUI.class);
    paramView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(this.pLX).a(false, null));
    paramView.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    this.pLX.startActivityForResult(paramView, 1);
    this.pLX.overridePendingTransition(2131034230, 2131034182);
    AppMethodBeat.o(68204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.21
 * JD-Core Version:    0.7.0.1
 */