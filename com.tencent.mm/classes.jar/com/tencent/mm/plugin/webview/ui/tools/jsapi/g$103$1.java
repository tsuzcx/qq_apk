package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.c.c;
import com.tencent.mm.ui.base.h;

final class g$103$1
  implements c.c
{
  g$103$1(g.103 param103, String paramString) {}
  
  public final void t(Bitmap arg1)
  {
    if (g.E(this.rAx.rzi) != null) {
      g.E(this.rAx.rzi).dismiss();
    }
    c localc = z.MA().aj(this.rAx.rzC);
    synchronized (e.ehy)
    {
      String str = e.HR();
      e.d(localc);
      g.a(this.rAx.rzi, this.rAx.rzw, this.rAx.val$appId, this.rAx.bxX, this.rAx.eoz, null, null, this.rzD, null);
      e.lw(str);
      g.a(this.rAx.rzi, this.rAx.rzk, "sendEnterpriseChat:ok", null);
      if (g.i(this.rAx.rzi) != null) {
        h.bC(g.i(this.rAx.rzi), g.i(this.rAx.rzi).getResources().getString(R.l.app_shared));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.103.1
 * JD-Core Version:    0.7.0.1
 */