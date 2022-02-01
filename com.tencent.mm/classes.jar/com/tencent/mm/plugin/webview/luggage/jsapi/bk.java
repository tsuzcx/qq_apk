package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.n;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class bk
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78625);
    Log.i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
    Object localObject1 = paramb.eiZ.eif.optString("left");
    Object localObject2 = paramb.eiZ.eif.optString("right");
    if ((Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2)))
    {
      paramb.a("fail", null);
      AppMethodBeat.o(78625);
      return;
    }
    Bundle localBundle = new Bundle();
    try
    {
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
        label276:
        Log.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException1, "setNavigationBarButtons opt left ", new Object[0]);
        continue;
        label315:
        localBundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
      }
    }
    try
    {
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
        break label315;
      }
      localBundle.putString("set_navigation_bar_buttons_text", (String)localObject3);
      localBundle.putString("set_navigation_bar_buttons_icon_data", str2);
      localBundle.putString("set_navigation_bar_buttons_text_color", (String)localObject1);
      localBundle.putBoolean("set_navigation_bar_buttons_need_click_event", bool2);
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException2, "setNavigationBarButtons opt right ", new Object[0]);
      break label276;
      n localn = ((g)paramb.eiY).iuf();
      if (localn != null) {
        break label374;
      }
      paramb.a("fail", null);
      AppMethodBeat.o(78625);
      return;
      label374:
      localn.setNavigationBarButtons(localBundle);
      paramb.a("", null);
      AppMethodBeat.o(78625);
    }
    if (localBundle.size() < 0)
    {
      paramb.a("fail", null);
      AppMethodBeat.o(78625);
      return;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setNavigationBarButtons";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bk
 * JD-Core Version:    0.7.0.1
 */