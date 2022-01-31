package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class RecordMsgFileUI$8
  implements View.OnClickListener
{
  RecordMsgFileUI$8(RecordMsgFileUI paramRecordMsgFileUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.kfx);
    d.b(this.nue.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.8
 * JD-Core Version:    0.7.0.1
 */