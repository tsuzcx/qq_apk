package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$9
  implements Runnable
{
  FTSBaseWebViewUI$9(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    int i;
    String str1;
    String str2;
    if (FTSBaseWebViewUI.e(this.rtV) != null)
    {
      FTSBaseWebViewUI.f(this.rtV).a(this.rtV.getTotalQuery(), this.rtV.getInEditTextQuery(), this.rtV.cfw(), 0, null);
      if (!TextUtils.isEmpty(this.rtV.getInEditTextQuery()))
      {
        i = FTSBaseWebViewUI.g(this.rtV);
        str1 = this.rtV.bIB;
        str2 = this.rtV.bVp;
        if (this.rtV.rtQ != 0) {
          break label116;
        }
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      z.a(i, str1, str2, bool, this.rtV.getInEditTextQuery(), FTSBaseWebViewUI.h(this.rtV));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */