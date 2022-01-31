package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ax
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6373);
    ab.i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
    String str1 = parama.byF.bxK.optString("left");
    Object localObject = parama.byF.bxK.optString("right");
    if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil((String)localObject)))
    {
      parama.a("fail", null);
      AppMethodBeat.o(6373);
      return;
    }
    Bundle localBundle = new Bundle();
    try
    {
      str1 = new JSONObject(str1).optString("color", "");
      if (!bo.isNullOrNil(str1)) {
        localBundle.putString("set_navigation_bar_buttons_left_text_color", str1);
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        boolean bool1 = ((JSONObject)localObject).optBoolean("hidden", false);
        str1 = ((JSONObject)localObject).optString("text", "");
        String str2 = bo.nullAsNil(u.amV(((JSONObject)localObject).optString("iconData", "")));
        String str3 = ((JSONObject)localObject).optString("color", "");
        boolean bool2 = ((JSONObject)localObject).optBoolean("needClickEvent", false);
        if (bool1) {
          break label262;
        }
        localBundle.putString("set_navigation_bar_buttons_text", str1);
        localBundle.putString("set_navigation_bar_buttons_icon_data", str2);
        localBundle.putString("set_navigation_bar_buttons_text_color", str3);
        localBundle.putBoolean("set_navigation_bar_buttons_need_click_event", bool2);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException1, "setNavigationBarButtons opt right ", new Object[0]);
        }
        l locall = ((e)parama.byE).daV();
        if (locall != null) {
          break label322;
        }
        parama.a("fail", null);
        AppMethodBeat.o(6373);
        return;
        locall.setNavigationBarButtons(localBundle);
        parama.a("", null);
        AppMethodBeat.o(6373);
      }
      if (localBundle.size() < 0)
      {
        parama.a("fail", null);
        AppMethodBeat.o(6373);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException2, "setNavigationBarButtons opt left ", new Object[0]);
        continue;
        label262:
        localBundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
      }
    }
    label322:
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setNavigationBarButtons";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */