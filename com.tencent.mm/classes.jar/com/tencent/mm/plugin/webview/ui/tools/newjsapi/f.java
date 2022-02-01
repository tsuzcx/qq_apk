package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class f
  extends a
{
  private static final int EkT = 346;
  public static final f Epq;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoShow";
  private static final String dKm = "currentMpInfoShow";
  
  static
  {
    AppMethodBeat.i(175682);
    Epq = new f();
    TAG = "MicroMsg.JsApiCurrentMpInfoShow";
    EkT = 346;
    dKm = "currentMpInfoShow";
    AppMethodBeat.o(175682);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207635);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Context localContext = paramd.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).EdY != null))
    {
      Bundle localBundle = new Bundle();
      String str1 = (String)paraml.xaW.get("url");
      String str2 = (String)paraml.xaW.get("brandName");
      String str3 = (String)paraml.xaW.get("userName");
      ad.d(TAG, dKm + " brandName=" + str2 + ", userName=" + str3);
      if ((!bt.isNullOrNil(str2)) && (!bt.isNullOrNil(str3)))
      {
        localBundle.putString("key_brand_name", str2);
        localBundle.putString("key_brand_user_name", str3);
        localBundle.putString("key_url", str1);
      }
      localBundle.putBoolean("key_current_info_show", true);
      ((WebViewUI)localContext).EdY.aQ(localBundle);
    }
    paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", null);
    AppMethodBeat.o(207635);
    return true;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.f
 * JD-Core Version:    0.7.0.1
 */