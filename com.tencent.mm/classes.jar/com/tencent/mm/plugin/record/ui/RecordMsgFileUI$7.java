package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.n;

final class RecordMsgFileUI$7
  implements View.OnClickListener
{
  RecordMsgFileUI$7(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24259);
    paramView = n.c(RecordMsgFileUI.a(this.pZN), RecordMsgFileUI.b(this.pZN));
    new Intent().setAction("android.intent.action.VIEW");
    if (4 == RecordMsgFileUI.c(this.pZN))
    {
      RecordMsgFileUI.d(this.pZN);
      RecordMsgFileUI.e(this.pZN);
      AppMethodBeat.o(24259);
      return;
    }
    RecordMsgFileUI.a(this.pZN, paramView);
    AppMethodBeat.o(24259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.7
 * JD-Core Version:    0.7.0.1
 */