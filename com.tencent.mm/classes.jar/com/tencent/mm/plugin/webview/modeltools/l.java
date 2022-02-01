package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.apache.commons.c.h;
import org.json.JSONObject;

public final class l
{
  public static boolean a(j paramj, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(295809);
    if (paramj == null)
    {
      Log.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(295809);
      return false;
    }
    String str = paramMMWebView.getUrl();
    if (!Util.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals(WeChatHosts.domainString(c.i.host_mp_weixin_qq_com));
        if (bool) {
          break label106;
        }
        AppMethodBeat.o(295809);
        return false;
      }
      catch (Exception paramj)
      {
        Log.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramj.getLocalizedMessage());
        AppMethodBeat.o(295809);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(295809);
      return false;
    }
    label106:
    paramMMWebView = new ValueCallback() {};
    if (!paramj.UcS) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(295809);
      return true;
      str = p.a.b("reportOnLeaveForMP", new HashMap(), paramj.WDI, paramj.KQY);
      paramj.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
  
  public static int bkT(String paramString)
  {
    AppMethodBeat.i(295812);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(295812);
      return -1;
    }
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aok();
    ((c.a)localObject).otF = new aol();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/exitreport";
    ((c.a)localObject).funcId = 1642;
    localObject = ((c.a)localObject).bEF();
    ((aok)c.b.b(((c)localObject).otB)).ZvQ = paramString;
    IPCRunCgi.a((c)localObject, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
      {
        AppMethodBeat.i(79215);
        Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(79215);
      }
    });
    AppMethodBeat.o(295812);
    return 0;
  }
  
  public static void bkU(String paramString)
  {
    AppMethodBeat.i(295816);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReportMusic invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(295816);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), a.class, null);
    AppMethodBeat.o(295816);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */