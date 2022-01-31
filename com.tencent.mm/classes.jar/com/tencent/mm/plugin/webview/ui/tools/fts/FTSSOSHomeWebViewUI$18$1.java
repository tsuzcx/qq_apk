package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.HashMap;
import java.util.Map;

final class FTSSOSHomeWebViewUI$18$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$18$1(FTSSOSHomeWebViewUI.18 param18, int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(153301);
    boolean bool = false;
    HashMap localHashMap;
    if (this.vkV.vkS.getJsapi() != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("isHomePage", "0");
      if (this.gjX != 0) {
        break label323;
      }
      localHashMap.put("isHomePage", "1");
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.vkV.vkS.getTotalQuery())) {
        localHashMap.put("query", this.vkV.vkS.getTotalQuery());
      }
      bool = this.vkV.vkS.getJsapi().a(this.val$result.getString("scene", "0"), this.val$result.getString("type", "0"), this.val$result.getString("isSug", "0"), this.val$result.getString("isLocalSug", "0"), this.vkV.vkS.getSessionId(), localHashMap);
      if (!TextUtils.isEmpty(this.vkV.vkS.getInEditTextQuery())) {
        z.a(this.vkV.vkS.scene, this.vkV.vkS.cpW, this.vkV.vkS.cCW, true, this.vkV.vkS.getInEditTextQuery(), this.vkV.vkS.vjX);
      }
      if (bool)
      {
        this.vkV.vkS.dfA().setHint(FTSSOSHomeWebViewUI.f(this.vkV.vkS, this.gjX));
        an.d(this.gjX, this.vkV.vkS.vjW, FTSSOSHomeWebViewUI.n(this.vkV.vkS), FTSSOSHomeWebViewUI.a(this.vkV.vkS).dfE());
        FTSSOSHomeWebViewUI.a(this.vkV.vkS).sendMessage(7);
      }
      AppMethodBeat.o(153301);
      return;
      label323:
      if (this.gjX == 1) {
        localHashMap.put("isMostSearchBiz", this.val$result.getString("isMostSearchBiz", "0"));
      } else {
        localHashMap.put("isHomePage", "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.18.1
 * JD-Core Version:    0.7.0.1
 */