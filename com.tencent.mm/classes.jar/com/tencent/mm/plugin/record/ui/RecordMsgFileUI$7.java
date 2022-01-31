package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.record.b.h;

final class RecordMsgFileUI$7
  implements View.OnClickListener
{
  RecordMsgFileUI$7(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = h.c(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue));
    new Intent().setAction("android.intent.action.VIEW");
    if (4 == RecordMsgFileUI.c(this.nue))
    {
      RecordMsgFileUI.d(this.nue);
      RecordMsgFileUI.e(this.nue);
      return;
    }
    RecordMsgFileUI.a(this.nue, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.7
 * JD-Core Version:    0.7.0.1
 */