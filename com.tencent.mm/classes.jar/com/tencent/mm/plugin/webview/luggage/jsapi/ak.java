package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class ak
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    int i = 1;
    AppMethodBeat.i(78588);
    ad.i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
    final String str1 = parama.bZV.bZb.optString("url");
    if (bt.isNullOrNil(str1))
    {
      parama.a("invalid_url", null);
      AppMethodBeat.o(78588);
      return;
    }
    ad.i("MicroMsg.JsApiOpenCustomWebView", "url: %s", new Object[] { str1 });
    String str2 = parama.bZV.bZb.optString("orientation");
    if (!bt.isNullOrNil(str2)) {
      if (str2.equals("horizontal")) {
        i = 0;
      }
    }
    for (;;)
    {
      boolean bool1 = parama.bZV.bZb.optBoolean("fullscreen");
      final boolean bool2 = parama.bZV.bZb.optString("finish_recent_webview").equals("1");
      boolean bool3 = parama.bZV.bZb.optString("disable_swipe_back").equals("1");
      str2 = parama.bZV.bZb.optString("username");
      final Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("screen_orientation", i);
      localBundle.putBoolean("show_full_screen", bool1);
      localBundle.putBoolean("disable_swipe_back", bool3);
      localBundle.putString("shortcut_user_name", str2);
      localBundle.putString("game_hv_menu_appid", bt.nullAsNil(parama.bZV.bZb.optString("gameAppid")));
      localBundle.putBoolean("from_find_more_friend", ((f)parama.bZU).mParams.getBoolean("from_find_more_friend", false));
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78587);
          if (bool2)
          {
            ((f)parama.bZU).bZZ.Bb().i(str1, localBundle);
            AppMethodBeat.o(78587);
            return;
          }
          ((f)parama.bZU).bZZ.Bb().h(str1, localBundle);
          AppMethodBeat.o(78587);
        }
      });
      parama.a("", null);
      AppMethodBeat.o(78588);
      return;
      if (!str2.equals("vertical")) {
        i = -1;
      }
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openCustomWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */