package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.h.a.pj;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$23
  extends c<pj>
{
  WebViewUI$23(WebViewUI paramWebViewUI)
  {
    this.udX = pj.class.getName().hashCode();
  }
  
  private boolean cVq()
  {
    if (this.rpH.gGn == null)
    {
      y.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
      return false;
    }
    if ((WebViewUI.A(this.rpH) == null) || (WebViewUI.A(this.rpH).length() == 0))
    {
      y.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
      return false;
    }
    try
    {
      long l = System.currentTimeMillis();
      y.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.A(this.rpH), Long.valueOf(WebViewUI.B(this.rpH)), Long.valueOf(l) });
      Bundle localBundle = new Bundle();
      localBundle.putString("service_click_tid", new String(WebViewUI.A(this.rpH)));
      localBundle.putLong("service_click_stime", WebViewUI.B(this.rpH));
      localBundle.putLong("service_click_etime", l);
      this.rpH.gGn.r(2836, localBundle);
      WebViewUI.a(this.rpH, null);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23
 * JD-Core Version:    0.7.0.1
 */