package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

final class BaseSOSWebViewUI$2
  implements Runnable
{
  BaseSOSWebViewUI$2(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8332);
    if (this.vjG.getJsapi() != null)
    {
      HashMap localHashMap1 = new HashMap();
      if (this.vjG.dfz() != 0)
      {
        localHashMap1.put("sugClickType", Integer.valueOf(this.vjG.dfz()));
        localHashMap1.put("sugId", this.vjG.dfy());
      }
      d locald = this.vjG.getJsapi();
      String str1 = this.vjG.getTotalQuery();
      String str2 = this.vjG.getInEditTextQuery();
      JSONArray localJSONArray = this.vjG.dfD();
      HashMap localHashMap2 = new HashMap();
      localHashMap2.putAll(localHashMap1);
      localHashMap2.put("query", str1);
      localHashMap2.put("custom", str2);
      localHashMap2.put("tagList", localJSONArray);
      locald.a("onSearchInputConfirm", localHashMap2, null);
      if (!TextUtils.isEmpty(this.vjG.getInEditTextQuery())) {
        z.a(this.vjG.vjW, this.vjG.cpW, this.vjG.cCW, true, this.vjG.getInEditTextQuery(), this.vjG.vjX);
      }
    }
    AppMethodBeat.o(8332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */