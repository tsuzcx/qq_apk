package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$10
  implements Runnable
{
  FTSBaseWebViewUI$10(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8392);
    int i;
    String str1;
    String str2;
    if (this.vkg.uQS != null)
    {
      this.vkg.uQS.a(this.vkg.getTotalQuery(), this.vkg.getInEditTextQuery(), this.vkg.dfD(), 0, null);
      if (!TextUtils.isEmpty(this.vkg.getInEditTextQuery()))
      {
        i = FTSBaseWebViewUI.a(this.vkg);
        str1 = this.vkg.cpW;
        str2 = this.vkg.cCW;
        if (this.vkg.vjX != 0) {
          break label128;
        }
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      z.a(i, str1, str2, bool, this.vkg.getInEditTextQuery(), FTSBaseWebViewUI.b(this.vkg));
      AppMethodBeat.o(8392);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.10
 * JD-Core Version:    0.7.0.1
 */