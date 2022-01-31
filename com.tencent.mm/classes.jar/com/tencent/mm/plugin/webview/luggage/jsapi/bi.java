package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bi<T extends e>
  extends bh<T>
{
  public final void a(a<T>.a parama)
  {
    JSONObject localJSONObject = parama.byF.bxK;
    String str = ((e)parama.byE).getUrl();
    Object localObject1 = ((e)parama.byE).dba();
    if (localObject1 != null) {}
    label138:
    Object localObject2;
    for (localObject1 = ((LuggageGetA8Key)localObject1).agU(str);; localObject2 = null)
    {
      if (bo.isNullOrNil((String)localObject1)) {
        localObject1 = str;
      }
      for (;;)
      {
        GameWebPerformanceInfo.lN(((e)parama.byE).daZ()).ezW = 1;
        try
        {
          localJSONObject.put("currentUrl", str);
          localJSONObject.put("shareUrl", localObject1);
          localJSONObject.put("preVerifyAppId", ((e)parama.byE).uRD.getAppId());
          if (getClass().getName().equals(au.class.getName()))
          {
            localJSONObject.put("sendAppMessageScene", au.dbB());
            au.dbC();
          }
          super.a(parama);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label138;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bi
 * JD-Core Version:    0.7.0.1
 */