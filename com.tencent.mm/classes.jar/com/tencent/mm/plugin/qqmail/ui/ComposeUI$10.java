package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ComposeUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ComposeUI$10(ComposeUI paramComposeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (((ComposeUI.a(this.ngJ, false)) && (ComposeUI.a(this.ngJ) == 5)) || (ComposeUI.a(this.ngJ) == 6)) {
      h.a(this.ngJ.mController.uMN, this.ngJ.getString(b.j.plugin_qqmail_composeui_leave_alert), "", this.ngJ.getString(b.j.plugin_qqmail_composeui_quit_delete), this.ngJ.getString(b.j.app_cancel), new ComposeUI.10.1(this), null);
    }
    for (;;)
    {
      return true;
      this.ngJ.setResult(0);
      this.ngJ.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.10
 * JD-Core Version:    0.7.0.1
 */