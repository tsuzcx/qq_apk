package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.Map;

final class FTSSOSHomeWebViewUI$2$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$2$1(FTSSOSHomeWebViewUI.2 param2, Bundle paramBundle, Map paramMap) {}
  
  public final void run()
  {
    if (FTSSOSHomeWebViewUI.r(this.ruF.ruD) != null) {}
    for (boolean bool = FTSSOSHomeWebViewUI.s(this.ruF.ruD).a(this.rqe.getString("type", "0"), this.rqe.getString("isMostSearchBiz", "0"), this.rqe.getString("isSug", "0"), this.rqe.getString("scene", "0"), this.rqe.getString("isLocalSug", "0"), this.ruF.ruD.getTotalQuery(), this.ruF.ruD.getInEditTextQuery(), this.ruF.ruD.cfw(), this.ruF.ruD.cfp(), this.ruF.ruD.ruy, this.ruE);; bool = false)
    {
      if (bool)
      {
        this.ruF.ruD.cfr().setHint(FTSSOSHomeWebViewUI.f(this.ruF.ruD, 0));
        FTSSOSHomeWebViewUI.a(this.ruF.ruD).Ff(7);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.2.1
 * JD-Core Version:    0.7.0.1
 */