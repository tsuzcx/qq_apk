package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetNavigationBarButtons;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetNavigationBarButtons", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"})
public final class z
  extends a
{
  private static final int IIl = 195;
  public static final z QvL;
  private static final String TAG = "MicroMsg.JsApiSetNavigationBarButtons";
  private static final String fXz = "setNavigationBarButtons";
  
  static
  {
    AppMethodBeat.i(224221);
    QvL = new z();
    TAG = "MicroMsg.JsApiSetNavigationBarButtons";
    IIl = 195;
    fXz = "setNavigationBarButtons";
    AppMethodBeat.o(224221);
  }
  
  private static boolean j(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(224217);
    Object localObject1 = (String)paramn.params.get("left");
    Object localObject4 = (String)paramn.params.get("right");
    if ((Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject4)))
    {
      paramf.PNo.h(paramn.POu, "setNavigationBarButtons:fail", null);
      AppMethodBeat.o(224217);
      return true;
    }
    Bundle localBundle = new Bundle();
    if (localObject1 != null) {}
    Object localObject3;
    try
    {
      Log.i(TAG, "parsing left");
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(TAG, "left: ".concat(String.valueOf(localObject1)));
      }
      localObject5 = new JSONObject((String)localObject1);
      localObject3 = ab.bsf(((JSONObject)localObject5).optString("wxcolor", ""));
      localObject1 = localObject3;
      if (Util.isNullOrNil((String)localObject3)) {
        localObject1 = ((JSONObject)localObject5).optString("color", "");
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        localBundle.putString("set_navigation_bar_buttons_left_text_color", (String)localObject1);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject5;
        boolean bool1;
        String str;
        boolean bool2;
        label366:
        Log.printErrStackTrace(TAG, (Throwable)localException1, "setNavigationBarButtons opt left ", new Object[0]);
        continue;
        localBundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
      }
    }
    try
    {
      Log.i(TAG, "parsing right");
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(TAG, "right: ".concat(String.valueOf(localObject4)));
      }
      localObject4 = new JSONObject((String)localObject4);
      bool1 = ((JSONObject)localObject4).optBoolean("hidden", false);
      localObject5 = ((JSONObject)localObject4).optString("text", "");
      str = Util.nullAsNil(ab.bsc(((JSONObject)localObject4).optString("iconData", "")));
      localObject3 = ab.bsf(((JSONObject)localObject4).optString("wxcolor", ""));
      localObject1 = localObject3;
      if (Util.isNullOrNil((String)localObject3)) {
        localObject1 = ((JSONObject)localObject4).optString("color", "");
      }
      bool2 = ((JSONObject)localObject4).optBoolean("needClickEvent", false);
      if (bool1) {
        break label425;
      }
      localBundle.putString("set_navigation_bar_buttons_text", (String)localObject5);
      localBundle.putString("set_navigation_bar_buttons_icon_data", str);
      localBundle.putString("set_navigation_bar_buttons_text_color", (String)localObject1);
      localBundle.putBoolean("set_navigation_bar_buttons_need_click_event", bool2);
      localBundle.putBoolean("set_navigation_bar_right_style", true);
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException2, "setNavigationBarButtons opt right ", new Object[0]);
      break label366;
    }
    if (localBundle.size() < 0)
    {
      Log.i(TAG, "params size = 0");
      paramf.PNo.h(paramn.POu, "setNavigationBarButtons:fail_invalid_params", null);
      AppMethodBeat.o(224217);
      return true;
    }
    try
    {
      label425:
      localObject3 = paramf.context;
      Object localObject2 = localObject3;
      if (!(localObject3 instanceof WebViewUI)) {
        localObject2 = null;
      }
      localObject2 = (WebViewUI)localObject2;
      if (localObject2 != null)
      {
        localObject2 = ((WebViewUI)localObject2).POP;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.webview.stub.f)localObject2).l(44, localBundle);
        }
      }
      paramf.PNo.h(paramn.POu, "setNavigationBarButtons:ok", null);
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException3, "setNavigationBarButtons invoke ", new Object[0]);
        paramf.PNo.h(paramn.POu, "setNavigationBarButtons:fail_invoke", null);
      }
    }
    AppMethodBeat.o(224217);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(224204);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    j(paramf, paramn);
    AppMethodBeat.o(224204);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.z
 * JD-Core Version:    0.7.0.1
 */