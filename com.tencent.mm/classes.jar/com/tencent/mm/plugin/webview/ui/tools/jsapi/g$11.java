package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c.c;
import com.tencent.mm.pluginsdk.model.app.f;

final class g$11
  implements c.c
{
  g$11(g paramg, ProgressDialog paramProgressDialog, f paramf, String paramString1, String paramString2, i parami) {}
  
  public final void B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(154930);
    if (this.vqx != null) {
      this.vqx.dismiss();
    }
    g.a(this.vqm, this.jMp, "", this.bZZ, this.fEW, null, null, null, null);
    this.vqm.a(this.uZa, "send_service_app_msg:ok", null);
    g.eB(this.vqm, this.uZa);
    AppMethodBeat.o(154930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.11
 * JD-Core Version:    0.7.0.1
 */