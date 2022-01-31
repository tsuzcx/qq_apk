package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
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
    if (BaseSOSWebViewUI.j(this.rtA) != null)
    {
      HashMap localHashMap1 = new HashMap();
      if (this.rtA.cfq() != 0)
      {
        localHashMap1.put("sugClickType", Integer.valueOf(this.rtA.cfq()));
        localHashMap1.put("sugId", this.rtA.cfp());
      }
      d locald = BaseSOSWebViewUI.k(this.rtA);
      String str1 = this.rtA.getTotalQuery();
      String str2 = this.rtA.getInEditTextQuery();
      JSONArray localJSONArray = this.rtA.cfw();
      HashMap localHashMap2 = new HashMap();
      localHashMap2.putAll(localHashMap1);
      localHashMap2.put("query", str1);
      localHashMap2.put("custom", str2);
      localHashMap2.put("tagList", localJSONArray);
      locald.a("onSearchInputConfirm", localHashMap2, null);
      if (!TextUtils.isEmpty(this.rtA.getInEditTextQuery())) {
        z.a(this.rtA.rtP, this.rtA.bIB, this.rtA.bVp, true, this.rtA.getInEditTextQuery(), this.rtA.rtQ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */