package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ah
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    int i = 0;
    AppMethodBeat.i(6340);
    ab.i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
    String str1 = parama.byF.bxK.optString("url");
    if (bo.isNullOrNil(str1))
    {
      parama.a("invalid_url", null);
      AppMethodBeat.o(6340);
      return;
    }
    ab.i("MicroMsg.JsApiOpenCustomWebView", "url: %s", new Object[] { str1 });
    String str2 = parama.byF.bxK.optString("orientation");
    if (!bo.isNullOrNil(str2)) {
      if (!str2.equals("horizontal")) {}
    }
    for (;;)
    {
      boolean bool1 = parama.byF.bxK.optBoolean("fullscreen");
      boolean bool2 = parama.byF.bxK.optString("finish_recent_webview").equals("1");
      boolean bool3 = parama.byF.bxK.optString("disable_swipe_back").equals("1");
      str2 = parama.byF.bxK.optString("username");
      Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("screen_orientation", i);
      localBundle.putBoolean("show_full_screen", bool1);
      localBundle.putBoolean("disable_swipe_back", bool3);
      localBundle.putString("shortcut_user_name", str2);
      localBundle.putString("game_hv_menu_appid", bo.nullAsNil(parama.byF.bxK.optString("gameAppid")));
      al.d(new ah.1(this, bool2, parama, str1, localBundle));
      parama.a("", null);
      AppMethodBeat.o(6340);
      return;
      if (str2.equals("vertical")) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openCustomWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah
 * JD-Core Version:    0.7.0.1
 */