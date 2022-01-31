package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class g$70
  implements d.b
{
  g$70(g paramg, String paramString1, String paramString2, i parami) {}
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.MsgHandler", this.gQZ + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1, paramString3 });
    if ((!bk.bl(paramString1)) && (paramString1.equals(this.rec)))
    {
      com.tencent.mm.plugin.webview.modeltools.g.ccK().a(this);
      if (g.k(this.rzi) != null)
      {
        g.k(this.rzi).dismiss();
        g.a(this.rzi, null);
      }
      if (!paramBoolean) {
        g.a(this.rzi, this.rzk, this.gQZ + ":fail", null);
      }
    }
    else
    {
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("serverId", paramString2);
    paramString1.put("mediaUrl", paramString3);
    g.a(this.rzi, this.rzk, this.gQZ + ":ok", paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.70
 * JD-Core Version:    0.7.0.1
 */