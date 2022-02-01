package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$11
  implements Runnable
{
  FTSBaseWebViewUI$11(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(80590);
    int i;
    String str1;
    String str2;
    if (this.CDb.Cjc != null)
    {
      this.CDb.Cjc.a(this.CDb.getTotalQuery(), this.CDb.getInEditTextQuery(), this.CDb.eEZ(), 0, null);
      if (!TextUtils.isEmpty(this.CDb.getInEditTextQuery()))
      {
        i = FTSBaseWebViewUI.a(this.CDb);
        str1 = this.CDb.sessionId;
        str2 = this.CDb.drf;
        if (this.CDb.CCR != 0) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      y.a(i, str1, str2, bool, this.CDb.getInEditTextQuery(), FTSBaseWebViewUI.b(this.CDb));
      AppMethodBeat.o(80590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */