package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.a;

final class ComposeUI$21
  implements View.OnClickListener
{
  ComposeUI$21(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.ngJ, MailAddrListUI.class);
    paramView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(this.ngJ).a(false, null));
    paramView.putExtra("MMActivity.OverrideExitAnimation", b.a.push_down_out);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", b.a.fast_faded_in);
    this.ngJ.startActivityForResult(paramView, 1);
    this.ngJ.overridePendingTransition(b.a.push_up_in, b.a.fast_faded_out);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.21
 * JD-Core Version:    0.7.0.1
 */