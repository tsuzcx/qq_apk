package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.3;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.s;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AdLandingPagesProxy
  extends com.tencent.mm.remoteservice.a
{
  private static AdLandingPagesProxy DGl;
  public static f DGn;
  private Map<q, Long> DGm;
  private ConcurrentHashMap<Long, ArrayList<a>> DGo;
  private a.b DGp;
  private Map<String, g> DGq;
  private Map<String, h.a> DGr;
  private com.tencent.mm.remoteservice.d Dxo;
  private Map<Long, e> callbacks;
  private com.tencent.mm.ak.i gNh;
  
  static
  {
    AppMethodBeat.i(95375);
    DGn = new f();
    AppMethodBeat.o(95375);
  }
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    AppMethodBeat.i(95227);
    this.callbacks = new HashMap();
    this.DGm = new HashMap();
    this.gNh = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(95209);
        Object localObject1 = new StringBuilder("onSceneEnd, funcId=");
        int i;
        if (paramAnonymousq == null)
        {
          i = 0;
          Log.i("AdLandingPagesProxy", i + ", errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2 + ", errMsg=" + paramAnonymousString);
          if (!(paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j)) {
            break label273;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label224;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j)paramAnonymousq).jsonString;
          Log.i("AdLandingPagesProxy", "the dynamic string is " + paramAnonymousString + ", sceneType is " + paramAnonymousq.getType());
        }
        long l;
        for (;;)
        {
          if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
          {
            l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
            AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramAnonymousString });
            com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
          }
          AppMethodBeat.o(95209);
          return;
          i = paramAnonymousq.getType();
          break;
          label224:
          Log.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramAnonymousInt1 + " error msg is " + paramAnonymousString + " sceneType is " + paramAnonymousq.getType());
          paramAnonymousString = "";
        }
        label273:
        if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b)) {
          if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq)) {
            break label2389;
          }
        }
        for (;;)
        {
          try
          {
            l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
            Log.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
            paramAnonymousString = (xc)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
              break label2456;
            }
            paramAnonymousString = paramAnonymousString.toByteArray();
            AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.e("AdLandingPagesProxy", Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(95209);
            return;
          }
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i))
          {
            if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
              localObject1 = AdLandingPagesProxy.this;
              paramAnonymousString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i)paramAnonymousq;
              if (paramAnonymousString.EiS != null) {}
              for (paramAnonymousString = paramAnonymousString.EiS;; paramAnonymousString = "")
              {
                ((AdLandingPagesProxy)localObject1).CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
            }
          }
          else
          {
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.ad.g.h))
            {
              Log.i("AdLandingPagesProxy", "real time report done.");
              com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e)) {
              if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq)) {
                break label2389;
              }
            }
          }
          for (;;)
          {
            try
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
              Log.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
              paramAnonymousString = (box)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                break label2451;
              }
              paramAnonymousString = paramAnonymousString.toByteArray();
              AdLandingPagesProxy.this.CLIENT_CALL("onGetSmartPhoneScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
              AppMethodBeat.o(95209);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              Log.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + paramAnonymousString.toString());
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)) {
              try
              {
                Log.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2);
                com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
              catch (Exception paramAnonymousString)
              {
                Log.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(95209);
                return;
              }
            }
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.l)) {
              if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq)) {
                break label2389;
              }
            }
            for (;;)
            {
              try
              {
                l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                Log.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                paramAnonymousString = (emn)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                  break label2445;
                }
                paramAnonymousString = paramAnonymousString.gTk;
                AdLandingPagesProxy.this.CLIENT_CALL("onUpdateUxInfo", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
              catch (Exception paramAnonymousString)
              {
                Log.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(95209);
                return;
              }
              if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d))
              {
                if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq)) {
                  break label2389;
                }
                l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                Log.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
              }
              for (;;)
              {
                try
                {
                  paramAnonymousString = (dic)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                    break label2439;
                  }
                  i = paramAnonymousString.state;
                  AdLandingPagesProxy.this.CLIENT_CALL("onGetHbCoverStateScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
                  com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                  AppMethodBeat.o(95209);
                  return;
                }
                catch (Exception paramAnonymousString)
                {
                  Log.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + paramAnonymousString.toString());
                  AppMethodBeat.o(95209);
                  return;
                }
                if ((paramAnonymousq instanceof k)) {}
                for (;;)
                {
                  try
                  {
                    if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
                    {
                      l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                      Log.i("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                      paramAnonymousString = (btl)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
                      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                        break label2434;
                      }
                      paramAnonymousString = paramAnonymousString.toByteArray();
                      AdLandingPagesProxy.this.CLIENT_CALL("onAdUpdateQrUrlEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                      com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                    }
                    AppMethodBeat.o(95209);
                    return;
                  }
                  catch (Throwable paramAnonymousString)
                  {
                    Log.e("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd exp=" + paramAnonymousString.toString());
                    AppMethodBeat.o(95209);
                    return;
                  }
                  Object localObject2;
                  if (((paramAnonymousq instanceof com.tencent.mm.openim.b.b)) || ((paramAnonymousq instanceof p))) {
                    try
                    {
                      JSONObject localJSONObject;
                      if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
                      {
                        Log.d("AdLandingPagesProxy", "onSceneEnd, errType = " + paramAnonymousInt1 + ", errCode = " + paramAnonymousInt2 + "," + paramAnonymousString);
                        l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                        if ((paramAnonymousq.getType() != 30) && (paramAnonymousq.getType() != 667))
                        {
                          Log.w("AdLandingPagesProxy", "not expected scene,  type = " + paramAnonymousq.getType());
                          AppMethodBeat.o(95209);
                          return;
                        }
                        if (((paramAnonymousq instanceof p)) && (((p)paramAnonymousq).dKy != 1))
                        {
                          Log.e("AdLandingPagesProxy", "not opcode addcontact!");
                          AppMethodBeat.o(95209);
                          return;
                        }
                        localObject2 = "";
                        localJSONObject = new JSONObject();
                        localObject1 = localObject2;
                        if (paramAnonymousInt1 == 0)
                        {
                          localObject1 = localObject2;
                          if (paramAnonymousInt2 == 0)
                          {
                            if (paramAnonymousq.getType() != 30) {
                              break label1827;
                            }
                            localObject1 = ((p)paramAnonymousq).gmD();
                          }
                        }
                      }
                      for (;;)
                      {
                        localJSONObject.put("errMsg", paramAnonymousString);
                        localJSONObject.put("respUsername", localObject1);
                        AdLandingPagesProxy.this.CLIENT_CALL("onAddBrandSceneEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localJSONObject.toString() });
                        b.e(AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                        AppMethodBeat.o(95209);
                        return;
                        label1827:
                        localObject1 = localObject2;
                        if (paramAnonymousq.getType() == 667) {
                          localObject1 = ((com.tencent.mm.openim.b.b)paramAnonymousq).jGZ;
                        }
                      }
                      if (!(paramAnonymousq instanceof com.tencent.mm.plugin.messenger.a.f)) {}
                    }
                    catch (Throwable paramAnonymousString)
                    {
                      Log.e("AdLandingPagesProxy", "NetSceneAddOpenIMContact or NetSceneVerifyUser onSceneEnd exp=" + paramAnonymousString.toString());
                      AppMethodBeat.o(95209);
                      return;
                    }
                  }
                  for (;;)
                  {
                    try
                    {
                      if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
                      {
                        l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                        paramAnonymousString = (drt)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
                        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                          break label2429;
                        }
                        paramAnonymousString = paramAnonymousString.toByteArray();
                        AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                      }
                    }
                    catch (Throwable paramAnonymousString)
                    {
                      Log.e("AdLandingPagesProxy", "NetSceneSearchContact, onSceneEnd exp=" + paramAnonymousString.toString());
                      continue;
                    }
                    com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                    AppMethodBeat.o(95209);
                    return;
                    if ((paramAnonymousq instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a)) {}
                    for (;;)
                    {
                      try
                      {
                        if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
                        {
                          l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                          paramAnonymousString = (bq)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
                          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                            break label2424;
                          }
                          paramAnonymousString = paramAnonymousString.toByteArray();
                          AdLandingPagesProxy.this.CLIENT_CALL("onAdNativeAntiAbuse", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                        }
                      }
                      catch (Throwable paramAnonymousString)
                      {
                        Log.e("AdLandingPagesProxy", "NetSceneAdAntiAbuse, onSceneEnd exp = " + paramAnonymousString.toString());
                        continue;
                      }
                      com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                      AppMethodBeat.o(95209);
                      return;
                      if (paramAnonymousq != null) {}
                      try
                      {
                        if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousq))
                        {
                          l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousq)).longValue();
                          localObject2 = ((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
                          localObject1 = null;
                          paramAnonymousString = (String)localObject1;
                          if (paramAnonymousInt1 == 0)
                          {
                            paramAnonymousString = (String)localObject1;
                            if (paramAnonymousInt2 == 0)
                            {
                              paramAnonymousString = (String)localObject1;
                              if (localObject2 != null) {
                                paramAnonymousString = ((com.tencent.mm.bw.a)localObject2).toByteArray();
                              }
                            }
                          }
                          AdLandingPagesProxy.this.CLIENT_CALL("onRspCallbackCommon", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                        }
                      }
                      catch (Throwable paramAnonymousString)
                      {
                        for (;;)
                        {
                          Log.e("AdLandingPagesProxy", "default, onSceneEnd exp=" + paramAnonymousString.toString());
                        }
                      }
                      com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                      label2389:
                      AppMethodBeat.o(95209);
                      return;
                      label2424:
                      paramAnonymousString = null;
                    }
                    label2429:
                    paramAnonymousString = null;
                  }
                  label2434:
                  paramAnonymousString = null;
                }
                label2439:
                i = -1;
              }
              label2445:
              paramAnonymousString = "";
            }
            label2451:
            paramAnonymousString = null;
          }
          label2456:
          paramAnonymousString = null;
        }
      }
    };
    this.DGo = new ConcurrentHashMap();
    this.DGp = new a.b()
    {
      public final void failed(long paramAnonymousLong)
      {
        AppMethodBeat.i(202669);
        AdLandingPagesProxy.this.CLIENT_CALL("failed", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(202669);
      }
      
      public final void paused(long paramAnonymousLong)
      {
        AppMethodBeat.i(202666);
        AdLandingPagesProxy.this.CLIENT_CALL("paused", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(202666);
      }
      
      public final void progress(long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(202665);
        Log.v("AdLandingPagesProxy", "progress %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AdLandingPagesProxy.this.CLIENT_CALL("progress", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(202665);
      }
      
      public final void resumed(long paramAnonymousLong)
      {
        AppMethodBeat.i(202670);
        AdLandingPagesProxy.this.CLIENT_CALL("resumed", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(202670);
      }
      
      public final void stopped(long paramAnonymousLong)
      {
        AppMethodBeat.i(202667);
        AdLandingPagesProxy.this.CLIENT_CALL("stopped", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(202667);
      }
      
      public final void succeed(long paramAnonymousLong)
      {
        AppMethodBeat.i(202668);
        AdLandingPagesProxy.this.CLIENT_CALL("succeed", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(202668);
      }
    };
    this.DGq = new HashMap();
    this.DGr = new HashMap();
    this.Dxo = paramd;
    AppMethodBeat.o(95227);
  }
  
  private static SharedPreferences akz()
  {
    AppMethodBeat.i(95329);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0);
    AppMethodBeat.o(95329);
    return localSharedPreferences;
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    AppMethodBeat.i(95228);
    if (DGl == null) {
      DGl = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
    }
    AdLandingPagesProxy localAdLandingPagesProxy = DGl;
    AppMethodBeat.o(95228);
    return localAdLandingPagesProxy;
  }
  
  @com.tencent.mm.remoteservice.e
  public void addCanvasCache(long paramLong, String paramString)
  {
    AppMethodBeat.i(95330);
    REMOTE_CALL("addCanvasCacheMM", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(95330);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addCanvasCacheMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95331);
    m.feB().J(paramLong, paramString);
    AppMethodBeat.o(95331);
  }
  
  public void addReportInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(176249);
    REMOTE_CALL("addReportInfoMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(176249);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addReportInfoMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(176248);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(176248);
      return;
    }
    paramString2 = new a.d(paramString2, paramString3, paramString4);
    locala.DXl.put(paramString1, paramString2);
    AppMethodBeat.o(176248);
  }
  
  @com.tencent.mm.remoteservice.e
  public void asyncCacheXml(String paramString)
  {
    AppMethodBeat.i(95332);
    REMOTE_CALL("asyncCacheXmlMM", new Object[] { paramString });
    AppMethodBeat.o(95332);
  }
  
  @com.tencent.mm.remoteservice.f
  public void asyncCacheXmlMM(final String paramString)
  {
    AppMethodBeat.i(95333);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95218);
        if (!com.tencent.mm.kernel.g.aAf().azp())
        {
          AppMethodBeat.o(95218);
          return;
        }
        Object localObject = aj.faO().aQl(paramString);
        if (localObject != null)
        {
          localObject = ((SnsInfo)localObject).getAdXml();
          if (localObject != null)
          {
            AdLandingPagesProxy.aOI(((ADXml)localObject).getLeftCanvasInfo());
            AdLandingPagesProxy.aOI(((ADXml)localObject).getRightCanvasInfo());
          }
        }
        AppMethodBeat.o(95218);
      }
    }, 5000L);
    AppMethodBeat.o(95333);
  }
  
  @com.tencent.mm.remoteservice.e
  public void clearCallback()
  {
    AppMethodBeat.i(95350);
    REMOTE_CALL("clearCallbackMM", new Object[0]);
    this.DGq.clear();
    this.callbacks.clear();
    this.DGo.clear();
    AppMethodBeat.o(95350);
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearCallbackMM()
  {
    AppMethodBeat.i(95349);
    this.DGm.clear();
    this.DGp = null;
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1337, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1210, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(2874, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(2721, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1802, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(2605, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(2883, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(4353, this.gNh);
    AppMethodBeat.o(95349);
  }
  
  public void confirmDialPhoneNum(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(95242);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(95242);
      return;
    }
    Intent localIntent = new Intent(MMApplicationContext.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("phoneNum", paramString);
    localIntent.putExtra("op", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.axQ(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(95242);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(95226);
    this.Dxo.connect(paramRunnable);
    AppMethodBeat.o(95226);
  }
  
  public int contactGetTypeTextFromUserName(String paramString)
  {
    AppMethodBeat.i(95232);
    paramString = REMOTE_CALL("contactGetTypeTextFromUserNameMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95232);
      return 0;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(95232);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int contactGetTypeTextFromUserNameMM(String paramString)
  {
    AppMethodBeat.i(95233);
    int i = ab.JG(paramString);
    AppMethodBeat.o(95233);
    return i;
  }
  
  public void deleteDeferredDeepLink(String paramString)
  {
    AppMethodBeat.i(95327);
    REMOTE_CALL("deleteDeferredDeepLinkMM", new Object[] { paramString });
    AppMethodBeat.o(95327);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteDeferredDeepLinkMM(String paramString)
  {
    AppMethodBeat.i(95328);
    akz().edit().remove(paramString).commit();
    AppMethodBeat.o(95328);
  }
  
  public void doAdChannelScene(String paramString1, String paramString2, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(95274);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdChannelSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(95274);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdChannelSceneMM(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(95275);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(paramString1, paramString2, paramBoolean);
    this.DGm.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1210, this.gNh);
    AppMethodBeat.o(95275);
  }
  
  public void doAdNativeAntiAbuseScene(String paramString1, String paramString2, int paramInt, String paramString3, e parame)
  {
    AppMethodBeat.i(202687);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdNativeAntiAbuseSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Integer.valueOf(paramInt), paramString3 });
    AppMethodBeat.o(202687);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdNativeAntiAbuseSceneMM(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(202688);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(paramString1, paramString2, paramInt, paramString3);
    this.DGm.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.azz().a(4679, this.gNh);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    AppMethodBeat.o(202688);
  }
  
  public void doAdUpdateQrUrlScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, e parame)
  {
    AppMethodBeat.i(202679);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdUpdateQrUrlSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
    AppMethodBeat.o(202679);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdUpdateQrUrlSceneMM(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(202680);
    paramString1 = new k(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    this.DGm.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.azz().a(1022, this.gNh);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    AppMethodBeat.o(202680);
  }
  
  public void doAddBrandScene(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(202698);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAddBrandSceneSceneMM", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(202698);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAddBrandSceneSceneMM(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(202699);
    paramString = b.a(paramString, this.gNh, paramInt);
    if ((paramString instanceof com.tencent.mm.openim.b.b))
    {
      paramString = (com.tencent.mm.openim.b.b)paramString;
      this.DGm.put(paramString, Long.valueOf(paramLong));
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
      AppMethodBeat.o(202699);
      return;
    }
    if ((paramString instanceof p))
    {
      paramString = (p)paramString;
      this.DGm.put(paramString, Long.valueOf(paramLong));
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
    }
    AppMethodBeat.o(202699);
  }
  
  public void doCgiReportCanvasBrowseInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(95345);
    REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(95345);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doCgiReportCanvasBrowseInfoMM(int paramInt, String paramString)
  {
    AppMethodBeat.i(95346);
    cfy localcfy = new cfy();
    localcfy.MlF = paramInt;
    localcfy.MlM = ((int)(System.currentTimeMillis() / 1000L));
    localcfy.oTz = 1;
    localcfy.MlG = new com.tencent.mm.bw.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localcfy);
    paramString = new com.tencent.mm.plugin.sns.ad.g.h(paramString);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1802, this.gNh);
    AppMethodBeat.o(95346);
  }
  
  public void doDynamicUpdateScene(String paramString1, String paramString2, String paramString3, e parame)
  {
    AppMethodBeat.i(95268);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95268);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doDynamicUpdateSceneMM(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95269);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j(paramString1, paramString2, paramString3);
    this.DGm.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1337, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2721, this.gNh);
    AppMethodBeat.o(95269);
  }
  
  public int doFav(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(95265);
    paramIntent = REMOTE_CALL("doFavMM", new Object[] { paramIntent, Integer.valueOf(paramInt) });
    if (paramIntent == null)
    {
      AppMethodBeat.o(95265);
      return 0;
    }
    paramInt = ((Integer)paramIntent).intValue();
    AppMethodBeat.o(95265);
    return paramInt;
  }
  
  public int doFavAdlanding(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8)
  {
    AppMethodBeat.i(95263);
    paramString1 = REMOTE_CALL("doFavAdlandingMM", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString4, paramString5, paramString6, Integer.valueOf(paramInt2), paramString7, paramString8 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(95263);
      return 0;
    }
    paramInt1 = ((Integer)paramString1).intValue();
    AppMethodBeat.o(95263);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavAdlandingMM(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8)
  {
    AppMethodBeat.i(95264);
    cz localcz = new cz();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      Util.isNullOrNil(paramString1);
    }
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ad.class)).a(localcz, paramString6.hashCode(), z.aTY(), paramString4, paramString5, paramString6, paramString7, paramString2);
    paramString1 = com.tencent.mm.model.ad.JX(paramString3);
    localcz.dFZ.sessionId = paramString1;
    localcz.dFZ.title = paramString4;
    localcz.dFZ.desc = paramString5;
    paramString1 = localcz.dFZ.dGb;
    if ((paramString1 != null) && (paramString1.ppH != null) && (paramString1.ppH.size() > 0) && (paramString1.ppH.get(0) != null))
    {
      ((aml)paramString1.ppH.get(0)).bgE(paramString6);
      ((aml)paramString1.ppH.get(0)).bgf(paramString4);
      ((aml)paramString1.ppH.get(0)).bgg(paramString5);
      ((aml)paramString1.ppH.get(0)).bgD(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.bhd(paramString4);
      paramString1.bhe(paramString5);
    }
    localcz.dFZ.dGf = paramInt2;
    EventCenter.instance.publish(localcz);
    paramInt1 = localcz.dFZ.dGe;
    AppMethodBeat.o(95264);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(95266);
    cz localcz = new cz();
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ad.class)).a(localcz, paramIntent);
    localcz.dFZ.dGf = paramInt;
    EventCenter.instance.publish(localcz);
    paramInt = localcz.dFZ.dGe;
    AppMethodBeat.o(95266);
    return paramInt;
  }
  
  public void doFavOfficialItemScene(String paramString, e parame)
  {
    AppMethodBeat.i(95340);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
      AppMethodBeat.o(95340);
      return;
    }
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doFavOfficialItemSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(95340);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doFavOfficialItemSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95341);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i(paramString);
    this.DGm.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2874, this.gNh);
    AppMethodBeat.o(95341);
  }
  
  public void doGetHbCoverState(String paramString, e parame)
  {
    AppMethodBeat.i(95282);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doGetHbCoverStateMM", new Object[] { Long.valueOf(l), paramString });
    Log.i("AdLandingPagesProxy", "doGetHbCoverState, hbCoverId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95282);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doGetHbCoverStateMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95283);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString);
    this.DGm.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2944, this.gNh);
    AppMethodBeat.o(95283);
  }
  
  public void doGetSmartPhoneScene(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, e parame)
  {
    AppMethodBeat.i(95276);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doGetSmartPhoneSceneMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95276);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doGetSmartPhoneSceneMM(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(95277);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e(paramLong2, paramInt1, paramString1, paramString2, paramInt2);
    this.DGm.put(paramString1, Long.valueOf(paramLong1));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2605, this.gNh);
    AppMethodBeat.o(95277);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchContactMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(202684);
    Log.i("AdLandingPagesProxy", "doSearchContactMM, userName=".concat(String.valueOf(paramString)));
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, 1);
    this.DGm.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.azz().a(106, this.gNh);
    com.tencent.mm.kernel.g.azz().a(paramString, 0);
    AppMethodBeat.o(202684);
  }
  
  public void doSearchDynamicUpdateScene(String paramString, e parame)
  {
    AppMethodBeat.i(95271);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doSearchDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(95271);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchDynamicUpdateSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95272);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j(paramString);
    this.DGm.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1337, this.gNh);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2721, this.gNh);
    AppMethodBeat.o(95272);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(202678);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("adlandingXml", paramString1);
    localIntent.putExtra("shareTitle", paramString2);
    localIntent.putExtra("shareThumbUrl", paramString3);
    localIntent.putExtra("shareDesc", paramString4);
    localIntent.putExtra("shareUrl", paramString5);
    localIntent.putExtra("statExtStr", paramString6);
    localIntent.putExtra("uxInfo", paramString7);
    localIntent.putExtra("canvasId", paramString8);
    localIntent.putExtra("op", 2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString1.axQ(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(202678);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doTransimtMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void doUpdateUxInfoScene(String paramString, e parame)
  {
    AppMethodBeat.i(95279);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doUpdateUxInfoSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(95279);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doUpdateUxInfoSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95280);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.l(paramString);
    this.DGm.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2883, this.gNh);
    AppMethodBeat.o(95280);
  }
  
  public void downloadLandingPageVideo(String paramString1, String paramString2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95355);
    if (Util.isNullOrNil(new String[] { paramString1, paramString2, paramString3 }))
    {
      if (parama != null) {
        parama.a(paramString1, -1, null);
      }
      AppMethodBeat.o(95355);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(955, 20);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (s.YS(paramString3))
    {
      Log.i("AdLandingPagesProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 21);
        parama.a(paramString1, 0, null);
        AppMethodBeat.o(95355);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.dN(955, 22);
    }
    while (this.DGr.containsKey(paramString1))
    {
      Log.i("%s is already in downloading", paramString2);
      AppMethodBeat.o(95355);
      return;
      if (bool)
      {
        Log.i("AdLandingPagesProxy", "last download file was deleted");
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 23);
        localSharedPreferences.edit().putBoolean(paramString1, false).commit();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 24);
      }
    }
    if (parama != null) {
      this.DGr.put(paramString1, parama);
    }
    REMOTE_CALL("downloadLandingPageVideoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95355);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPageVideoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95360);
    Log.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.h.CyF.dN(955, 25);
    aj.faJ().a(paramString1, paramString2, paramString3, new d(paramString1));
    AppMethodBeat.o(95360);
  }
  
  public void downloadLandingPagesCDNFile(String paramString1, String paramString2, String paramString3, int paramInt, g paramg)
  {
    AppMethodBeat.i(202690);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      if (paramg != null) {
        paramg.eWO();
      }
      AppMethodBeat.o(202690);
      return;
    }
    if (paramg != null) {
      this.DGq.put(paramString2, paramg);
    }
    REMOTE_CALL("downloadLandingPagesCDNFileMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(202690);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesCDNFileMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(202691);
    if (paramInt == 0)
    {
      downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
      AppMethodBeat.o(202691);
      return;
    }
    if (paramInt == 1) {
      downloadLandingPagesSightMMImpl(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(202691);
  }
  
  public void downloadLandingPagesImageMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(95353);
    Log.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.n.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    final com.tencent.mm.plugin.sns.data.n localn = new com.tencent.mm.plugin.sns.data.n(paramString3);
    localn.DEs = 3;
    localn.dPI = paramString3.Id;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202671);
        aj.faJ().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        c localc = aj.faJ();
        cnb localcnb = paramString3;
        com.tencent.mm.plugin.sns.data.n localn = localn;
        bp localbp = bp.gCU();
        localbp.hXs = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localcnb, 8, localn, localbp, paramString1, paramString2);
        AppMethodBeat.o(202671);
      }
    });
    AppMethodBeat.o(95353);
  }
  
  public void downloadLandingPagesSightMMImpl(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(202692);
    Log.i("AdLandingPagesProxy", "downloadLandingPagesSightMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202672);
        aj.faJ().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, this.DyS.Id));
        c localc = aj.faJ();
        cnb localcnb = this.DyS;
        bp localbp = bp.gCU();
        localbp.hXs = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localcnb, 4, null, localbp, paramString1, paramString2);
        AppMethodBeat.o(202672);
      }
    });
    AppMethodBeat.o(202692);
  }
  
  @com.tencent.mm.remoteservice.e
  public void failed(long paramLong)
  {
    AppMethodBeat.i(95305);
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.eZS();
      }
    }
    this.DGo.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95305);
  }
  
  public void favEditTag()
  {
    AppMethodBeat.i(95260);
    REMOTE_CALL("favEditTagMM", new Object[0]);
    AppMethodBeat.o(95260);
  }
  
  @com.tencent.mm.remoteservice.f
  public void favEditTagMM()
  {
    AppMethodBeat.i(95261);
    hb localhb = new hb();
    localhb.dLm.type = 35;
    EventCenter.instance.publish(localhb);
    AppMethodBeat.o(95261);
  }
  
  public void fetchQRCodeInfo(int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(95371);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("fetchQRCodeInfoMM", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(95371);
  }
  
  @com.tencent.mm.remoteservice.f
  public void fetchQRCodeInfoMM(final long paramLong, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(95372);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202674);
        new com.tencent.mm.plugin.scanner.d().bZ(paramInt, paramString).a(new d.b() {});
        AppMethodBeat.o(202674);
      }
    });
    AppMethodBeat.o(95372);
  }
  
  public void geoLocation(String paramString, e parame)
  {
    AppMethodBeat.i(202695);
    try
    {
      Log.d("AdLandingPagesProxy", "geoLocation is called!!");
      long l = System.currentTimeMillis();
      this.callbacks.put(Long.valueOf(l), parame);
      REMOTE_CALL("geoLocationMM", new Object[] { Long.valueOf(l), paramString });
      AppMethodBeat.o(202695);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("AdLandingPagesProxy", "geoLocation catch one exception");
      AppMethodBeat.o(202695);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void geoLocationMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(202696);
    try
    {
      Log.d("AdLandingPagesProxy", "geoLocationMM is called!!");
      com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b localb = com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c.a(this, "onGeoLocation", paramLong);
      if (localb != null) {
        localb.request(paramString);
      }
      AppMethodBeat.o(202696);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("AdLandingPagesProxy", "geoLocationMM catch one exception");
      AppMethodBeat.o(202696);
    }
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(95236);
    String str = (String)REMOTE_CALL("getAccSnsPathMM", new Object[0]);
    AppMethodBeat.o(95236);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAccSnsPathMM()
  {
    AppMethodBeat.i(95237);
    String str = aj.getAccSnsPath();
    AppMethodBeat.o(95237);
    return str;
  }
  
  public int getAdVoteIndex(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95334);
    int i = ((Integer)REMOTE_CALL("getAdVoteIndexMM", new Object[] { paramString1, paramString2, paramString3 })).intValue();
    AppMethodBeat.o(95334);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getAdVoteIndexMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95335);
    int i = y.aS(paramString1, paramString2, paramString3);
    AppMethodBeat.o(95335);
    return i;
  }
  
  public String getAdVoteInfo(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95336);
    paramString1 = (String)REMOTE_CALL("getAdVoteInfoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95336);
    return paramString1;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAdVoteInfoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95337);
    paramString1 = y.aT(paramString1, paramString2, paramString3);
    AppMethodBeat.o(95337);
    return paramString1;
  }
  
  public void getBtnPersonalWxUserName(String paramString1, String paramString2, e parame)
  {
    AppMethodBeat.i(202682);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("getBtnPersonalWxUserNameMM", new Object[] { Long.valueOf(l), paramString1, paramString2 });
    AppMethodBeat.o(202682);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getBtnPersonalWxUserNameMM(final long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202683);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramString1, paramString2);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(4353, new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(202664);
        Log.i("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2 + ", errMsg=" + paramAnonymousString);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (byb)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR;
          if ((paramAnonymousString != null) && (!TextUtils.isEmpty(paramAnonymousString.MdC)))
          {
            AdLandingPagesProxy.this.CLIENT_CALL("onGetBtnPersonalWxUserName", new Object[] { Long.valueOf(paramLong), paramAnonymousString.username, paramAnonymousString.MdC });
            AdLandingPagesProxy.this.doSearchContactMM(paramLong, paramAnonymousString.MdC);
          }
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.azz().b(paramAnonymousq.getType(), this);
          AppMethodBeat.o(202664);
          return;
          Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, rsp==null");
          AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), null });
          continue;
          Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, failed");
          AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), null });
        }
      }
    });
    AppMethodBeat.o(202683);
  }
  
  public Object getCfg(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(95230);
    Object localObject = REMOTE_CALL("getCfgMM", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (localObject == null)
    {
      AppMethodBeat.o(95230);
      return paramObject;
    }
    AppMethodBeat.o(95230);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getCfgMM(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(95231);
    com.tencent.mm.kernel.g.aAi();
    paramObject = com.tencent.mm.kernel.g.aAh().azQ().get(paramInt, paramObject);
    AppMethodBeat.o(95231);
    return paramObject;
  }
  
  public String getExpIdByKey(String paramString)
  {
    AppMethodBeat.i(95258);
    paramString = (String)REMOTE_CALL("getExpIdByKeyMM", new Object[] { paramString });
    AppMethodBeat.o(95258);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getExpIdByKeyMM(String paramString)
  {
    AppMethodBeat.i(95257);
    paramString = com.tencent.mm.model.c.d.aXv().getExpIdByKey(paramString);
    AppMethodBeat.o(95257);
    return paramString;
  }
  
  public int getExpValueByKey(String paramString, int paramInt)
  {
    AppMethodBeat.i(95256);
    paramString = REMOTE_CALL("getExpValueByKeyMM", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString == null)
    {
      AppMethodBeat.o(95256);
      return -1;
    }
    paramInt = ((Integer)paramString).intValue();
    AppMethodBeat.o(95256);
    return paramInt;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getExpValueByKeyMM(String paramString, int paramInt)
  {
    AppMethodBeat.i(95255);
    paramInt = com.tencent.mm.model.c.d.aXv().gO(paramString, paramInt);
    AppMethodBeat.o(95255);
    return paramInt;
  }
  
  public com.tencent.mm.remoteservice.d getRemoteServiceProxy()
  {
    return this.Dxo;
  }
  
  public String getSnsAdCanvasExtXml(String paramString)
  {
    AppMethodBeat.i(95343);
    paramString = (String)REMOTE_CALL("getSnsAdCanvasExtXmlMM", new Object[] { paramString });
    AppMethodBeat.o(95343);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsAdCanvasExtXmlMM(String paramString)
  {
    AppMethodBeat.i(95344);
    paramString = aj.faO().aQl(paramString);
    if (paramString != null)
    {
      paramString = paramString.getAdInfo().adCanvasExtXml;
      AppMethodBeat.o(95344);
      return paramString;
    }
    AppMethodBeat.o(95344);
    return "";
  }
  
  public int getSnsAdType(String paramString)
  {
    AppMethodBeat.i(95240);
    paramString = REMOTE_CALL("getSnsAdTypeMM", new Object[] { paramString });
    if ((paramString instanceof Number))
    {
      int i = ((Number)paramString).intValue();
      AppMethodBeat.o(95240);
      return i;
    }
    AppMethodBeat.o(95240);
    return 0;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getSnsAdTypeMM(String paramString)
  {
    AppMethodBeat.i(95241);
    paramString = aj.faO().aQl(paramString);
    if (paramString != null)
    {
      int i = paramString.getAdType();
      AppMethodBeat.o(95241);
      return i;
    }
    AppMethodBeat.o(95241);
    return 0;
  }
  
  public String getSnsAid(String paramString)
  {
    AppMethodBeat.i(95238);
    paramString = (String)REMOTE_CALL("getSnsAidMM", new Object[] { paramString });
    AppMethodBeat.o(95238);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsAidMM(String paramString)
  {
    AppMethodBeat.i(95239);
    paramString = aj.faO().aQl(paramString);
    if (paramString != null)
    {
      paramString = paramString.getAid();
      AppMethodBeat.o(95239);
      return paramString;
    }
    AppMethodBeat.o(95239);
    return "";
  }
  
  public SnsInfo getSnsInfo(String paramString)
  {
    AppMethodBeat.i(95249);
    Object localObject;
    try
    {
      localObject = (Bundle)REMOTE_CALL("getSnsInfoMM", new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null)
      {
        AppMethodBeat.o(95249);
        return null;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("AdLandingPagesProxy", paramString, "", new Object[0]);
      paramString = null;
      localObject = new SnsInfo();
      ((SnsInfo)localObject).readFromBundle(paramString);
      AppMethodBeat.o(95249);
    }
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bundle getSnsInfoMM(String paramString)
  {
    AppMethodBeat.i(95250);
    paramString = aj.faO().aQl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95250);
      return null;
    }
    paramString = paramString.writeToBundle();
    AppMethodBeat.o(95250);
    return paramString;
  }
  
  public String getSnsStatExtBySnsId(long paramLong)
  {
    AppMethodBeat.i(95234);
    String str = (String)REMOTE_CALL("getSnsStatExtBySnsIdMM", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95234);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsStatExtBySnsIdMM(long paramLong)
  {
    AppMethodBeat.i(95235);
    Object localObject = aj.faR().JE(paramLong);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.sns.ad.g.j.b(((AdSnsInfo)localObject).getTimeLine());
      AppMethodBeat.o(95235);
      return localObject;
    }
    Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95235);
    return "";
  }
  
  public String getSnsTraceid(String paramString)
  {
    AppMethodBeat.i(95243);
    paramString = (String)REMOTE_CALL("getSnsTraceidMM", new Object[] { paramString });
    AppMethodBeat.o(95243);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsTraceidMM(String paramString)
  {
    AppMethodBeat.i(95244);
    paramString = aj.faO().aQl(paramString);
    if (paramString != null)
    {
      paramString = paramString.getTraceid();
      AppMethodBeat.o(95244);
      return paramString;
    }
    AppMethodBeat.o(95244);
    return "";
  }
  
  public String getSnsUxInfo(String paramString)
  {
    AppMethodBeat.i(95245);
    paramString = (String)REMOTE_CALL("getSnsUxInfoMM", new Object[] { paramString });
    AppMethodBeat.o(95245);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsUxInfoMM(String paramString)
  {
    AppMethodBeat.i(95246);
    paramString = aj.faO().aQl(paramString);
    if (paramString != null)
    {
      paramString = paramString.getUxinfo();
      AppMethodBeat.o(95246);
      return paramString;
    }
    AppMethodBeat.o(95246);
    return "";
  }
  
  public int getStreamVideoPlayerConfig()
  {
    AppMethodBeat.i(95347);
    try
    {
      int i = ((Integer)REMOTE_CALL("getStreamVideoPlayerConfigMM", new Object[0])).intValue();
      AppMethodBeat.o(95347);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("AdLandingPagesProxy", "getStreamVideoPlayerConfig, exp=" + localException.toString());
      AppMethodBeat.o(95347);
    }
    return 1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getStreamVideoPlayerConfigMM()
  {
    AppMethodBeat.i(95348);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOS, 0);
    AppMethodBeat.o(95348);
    return i;
  }
  
  public int getTaskProgress(String paramString)
  {
    AppMethodBeat.i(95316);
    paramString = REMOTE_CALL("getTaskProgressMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95316);
      return -1;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(95316);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getTaskProgressMM(String paramString)
  {
    AppMethodBeat.i(95315);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    paramString = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString);
    if (paramString.oJj != 0L)
    {
      int i = (int)(paramString.qJe * 100L / paramString.oJj);
      AppMethodBeat.o(95315);
      return i;
    }
    AppMethodBeat.o(95315);
    return 0;
  }
  
  public void getTwistAdCard(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, e parame)
  {
    AppMethodBeat.i(202707);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("getTwistAdCardMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    AppMethodBeat.o(202707);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getTwistAdCardMM(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202708);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f(paramString1, paramString2, paramInt, paramString3, paramString4);
    this.DGm.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(4729, this.gNh);
    AppMethodBeat.o(202708);
  }
  
  public String getUin()
  {
    AppMethodBeat.i(95251);
    Object localObject = REMOTE_CALL("getUinMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(95251);
      return "";
    }
    localObject = (String)localObject;
    AppMethodBeat.o(95251);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getUinMM()
  {
    AppMethodBeat.i(95252);
    com.tencent.mm.kernel.g.aAf();
    String str = com.tencent.mm.kernel.a.ayV();
    AppMethodBeat.o(95252);
    return str;
  }
  
  public boolean installApp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(95320);
    paramContext = REMOTE_CALL("installAppMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (paramContext == null)
    {
      AppMethodBeat.o(95320);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(95320);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean installAppMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(95319);
    paramString3 = a.e.DXp;
    paramString4 = MMApplicationContext.getContext();
    b localb = new b(paramString1, paramString2, false);
    if ((paramString4 == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(95319);
      return false;
    }
    paramString1 = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString1);
    if ((paramString1 != null) && (paramString1.status == 3) && (!TextUtils.isEmpty(paramString1.path)))
    {
      paramString3.aH(4, paramString1.id);
      r.b(paramString4, paramString1.path, null, false);
      paramString3.a(paramString2, localb);
      AppMethodBeat.o(95319);
      return true;
    }
    AppMethodBeat.o(95319);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(95292);
    paramString = REMOTE_CALL("isApkExistMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95292);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95292);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isApkExistMM(String paramString)
  {
    AppMethodBeat.i(95293);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString);
    AppMethodBeat.o(95293);
    return bool;
  }
  
  public int isAutoAdDownload()
  {
    AppMethodBeat.i(95259);
    Object localObject = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(95259);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(95259);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int isAutoAdDownloadMM()
  {
    AppMethodBeat.i(95262);
    int i = aj.faL().b(null, null);
    AppMethodBeat.o(95262);
    return i;
  }
  
  public boolean isBrandAdded(String paramString)
  {
    AppMethodBeat.i(202701);
    paramString = REMOTE_CALL("selectBrandAdd", new Object[] { paramString });
    if ((paramString instanceof Boolean))
    {
      boolean bool = ((Boolean)paramString).booleanValue();
      AppMethodBeat.o(202701);
      return bool;
    }
    AppMethodBeat.o(202701);
    return false;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(95229);
    if (this.Dxo == null)
    {
      AppMethodBeat.o(95229);
      return false;
    }
    boolean bool = this.Dxo.isConnected();
    AppMethodBeat.o(95229);
    return bool;
  }
  
  public boolean isDownloading(String paramString)
  {
    AppMethodBeat.i(95295);
    paramString = REMOTE_CALL("isDownloadingMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95295);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95295);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isDownloadingMM(String paramString)
  {
    AppMethodBeat.i(95294);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    paramString = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString);
    if ((paramString != null) && (paramString.status == 1))
    {
      AppMethodBeat.o(95294);
      return true;
    }
    AppMethodBeat.o(95294);
    return false;
  }
  
  public boolean isFreeSimCard()
  {
    AppMethodBeat.i(202710);
    Object localObject = REMOTE_CALL("isFreeSimCardMM", new Object[0]);
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(202710);
      return bool;
    }
    AppMethodBeat.o(202710);
    return false;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isFreeSimCardMM()
  {
    AppMethodBeat.i(202711);
    int i = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class)).eiV();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("AdLandingPagesProxy", "isFreeSimCard, simType=" + i + ", isFree=" + bool);
      AppMethodBeat.o(202711);
      return bool;
    }
  }
  
  public boolean isPaused(String paramString)
  {
    AppMethodBeat.i(95299);
    paramString = REMOTE_CALL("isPausedMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95299);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95299);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isPausedMM(String paramString)
  {
    AppMethodBeat.i(95298);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    paramString = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString);
    if ((paramString != null) && (paramString.status == 2))
    {
      AppMethodBeat.o(95298);
      return true;
    }
    AppMethodBeat.o(95298);
    return false;
  }
  
  public boolean isPkgInstalled(String paramString)
  {
    AppMethodBeat.i(95297);
    paramString = REMOTE_CALL("isPkgInstalledMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95297);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95297);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isPkgInstalledMM(String paramString)
  {
    AppMethodBeat.i(95296);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bz(MMApplicationContext.getContext(), paramString);
    AppMethodBeat.o(95296);
    return bool;
  }
  
  public boolean isRecExpAd(String paramString)
  {
    AppMethodBeat.i(95247);
    paramString = REMOTE_CALL("isRecExpAdMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95247);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95247);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isRecExpAdMM(String paramString)
  {
    AppMethodBeat.i(95248);
    paramString = aj.faO().aQl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95248);
      return false;
    }
    boolean bool = paramString.isRecExpAd();
    AppMethodBeat.o(95248);
    return bool;
  }
  
  public boolean isUseSnsDownloadImage()
  {
    AppMethodBeat.i(95369);
    Object localObject = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(95369);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(95369);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isUseSnsDownloadImageMM()
  {
    AppMethodBeat.i(95370);
    f localf = DGn;
    int i;
    if (Util.currentTicks() - localf.lastUpdateTime > 3600L)
    {
      i = 1;
      if (i != 0) {
        localf.DGx = false;
      }
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.kernel.g.aAc())
        {
          com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100348");
          if (localc.isValid())
          {
            if (Util.getInt((String)localc.gzz().get("downloadMode"), 0) != 1) {
              continue;
            }
            bool = true;
            localf.DGx = bool;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        Log.printErrStackTrace("AdLandingPagesProxy", localException, "get abtest failed!", new Object[0]);
        continue;
      }
      localf.lastUpdateTime = Util.currentTicks();
      bool = DGn.DGx;
      AppMethodBeat.o(95370);
      return bool;
      i = 0;
      break;
      bool = false;
    }
  }
  
  public boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95363);
    paramString = REMOTE_CALL("isVideoDataAvailableMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramString == null)
    {
      AppMethodBeat.o(95363);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95363);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isVideoDataAvailableMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95364);
    boolean bool = o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    Log.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(95364);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdChannelEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95273);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95273);
  }
  
  public void onAdLandingPageClick(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95285);
    System.currentTimeMillis();
    REMOTE_CALL("onAdLandingPageClickMM", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(95285);
  }
  
  @com.tencent.mm.remoteservice.f
  public void onAdLandingPageClickMM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95286);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g(paramString1, paramString2);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(2538, this.gNh);
    AppMethodBeat.o(95286);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdNativeAntiAbuse(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(202689);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(202689);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdUpdateQrUrlEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(202681);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(202681);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAddBrandSceneEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(202700);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(202700);
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(95291);
    Log.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label194;
        }
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equalsIgnoreCase(paramString)) {
          break label210;
        }
      }
      catch (Exception paramString)
      {
        Log.e("AdLandingPagesProxy", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(95291);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramString = ((Method)localObject1).invoke(this, getArgs(paramBundle));
        if (((Method)localObject1).getReturnType() != Void.TYPE)
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable("result_key", (Parcelable)paramString);
            AppMethodBeat.o(95291);
            return;
          }
          paramBundle.putSerializable("result_key", (Serializable)paramString);
        }
      }
      AppMethodBeat.o(95291);
      return;
      label194:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          paramString = com.tencent.mm.remoteservice.e.class;
          continue;
          label210:
          i += 1;
        }
        else
        {
          paramString = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95366);
    Log.i("AdLandingPagesProxy", "cdn video data available %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.DGr.containsKey(paramString)) {
      ((h.a)this.DGr.get(paramString)).onDataAvailable(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95366);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoFinish(String paramString, int paramInt)
  {
    AppMethodBeat.i(95368);
    Log.i("AdLandingPagesProxy", "cdn video finish %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, true).commit();
    }
    if (this.DGr.containsKey(paramString)) {
      ((h.a)this.DGr.remove(paramString)).a(paramString, paramInt, null);
    }
    AppMethodBeat.o(95368);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(202694);
    Log.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.DGr.containsKey(paramString1)) {
      ((h.a)this.DGr.get(paramString1)).a(paramString1, paramLong1, paramLong2, paramString2);
    }
    AppMethodBeat.o(202694);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoProgress(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95367);
    Log.i("AdLandingPagesProxy", "cdn video progress %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.DGr.containsKey(paramString)) {
      ((h.a)this.DGr.get(paramString)).i(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95367);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AppMethodBeat.i(95270);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((locale != null) && (!Util.isNullOrNil(paramString))) {
      locale.bn(paramString);
    }
    AppMethodBeat.o(95270);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFavOfficialItemEnd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95342);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Log.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      if (locale != null) {
        locale.h(paramInt1, paramInt2, null);
      }
      AppMethodBeat.o(95342);
      return;
      Log.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[] { paramString });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFetchQRCodeInfo(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95373);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95373);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGeoLocation(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(202697);
    try
    {
      Log.d("AdLandingPagesProxy", "onGeoLocation is called!!");
      e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
      if (locale != null) {
        locale.bn(paramObject);
      }
      AppMethodBeat.o(202697);
      return;
    }
    catch (Throwable paramObject)
    {
      Log.e("AdLandingPagesProxy", "onGeoLocation catch one exception");
      AppMethodBeat.o(202697);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetBtnPersonalWxUserName(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202685);
    e locale = (e)this.callbacks.get(Long.valueOf(paramLong));
    if (locale != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("username", paramString1);
        localJSONObject.put("aliasname", paramString2);
        locale.bn(localJSONObject.toString());
        AppMethodBeat.o(202685);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("AdLandingPagesProxy", "onGetBtnPersonalWxUserName, exp=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(202685);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetHbCoverStateScene(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95284);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95284);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetSmartPhoneScene(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95278);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95278);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onImgDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(95354);
    Log.i("AdLandingPagesProxy", "onImgDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95354);
      return;
    }
    paramString = (g)this.DGq.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.eZU();
        AppMethodBeat.o(95354);
        return;
      }
      paramString.eWO();
    }
    AppMethodBeat.o(95354);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onRspCallbackCommon(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(202709);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(202709);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSearchContact(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(202686);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(202686);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSightDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202693);
    Log.i("AdLandingPagesProxy", "onSightDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(202693);
      return;
    }
    paramString = (g)this.DGq.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.eZU();
        AppMethodBeat.o(202693);
        return;
      }
      paramString.eWO();
    }
    AppMethodBeat.o(202693);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onUpdateUxInfo(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95281);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95281);
  }
  
  public boolean pauseTask(String paramString)
  {
    AppMethodBeat.i(95314);
    paramString = REMOTE_CALL("pauseTaskMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95314);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(95314);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean pauseTaskMM(String paramString)
  {
    AppMethodBeat.i(95313);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    boolean bool = com.tencent.mm.plugin.downloader.model.f.cBv().Cp(l);
    AppMethodBeat.o(95313);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    AppMethodBeat.i(95302);
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.eZP();
      }
    }
    AppMethodBeat.o(95302);
  }
  
  public void playTimelineBackAnimation(long paramLong)
  {
    AppMethodBeat.i(95289);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineBackAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    AppMethodBeat.o(95289);
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineBackAnimationMM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95290);
    xv localxv = new xv();
    localxv.eeg.gY = paramLong2;
    EventCenter.instance.publish(localxv);
    AppMethodBeat.o(95290);
  }
  
  public void playTimelineClickAnimation(long paramLong)
  {
    AppMethodBeat.i(95287);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineClickAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    AppMethodBeat.o(95287);
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineClickAnimationMM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95288);
    xw localxw = new xw();
    localxw.eeh.gY = paramLong2;
    EventCenter.instance.publish(localxw);
    AppMethodBeat.o(95288);
  }
  
  public void prefetchH5Url(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(202705);
    try
    {
      REMOTE_CALL("prefetchH5UrlMM", new Object[] { paramString, paramArrayOfString });
      AppMethodBeat.o(202705);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("AdLandingPagesProxy", "prefetchH5Url remote call has an exception!");
      AppMethodBeat.o(202705);
    }
  }
  
  /* Error */
  @com.tencent.mm.remoteservice.f
  public void prefetchH5UrlMM(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc_w 1646
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +79 -> 89
    //   13: aload_2
    //   14: invokestatic 1652	com/tencent/mm/plugin/sns/ad/i/c:w	([Ljava/lang/Object;)Z
    //   17: ifne +72 -> 89
    //   20: invokestatic 1658	com/tencent/mm/plugin/sns/ad/d/a:eWI	()Lcom/tencent/mm/plugin/sns/ad/d/a;
    //   23: astore_3
    //   24: aload_3
    //   25: getfield 1662	com/tencent/mm/plugin/sns/ad/d/a:Dsw	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   28: astore_3
    //   29: aload_1
    //   30: ifnull +66 -> 96
    //   33: aload_2
    //   34: invokestatic 1652	com/tencent/mm/plugin/sns/ad/i/c:w	([Ljava/lang/Object;)Z
    //   37: ifeq +18 -> 55
    //   40: goto +56 -> 96
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual 1667	com/tencent/mm/plugin/sns/ad/d/a/c:c	(Lcom/tencent/mm/plugin/sns/ad/d/a/c$b;)V
    //   48: ldc_w 1646
    //   51: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: aload_3
    //   56: new 1669	com/tencent/mm/plugin/sns/ad/d/a/c$b
    //   59: dup
    //   60: aload_1
    //   61: aload_2
    //   62: invokespecial 1671	com/tencent/mm/plugin/sns/ad/d/a/c$b:<init>	(Ljava/lang/String;[Ljava/lang/String;)V
    //   65: invokevirtual 1674	com/tencent/mm/plugin/sns/ad/d/a/c:b	(Lcom/tencent/mm/plugin/sns/ad/d/a/c$b;)Lcom/tencent/mm/plugin/sns/ad/d/a/c$b;
    //   68: astore_1
    //   69: goto -26 -> 43
    //   72: astore_1
    //   73: ldc_w 1646
    //   76: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: astore_1
    //   81: ldc 138
    //   83: ldc_w 1676
    //   86: invokestatic 662	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc_w 1646
    //   92: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: aconst_null
    //   97: astore_1
    //   98: goto -55 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	AdLandingPagesProxy
    //   0	101	1	paramString	String
    //   0	101	2	paramArrayOfString	String[]
    //   23	33	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	29	72	java/lang/Throwable
    //   33	40	72	java/lang/Throwable
    //   43	48	72	java/lang/Throwable
    //   55	69	72	java/lang/Throwable
    //   20	24	80	java/lang/Throwable
    //   48	54	80	java/lang/Throwable
  }
  
  @com.tencent.mm.remoteservice.e
  public void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95301);
    Log.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.Yr(paramInt);
      }
    }
    AppMethodBeat.o(95301);
  }
  
  public long queryIdByAppid(String paramString)
  {
    AppMethodBeat.i(95312);
    paramString = REMOTE_CALL("queryIdByAppidMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(95312);
      return -1L;
    }
    long l = ((Long)paramString).longValue();
    AppMethodBeat.o(95312);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public long queryIdByAppidMM(String paramString)
  {
    AppMethodBeat.i(95311);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    AppMethodBeat.o(95311);
    return l;
  }
  
  public long[] queryVideoMoov(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95358);
    Log.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", new Object[] { paramString1, paramString2, paramString3 });
    if (Util.isNullOrNil(new String[] { paramString1, paramString2, paramString3 }))
    {
      AppMethodBeat.o(95358);
      return null;
    }
    paramString1 = (long[])REMOTE_CALL("queryVideoMoovMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95358);
    return paramString1;
  }
  
  @com.tencent.mm.remoteservice.f
  public long[] queryVideoMoovMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95359);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.fileType = 100;
    localC2CDownloadRequest.url = paramString3;
    localC2CDownloadRequest.setSavePath(paramString2);
    paramString1 = new long[2];
    if (CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, paramString1))
    {
      AppMethodBeat.o(95359);
      return paramString1;
    }
    AppMethodBeat.o(95359);
    return null;
  }
  
  public void reportDownloadInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(95322);
    REMOTE_CALL("reportDownloadInfoMM", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(95322);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportDownloadInfoMM(int paramInt, String paramString)
  {
    AppMethodBeat.i(95321);
    a.e.DXp.reportDownloadInfo(paramInt, paramString);
    AppMethodBeat.o(95321);
  }
  
  public void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95361);
    com.tencent.mm.plugin.report.service.h.CyF.dN(955, 32);
    REMOTE_CALL("requestVideoDataMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95361);
  }
  
  @com.tencent.mm.remoteservice.f
  public void requestVideoDataMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95362);
    com.tencent.mm.plugin.report.service.h.CyF.dN(955, 33);
    o.bhk();
    com.tencent.mm.an.e.r(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(95362);
  }
  
  public boolean resumeTask(String paramString1, a parama, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = false;
    AppMethodBeat.i(176247);
    paramString2 = REMOTE_CALL("resumeTaskMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    long l;
    if (paramString2 == null) {
      if (bool)
      {
        l = queryIdByAppid(paramString1);
        paramString2 = (ArrayList)this.DGo.get(Long.valueOf(l));
        if (paramString2 == null) {
          break label128;
        }
        paramString1 = paramString2;
        if (!paramString2.contains(parama))
        {
          paramString2.add(parama);
          paramString1 = paramString2;
        }
      }
    }
    for (;;)
    {
      this.DGo.put(Long.valueOf(l), paramString1);
      AppMethodBeat.o(176247);
      return bool;
      bool = ((Boolean)paramString2).booleanValue();
      break;
      label128:
      paramString1 = new ArrayList();
      paramString1.add(parama);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean resumeTaskMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(176246);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    a.b localb = this.DGp;
    com.tencent.mm.plugin.downloader.model.f.cBv();
    com.tencent.mm.plugin.downloader.model.c.a(locala.DXm);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      if (localb != null) {
        locala.DGp = localb;
      }
      locala.DXl.put(paramString1, new a.d(paramString2, paramString3, paramString4));
      boolean bool = com.tencent.mm.plugin.downloader.model.f.cBv().Cq(localFileDownloadTaskInfo.id);
      AppMethodBeat.o(176246);
      return bool;
    }
    AppMethodBeat.o(176246);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public void resumed(long paramLong)
  {
    AppMethodBeat.i(95306);
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.eZT();
      }
    }
    AppMethodBeat.o(95306);
  }
  
  public void saveAdVoteInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(95338);
    REMOTE_CALL("saveAdVoteInfoMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString4 });
    AppMethodBeat.o(95338);
  }
  
  @com.tencent.mm.remoteservice.f
  public void saveAdVoteInfoMM(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(95339);
    y.b(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4);
    AppMethodBeat.o(95339);
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean selectBrandAdd(String paramString)
  {
    AppMethodBeat.i(202702);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
    if ((localbv == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(202702);
      return false;
    }
    paramString = localbv.Kn(paramString);
    if ((paramString != null) && (com.tencent.mm.contact.c.oR(paramString.field_type)))
    {
      AppMethodBeat.o(202702);
      return true;
    }
    AppMethodBeat.o(202702);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    AppMethodBeat.i(95300);
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.start();
      }
    }
    AppMethodBeat.o(95300);
  }
  
  public long startDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, a parama, String paramString7, String paramString8, String paramString9, boolean paramBoolean2)
  {
    AppMethodBeat.i(176245);
    Log.i("AdLandingPagesProxy", "startDownload, appId=" + paramString1 + ", pkg=" + paramString3 + ", aid=" + paramString7 + ", fileName=" + paramString6 + ", isGameApp=" + paramBoolean2 + ", url=" + paramString5 + ", uxinfo=" + paramString9);
    paramString1 = REMOTE_CALL("startDownloadMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, Boolean.valueOf(paramBoolean1), paramString7, paramString8, paramString9, Boolean.valueOf(paramBoolean2) });
    long l;
    if (paramString1 == null)
    {
      l = -1L;
      paramString2 = (ArrayList)this.DGo.get(Long.valueOf(l));
      if (paramString2 == null) {
        break label253;
      }
      paramString1 = paramString2;
      if (!paramString2.contains(parama))
      {
        paramString2.add(parama);
        paramString1 = paramString2;
      }
    }
    for (;;)
    {
      this.DGo.put(Long.valueOf(l), paramString1);
      AppMethodBeat.o(176245);
      return l;
      l = ((Long)paramString1).longValue();
      break;
      label253:
      paramString1 = new ArrayList();
      paramString1.add(parama);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long startDownloadMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, String paramString8, String paramString9, boolean paramBoolean2)
  {
    AppMethodBeat.i(176244);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    b localb = new b(paramString1, paramString3, paramBoolean1);
    a.b localb1 = this.DGp;
    if (!paramBoolean2)
    {
      paramString2 = new g.a();
      paramString2.setAppId(paramString1);
      paramString2.alm(paramString1);
      paramString2.gm(paramString3);
      paramString2.setFileMD5(paramString4);
      paramString2.alj(paramString5);
      paramString2.all(paramString6);
      paramString2.kS(paramBoolean1);
      paramString2 = paramString2.qIY;
    }
    com.tencent.mm.plugin.downloader_app.a.a locala1;
    for (long l = com.tencent.mm.plugin.downloader.model.f.cBv().a(paramString2);; l = ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(locala1, new a.3(locala)))
    {
      if (localb1 != null) {
        locala.DGp = localb1;
      }
      if (paramBoolean1) {
        locala.a(paramString3, localb);
      }
      locala.DXl.put(paramString1, new a.d(paramString7, paramString8, paramString9));
      com.tencent.mm.plugin.downloader.model.f.cBv();
      com.tencent.mm.plugin.downloader.model.c.a(locala.DXm);
      Log.i("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(176244);
      return l;
      locala1 = new com.tencent.mm.plugin.downloader_app.a.a();
      locala1.downloadUrl = paramString5;
      locala1.appId = paramString2;
      locala1.qKu = paramString1;
      locala1.packageName = paramString3;
      locala1.mYc = paramString4;
      locala1.appName = paramString6;
      locala1.dNv = 1;
      locala1.qKw = paramBoolean1;
      locala1.scene = 5101;
    }
  }
  
  public void stopDownloadLandingPageVideo(String paramString)
  {
    AppMethodBeat.i(95356);
    if (this.DGr.containsKey(paramString))
    {
      this.DGr.remove(paramString);
      Log.i("AdLandingPagesProxy", "stop download video %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.CyF.dN(955, 34);
      MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, false).commit();
    }
    REMOTE_CALL("stopDownloadLandingPageVideoMM", new Object[] { paramString });
    AppMethodBeat.o(95356);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopDownloadLandingPageVideoMM(String paramString)
  {
    AppMethodBeat.i(95357);
    aj.faJ().aOM(paramString);
    AppMethodBeat.o(95357);
  }
  
  public void stopTask(String paramString)
  {
    AppMethodBeat.i(95310);
    REMOTE_CALL("stopTaskMM", new Object[] { paramString });
    AppMethodBeat.o(95310);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopTaskMM(String paramString)
  {
    AppMethodBeat.i(95309);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.DXp;
    paramString = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      com.tencent.mm.plugin.downloader.model.f.cBv().Cn(l);
    }
    AppMethodBeat.o(95309);
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    AppMethodBeat.i(95303);
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.eZQ();
      }
    }
    this.DGo.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95303);
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    AppMethodBeat.i(95304);
    Iterator localIterator = ((ArrayList)this.DGo.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.eZR();
      }
    }
    this.DGo.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95304);
  }
  
  public void updateContact(String paramString)
  {
    AppMethodBeat.i(202703);
    REMOTE_CALL("updateContactMM", new Object[] { paramString });
    AppMethodBeat.o(202703);
  }
  
  @com.tencent.mm.remoteservice.f
  public void updateContactMM(String paramString)
  {
    AppMethodBeat.i(202704);
    final bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
    if ((localbv == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(202704);
      return;
    }
    final as localas = localbv.Kn(paramString);
    localas.aqQ();
    localas.setUsername(paramString);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202675);
        try
        {
          if ((int)localas.gMZ == 0) {
            localbv.aq(localas);
          }
          if ((int)localas.gMZ <= 0)
          {
            Log.e("AdLandingPagesProxy", "addContact : insert contact failed");
            AppMethodBeat.o(202675);
            return;
          }
          ab.B(localas);
          AppMethodBeat.o(202675);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdLandingPagesProxy", localThrowable.toString());
          AppMethodBeat.o(202675);
        }
      }
    });
    AppMethodBeat.o(202704);
  }
  
  public boolean useOnlineStreamPlayer()
  {
    AppMethodBeat.i(95253);
    Object localObject = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(95253);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(95253);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean useOnlineStreamPlayerMM()
  {
    AppMethodBeat.i(95254);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100208");
    if (localc.isValid())
    {
      int i = Util.getInt((String)localc.gzz().get("useOnlineVideoPlayer"), 0);
      Log.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(95254);
        return true;
      }
      AppMethodBeat.o(95254);
      return false;
    }
    AppMethodBeat.o(95254);
    return false;
  }
  
  public void writeDeferredDeepLink(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95325);
    REMOTE_CALL("writeDeferredDeepLinkMM", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(95325);
  }
  
  @com.tencent.mm.remoteservice.f
  public void writeDeferredDeepLinkMM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95326);
    akz().edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(95326);
  }
  
  public static abstract interface a
  {
    public abstract void Yr(int paramInt);
    
    public abstract void eZP();
    
    public abstract void eZQ();
    
    public abstract void eZR();
    
    public abstract void eZS();
    
    public abstract void eZT();
    
    public abstract void start();
  }
  
  final class b
    implements a.c
  {
    private String LG;
    private String appId;
    private boolean qKw;
    
    public b(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.LG = paramString2;
      this.appId = paramString1;
      this.qKw = paramBoolean;
    }
    
    public final void aOJ(String paramString)
    {
      AppMethodBeat.i(95219);
      Log.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
      if (this.qKw) {
        a.e.DXp.reportDownloadInfo(4, this.appId);
      }
      a.e.DXp.reportDownloadInfo(5, this.appId);
      AppMethodBeat.o(95219);
    }
    
    public final void aOK(String paramString)
    {
      AppMethodBeat.i(95220);
      Log.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.LG))) {
        AdLandingPagesProxy.this.deleteDeferredDeepLinkMM(paramString);
      }
      AppMethodBeat.o(95220);
    }
  }
  
  final class c
    implements c.b
  {
    private String mediaId;
    
    public c(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void aOG(String paramString) {}
    
    public final void ci(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(95221);
      Log.i("AdLandingPagesProxy", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        aj.faJ().b(this);
      }
      AppMethodBeat.o(95221);
    }
    
    public final void cj(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(202676);
      Log.i("AdLandingPagesProxy", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onSightDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        aj.faJ().b(this);
      }
      AppMethodBeat.o(202676);
    }
    
    public final void eZJ() {}
  }
  
  final class d
    implements h.a
  {
    private String mediaId;
    
    public d(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void Ds(String paramString) {}
    
    public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(95225);
      if (paramString.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 30);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      AppMethodBeat.o(95225);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(202677);
      if (paramString1.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 26);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 });
      }
      AppMethodBeat.o(202677);
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(95224);
      if (paramString.equals(this.mediaId)) {
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoProgress", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      }
      AppMethodBeat.o(95224);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(95223);
      if (paramString.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 28);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      }
      AppMethodBeat.o(95223);
    }
  }
  
  public static abstract interface e
  {
    public abstract void bn(Object paramObject);
    
    public abstract void h(int paramInt1, int paramInt2, Object paramObject);
  }
  
  public static final class f
  {
    boolean DGx = false;
    long lastUpdateTime = 0L;
  }
  
  public static abstract interface g
  {
    public abstract void eWO();
    
    public abstract void eZU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */