package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.ui.tools.video.a;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.apache.commons.b.f;
import org.json.JSONObject;

public final class k
{
  public static boolean a(h paramh, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(211030);
    if (paramh == null)
    {
      Log.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(211030);
      return false;
    }
    String str = paramMMWebView.getUrl();
    if (!Util.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals(WeChatHosts.domainString(2131761726));
        if (bool) {
          break label105;
        }
        AppMethodBeat.o(211030);
        return false;
      }
      catch (Exception paramh)
      {
        Log.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramh.getLocalizedMessage());
        AppMethodBeat.o(211030);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(211030);
      return false;
    }
    label105:
    paramMMWebView = new ValueCallback() {};
    if (!paramh.GBl) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(211030);
      return true;
      str = n.a.b("reportOnLeaveForMP", new HashMap(), paramh.IRj, paramh.zpY);
      paramh.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
  
  public static int aZv(String paramString)
  {
    AppMethodBeat.i(211031);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(211031);
      return -1;
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ajw();
    ((d.a)localObject).iLO = new ajx();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/exitreport";
    ((d.a)localObject).funcId = 1642;
    localObject = ((d.a)localObject).aXF();
    ((ajw)((d)localObject).iLK.iLR).Ltj = paramString;
    IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(79215);
        Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(79215);
      }
    });
    AppMethodBeat.o(211031);
    return 0;
  }
  
  public static void aZw(String paramString)
  {
    AppMethodBeat.i(211032);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReportMusic invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(211032);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramString), a.class, null);
    AppMethodBeat.o(211032);
  }
  
  static class a
    implements b<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */