package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class f
  extends a
{
  private static final int ECX = 346;
  public static final f EHy;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoShow";
  private static final String dLB = "currentMpInfoShow";
  
  static
  {
    AppMethodBeat.i(175682);
    EHy = new f();
    TAG = "MicroMsg.JsApiCurrentMpInfoShow";
    ECX = 346;
    dLB = "currentMpInfoShow";
    AppMethodBeat.o(175682);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199394);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Context localContext = paramd.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).Ewa != null))
    {
      Bundle localBundle = new Bundle();
      String str1 = (String)paraml.xqN.get("url");
      String str2 = (String)paraml.xqN.get("brandName");
      String str3 = (String)paraml.xqN.get("userName");
      ae.d(TAG, dLB + " brandName=" + str2 + ", userName=" + str3);
      if ((!bu.isNullOrNil(str2)) && (!bu.isNullOrNil(str3)))
      {
        localBundle.putString("key_brand_name", str2);
        localBundle.putString("key_brand_user_name", str3);
        localBundle.putString("key_url", str1);
      }
      localBundle.putBoolean("key_current_info_show", true);
      ((WebViewUI)localContext).Ewa.aR(localBundle);
    }
    paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
    AppMethodBeat.o(199394);
    return true;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.f
 * JD-Core Version:    0.7.0.1
 */