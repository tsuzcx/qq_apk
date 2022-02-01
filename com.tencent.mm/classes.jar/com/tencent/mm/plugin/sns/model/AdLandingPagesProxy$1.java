package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.l;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

final class AdLandingPagesProxy$1
  implements com.tencent.mm.an.i
{
  AdLandingPagesProxy$1(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(95209);
    Object localObject1 = new StringBuilder("onSceneEnd, funcId=");
    int i;
    if (paramq == null)
    {
      i = 0;
      Log.i("AdLandingPagesProxy", i + ", errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      if (!(paramq instanceof j)) {
        break label273;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label224;
      }
      paramString = ((j)paramq).jsonString;
      Log.i("AdLandingPagesProxy", "the dynamic string is " + paramString + ", sceneType is " + paramq.getType());
    }
    long l;
    for (;;)
    {
      if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
      {
        l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
        this.JTn.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramString });
        com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
      }
      AppMethodBeat.o(95209);
      return;
      i = paramq.getType();
      break;
      label224:
      Log.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramInt1 + " error msg is " + paramString + " sceneType is " + paramq.getType());
      paramString = "";
    }
    label273:
    if ((paramq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b)) {
      if (!AdLandingPagesProxy.a(this.JTn).containsKey(paramq)) {
        break label2389;
      }
    }
    for (;;)
    {
      try
      {
        l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
        Log.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
        paramString = (xi)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label2456;
        }
        paramString = paramString.toByteArray();
        this.JTn.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
        AppMethodBeat.o(95209);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("AdLandingPagesProxy", Util.stackTraceToString(paramString));
        AppMethodBeat.o(95209);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i))
      {
        if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
        {
          l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
          localObject1 = this.JTn;
          paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i)paramq;
          if (paramString.Kwb != null) {}
          for (paramString = paramString.Kwb;; paramString = "")
          {
            ((AdLandingPagesProxy)localObject1).CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
            AppMethodBeat.o(95209);
            return;
          }
        }
      }
      else
      {
        if ((paramq instanceof com.tencent.mm.plugin.sns.ad.f.h))
        {
          Log.i("AdLandingPagesProxy", "real time report done.");
          com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
          AppMethodBeat.o(95209);
          return;
        }
        if ((paramq instanceof e)) {
          if (!AdLandingPagesProxy.a(this.JTn).containsKey(paramq)) {
            break label2389;
          }
        }
      }
      for (;;)
      {
        try
        {
          l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
          Log.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
          paramString = (bws)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
          if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
            break label2451;
          }
          paramString = paramString.toByteArray();
          this.JTn.CLIENT_CALL("onGetSmartPhoneScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
          AppMethodBeat.o(95209);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + paramString.toString());
          AppMethodBeat.o(95209);
          return;
        }
        if ((paramq instanceof g)) {
          try
          {
            Log.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + paramInt1 + ", errCode=" + paramInt2);
            com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramString)
          {
            Log.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + paramString.toString());
            AppMethodBeat.o(95209);
            return;
          }
        }
        if ((paramq instanceof l)) {
          if (!AdLandingPagesProxy.a(this.JTn).containsKey(paramq)) {
            break label2389;
          }
        }
        for (;;)
        {
          try
          {
            l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
            Log.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
            paramString = (ewv)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
            if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
              break label2445;
            }
            paramString = paramString.jDL;
            this.JTn.CLIENT_CALL("onUpdateUxInfo", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramString)
          {
            Log.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + paramString.toString());
            AppMethodBeat.o(95209);
            return;
          }
          if ((paramq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d))
          {
            if (!AdLandingPagesProxy.a(this.JTn).containsKey(paramq)) {
              break label2389;
            }
            l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
            Log.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
          }
          for (;;)
          {
            try
            {
              paramString = (dru)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
              if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                break label2439;
              }
              i = paramString.state;
              this.JTn.CLIENT_CALL("onGetHbCoverStateScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
              com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
              AppMethodBeat.o(95209);
              return;
            }
            catch (Exception paramString)
            {
              Log.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + paramString.toString());
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramq instanceof k)) {}
            for (;;)
            {
              try
              {
                if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
                {
                  l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
                  Log.i("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                  paramString = (cbd)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
                  if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                    break label2434;
                  }
                  paramString = paramString.toByteArray();
                  this.JTn.CLIENT_CALL("onAdUpdateQrUrlEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
                  com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
                }
                AppMethodBeat.o(95209);
                return;
              }
              catch (Throwable paramString)
              {
                Log.e("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd exp=" + paramString.toString());
                AppMethodBeat.o(95209);
                return;
              }
              Object localObject2;
              if (((paramq instanceof com.tencent.mm.openim.b.b)) || ((paramq instanceof com.tencent.mm.pluginsdk.model.t))) {
                try
                {
                  JSONObject localJSONObject;
                  if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
                  {
                    Log.d("AdLandingPagesProxy", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
                    l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
                    if ((paramq.getType() != 30) && (paramq.getType() != 667))
                    {
                      Log.w("AdLandingPagesProxy", "not expected scene,  type = " + paramq.getType());
                      AppMethodBeat.o(95209);
                      return;
                    }
                    if (((paramq instanceof com.tencent.mm.pluginsdk.model.t)) && (((com.tencent.mm.pluginsdk.model.t)paramq).fDn != 1))
                    {
                      Log.e("AdLandingPagesProxy", "not opcode addcontact!");
                      AppMethodBeat.o(95209);
                      return;
                    }
                    localObject2 = "";
                    localJSONObject = new JSONObject();
                    localObject1 = localObject2;
                    if (paramInt1 == 0)
                    {
                      localObject1 = localObject2;
                      if (paramInt2 == 0)
                      {
                        if (paramq.getType() != 30) {
                          break label1827;
                        }
                        localObject1 = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
                      }
                    }
                  }
                  for (;;)
                  {
                    localJSONObject.put("errMsg", paramString);
                    localJSONObject.put("respUsername", localObject1);
                    this.JTn.CLIENT_CALL("onAddBrandSceneEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localJSONObject.toString() });
                    b.d(AdLandingPagesProxy.b(this.JTn));
                    AppMethodBeat.o(95209);
                    return;
                    label1827:
                    localObject1 = localObject2;
                    if (paramq.getType() == 667) {
                      localObject1 = ((com.tencent.mm.openim.b.b)paramq).myd;
                    }
                  }
                  if (!(paramq instanceof f)) {}
                }
                catch (Throwable paramString)
                {
                  Log.e("AdLandingPagesProxy", "NetSceneAddOpenIMContact or NetSceneVerifyUser onSceneEnd exp=" + paramString.toString());
                  AppMethodBeat.o(95209);
                  return;
                }
              }
              for (;;)
              {
                try
                {
                  if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
                  {
                    l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
                    paramString = (ebp)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
                    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                      break label2429;
                    }
                    paramString = paramString.toByteArray();
                    this.JTn.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
                  }
                }
                catch (Throwable paramString)
                {
                  Log.e("AdLandingPagesProxy", "NetSceneSearchContact, onSceneEnd exp=" + paramString.toString());
                  continue;
                }
                com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
                AppMethodBeat.o(95209);
                return;
                if ((paramq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a)) {}
                for (;;)
                {
                  try
                  {
                    if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
                    {
                      l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
                      paramString = (bo)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
                      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
                        break label2424;
                      }
                      paramString = paramString.toByteArray();
                      this.JTn.CLIENT_CALL("onAdNativeAntiAbuse", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
                    }
                  }
                  catch (Throwable paramString)
                  {
                    Log.e("AdLandingPagesProxy", "NetSceneAdAntiAbuse, onSceneEnd exp = " + paramString.toString());
                    continue;
                  }
                  com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
                  AppMethodBeat.o(95209);
                  return;
                  if (paramq != null) {}
                  try
                  {
                    if (AdLandingPagesProxy.a(this.JTn).containsKey(paramq))
                    {
                      l = ((Long)AdLandingPagesProxy.a(this.JTn).remove(paramq)).longValue();
                      localObject2 = d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
                      localObject1 = null;
                      paramString = (String)localObject1;
                      if (paramInt1 == 0)
                      {
                        paramString = (String)localObject1;
                        if (paramInt2 == 0)
                        {
                          paramString = (String)localObject1;
                          if (localObject2 != null) {
                            paramString = ((com.tencent.mm.cd.a)localObject2).toByteArray();
                          }
                        }
                      }
                      this.JTn.CLIENT_CALL("onRspCallbackCommon", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
                    }
                  }
                  catch (Throwable paramString)
                  {
                    for (;;)
                    {
                      Log.e("AdLandingPagesProxy", "default, onSceneEnd exp=" + paramString.toString());
                    }
                  }
                  com.tencent.mm.kernel.h.aGY().b(paramq.getType(), AdLandingPagesProxy.b(this.JTn));
                  label2389:
                  AppMethodBeat.o(95209);
                  return;
                  label2424:
                  paramString = null;
                }
                label2429:
                paramString = null;
              }
              label2434:
              paramString = null;
            }
            label2439:
            i = -1;
          }
          label2445:
          paramString = "";
        }
        label2451:
        paramString = null;
      }
      label2456:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.1
 * JD-Core Version:    0.7.0.1
 */