package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONObject;

public class an
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78590);
    Log.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
    final String str = paramb.ctb.csi.optString("url");
    Log.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", new Object[] { str });
    if (Util.isNullOrNil(str))
    {
      paramb.c("fail", null);
      AppMethodBeat.o(78590);
      return;
    }
    Object localObject = Uri.parse(str);
    if ((Util.nullAsNil(((Uri)localObject).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject).getHost() != null) && (!((Uri)localObject).getHost().equals(WeChatHosts.domainString(2131761707)))))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str);
      c.b(((g)paramb.cta).mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      paramb.c("", null);
      AppMethodBeat.o(78590);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78589);
        Bundle localBundle = new Bundle();
        localBundle.putString("rawUrl", str);
        localBundle.putBoolean("from_find_more_friend", ((g)paramb.cta).mParams.getBoolean("from_find_more_friend", false));
        ((g)paramb.cta).ctg.Ly().h(str, localBundle);
        AppMethodBeat.o(78589);
      }
    });
    paramb.c("", null);
    AppMethodBeat.o(78590);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openUrlWithExtraWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.an
 * JD-Core Version:    0.7.0.1
 */