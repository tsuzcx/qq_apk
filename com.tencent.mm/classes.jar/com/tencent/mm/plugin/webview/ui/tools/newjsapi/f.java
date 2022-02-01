package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class f
  extends a
{
  private static final int CDJ = 346;
  public static final f Jxf;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoShow";
  private static final String edq = "currentMpInfoShow";
  
  static
  {
    AppMethodBeat.i(175682);
    Jxf = new f();
    TAG = "MicroMsg.JsApiCurrentMpInfoShow";
    CDJ = 346;
    edq = "currentMpInfoShow";
    AppMethodBeat.o(175682);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(210586);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Context localContext = paramf.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).ILE != null))
    {
      Bundle localBundle = new Bundle();
      String str1 = (String)paramn.params.get("url");
      String str2 = (String)paramn.params.get("brandName");
      String str3 = (String)paramn.params.get("userName");
      Log.d(TAG, edq + " brandName=" + str2 + ", userName=" + str3);
      if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str3)))
      {
        localBundle.putString("key_brand_name", str2);
        localBundle.putString("key_brand_user_name", str3);
        localBundle.putString("key_url", str1);
      }
      localBundle.putBoolean("key_current_info_show", true);
      ((WebViewUI)localContext).ILE.bd(localBundle);
    }
    paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
    AppMethodBeat.o(210586);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.f
 * JD-Core Version:    0.7.0.1
 */