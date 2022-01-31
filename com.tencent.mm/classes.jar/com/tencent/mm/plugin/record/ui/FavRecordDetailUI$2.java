package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class FavRecordDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FavRecordDetailUI$2(FavRecordDetailUI paramFavRecordDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.ntD.mController.uMN, 1, false);
    paramMenuItem.phH = new FavRecordDetailUI.2.1(this);
    paramMenuItem.phI = new FavRecordDetailUI.2.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2
 * JD-Core Version:    0.7.0.1
 */