package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

final class AdLandingPagesProxy$2
  implements Runnable
{
  AdLandingPagesProxy$2(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(309459);
    str = "";
    try
    {
      localg = h.s(this.etl, true, false);
      if (localg != null) {
        break label150;
      }
      Log.i("AdLandingPagesProxy", "getOpenSdkAppInfoMM, no cahcer, appId=" + this.etl);
      localg = h.dV(this.etl, true);
    }
    finally
    {
      try
      {
        g localg;
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("icon", Util.nullAsNil(localg.field_appIconUrl));
        ((JSONObject)localObject2).put("name", Util.nullAsNil(localg.field_appName));
        ((JSONObject)localObject2).put("pkg", Util.nullAsNil(localg.field_packageName));
        for (localObject2 = ((JSONObject)localObject2).toString();; localObject2 = str)
        {
          this.Qqp.CLIENT_CALL("onGetOpenSdkAppInfo", new Object[] { localObject2, Long.valueOf(this.Qqq) });
          AppMethodBeat.o(309459);
          return;
          Log.i("AdLandingPagesProxy", "getOpenSdkAppInfoMM, hit cache, appId=" + this.etl);
          break;
          localObject1 = finally;
          Log.e("AdLandingPagesProxy", "getOpenSdkAppInfoMM, exp=" + localObject1.toString());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = str;
        }
      }
    }
    localObject2 = str;
    if (localg == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.2
 * JD-Core Version:    0.7.0.1
 */