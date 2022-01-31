package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.24;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$13
  implements WebViewInputFooter.a
{
  WebViewUI$13(WebViewUI paramWebViewUI) {}
  
  public final boolean FO(String paramString)
  {
    AppMethodBeat.i(7827);
    if (this.vgz.uQS != null)
    {
      d locald = this.vgz.uQS;
      HashMap localHashMap = new HashMap();
      localHashMap.put("smiley", paramString);
      al.d(new d.24(locald, i.a.b("onGetSmiley", localHashMap, locald.voB, locald.voC)));
    }
    AppMethodBeat.o(7827);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.13
 * JD-Core Version:    0.7.0.1
 */