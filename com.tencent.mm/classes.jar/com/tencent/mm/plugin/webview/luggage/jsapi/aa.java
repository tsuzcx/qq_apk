package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.n;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class aa
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a.a parama)
  {
    parama = parama.bih.bhk;
    y.i("MicroMsg.JsApiLog", "jslog : " + parama.optString("msg"));
  }
  
  public final String name()
  {
    return "log";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */