package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.11;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class n$59
  implements Runnable
{
  n$59(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7773);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7773);
      return;
    }
    if (this.vdp != null)
    {
      d locald = this.vdp;
      String str = this.vdY;
      int i = this.vdt;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
        AppMethodBeat.o(7773);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", str);
      localHashMap.put("percent", Integer.valueOf(i));
      al.d(new d.11(locald, i.a.b("onMediaFileUploadProgress", localHashMap, locald.voB, locald.voC)));
    }
    AppMethodBeat.o(7773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.59
 * JD-Core Version:    0.7.0.1
 */