package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ShakeTvHistoryListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShakeTvHistoryListUI$2(ShakeTvHistoryListUI paramShakeTvHistoryListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.odz.mController.uMN, true, this.odz.getString(R.l.shake_tv_history_list_clear_confirm), "", this.odz.getString(R.l.say_hi_clean_all_btn), this.odz.getString(R.l.app_cancel), new ShakeTvHistoryListUI.2.1(this), new ShakeTvHistoryListUI.2.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.2
 * JD-Core Version:    0.7.0.1
 */