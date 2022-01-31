package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ShakeMsgListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShakeMsgListUI$2(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.obT.mController.uMN, true, this.obT.getString(R.l.shake_msg_list_clear_confirm), "", this.obT.getString(R.l.say_hi_clean_all_btn), this.obT.getString(R.l.app_cancel), new ShakeMsgListUI.2.1(this), new ShakeMsgListUI.2.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.2
 * JD-Core Version:    0.7.0.1
 */