package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class bf
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78625);
    ae.i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
    Object localObject1 = paramb.chh.cgn.optString("left");
    Object localObject2 = paramb.chh.cgn.optString("right");
    if ((bu.isNullOrNil((String)localObject1)) && (bu.isNullOrNil((String)localObject2)))
    {
      paramb.a("fail", null);
      AppMethodBeat.o(78625);
      return;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localObject3 = new JSONObject((String)localObject1);
      str1 = x.aPi(((JSONObject)localObject3).optString("wxcolor", ""));
      localObject1 = str1;
      if (bu.isNullOrNil(str1)) {
        localObject1 = ((JSONObject)localObject3).optString("color", "");
      }
      if (!bu.isNullOrNil((String)localObject1)) {
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
        ae.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException1, "setNavigationBarButtons opt left ", new Object[0]);
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
      str2 = bu.nullAsNil(x.aPe(((JSONObject)localObject2).optString("iconData", "")));
      str1 = x.aPi(((JSONObject)localObject2).optString("wxcolor", ""));
      localObject1 = str1;
      if (bu.isNullOrNil(str1)) {
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
      ae.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException2, "setNavigationBarButtons opt right ", new Object[0]);
      break label276;
      m localm = ((g)paramb.chg).eSQ();
      if (localm != null) {
        break label374;
      }
      paramb.a("fail", null);
      AppMethodBeat.o(78625);
      return;
      label374:
      localm.setNavigationBarButtons(localBundle);
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
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setNavigationBarButtons";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bf
 * JD-Core Version:    0.7.0.1
 */