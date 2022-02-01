package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.32;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Map;

final class BaseSearchWebViewUI$6
  implements w
{
  BaseSearchWebViewUI$6(BaseSearchWebViewUI paramBaseSearchWebViewUI) {}
  
  public final void iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188517);
    if (this.CCV.getJsapi() != null)
    {
      f localf = this.CCV.getJsapi();
      if (!localf.Apr)
      {
        ac.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
        AppMethodBeat.o(188517);
        return;
      }
      ac.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("index", Integer.valueOf(paramInt1));
      localHashMap.put("actionSheetId", Integer.valueOf(paramInt2));
      ap.f(new f.32(localf, l.a.b("onSearchActionSheetClick", localHashMap, localf.Cjz, localf.CjA)));
    }
    AppMethodBeat.o(188517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */