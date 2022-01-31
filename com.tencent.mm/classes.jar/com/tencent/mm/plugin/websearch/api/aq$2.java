package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.d;

final class aq$2
  implements Runnable
{
  aq$2(aq paramaq, WebView paramWebView1, WebView paramWebView2) {}
  
  public final void run()
  {
    try
    {
      if (WebView.getTbsCoreVersion(ae.getContext()) == 0)
      {
        h.nFQ.f(15367, new Object[] { Integer.valueOf(1) });
        return;
      }
      if (!d.canOpenWebPlus(ae.getContext()))
      {
        h.nFQ.f(15367, new Object[] { Integer.valueOf(1) });
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("WebSearchXWeb", "", new Object[] { localException });
      return;
    }
    y.i("WebSearchXWeb", "begin check use sys webview");
    if (aq.b(this.qVl) > aq.b(this.qVm))
    {
      h.nFQ.f(15367, new Object[] { Integer.valueOf(2) });
      aq.b(this.qVk, true);
    }
    for (;;)
    {
      y.i("WebSearchXWeb", "end  check use sys webview, isUseSysWebview %b", new Object[] { Boolean.valueOf(aq.a(this.qVk)) });
      aq.b(this.qVk).edit().putBoolean("isUseSysWebview", aq.a(this.qVk)).commit();
      return;
      h.nFQ.f(15367, new Object[] { Integer.valueOf(3) });
      aq.b(this.qVk, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aq.2
 * JD-Core Version:    0.7.0.1
 */