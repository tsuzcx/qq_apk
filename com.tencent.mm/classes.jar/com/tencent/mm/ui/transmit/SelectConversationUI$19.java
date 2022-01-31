package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SelectConversationUI$19
  implements c.a.b
{
  SelectConversationUI$19(SelectConversationUI paramSelectConversationUI, String paramString) {}
  
  public final void byw()
  {
    AppMethodBeat.i(35142);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("showShare", false);
    d.b(this.AAp.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(35142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.19
 * JD-Core Version:    0.7.0.1
 */