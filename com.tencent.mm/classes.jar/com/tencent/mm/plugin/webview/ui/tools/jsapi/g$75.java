package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$75
  implements d.b
{
  g$75(g paramg, String paramString1, String paramString2, i parami) {}
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.MsgHandler", this.gQZ + ", on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1, paramString3 });
    if ((bk.bl(paramString1)) || (!paramString1.equals(this.rec))) {
      return;
    }
    g.A(this.rzi).remove(this.rec);
    com.tencent.mm.plugin.webview.modeltools.g.ccK().a(this);
    if (g.k(this.rzi) != null)
    {
      g.k(this.rzi).dismiss();
      g.a(this.rzi, null);
    }
    g.B(this.rzi);
    if (!paramBoolean)
    {
      g.a(this.rzi, this.rzk, this.gQZ + ":fail", null);
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("serverId", paramString2);
    paramString1.put("mediaUrl", paramString3);
    g.a(this.rzi, this.rzk, this.gQZ + ":ok", paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.75
 * JD-Core Version:    0.7.0.1
 */