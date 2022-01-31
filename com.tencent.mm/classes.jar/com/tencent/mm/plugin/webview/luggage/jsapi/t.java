package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public class t
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiHideMenuItems", "invokeInOwn");
    JSONArray localJSONArray = parama.bih.bhk.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      y.i("MicroMsg.JsApiHideMenuItems", "data is null");
      parama.a("invalid_data", null);
      return;
    }
    m localm = ((e)parama.big).rbE;
    if ((localm != null) && (localJSONArray != null))
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        localm.getMenuHelp().RN(localJSONArray.optString(i));
        i += 1;
      }
    }
    parama.a("", null);
  }
  
  public final String name()
  {
    return "hideMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.t
 * JD-Core Version:    0.7.0.1
 */