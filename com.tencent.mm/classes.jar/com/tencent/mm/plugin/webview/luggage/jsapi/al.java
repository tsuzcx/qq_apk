package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class al
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78590);
    ad.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
    final String str = parama.bZV.bZb.optString("url");
    ad.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", new Object[] { str });
    if (bt.isNullOrNil(str))
    {
      parama.a("fail", null);
      AppMethodBeat.o(78590);
      return;
    }
    Object localObject = Uri.parse(str);
    if ((bt.nullAsNil(((Uri)localObject).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject).getHost() != null) && (!((Uri)localObject).getHost().equals("game.weixin.qq.com"))))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str);
      d.b(((f)parama.bZU).mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      parama.a("", null);
      AppMethodBeat.o(78590);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78589);
        Bundle localBundle = new Bundle();
        localBundle.putString("rawUrl", str);
        localBundle.putBoolean("from_find_more_friend", ((f)parama.bZU).mParams.getBoolean("from_find_more_friend", false));
        ((f)parama.bZU).bZZ.Bb().h(str, localBundle);
        AppMethodBeat.o(78589);
      }
    });
    parama.a("", null);
    AppMethodBeat.o(78590);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openUrlWithExtraWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.al
 * JD-Core Version:    0.7.0.1
 */