package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class AdLandingPagesProxy$1
  implements com.tencent.mm.al.f
{
  AdLandingPagesProxy$1(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(95209);
    ad.i("AdLandingPagesProxy", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    long l;
    if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)paramn).jsonString;
        ad.i("AdLandingPagesProxy", "the dynamic string is " + paramString + ", sceneType is " + paramn.getType());
      }
      for (;;)
      {
        if (AdLandingPagesProxy.a(this.zfr).containsKey(paramn))
        {
          l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
          this.zfr.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramString });
          com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
        }
        AppMethodBeat.o(95209);
        return;
        ad.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramInt1 + " error msg is " + paramString + " sceneType is " + paramn.getType());
        paramString = "";
      }
    }
    if ((paramn instanceof a)) {
      if (!AdLandingPagesProxy.a(this.zfr).containsKey(paramn)) {
        break label1477;
      }
    }
    for (;;)
    {
      try
      {
        l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
        ad.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
        paramString = (vs)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label1505;
        }
        paramString = paramString.toByteArray();
        this.zfr.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
        AppMethodBeat.o(95209);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("AdLandingPagesProxy", bt.n(paramString));
        AppMethodBeat.o(95209);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f))
      {
        if (AdLandingPagesProxy.a(this.zfr).containsKey(paramn))
        {
          l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
          AdLandingPagesProxy localAdLandingPagesProxy = this.zfr;
          paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f)paramn;
          if (paramString.zJu != null) {}
          for (paramString = paramString.zJu;; paramString = "")
          {
            localAdLandingPagesProxy.CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
            AppMethodBeat.o(95209);
            return;
          }
        }
      }
      else
      {
        if ((paramn instanceof com.tencent.mm.plugin.sns.ad.d.g))
        {
          ad.i("AdLandingPagesProxy", "real time report done.");
          com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
          AppMethodBeat.o(95209);
          return;
        }
        if ((paramn instanceof c)) {
          if (!AdLandingPagesProxy.a(this.zfr).containsKey(paramn)) {
            break label1477;
          }
        }
      }
      for (;;)
      {
        try
        {
          l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
          ad.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
          paramString = (bct)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
          if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
            break label1500;
          }
          paramString = paramString.toByteArray();
          this.zfr.CLIENT_CALL("onGetSmartPhoneScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
          AppMethodBeat.o(95209);
          return;
        }
        catch (Exception paramString)
        {
          ad.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + paramString.toString());
          AppMethodBeat.o(95209);
          return;
        }
        if ((paramn instanceof d)) {
          try
          {
            ad.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + paramInt1 + ", errCode=" + paramInt2);
            com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramString)
          {
            ad.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + paramString.toString());
            AppMethodBeat.o(95209);
            return;
          }
        }
        if ((paramn instanceof i)) {
          if (!AdLandingPagesProxy.a(this.zfr).containsKey(paramn)) {
            break label1477;
          }
        }
        for (;;)
        {
          try
          {
            l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
            ad.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
            paramString = (drs)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
            if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
              break label1494;
            }
            paramString = paramString.yXS;
            this.zfr.CLIENT_CALL("onUpdateUxInfo", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramString)
          {
            ad.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + paramString.toString());
            AppMethodBeat.o(95209);
            return;
          }
          if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b))
          {
            if (!AdLandingPagesProxy.a(this.zfr).containsKey(paramn)) {
              break label1477;
            }
            l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
            ad.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
          }
          for (;;)
          {
            try
            {
              paramString = (cpj)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
              if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                break label1488;
              }
              i = paramString.state;
              this.zfr.CLIENT_CALL("onGetHbCoverStateScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
              com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
              AppMethodBeat.o(95209);
              return;
            }
            catch (Exception paramString)
            {
              ad.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + paramString.toString());
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramn instanceof h)) {}
            for (;;)
            {
              try
              {
                if (AdLandingPagesProxy.a(this.zfr).containsKey(paramn))
                {
                  l = ((Long)AdLandingPagesProxy.a(this.zfr).remove(paramn)).longValue();
                  ad.i("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                  paramString = (bgx)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
                  if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                    break label1483;
                  }
                  paramString = paramString.toByteArray();
                  this.zfr.CLIENT_CALL("onAdUpdateQrUrlEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
                  com.tencent.mm.kernel.g.aiU().b(paramn.getType(), AdLandingPagesProxy.b(this.zfr));
                }
                AppMethodBeat.o(95209);
                return;
              }
              catch (Throwable paramString)
              {
                ad.e("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd exp=" + paramString.toString());
              }
              label1477:
              AppMethodBeat.o(95209);
              return;
              label1483:
              paramString = null;
            }
            label1488:
            int i = -1;
          }
          label1494:
          paramString = "";
        }
        label1500:
        paramString = null;
      }
      label1505:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.1
 * JD-Core Version:    0.7.0.1
 */