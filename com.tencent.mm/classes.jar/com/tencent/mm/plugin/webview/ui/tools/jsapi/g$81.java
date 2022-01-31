package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.h.a.fi;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;

final class g$81
  implements Runnable
{
  g$81(g paramg, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, String paramString) {}
  
  public final void run()
  {
    fi localfi = new fi();
    localfi.bMc.op = 1;
    localfi.bMc.fileName = this.rAi.fileName;
    localfi.bMc.bBp = true;
    localfi.bMc.bMf = new g.81.1(this);
    localfi.bMc.bMg = new g.81.2(this);
    a.udP.m(localfi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.81
 * JD-Core Version:    0.7.0.1
 */