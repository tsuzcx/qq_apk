package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.22;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$13
  implements WebViewInputFooter.a
{
  WebViewUI$13(WebViewUI paramWebViewUI) {}
  
  public final boolean xb(String paramString)
  {
    if (this.rpH.rbk != null)
    {
      d locald = this.rpH.rbk;
      HashMap localHashMap = new HashMap();
      localHashMap.put("smiley", paramString);
      ai.d(new d.22(locald, i.a.a("onGetSmiley", localHashMap, locald.rxI, locald.rxJ)));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.13
 * JD-Core Version:    0.7.0.1
 */