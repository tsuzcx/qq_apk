package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class ad
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
    String str = parama.bih.bhk.optString("url");
    y.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", new Object[] { str });
    ai.d(new ad.1(this, str, parama));
    parama.a("", null);
  }
  
  public final String name()
  {
    return "openUrlWithExtraWebview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ad
 * JD-Core Version:    0.7.0.1
 */