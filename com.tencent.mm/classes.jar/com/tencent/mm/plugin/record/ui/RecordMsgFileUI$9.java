package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class RecordMsgFileUI$9
  implements View.OnClickListener
{
  RecordMsgFileUI$9(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final void onClick(View paramView)
  {
    if (!f.zF())
    {
      com.tencent.mm.ui.base.h.h(this.nue.mController.uMN, R.l.favorite_no_sdcard, R.l.app_tip);
      return;
    }
    com.tencent.mm.plugin.record.b.h.b(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue), true);
    RecordMsgFileUI.f(this.nue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.9
 * JD-Core Version:    0.7.0.1
 */