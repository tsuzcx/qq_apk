package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.HashMap;
import java.util.Map;

final class FTSSOSHomeWebViewUI$18$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$18$1(FTSSOSHomeWebViewUI.18 param18, int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    boolean bool = false;
    HashMap localHashMap;
    if (FTSSOSHomeWebViewUI.k(this.ruG.ruD) != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("isHomePage", "0");
      if (this.eSc != 0) {
        break label313;
      }
      localHashMap.put("isHomePage", "1");
    }
    for (;;)
    {
      if (!bk.bl(this.ruG.ruD.getTotalQuery())) {
        localHashMap.put("query", this.ruG.ruD.getTotalQuery());
      }
      bool = FTSSOSHomeWebViewUI.l(this.ruG.ruD).a(this.rqe.getString("scene", "0"), this.rqe.getString("type", "0"), this.rqe.getString("isSug", "0"), this.rqe.getString("isLocalSug", "0"), this.ruG.ruD.getSessionId(), localHashMap);
      if (!TextUtils.isEmpty(this.ruG.ruD.getInEditTextQuery())) {
        z.a(this.ruG.ruD.scene, this.ruG.ruD.bIB, this.ruG.ruD.bVp, true, this.ruG.ruD.getInEditTextQuery(), this.ruG.ruD.rtQ);
      }
      if (bool)
      {
        this.ruG.ruD.cfr().setHint(FTSSOSHomeWebViewUI.f(this.ruG.ruD, this.eSc));
        ao.f(this.eSc, this.ruG.ruD.rtP, FTSSOSHomeWebViewUI.m(this.ruG.ruD), FTSSOSHomeWebViewUI.a(this.ruG.ruD).cfG());
        FTSSOSHomeWebViewUI.a(this.ruG.ruD).Ff(7);
      }
      return;
      label313:
      if (this.eSc == 1) {
        localHashMap.put("isMostSearchBiz", this.rqe.getString("isMostSearchBiz", "0"));
      } else {
        localHashMap.put("isHomePage", "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.18.1
 * JD-Core Version:    0.7.0.1
 */