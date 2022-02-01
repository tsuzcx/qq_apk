package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.aaw;
import com.tencent.mm.autogen.a.aax;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.g.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.c.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.3;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.r;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.fso;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
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
  private static AdLandingPagesProxy Qqj;
  private Map<Long, e> Lfc;
  private com.tencent.mm.remoteservice.d PXV;
  private Map<com.tencent.mm.am.p, Long> Qqk;
  private ConcurrentHashMap<Long, ArrayList<a>> Qql;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b Qqm;
  Map<String, List<f>> Qqn;
  private Map<String, h.a> Qqo;
  private com.tencent.mm.am.h maV;
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    AppMethodBeat.i(95227);
    this.Lfc = new HashMap();
    this.Qqk = new HashMap();
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(95209);
        Object localObject1 = new StringBuilder("onSceneEnd, funcId=");
        int i;
        if (paramAnonymousp == null)
        {
          i = 0;
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", i + ", errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2 + ", errMsg=" + paramAnonymousString);
          if (!(paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.k)) {
            break label273;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label224;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.k)paramAnonymousp).hTL;
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "the dynamic string is " + paramAnonymousString + ", sceneType is " + paramAnonymousp.getType());
        }
        long l;
        for (;;)
        {
          if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
          {
            l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
            AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramAnonymousString });
            com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
          }
          AppMethodBeat.o(95209);
          return;
          i = paramAnonymousp.getType();
          break;
          label224:
          com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramAnonymousInt1 + " error msg is " + paramAnonymousString + " sceneType is " + paramAnonymousp.getType());
          paramAnonymousString = "";
        }
        label273:
        if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.b)) {
          if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp)) {
            break label2669;
          }
        }
        for (;;)
        {
          try
          {
            l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
            paramAnonymousString = (za)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
              break label2736;
            }
            paramAnonymousString = paramAnonymousString.toByteArray();
            AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(95209);
            return;
          }
          if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.j))
          {
            if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
              localObject1 = AdLandingPagesProxy.this;
              paramAnonymousString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.j)paramAnonymousp;
              if (paramAnonymousString.QUK != null) {}
              for (paramAnonymousString = paramAnonymousString.QUK;; paramAnonymousString = "")
              {
                ((AdLandingPagesProxy)localObject1).CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
            }
          }
          else
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.ad.g.h))
            {
              com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "real time report done.");
              com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.e)) {
              if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp)) {
                break label2669;
              }
            }
          }
          for (;;)
          {
            try
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
              com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
              paramAnonymousString = (clv)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                break label2731;
              }
              paramAnonymousString = paramAnonymousString.toByteArray();
              AdLandingPagesProxy.this.CLIENT_CALL("onGetSmartPhoneScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
              AppMethodBeat.o(95209);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + paramAnonymousString.toString());
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h)) {
              try
              {
                com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2);
                com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
              catch (Exception paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(95209);
                return;
              }
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.m)) {
              if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp)) {
                break label2669;
              }
            }
            for (;;)
            {
              try
              {
                l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                paramAnonymousString = (fso)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                  break label2725;
                }
                paramAnonymousString = paramAnonymousString.mdG;
                AdLandingPagesProxy.this.CLIENT_CALL("onUpdateUxInfo", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
              catch (Exception paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(95209);
                return;
              }
              if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.d))
              {
                if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp)) {
                  break label2669;
                }
                l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
              }
              for (;;)
              {
                try
                {
                  paramAnonymousString = (ekp)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                    break label2719;
                  }
                  i = paramAnonymousString.state;
                  AdLandingPagesProxy.this.CLIENT_CALL("onGetHbCoverStateScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
                  com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                  AppMethodBeat.o(95209);
                  return;
                }
                catch (Exception paramAnonymousString)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + paramAnonymousString.toString());
                  AppMethodBeat.o(95209);
                  return;
                }
                if ((paramAnonymousp instanceof l)) {}
                for (;;)
                {
                  try
                  {
                    if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
                    {
                      l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                      paramAnonymousString = (cqm)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
                      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                        break label2714;
                      }
                      paramAnonymousString = paramAnonymousString.toByteArray();
                      AdLandingPagesProxy.this.CLIENT_CALL("onAdUpdateQrUrlEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                      com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                    }
                    AppMethodBeat.o(95209);
                    return;
                  }
                  finally
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd exp=" + paramAnonymousString.toString());
                    AppMethodBeat.o(95209);
                    return;
                  }
                  Object localObject2;
                  if (((paramAnonymousp instanceof com.tencent.mm.openim.model.b)) || ((paramAnonymousp instanceof com.tencent.mm.pluginsdk.model.v))) {
                    try
                    {
                      JSONObject localJSONObject;
                      if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
                      {
                        com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "onSceneEnd, errType = " + paramAnonymousInt1 + ", errCode = " + paramAnonymousInt2 + "," + paramAnonymousString);
                        l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                        if ((paramAnonymousp.getType() != 30) && (paramAnonymousp.getType() != 667))
                        {
                          com.tencent.mm.sdk.platformtools.Log.w("AdLandingPagesProxy", "not expected scene,  type = " + paramAnonymousp.getType());
                          AppMethodBeat.o(95209);
                          return;
                        }
                        if (((paramAnonymousp instanceof com.tencent.mm.pluginsdk.model.v)) && (((com.tencent.mm.pluginsdk.model.v)paramAnonymousp).hId != 1))
                        {
                          com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "not opcode addcontact!");
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
                            if (paramAnonymousp.getType() != 30) {
                              break label1827;
                            }
                            localObject1 = ((com.tencent.mm.pluginsdk.model.v)paramAnonymousp).iIc();
                          }
                        }
                      }
                      for (;;)
                      {
                        localJSONObject.put("errMsg", paramAnonymousString);
                        localJSONObject.put("respUsername", localObject1);
                        AdLandingPagesProxy.this.CLIENT_CALL("onAddBrandSceneEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localJSONObject.toString() });
                        b.d(AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                        AppMethodBeat.o(95209);
                        return;
                        label1827:
                        localObject1 = localObject2;
                        if (paramAnonymousp.getType() == 667) {
                          localObject1 = ((com.tencent.mm.openim.model.b)paramAnonymousp).psp;
                        }
                      }
                      if (!(paramAnonymousp instanceof com.tencent.mm.plugin.messenger.a.f)) {}
                    }
                    finally
                    {
                      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneAddOpenIMContact or NetSceneVerifyUser onSceneEnd exp=" + paramAnonymousString.toString());
                      AppMethodBeat.o(95209);
                      return;
                    }
                  }
                  for (;;)
                  {
                    try
                    {
                      if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
                      {
                        l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                        paramAnonymousString = (evg)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
                        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                          break label2709;
                        }
                        paramAnonymousString = paramAnonymousString.toByteArray();
                        AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                      }
                    }
                    finally
                    {
                      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneSearchContact, onSceneEnd exp=" + paramAnonymousString.toString());
                      continue;
                    }
                    com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                    AppMethodBeat.o(95209);
                    return;
                    if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a)) {}
                    for (;;)
                    {
                      try
                      {
                        if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
                        {
                          l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                          paramAnonymousString = (by)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
                          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                            break label2704;
                          }
                          paramAnonymousString = paramAnonymousString.toByteArray();
                          AdLandingPagesProxy.this.CLIENT_CALL("onAdNativeAntiAbuse", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                        }
                      }
                      finally
                      {
                        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneAdAntiAbuse, onSceneEnd exp = " + paramAnonymousString.toString());
                        continue;
                      }
                      com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                      AppMethodBeat.o(95209);
                      return;
                      if ((paramAnonymousp instanceof com.tencent.mm.plugin.sns.ad.h.b))
                      {
                        try
                        {
                          if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
                          {
                            l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                            i = ((com.tencent.mm.protocal.protobuf.af)com.tencent.mm.am.c.b.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otB)).YAN;
                            localObject2 = "-1";
                            localObject1 = localObject2;
                            if (paramAnonymousInt1 == 0)
                            {
                              localObject1 = localObject2;
                              if (paramAnonymousInt2 == 0) {
                                localObject1 = String.valueOf(((ag)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC)).status);
                              }
                            }
                            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "NetSceneAdAppointment, errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2 + ", errMsg=" + paramAnonymousString + ", opType=" + i + ", status=" + (String)localObject1);
                            AdLandingPagesProxy.this.CLIENT_CALL("onSendAppointmentReq", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), localObject1 });
                          }
                        }
                        finally
                        {
                          for (;;)
                          {
                            com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "NetSceneAdAppointment, onSceneEnd exp = " + paramAnonymousString.toString());
                          }
                        }
                        com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                        AppMethodBeat.o(95209);
                        return;
                      }
                      if (paramAnonymousp != null) {}
                      try
                      {
                        if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousp))
                        {
                          l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousp)).longValue();
                          localObject2 = c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC);
                          localObject1 = null;
                          paramAnonymousString = (String)localObject1;
                          if (paramAnonymousInt1 == 0)
                          {
                            paramAnonymousString = (String)localObject1;
                            if (paramAnonymousInt2 == 0)
                            {
                              paramAnonymousString = (String)localObject1;
                              if (localObject2 != null) {
                                paramAnonymousString = ((com.tencent.mm.bx.a)localObject2).toByteArray();
                              }
                            }
                          }
                          AdLandingPagesProxy.this.CLIENT_CALL("onRspCallbackCommon", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                        }
                      }
                      finally
                      {
                        for (;;)
                        {
                          com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "default, onSceneEnd exp=" + paramAnonymousString.toString());
                        }
                      }
                      com.tencent.mm.kernel.h.aZW().b(paramAnonymousp.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                      label2669:
                      AppMethodBeat.o(95209);
                      return;
                      label2704:
                      paramAnonymousString = null;
                    }
                    label2709:
                    paramAnonymousString = null;
                  }
                  label2714:
                  paramAnonymousString = null;
                }
                label2719:
                i = -1;
              }
              label2725:
              paramAnonymousString = "";
            }
            label2731:
            paramAnonymousString = null;
          }
          label2736:
          paramAnonymousString = null;
        }
      }
    };
    this.Qql = new ConcurrentHashMap();
    this.Qqm = new AdLandingPagesProxy.4(this);
    this.Qqn = new HashMap();
    this.Qqo = new HashMap();
    this.PXV = paramd;
    AppMethodBeat.o(95227);
  }
  
  private static SharedPreferences aKt()
  {
    AppMethodBeat.i(95329);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0);
    AppMethodBeat.o(95329);
    return localSharedPreferences;
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    AppMethodBeat.i(95228);
    if (Qqj == null) {
      Qqj = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
    }
    AdLandingPagesProxy localAdLandingPagesProxy = Qqj;
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
    r.hkH().ag(paramLong, paramString);
    AppMethodBeat.o(95331);
  }
  
  public void addReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, t.a parama)
  {
    AppMethodBeat.i(309928);
    REMOTE_CALL("addReportInfoMM", new Object[] { paramString1, paramString2, paramString3, paramString4, parama });
    AppMethodBeat.o(309928);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addReportInfoMM(String paramString1, String paramString2, String paramString3, String paramString4, t.a parama)
  {
    AppMethodBeat.i(309922);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    if ((paramString1 == null) || (paramString1.length() == 0) || (parama == null))
    {
      AppMethodBeat.o(309922);
      return;
    }
    paramString2 = new a.e(paramString2, paramString3, paramString4, parama.rzx, parama.enterScene, parama.adExtInfo, parama.pId, parama.Qms);
    locala.QIB.put(paramString1, paramString2);
    AppMethodBeat.o(309922);
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95218);
        if (!com.tencent.mm.kernel.h.baC().aZN())
        {
          AppMethodBeat.o(95218);
          return;
        }
        Object localObject = al.hgB().aZK(paramString);
        if (localObject != null)
        {
          localObject = ((SnsInfo)localObject).getAdXml();
          if (localObject != null)
          {
            AdLandingPagesProxy.aXQ(((ADXml)localObject).getLeftCanvasInfo());
            AdLandingPagesProxy.aXQ(((ADXml)localObject).getRightCanvasInfo());
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
    synchronized (this.Qqn)
    {
      this.Qqn.clear();
      this.Lfc.clear();
      this.Qql.clear();
      AppMethodBeat.o(95350);
      return;
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearCallbackMM()
  {
    AppMethodBeat.i(95349);
    this.Qqk.clear();
    this.Qqm = null;
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1337, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1210, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2874, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2721, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1802, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2605, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2883, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(4353, this.maV);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aYi(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(95242);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(95226);
    this.PXV.connect(paramRunnable);
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
    int i = ab.IX(paramString);
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
    aKt().edit().remove(paramString).commit();
    AppMethodBeat.o(95328);
  }
  
  public void doAdChannelScene(String paramString1, String paramString2, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(95274);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdChannelSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(95274);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdChannelSceneMM(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(95275);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.b(paramString1, paramString2, paramBoolean);
    this.Qqk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1210, this.maV);
    AppMethodBeat.o(95275);
  }
  
  public void doAdNativeAntiAbuseScene(String paramString1, String paramString2, int paramInt, String paramString3, e parame)
  {
    AppMethodBeat.i(309746);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdNativeAntiAbuseSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Integer.valueOf(paramInt), paramString3 });
    AppMethodBeat.o(309746);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdNativeAntiAbuseSceneMM(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(309754);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(paramString1, paramString2, paramInt, paramString3);
    this.Qqk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aZW().a(4679, this.maV);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(309754);
  }
  
  public void doAdUpdateQrUrlScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, e parame)
  {
    AppMethodBeat.i(309661);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdUpdateQrUrlSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
    AppMethodBeat.o(309661);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdUpdateQrUrlSceneMM(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(309666);
    paramString1 = new l(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    this.Qqk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aZW().a(1022, this.maV);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(309666);
  }
  
  public void doAddBrandScene(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(310191);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAddBrandSceneSceneMM", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(310191);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAddBrandSceneSceneMM(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(310198);
    paramString = b.a(paramString, this.maV, paramInt);
    if ((paramString instanceof com.tencent.mm.openim.model.b))
    {
      paramString = (com.tencent.mm.openim.model.b)paramString;
      this.Qqk.put(paramString, Long.valueOf(paramLong));
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      AppMethodBeat.o(310198);
      return;
    }
    if ((paramString instanceof com.tencent.mm.pluginsdk.model.v))
    {
      paramString = (com.tencent.mm.pluginsdk.model.v)paramString;
      this.Qqk.put(paramString, Long.valueOf(paramLong));
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    }
    AppMethodBeat.o(310198);
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
    dfo localdfo = new dfo();
    localdfo.aaLf = paramInt;
    localdfo.aaLn = ((int)(System.currentTimeMillis() / 1000L));
    localdfo.vgN = 1;
    localdfo.aaLg = new com.tencent.mm.bx.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localdfo);
    paramString = new com.tencent.mm.plugin.sns.ad.g.h(paramString);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1802, this.maV);
    AppMethodBeat.o(95346);
  }
  
  public void doDynamicUpdateScene(String paramString1, String paramString2, String paramString3, e parame)
  {
    AppMethodBeat.i(95268);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95268);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doDynamicUpdateSceneMM(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95269);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.k(paramString1, paramString2, paramString3);
    this.Qqk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1337, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2721, this.maV);
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
    dn localdn = new dn();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      Util.isNullOrNil(paramString1);
    }
    if (!((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fav.a.af.class)).a(localdn, paramString6.hashCode(), z.bAM(), paramString4, paramString5, paramString6, paramString7, paramString2))
    {
      if (localdn.hDr.hDx == 0) {
        localdn.hDr.hDx = b.j.favorite_fail_nonsupport;
      }
      paramInt1 = localdn.hDr.hDx;
      AppMethodBeat.o(95264);
      return paramInt1;
    }
    paramString1 = ad.Jo(paramString3);
    localdn.hDr.sessionId = paramString1;
    localdn.hDr.title = paramString4;
    localdn.hDr.desc = paramString5;
    paramString1 = localdn.hDr.hDt;
    if ((paramString1 != null) && (paramString1.vEn != null) && (paramString1.vEn.size() > 0) && (paramString1.vEn.get(0) != null))
    {
      ((arf)paramString1.vEn.get(0)).bsN(paramString6);
      ((arf)paramString1.vEn.get(0)).bso(paramString4);
      ((arf)paramString1.vEn.get(0)).bsp(paramString5);
      ((arf)paramString1.vEn.get(0)).bsM(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.btm(paramString4);
      paramString1.btn(paramString5);
    }
    localdn.hDr.hDy = paramInt2;
    localdn.publish();
    paramInt1 = localdn.hDr.hDx;
    AppMethodBeat.o(95264);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(95266);
    dn localdn = new dn();
    ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fav.a.af.class)).a(localdn, paramIntent);
    localdn.hDr.hDy = paramInt;
    localdn.publish();
    paramInt = localdn.hDr.hDx;
    AppMethodBeat.o(95266);
    return paramInt;
  }
  
  public void doFavOfficialItemScene(String paramString, e parame)
  {
    AppMethodBeat.i(95340);
    if (Util.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
      AppMethodBeat.o(95340);
      return;
    }
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doFavOfficialItemSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(95340);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doFavOfficialItemSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95341);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.j(paramString);
    this.Qqk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2874, this.maV);
    AppMethodBeat.o(95341);
  }
  
  public void doGetHbCoverState(String paramString, e parame)
  {
    AppMethodBeat.i(95282);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doGetHbCoverStateMM", new Object[] { Long.valueOf(l), paramString });
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "doGetHbCoverState, hbCoverId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95282);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doGetHbCoverStateMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95283);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.d(paramString);
    this.Qqk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2944, this.maV);
    AppMethodBeat.o(95283);
  }
  
  public void doGetSmartPhoneScene(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, e parame)
  {
    AppMethodBeat.i(95276);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doGetSmartPhoneSceneMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95276);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doGetSmartPhoneSceneMM(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(95277);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.e(paramLong2, paramInt1, paramString1, paramString2, paramInt2);
    this.Qqk.put(paramString1, Long.valueOf(paramLong1));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2605, this.maV);
    AppMethodBeat.o(95277);
  }
  
  public void doJumpToFinderFeedsDetailUI(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310315);
    try
    {
      REMOTE_CALL("doJumpToFinderFeedsDetailUIMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(310315);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "doJumpToFinderFeedsDetailUI remote call has an exception!");
      AppMethodBeat.o(310315);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void doJumpToFinderFeedsDetailUIMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310325);
    try
    {
      Object localObject = al.hgB().aZK(paramString5);
      boolean bool;
      if (localObject == null)
      {
        bool = false;
        com.tencent.mm.plugin.sns.ad.d.n.a(MMApplicationContext.getContext(), paramString4, paramString1, paramString2, paramString3, com.tencent.mm.plugin.sns.data.m.aXe(paramString5), bool, paramInt2);
        AppMethodBeat.o(310325);
        return;
      }
      if (paramInt1 == 16) {}
      for (localObject = ((SnsInfo)localObject).getAtAdInfo();; localObject = ((SnsInfo)localObject).getAdInfo())
      {
        bool = ((ADInfo)localObject).preloadFinderFeed;
        break;
      }
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "doJumpToFinderFeedsDetailUI call has an exception");
      AppMethodBeat.o(310325);
    }
  }
  
  public void doJumpToFinderProfileUI(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(310290);
    REMOTE_CALL("doJumpToFinderProfileUIMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(310290);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doJumpToFinderProfileUIMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(310295);
    com.tencent.mm.plugin.sns.ad.d.n.a(MMApplicationContext.getContext(), paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(310295);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchContactMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(309704);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "doSearchContactMM, userName=".concat(String.valueOf(paramString)));
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, 1);
    this.Qqk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aZW().a(106, this.maV);
    com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    AppMethodBeat.o(309704);
  }
  
  public void doSearchDynamicUpdateScene(String paramString, e parame)
  {
    AppMethodBeat.i(95271);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doSearchDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(95271);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchDynamicUpdateSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95272);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.k(paramString);
    this.Qqk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1337, this.maV);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2721, this.maV);
    AppMethodBeat.o(95272);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(309615);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString1.aYi(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(309615);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doTransimtMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void doUpdateUxInfoScene(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(309727);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("doUpdateUxInfoSceneMM", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(309727);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doUpdateUxInfoSceneMM(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(309733);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.m(paramString, paramInt);
    this.Qqk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2883, this.maV);
    AppMethodBeat.o(309733);
  }
  
  public void downloadLandingPageVideo(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, h.a parama)
  {
    AppMethodBeat.i(310101);
    if (Util.isNullOrNil(new String[] { paramString1, paramString2, paramString3 }))
    {
      if (parama != null) {
        parama.a(paramString1, -1, null);
      }
      AppMethodBeat.o(310101);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 20);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (y.ZC(paramString3))
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 21);
        parama.a(paramString1, 0, null);
        AppMethodBeat.o(310101);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 22);
    }
    while (this.Qqo.containsKey(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.i("%s is already in downloading", paramString2);
      AppMethodBeat.o(310101);
      return;
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "last download file was deleted");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 23);
        localSharedPreferences.edit().putBoolean(paramString1, false).commit();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 24);
      }
    }
    if (parama != null) {
      this.Qqo.put(paramString1, parama);
    }
    REMOTE_CALL("downloadLandingPageVideoMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(310101);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPageVideoMM(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(310118);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 25);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309424);
        final c localc = al.hgw();
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309501);
            localc.a(AdLandingPagesProxy.8.this.bJZ, AdLandingPagesProxy.8.this.val$url, AdLandingPagesProxy.8.this.val$path, AdLandingPagesProxy.8.this.Qqs, AdLandingPagesProxy.8.this.emC, AdLandingPagesProxy.8.this.Qqt, new AdLandingPagesProxy.d(AdLandingPagesProxy.this, AdLandingPagesProxy.8.this.bJZ));
            AppMethodBeat.o(309501);
          }
        });
        AppMethodBeat.o(309424);
      }
    });
    AppMethodBeat.o(310118);
  }
  
  public void downloadLandingPagesCDNFile(String paramString1, String paramString2, String paramString3, int paramInt, f paramf)
  {
    AppMethodBeat.i(310056);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      if (paramf != null) {
        paramf.gZN();
      }
      AppMethodBeat.o(310056);
      return;
    }
    if (paramf != null) {}
    for (;;)
    {
      synchronized (this.Qqn)
      {
        if (!this.Qqn.containsKey(paramString2))
        {
          this.Qqn.put(paramString2, new ArrayList());
          i = 1;
          List localList = (List)this.Qqn.get(paramString2);
          if (localList != null) {
            localList.add(paramf);
          }
          if (i != 0) {
            REMOTE_CALL("downloadLandingPagesCDNFileMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
          }
          AppMethodBeat.o(310056);
          return;
        }
      }
      int i = 0;
      continue;
      i = 0;
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesCDNFileMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(310064);
    if (paramInt == 0)
    {
      downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
      AppMethodBeat.o(310064);
      return;
    }
    if (paramInt == 1) {
      downloadLandingPagesSightMMImpl(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(310064);
  }
  
  public void downloadLandingPagesImageMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(95353);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.o.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    final com.tencent.mm.plugin.sns.data.p localp = new com.tencent.mm.plugin.sns.data.p(paramString3);
    localp.QnY = 3;
    localp.hOG = paramString3.Id;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309428);
        al.hgw().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        c localc = al.hgw();
        dmz localdmz = paramString3;
        com.tencent.mm.plugin.sns.data.p localp = localp;
        br localbr = br.jbh();
        localbr.time = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localdmz, 8, localp, localbr, paramString1, paramString2);
        AppMethodBeat.o(309428);
      }
    });
    AppMethodBeat.o(95353);
  }
  
  public void downloadLandingPagesSightMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(310077);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "downloadLandingPagesSightMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.o.a(paramString2, 6, paramString3, paramString3, 1, 1, "");
    paramString3.isAd = true;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309441);
        al.hgw().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        c localc = al.hgw();
        dmz localdmz = paramString3;
        br localbr = br.jbh();
        localbr.time = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localdmz, 4, null, localbr, paramString1, paramString2);
        AppMethodBeat.o(309441);
      }
    });
    AppMethodBeat.o(310077);
  }
  
  public void downloadPagFile(String paramString)
  {
    AppMethodBeat.i(310434);
    REMOTE_CALL("downloadPagFileMM", new Object[] { paramString });
    AppMethodBeat.o(310434);
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean downloadPagFileMM(String paramString)
  {
    AppMethodBeat.i(310442);
    try
    {
      com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b.downloadPagFile(paramString);
      AppMethodBeat.o(310442);
      return false;
    }
    finally
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "downloadPagFileMM exp=" + android.util.Log.getStackTraceString(paramString));
      }
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void failed(long paramLong)
  {
    AppMethodBeat.i(95305);
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.hfu();
      }
    }
    this.Qql.remove(Long.valueOf(paramLong));
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
    ht localht = new ht();
    localht.hIR.type = 35;
    localht.publish();
    AppMethodBeat.o(95261);
  }
  
  public void fetchQRCodeInfo(int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(95371);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("fetchQRCodeInfoMM", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(95371);
  }
  
  @com.tencent.mm.remoteservice.f
  public void fetchQRCodeInfoMM(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95372);
    com.tencent.threadpool.h.ahAA.bm(new AdLandingPagesProxy.9(this, paramInt, paramString, paramLong));
    AppMethodBeat.o(95372);
  }
  
  public void geoLocation(String paramString, e parame)
  {
    AppMethodBeat.i(310173);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "geoLocation is called!!");
      long l = System.currentTimeMillis();
      this.Lfc.put(Long.valueOf(l), parame);
      REMOTE_CALL("geoLocationMM", new Object[] { Long.valueOf(l), paramString });
      AppMethodBeat.o(310173);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "geoLocation catch one exception");
      AppMethodBeat.o(310173);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void geoLocationMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(310179);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "geoLocationMM is called!!");
      com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b localb = com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c.a(this, "onGeoLocation", paramLong);
      if (localb != null) {
        localb.request(paramString);
      }
      AppMethodBeat.o(310179);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "geoLocationMM catch one exception");
      AppMethodBeat.o(310179);
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
    String str = al.getAccSnsPath();
    AppMethodBeat.o(95237);
    return str;
  }
  
  public String getAdValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310474);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(310474);
      return "";
    }
    try
    {
      paramString1 = REMOTE_CALL("getAdValueMM", new Object[] { paramString1, paramString2 });
      if ((paramString1 instanceof String))
      {
        paramString1 = (String)paramString1;
        AppMethodBeat.o(310474);
        return paramString1;
      }
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getAdValue exp=" + paramString1.toString());
      AppMethodBeat.o(310474);
    }
    return "";
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAdValueMM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310481);
    try
    {
      paramString1 = com.tencent.mm.plugin.sns.ad.a.getAdValue(paramString1, paramString2);
      AppMethodBeat.o(310481);
      return paramString1;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getAdValueMM exp=" + paramString1.toString());
      AppMethodBeat.o(310481);
    }
    return "";
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
    int i = ai.be(paramString1, paramString2, paramString3);
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
    paramString1 = ai.bf(paramString1, paramString2, paramString3);
    AppMethodBeat.o(95337);
    return paramString1;
  }
  
  public Bitmap getAvatarByUserName(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(310390);
    paramString = REMOTE_CALL("getAvatarByUserNameMM", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if ((paramString instanceof Bitmap))
    {
      paramString = (Bitmap)paramString;
      AppMethodBeat.o(310390);
      return paramString;
    }
    AppMethodBeat.o(310390);
    return null;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bitmap getAvatarByUserNameMM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(310404);
    for (;;)
    {
      try
      {
        String str = paramString + "-1.0";
        com.tencent.mm.by.a.a locala = a.a.acjy;
        if (locala == null) {
          break label221;
        }
        Bitmap localBitmap = a.a.acjy.aKc(str);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "getAvatarByUserNameMM, useCache, name=".concat(String.valueOf(paramString)));
          AppMethodBeat.o(310404);
          return localBitmap;
        }
        j.a locala1 = com.tencent.mm.pluginsdk.ui.a.b.iKa();
        if (locala1 != null)
        {
          localBitmap = locala1.loadBitmap(paramString);
          if (localBitmap == null) {
            break label210;
          }
          localBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 1.0F * localBitmap.getWidth());
          if (locala != null) {
            locala.p(str, localBitmap);
          }
          if (localBitmap != null)
          {
            paramBoolean = localBitmap.isRecycled();
            if (!paramBoolean)
            {
              AppMethodBeat.o(310404);
              return localBitmap;
            }
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "getAvatarByUserNameMM, loader==null");
          continue;
        }
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "getAvatarByUserNameMM, loader return null");
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getAvatarByUserNameMM name=" + paramString + ", exp=" + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(310404);
        return null;
      }
      label210:
      continue;
      label221:
      Object localObject = null;
    }
  }
  
  public void getBtnPersonalWxUserName(String paramString1, String paramString2, e parame)
  {
    AppMethodBeat.i(309689);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("getBtnPersonalWxUserNameMM", new Object[] { Long.valueOf(l), paramString1, paramString2 });
    AppMethodBeat.o(309689);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getBtnPersonalWxUserNameMM(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(309697);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.c(paramString1, paramString2);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(4353, new AdLandingPagesProxy.3(this, paramLong));
    AppMethodBeat.o(309697);
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
    com.tencent.mm.kernel.h.baF();
    paramObject = com.tencent.mm.kernel.h.baE().ban().d(paramInt, paramObject);
    AppMethodBeat.o(95231);
    return paramObject;
  }
  
  public String getDisplayName(String paramString)
  {
    AppMethodBeat.i(309574);
    paramString = REMOTE_CALL("getDisplayNameMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(309574);
      return "";
    }
    paramString = (String)paramString;
    AppMethodBeat.o(309574);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getDisplayNameMM(String paramString)
  {
    AppMethodBeat.i(309579);
    try
    {
      com.tencent.mm.kernel.h.baF();
      bx localbx = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
      if (localbx == null) {}
      for (paramString = null; paramString == null; paramString = localbx.bxv(paramString))
      {
        AppMethodBeat.o(309579);
        return "";
      }
      paramString = paramString.aSV();
      AppMethodBeat.o(309579);
      return paramString;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getDisplayNameMM, exp=" + paramString.toString());
      AppMethodBeat.o(309579);
    }
    return "";
  }
  
  public void getOpenSdkAppInfo(String paramString, e parame)
  {
    AppMethodBeat.i(310367);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "getOpenSdkAppInfo, appId=".concat(String.valueOf(paramString)));
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("getOpenSdkAppInfoMM", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(310367);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getOpenSdkAppInfoMM(String paramString, long paramLong)
  {
    AppMethodBeat.i(310382);
    com.tencent.threadpool.h.ahAA.bm(new AdLandingPagesProxy.2(this, paramString, paramLong));
    AppMethodBeat.o(310382);
  }
  
  public String getPhoneNumber()
  {
    AppMethodBeat.i(310339);
    Object localObject = REMOTE_CALL("getPhoneNumberMM", new Object[0]);
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(310339);
      return localObject;
    }
    AppMethodBeat.o(310339);
    return "";
  }
  
  @com.tencent.mm.remoteservice.f
  public String getPhoneNumberMM()
  {
    AppMethodBeat.i(310348);
    try
    {
      String str1 = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
      AppMethodBeat.o(310348);
      return str1;
    }
    finally
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getPhoneNumberMM exp=" + android.util.Log.getStackTraceString(localThrowable));
        String str2 = "";
      }
    }
  }
  
  public com.tencent.mm.remoteservice.d getRemoteServiceProxy()
  {
    return this.PXV;
  }
  
  public String getSelfNickName()
  {
    AppMethodBeat.i(309569);
    Object localObject = REMOTE_CALL("getSelfNickNameMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(309569);
      return "";
    }
    localObject = (String)localObject;
    AppMethodBeat.o(309569);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSelfNickNameMM()
  {
    AppMethodBeat.i(309572);
    try
    {
      String str = z.bAO();
      AppMethodBeat.o(309572);
      return str;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getSelfNickNameMM, exp=" + localObject.toString());
      AppMethodBeat.o(309572);
    }
    return "";
  }
  
  public String getSelfUserName()
  {
    AppMethodBeat.i(309565);
    Object localObject = REMOTE_CALL("getSelfUserNameMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(309565);
      return "";
    }
    localObject = (String)localObject;
    AppMethodBeat.o(309565);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSelfUserNameMM()
  {
    AppMethodBeat.i(309567);
    try
    {
      String str = z.bAM();
      AppMethodBeat.o(309567);
      return str;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getSelfUserNameMM, exp=" + localObject.toString());
      AppMethodBeat.o(309567);
    }
    return "";
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
    paramString = al.hgB().aZK(paramString);
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
    paramString = al.hgB().aZK(paramString);
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
    paramString = al.hgB().aZK(paramString);
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
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("AdLandingPagesProxy", paramString, "", new Object[0]);
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
    paramString = al.hgB().aZK(paramString);
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
    Object localObject = al.hgE().vd(paramLong);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.sns.ad.g.k.b(((AdSnsInfo)localObject).getTimeLine());
      AppMethodBeat.o(95235);
      return localObject;
    }
    com.tencent.mm.sdk.platformtools.Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { Long.valueOf(paramLong) });
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
    paramString = al.hgB().aZK(paramString);
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
    paramString = al.hgB().aZK(paramString);
    if (paramString != null)
    {
      paramString = paramString.getUxinfo();
      AppMethodBeat.o(95246);
      return paramString;
    }
    AppMethodBeat.o(95246);
    return "";
  }
  
  public int getSyncServerTimeSecond()
  {
    AppMethodBeat.i(309581);
    Object localObject = REMOTE_CALL("getSyncServerTimeSecondMM", new Object[0]);
    if ((localObject instanceof Integer))
    {
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(309581);
      return i;
    }
    int i = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(309581);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getSyncServerTimeSecondMM()
  {
    AppMethodBeat.i(309584);
    int i;
    try
    {
      i = cn.getSyncServerTimeSecond();
      AppMethodBeat.o(309584);
      return i;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getSyncServerTimeSecondMM, exp=" + localObject.toString());
      i = (int)(System.currentTimeMillis() / 1000L);
      AppMethodBeat.o(309584);
    }
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    paramString = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString);
    if (paramString.uWn != 0L)
    {
      int i = (int)(paramString.xom * 100L / paramString.uWn);
      AppMethodBeat.o(95315);
      return i;
    }
    AppMethodBeat.o(95315);
    return 0;
  }
  
  public void getTwistAdCard(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, e parame)
  {
    AppMethodBeat.i(310245);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("getTwistAdCardMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    AppMethodBeat.o(310245);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getTwistAdCardMM(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(310251);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.f(paramString1, paramString2, paramInt, paramString3, paramString4);
    this.Qqk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(4729, this.maV);
    AppMethodBeat.o(310251);
  }
  
  public void getTwistAdCardStatus(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, e parame)
  {
    AppMethodBeat.i(310258);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("getTwistAdCardStatusMM", new Object[] { Long.valueOf(l), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString4, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(310258);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getTwistAdCardStatusMM(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(310265);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.g(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2);
    this.Qqk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(4689, this.maV);
    AppMethodBeat.o(310265);
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
    com.tencent.mm.kernel.h.baC();
    String str = com.tencent.mm.kernel.b.aZs();
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
    paramString3 = a.f.QIF;
    paramString4 = MMApplicationContext.getContext();
    b localb = new b(paramString1, paramString2, false, 1);
    if ((paramString4 == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(95319);
      return false;
    }
    paramString1 = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString1);
    if ((paramString1 != null) && (paramString1.status == 3) && (!TextUtils.isEmpty(paramString1.path)))
    {
      paramString3.bb(4, paramString1.id);
      paramString3.a(4001010, paramString1.id, new a.c(1));
      com.tencent.mm.pluginsdk.model.app.v.b(paramString4, paramString1.path, null, false);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
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
    int i = al.hgy().b(null, null);
    AppMethodBeat.o(95262);
    return i;
  }
  
  public boolean isBrandAdded(String paramString)
  {
    AppMethodBeat.i(310207);
    paramString = REMOTE_CALL("selectBrandAdd", new Object[] { paramString });
    if ((paramString instanceof Boolean))
    {
      boolean bool = ((Boolean)paramString).booleanValue();
      AppMethodBeat.o(310207);
      return bool;
    }
    AppMethodBeat.o(310207);
    return false;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(95229);
    if (this.PXV == null)
    {
      AppMethodBeat.o(95229);
      return false;
    }
    boolean bool = this.PXV.isConnected();
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    paramString = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString);
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
    AppMethodBeat.i(310276);
    Object localObject = REMOTE_CALL("isFreeSimCardMM", new Object[0]);
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(310276);
      return bool;
    }
    AppMethodBeat.o(310276);
    return false;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isFreeSimCardMM()
  {
    AppMethodBeat.i(310281);
    int i = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.misc.a.a.class)).gbv();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "isFreeSimCard, simType=" + i + ", isFree=" + bool);
      AppMethodBeat.o(310281);
      return bool;
    }
  }
  
  public String isFriend(String paramString)
  {
    AppMethodBeat.i(310414);
    paramString = REMOTE_CALL("isFriendMM", new Object[] { paramString });
    if ((paramString instanceof String))
    {
      paramString = (String)paramString;
      AppMethodBeat.o(310414);
      return paramString;
    }
    AppMethodBeat.o(310414);
    return "";
  }
  
  @com.tencent.mm.remoteservice.f
  public String isFriendMM(String paramString)
  {
    AppMethodBeat.i(310426);
    try
    {
      String str2 = ((com.tencent.mm.plugin.hashinfo.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.hashinfo.a.a.class)).getUserNameByHash(paramString, 2);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "isFriendMM, hashName=" + paramString + ", userName=" + str2);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString;
      }
      if (!TextUtils.isEmpty(str1))
      {
        com.tencent.mm.kernel.h.baF();
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
        if (paramString != null)
        {
          boolean bool = paramString.bxr(str1);
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "userName=" + str1 + ", isFriend=" + bool);
          if (bool)
          {
            AppMethodBeat.o(310426);
            return str1;
          }
        }
      }
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "isFriendMM exp=" + android.util.Log.getStackTraceString(paramString));
      AppMethodBeat.o(310426);
    }
    return "";
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    paramString = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bR(MMApplicationContext.getContext(), paramString);
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
    paramString = al.hgB().aZK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95248);
      return false;
    }
    boolean bool = paramString.isRecExpAd();
    AppMethodBeat.o(95248);
    return bool;
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
    boolean bool = com.tencent.mm.modelvideo.v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(95364);
    return bool;
  }
  
  public boolean isWeAppAppendClickTime(String paramString, int paramInt)
  {
    AppMethodBeat.i(310328);
    try
    {
      paramString = REMOTE_CALL("isWeAppAppendClickTimeMM", new Object[] { paramString, Integer.valueOf(paramInt) });
      if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue()))
      {
        AppMethodBeat.o(310328);
        return true;
      }
      AppMethodBeat.o(310328);
      return false;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "isWeAppAppendClickTime remote call has an exception!");
      AppMethodBeat.o(310328);
    }
    return false;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isWeAppAppendClickTimeMM(String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(310335);
    try
    {
      paramString = al.hgB().aZK(paramString);
      if (paramString != null) {
        if (paramInt != 16) {
          break label44;
        }
      }
      label44:
      for (paramString = paramString.getAtAdInfo();; paramString = paramString.getAdInfo())
      {
        bool = paramString.addClickTimeToWeAppPath;
        AppMethodBeat.o(310335);
        return bool;
      }
      return false;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "isWeAppAppendClickTimeMM call has an exception");
      AppMethodBeat.o(310335);
    }
  }
  
  public void launchBackApp(String paramString)
  {
    AppMethodBeat.i(310354);
    REMOTE_CALL("launchBackAppMM", new Object[] { paramString });
    AppMethodBeat.o(310354);
  }
  
  @com.tencent.mm.remoteservice.f
  public void launchBackAppMM(String paramString)
  {
    AppMethodBeat.i(310359);
    com.tencent.mm.pluginsdk.ui.tools.n.d("nativeOpenAdCanvas", "", paramString, 0, "");
    AppMethodBeat.o(310359);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdChannelEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95273);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
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
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h(paramString1, paramString2);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2538, this.maV);
    AppMethodBeat.o(95286);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdNativeAntiAbuse(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(309763);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(309763);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdUpdateQrUrlEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(309670);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(309670);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAddBrandSceneEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(310203);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(310203);
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(95291);
    com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
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
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "cdn video data available %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.Qqo.containsKey(paramString)) {
      ((h.a)this.Qqo.get(paramString)).onDataAvailable(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95366);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoFinish(String paramString, int paramInt)
  {
    AppMethodBeat.i(95368);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "cdn video finish %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, true).commit();
    }
    if (this.Qqo.containsKey(paramString)) {
      ((h.a)this.Qqo.remove(paramString)).a(paramString, paramInt, null);
    }
    AppMethodBeat.o(95368);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(310139);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.Qqo.containsKey(paramString1)) {
      ((h.a)this.Qqo.get(paramString1)).a(paramString1, paramLong1, paramLong2, paramString2);
    }
    AppMethodBeat.o(310139);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoProgress(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95367);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "cdn video progress %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.Qqo.containsKey(paramString)) {
      ((h.a)this.Qqo.get(paramString)).h(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95367);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AppMethodBeat.i(95270);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if ((locale != null) && (!Util.isNullOrNil(paramString))) {
      locale.onCallback(paramString);
    }
    AppMethodBeat.o(95270);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFavOfficialItemEnd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95342);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      if (locale != null) {
        locale.h(paramInt1, paramInt2, null);
      }
      AppMethodBeat.o(95342);
      return;
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[] { paramString });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFetchQRCodeInfo(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95373);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95373);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGeoLocation(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(310184);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "onGeoLocation is called!!");
      e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
      if (locale != null) {
        locale.onCallback(paramObject);
      }
      AppMethodBeat.o(310184);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "onGeoLocation catch one exception");
      AppMethodBeat.o(310184);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetBtnPersonalWxUserName(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(309712);
    e locale = (e)this.Lfc.get(Long.valueOf(paramLong));
    if (locale != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("username", paramString1);
        localJSONObject.put("aliasname", paramString2);
        locale.onCallback(localJSONObject.toString());
        AppMethodBeat.o(309712);
        return;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "onGetBtnPersonalWxUserName, exp=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(309712);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetHbCoverStateScene(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95284);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95284);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetOpenSdkAppInfo(String paramString, long paramLong)
  {
    AppMethodBeat.i(310377);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onGetOpenSdkAppInfo");
      locale.onCallback(paramString);
    }
    AppMethodBeat.o(310377);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetSmartPhoneScene(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95278);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95278);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onImgDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(95354);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onImgDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95354);
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.Qqn)
      {
        paramString = (List)this.Qqn.remove(paramString);
        if (paramString == null)
        {
          AppMethodBeat.o(95354);
          return;
        }
        i = 0;
        if (i < paramString.size())
        {
          f localf = (f)paramString.get(i);
          if (localf == null) {
            break label164;
          }
          if (paramBoolean) {
            localf.hfw();
          } else {
            localf.gZN();
          }
        }
      }
      AppMethodBeat.o(95354);
      return;
      label164:
      i += 1;
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onRspCallbackCommon(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(310270);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(310270);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSearchContact(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(309721);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(309721);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSendAppointmentReq(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(310466);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
    if (locale != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("status", paramString);
        localJSONObject.put("opType", paramInt3);
        locale.h(paramInt1, paramInt2, localJSONObject.toString());
        AppMethodBeat.o(310466);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "onSendAppointmentReq, exp=" + paramString.toString());
      }
    }
    AppMethodBeat.o(310466);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSightDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(310090);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onSightDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(310090);
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.Qqn)
      {
        paramString = (List)this.Qqn.remove(paramString);
        if (paramString == null)
        {
          AppMethodBeat.o(310090);
          return;
        }
        i = 0;
        if (i < paramString.size())
        {
          f localf = (f)paramString.get(i);
          if (localf == null) {
            break label164;
          }
          if (paramBoolean) {
            localf.hfw();
          } else {
            localf.gZN();
          }
        }
      }
      AppMethodBeat.o(310090);
      return;
      label164:
      i += 1;
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onUpdateUxInfo(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95281);
    e locale = (e)this.Lfc.remove(Long.valueOf(paramLong));
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    boolean bool = com.tencent.mm.plugin.downloader.model.f.duv().kT(l);
    AppMethodBeat.o(95313);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    AppMethodBeat.i(95302);
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.hfr();
      }
    }
    AppMethodBeat.o(95302);
  }
  
  public void playTimelineBackAnimation(long paramLong)
  {
    AppMethodBeat.i(95289);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineBackAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    AppMethodBeat.o(95289);
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineBackAnimationMM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95290);
    aaw localaaw = new aaw();
    localaaw.iex.delay = paramLong2;
    localaaw.publish();
    AppMethodBeat.o(95290);
  }
  
  public void playTimelineClickAnimation(long paramLong)
  {
    AppMethodBeat.i(95287);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineClickAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    AppMethodBeat.o(95287);
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineClickAnimationMM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95288);
    aax localaax = new aax();
    localaax.iey.delay = paramLong2;
    localaax.publish();
    AppMethodBeat.o(95288);
  }
  
  public void prefetchH5Url(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(310233);
    try
    {
      REMOTE_CALL("prefetchH5UrlMM", new Object[] { paramString, paramArrayOfString });
      AppMethodBeat.o(310233);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "prefetchH5Url remote call has an exception!");
      AppMethodBeat.o(310233);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void prefetchH5UrlMM(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(310239);
    if ((!TextUtils.isEmpty(paramString)) && (!com.tencent.mm.plugin.sns.ad.j.d.y(paramArrayOfString))) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.mm.plugin.sns.ad.c.a.gZF();
        try
        {
          localObject = ((com.tencent.mm.plugin.sns.ad.c.a)localObject).PNC;
          if (paramString == null) {
            break label96;
          }
          if (com.tencent.mm.plugin.sns.ad.j.d.y(paramArrayOfString))
          {
            break label96;
            ((com.tencent.mm.plugin.sns.ad.c.a.c)localObject).b(paramString);
            AppMethodBeat.o(310239);
            return;
          }
          paramString = ((com.tencent.mm.plugin.sns.ad.c.a.c)localObject).a(new com.tencent.mm.plugin.sns.ad.c.a.c.b(paramString, paramArrayOfString));
          continue;
          paramString = finally;
        }
        finally
        {
          AppMethodBeat.o(310239);
          return;
        }
        AppMethodBeat.o(310239);
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "prefetchH5UrlMM call has an exception!");
      }
      return;
      label96:
      paramString = null;
    }
  }
  
  public void preloadFinderFeeds(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(310300);
    try
    {
      REMOTE_CALL("preloadFinderFeedsMM", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
      AppMethodBeat.o(310300);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "preloadFinderFeeds remote call has an exception!");
      AppMethodBeat.o(310300);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void preloadFinderFeedsMM(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(310308);
    try
    {
      paramString1 = al.hgB().aZK(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(310308);
        return;
      }
      if (paramInt == 16) {}
      for (paramString1 = paramString1.getAtAdInfo();; paramString1 = paramString1.getAdInfo())
      {
        if ((paramString1 != null) && (paramString1.preloadFinderFeed)) {
          com.tencent.mm.plugin.sns.ad.d.o.aWo(paramString2);
        }
        AppMethodBeat.o(310308);
        return;
      }
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "preloadFinderFeeds call has an exception!");
      AppMethodBeat.o(310308);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95301);
    com.tencent.mm.sdk.platformtools.Log.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.aky(paramInt);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    AppMethodBeat.o(95311);
    return l;
  }
  
  public long[] queryVideoMoov(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95358);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", new Object[] { paramString1, paramString2, paramString3 });
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
  
  public void reportOpenAppInfo(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(309917);
    REMOTE_CALL("reportOpenAppInfoMM", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(309917);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportOpenAppInfoMM(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(309911);
    a.f.QIF.g(paramInt, paramString1, paramString2, "");
    AppMethodBeat.o(309911);
  }
  
  public void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95361);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 32);
    REMOTE_CALL("requestVideoDataMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95361);
  }
  
  @com.tencent.mm.remoteservice.f
  public void requestVideoDataMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95362);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 33);
    com.tencent.mm.modelvideo.v.bOi();
    com.tencent.mm.modelcdntran.j.v(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(95362);
  }
  
  public boolean resumeTask(String paramString1, a parama, String paramString2, String paramString3, String paramString4, t.a parama1)
  {
    boolean bool = false;
    AppMethodBeat.i(309902);
    paramString2 = REMOTE_CALL("resumeTaskMM", new Object[] { paramString1, paramString2, paramString3, paramString4, parama1 });
    long l;
    if (paramString2 == null) {
      if (bool)
      {
        l = queryIdByAppid(paramString1);
        paramString2 = (ArrayList)this.Qql.get(Long.valueOf(l));
        if (paramString2 == null) {
          break label133;
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
      this.Qql.put(Long.valueOf(l), paramString1);
      AppMethodBeat.o(309902);
      return bool;
      bool = ((Boolean)paramString2).booleanValue();
      break;
      label133:
      paramString1 = new ArrayList();
      paramString1.add(parama);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean resumeTaskMM(String paramString1, String paramString2, String paramString3, String paramString4, t.a parama)
  {
    AppMethodBeat.i(309900);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b localb = this.Qqm;
    com.tencent.mm.plugin.downloader.model.f.duv();
    com.tencent.mm.plugin.downloader.model.c.a(locala.QIC);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      if (localb != null) {
        locala.Qqm = localb;
      }
      locala.QIB.put(paramString1, new a.e(paramString2, paramString3, paramString4, parama.rzx, parama.enterScene, parama.adExtInfo, parama.pId, parama.Qms));
      boolean bool = com.tencent.mm.plugin.downloader.model.f.duv().kU(localFileDownloadTaskInfo.id);
      AppMethodBeat.o(309900);
      return bool;
    }
    AppMethodBeat.o(309900);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public void resumed(long paramLong)
  {
    AppMethodBeat.i(95306);
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.hfv();
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
    ai.b(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4);
    AppMethodBeat.o(95339);
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean selectBrandAdd(String paramString)
  {
    AppMethodBeat.i(310213);
    bx localbx = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    if ((localbx == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(310213);
      return false;
    }
    paramString = localbx.JE(paramString);
    if ((paramString != null) && (com.tencent.mm.contact.d.rs(paramString.field_type)))
    {
      AppMethodBeat.o(310213);
      return true;
    }
    AppMethodBeat.o(310213);
    return false;
  }
  
  public void sendAppointmentReq(String paramString, long paramLong, int paramInt, e parame)
  {
    AppMethodBeat.i(310447);
    long l = System.currentTimeMillis();
    this.Lfc.put(Long.valueOf(l), parame);
    REMOTE_CALL("sendAppointmentReqMM", new Object[] { Long.valueOf(l), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(310447);
  }
  
  @com.tencent.mm.remoteservice.f
  public void sendAppointmentReqMM(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(310455);
    paramString = new com.tencent.mm.plugin.sns.ad.h.b(paramString, paramLong2, paramInt);
    this.Qqk.put(paramString, Long.valueOf(paramLong1));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(5159, this.maV);
    AppMethodBeat.o(310455);
  }
  
  public void setAdValue(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(310487);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(310487);
      return;
    }
    try
    {
      REMOTE_CALL("setAdValueMM", new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(310487);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "setAdValue exp=" + paramString1.toString());
      AppMethodBeat.o(310487);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public String setAdValueMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(310493);
    try
    {
      com.tencent.mm.plugin.sns.ad.a.setAdValue(paramString1, paramString2, paramString3);
      AppMethodBeat.o(310493);
      return "";
    }
    finally
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "setAdValueMM exp=" + paramString1.toString());
      }
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    AppMethodBeat.i(95300);
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.start();
      }
    }
    AppMethodBeat.o(95300);
  }
  
  public long startDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, a parama, String paramString7, String paramString8, String paramString9, boolean paramBoolean2, t.a parama1)
  {
    AppMethodBeat.i(309887);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "startDownload, appId=" + paramString1 + ", pkg=" + paramString3 + ", aid=" + paramString7 + ", fileName=" + paramString6 + ", isGameApp=" + paramBoolean2 + ", url=" + paramString5 + ", uxinfo=" + paramString9);
    paramString1 = REMOTE_CALL("startDownloadMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, Boolean.valueOf(paramBoolean1), paramString7, paramString8, paramString9, Boolean.valueOf(paramBoolean2), parama1 });
    long l;
    if (paramString1 == null)
    {
      l = -1L;
      paramString2 = (ArrayList)this.Qql.get(Long.valueOf(l));
      if (paramString2 == null) {
        break label259;
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
      this.Qql.put(Long.valueOf(l), paramString1);
      AppMethodBeat.o(309887);
      return l;
      l = ((Long)paramString1).longValue();
      break;
      label259:
      paramString1 = new ArrayList();
      paramString1.add(parama);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long startDownloadMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, String paramString8, String paramString9, boolean paramBoolean2, t.a parama)
  {
    AppMethodBeat.i(309884);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    b localb = new b(paramString1, paramString3, paramBoolean1, 2);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b localb1 = this.Qqm;
    if (!paramBoolean2)
    {
      paramString2 = new g.a();
      paramString2.setAppId(paramString1);
      paramString2.amU(paramString1);
      paramString2.setPackageName(paramString3);
      paramString2.setFileMD5(paramString4);
      paramString2.amR(paramString5);
      paramString2.amT(paramString6);
      paramString2.nA(paramBoolean1);
      paramString2 = paramString2.xoe;
    }
    com.tencent.mm.plugin.downloader_app.a.a locala1;
    for (long l = com.tencent.mm.plugin.downloader.model.f.duv().a(paramString2);; l = ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).a(locala1, new a.3(locala)))
    {
      if (localb1 != null) {
        locala.Qqm = localb1;
      }
      if (paramBoolean1) {
        locala.a(paramString3, localb);
      }
      locala.QIB.put(paramString1, new a.e(paramString7, paramString8, paramString9, parama.rzx, parama.enterScene, parama.adExtInfo, parama.pId, parama.Qms));
      com.tencent.mm.plugin.downloader.model.f.duv();
      com.tencent.mm.plugin.downloader.model.c.a(locala.QIC);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(309884);
      return l;
      locala1 = new com.tencent.mm.plugin.downloader_app.a.a();
      locala1.downloadUrl = paramString5;
      locala1.appId = paramString2;
      locala1.xrS = paramString1;
      locala1.packageName = paramString3;
      locala1.tdo = paramString4;
      locala1.appName = paramString6;
      locala1.hMd = 1;
      locala1.xrU = paramBoolean1;
      locala1.scene = 5101;
    }
  }
  
  public void stopDownloadLandingPageVideo(String paramString)
  {
    AppMethodBeat.i(95356);
    if (this.Qqo.containsKey(paramString))
    {
      this.Qqo.remove(paramString);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "stop download video %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 34);
      MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, false).commit();
    }
    REMOTE_CALL("stopDownloadLandingPageVideoMM", new Object[] { paramString });
    AppMethodBeat.o(95356);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopDownloadLandingPageVideoMM(String paramString)
  {
    AppMethodBeat.i(95357);
    al.hgw().aXU(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.QIF;
    paramString = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      com.tencent.mm.plugin.downloader.model.f.duv().kR(l);
    }
    AppMethodBeat.o(95309);
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    AppMethodBeat.i(95303);
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.hfs();
      }
    }
    this.Qql.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95303);
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    AppMethodBeat.i(95304);
    Iterator localIterator = ((ArrayList)this.Qql.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.hft();
      }
    }
    this.Qql.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95304);
  }
  
  public void updateContact(String paramString)
  {
    AppMethodBeat.i(310218);
    REMOTE_CALL("updateContactMM", new Object[] { paramString });
    AppMethodBeat.o(310218);
  }
  
  @com.tencent.mm.remoteservice.f
  public void updateContactMM(String paramString)
  {
    AppMethodBeat.i(310226);
    bx localbx = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    if ((localbx == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(310226);
      return;
    }
    au localau = localbx.JE(paramString);
    localau.aRK();
    localau.setUsername(paramString);
    com.tencent.threadpool.h.ahAA.bm(new AdLandingPagesProxy.10(this, localau, localbx));
    AppMethodBeat.o(310226);
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
    aKt().edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(95326);
  }
  
  public static abstract interface a
  {
    public abstract void aky(int paramInt);
    
    public abstract void hfr();
    
    public abstract void hfs();
    
    public abstract void hft();
    
    public abstract void hfu();
    
    public abstract void hfv();
    
    public abstract void start();
  }
  
  final class b
    implements a.d
  {
    private int Qmq;
    private String appId;
    private String bJH;
    private boolean xrU;
    
    public b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
    {
      this.bJH = paramString2;
      this.appId = paramString1;
      this.xrU = paramBoolean;
      this.Qmq = paramInt;
    }
    
    public final void aXR(String paramString)
    {
      AppMethodBeat.i(95219);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
      if (this.xrU) {
        a.f.QIF.dg(4, this.appId);
      }
      a.f.QIF.dg(5, this.appId);
      Object localObject2 = a.f.QIF;
      Object localObject1 = this.appId;
      paramString = new a.c(this.Qmq);
      if (((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader.a.d.class)).bzH().amJ((String)localObject1) == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AdDownloadApkMgr", "fileDownloadInfo is null");
        AppMethodBeat.o(95219);
        return;
      }
      localObject2 = (a.e)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a)localObject2).QIB.get(localObject1);
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid = ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(95219);
        return;
      }
      localObject1 = new com.tencent.mm.plugin.sns.data.b(((a.e)localObject2).uxInfo, ((a.e)localObject2).rzx, ((a.e)localObject2).enterScene, ((a.e)localObject2).adExtInfo, ((a.e)localObject2).aid, ((a.e)localObject2).qTb, ((a.e)localObject2).pId, ((a.e)localObject2).Qms);
      ((com.tencent.mm.plugin.sns.data.b)localObject1).Qmq = paramString.Qmq;
      ((com.tencent.mm.plugin.sns.data.b)localObject1).Qmp = ((int)(System.currentTimeMillis() - ((a.e)localObject2).QoS));
      try
      {
        paramString = new c.a();
        paramString.eventId = 4001011;
        paramString.uxInfo = ((com.tencent.mm.plugin.sns.data.b)localObject1).uxInfo;
        paramString.rzx = ((com.tencent.mm.plugin.sns.data.b)localObject1).rzx;
        paramString.enterScene = ((com.tencent.mm.plugin.sns.data.b)localObject1).enterScene;
        paramString.adExtInfo = ((com.tencent.mm.plugin.sns.data.b)localObject1).adExtInfo;
        paramString.PVG = ((com.tencent.mm.plugin.sns.data.b)localObject1).PVG;
        paramString.qTb = ((com.tencent.mm.plugin.sns.data.b)localObject1).qTb;
        paramString.pId = ((com.tencent.mm.plugin.sns.data.b)localObject1).pId;
        paramString.lxk = 4;
        paramString.Qms = ((com.tencent.mm.plugin.sns.data.b)localObject1).Qms;
        paramString.Qmq = ((com.tencent.mm.plugin.sns.data.b)localObject1).Qmq;
        paramString.Qmp = ((com.tencent.mm.plugin.sns.data.b)localObject1).Qmp;
        com.tencent.mm.plugin.sns.ad.j.j.a(paramString.heI());
        AppMethodBeat.o(95219);
        return;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdConversionOnlineReportHelper", paramString.toString());
        AppMethodBeat.o(95219);
      }
    }
    
    public final void aXS(String paramString)
    {
      AppMethodBeat.i(95220);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.bJH))) {
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
    
    public final void EE(String paramString) {}
    
    public final void aXr() {}
    
    public final void w(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(95221);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        al.hgw().b(this);
      }
      AppMethodBeat.o(95221);
    }
    
    public final void x(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(309394);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onSightDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        al.hgw().b(this);
      }
      AppMethodBeat.o(309394);
    }
  }
  
  final class d
    implements h.a
  {
    private String mediaId;
    
    public d(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void a(String paramString, int paramInt, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(95225);
      if (paramString.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 30);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      AppMethodBeat.o(95225);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(309397);
      if (paramString1.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 26);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 });
      }
      AppMethodBeat.o(309397);
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
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
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 28);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      }
      AppMethodBeat.o(95223);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2) {}
  }
  
  public static abstract interface e
  {
    public abstract void h(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void onCallback(Object paramObject);
  }
  
  public static abstract interface f
  {
    public abstract void gZN();
    
    public abstract void hfw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */