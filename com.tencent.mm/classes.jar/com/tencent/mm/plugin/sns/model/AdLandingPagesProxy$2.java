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
    AppMethodBeat.i(239749);
    str = "";
    try
    {
      localg = h.o(this.val$appId, true, false);
      if (localg != null) {
        break label150;
      }
      Log.i("AdLandingPagesProxy", "getOpenSdkAppInfoMM, no cahcer, appId=" + this.val$appId);
      localg = h.dl(this.val$appId, true);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        g localg;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("icon", Util.nullAsNil(localg.field_appIconUrl));
        ((JSONObject)localObject).put("name", Util.nullAsNil(localg.field_appName));
        ((JSONObject)localObject).put("pkg", Util.nullAsNil(localg.field_packageName));
        for (localObject = ((JSONObject)localObject).toString();; localObject = str)
        {
          this.JTn.CLIENT_CALL("onGetOpenSdkAppInfo", new Object[] { localObject, Long.valueOf(this.JTo) });
          AppMethodBeat.o(239749);
          return;
          Log.i("AdLandingPagesProxy", "getOpenSdkAppInfoMM, hit cache, appId=" + this.val$appId);
          break;
          localThrowable = localThrowable;
          Log.e("AdLandingPagesProxy", "getOpenSdkAppInfoMM, exp=" + localThrowable.toString());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = str;
        }
      }
    }
    localObject = str;
    if (localg == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.2
 * JD-Core Version:    0.7.0.1
 */