package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.p.a;
import java.util.LinkedList;

final class ag$b$8
  implements Runnable
{
  ag$b$8(Context paramContext, LinkedList paramLinkedList, String paramString1, String paramString2, p.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(232679);
    new p(this.val$context).a(this.oBO, this.nHB, this.oic, this.val$context.getString(c.i.wechat_login_title), this.PUK);
    AppMethodBeat.o(232679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag.b.8
 * JD-Core Version:    0.7.0.1
 */