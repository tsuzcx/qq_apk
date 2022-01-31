package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$22
  implements View.OnClickListener
{
  ComposeUI$22(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68205);
    paramView = new Intent(this.pLX, MailAddrListUI.class);
    paramView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.f(this.pLX).a(false, null));
    paramView.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    this.pLX.startActivityForResult(paramView, 2);
    this.pLX.overridePendingTransition(2131034230, 2131034182);
    AppMethodBeat.o(68205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.22
 * JD-Core Version:    0.7.0.1
 */