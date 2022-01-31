package com.tencent.mm.plugin.webview.luggage;

import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class e$13
  extends p
{
  e$13(e parame) {}
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    e.a(this.rca).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.13
 * JD-Core Version:    0.7.0.1
 */