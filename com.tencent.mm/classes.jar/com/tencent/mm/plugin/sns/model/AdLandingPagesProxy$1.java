package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.sns.a.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Map;

final class AdLandingPagesProxy$1
  implements f
{
  AdLandingPagesProxy$1(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm.toString() });
    if ((paramm instanceof c)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((c)paramm).bTX;
        y.i("AdLandingPagesProxy", "the dynamic string is " + paramString + ", sceneType is " + paramm.getType());
        if (AdLandingPagesProxy.a(this.oow).containsKey(paramm))
        {
          l = ((Long)AdLandingPagesProxy.a(this.oow).remove(paramm)).longValue();
          this.oow.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramString });
        }
      }
    }
    do
    {
      return;
      y.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramInt1 + " error msg is " + paramString + " sceneType is " + paramm.getType());
      paramString = "";
      break;
      if (!(paramm instanceof a)) {
        break label345;
      }
    } while (!AdLandingPagesProxy.a(this.oow).containsKey(paramm));
    long l = ((Long)AdLandingPagesProxy.a(this.oow).remove(paramm)).longValue();
    paramString = (ny)((com.tencent.mm.ah.b)paramm.edi).ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null)) {}
    for (;;)
    {
      try
      {
        paramString = paramString.toByteArray();
        this.oow.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        return;
      }
      catch (IOException paramString)
      {
        y.e("AdLandingPagesProxy", bk.j(paramString));
        return;
      }
      label345:
      if ((paramm instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b))
      {
        if (!AdLandingPagesProxy.a(this.oow).containsKey(paramm)) {
          break;
        }
        l = ((Long)AdLandingPagesProxy.a(this.oow).remove(paramm)).longValue();
        AdLandingPagesProxy localAdLandingPagesProxy = this.oow;
        paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b)paramm;
        if (paramString.oJN != null) {}
        for (paramString = paramString.oJN;; paramString = "")
        {
          localAdLandingPagesProxy.CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return;
        }
      }
      if (!(paramm instanceof e)) {
        break;
      }
      y.i("AdLandingPagesProxy", "real time report done.");
      return;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.1
 * JD-Core Version:    0.7.0.1
 */