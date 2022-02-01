package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bo<T extends f>
  extends bn<T>
{
  public final void a(a<T>.a parama)
  {
    JSONObject localJSONObject = parama.bWS.bVY;
    String str = ((f)parama.bWR).getUrl();
    Object localObject1 = ((f)parama.bWR).eAs();
    if (localObject1 != null) {}
    label160:
    Object localObject2;
    for (localObject1 = ((c)localObject1).aCl(str);; localObject2 = null)
    {
      if (bs.isNullOrNil((String)localObject1)) {
        localObject1 = str;
      }
      for (;;)
      {
        GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.tq(((f)parama.bWR).bLL());
        if (localGameWebPerformanceInfo != null) {
          localGameWebPerformanceInfo.fYP = 1;
        }
        try
        {
          localJSONObject.put("currentUrl", str);
          localJSONObject.put("shareUrl", localObject1);
          if (((f)parama.bWR).ClA != null) {
            localJSONObject.put("preVerifyAppId", ((f)parama.bWR).ClA.getAppId());
          }
          if (getClass().getName().equals(ax.class.getName()))
          {
            localJSONObject.put("sendAppMessageScene", ax.eAW());
            ax.eAX();
          }
        }
        catch (JSONException localJSONException)
        {
          break label160;
        }
        super.a(parama);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bo
 * JD-Core Version:    0.7.0.1
 */