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
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
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
    AppMethodBeat.i(207992);
    if (paramf == null)
    {
      ad.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(207992);
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
        AppMethodBeat.o(207992);
        return false;
      }
      catch (Exception paramf)
      {
        ad.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramf.getLocalizedMessage());
        AppMethodBeat.o(207992);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(207992);
      return false;
    }
    label102:
    paramMMWebView = new ValueCallback() {};
    if (!paramf.BHY) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(207992);
      return true;
      str = l.a.b("reportOnLeaveForMP", new HashMap(), paramf.DMD, paramf.vJP);
      paramf.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
  
  public static int aHX(String paramString)
  {
    AppMethodBeat.i(207993);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(207993);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aha();
    ((b.a)localObject).hNN = new ahb();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/exitreport";
    ((b.a)localObject).funcId = 1642;
    localObject = ((b.a)localObject).aDC();
    ((aha)((com.tencent.mm.al.b)localObject).hNK.hNQ).GeS = paramString;
    IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(79215);
        ad.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(79215);
      }
    });
    AppMethodBeat.o(207993);
    return 0;
  }
  
  public static void aHY(String paramString)
  {
    AppMethodBeat.i(207994);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.WebViewReportOnLeaveHelper", "doReportMusic invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(207994);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.class, null);
    AppMethodBeat.o(207994);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */