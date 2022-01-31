package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Map;

final class AdLandingPagesProxy$1
  implements f
{
  AdLandingPagesProxy$1(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(35911);
    ab.i("AdLandingPagesProxy", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm.toString() });
    long l;
    if ((paramm instanceof c))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((c)paramm).jsonString;
        ab.i("AdLandingPagesProxy", "the dynamic string is " + paramString + ", sceneType is " + paramm.getType());
      }
      for (;;)
      {
        if (AdLandingPagesProxy.a(this.rcM).containsKey(paramm))
        {
          l = ((Long)AdLandingPagesProxy.a(this.rcM).remove(paramm)).longValue();
          this.rcM.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramString });
          g.Rc().b(paramm.getType(), AdLandingPagesProxy.b(this.rcM));
        }
        AppMethodBeat.o(35911);
        return;
        ab.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramInt1 + " error msg is " + paramString + " sceneType is " + paramm.getType());
        paramString = "";
      }
    }
    if ((paramm instanceof a))
    {
      if (!AdLandingPagesProxy.a(this.rcM).containsKey(paramm)) {
        break label592;
      }
      l = ((Long)AdLandingPagesProxy.a(this.rcM).remove(paramm)).longValue();
      ab.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
      paramString = (ra)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta;
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
        break label598;
      }
    }
    for (;;)
    {
      try
      {
        paramString = paramString.toByteArray();
        this.rcM.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        g.Rc().b(paramm.getType(), AdLandingPagesProxy.b(this.rcM));
        AppMethodBeat.o(35911);
        return;
      }
      catch (IOException paramString)
      {
        ab.e("AdLandingPagesProxy", bo.l(paramString));
        AppMethodBeat.o(35911);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b))
      {
        if (AdLandingPagesProxy.a(this.rcM).containsKey(paramm))
        {
          l = ((Long)AdLandingPagesProxy.a(this.rcM).remove(paramm)).longValue();
          AdLandingPagesProxy localAdLandingPagesProxy = this.rcM;
          paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b)paramm;
          if (paramString.rzL != null) {}
          for (paramString = paramString.rzL;; paramString = "")
          {
            localAdLandingPagesProxy.CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            g.Rc().b(paramm.getType(), AdLandingPagesProxy.b(this.rcM));
            AppMethodBeat.o(35911);
            return;
          }
        }
      }
      else if ((paramm instanceof e))
      {
        ab.i("AdLandingPagesProxy", "real time report done.");
        g.Rc().b(paramm.getType(), AdLandingPagesProxy.b(this.rcM));
      }
      label592:
      AppMethodBeat.o(35911);
      return;
      label598:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.1
 * JD-Core Version:    0.7.0.1
 */