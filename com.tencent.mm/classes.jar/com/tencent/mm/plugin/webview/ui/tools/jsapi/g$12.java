package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.tencent.mm.as.c.c;
import com.tencent.mm.pluginsdk.model.app.f;

final class g$12
  implements c.c
{
  g$12(g paramg, ProgressDialog paramProgressDialog, f paramf, String paramString1, String paramString2, i parami) {}
  
  public final void t(Bitmap paramBitmap)
  {
    if (this.rzv != null) {
      this.rzv.dismiss();
    }
    g.a(this.rzi, this.rzw, "", this.bxX, this.eoz, null, null, null, null);
    g.a(this.rzi, this.rzk, "send_service_app_msg:ok", null);
    g.ef(this.rzi, this.rzk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.12
 * JD-Core Version:    0.7.0.1
 */