package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class g$103
  implements q.a
{
  g$103(g paramg, String paramString1, long paramLong, f paramf, String paramString2, String paramString3, i parami) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      if (bk.bl(this.eoz))
      {
        com.tencent.mm.ai.a.c localc = z.MA().aj(this.rzC);
        synchronized (e.ehy)
        {
          String str = e.HR();
          e.d(localc);
          g.a(this.rzi, this.rzw, this.val$appId, this.bxX, this.eoz, null, null, paramString, null);
          e.lw(str);
          g.a(this.rzi, this.rzk, "sendEnterpriseChat:ok", null);
          if (g.i(this.rzi) != null) {
            h.bC(g.i(this.rzi), g.i(this.rzi).getResources().getString(R.l.app_shared));
          }
          return;
        }
      }
      o.OI().a(this.eoz, new g.103.1(this, paramString));
      return;
    }
    g.a(this.rzi, this.rzk, "sendEnterpriseChat:cancel", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.103
 * JD-Core Version:    0.7.0.1
 */