package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class al
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    int i = 1;
    AppMethodBeat.i(78588);
    ae.i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
    final String str1 = paramb.chh.cgn.optString("url");
    if (bu.isNullOrNil(str1))
    {
      paramb.a("invalid_url", null);
      AppMethodBeat.o(78588);
      return;
    }
    ae.i("MicroMsg.JsApiOpenCustomWebView", "url: %s", new Object[] { str1 });
    String str2 = paramb.chh.cgn.optString("orientation");
    if (!bu.isNullOrNil(str2)) {
      if (str2.equals("horizontal")) {
        i = 0;
      }
    }
    for (;;)
    {
      boolean bool1 = paramb.chh.cgn.optBoolean("fullscreen");
      final boolean bool2 = paramb.chh.cgn.optString("finish_recent_webview").equals("1");
      boolean bool3 = paramb.chh.cgn.optString("disable_swipe_back").equals("1");
      str2 = paramb.chh.cgn.optString("username");
      final Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("screen_orientation", i);
      localBundle.putBoolean("show_full_screen", bool1);
      localBundle.putBoolean("disable_swipe_back", bool3);
      localBundle.putString("shortcut_user_name", str2);
      localBundle.putString("game_hv_menu_appid", bu.nullAsNil(paramb.chh.cgn.optString("gameAppid")));
      localBundle.putBoolean("from_find_more_friend", ((g)paramb.chg).mParams.getBoolean("from_find_more_friend", false));
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78587);
          if (bool2)
          {
            ((g)paramb.chg).chm.Ch().i(str1, localBundle);
            AppMethodBeat.o(78587);
            return;
          }
          ((g)paramb.chg).chm.Ch().h(str1, localBundle);
          AppMethodBeat.o(78587);
        }
      });
      paramb.a("", null);
      AppMethodBeat.o(78588);
      return;
      if (!str2.equals("vertical")) {
        i = -1;
      }
    }
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openCustomWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.al
 * JD-Core Version:    0.7.0.1
 */