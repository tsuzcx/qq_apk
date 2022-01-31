package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class RecordMsgFileUI$8
  implements View.OnClickListener
{
  RecordMsgFileUI$8(RecordMsgFileUI paramRecordMsgFileUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24260);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.mAj);
    d.b(this.pZN.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(24260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.8
 * JD-Core Version:    0.7.0.1
 */