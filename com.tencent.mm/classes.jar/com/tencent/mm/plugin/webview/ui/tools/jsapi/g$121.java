package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class g$121
  implements q.a
{
  g$121(g paramg, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      g.a(this.rzi, this.rzw, this.gge, this.bxX, this.eoz, this.rzx, this.rzy, paramString, this.rzz);
      if (this.rAD) {
        d.e(g.i(this.rzi), ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.bxX));
      }
      for (;;)
      {
        this.rzi.eL(1, 1);
        g.a(this.rzi, g.j(this.rzi), this.rAE, null);
        return;
        if (g.i(this.rzi) != null) {
          h.bC(g.i(this.rzi), g.i(this.rzi).getResources().getString(R.l.app_shared));
        }
      }
    }
    this.rzi.eL(1, 3);
    g.a(this.rzi, g.j(this.rzi), this.rAF, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.121
 * JD-Core Version:    0.7.0.1
 */