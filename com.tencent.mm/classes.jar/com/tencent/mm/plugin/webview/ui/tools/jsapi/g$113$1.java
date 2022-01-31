package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.c.c;
import com.tencent.mm.ui.base.h;

final class g$113$1
  implements c.c
{
  g$113$1(g.113 param113, String paramString) {}
  
  public final void B(Bitmap arg1)
  {
    AppMethodBeat.i(155032);
    if (g.I(this.vrA.vqm) != null) {
      g.I(this.vrA.vqm).dismiss();
    }
    c localc = z.afk().aG(this.vrA.vqD);
    synchronized (e.fxC)
    {
      String str = e.aaQ();
      e.d(localc);
      g.a(this.vrA.vqm, this.vrA.jMp, this.vrA.val$appId, this.vrA.bZZ, this.vrA.fEW, null, null, this.vqE, null);
      e.ss(str);
      this.vrA.vqm.a(this.vrA.uZa, "sendEnterpriseChat:ok", null);
      if (g.j(this.vrA.vqm) != null) {
        h.bO(g.j(this.vrA.vqm), g.j(this.vrA.vqm).getResources().getString(2131297076));
      }
      AppMethodBeat.o(155032);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.113.1
 * JD-Core Version:    0.7.0.1
 */