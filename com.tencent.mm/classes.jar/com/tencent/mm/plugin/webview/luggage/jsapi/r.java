package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class r
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
    paramContext = c.tJ(paramString);
    if (paramContext == null)
    {
      y.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
      parama.e("fail", null);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    paramContext = q.zf();
    String str = q.zg();
    if ((!bk.bl(paramContext)) && (!bk.bl(str)) && (!bk.bl(paramString)))
    {
      paramContext = ad.bB(ad.bB(paramString + paramContext));
      str = ad.bB(ad.bB(paramString + str));
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("deviceid", paramContext);
      paramString.put("newDeviceId", str);
      label146:
      parama.e(null, paramString);
      return;
      parama.e("fail", null);
      return;
    }
    catch (JSONException paramContext)
    {
      break label146;
    }
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a<e>.a parama) {}
  
  public final String name()
  {
    return "getOpenDeviceId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.r
 * JD-Core Version:    0.7.0.1
 */