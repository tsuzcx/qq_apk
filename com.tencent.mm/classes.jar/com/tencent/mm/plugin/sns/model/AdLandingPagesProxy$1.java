package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import org.json.JSONObject;

final class AdLandingPagesProxy$1
  implements com.tencent.mm.ak.f
{
  AdLandingPagesProxy$1(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(95209);
    ae.i("AdLandingPagesProxy", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    long l;
    if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)paramn).jsonString;
        ae.i("AdLandingPagesProxy", "the dynamic string is " + paramString + ", sceneType is " + paramn.getType());
      }
      for (;;)
      {
        if (AdLandingPagesProxy.a(this.zwg).containsKey(paramn))
        {
          l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
          this.zwg.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramString });
          com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
        }
        AppMethodBeat.o(95209);
        return;
        ae.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramInt1 + " error msg is " + paramString + " sceneType is " + paramn.getType());
        paramString = "";
      }
    }
    if ((paramn instanceof a)) {
      if (!AdLandingPagesProxy.a(this.zwg).containsKey(paramn)) {
        break label1849;
      }
    }
    for (;;)
    {
      try
      {
        l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
        ae.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
        paramString = (vu)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label1877;
        }
        paramString = paramString.toByteArray();
        this.zwg.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
        AppMethodBeat.o(95209);
        return;
      }
      catch (Exception paramString)
      {
        ae.e("AdLandingPagesProxy", bu.o(paramString));
        AppMethodBeat.o(95209);
        return;
      }
      Object localObject;
      if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f))
      {
        if (AdLandingPagesProxy.a(this.zwg).containsKey(paramn))
        {
          l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
          localObject = this.zwg;
          paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f)paramn;
          if (paramString.AaB != null) {}
          for (paramString = paramString.AaB;; paramString = "")
          {
            ((AdLandingPagesProxy)localObject).CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
            AppMethodBeat.o(95209);
            return;
          }
        }
      }
      else
      {
        if ((paramn instanceof com.tencent.mm.plugin.sns.ad.e.g))
        {
          ae.i("AdLandingPagesProxy", "real time report done.");
          com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
          AppMethodBeat.o(95209);
          return;
        }
        if ((paramn instanceof c)) {
          if (!AdLandingPagesProxy.a(this.zwg).containsKey(paramn)) {
            break label1849;
          }
        }
      }
      for (;;)
      {
        try
        {
          l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
          ae.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
          paramString = (bdj)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
          if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
            break label1872;
          }
          paramString = paramString.toByteArray();
          this.zwg.CLIENT_CALL("onGetSmartPhoneScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
          AppMethodBeat.o(95209);
          return;
        }
        catch (Exception paramString)
        {
          ae.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + paramString.toString());
          AppMethodBeat.o(95209);
          return;
        }
        if ((paramn instanceof d)) {
          try
          {
            ae.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + paramInt1 + ", errCode=" + paramInt2);
            com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramString)
          {
            ae.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + paramString.toString());
            AppMethodBeat.o(95209);
            return;
          }
        }
        if ((paramn instanceof i)) {
          if (!AdLandingPagesProxy.a(this.zwg).containsKey(paramn)) {
            break label1849;
          }
        }
        for (;;)
        {
          try
          {
            l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
            ae.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
            paramString = (dsp)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
            if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
              break label1866;
            }
            paramString = paramString.zot;
            this.zwg.CLIENT_CALL("onUpdateUxInfo", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramString)
          {
            ae.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + paramString.toString());
            AppMethodBeat.o(95209);
            return;
          }
          if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b))
          {
            if (!AdLandingPagesProxy.a(this.zwg).containsKey(paramn)) {
              break label1849;
            }
            l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
            ae.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
          }
          for (;;)
          {
            try
            {
              paramString = (cqd)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
              if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                break label1860;
              }
              i = paramString.state;
              this.zwg.CLIENT_CALL("onGetHbCoverStateScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
              com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
              AppMethodBeat.o(95209);
              return;
            }
            catch (Exception paramString)
            {
              ae.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + paramString.toString());
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramn instanceof h)) {}
            for (;;)
            {
              try
              {
                if (AdLandingPagesProxy.a(this.zwg).containsKey(paramn))
                {
                  l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
                  ae.i("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                  paramString = (bhn)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
                  if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                    break label1855;
                  }
                  paramString = paramString.toByteArray();
                  this.zwg.CLIENT_CALL("onAdUpdateQrUrlEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
                  com.tencent.mm.kernel.g.ajj().b(paramn.getType(), AdLandingPagesProxy.b(this.zwg));
                }
                AppMethodBeat.o(95209);
                return;
              }
              catch (Throwable paramString)
              {
                ae.e("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd exp=" + paramString.toString());
                AppMethodBeat.o(95209);
                return;
              }
              if (((paramn instanceof com.tencent.mm.openim.b.b)) || ((paramn instanceof o))) {
                try
                {
                  String str;
                  JSONObject localJSONObject;
                  if (AdLandingPagesProxy.a(this.zwg).containsKey(paramn))
                  {
                    ae.d("AdLandingPagesProxy", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
                    l = ((Long)AdLandingPagesProxy.a(this.zwg).remove(paramn)).longValue();
                    if ((paramn.getType() != 30) && (paramn.getType() != 667))
                    {
                      ae.w("AdLandingPagesProxy", "not expected scene,  type = " + paramn.getType());
                      AppMethodBeat.o(95209);
                      return;
                    }
                    if (((paramn instanceof o)) && (((o)paramn).dto != 1))
                    {
                      ae.e("AdLandingPagesProxy", "not opcode addcontact!");
                      AppMethodBeat.o(95209);
                      return;
                    }
                    str = "";
                    localJSONObject = new JSONObject();
                    localObject = str;
                    if (paramInt1 == 0)
                    {
                      localObject = str;
                      if (paramInt2 == 0)
                      {
                        if (paramn.getType() != 30) {
                          break label1795;
                        }
                        localObject = ((o)paramn).fdt();
                      }
                    }
                  }
                  for (;;)
                  {
                    localJSONObject.put("errMsg", paramString);
                    localJSONObject.put("respUsername", localObject);
                    this.zwg.CLIENT_CALL("onAddBrandSceneEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localJSONObject.toString() });
                    b.e(AdLandingPagesProxy.b(this.zwg));
                    AppMethodBeat.o(95209);
                    return;
                    label1795:
                    localObject = str;
                    if (paramn.getType() == 667) {
                      localObject = ((com.tencent.mm.openim.b.b)paramn).iKt;
                    }
                  }
                  AppMethodBeat.o(95209);
                }
                catch (Throwable paramString)
                {
                  ae.e("AdLandingPagesProxy", "NetSceneAddOpenIMContact or NetSceneVerifyUser onSceneEnd exp=" + paramString.toString());
                }
              }
              label1849:
              return;
              label1855:
              paramString = null;
            }
            label1860:
            int i = -1;
          }
          label1866:
          paramString = "";
        }
        label1872:
        paramString = null;
      }
      label1877:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.1
 * JD-Core Version:    0.7.0.1
 */