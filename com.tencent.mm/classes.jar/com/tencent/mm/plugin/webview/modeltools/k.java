package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;

public final class k
{
  public static boolean a(d paramd, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(7030);
    if (paramd == null)
    {
      ab.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(7030);
      return false;
    }
    String str = paramMMWebView.getUrl();
    if (!bo.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals("mp.weixin.qq.com");
        if (bool) {
          break label107;
        }
        AppMethodBeat.o(7030);
        return false;
      }
      catch (Exception paramd)
      {
        ab.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramd.getLocalizedMessage());
        AppMethodBeat.o(7030);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(7030);
      return false;
    }
    label107:
    paramMMWebView = new k.1(paramMMWebView);
    if (!paramd.ready) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(7030);
      return true;
      str = i.a.b("reportOnLeaveForMP", new HashMap(), paramd.voB, paramd.voC);
      paramd.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */