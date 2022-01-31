package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ShakeSayHiListUI$3
  implements MenuItem.OnMenuItemClickListener
{
  ShakeSayHiListUI$3(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.odv.mController.uMN, true, this.odv.getString(R.l.say_hi_clean_all_title), "", this.odv.getString(R.l.say_hi_clean_all_btn), this.odv.getString(R.l.app_cancel), new ShakeSayHiListUI.3.1(this), new ShakeSayHiListUI.3.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.3
 * JD-Core Version:    0.7.0.1
 */