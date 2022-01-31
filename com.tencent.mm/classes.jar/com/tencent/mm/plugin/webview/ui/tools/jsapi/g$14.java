package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;
import java.util.Map;

final class g$14
  implements c.c
{
  g$14(g paramg, ProgressDialog paramProgressDialog, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map paramMap) {}
  
  public final void B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9058);
    if (this.vqx != null) {
      this.vqx.dismiss();
    }
    g.a(this.vqm, this.jMp, this.val$appId, this.bZZ, this.fEW, this.vqy, this.vqz, null, this.vqA);
    if (g.j(this.vqm) != null) {
      h.bO(g.j(this.vqm), g.j(this.vqm).getString(2131297064));
    }
    this.vqm.a(g.k(this.vqm), "send_app_msg:ok", this.oCN);
    AppMethodBeat.o(9058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.14
 * JD-Core Version:    0.7.0.1
 */