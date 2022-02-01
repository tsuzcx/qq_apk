package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
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
    AppMethodBeat.i(259900);
    if (paramh == null)
    {
      Log.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
      AppMethodBeat.o(259900);
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
        AppMethodBeat.o(259900);
        return false;
      }
      catch (Exception paramh)
      {
        Log.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + paramh.getLocalizedMessage());
        AppMethodBeat.o(259900);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(259900);
      return false;
    }
    label106:
    paramMMWebView = new ValueCallback() {};
    if (!paramh.NoX) {
      paramMMWebView.onReceiveValue(null);
    }
    for (;;)
    {
      AppMethodBeat.o(259900);
      return true;
      str = n.a.b("reportOnLeaveForMP", new HashMap(), paramh.PNx, paramh.EVx);
      paramh.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", paramMMWebView);
    }
  }
  
  public static int blo(String paramString)
  {
    AppMethodBeat.i(259901);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(259901);
      return -1;
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new akz();
    ((d.a)localObject).lBV = new ala();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/exitreport";
    ((d.a)localObject).funcId = 1642;
    localObject = ((d.a)localObject).bgN();
    ((akz)d.b.b(((com.tencent.mm.an.d)localObject).lBR)).SvH = paramString;
    IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
      {
        AppMethodBeat.i(79215);
        Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(79215);
      }
    });
    AppMethodBeat.o(259901);
    return 0;
  }
  
  public static void blp(String paramString)
  {
    AppMethodBeat.i(259902);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReportMusic invalid reportData %s", new Object[] { paramString });
      AppMethodBeat.o(259902);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), a.class, null);
    AppMethodBeat.o(259902);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements com.tencent.mm.ipcinvoker.d<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */