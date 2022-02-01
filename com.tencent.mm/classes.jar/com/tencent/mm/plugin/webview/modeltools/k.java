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
import com.tencent.mm.plugin.webview.ui.tools.video.a;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public final class k
{
  public static boolean a(com.tencent.mm.plugin.webview.c.f paramf, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(198169);
    if (paramf == null)
    {
      ae.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(198169);
      return false;
    }
    String str = paramMMWebView.getUrl();
    if (!bu.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals("mp.weixin.qq.com");
        if (bool) {
          break label102;
        }
        AppMethodBeat.o(198169);
        return false;
      }
      catch (Exception paramf)
      {
        ae.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramf.getLocalizedMessage());
        AppMethodBeat.o(198169);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(198169);
      return false;
    }
    label102:
    paramMMWebView = new ValueCallback() {};
    if (!paramf.BZx) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(198169);
      return true;
      str = l.a.b("reportOnLeaveForMP", new HashMap(), paramf.EeC, paramf.vVT);
      paramf.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
  
  public static int aJq(String paramString)
  {
    AppMethodBeat.i(198170);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(198170);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ahk();
    ((b.a)localObject).hQG = new ahl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/exitreport";
    ((b.a)localObject).funcId = 1642;
    localObject = ((b.a)localObject).aDS();
    ((ahk)((com.tencent.mm.ak.b)localObject).hQD.hQJ).GxA = paramString;
    IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(79215);
        ae.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(79215);
      }
    });
    AppMethodBeat.o(198170);
    return 0;
  }
  
  public static void aJr(String paramString)
  {
    AppMethodBeat.i(198171);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.WebViewReportOnLeaveHelper", "doReportMusic invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(198171);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.class, null);
    AppMethodBeat.o(198171);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */