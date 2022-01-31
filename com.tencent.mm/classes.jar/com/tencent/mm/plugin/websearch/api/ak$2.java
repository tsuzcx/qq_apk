package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

final class ak$2
  extends w
{
  ak$2(ak paramak, MMWebView paramMMWebView) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(124192);
    if (!u.x(paramString, "weixin://private/setresult/"))
    {
      AppMethodBeat.o(124192);
      return false;
    }
    ab.i(this.uJV.TAG, "handleUrl %s ,view %s", new Object[] { paramString, paramWebView.toString() });
    this.uJW.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
    AppMethodBeat.o(124192);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(124190);
    ab.i(this.uJV.TAG, "onPageFinished, view %s", new Object[] { paramWebView.toString() });
    this.uJV.b(this.uJW);
    AppMethodBeat.o(124190);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(124191);
    super.b(paramWebView, paramString, paramBitmap);
    ab.i(this.uJV.TAG, "onPageStarted, view %s", new Object[] { paramWebView.toString() });
    u.d(this.uJW);
    AppMethodBeat.o(124191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak.2
 * JD-Core Version:    0.7.0.1
 */