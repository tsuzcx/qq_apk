package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.r;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ax<T extends e>
  extends aw<T>
{
  public final void a(a<T>.a parama)
  {
    JSONObject localJSONObject = parama.bih.bhk;
    String str = ((e)parama.big).getUrl();
    try
    {
      localJSONObject.put("currentUrl", str);
      localJSONObject.put("shareUrl", ((e)parama.big).caW().RR(str));
      localJSONObject.put("preVerifyAppId", ((e)parama.big).rbS.getAppId());
      if (getClass().getName().equals(ak.class.getName()))
      {
        localJSONObject.put("sendAppMessageScene", ak.cbx());
        ak.cby();
      }
      label99:
      super.a(parama);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label99;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */