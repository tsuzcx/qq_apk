package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;

final class WebViewUI$ac$44$1
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$ac$44$1(WebViewUI.ac.44 param44) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.d("MicroMsg.WebViewUI", "click item: %s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
    paramMenuItem = this.wuI.rqr.rpH.rbk;
    if (!paramMenuItem.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      return false;
    }
    y.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = i.a.a("onNavigationBarRightButtonClick", new HashMap(), paramMenuItem.rxI, paramMenuItem.rxJ);
    paramMenuItem.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.44.1
 * JD-Core Version:    0.7.0.1
 */