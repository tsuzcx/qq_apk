package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.R.l;
import com.tencent.mm.as.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;
import java.util.Map;

final class g$15
  implements c.c
{
  g$15(g paramg, ProgressDialog paramProgressDialog, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map paramMap) {}
  
  public final void t(Bitmap paramBitmap)
  {
    if (this.rzv != null) {
      this.rzv.dismiss();
    }
    g.a(this.rzi, this.rzw, this.val$appId, this.bxX, this.eoz, this.rzx, this.rzy, null, this.rzz);
    if (g.i(this.rzi) != null) {
      h.bC(g.i(this.rzi), g.i(this.rzi).getString(R.l.app_saved));
    }
    g.a(this.rzi, g.j(this.rzi), "send_app_msg:ok", this.mcl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.15
 * JD-Core Version:    0.7.0.1
 */