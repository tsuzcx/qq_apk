package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class bc
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78625);
    ac.i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
    String str1 = parama.bWS.bVY.optString("left");
    Object localObject = parama.bWS.bVY.optString("right");
    if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil((String)localObject)))
    {
      parama.a("fail", null);
      AppMethodBeat.o(78625);
      return;
    }
    Bundle localBundle = new Bundle();
    try
    {
      str1 = new JSONObject(str1).optString("color", "");
      if (!bs.isNullOrNil(str1)) {
        localBundle.putString("set_navigation_bar_buttons_left_text_color", str1);
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        boolean bool1 = ((JSONObject)localObject).optBoolean("hidden", false);
        str1 = ((JSONObject)localObject).optString("text", "");
        String str2 = bs.nullAsNil(x.aIf(((JSONObject)localObject).optString("iconData", "")));
        String str3 = ((JSONObject)localObject).optString("color", "");
        boolean bool2 = ((JSONObject)localObject).optBoolean("needClickEvent", false);
        if (bool1) {
          break label259;
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
          ac.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException1, "setNavigationBarButtons opt right ", new Object[0]);
        }
        l locall = ((f)parama.bWR).eAo();
        if (locall != null) {
          break label318;
        }
        parama.a("fail", null);
        AppMethodBeat.o(78625);
        return;
        locall.setNavigationBarButtons(localBundle);
        parama.a("", null);
        AppMethodBeat.o(78625);
      }
      if (localBundle.size() < 0)
      {
        parama.a("fail", null);
        AppMethodBeat.o(78625);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", localException2, "setNavigationBarButtons opt left ", new Object[0]);
        continue;
        label259:
        localBundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
      }
    }
    label318:
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setNavigationBarButtons";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */