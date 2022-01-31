package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class l
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    JSONObject localJSONObject = parama.bih.bhk;
    String str = localJSONObject.optString("brandIcon");
    localJSONObject.optString("brandName");
    y.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str });
    ((e)parama.big).cba().TC(str);
    parama.a("", null);
  }
  
  public final String name()
  {
    return "currentMpInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */