package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SnsMsgUI$11
  implements MenuItem.OnMenuItemClickListener
{
  SnsMsgUI$11(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.paq.mController.uMN, this.paq.getString(i.j.sns_msg_clear_mgslist), "", new SnsMsgUI.11.1(this), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.11
 * JD-Core Version:    0.7.0.1
 */