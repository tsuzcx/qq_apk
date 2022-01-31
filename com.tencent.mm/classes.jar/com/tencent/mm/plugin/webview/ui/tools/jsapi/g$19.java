package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;

final class g$19
  implements c.c
{
  g$19(g paramg, long paramLong, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public final void B(Bitmap arg1)
  {
    AppMethodBeat.i(154934);
    if (g.I(this.vqm) != null) {
      g.I(this.vqm).dismiss();
    }
    c localc;
    if (this.vqD >= 0L) {
      localc = z.afk().aG(this.vqD);
    }
    for (;;)
    {
      synchronized (e.fxC)
      {
        String str = e.aaQ();
        e.d(localc);
        g.a(this.vqm, this.jMp, this.val$appId, this.bZZ, this.fEW, this.vqy, this.vqz, this.vqE, this.vqA);
        e.ss(str);
        if (g.j(this.vqm) != null) {
          h.bO(g.j(this.vqm), g.j(this.vqm).getString(2131298502));
        }
        this.vqm.a(g.k(this.vqm), "send_app_msg:ok", null);
        AppMethodBeat.o(154934);
        return;
      }
      g.a(this.vqm, this.jMp, this.val$appId, this.bZZ, this.fEW, this.vqy, this.vqz, this.vqE, this.vqA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.19
 * JD-Core Version:    0.7.0.1
 */