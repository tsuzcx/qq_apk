package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class g$113
  implements q.a
{
  g$113(g paramg, String paramString1, long paramLong, f paramf, String paramString2, String paramString3, i parami) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(155033);
    if (paramBoolean)
    {
      if (bo.isNullOrNil(this.fEW))
      {
        com.tencent.mm.aj.a.c localc = z.afk().aG(this.vqD);
        synchronized (e.fxC)
        {
          String str = e.aaQ();
          e.d(localc);
          g.a(this.vqm, this.jMp, this.val$appId, this.bZZ, this.fEW, null, null, paramString, null);
          e.ss(str);
          this.vqm.a(this.uZa, "sendEnterpriseChat:ok", null);
          if (g.j(this.vqm) != null) {
            h.bO(g.j(this.vqm), g.j(this.vqm).getResources().getString(2131297076));
          }
          AppMethodBeat.o(155033);
          return;
        }
      }
      o.ahB().a(this.fEW, new g.113.1(this, paramString));
      AppMethodBeat.o(155033);
      return;
    }
    this.vqm.a(this.uZa, "sendEnterpriseChat:cancel", null);
    AppMethodBeat.o(155033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.113
 * JD-Core Version:    0.7.0.1
 */