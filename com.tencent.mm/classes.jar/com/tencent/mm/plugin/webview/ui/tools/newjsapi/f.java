package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final f XmR;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(175682);
    XmR = new f();
    TAG = "MicroMsg.JsApiCurrentMpInfoShow";
    OOk = 346;
    idA = "currentMpInfoShow";
    AppMethodBeat.o(175682);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297887);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Context localContext = paramh.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).Wyi != null))
    {
      Bundle localBundle = new Bundle();
      String str1 = (String)paramp.params.get("url");
      String str2 = (String)paramp.params.get("brandName");
      String str3 = (String)paramp.params.get("userName");
      Log.d(TAG, idA + " brandName=" + str2 + ", userName=" + str3);
      if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str3)))
      {
        localBundle.putString("key_brand_name", str2);
        localBundle.putString("key_brand_user_name", str3);
        localBundle.putString("key_url", str1);
      }
      localBundle.putBoolean("key_current_info_show", true);
      ((WebViewUI)localContext).Wyi.bD(localBundle);
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
    AppMethodBeat.o(297887);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.f
 * JD-Core Version:    0.7.0.1
 */