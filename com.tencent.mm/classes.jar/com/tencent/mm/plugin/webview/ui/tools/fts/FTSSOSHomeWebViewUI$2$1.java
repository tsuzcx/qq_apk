package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.Map;

final class FTSSOSHomeWebViewUI$2$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$2$1(FTSSOSHomeWebViewUI.2 param2, Bundle paramBundle, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(8424);
    if (this.vkU.vkS.getJsapi() != null) {}
    for (boolean bool = this.vkU.vkS.getJsapi().a(this.val$result.getString("type", "0"), this.val$result.getString("isMostSearchBiz", "0"), this.val$result.getString("isSug", "0"), this.val$result.getString("scene", "0"), this.val$result.getString("isLocalSug", "0"), this.vkU.vkS.getTotalQuery(), this.vkU.vkS.getInEditTextQuery(), this.vkU.vkS.dfD(), this.vkU.vkS.dfy(), this.vkU.vkS.vkN, this.vkT);; bool = false)
    {
      if (bool)
      {
        this.vkU.vkS.dfA().setHint(FTSSOSHomeWebViewUI.f(this.vkU.vkS, 0));
        FTSSOSHomeWebViewUI.a(this.vkU.vkS).sendMessage(7);
      }
      AppMethodBeat.o(8424);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.2.1
 * JD-Core Version:    0.7.0.1
 */