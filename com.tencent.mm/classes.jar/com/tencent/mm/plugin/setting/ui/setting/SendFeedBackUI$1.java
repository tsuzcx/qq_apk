package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class SendFeedBackUI$1
  implements View.OnClickListener
{
  SendFeedBackUI$1(SendFeedBackUI paramSendFeedBackUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127043);
    paramView = new Intent();
    paramView.putExtra("showShare", false);
    paramView.putExtra("rawUrl", this.qGG.getString(2131305938));
    d.b(this.qGG.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(127043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.1
 * JD-Core Version:    0.7.0.1
 */