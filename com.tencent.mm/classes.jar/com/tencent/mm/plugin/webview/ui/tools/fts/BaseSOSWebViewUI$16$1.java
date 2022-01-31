package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$16$1
  implements Runnable
{
  BaseSOSWebViewUI$16$1(BaseSOSWebViewUI.16 param16) {}
  
  public final void run()
  {
    d locald = BaseSOSWebViewUI.e(this.rtG.rtA);
    int i = this.rtG.rtA.scene;
    HashMap localHashMap = new HashMap();
    localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
    localHashMap.put("isInputChange", Integer.valueOf(1));
    localHashMap.put("scene", Integer.valueOf(i));
    locald.a("onSearchInputChange", localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.16.1
 * JD-Core Version:    0.7.0.1
 */