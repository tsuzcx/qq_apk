package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ai
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6342);
    ab.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
    String str = parama.byF.bxK.optString("url");
    ab.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", new Object[] { str });
    if (bo.isNullOrNil(str))
    {
      parama.a("fail", null);
      AppMethodBeat.o(6342);
      return;
    }
    Object localObject = Uri.parse(str);
    if ((((Uri)localObject).getHost() != null) && (!((Uri)localObject).getHost().equals("game.weixin.qq.com")))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str);
      d.b(((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      parama.a("", null);
      AppMethodBeat.o(6342);
      return;
    }
    al.d(new ai.1(this, str, parama));
    parama.a("", null);
    AppMethodBeat.o(6342);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openUrlWithExtraWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */