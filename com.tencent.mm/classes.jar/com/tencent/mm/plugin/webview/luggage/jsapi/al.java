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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class al
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    int i = 1;
    AppMethodBeat.i(78588);
    Log.i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
    final String str1 = paramb.ctb.csi.optString("url");
    if (Util.isNullOrNil(str1))
    {
      paramb.c("invalid_url", null);
      AppMethodBeat.o(78588);
      return;
    }
    Log.i("MicroMsg.JsApiOpenCustomWebView", "url: %s", new Object[] { str1 });
    String str2 = paramb.ctb.csi.optString("orientation");
    if (!Util.isNullOrNil(str2)) {
      if (str2.equals("horizontal")) {
        i = 0;
      }
    }
    for (;;)
    {
      boolean bool1 = paramb.ctb.csi.optBoolean("fullscreen");
      final boolean bool2 = paramb.ctb.csi.optString("finish_recent_webview").equals("1");
      boolean bool3 = paramb.ctb.csi.optString("disable_swipe_back").equals("1");
      str2 = paramb.ctb.csi.optString("username");
      final Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("screen_orientation", i);
      localBundle.putBoolean("show_full_screen", bool1);
      localBundle.putBoolean("disable_swipe_back", bool3);
      localBundle.putString("shortcut_user_name", str2);
      localBundle.putString("game_hv_menu_appid", Util.nullAsNil(paramb.ctb.csi.optString("gameAppid")));
      localBundle.putBoolean("from_find_more_friend", ((g)paramb.cta).mParams.getBoolean("from_find_more_friend", false));
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78587);
          if (bool2)
          {
            ((g)paramb.cta).ctg.Ly().i(str1, localBundle);
            AppMethodBeat.o(78587);
            return;
          }
          ((g)paramb.cta).ctg.Ly().h(str1, localBundle);
          AppMethodBeat.o(78587);
        }
      });
      paramb.c("", null);
      AppMethodBeat.o(78588);
      return;
      if (!str2.equals("vertical")) {
        i = -1;
      }
    }
  }
  
  public final int dTs()
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