package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.3;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bc;
import com.tencent.mm.vending.g.d.b;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdLandingPagesProxy
  extends com.tencent.mm.remoteservice.a
{
  private static AdLandingPagesProxy wCU;
  public static f wCX;
  private Map<Long, e> callbacks;
  private com.tencent.mm.al.g gWw;
  private Map<n, Long> wCV;
  private com.tencent.mm.remoteservice.d wCW;
  private ConcurrentHashMap<Long, ArrayList<a>> wCY;
  private a.b wCZ;
  private Map<String, g> wDa;
  private Map<String, h.a> wDb;
  
  static
  {
    AppMethodBeat.i(95375);
    wCX = new f();
    AppMethodBeat.o(95375);
  }
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    AppMethodBeat.i(95227);
    this.callbacks = new HashMap();
    this.wCV = new HashMap();
    this.gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(95209);
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        long l;
        if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f))
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f)paramAnonymousn).jsonString;
            com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "the dynamic string is " + paramAnonymousString + ", sceneType is " + paramAnonymousn.getType());
          }
          for (;;)
          {
            if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousn))
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousn)).longValue();
              AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", new Object[] { Long.valueOf(l), paramAnonymousString });
              com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
            }
            AppMethodBeat.o(95209);
            return;
            com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "the netscene is error ,error type is " + paramAnonymousInt1 + " error msg is " + paramAnonymousString + " sceneType is " + paramAnonymousn.getType());
            paramAnonymousString = "";
          }
        }
        if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a)) {
          if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousn)) {
            break label1281;
          }
        }
        for (;;)
        {
          try
          {
            l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousn)).longValue();
            com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
            paramAnonymousString = (tn)((com.tencent.mm.al.b)paramAnonymousn.getReqResp()).gUT.gUX;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
              break label1304;
            }
            paramAnonymousString = paramAnonymousString.toByteArray();
            AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
            AppMethodBeat.o(95209);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", bt.m(paramAnonymousString));
            AppMethodBeat.o(95209);
            return;
          }
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e))
          {
            if (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousn))
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousn)).longValue();
              AdLandingPagesProxy localAdLandingPagesProxy = AdLandingPagesProxy.this;
              paramAnonymousString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e)paramAnonymousn;
              if (paramAnonymousString.xfx != null) {}
              for (paramAnonymousString = paramAnonymousString.xfx;; paramAnonymousString = "")
              {
                localAdLandingPagesProxy.CLIENT_CALL("onFavOfficialItemEnd", new Object[] { Long.valueOf(l), paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
            }
          }
          else
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.a.b.g))
            {
              com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "real time report done.");
              com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c)) {
              if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousn)) {
                break label1281;
              }
            }
          }
          for (;;)
          {
            try
            {
              l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousn)).longValue();
              com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
              paramAnonymousString = (avj)((com.tencent.mm.al.b)paramAnonymousn.getReqResp()).gUT.gUX;
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                break label1299;
              }
              paramAnonymousString = paramAnonymousString.toByteArray();
              AdLandingPagesProxy.this.CLIENT_CALL("onGetSmartPhoneScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
              AppMethodBeat.o(95209);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + paramAnonymousString.toString());
              AppMethodBeat.o(95209);
              return;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d)) {
              try
              {
                com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + paramAnonymousInt1 + ", errCode=" + paramAnonymousInt2);
                com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
              catch (Exception paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(95209);
                return;
              }
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h)) {
              if (!AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousn)) {
                break label1281;
              }
            }
            for (;;)
            {
              try
              {
                l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousn)).longValue();
                com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
                paramAnonymousString = (dgm)((com.tencent.mm.al.b)paramAnonymousn.getReqResp()).gUT.gUX;
                if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                  break label1293;
                }
                paramAnonymousString = paramAnonymousString.wxc;
                AdLandingPagesProxy.this.CLIENT_CALL("onUpdateUxInfo", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                AppMethodBeat.o(95209);
                return;
              }
              catch (Exception paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(95209);
                return;
              }
              if (((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b)) && (AdLandingPagesProxy.a(AdLandingPagesProxy.this).containsKey(paramAnonymousn)))
              {
                l = ((Long)AdLandingPagesProxy.a(AdLandingPagesProxy.this).remove(paramAnonymousn)).longValue();
                com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", new Object[] { Long.valueOf(l) });
              }
              for (;;)
              {
                try
                {
                  paramAnonymousString = (cfg)((com.tencent.mm.al.b)paramAnonymousn.getReqResp()).gUT.gUX;
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousString == null)) {
                    break label1287;
                  }
                  i = paramAnonymousString.state;
                  AdLandingPagesProxy.this.CLIENT_CALL("onGetHbCoverStateScene", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
                  com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), AdLandingPagesProxy.b(AdLandingPagesProxy.this));
                  AppMethodBeat.o(95209);
                  return;
                }
                catch (Exception paramAnonymousString)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + paramAnonymousString.toString());
                }
                label1281:
                AppMethodBeat.o(95209);
                return;
                label1287:
                int i = -1;
              }
              label1293:
              paramAnonymousString = "";
            }
            label1299:
            paramAnonymousString = null;
          }
          label1304:
          paramAnonymousString = null;
        }
      }
    };
    this.wCY = new ConcurrentHashMap();
    this.wCZ = new AdLandingPagesProxy.2(this);
    this.wDa = new HashMap();
    this.wDb = new HashMap();
    this.wCW = paramd;
    AppMethodBeat.o(95227);
  }
  
  private static SharedPreferences Ts()
  {
    AppMethodBeat.i(95329);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences(aj.getPackageName() + "_comm_preferences", 0);
    AppMethodBeat.o(95329);
    return localSharedPreferences;
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    AppMethodBeat.i(95228);
    if (wCU == null) {
      wCU = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(aj.getContext()));
    }
    AdLandingPagesProxy localAdLandingPagesProxy = wCU;
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.dxr().A(paramLong, paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(176248);
      return;
    }
    paramString2 = new a.d(paramString2, paramString3, paramString4);
    locala.wUT.put(paramString1, paramString2);
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95216);
        if (!com.tencent.mm.kernel.g.afz().aeI())
        {
          AppMethodBeat.o(95216);
          return;
        }
        Object localObject = af.dtu().apJ(paramString);
        if (localObject != null)
        {
          localObject = ((p)localObject).dxs();
          if (localObject != null)
          {
            AdLandingPagesProxy.aod(((com.tencent.mm.plugin.sns.storage.b)localObject).dvr());
            AdLandingPagesProxy.aod(((com.tencent.mm.plugin.sns.storage.b)localObject).dvs());
          }
        }
        AppMethodBeat.o(95216);
      }
    }, 5000L);
    AppMethodBeat.o(95333);
  }
  
  @com.tencent.mm.remoteservice.e
  public void clearCallback()
  {
    AppMethodBeat.i(95350);
    REMOTE_CALL("clearCallbackMM", new Object[0]);
    this.wDa.clear();
    this.callbacks.clear();
    this.wCY.clear();
    AppMethodBeat.o(95350);
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearCallbackMM()
  {
    AppMethodBeat.i(95349);
    this.wCV.clear();
    this.wCZ = null;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1337, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1210, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2874, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2721, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1802, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2605, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2883, this.gWw);
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
    Intent localIntent = new Intent(aj.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("phoneNum", paramString);
    localIntent.putExtra("op", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.adn(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(95242);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(95226);
    this.wCW.connect(paramRunnable);
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
    int i = w.tq(paramString);
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
    Ts().edit().remove(paramString).commit();
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
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(paramString1, paramString2, paramBoolean);
    this.wCV.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1210, this.gWw);
    AppMethodBeat.o(95275);
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
    bkf localbkf = new bkf();
    localbkf.DIc = paramInt;
    localbkf.DIj = ((int)(System.currentTimeMillis() / 1000L));
    localbkf.mAK = 1;
    localbkf.DId = new com.tencent.mm.bx.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localbkf);
    paramString = new com.tencent.mm.plugin.sns.a.b.g(paramString);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1802, this.gWw);
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
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f(paramString1, paramString2, paramString3);
    this.wCV.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1337, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2721, this.gWw);
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
    cs localcs = new cs();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      bt.isNullOrNil(paramString1);
    }
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a(localcs, paramString6.hashCode(), u.aqG(), paramString4, paramString5, paramString6, paramString7, paramString2);
    paramString1 = y.tD(paramString3);
    localcs.deQ.sessionId = paramString1;
    localcs.deQ.title = paramString4;
    localcs.deQ.desc = paramString5;
    paramString1 = localcs.deQ.deS;
    if ((paramString1 != null) && (paramString1.mVb != null) && (paramString1.mVb.size() > 0) && (paramString1.mVb.get(0) != null))
    {
      ((afy)paramString1.mVb.get(0)).aDK(paramString6);
      ((afy)paramString1.mVb.get(0)).aDl(paramString4);
      ((afy)paramString1.mVb.get(0)).aDm(paramString5);
      ((afy)paramString1.mVb.get(0)).aDJ(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.aEj(paramString4);
      paramString1.aEk(paramString5);
    }
    localcs.deQ.deW = paramInt2;
    com.tencent.mm.sdk.b.a.ESL.l(localcs);
    paramInt1 = localcs.deQ.deV;
    AppMethodBeat.o(95264);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(95266);
    cs localcs = new cs();
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a(localcs, paramIntent);
    localcs.deQ.deW = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localcs);
    paramInt = localcs.deQ.deV;
    AppMethodBeat.o(95266);
    return paramInt;
  }
  
  public void doFavOfficialItemScene(String paramString, e parame)
  {
    AppMethodBeat.i(95340);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
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
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e(paramString);
    this.wCV.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2874, this.gWw);
    AppMethodBeat.o(95341);
  }
  
  public void doGetHbCoverState(String paramString, e parame)
  {
    AppMethodBeat.i(95282);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doGetHbCoverStateMM", new Object[] { Long.valueOf(l), paramString });
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "doGetHbCoverState, hbCoverId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95282);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doGetHbCoverStateMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95283);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(paramString);
    this.wCV.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2944, this.gWw);
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
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramLong2, paramInt1, paramString1, paramString2, paramInt2);
    this.wCV.put(paramString1, Long.valueOf(paramLong1));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2605, this.gWw);
    AppMethodBeat.o(95277);
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
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f(paramString);
    this.wCV.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1337, this.gWw);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2721, this.gWw);
    AppMethodBeat.o(95272);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(187317);
    Intent localIntent = new Intent(aj.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("adlandingXml", paramString1);
    localIntent.putExtra("shareTitle", paramString2);
    localIntent.putExtra("shareThumbUrl", paramString3);
    localIntent.putExtra("shareDesc", paramString4);
    localIntent.putExtra("shareUrl", paramString5);
    localIntent.putExtra("statExtStr", paramString6);
    localIntent.putExtra("uxInfo", paramString7);
    localIntent.putExtra("canvasId", paramString8);
    localIntent.putExtra("op", 2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString1.adn(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString1.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(187317);
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
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h(paramString);
    this.wCV.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2883, this.gWw);
    AppMethodBeat.o(95280);
  }
  
  public void downloadLandingPageVideo(String paramString1, String paramString2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95355);
    if (bt.T(new String[] { paramString1, paramString2, paramString3 }))
    {
      if (parama != null) {
        parama.a(paramString1, -1, null);
      }
      AppMethodBeat.o(95355);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(955, 20);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (com.tencent.mm.vfs.i.eK(paramString3))
    {
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 21);
        parama.a(paramString1, 0, null);
        AppMethodBeat.o(95355);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.dB(955, 22);
    }
    while (this.wDb.containsKey(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ad.i("%s is already in downloading", paramString2);
      AppMethodBeat.o(95355);
      return;
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "last download file was deleted");
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 23);
        localSharedPreferences.edit().putBoolean(paramString1, false).commit();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 24);
      }
    }
    if (parama != null) {
      this.wDb.put(paramString1, parama);
    }
    REMOTE_CALL("downloadLandingPageVideoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95355);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPageVideoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95360);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.h.vKh.dB(955, 25);
    af.dtp().a(paramString1, paramString2, paramString3, new d(paramString1));
    AppMethodBeat.o(95360);
  }
  
  public void downloadLandingPagesCDNFile(String paramString1, String paramString2, String paramString3, int paramInt, g paramg)
  {
    AppMethodBeat.i(187318);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      if (paramg != null) {
        paramg.dsA();
      }
      AppMethodBeat.o(187318);
      return;
    }
    if (paramg != null) {
      this.wDa.put(paramString2, paramg);
    }
    REMOTE_CALL("downloadLandingPagesCDNFileMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(187318);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesCDNFileMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(187319);
    if (paramInt == 0)
    {
      downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
      AppMethodBeat.o(187319);
      return;
    }
    if (paramInt == 1) {
      downloadLandingPagesSightMMImpl(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(187319);
  }
  
  public void downloadLandingPagesImageMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(95353);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.g.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    final com.tencent.mm.plugin.sns.data.m localm = new com.tencent.mm.plugin.sns.data.m(paramString3);
    localm.wBd = 3;
    localm.dnB = paramString3.Id;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95218);
        af.dtp().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        b localb = af.dtp();
        bpi localbpi = paramString3;
        com.tencent.mm.plugin.sns.data.m localm = localm;
        bc localbc = bc.eLG();
        localbc.tGD = ((int)(System.currentTimeMillis() / 1000L));
        localb.a(localbpi, 8, localm, localbc, paramString1, paramString2);
        AppMethodBeat.o(95218);
      }
    });
    AppMethodBeat.o(95353);
  }
  
  public void downloadLandingPagesSightMMImpl(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(187320);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "downloadLandingPagesSightMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187313);
        af.dtp().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, this.wAP.Id));
        b localb = af.dtp();
        bpi localbpi = this.wAP;
        bc localbc = bc.eLG();
        localbc.tGD = ((int)(System.currentTimeMillis() / 1000L));
        localb.a(localbpi, 4, null, localbc, paramString1, paramString2);
        AppMethodBeat.o(187313);
      }
    });
    AppMethodBeat.o(187320);
  }
  
  @com.tencent.mm.remoteservice.e
  public void failed(long paramLong)
  {
    AppMethodBeat.i(95305);
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dsy();
      }
    }
    this.wCY.remove(Long.valueOf(paramLong));
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
    gs localgs = new gs();
    localgs.dkc.type = 35;
    com.tencent.mm.sdk.b.a.ESL.l(localgs);
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
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187315);
        new com.tencent.mm.plugin.scanner.b().bC(paramInt, paramString).a(new d.b() {});
        AppMethodBeat.o(187315);
      }
    });
    AppMethodBeat.o(95372);
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
    String str = af.getAccSnsPath();
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
    int i = x.ay(paramString1, paramString2, paramString3);
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
    paramString1 = x.az(paramString1, paramString2, paramString3);
    AppMethodBeat.o(95337);
    return paramString1;
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
    com.tencent.mm.kernel.g.afC();
    paramObject = com.tencent.mm.kernel.g.afB().afk().get(paramInt, paramObject);
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
    paramString = com.tencent.mm.model.c.d.atz().getExpIdByKey(paramString);
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
    paramInt = com.tencent.mm.model.c.d.atz().fK(paramString, paramInt);
    AppMethodBeat.o(95255);
    return paramInt;
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
    paramString = af.dtu().apJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dxu().wSj;
      AppMethodBeat.o(95344);
      return paramString;
    }
    AppMethodBeat.o(95344);
    return "";
  }
  
  public int getSnsAdType(String paramString)
  {
    AppMethodBeat.i(95240);
    int i = ((Integer)REMOTE_CALL("getSnsAdTypeMM", new Object[] { paramString })).intValue();
    AppMethodBeat.o(95240);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getSnsAdTypeMM(String paramString)
  {
    AppMethodBeat.i(95241);
    paramString = af.dtu().apJ(paramString);
    if (paramString != null)
    {
      int i = paramString.dyj();
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
    paramString = af.dtu().apJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dyc();
      AppMethodBeat.o(95239);
      return paramString;
    }
    AppMethodBeat.o(95239);
    return "";
  }
  
  public p getSnsInfo(String paramString)
  {
    localp = null;
    AppMethodBeat.i(95249);
    try
    {
      paramString = (Bundle)REMOTE_CALL("getSnsInfoMM", new Object[] { paramString });
      if (paramString == null)
      {
        AppMethodBeat.o(95249);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("AdLandingPagesProxy", paramString, "", new Object[0]);
        paramString = localp;
      }
    }
    localp = new p();
    if (paramString != null)
    {
      localObject = (ContentValues)paramString.getParcelable("values");
      localp.field_snsId = ((ContentValues)localObject).getAsLong("snsId").longValue();
      localp.field_userName = ((ContentValues)localObject).getAsString("userName");
      localp.field_localFlag = ((ContentValues)localObject).getAsInteger("localFlag").intValue();
      localp.field_createTime = ((ContentValues)localObject).getAsInteger("createTime").intValue();
      localp.field_head = ((ContentValues)localObject).getAsInteger("head").intValue();
      localp.field_localPrivate = ((ContentValues)localObject).getAsInteger("localPrivate").intValue();
      localp.field_type = ((ContentValues)localObject).getAsInteger("type").intValue();
      localp.field_sourceType = ((ContentValues)localObject).getAsInteger("sourceType").intValue();
      localp.field_likeFlag = ((ContentValues)localObject).getAsInteger("likeFlag").intValue();
      localp.field_pravited = ((ContentValues)localObject).getAsInteger("pravited").intValue();
      localp.field_stringSeq = ((ContentValues)localObject).getAsString("stringSeq");
      localp.field_content = ((ContentValues)localObject).getAsByteArray("content");
      localp.field_attrBuf = ((ContentValues)localObject).getAsByteArray("attrBuf");
      localp.field_postBuf = ((ContentValues)localObject).getAsByteArray("postBuf");
      localp.field_subType = ((ContentValues)localObject).getAsInteger("subType").intValue();
      if (((ContentValues)localObject).containsKey("rowid")) {
        localp.systemRowid = ((ContentValues)localObject).getAsLong("rowid").longValue();
      }
      localp.xiB = paramString.getInt("localid");
      paramString = paramString.getBundle("adValues");
      if (paramString != null)
      {
        localObject = new com.tencent.mm.plugin.sns.storage.e();
        ((com.tencent.mm.plugin.sns.storage.e)localObject).ae(paramString);
        localp.xiL = ((com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    AppMethodBeat.o(95249);
    return localp;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bundle getSnsInfoMM(String paramString)
  {
    AppMethodBeat.i(95250);
    paramString = af.dtu().apJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95250);
      return null;
    }
    paramString = paramString.dxF();
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
    Object localObject = af.dtx().sY(paramLong);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.sns.a.b.h.b(((com.tencent.mm.plugin.sns.storage.e)localObject).dxy());
      AppMethodBeat.o(95235);
      return localObject;
    }
    com.tencent.mm.sdk.platformtools.ad.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { Long.valueOf(paramLong) });
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
    paramString = af.dtu().apJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dyd();
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
    paramString = af.dtu().apJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dyg();
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
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "getStreamVideoPlayerConfig, exp=" + localException.toString());
      AppMethodBeat.o(95347);
    }
    return 1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getStreamVideoPlayerConfigMM()
  {
    AppMethodBeat.i(95348);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjp, 0);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    paramString = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString);
    if (paramString.mqq != 0L)
    {
      int i = (int)(paramString.ofL * 100L / paramString.mqq);
      AppMethodBeat.o(95315);
      return i;
    }
    AppMethodBeat.o(95315);
    return 0;
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
    com.tencent.mm.kernel.g.afz();
    String str = com.tencent.mm.kernel.a.aeo();
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
    paramString3 = a.e.wUX;
    paramString4 = aj.getContext();
    AdLandingPagesProxy.b localb = new AdLandingPagesProxy.b(this, paramString1, paramString2, false);
    if ((paramString4 == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(95319);
      return false;
    }
    paramString1 = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString1);
    if ((paramString1 != null) && (paramString1.status == 3) && (!TextUtils.isEmpty(paramString1.path)))
    {
      paramString3.au(4, paramString1.id);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
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
    int i = af.dtr().b(null, null);
    AppMethodBeat.o(95262);
    return i;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(95229);
    if (this.wCW == null)
    {
      AppMethodBeat.o(95229);
      return false;
    }
    boolean bool = this.wCW.isConnected();
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    paramString = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString);
    if ((paramString != null) && (paramString.status == 1))
    {
      AppMethodBeat.o(95294);
      return true;
    }
    AppMethodBeat.o(95294);
    return false;
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    paramString = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bc(aj.getContext(), paramString);
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
    paramString = af.dtu().apJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95248);
      return false;
    }
    boolean bool = paramString.dvv();
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
    f localf = wCX;
    int i;
    if (bt.GC() - localf.lastUpdateTime > 3600L)
    {
      i = 1;
      if (i != 0) {
        localf.wDg = false;
      }
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.kernel.g.afw())
        {
          com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100348");
          if (localc.isValid())
          {
            if (bt.getInt((String)localc.eJy().get("downloadMode"), 0) != 1) {
              continue;
            }
            bool = true;
            localf.wDg = bool;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("AdLandingPagesProxy", localException, "get abtest failed!", new Object[0]);
        continue;
      }
      localf.lastUpdateTime = bt.GC();
      bool = wCX.wDg;
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
    boolean bool = o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString1, paramString2);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2538, this.gWw);
    AppMethodBeat.o(95286);
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(95291);
    com.tencent.mm.sdk.platformtools.ad.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "exception:%s", new Object[] { bt.m(paramString) });
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
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "cdn video data available %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.wDb.containsKey(paramString)) {
      ((h.a)this.wDb.get(paramString)).onDataAvailable(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95366);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoFinish(String paramString, int paramInt)
  {
    AppMethodBeat.i(95368);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "cdn video finish %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, true).commit();
    }
    if (this.wDb.containsKey(paramString)) {
      ((h.a)this.wDb.remove(paramString)).a(paramString, paramInt, null);
    }
    AppMethodBeat.o(95368);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(201275);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.wDb.containsKey(paramString1)) {
      ((h.a)this.wDb.get(paramString1)).a(paramString1, paramLong1, paramLong2, paramString2);
    }
    AppMethodBeat.o(201275);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoProgress(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95367);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "cdn video progress %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.wDb.containsKey(paramString)) {
      ((h.a)this.wDb.get(paramString)).k(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95367);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AppMethodBeat.i(95270);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((locale != null) && (!bt.isNullOrNil(paramString))) {
      locale.bf(paramString);
    }
    AppMethodBeat.o(95270);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFavOfficialItemEnd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95342);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      if (locale != null) {
        locale.h(paramInt1, paramInt2, null);
      }
      AppMethodBeat.o(95342);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[] { paramString });
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
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onImgDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95354);
      return;
    }
    paramString = (g)this.wDa.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.dsB();
        AppMethodBeat.o(95354);
        return;
      }
      paramString.dsA();
    }
    AppMethodBeat.o(95354);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSightDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(187321);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onSightDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(187321);
      return;
    }
    paramString = (g)this.wDa.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.dsB();
        AppMethodBeat.o(187321);
        return;
      }
      paramString.dsA();
    }
    AppMethodBeat.o(187321);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    boolean bool = com.tencent.mm.plugin.downloader.model.f.bQt().oi(l);
    AppMethodBeat.o(95313);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    AppMethodBeat.i(95302);
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dsv();
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
    vm localvm = new vm();
    localvm.dAZ.ed = paramLong2;
    com.tencent.mm.sdk.b.a.ESL.l(localvm);
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
    vn localvn = new vn();
    localvn.dBa.ed = paramLong2;
    com.tencent.mm.sdk.b.a.ESL.l(localvn);
    AppMethodBeat.o(95288);
  }
  
  @com.tencent.mm.remoteservice.e
  public void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95301);
    com.tencent.mm.sdk.platformtools.ad.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.Me(paramInt);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    AppMethodBeat.o(95311);
    return l;
  }
  
  public long[] queryVideoMoov(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95358);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", new Object[] { paramString1, paramString2, paramString3 });
    if (bt.T(new String[] { paramString1, paramString2, paramString3 }))
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
    a.e.wUX.reportDownloadInfo(paramInt, paramString);
    AppMethodBeat.o(95321);
  }
  
  public void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95361);
    com.tencent.mm.plugin.report.service.h.vKh.dB(955, 32);
    REMOTE_CALL("requestVideoDataMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95361);
  }
  
  @com.tencent.mm.remoteservice.f
  public void requestVideoDataMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95362);
    com.tencent.mm.plugin.report.service.h.vKh.dB(955, 33);
    o.aCJ();
    com.tencent.mm.ao.e.q(paramString, paramInt1, paramInt2);
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
        paramString2 = (ArrayList)this.wCY.get(Long.valueOf(l));
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
      this.wCY.put(Long.valueOf(l), paramString1);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    a.b localb = this.wCZ;
    com.tencent.mm.plugin.downloader.model.f.bQt();
    com.tencent.mm.plugin.downloader.model.c.a(locala.wUU);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      if (localb != null) {
        locala.wCZ = localb;
      }
      locala.wUT.put(paramString1, new a.d(paramString2, paramString3, paramString4));
      boolean bool = com.tencent.mm.plugin.downloader.model.f.bQt().oj(localFileDownloadTaskInfo.id);
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
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dsz();
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
    x.c(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4);
    AppMethodBeat.o(95339);
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    AppMethodBeat.i(95300);
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
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
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "startDownload, appId=" + paramString1 + ", pkg=" + paramString3 + ", aid=" + paramString7 + ", fileName=" + paramString6 + ", isGameApp=" + paramBoolean2 + ", url=" + paramString5 + ", uxinfo=" + paramString9);
    paramString1 = REMOTE_CALL("startDownloadMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, Boolean.valueOf(paramBoolean1), paramString7, paramString8, paramString9, Boolean.valueOf(paramBoolean2) });
    long l;
    if (paramString1 == null)
    {
      l = -1L;
      paramString2 = (ArrayList)this.wCY.get(Long.valueOf(l));
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
      this.wCY.put(Long.valueOf(l), paramString1);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    AdLandingPagesProxy.b localb = new AdLandingPagesProxy.b(this, paramString1, paramString3, paramBoolean1);
    a.b localb1 = this.wCZ;
    if (!paramBoolean2)
    {
      paramString2 = new g.a();
      paramString2.setAppId(paramString1);
      paramString2.Sw(paramString1);
      paramString2.eI(paramString3);
      paramString2.Su(paramString4);
      paramString2.Sr(paramString5);
      paramString2.St(paramString6);
      paramString2.jc(paramBoolean1);
      paramString2 = paramString2.ofF;
    }
    com.tencent.mm.plugin.downloader_app.a.a locala1;
    for (long l = com.tencent.mm.plugin.downloader.model.f.bQt().a(paramString2);; l = ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(locala1, new a.3(locala)))
    {
      if (localb1 != null) {
        locala.wCZ = localb1;
      }
      if (paramBoolean1) {
        locala.a(paramString3, localb);
      }
      locala.wUT.put(paramString1, new a.d(paramString7, paramString8, paramString9));
      com.tencent.mm.plugin.downloader.model.f.bQt();
      com.tencent.mm.plugin.downloader.model.c.a(locala.wUU);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(176244);
      return l;
      locala1 = new com.tencent.mm.plugin.downloader_app.a.a();
      locala1.downloadUrl = paramString5;
      locala1.appId = paramString2;
      locala1.ohr = paramString1;
      locala1.packageName = paramString3;
      locala1.kNB = paramString4;
      locala1.appName = paramString6;
      locala1.dlp = 1;
      locala1.oht = paramBoolean1;
      locala1.scene = 5101;
    }
  }
  
  public void stopDownloadLandingPageVideo(String paramString)
  {
    AppMethodBeat.i(95356);
    if (this.wDb.containsKey(paramString))
    {
      this.wDb.remove(paramString);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "stop download video %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.vKh.dB(955, 34);
      aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, false).commit();
    }
    REMOTE_CALL("stopDownloadLandingPageVideoMM", new Object[] { paramString });
    AppMethodBeat.o(95356);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopDownloadLandingPageVideoMM(String paramString)
  {
    AppMethodBeat.i(95357);
    af.dtp().aoi(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.wUX;
    paramString = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      com.tencent.mm.plugin.downloader.model.f.bQt().og(l);
    }
    AppMethodBeat.o(95309);
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    AppMethodBeat.i(95303);
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dsw();
      }
    }
    this.wCY.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95303);
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    AppMethodBeat.i(95304);
    Iterator localIterator = ((ArrayList)this.wCY.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dsx();
      }
    }
    this.wCY.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95304);
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
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100208");
    if (localc.isValid())
    {
      int i = bt.getInt((String)localc.eJy().get("useOnlineVideoPlayer"), 0);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=".concat(String.valueOf(i)));
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
    Ts().edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(95326);
  }
  
  public static abstract interface a
  {
    public abstract void Me(int paramInt);
    
    public abstract void dsv();
    
    public abstract void dsw();
    
    public abstract void dsx();
    
    public abstract void dsy();
    
    public abstract void dsz();
    
    public abstract void start();
  }
  
  final class c
    implements b.b
  {
    private String mediaId;
    
    public c(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void aob(String paramString) {}
    
    public final void by(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(95221);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!bt.T(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        af.dtp().b(this);
      }
      AppMethodBeat.o(95221);
    }
    
    public final void bz(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187316);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!bt.T(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onSightDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        af.dtp().b(this);
      }
      AppMethodBeat.o(187316);
    }
    
    public final void dsp() {}
  }
  
  final class d
    implements h.a
  {
    private String mediaId;
    
    public d(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(95225);
      if (paramString.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 30);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      AppMethodBeat.o(95225);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(201274);
      if (paramString1.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 26);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 });
      }
      AppMethodBeat.o(201274);
    }
    
    public final void k(String paramString, long paramLong1, long paramLong2)
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
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 28);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      }
      AppMethodBeat.o(95223);
    }
  }
  
  public static abstract interface e
  {
    public abstract void bf(Object paramObject);
    
    public abstract void h(int paramInt1, int paramInt2, Object paramObject);
  }
  
  public static final class f
  {
    long lastUpdateTime = 0L;
    boolean wDg = false;
  }
  
  public static abstract interface g
  {
    public abstract void dsA();
    
    public abstract void dsB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */