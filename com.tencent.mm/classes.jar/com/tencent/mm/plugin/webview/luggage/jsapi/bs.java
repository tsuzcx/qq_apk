package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bs<T extends g>
  extends br<T>
{
  public final void a(b<T>.a paramb)
  {
    JSONObject localJSONObject = paramb.crh.cqn;
    String str = ((g)paramb.crg).getUrl();
    Object localObject1 = ((g)paramb.crg).gUA();
    if (localObject1 != null) {}
    label160:
    Object localObject2;
    for (localObject1 = ((c)localObject1).bld(str);; localObject2 = null)
    {
      if (Util.isNullOrNil((String)localObject1)) {
        localObject1 = str;
      }
      for (;;)
      {
        GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.LZ(((g)paramb.crg).cDu());
        if (localGameWebPerformanceInfo != null) {
          localGameWebPerformanceInfo.jTz = 1;
        }
        try
        {
          localJSONObject.put("currentUrl", str);
          localJSONObject.put("shareUrl", localObject1);
          if (((g)paramb.crg).PPO != null) {
            localJSONObject.put("preVerifyAppId", ((g)paramb.crg).PPO.getAppId());
          }
          if (getClass().getName().equals(bb.class.getName()))
          {
            localJSONObject.put("sendAppMessageScene", bb.gVg());
            bb.gVh();
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
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bs
 * JD-Core Version:    0.7.0.1
 */