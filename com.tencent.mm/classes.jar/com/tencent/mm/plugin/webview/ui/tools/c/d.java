package com.tencent.mm.plugin.webview.ui.tools.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class d
  extends a
{
  private static final int Bpa = 346;
  public static final d Btr;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoShow";
  private static final String dAn = "currentMpInfoShow";
  
  static
  {
    AppMethodBeat.i(175682);
    Btr = new d();
    TAG = "MicroMsg.JsApiCurrentMpInfoShow";
    Bpa = 346;
    dAn = "currentMpInfoShow";
    AppMethodBeat.o(175682);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188921);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Context localContext = paramd.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).Bid != null))
    {
      Bundle localBundle = new Bundle();
      String str1 = (String)paraml.uLu.get("url");
      String str2 = (String)paraml.uLu.get("brandName");
      String str3 = (String)paraml.uLu.get("userName");
      ad.d(TAG, dAn + " brandName=" + str2 + ", userName=" + str3);
      if ((!bt.isNullOrNil(str2)) && (!bt.isNullOrNil(str3)))
      {
        localBundle.putString("key_brand_name", str2);
        localBundle.putString("key_brand_user_name", str3);
        localBundle.putString("key_url", str1);
      }
      localBundle.putBoolean("key_current_info_show", true);
      ((WebViewUI)localContext).Bid.aG(localBundle);
    }
    paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
    AppMethodBeat.o(188921);
    return true;
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.d
 * JD-Core Version:    0.7.0.1
 */