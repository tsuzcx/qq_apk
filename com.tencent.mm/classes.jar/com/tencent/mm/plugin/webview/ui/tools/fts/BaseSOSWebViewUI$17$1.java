package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$17$1
  implements Runnable
{
  BaseSOSWebViewUI$17$1(BaseSOSWebViewUI.17 param17) {}
  
  public final void run()
  {
    AppMethodBeat.i(8346);
    d locald = this.vjN.vjG.getJsapi();
    int i = this.vjN.vjG.scene;
    HashMap localHashMap = new HashMap();
    localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
    localHashMap.put("isInputChange", Integer.valueOf(1));
    localHashMap.put("scene", Integer.valueOf(i));
    locald.a("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(8346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.17.1
 * JD-Core Version:    0.7.0.1
 */