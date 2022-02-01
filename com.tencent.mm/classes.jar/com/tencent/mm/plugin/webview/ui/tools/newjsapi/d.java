package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class d
  extends a
{
  private static final int CHh = 346;
  public static final d CLx;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoShow";
  private static final String dxZ = "currentMpInfoShow";
  
  static
  {
    AppMethodBeat.i(175682);
    CLx = new d();
    TAG = "MicroMsg.JsApiCurrentMpInfoShow";
    CHh = 346;
    dxZ = "currentMpInfoShow";
    AppMethodBeat.o(175682);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189490);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Context localContext = paramd.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).CAq != null))
    {
      Bundle localBundle = new Bundle();
      String str1 = (String)paraml.vUl.get("url");
      String str2 = (String)paraml.vUl.get("brandName");
      String str3 = (String)paraml.vUl.get("userName");
      ac.d(TAG, dxZ + " brandName=" + str2 + ", userName=" + str3);
      if ((!bs.isNullOrNil(str2)) && (!bs.isNullOrNil(str3)))
      {
        localBundle.putString("key_brand_name", str2);
        localBundle.putString("key_brand_user_name", str3);
        localBundle.putString("key_url", str1);
      }
      localBundle.putBoolean("key_current_info_show", true);
      ((WebViewUI)localContext).CAq.aL(localBundle);
    }
    paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
    AppMethodBeat.o(189490);
    return true;
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.d
 * JD-Core Version:    0.7.0.1
 */