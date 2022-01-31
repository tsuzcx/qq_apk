package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.ui.base.h;

final class RecordMsgFileUI$9
  implements View.OnClickListener
{
  RecordMsgFileUI$9(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24261);
    if (!f.Mi())
    {
      h.h(this.pZN.getContext(), 2131299762, 2131297087);
      AppMethodBeat.o(24261);
      return;
    }
    n.b(RecordMsgFileUI.a(this.pZN), RecordMsgFileUI.b(this.pZN), true);
    RecordMsgFileUI.f(this.pZN);
    AppMethodBeat.o(24261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.9
 * JD-Core Version:    0.7.0.1
 */