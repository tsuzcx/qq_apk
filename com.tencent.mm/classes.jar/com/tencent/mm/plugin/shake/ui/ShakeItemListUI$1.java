package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class ShakeItemListUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShakeItemListUI$1(ShakeItemListUI paramShakeItemListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.obE, true, this.obE.getString(R.l.say_hi_clean_all_title), "", this.obE.getString(R.l.app_clear), this.obE.getString(R.l.app_cancel), new ShakeItemListUI.1.1(this), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1
 * JD-Core Version:    0.7.0.1
 */