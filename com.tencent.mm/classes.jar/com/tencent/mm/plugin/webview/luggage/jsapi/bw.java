package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bw<T extends g>
  extends bv<T>
{
  public final void a(b<T>.a paramb)
  {
    JSONObject localJSONObject = paramb.eiZ.eif;
    String str = ((g)paramb.eiY).getUrl();
    Object localObject1 = ((g)paramb.eiY).iuj();
    if (localObject1 != null) {}
    label160:
    Object localObject2;
    for (localObject1 = ((c)localObject1).bkG(str);; localObject2 = null)
    {
      if (Util.isNullOrNil((String)localObject1)) {
        localObject1 = str;
      }
      for (;;)
      {
        GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.EI(((g)paramb.eiY).dgY());
        if (localGameWebPerformanceInfo != null) {
          localGameWebPerformanceInfo.mtR = 1;
        }
        try
        {
          localJSONObject.put("currentUrl", str);
          localJSONObject.put("shareUrl", localObject1);
          if (((g)paramb.eiY).WGh != null) {
            localJSONObject.put("preVerifyAppId", ((g)paramb.eiY).WGh.getAppId());
          }
          if (getClass().getName().equals(bf.class.getName()))
          {
            localJSONObject.put("sendAppMessageScene", bf.iuR());
            bf.iuS();
          }
        }
        catch (JSONException localJSONException)
        {
          break label160;
        }
        super.a(paramb);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bw
 * JD-Core Version:    0.7.0.1
 */