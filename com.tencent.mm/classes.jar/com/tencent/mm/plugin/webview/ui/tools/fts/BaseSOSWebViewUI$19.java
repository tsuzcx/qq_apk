package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ch;
import com.tencent.mm.plugin.websearch.api.as;

final class BaseSOSWebViewUI$19
  implements Runnable
{
  BaseSOSWebViewUI$19(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5) {}
  
  public final void run()
  {
    AppMethodBeat.i(296872);
    ch localch = new ch();
    localch.ijk = localch.F("SessionId", this.XcJ, true);
    localch.iuU = localch.F("SearchId", this.XcK, true);
    localch.ioY = localch.F("RequestId", this.XcL, true);
    localch.ivR = this.XcM;
    localch.iqr = this.XcN;
    localch.ivS = this.XcO;
    localch.ivT = System.currentTimeMillis();
    localch.ivU = localch.F("FeatureInfo", this.XcP, true);
    localch.ivX = this.XcQ;
    localch.ivY = localch.F("ParentSearchId", this.XcR, true);
    localch.bMH();
    as.a(localch);
    AppMethodBeat.o(296872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.19
 * JD-Core Version:    0.7.0.1
 */