package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$25
  implements c.a.b
{
  SelectConversationUI$25(SelectConversationUI paramSelectConversationUI, String paramString) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("showShare", false);
    d.b(this.whw.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.25
 * JD-Core Version:    0.7.0.1
 */