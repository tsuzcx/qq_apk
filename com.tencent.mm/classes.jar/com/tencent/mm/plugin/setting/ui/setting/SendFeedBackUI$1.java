package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SendFeedBackUI$1
  implements View.OnClickListener
{
  SendFeedBackUI$1(SendFeedBackUI paramSendFeedBackUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("showShare", false);
    paramView.putExtra("rawUrl", this.nSI.getString(a.i.wechat_faq_url));
    d.b(this.nSI.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.1
 * JD-Core Version:    0.7.0.1
 */