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
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class am
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78590);
    ae.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
    final String str = paramb.chh.cgn.optString("url");
    ae.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", new Object[] { str });
    if (bu.isNullOrNil(str))
    {
      paramb.a("fail", null);
      AppMethodBeat.o(78590);
      return;
    }
    Object localObject = Uri.parse(str);
    if ((bu.nullAsNil(((Uri)localObject).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject).getHost() != null) && (!((Uri)localObject).getHost().equals("game.weixin.qq.com"))))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str);
      d.b(((g)paramb.chg).mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      paramb.a("", null);
      AppMethodBeat.o(78590);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78589);
        Bundle localBundle = new Bundle();
        localBundle.putString("rawUrl", str);
        localBundle.putBoolean("from_find_more_friend", ((g)paramb.chg).mParams.getBoolean("from_find_more_friend", false));
        ((g)paramb.chg).chm.Ch().h(str, localBundle);
        AppMethodBeat.o(78589);
      }
    });
    paramb.a("", null);
    AppMethodBeat.o(78590);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openUrlWithExtraWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.am
 * JD-Core Version:    0.7.0.1
 */