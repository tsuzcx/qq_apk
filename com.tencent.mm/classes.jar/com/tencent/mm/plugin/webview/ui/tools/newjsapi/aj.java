package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetNavigationBarButtons;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetNavigationBarButtons", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final aj XnZ;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297556);
    XnZ = new aj();
    TAG = "MicroMsg.JsApiSetNavigationBarButtons";
    OOk = 195;
    idA = "setNavigationBarButtons";
    AppMethodBeat.o(297556);
  }
  
  private static boolean o(h paramh, p paramp)
  {
    AppMethodBeat.i(297533);
    Object localObject1 = (String)paramp.params.get("left");
    Object localObject2 = (String)paramp.params.get("right");
    if ((Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2)))
    {
      paramh.WDy.doCallback(paramp.WEH, "setNavigationBarButtons:fail", null);
      AppMethodBeat.o(297533);
      return true;
    }
    Bundle localBundle = new Bundle();
    if (localObject1 != null) {}
    try
    {
      Log.i(TAG, "parsing left");
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(TAG, s.X("left: ", localObject1));
      }
      localObject3 = new JSONObject((String)localObject1);
      str1 = aa.brW(((JSONObject)localObject3).optString("wxcolor", ""));
      localObject1 = str1;
      if (Util.isNullOrNil(str1)) {
        localObject1 = ((JSONObject)localObject3).optString("color", "");
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        localBundle.putString("set_navigation_bar_buttons_left_text_color", (String)localObject1);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3;
        String str1;
        boolean bool1;
        String str2;
        boolean bool2;
        label362:
        Log.printErrStackTrace(TAG, (Throwable)localException1, "setNavigationBarButtons opt left ", new Object[0]);
        continue;
        localBundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
      }
    }
    try
    {
      Log.i(TAG, "parsing right");
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(TAG, s.X("right: ", localObject2));
      }
      localObject2 = new JSONObject((String)localObject2);
      bool1 = ((JSONObject)localObject2).optBoolean("hidden", false);
      localObject3 = ((JSONObject)localObject2).optString("text", "");
      str2 = Util.nullAsNil(aa.brT(((JSONObject)localObject2).optString("iconData", "")));
      str1 = aa.brW(((JSONObject)localObject2).optString("wxcolor", ""));
      localObject1 = str1;
      if (Util.isNullOrNil(str1)) {
        localObject1 = ((JSONObject)localObject2).optString("color", "");
      }
      bool2 = ((JSONObject)localObject2).optBoolean("needClickEvent", false);
      if (bool1) {
        break label423;
      }
      localBundle.putString("set_navigation_bar_buttons_text", (String)localObject3);
      localBundle.putString("set_navigation_bar_buttons_icon_data", str2);
      localBundle.putString("set_navigation_bar_buttons_text_color", (String)localObject1);
      localBundle.putBoolean("set_navigation_bar_buttons_need_click_event", bool2);
      localBundle.putBoolean("set_navigation_bar_right_style", true);
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException2, "setNavigationBarButtons opt right ", new Object[0]);
      break label362;
    }
    if (localBundle.size() < 0)
    {
      Log.i(TAG, "params size = 0");
      paramh.WDy.doCallback(paramp.WEH, "setNavigationBarButtons:fail_invalid_params", null);
      AppMethodBeat.o(297533);
      return true;
    }
    try
    {
      label423:
      f localf = paramh.isi();
      if (localf != null) {
        localf.m(44, localBundle);
      }
      paramh.WDy.doCallback(paramp.WEH, "setNavigationBarButtons:ok", null);
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException3, "setNavigationBarButtons invoke ", new Object[0]);
        paramh.WDy.doCallback(paramp.WEH, "setNavigationBarButtons:fail_invoke", null);
      }
    }
    AppMethodBeat.o(297533);
    return true;
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297576);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    o(paramh, paramp);
    AppMethodBeat.o(297576);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.aj
 * JD-Core Version:    0.7.0.1
 */