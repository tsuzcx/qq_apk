package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.e.17;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiDisableBounceScroll", "invoke");
    Object localObject = parama.bih.bhk.optJSONArray("place");
    if (localObject == null)
    {
      y.i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
      parama.a("fail", null);
      return;
    }
    int j = 0;
    int i = 0;
    if (j < ((JSONArray)localObject).length())
    {
      if (!"top".equalsIgnoreCase(((JSONArray)localObject).optString(j))) {
        break label124;
      }
      i = 1;
    }
    label124:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0)
      {
        parama.a("", null);
        return;
      }
      localObject = (e)parama.big;
      ((e)localObject).mHandler.post(new e.17((e)localObject));
      parama.a("", null);
      return;
    }
  }
  
  public final String name()
  {
    return "disableBounceScroll";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */