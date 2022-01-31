package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.d;

final class ap$2
  implements Runnable
{
  ap$2(ap paramap, WebView paramWebView1, WebView paramWebView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(124251);
    try
    {
      if (WebView.getTbsCoreVersion(ah.getContext()) == 0)
      {
        h.qsU.e(15367, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(124251);
        return;
      }
      if (!d.canOpenWebPlus(ah.getContext()))
      {
        h.qsU.e(15367, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(124251);
        return;
      }
      ab.i("WebSearchXWeb", "begin check use sys webview");
      if (ap.a(this.uKx) > ap.a(this.uKy))
      {
        h.qsU.e(15367, new Object[] { Integer.valueOf(2) });
        ap.b(this.uKw, true);
      }
      for (;;)
      {
        ab.i("WebSearchXWeb", "end  check use sys webview, isUseSysWebview %b", new Object[] { Boolean.valueOf(ap.a(this.uKw)) });
        ap.b(this.uKw).edit().putBoolean("isUseSysWebview", ap.a(this.uKw)).commit();
        AppMethodBeat.o(124251);
        return;
        h.qsU.e(15367, new Object[] { Integer.valueOf(3) });
        ap.b(this.uKw, false);
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("WebSearchXWeb", "", new Object[] { localException });
      AppMethodBeat.o(124251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ap.2
 * JD-Core Version:    0.7.0.1
 */