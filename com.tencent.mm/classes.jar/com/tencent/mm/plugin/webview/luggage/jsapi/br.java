package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class br<T extends g>
  extends bq<T>
{
  public final void a(b<T>.a paramb)
  {
    JSONObject localJSONObject = paramb.chh.cgn;
    String str = ((g)paramb.chg).getUrl();
    Object localObject1 = ((g)paramb.chg).ePi();
    if (localObject1 != null) {}
    label160:
    Object localObject2;
    for (localObject1 = ((c)localObject1).aHL(str);; localObject2 = null)
    {
      if (bt.isNullOrNil((String)localObject1)) {
        localObject1 = str;
      }
      for (;;)
      {
        GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.wg(((g)paramb.chg).bQm());
        if (localGameWebPerformanceInfo != null) {
          localGameWebPerformanceInfo.gsl = 1;
        }
        try
        {
          localJSONObject.put("currentUrl", str);
          localJSONObject.put("shareUrl", localObject1);
          if (((g)paramb.chg).DOL != null) {
            localJSONObject.put("preVerifyAppId", ((g)paramb.chg).DOL.getAppId());
          }
          if (getClass().getName().equals(ba.class.getName()))
          {
            localJSONObject.put("sendAppMessageScene", ba.ePO());
            ba.ePP();
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
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.br
 * JD-Core Version:    0.7.0.1
 */