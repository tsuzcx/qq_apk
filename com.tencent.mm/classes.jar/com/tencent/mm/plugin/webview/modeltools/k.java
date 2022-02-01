package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public final class k
{
  public static boolean a(com.tencent.mm.plugin.webview.c.f paramf, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(188365);
    if (paramf == null)
    {
      ac.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(188365);
      return false;
    }
    String str = paramMMWebView.getUrl();
    if (!bs.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals("mp.weixin.qq.com");
        if (bool) {
          break label102;
        }
        AppMethodBeat.o(188365);
        return false;
      }
      catch (Exception paramf)
      {
        ac.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramf.getLocalizedMessage());
        AppMethodBeat.o(188365);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(188365);
      return false;
    }
    label102:
    paramMMWebView = new ValueCallback() {};
    if (!paramf.Apr) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(188365);
      return true;
      str = l.a.b("reportOnLeaveForMP", new HashMap(), paramf.Cjz, paramf.CjA);
      paramf.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
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