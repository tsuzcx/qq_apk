package com.tencent.mm.plugin.nearby.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class NearbySayHiListUI$5
  implements MenuItem.OnMenuItemClickListener
{
  NearbySayHiListUI$5(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.mDP.mController.uMN, true, this.mDP.getResources().getString(b.h.say_hi_clean_all_title), "", this.mDP.getResources().getString(b.h.say_hi_clean_all_btn), this.mDP.getString(b.h.app_cancel), new NearbySayHiListUI.5.1(this), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.5
 * JD-Core Version:    0.7.0.1
 */