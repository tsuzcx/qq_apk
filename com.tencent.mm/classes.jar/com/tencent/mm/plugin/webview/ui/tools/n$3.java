package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.18;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class n$3
  implements Runnable
{
  n$3(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(7715);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7715);
      return;
    }
    if (this.vdp != null)
    {
      d locald = this.vdp;
      String str1 = this.lai;
      int i = this.hXH;
      String str2 = this.vdu;
      int j = this.val$errCode;
      String str3 = this.ftO;
      String str4 = this.vdv;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
        AppMethodBeat.o(7715);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j), str3, str4 });
      HashMap localHashMap = new HashMap();
      localHashMap.put("state", str1);
      localHashMap.put("duration", Integer.valueOf(i));
      localHashMap.put("src", str2);
      localHashMap.put("errCode", Integer.valueOf(j));
      localHashMap.put("errMsg", str3);
      localHashMap.put("srcId ", str4);
      al.d(new d.18(locald, i.a.b("onBackgroundAudioStateChange", localHashMap, locald.voB, locald.voC)));
    }
    AppMethodBeat.o(7715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.3
 * JD-Core Version:    0.7.0.1
 */