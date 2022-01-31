package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class ac
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(final com.tencent.luggage.e.a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    int i = 0;
    y.i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
    final String str1 = parama.bih.bhk.optString("url");
    if (bk.bl(str1))
    {
      parama.a("invalid_url", null);
      return;
    }
    y.i("MicroMsg.JsApiOpenCustomWebView", "url: %s", new Object[] { str1 });
    String str2 = parama.bih.bhk.optString("orientation");
    if (!bk.bl(str2)) {
      if (!str2.equals("horizontal")) {}
    }
    for (;;)
    {
      boolean bool1 = parama.bih.bhk.optBoolean("fullscreen");
      final boolean bool2 = parama.bih.bhk.optString("finish_recent_webview").equals("1");
      boolean bool3 = parama.bih.bhk.optString("disable_swipe_back").equals("1");
      str2 = parama.bih.bhk.optString("username");
      final Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("screen_orientation", i);
      localBundle.putBoolean("show_full_screen", bool1);
      localBundle.putBoolean("disable_swipe_back", bool3);
      localBundle.putString("shortcut_user_name", str2);
      localBundle.putString("game_hv_menu_appid", bk.pm(parama.bih.bhk.optString("gameAppid")));
      ai.d(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.plugin.webview.luggage.c.a.w(System.currentTimeMillis(), str1);
          if (bool2)
          {
            ((com.tencent.mm.plugin.webview.luggage.e)parama.big).bil.qj().e(str1, localBundle);
            return;
          }
          ((com.tencent.mm.plugin.webview.luggage.e)parama.big).bil.qj().d(str1, localBundle);
        }
      });
      parama.a("", null);
      return;
      if (str2.equals("vertical")) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  public final String name()
  {
    return "openCustomWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ac
 * JD-Core Version:    0.7.0.1
 */