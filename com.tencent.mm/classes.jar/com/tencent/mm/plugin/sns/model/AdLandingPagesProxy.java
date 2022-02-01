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
import com.tencent.mm.an.q;
import com.tencent.mm.ce.a.a.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.zc;
import com.tencent.mm.f.a.zd;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.sns.data.c.a;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.3;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.u;
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
  private static AdLandingPagesProxy JTh;
  private com.tencent.mm.remoteservice.d JGV;
  private Map<q, Long> JTi;
  private ConcurrentHashMap<Long, ArrayList<a>> JTj;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b JTk;
  private Map<String, f> JTl;
  private Map<String, h.a> JTm;
  private Map<Long, e> callbacks;
  private com.tencent.mm.an.i jxB;
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    AppMethodBeat.i(95227);
    this.callbacks = new HashMap();
    this.JTi = new HashMap();
    this.jxB = new AdLandingPagesProxy.1(this);
    this.JTj = new ConcurrentHashMap();
    this.JTk = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b()
    {
      public final void failed(long paramAnonymousLong)
      {
        AppMethodBeat.i(263984);
        AdLandingPagesProxy.this.CLIENT_CALL("failed", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(263984);
      }
      
      public final void paused(long paramAnonymousLong)
      {
        AppMethodBeat.i(263978);
        AdLandingPagesProxy.this.CLIENT_CALL("paused", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(263978);
      }
      
      public final void progress(long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(263977);
        com.tencent.mm.sdk.platformtools.Log.v("AdLandingPagesProxy", "progress %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AdLandingPagesProxy.this.CLIENT_CALL("progress", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(263977);
      }
      
      public final void resumed(long paramAnonymousLong)
      {
        AppMethodBeat.i(263985);
        AdLandingPagesProxy.this.CLIENT_CALL("resumed", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(263985);
      }
      
      public final void start(long paramAnonymousLong)
      {
        AppMethodBeat.i(263975);
        AdLandingPagesProxy.this.CLIENT_CALL("start", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(263975);
      }
      
      public final void stopped(long paramAnonymousLong)
      {
        AppMethodBeat.i(263980);
        AdLandingPagesProxy.this.CLIENT_CALL("stopped", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(263980);
      }
      
      public final void succeed(long paramAnonymousLong)
      {
        AppMethodBeat.i(263981);
        AdLandingPagesProxy.this.CLIENT_CALL("succeed", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(263981);
      }
    };
    this.JTl = new HashMap();
    this.JTm = new HashMap();
    this.JGV = paramd;
    AppMethodBeat.o(95227);
  }
  
  private static SharedPreferences aqv()
  {
    AppMethodBeat.i(95329);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0);
    AppMethodBeat.o(95329);
    return localSharedPreferences;
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    AppMethodBeat.i(95228);
    if (JTh == null) {
      JTh = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
    }
    AdLandingPagesProxy localAdLandingPagesProxy = JTh;
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
    m.fSv().R(paramLong, paramString);
    AppMethodBeat.o(95331);
  }
  
  public void addReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, s.a parama)
  {
    AppMethodBeat.i(215848);
    REMOTE_CALL("addReportInfoMM", new Object[] { paramString1, paramString2, paramString3, paramString4, parama });
    AppMethodBeat.o(215848);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addReportInfoMM(String paramString1, String paramString2, String paramString3, String paramString4, s.a parama)
  {
    AppMethodBeat.i(215846);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    if ((paramString1 == null) || (paramString1.length() == 0) || (parama == null))
    {
      AppMethodBeat.o(215846);
      return;
    }
    paramString2 = new a.e(paramString2, paramString3, paramString4, parama.owd, parama.enterScene, parama.adExtInfo, parama.pId, parama.JPL);
    locala.Kku.put(paramString1, paramString2);
    AppMethodBeat.o(215846);
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
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95218);
        if (!com.tencent.mm.kernel.h.aHE().aGM())
        {
          AppMethodBeat.o(95218);
          return;
        }
        Object localObject = aj.fOI().bbk(paramString);
        if (localObject != null)
        {
          localObject = ((SnsInfo)localObject).getAdXml();
          if (localObject != null)
          {
            AdLandingPagesProxy.aZD(((ADXml)localObject).getLeftCanvasInfo());
            AdLandingPagesProxy.aZD(((ADXml)localObject).getRightCanvasInfo());
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
    this.JTl.clear();
    this.callbacks.clear();
    this.JTj.clear();
    AppMethodBeat.o(95350);
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearCallbackMM()
  {
    AppMethodBeat.i(95349);
    this.JTi.clear();
    this.JTk = null;
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1337, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1210, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2874, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2721, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1802, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2605, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2883, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(4353, this.jxB);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aFh(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(95242);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(95226);
    this.JGV.connect(paramRunnable);
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
    int i = ab.QZ(paramString);
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
    aqv().edit().remove(paramString).commit();
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
    this.JTi.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1210, this.jxB);
    AppMethodBeat.o(95275);
  }
  
  public void doAdNativeAntiAbuseScene(String paramString1, String paramString2, int paramInt, String paramString3, e parame)
  {
    AppMethodBeat.i(215819);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdNativeAntiAbuseSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Integer.valueOf(paramInt), paramString3 });
    AppMethodBeat.o(215819);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdNativeAntiAbuseSceneMM(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(215822);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(paramString1, paramString2, paramInt, paramString3);
    this.JTi.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aGY().a(4679, this.jxB);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    AppMethodBeat.o(215822);
  }
  
  public void doAdUpdateQrUrlScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, e parame)
  {
    AppMethodBeat.i(215796);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdUpdateQrUrlSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
    AppMethodBeat.o(215796);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdUpdateQrUrlSceneMM(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(215798);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.k(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    this.JTi.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aGY().a(1022, this.jxB);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    AppMethodBeat.o(215798);
  }
  
  public void doAddBrandScene(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(215886);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAddBrandSceneSceneMM", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(215886);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAddBrandSceneSceneMM(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(215887);
    paramString = b.a(paramString, this.jxB, paramInt);
    if ((paramString instanceof com.tencent.mm.openim.b.b))
    {
      paramString = (com.tencent.mm.openim.b.b)paramString;
      this.JTi.put(paramString, Long.valueOf(paramLong));
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      AppMethodBeat.o(215887);
      return;
    }
    if ((paramString instanceof com.tencent.mm.pluginsdk.model.t))
    {
      paramString = (com.tencent.mm.pluginsdk.model.t)paramString;
      this.JTi.put(paramString, Long.valueOf(paramLong));
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    }
    AppMethodBeat.o(215887);
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
    cou localcou = new cou();
    localcou.Twy = paramInt;
    localcou.TwG = ((int)(System.currentTimeMillis() / 1000L));
    localcou.rVx = 1;
    localcou.Twz = new com.tencent.mm.cd.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localcou);
    paramString = new com.tencent.mm.plugin.sns.ad.f.h(paramString);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1802, this.jxB);
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
    this.JTi.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1337, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2721, this.jxB);
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
    dd localdd = new dd();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      Util.isNullOrNil(paramString1);
    }
    ((ae)com.tencent.mm.kernel.h.ae(ae.class)).a(localdd, paramString6.hashCode(), z.bcZ(), paramString4, paramString5, paramString6, paramString7, paramString2);
    paramString1 = ad.Rp(paramString3);
    localdd.fyI.sessionId = paramString1;
    localdd.fyI.title = paramString4;
    localdd.fyI.desc = paramString5;
    paramString1 = localdd.fyI.fyK;
    if ((paramString1 != null) && (paramString1.syG != null) && (paramString1.syG.size() > 0) && (paramString1.syG.get(0) != null))
    {
      ((anm)paramString1.syG.get(0)).bsW(paramString6);
      ((anm)paramString1.syG.get(0)).bsx(paramString4);
      ((anm)paramString1.syG.get(0)).bsy(paramString5);
      ((anm)paramString1.syG.get(0)).bsV(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.btv(paramString4);
      paramString1.btw(paramString5);
    }
    localdd.fyI.fyP = paramInt2;
    EventCenter.instance.publish(localdd);
    paramInt1 = localdd.fyI.fyO;
    AppMethodBeat.o(95264);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(95266);
    dd localdd = new dd();
    ((ae)com.tencent.mm.kernel.h.ae(ae.class)).a(localdd, paramIntent);
    localdd.fyI.fyP = paramInt;
    EventCenter.instance.publish(localdd);
    paramInt = localdd.fyI.fyO;
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
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doFavOfficialItemSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(95340);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doFavOfficialItemSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95341);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i(paramString);
    this.JTi.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2874, this.jxB);
    AppMethodBeat.o(95341);
  }
  
  public void doGetHbCoverState(String paramString, e parame)
  {
    AppMethodBeat.i(95282);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doGetHbCoverStateMM", new Object[] { Long.valueOf(l), paramString });
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "doGetHbCoverState, hbCoverId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95282);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doGetHbCoverStateMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(95283);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString);
    this.JTi.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2944, this.jxB);
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
    this.JTi.put(paramString1, Long.valueOf(paramLong1));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2605, this.jxB);
    AppMethodBeat.o(95277);
  }
  
  public void doJumpToFinderProfileUI(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(215910);
    REMOTE_CALL("doJumpToFinderProfileUIMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(215910);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doJumpToFinderProfileUIMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(215912);
    com.tencent.mm.plugin.sns.ad.d.l.a(MMApplicationContext.getContext(), paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(215912);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchContactMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(215810);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "doSearchContactMM, userName=".concat(String.valueOf(paramString)));
    paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, 1);
    this.JTi.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aGY().a(106, this.jxB);
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    AppMethodBeat.o(215810);
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
    this.JTi.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1337, this.jxB);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2721, this.jxB);
    AppMethodBeat.o(95272);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(215783);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString1.aFh(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(215783);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doTransimtMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void doUpdateUxInfoScene(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(215816);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doUpdateUxInfoSceneMM", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(215816);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doUpdateUxInfoSceneMM(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(215817);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.l(paramString, paramInt);
    this.JTi.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2883, this.jxB);
    AppMethodBeat.o(215817);
  }
  
  public void downloadLandingPageVideo(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, h.a parama)
  {
    AppMethodBeat.i(215873);
    if (Util.isNullOrNil(new String[] { paramString1, paramString2, paramString3 }))
    {
      if (parama != null) {
        parama.a(paramString1, -1, null);
      }
      AppMethodBeat.o(215873);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(955, 20);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (u.agG(paramString3))
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 21);
        parama.a(paramString1, 0, null);
        AppMethodBeat.o(215873);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(955, 22);
    }
    while (this.JTm.containsKey(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.i("%s is already in downloading", paramString2);
      AppMethodBeat.o(215873);
      return;
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "last download file was deleted");
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 23);
        localSharedPreferences.edit().putBoolean(paramString1, false).commit();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 24);
      }
    }
    if (parama != null) {
      this.JTm.put(paramString1, parama);
    }
    REMOTE_CALL("downloadLandingPageVideoMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(215873);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPageVideoMM(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(215878);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.h.IzE.el(955, 25);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203380);
        final c localc = aj.fOD();
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200477);
            localc.a(AdLandingPagesProxy.8.this.acq, AdLandingPagesProxy.8.this.val$url, AdLandingPagesProxy.8.this.val$path, AdLandingPagesProxy.8.this.JTq, AdLandingPagesProxy.8.this.cuK, AdLandingPagesProxy.8.this.JTr, new AdLandingPagesProxy.d(AdLandingPagesProxy.this, AdLandingPagesProxy.8.this.acq));
            AppMethodBeat.o(200477);
          }
        });
        AppMethodBeat.o(203380);
      }
    });
    AppMethodBeat.o(215878);
  }
  
  public void downloadLandingPagesCDNFile(String paramString1, String paramString2, String paramString3, int paramInt, f paramf)
  {
    AppMethodBeat.i(215867);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      if (paramf != null) {
        paramf.fJV();
      }
      AppMethodBeat.o(215867);
      return;
    }
    if (paramf != null) {
      this.JTl.put(paramString2, paramf);
    }
    REMOTE_CALL("downloadLandingPagesCDNFileMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(215867);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesCDNFileMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(215868);
    if (paramInt == 0)
    {
      downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
      AppMethodBeat.o(215868);
      return;
    }
    if (paramInt == 1) {
      downloadLandingPagesSightMMImpl(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(215868);
  }
  
  public void downloadLandingPagesImageMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(95353);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.o.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    final p localp = new p(paramString3);
    localp.JRn = 3;
    localp.fIY = paramString3.Id;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201765);
        aj.fOD().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        c localc = aj.fOD();
        cvt localcvt = paramString3;
        p localp = localp;
        bp localbp = bp.hzh();
        localbp.time = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localcvt, 8, localp, localbp, paramString1, paramString2);
        AppMethodBeat.o(201765);
      }
    });
    AppMethodBeat.o(95353);
  }
  
  public void downloadLandingPagesSightMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(215869);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "downloadLandingPagesSightMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.o.a(paramString2, 6, paramString3, paramString3, 1, 1, "");
    paramString3.isAd = true;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193803);
        aj.fOD().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        c localc = aj.fOD();
        cvt localcvt = paramString3;
        bp localbp = bp.hzh();
        localbp.time = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localcvt, 4, null, localbp, paramString1, paramString2);
        AppMethodBeat.o(193803);
      }
    });
    AppMethodBeat.o(215869);
  }
  
  public void downloadPagFile(String paramString)
  {
    AppMethodBeat.i(215940);
    REMOTE_CALL("downloadPagFileMM", new Object[] { paramString });
    AppMethodBeat.o(215940);
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean downloadPagFileMM(String paramString)
  {
    AppMethodBeat.i(215941);
    try
    {
      com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.downloadPagFile(paramString);
      AppMethodBeat.o(215941);
      return false;
    }
    catch (Throwable paramString)
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
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fNJ();
      }
    }
    this.JTj.remove(Long.valueOf(paramLong));
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
    hi localhi = new hi();
    localhi.fEb.type = 35;
    EventCenter.instance.publish(localhi);
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
  public void fetchQRCodeInfoMM(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95372);
    com.tencent.e.h.ZvG.be(new AdLandingPagesProxy.9(this, paramInt, paramString, paramLong));
    AppMethodBeat.o(95372);
  }
  
  public void geoLocation(String paramString, e parame)
  {
    AppMethodBeat.i(215882);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "geoLocation is called!!");
      long l = System.currentTimeMillis();
      this.callbacks.put(Long.valueOf(l), parame);
      REMOTE_CALL("geoLocationMM", new Object[] { Long.valueOf(l), paramString });
      AppMethodBeat.o(215882);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "geoLocation catch one exception");
      AppMethodBeat.o(215882);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void geoLocationMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(215884);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "geoLocationMM is called!!");
      com.tencent.mm.plugin.sns.ad.landingpage.helper.b.b localb = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.c.a(this, "onGeoLocation", paramLong);
      if (localb != null) {
        localb.request(paramString);
      }
      AppMethodBeat.o(215884);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "geoLocationMM catch one exception");
      AppMethodBeat.o(215884);
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
    int i = y.aM(paramString1, paramString2, paramString3);
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
    paramString1 = y.aN(paramString1, paramString2, paramString3);
    AppMethodBeat.o(95337);
    return paramString1;
  }
  
  public Bitmap getAvatarByUserName(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215931);
    paramString = REMOTE_CALL("getAvatarByUserNameMM", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if ((paramString instanceof Bitmap))
    {
      paramString = (Bitmap)paramString;
      AppMethodBeat.o(215931);
      return paramString;
    }
    AppMethodBeat.o(215931);
    return null;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bitmap getAvatarByUserNameMM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215935);
    for (;;)
    {
      try
      {
        String str = paramString + "-1.0";
        com.tencent.mm.ce.a.a locala = a.a.UOn;
        if (locala == null) {
          break label221;
        }
        Bitmap localBitmap = a.a.UOn.aNh(str);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "getAvatarByUserNameMM, useCache, name=".concat(String.valueOf(paramString)));
          AppMethodBeat.o(215935);
          return localBitmap;
        }
        j.a locala1 = com.tencent.mm.pluginsdk.ui.a.b.hjf();
        if (locala1 != null)
        {
          localBitmap = locala1.gJ(paramString);
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
              AppMethodBeat.o(215935);
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
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getAvatarByUserNameMM name=" + paramString + ", exp=" + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(215935);
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
    AppMethodBeat.i(215804);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("getBtnPersonalWxUserNameMM", new Object[] { Long.valueOf(l), paramString1, paramString2 });
    AppMethodBeat.o(215804);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getBtnPersonalWxUserNameMM(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215807);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramString1, paramString2);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(4353, new AdLandingPagesProxy.3(this, paramLong));
    AppMethodBeat.o(215807);
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
    com.tencent.mm.kernel.h.aHH();
    paramObject = com.tencent.mm.kernel.h.aHG().aHp().b(paramInt, paramObject);
    AppMethodBeat.o(95231);
    return paramObject;
  }
  
  public void getOpenSdkAppInfo(String paramString, e parame)
  {
    AppMethodBeat.i(215925);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "getOpenSdkAppInfo, appId=".concat(String.valueOf(paramString)));
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("getOpenSdkAppInfoMM", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(215925);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getOpenSdkAppInfoMM(String paramString, long paramLong)
  {
    AppMethodBeat.i(215929);
    com.tencent.e.h.ZvG.be(new AdLandingPagesProxy.2(this, paramString, paramLong));
    AppMethodBeat.o(215929);
  }
  
  public String getPhoneNumber()
  {
    AppMethodBeat.i(215916);
    Object localObject = REMOTE_CALL("getPhoneNumberMM", new Object[0]);
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(215916);
      return localObject;
    }
    AppMethodBeat.o(215916);
    return "";
  }
  
  @com.tencent.mm.remoteservice.f
  public String getPhoneNumberMM()
  {
    AppMethodBeat.i(215918);
    try
    {
      String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
      AppMethodBeat.o(215918);
      return str1;
    }
    catch (Throwable localThrowable)
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
    return this.JGV;
  }
  
  public String getSelfUserName()
  {
    AppMethodBeat.i(215780);
    Object localObject = REMOTE_CALL("getSelfUserNameMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(215780);
      return "";
    }
    localObject = (String)localObject;
    AppMethodBeat.o(215780);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSelfUserNameMM()
  {
    AppMethodBeat.i(215781);
    try
    {
      String str = z.bcZ();
      AppMethodBeat.o(215781);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "getSelfUserNameMM, exp=" + localThrowable.toString());
      AppMethodBeat.o(215781);
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
    paramString = aj.fOI().bbk(paramString);
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
    paramString = aj.fOI().bbk(paramString);
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
    paramString = aj.fOI().bbk(paramString);
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
    paramString = aj.fOI().bbk(paramString);
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
    Object localObject = aj.fOL().QX(paramLong);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.sns.ad.f.k.b(((AdSnsInfo)localObject).getTimeLine());
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
    paramString = aj.fOI().bbk(paramString);
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
    paramString = aj.fOI().bbk(paramString);
    if (paramString != null)
    {
      paramString = paramString.getUxinfo();
      AppMethodBeat.o(95246);
      return paramString;
    }
    AppMethodBeat.o(95246);
    return "";
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    paramString = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(paramString);
    if (paramString.rKZ != 0L)
    {
      int i = (int)(paramString.uih * 100L / paramString.rKZ);
      AppMethodBeat.o(95315);
      return i;
    }
    AppMethodBeat.o(95315);
    return 0;
  }
  
  public void getTwistAdCard(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, e parame)
  {
    AppMethodBeat.i(215899);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("getTwistAdCardMM", new Object[] { Long.valueOf(l), paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    AppMethodBeat.o(215899);
  }
  
  @com.tencent.mm.remoteservice.f
  public void getTwistAdCardMM(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(215902);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f(paramString1, paramString2, paramInt, paramString3, paramString4);
    this.JTi.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(4729, this.jxB);
    AppMethodBeat.o(215902);
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
    com.tencent.mm.kernel.h.aHE();
    String str = com.tencent.mm.kernel.b.aGq();
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
    paramString3 = a.f.Kky;
    paramString4 = MMApplicationContext.getContext();
    b localb = new b(paramString1, paramString2, false, 1);
    if ((paramString4 == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(95319);
      return false;
    }
    paramString1 = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(paramString1);
    if ((paramString1 != null) && (paramString1.status == 3) && (!TextUtils.isEmpty(paramString1.path)))
    {
      paramString3.aU(4, paramString1.id);
      paramString3.a(4001010, paramString1.id, new a.c(1));
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
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
    int i = aj.fOF().b(null, null);
    AppMethodBeat.o(95262);
    return i;
  }
  
  public boolean isBrandAdded(String paramString)
  {
    AppMethodBeat.i(215889);
    paramString = REMOTE_CALL("selectBrandAdd", new Object[] { paramString });
    if ((paramString instanceof Boolean))
    {
      boolean bool = ((Boolean)paramString).booleanValue();
      AppMethodBeat.o(215889);
      return bool;
    }
    AppMethodBeat.o(215889);
    return false;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(95229);
    if (this.JGV == null)
    {
      AppMethodBeat.o(95229);
      return false;
    }
    boolean bool = this.JGV.isConnected();
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    paramString = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(paramString);
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
    AppMethodBeat.i(215906);
    Object localObject = REMOTE_CALL("isFreeSimCardMM", new Object[0]);
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(215906);
      return bool;
    }
    AppMethodBeat.o(215906);
    return false;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isFreeSimCardMM()
  {
    AppMethodBeat.i(215908);
    int i = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.misc.a.a.class)).eSB();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "isFreeSimCard, simType=" + i + ", isFree=" + bool);
      AppMethodBeat.o(215908);
      return bool;
    }
  }
  
  public String isFriend(String paramString)
  {
    AppMethodBeat.i(215937);
    paramString = REMOTE_CALL("isFriendMM", new Object[] { paramString });
    if ((paramString instanceof String))
    {
      paramString = (String)paramString;
      AppMethodBeat.o(215937);
      return paramString;
    }
    AppMethodBeat.o(215937);
    return "";
  }
  
  @com.tencent.mm.remoteservice.f
  public String isFriendMM(String paramString)
  {
    AppMethodBeat.i(215939);
    try
    {
      String str2 = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getUserNameByCommHashName(paramString);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "isFriendMM, hashName=" + paramString + ", userName=" + str2);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString;
      }
      if (!TextUtils.isEmpty(str1))
      {
        com.tencent.mm.kernel.h.aHH();
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
        if (paramString != null)
        {
          boolean bool = paramString.bwd(str1);
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "userName=" + str1 + ", isFriend=" + bool);
          if (bool)
          {
            AppMethodBeat.o(215939);
            return str1;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "isFriendMM exp=" + android.util.Log.getStackTraceString(paramString));
      AppMethodBeat.o(215939);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    paramString = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bN(MMApplicationContext.getContext(), paramString);
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
    paramString = aj.fOI().bbk(paramString);
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
    boolean bool = s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(95364);
    return bool;
  }
  
  public void launchBackApp(String paramString)
  {
    AppMethodBeat.i(215920);
    REMOTE_CALL("launchBackAppMM", new Object[] { paramString });
    AppMethodBeat.o(215920);
  }
  
  @com.tencent.mm.remoteservice.f
  public void launchBackAppMM(String paramString)
  {
    AppMethodBeat.i(215922);
    com.tencent.mm.pluginsdk.ui.tools.o.d("nativeOpenAdCanvas", "", paramString, 0, "");
    AppMethodBeat.o(215922);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdChannelEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95273);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
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
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(2538, this.jxB);
    AppMethodBeat.o(95286);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdNativeAntiAbuse(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(215823);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(215823);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdUpdateQrUrlEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(215800);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(215800);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAddBrandSceneEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(215888);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(215888);
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
    if (this.JTm.containsKey(paramString)) {
      ((h.a)this.JTm.get(paramString)).onDataAvailable(paramString, paramLong1, paramLong2);
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
    if (this.JTm.containsKey(paramString)) {
      ((h.a)this.JTm.remove(paramString)).a(paramString, paramInt, null);
    }
    AppMethodBeat.o(95368);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(215880);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.JTm.containsKey(paramString1)) {
      ((h.a)this.JTm.get(paramString1)).a(paramString1, paramLong1, paramLong2, paramString2);
    }
    AppMethodBeat.o(215880);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoProgress(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95367);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "cdn video progress %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.JTm.containsKey(paramString)) {
      ((h.a)this.JTm.get(paramString)).h(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95367);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AppMethodBeat.i(95270);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((locale != null) && (!Util.isNullOrNil(paramString))) {
      locale.aH(paramString);
    }
    AppMethodBeat.o(95270);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFavOfficialItemEnd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95342);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      if (locale != null) {
        locale.i(paramInt1, paramInt2, null);
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
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95373);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGeoLocation(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(215885);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.d("AdLandingPagesProxy", "onGeoLocation is called!!");
      e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
      if (locale != null) {
        locale.aH(paramObject);
      }
      AppMethodBeat.o(215885);
      return;
    }
    catch (Throwable paramObject)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "onGeoLocation catch one exception");
      AppMethodBeat.o(215885);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetBtnPersonalWxUserName(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215812);
    e locale = (e)this.callbacks.get(Long.valueOf(paramLong));
    if (locale != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("username", paramString1);
        localJSONObject.put("aliasname", paramString2);
        locale.aH(localJSONObject.toString());
        AppMethodBeat.o(215812);
        return;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "onGetBtnPersonalWxUserName, exp=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(215812);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetHbCoverStateScene(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95284);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(95284);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetOpenSdkAppInfo(String paramString, long paramLong)
  {
    AppMethodBeat.i(215927);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onGetOpenSdkAppInfo");
      locale.aH(paramString);
    }
    AppMethodBeat.o(215927);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onGetSmartPhoneScene(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95278);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
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
    paramString = (f)this.JTl.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.fNL();
        AppMethodBeat.o(95354);
        return;
      }
      paramString.fJV();
    }
    AppMethodBeat.o(95354);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onRspCallbackCommon(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(215904);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(215904);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSearchContact(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(215814);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(215814);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSightDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215871);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onSightDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(215871);
      return;
    }
    paramString = (f)this.JTl.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.fNL();
        AppMethodBeat.o(215871);
        return;
      }
      paramString.fJV();
    }
    AppMethodBeat.o(215871);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onUpdateUxInfo(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(95281);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.i(paramInt1, paramInt2, paramObject);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    boolean bool = com.tencent.mm.plugin.downloader.model.f.cPZ().Iy(l);
    AppMethodBeat.o(95313);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    AppMethodBeat.i(95302);
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fNG();
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
    zc localzc = new zc();
    localzc.fYv.delay = paramLong2;
    EventCenter.instance.publish(localzc);
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
    zd localzd = new zd();
    localzd.fYw.delay = paramLong2;
    EventCenter.instance.publish(localzd);
    AppMethodBeat.o(95288);
  }
  
  public void prefetchH5Url(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(215894);
    try
    {
      REMOTE_CALL("prefetchH5UrlMM", new Object[] { paramString, paramArrayOfString });
      AppMethodBeat.o(215894);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPagesProxy", "prefetchH5Url remote call has an exception!");
      AppMethodBeat.o(215894);
    }
  }
  
  /* Error */
  @com.tencent.mm.remoteservice.f
  public void prefetchH5UrlMM(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc_w 1736
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1327	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +79 -> 89
    //   13: aload_2
    //   14: invokestatic 1742	com/tencent/mm/plugin/sns/ad/i/d:w	([Ljava/lang/Object;)Z
    //   17: ifne +72 -> 89
    //   20: invokestatic 1748	com/tencent/mm/plugin/sns/ad/c/a:fJL	()Lcom/tencent/mm/plugin/sns/ad/c/a;
    //   23: astore_3
    //   24: aload_3
    //   25: getfield 1752	com/tencent/mm/plugin/sns/ad/c/a:Jze	Lcom/tencent/mm/plugin/sns/ad/c/a/c;
    //   28: astore_3
    //   29: aload_1
    //   30: ifnull +66 -> 96
    //   33: aload_2
    //   34: invokestatic 1742	com/tencent/mm/plugin/sns/ad/i/d:w	([Ljava/lang/Object;)Z
    //   37: ifeq +18 -> 55
    //   40: goto +56 -> 96
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual 1757	com/tencent/mm/plugin/sns/ad/c/a/c:b	(Lcom/tencent/mm/plugin/sns/ad/c/a/c$b;)V
    //   48: ldc_w 1736
    //   51: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: aload_3
    //   56: new 1759	com/tencent/mm/plugin/sns/ad/c/a/c$b
    //   59: dup
    //   60: aload_1
    //   61: aload_2
    //   62: invokespecial 1761	com/tencent/mm/plugin/sns/ad/c/a/c$b:<init>	(Ljava/lang/String;[Ljava/lang/String;)V
    //   65: invokevirtual 1764	com/tencent/mm/plugin/sns/ad/c/a/c:a	(Lcom/tencent/mm/plugin/sns/ad/c/a/c$b;)Lcom/tencent/mm/plugin/sns/ad/c/a/c$b;
    //   68: astore_1
    //   69: goto -26 -> 43
    //   72: astore_1
    //   73: ldc_w 1736
    //   76: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: astore_1
    //   81: ldc 124
    //   83: ldc_w 1766
    //   86: invokestatic 667	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc_w 1736
    //   92: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    com.tencent.mm.sdk.platformtools.Log.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.afJ(paramInt);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
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
    AppMethodBeat.i(215843);
    REMOTE_CALL("reportOpenAppInfoMM", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(215843);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportOpenAppInfoMM(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215841);
    a.f.Kky.g(paramInt, paramString1, paramString2, "");
    AppMethodBeat.o(215841);
  }
  
  public void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95361);
    com.tencent.mm.plugin.report.service.h.IzE.el(955, 32);
    REMOTE_CALL("requestVideoDataMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95361);
  }
  
  @com.tencent.mm.remoteservice.f
  public void requestVideoDataMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95362);
    com.tencent.mm.plugin.report.service.h.IzE.el(955, 33);
    s.bqC();
    com.tencent.mm.aq.e.s(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(95362);
  }
  
  public boolean resumeTask(String paramString1, a parama, String paramString2, String paramString3, String paramString4, s.a parama1)
  {
    boolean bool = false;
    AppMethodBeat.i(215839);
    paramString2 = REMOTE_CALL("resumeTaskMM", new Object[] { paramString1, paramString2, paramString3, paramString4, parama1 });
    long l;
    if (paramString2 == null) {
      if (bool)
      {
        l = queryIdByAppid(paramString1);
        paramString2 = (ArrayList)this.JTj.get(Long.valueOf(l));
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
      this.JTj.put(Long.valueOf(l), paramString1);
      AppMethodBeat.o(215839);
      return bool;
      bool = ((Boolean)paramString2).booleanValue();
      break;
      label133:
      paramString1 = new ArrayList();
      paramString1.add(parama);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean resumeTaskMM(String paramString1, String paramString2, String paramString3, String paramString4, s.a parama)
  {
    AppMethodBeat.i(215838);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b localb = this.JTk;
    com.tencent.mm.plugin.downloader.model.f.cPZ();
    com.tencent.mm.plugin.downloader.model.c.a(locala.Kkv);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      if (localb != null) {
        locala.JTk = localb;
      }
      locala.Kku.put(paramString1, new a.e(paramString2, paramString3, paramString4, parama.owd, parama.enterScene, parama.adExtInfo, parama.pId, parama.JPL));
      boolean bool = com.tencent.mm.plugin.downloader.model.f.cPZ().Iz(localFileDownloadTaskInfo.id);
      AppMethodBeat.o(215838);
      return bool;
    }
    AppMethodBeat.o(215838);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public void resumed(long paramLong)
  {
    AppMethodBeat.i(95306);
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fNK();
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
    AppMethodBeat.i(215890);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
    if ((localbv == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(215890);
      return false;
    }
    paramString = localbv.RG(paramString);
    if ((paramString != null) && (com.tencent.mm.contact.d.rk(paramString.field_type)))
    {
      AppMethodBeat.o(215890);
      return true;
    }
    AppMethodBeat.o(215890);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    AppMethodBeat.i(95300);
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.start();
      }
    }
    AppMethodBeat.o(95300);
  }
  
  public long startDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, a parama, String paramString7, String paramString8, String paramString9, boolean paramBoolean2, s.a parama1)
  {
    AppMethodBeat.i(215834);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "startDownload, appId=" + paramString1 + ", pkg=" + paramString3 + ", aid=" + paramString7 + ", fileName=" + paramString6 + ", isGameApp=" + paramBoolean2 + ", url=" + paramString5 + ", uxinfo=" + paramString9);
    paramString1 = REMOTE_CALL("startDownloadMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, Boolean.valueOf(paramBoolean1), paramString7, paramString8, paramString9, Boolean.valueOf(paramBoolean2), parama1 });
    long l;
    if (paramString1 == null)
    {
      l = -1L;
      paramString2 = (ArrayList)this.JTj.get(Long.valueOf(l));
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
      this.JTj.put(Long.valueOf(l), paramString1);
      AppMethodBeat.o(215834);
      return l;
      l = ((Long)paramString1).longValue();
      break;
      label259:
      paramString1 = new ArrayList();
      paramString1.add(parama);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long startDownloadMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, String paramString8, String paramString9, boolean paramBoolean2, s.a parama)
  {
    AppMethodBeat.i(215832);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    b localb = new b(paramString1, paramString3, paramBoolean1, 2);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b localb1 = this.JTk;
    if (!paramBoolean2)
    {
      paramString2 = new g.a();
      paramString2.setAppId(paramString1);
      paramString2.atf(paramString1);
      paramString2.setPackageName(paramString3);
      paramString2.setFileMD5(paramString4);
      paramString2.atc(paramString5);
      paramString2.ate(paramString6);
      paramString2.me(paramBoolean1);
      paramString2 = paramString2.uhY;
    }
    com.tencent.mm.plugin.downloader_app.a.a locala1;
    for (long l = com.tencent.mm.plugin.downloader.model.f.cPZ().a(paramString2);; l = ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(locala1, new a.3(locala)))
    {
      if (localb1 != null) {
        locala.JTk = localb1;
      }
      if (paramBoolean1) {
        locala.a(paramString3, localb);
      }
      locala.Kku.put(paramString1, new a.e(paramString7, paramString8, paramString9, parama.owd, parama.enterScene, parama.adExtInfo, parama.pId, parama.JPL));
      com.tencent.mm.plugin.downloader.model.f.cPZ();
      com.tencent.mm.plugin.downloader.model.c.a(locala.Kkv);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(215832);
      return l;
      locala1 = new com.tencent.mm.plugin.downloader_app.a.a();
      locala1.downloadUrl = paramString5;
      locala1.appId = paramString2;
      locala1.ulG = paramString1;
      locala1.packageName = paramString3;
      locala1.pYB = paramString4;
      locala1.appName = paramString6;
      locala1.fGH = 1;
      locala1.ulI = paramBoolean1;
      locala1.scene = 5101;
    }
  }
  
  public void stopDownloadLandingPageVideo(String paramString)
  {
    AppMethodBeat.i(95356);
    if (this.JTm.containsKey(paramString))
    {
      this.JTm.remove(paramString);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "stop download video %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.IzE.el(955, 34);
      MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, false).commit();
    }
    REMOTE_CALL("stopDownloadLandingPageVideoMM", new Object[] { paramString });
    AppMethodBeat.o(95356);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopDownloadLandingPageVideoMM(String paramString)
  {
    AppMethodBeat.i(95357);
    aj.fOD().aZH(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.f.Kky;
    paramString = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      com.tencent.mm.plugin.downloader.model.f.cPZ().Iw(l);
    }
    AppMethodBeat.o(95309);
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    AppMethodBeat.i(95303);
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fNH();
      }
    }
    this.JTj.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95303);
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    AppMethodBeat.i(95304);
    Iterator localIterator = ((ArrayList)this.JTj.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fNI();
      }
    }
    this.JTj.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95304);
  }
  
  public void updateContact(String paramString)
  {
    AppMethodBeat.i(215891);
    REMOTE_CALL("updateContactMM", new Object[] { paramString });
    AppMethodBeat.o(215891);
  }
  
  @com.tencent.mm.remoteservice.f
  public void updateContactMM(String paramString)
  {
    AppMethodBeat.i(215893);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
    if ((localbv == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(215893);
      return;
    }
    as localas = localbv.RG(paramString);
    localas.axk();
    localas.setUsername(paramString);
    com.tencent.e.h.ZvG.be(new AdLandingPagesProxy.10(this, localas, localbv));
    AppMethodBeat.o(215893);
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
    aqv().edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(95326);
  }
  
  public static abstract interface a
  {
    public abstract void afJ(int paramInt);
    
    public abstract void fNG();
    
    public abstract void fNH();
    
    public abstract void fNI();
    
    public abstract void fNJ();
    
    public abstract void fNK();
    
    public abstract void start();
  }
  
  final class b
    implements a.d
  {
    private int JPJ;
    private String abY;
    private String appId;
    private boolean ulI;
    
    public b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
    {
      this.abY = paramString2;
      this.appId = paramString1;
      this.ulI = paramBoolean;
      this.JPJ = paramInt;
    }
    
    public final void aZE(String paramString)
    {
      AppMethodBeat.i(95219);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
      if (this.ulI) {
        a.f.Kky.cu(4, this.appId);
      }
      a.f.Kky.cu(5, this.appId);
      Object localObject2 = a.f.Kky;
      Object localObject1 = this.appId;
      paramString = new a.c(this.JPJ);
      if (((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader.a.d.class)).bbS().asU((String)localObject1) == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AdDownloadApkMgr", "fileDownloadInfo is null");
        AppMethodBeat.o(95219);
        return;
      }
      localObject2 = (a.e)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a)localObject2).Kku.get(localObject1);
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid = ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(95219);
        return;
      }
      localObject1 = new com.tencent.mm.plugin.sns.data.b(((a.e)localObject2).uxInfo, ((a.e)localObject2).owd, ((a.e)localObject2).enterScene, ((a.e)localObject2).adExtInfo, ((a.e)localObject2).aid, ((a.e)localObject2).nTp, ((a.e)localObject2).pId, ((a.e)localObject2).JPL);
      ((com.tencent.mm.plugin.sns.data.b)localObject1).JPJ = paramString.JPJ;
      ((com.tencent.mm.plugin.sns.data.b)localObject1).JPI = ((int)(System.currentTimeMillis() - ((a.e)localObject2).JSg));
      try
      {
        paramString = new c.a();
        paramString.eventId = 4001011;
        paramString.uxInfo = ((com.tencent.mm.plugin.sns.data.b)localObject1).uxInfo;
        paramString.owd = ((com.tencent.mm.plugin.sns.data.b)localObject1).owd;
        paramString.enterScene = ((com.tencent.mm.plugin.sns.data.b)localObject1).enterScene;
        paramString.adExtInfo = ((com.tencent.mm.plugin.sns.data.b)localObject1).adExtInfo;
        paramString.JEE = ((com.tencent.mm.plugin.sns.data.b)localObject1).JEE;
        paramString.nTp = ((com.tencent.mm.plugin.sns.data.b)localObject1).nTp;
        paramString.pId = ((com.tencent.mm.plugin.sns.data.b)localObject1).pId;
        paramString.iVf = 4;
        paramString.JPL = ((com.tencent.mm.plugin.sns.data.b)localObject1).JPL;
        paramString.JPJ = ((com.tencent.mm.plugin.sns.data.b)localObject1).JPJ;
        paramString.JPI = ((com.tencent.mm.plugin.sns.data.b)localObject1).JPI;
        com.tencent.mm.plugin.sns.ad.i.j.a(paramString.fNh());
        AppMethodBeat.o(95219);
        return;
      }
      catch (Throwable paramString)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdConversionOnlineReportHelper", paramString.toString());
        AppMethodBeat.o(95219);
      }
    }
    
    public final void aZF(String paramString)
    {
      AppMethodBeat.i(95220);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.abY))) {
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
    
    public final void aYK(String paramString) {}
    
    public final void cq(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(266097);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onSightDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        aj.fOD().b(this);
      }
      AppMethodBeat.o(266097);
    }
    
    public final void cr(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(95221);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPagesProxy", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        aj.fOD().b(this);
      }
      AppMethodBeat.o(95221);
    }
    
    public final void fLL() {}
  }
  
  final class d
    implements h.a
  {
    private String mediaId;
    
    public d(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void Kj(String paramString) {}
    
    public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(95225);
      if (paramString.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 30);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      AppMethodBeat.o(95225);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(195146);
      if (paramString1.equals(this.mediaId))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 26);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 });
      }
      AppMethodBeat.o(195146);
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
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 28);
        AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      }
      AppMethodBeat.o(95223);
    }
  }
  
  public static abstract interface e
  {
    public abstract void aH(Object paramObject);
    
    public abstract void i(int paramInt1, int paramInt2, Object paramObject);
  }
  
  public static abstract interface f
  {
    public abstract void fJV();
    
    public abstract void fNL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */