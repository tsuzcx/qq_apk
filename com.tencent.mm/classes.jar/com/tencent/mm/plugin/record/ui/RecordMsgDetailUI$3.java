package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class RecordMsgDetailUI$3
  implements MenuItem.OnMenuItemClickListener
{
  RecordMsgDetailUI$3(RecordMsgDetailUI paramRecordMsgDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.ntZ.mController.uMN, 1, false);
    paramMenuItem.phH = new RecordMsgDetailUI.3.1(this);
    paramMenuItem.phI = new RecordMsgDetailUI.3.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3
 * JD-Core Version:    0.7.0.1
 */