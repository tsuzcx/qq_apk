package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class g$87
  implements d.b
{
  g$87(g paramg, String paramString, i parami) {}
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.MsgHandler", "doDownloadVoice, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    if ((!bk.bl(paramString2)) && (paramString2.equals(this.rAb)))
    {
      com.tencent.mm.plugin.webview.modeltools.g.ccK().a(this);
      if (g.k(this.rzi) != null)
      {
        g.k(this.rzi).dismiss();
        g.a(this.rzi, null);
      }
      if (!paramBoolean) {
        g.a(this.rzi, this.rzk, "downloadVoice:fail", null);
      }
    }
    else
    {
      return;
    }
    paramString2 = new HashMap();
    paramString2.put("localId", paramString1);
    g.a(this.rzi, this.rzk, "downloadVoice:ok", paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.87
 * JD-Core Version:    0.7.0.1
 */