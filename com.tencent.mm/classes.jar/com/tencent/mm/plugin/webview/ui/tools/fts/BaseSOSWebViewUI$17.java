package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$17
  implements Runnable
{
  BaseSOSWebViewUI$17(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(80540);
    if (this.CCB.getJsapi() != null) {
      this.CCB.aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80539);
          ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
          f localf = BaseSOSWebViewUI.17.this.CCB.getJsapi();
          int i = BaseSOSWebViewUI.17.this.CCB.scene;
          HashMap localHashMap = new HashMap();
          localHashMap.put("isCancelButtonClick", Integer.valueOf(1));
          localHashMap.put("isInputChange", Integer.valueOf(1));
          localHashMap.put("scene", Integer.valueOf(i));
          localf.b("onSearchInputChange", localHashMap, null);
          BaseSOSWebViewUI.17.this.CCB.Had = false;
          BaseSOSWebViewUI.17.this.CCB.fdd();
          AppMethodBeat.o(80539);
        }
      });
    }
    AppMethodBeat.o(80540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.17
 * JD-Core Version:    0.7.0.1
 */