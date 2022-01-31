package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;

final class g$20
  implements c.c
{
  g$20(g paramg, long paramLong, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public final void t(Bitmap arg1)
  {
    if (g.E(this.rzi) != null) {
      g.E(this.rzi).dismiss();
    }
    c localc;
    if (this.rzC >= 0L) {
      localc = z.MA().aj(this.rzC);
    }
    for (;;)
    {
      synchronized (e.ehy)
      {
        String str = e.HR();
        e.d(localc);
        g.a(this.rzi, this.rzw, this.val$appId, this.bxX, this.eoz, this.rzx, this.rzy, this.rzD, this.rzz);
        e.lw(str);
        if (g.i(this.rzi) != null) {
          h.bC(g.i(this.rzi), g.i(this.rzi).getString(R.l.confirm_dialog_sent));
        }
        g.a(this.rzi, g.j(this.rzi), "send_app_msg:ok", null);
        return;
      }
      g.a(this.rzi, this.rzw, this.val$appId, this.bxX, this.eoz, this.rzx, this.rzy, this.rzD, this.rzz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.20
 * JD-Core Version:    0.7.0.1
 */