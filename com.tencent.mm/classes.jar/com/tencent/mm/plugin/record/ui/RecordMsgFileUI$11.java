package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class RecordMsgFileUI$11
  implements MenuItem.OnMenuItemClickListener
{
  RecordMsgFileUI$11(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.nue.mController.uMN, 1, false);
    paramMenuItem.phH = new RecordMsgFileUI.11.1(this);
    paramMenuItem.phI = new RecordMsgFileUI.11.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11
 * JD-Core Version:    0.7.0.1
 */