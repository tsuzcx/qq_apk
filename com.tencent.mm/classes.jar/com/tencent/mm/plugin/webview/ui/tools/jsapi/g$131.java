package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class g$131
  implements q.a
{
  g$131(g paramg, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(155044);
    if (paramBoolean)
    {
      g.a(this.vqm, this.jMp, this.hye, this.bZZ, this.fEW, this.vqy, this.vqz, paramString, this.vqA);
      if (this.vrG) {
        d.f(g.j(this.vqm), ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.bZZ));
      }
      for (;;)
      {
        this.vqm.gR(1, 1);
        this.vqm.a(g.k(this.vqm), this.vrH, null);
        AppMethodBeat.o(155044);
        return;
        if (g.j(this.vqm) != null) {
          h.bO(g.j(this.vqm), g.j(this.vqm).getResources().getString(2131297076));
        }
      }
    }
    this.vqm.gR(1, 3);
    this.vqm.a(g.k(this.vqm), this.vrI, null);
    AppMethodBeat.o(155044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.131
 * JD-Core Version:    0.7.0.1
 */