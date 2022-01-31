package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class d$28
  implements ap.a
{
  d$28(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(154917);
    String str = i.a.a("onBeaconsInRange", d.j(this.voP), d.k(this.voP), d.l(this.voP));
    d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    d.m(this.voP).clear();
    d.a(this.voP, new JSONObject());
    d.a(this.voP, new JSONArray());
    AppMethodBeat.o(154917);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.28
 * JD-Core Version:    0.7.0.1
 */