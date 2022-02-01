package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public final class k
{
  public static boolean a(com.tencent.mm.plugin.webview.c.f paramf, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(187937);
    if (paramf == null)
    {
      ad.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(187937);
      return false;
    }
    String str = paramMMWebView.getUrl();
    if (!bt.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals("mp.weixin.qq.com");
        if (bool) {
          break label102;
        }
        AppMethodBeat.o(187937);
        return false;
      }
      catch (Exception paramf)
      {
        ad.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramf.getLocalizedMessage());
        AppMethodBeat.o(187937);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(187937);
      return false;
    }
    label102:
    paramMMWebView = new ValueCallback() {};
    if (!paramf.yZR) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(187937);
      return true;
      str = l.a.b("reportOnLeaveForMP", new HashMap(), paramf.ARm, paramf.ARn);
      paramf.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */