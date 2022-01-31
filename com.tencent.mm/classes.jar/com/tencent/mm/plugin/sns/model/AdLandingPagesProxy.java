package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdLandingPagesProxy
  extends com.tencent.mm.remoteservice.a
{
  private static AdLandingPagesProxy rcE;
  public static AdLandingPagesProxy.f rcH;
  private Map<Long, AdLandingPagesProxy.e> callbacks;
  private com.tencent.mm.ai.f fur;
  private Map<com.tencent.mm.ai.m, Long> rcF;
  private com.tencent.mm.remoteservice.d rcG;
  private Map<Long, AdLandingPagesProxy.a> rcI;
  private a.b rcJ;
  private Map<String, AdLandingPagesProxy.g> rcK;
  private Map<String, h.a> rcL;
  
  static
  {
    AppMethodBeat.i(36061);
    rcH = new AdLandingPagesProxy.f();
    AppMethodBeat.o(36061);
  }
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    AppMethodBeat.i(35927);
    this.callbacks = new HashMap();
    this.rcF = new HashMap();
    this.fur = new AdLandingPagesProxy.1(this);
    this.rcI = new HashMap();
    this.rcJ = new AdLandingPagesProxy.2(this);
    this.rcK = new HashMap();
    this.rcL = new HashMap();
    this.rcG = paramd;
    AppMethodBeat.o(35927);
  }
  
  private static SharedPreferences Ih()
  {
    AppMethodBeat.i(36018);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences(ah.getPackageName() + "_comm_preferences", 0);
    AppMethodBeat.o(36018);
    return localSharedPreferences;
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    AppMethodBeat.i(35928);
    if (rcE == null) {
      rcE = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(ah.getContext()));
    }
    AdLandingPagesProxy localAdLandingPagesProxy = rcE;
    AppMethodBeat.o(35928);
    return localAdLandingPagesProxy;
  }
  
  @com.tencent.mm.remoteservice.e
  public void addCanvasCache(long paramLong, String paramString)
  {
    AppMethodBeat.i(36019);
    REMOTE_CALL("addCanvasCacheMM", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(36019);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addCanvasCacheMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(36020);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.csa().u(paramLong, paramString);
    AppMethodBeat.o(36020);
  }
  
  public void addReportInfo(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36013);
    REMOTE_CALL("addReportInfoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(36013);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addReportInfoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36012);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(36012);
      return;
    }
    paramString2 = new a.d(paramString2, paramString3);
    locala.rrt.put(paramString1, paramString2);
    AppMethodBeat.o(36012);
  }
  
  @com.tencent.mm.remoteservice.e
  public void asyncCacheXml(String paramString)
  {
    AppMethodBeat.i(36021);
    REMOTE_CALL("asyncCacheXmlMM", new Object[] { paramString });
    AppMethodBeat.o(36021);
  }
  
  @com.tencent.mm.remoteservice.f
  public void asyncCacheXmlMM(String paramString)
  {
    AppMethodBeat.i(36022);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().o(new AdLandingPagesProxy.3(this, paramString), 5000L);
    AppMethodBeat.o(36022);
  }
  
  @com.tencent.mm.remoteservice.e
  public void clearCallback()
  {
    AppMethodBeat.i(36039);
    REMOTE_CALL("clearCallbackMM", new Object[0]);
    this.rcK.clear();
    this.callbacks.clear();
    this.rcI.clear();
    AppMethodBeat.o(36039);
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearCallbackMM()
  {
    AppMethodBeat.i(36038);
    this.rcF.clear();
    this.rcJ = null;
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1337, this.fur);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1210, this.fur);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(2874, this.fur);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(2721, this.fur);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1802, this.fur);
    AppMethodBeat.o(36038);
  }
  
  public void confirmDialPhoneNum(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(35942);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(35942);
      return;
    }
    Intent localIntent = new Intent(ah.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("phoneNum", paramString);
    localIntent.putExtra("op", 4);
    paramActivity.startActivity(localIntent);
    AppMethodBeat.o(35942);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(35926);
    this.rcG.connect(paramRunnable);
    AppMethodBeat.o(35926);
  }
  
  public int contactGetTypeTextFromUserName(String paramString)
  {
    AppMethodBeat.i(35932);
    paramString = REMOTE_CALL("contactGetTypeTextFromUserNameMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(35932);
      return 0;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(35932);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int contactGetTypeTextFromUserNameMM(String paramString)
  {
    AppMethodBeat.i(35933);
    int i = t.oF(paramString);
    AppMethodBeat.o(35933);
    return i;
  }
  
  public void deleteDeferredDeepLink(String paramString)
  {
    AppMethodBeat.i(36016);
    REMOTE_CALL("deleteDeferredDeepLinkMM", new Object[] { paramString });
    AppMethodBeat.o(36016);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteDeferredDeepLinkMM(String paramString)
  {
    AppMethodBeat.i(36017);
    Ih().edit().remove(paramString).commit();
    AppMethodBeat.o(36017);
  }
  
  public void doAdChannelScene(String paramString1, String paramString2, AdLandingPagesProxy.e parame)
  {
    AppMethodBeat.i(35974);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdChannelSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2 });
    AppMethodBeat.o(35974);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdChannelSceneMM(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(35975);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(paramString1, paramString2);
    this.rcF.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1210, this.fur);
    AppMethodBeat.o(35975);
  }
  
  public void doCgiReportCanvasBrowseInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(36034);
    REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(36034);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doCgiReportCanvasBrowseInfoMM(int paramInt, String paramString)
  {
    AppMethodBeat.i(36035);
    ayx localayx = new ayx();
    localayx.xoo = paramInt;
    localayx.xov = ((int)(System.currentTimeMillis() / 1000L));
    localayx.jJu = 1;
    localayx.xop = new com.tencent.mm.bv.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localayx);
    paramString = new com.tencent.mm.plugin.sns.a.b.e(paramString);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1802, this.fur);
    AppMethodBeat.o(36035);
  }
  
  public void doDynamicUpdateScene(String paramString1, String paramString2, String paramString3, AdLandingPagesProxy.e parame)
  {
    AppMethodBeat.i(35968);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(35968);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doDynamicUpdateSceneMM(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35969);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramString1, paramString2, paramString3);
    this.rcF.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1337, this.fur);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(2721, this.fur);
    AppMethodBeat.o(35969);
  }
  
  public int doFav(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(35965);
    paramIntent = REMOTE_CALL("doFavMM", new Object[] { paramIntent, Integer.valueOf(paramInt) });
    if (paramIntent == null)
    {
      AppMethodBeat.o(35965);
      return 0;
    }
    paramInt = ((Integer)paramIntent).intValue();
    AppMethodBeat.o(35965);
    return paramInt;
  }
  
  public int doFavAdlanding(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8)
  {
    AppMethodBeat.i(35963);
    paramString1 = REMOTE_CALL("doFavAdlandingMM", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString4, paramString5, paramString6, Integer.valueOf(paramInt2), paramString7, paramString8 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(35963);
      return 0;
    }
    paramInt1 = ((Integer)paramString1).intValue();
    AppMethodBeat.o(35963);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavAdlandingMM(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8)
  {
    AppMethodBeat.i(35964);
    cm localcm = new cm();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      bo.isNullOrNil(paramString1);
    }
    ((ad)com.tencent.mm.kernel.g.E(ad.class)).a(localcm, paramString6.hashCode(), r.Zn(), paramString4, paramString5, paramString6, paramString7, paramString2);
    paramString1 = com.tencent.mm.model.v.oQ(paramString3);
    localcm.cpR.cpW = paramString1;
    localcm.cpR.title = paramString4;
    localcm.cpR.desc = paramString5;
    paramString1 = localcm.cpR.cpT;
    if ((paramString1 != null) && (paramString1.wVc != null) && (paramString1.wVc.size() > 0) && (paramString1.wVc.get(0) != null))
    {
      ((aca)paramString1.wVc.get(0)).anP(paramString6);
      ((aca)paramString1.wVc.get(0)).anq(paramString4);
      ((aca)paramString1.wVc.get(0)).anr(paramString5);
      ((aca)paramString1.wVc.get(0)).anO(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.aol(paramString4);
      paramString1.aom(paramString5);
    }
    localcm.cpR.cpY = paramInt2;
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    paramInt1 = localcm.cpR.cpX;
    AppMethodBeat.o(35964);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(35966);
    cm localcm = new cm();
    ((ad)com.tencent.mm.kernel.g.E(ad.class)).a(localcm, paramIntent);
    localcm.cpR.cpY = paramInt;
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    paramInt = localcm.cpR.cpX;
    AppMethodBeat.o(35966);
    return paramInt;
  }
  
  public void doFavOfficialItemScene(String paramString, AdLandingPagesProxy.e parame)
  {
    AppMethodBeat.i(36029);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
      AppMethodBeat.o(36029);
      return;
    }
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doFavOfficialItemSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(36029);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doFavOfficialItemSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(36030);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(paramString);
    this.rcF.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(2874, this.fur);
    AppMethodBeat.o(36030);
  }
  
  public void doSearchDynamicUpdateScene(String paramString, AdLandingPagesProxy.e parame)
  {
    AppMethodBeat.i(35971);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doSearchDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString });
    AppMethodBeat.o(35971);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchDynamicUpdateSceneMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(35972);
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramString);
    this.rcF.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1337, this.fur);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(2721, this.fur);
    AppMethodBeat.o(35972);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(35967);
    Intent localIntent = new Intent(ah.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("adlandingXml", paramString1);
    localIntent.putExtra("shareTitle", paramString2);
    localIntent.putExtra("shareThumbUrl", paramString3);
    localIntent.putExtra("shareDesc", paramString4);
    localIntent.putExtra("shareUrl", paramString5);
    localIntent.putExtra("statExtStr", paramString6);
    localIntent.putExtra("op", 2);
    paramActivity.startActivity(localIntent);
    AppMethodBeat.o(35967);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doTransimtMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void downloadLandingPageVideo(String paramString1, String paramString2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(36044);
    if (bo.Q(new String[] { paramString1, paramString2, paramString3 }))
    {
      if (parama != null) {
        parama.a(paramString1, -1, null);
      }
      AppMethodBeat.o(36044);
      return;
    }
    h.qsU.cT(955, 20);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (com.tencent.mm.vfs.e.cN(paramString3))
    {
      ab.i("AdLandingPagesProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        h.qsU.cT(955, 21);
        parama.a(paramString1, 0, null);
        AppMethodBeat.o(36044);
        return;
      }
      h.qsU.cT(955, 22);
    }
    while (this.rcL.containsKey(paramString1))
    {
      ab.i("%s is already in downloading", paramString2);
      AppMethodBeat.o(36044);
      return;
      if (bool)
      {
        ab.i("AdLandingPagesProxy", "last download file was deleted");
        h.qsU.cT(955, 23);
        localSharedPreferences.edit().putBoolean(paramString1, false).commit();
      }
      else
      {
        h.qsU.cT(955, 24);
      }
    }
    if (parama != null) {
      this.rcL.put(paramString1, parama);
    }
    REMOTE_CALL("downloadLandingPageVideoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(36044);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPageVideoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36049);
    ab.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", new Object[] { paramString1, paramString2, paramString3 });
    h.qsU.cT(955, 25);
    ag.cpa().a(paramString1, paramString2, paramString3, new AdLandingPagesProxy.d(this, paramString1));
    AppMethodBeat.o(36049);
  }
  
  public void downloadLandingPagesImage(String paramString1, String paramString2, String paramString3, AdLandingPagesProxy.g paramg)
  {
    AppMethodBeat.i(36040);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3)))
    {
      if (paramg != null) {
        paramg.coe();
      }
      AppMethodBeat.o(36040);
      return;
    }
    if (paramg != null) {
      this.rcK.put(paramString2, paramg);
    }
    REMOTE_CALL("downloadLandingPagesImageMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(36040);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesImageMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36041);
    downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
    AppMethodBeat.o(36041);
  }
  
  public void downloadLandingPagesImageMMImpl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36042);
    ab.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl");
    paramString3 = com.tencent.mm.modelsns.e.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    com.tencent.mm.plugin.sns.data.e locale = new com.tencent.mm.plugin.sns.data.e(paramString3);
    locale.rbj = 3;
    locale.ohe = paramString3.Id;
    ag.cpa().a(new AdLandingPagesProxy.c(this, paramString3.Id));
    b localb = ag.cpa();
    az localaz = az.dxB();
    localaz.oLs = ((int)(System.currentTimeMillis() / 1000L));
    localb.a(paramString3, locale, localaz, paramString1, paramString2);
    AppMethodBeat.o(36042);
  }
  
  @com.tencent.mm.remoteservice.e
  public void failed(long paramLong)
  {
    AppMethodBeat.i(35994);
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.rcI.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.cod();
      this.rcI.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(35994);
  }
  
  public void favEditTag()
  {
    AppMethodBeat.i(35960);
    REMOTE_CALL("favEditTagMM", new Object[0]);
    AppMethodBeat.o(35960);
  }
  
  @com.tencent.mm.remoteservice.f
  public void favEditTagMM()
  {
    AppMethodBeat.i(35961);
    gi localgi = new gi();
    localgi.cuX.type = 35;
    com.tencent.mm.sdk.b.a.ymk.l(localgi);
    AppMethodBeat.o(35961);
  }
  
  public String getAccSnsPath()
  {
    AppMethodBeat.i(35936);
    String str = (String)REMOTE_CALL("getAccSnsPathMM", new Object[0]);
    AppMethodBeat.o(35936);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAccSnsPathMM()
  {
    AppMethodBeat.i(35937);
    String str = ag.getAccSnsPath();
    AppMethodBeat.o(35937);
    return str;
  }
  
  public int getAdVoteIndex(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36023);
    int i = ((Integer)REMOTE_CALL("getAdVoteIndexMM", new Object[] { paramString1, paramString2, paramString3 })).intValue();
    AppMethodBeat.o(36023);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getAdVoteIndexMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36024);
    int i = com.tencent.mm.plugin.sns.storage.v.ao(paramString1, paramString2, paramString3);
    AppMethodBeat.o(36024);
    return i;
  }
  
  public String getAdVoteInfo(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36025);
    paramString1 = (String)REMOTE_CALL("getAdVoteInfoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(36025);
    return paramString1;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAdVoteInfoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36026);
    paramString1 = com.tencent.mm.plugin.sns.storage.v.ap(paramString1, paramString2, paramString3);
    AppMethodBeat.o(36026);
    return paramString1;
  }
  
  public Object getCfg(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(35930);
    Object localObject = REMOTE_CALL("getCfgMM", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (localObject == null)
    {
      AppMethodBeat.o(35930);
      return paramObject;
    }
    AppMethodBeat.o(35930);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getCfgMM(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(35931);
    com.tencent.mm.kernel.g.RM();
    paramObject = com.tencent.mm.kernel.g.RL().Ru().get(paramInt, paramObject);
    AppMethodBeat.o(35931);
    return paramObject;
  }
  
  public String getExpIdByKey(String paramString)
  {
    AppMethodBeat.i(35958);
    paramString = (String)REMOTE_CALL("getExpIdByKeyMM", new Object[] { paramString });
    AppMethodBeat.o(35958);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getExpIdByKeyMM(String paramString)
  {
    AppMethodBeat.i(35957);
    paramString = com.tencent.mm.model.c.c.abV().getExpIdByKey(paramString);
    AppMethodBeat.o(35957);
    return paramString;
  }
  
  public int getExpValueByKey(String paramString, int paramInt)
  {
    AppMethodBeat.i(35956);
    paramString = REMOTE_CALL("getExpValueByKeyMM", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString == null)
    {
      AppMethodBeat.o(35956);
      return -1;
    }
    paramInt = ((Integer)paramString).intValue();
    AppMethodBeat.o(35956);
    return paramInt;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getExpValueByKeyMM(String paramString, int paramInt)
  {
    AppMethodBeat.i(35955);
    paramInt = com.tencent.mm.model.c.c.abV().eB(paramString, paramInt);
    AppMethodBeat.o(35955);
    return paramInt;
  }
  
  public String getSnsAdCanvasExtXml(String paramString)
  {
    AppMethodBeat.i(36032);
    paramString = (String)REMOTE_CALL("getSnsAdCanvasExtXmlMM", new Object[] { paramString });
    AppMethodBeat.o(36032);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsAdCanvasExtXmlMM(String paramString)
  {
    AppMethodBeat.i(36033);
    paramString = ag.cpf().abu(paramString);
    if (paramString != null)
    {
      paramString = paramString.csd().rpw;
      AppMethodBeat.o(36033);
      return paramString;
    }
    AppMethodBeat.o(36033);
    return "";
  }
  
  public int getSnsAdType(String paramString)
  {
    AppMethodBeat.i(35940);
    int i = ((Integer)REMOTE_CALL("getSnsAdTypeMM", new Object[] { paramString })).intValue();
    AppMethodBeat.o(35940);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getSnsAdTypeMM(String paramString)
  {
    AppMethodBeat.i(35941);
    paramString = ag.cpf().abu(paramString);
    if (paramString != null)
    {
      int i = paramString.csS();
      AppMethodBeat.o(35941);
      return i;
    }
    AppMethodBeat.o(35941);
    return 0;
  }
  
  public String getSnsAid(String paramString)
  {
    AppMethodBeat.i(35938);
    paramString = (String)REMOTE_CALL("getSnsAidMM", new Object[] { paramString });
    AppMethodBeat.o(35938);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsAidMM(String paramString)
  {
    AppMethodBeat.i(35939);
    paramString = ag.cpf().abu(paramString);
    if (paramString != null)
    {
      paramString = paramString.csM();
      AppMethodBeat.o(35939);
      return paramString;
    }
    AppMethodBeat.o(35939);
    return "";
  }
  
  public n getSnsInfo(String paramString)
  {
    localn = null;
    AppMethodBeat.i(35949);
    try
    {
      paramString = (Bundle)REMOTE_CALL("getSnsInfoMM", new Object[] { paramString });
      if (paramString == null)
      {
        AppMethodBeat.o(35949);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        ab.printErrStackTrace("AdLandingPagesProxy", paramString, "", new Object[0]);
        paramString = localn;
      }
    }
    localn = new n();
    if (paramString != null)
    {
      localObject = (ContentValues)paramString.getParcelable("values");
      localn.field_snsId = ((ContentValues)localObject).getAsLong("snsId").longValue();
      localn.field_userName = ((ContentValues)localObject).getAsString("userName");
      localn.field_localFlag = ((ContentValues)localObject).getAsInteger("localFlag").intValue();
      localn.field_createTime = ((ContentValues)localObject).getAsInteger("createTime").intValue();
      localn.field_head = ((ContentValues)localObject).getAsInteger("head").intValue();
      localn.field_localPrivate = ((ContentValues)localObject).getAsInteger("localPrivate").intValue();
      localn.field_type = ((ContentValues)localObject).getAsInteger("type").intValue();
      localn.field_sourceType = ((ContentValues)localObject).getAsInteger("sourceType").intValue();
      localn.field_likeFlag = ((ContentValues)localObject).getAsInteger("likeFlag").intValue();
      localn.field_pravited = ((ContentValues)localObject).getAsInteger("pravited").intValue();
      localn.field_stringSeq = ((ContentValues)localObject).getAsString("stringSeq");
      localn.field_content = ((ContentValues)localObject).getAsByteArray("content");
      localn.field_attrBuf = ((ContentValues)localObject).getAsByteArray("attrBuf");
      localn.field_postBuf = ((ContentValues)localObject).getAsByteArray("postBuf");
      localn.field_subType = ((ContentValues)localObject).getAsInteger("subType").intValue();
      if (((ContentValues)localObject).containsKey("rowid")) {
        localn.systemRowid = ((ContentValues)localObject).getAsLong("rowid").longValue();
      }
      localn.rCV = paramString.getInt("localid");
      paramString = paramString.getBundle("adValues");
      if (paramString != null)
      {
        localObject = new com.tencent.mm.plugin.sns.storage.e();
        ((com.tencent.mm.plugin.sns.storage.e)localObject).U(paramString);
        localn.rDf = ((com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    AppMethodBeat.o(35949);
    return localn;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bundle getSnsInfoMM(String paramString)
  {
    AppMethodBeat.i(35950);
    paramString = ag.cpf().abu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(35950);
      return null;
    }
    paramString = paramString.cso();
    AppMethodBeat.o(35950);
    return paramString;
  }
  
  public String getSnsStatExtBySnsId(long paramLong)
  {
    AppMethodBeat.i(35934);
    String str = (String)REMOTE_CALL("getSnsStatExtBySnsIdMM", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35934);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsStatExtBySnsIdMM(long paramLong)
  {
    AppMethodBeat.i(35935);
    Object localObject = ag.cpi().lQ(paramLong);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.sns.a.b.f.a(((com.tencent.mm.plugin.sns.storage.e)localObject).csh());
      AppMethodBeat.o(35935);
      return localObject;
    }
    ab.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35935);
    return "";
  }
  
  public String getSnsTraceid(String paramString)
  {
    AppMethodBeat.i(35943);
    paramString = (String)REMOTE_CALL("getSnsTraceidMM", new Object[] { paramString });
    AppMethodBeat.o(35943);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsTraceidMM(String paramString)
  {
    AppMethodBeat.i(35944);
    paramString = ag.cpf().abu(paramString);
    if (paramString != null)
    {
      paramString = paramString.csN();
      AppMethodBeat.o(35944);
      return paramString;
    }
    AppMethodBeat.o(35944);
    return "";
  }
  
  public String getSnsUxInfo(String paramString)
  {
    AppMethodBeat.i(35945);
    paramString = (String)REMOTE_CALL("getSnsUxInfoMM", new Object[] { paramString });
    AppMethodBeat.o(35945);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsUxInfoMM(String paramString)
  {
    AppMethodBeat.i(35946);
    paramString = ag.cpf().abu(paramString);
    if (paramString != null)
    {
      paramString = paramString.csP();
      AppMethodBeat.o(35946);
      return paramString;
    }
    AppMethodBeat.o(35946);
    return "";
  }
  
  public int getStreamVideoPlayerConfig()
  {
    AppMethodBeat.i(36036);
    int i = ((Integer)REMOTE_CALL("getStreamVideoPlayerConfigMM", new Object[0])).intValue();
    AppMethodBeat.o(36036);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getStreamVideoPlayerConfigMM()
  {
    AppMethodBeat.i(36037);
    int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRW, 0);
    AppMethodBeat.o(36037);
    return i;
  }
  
  public int getTaskProgress(String paramString)
  {
    AppMethodBeat.i(36005);
    paramString = REMOTE_CALL("getTaskProgressMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(36005);
      return -1;
    }
    int i = ((Integer)paramString).intValue();
    AppMethodBeat.o(36005);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int getTaskProgressMM(String paramString)
  {
    AppMethodBeat.i(36004);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    paramString = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    if (paramString.jyU != 0L)
    {
      int i = (int)(paramString.kYX * 100L / paramString.jyU);
      AppMethodBeat.o(36004);
      return i;
    }
    AppMethodBeat.o(36004);
    return 0;
  }
  
  public String getUin()
  {
    AppMethodBeat.i(35951);
    Object localObject = REMOTE_CALL("getUinMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(35951);
      return "";
    }
    localObject = (String)localObject;
    AppMethodBeat.o(35951);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getUinMM()
  {
    AppMethodBeat.i(35952);
    com.tencent.mm.kernel.g.RJ();
    String str = com.tencent.mm.kernel.a.QC();
    AppMethodBeat.o(35952);
    return str;
  }
  
  public boolean installApp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(36009);
    paramContext = REMOTE_CALL("installAppMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (paramContext == null)
    {
      AppMethodBeat.o(36009);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(36009);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean installAppMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(36008);
    paramString3 = a.e.rrx;
    paramString4 = ah.getContext();
    AdLandingPagesProxy.b localb = new AdLandingPagesProxy.b(this, paramString1, paramString2, false);
    if ((paramString4 == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(36008);
      return false;
    }
    paramString1 = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString1);
    if ((paramString1 != null) && (paramString1.status == 3) && (!TextUtils.isEmpty(paramString1.path)))
    {
      Uri localUri = Uri.fromFile(new File(paramString1.path));
      paramString3.ad(4, paramString1.id);
      q.a(paramString4, localUri, null);
      paramString3.a(paramString2, localb);
      AppMethodBeat.o(36008);
      return true;
    }
    AppMethodBeat.o(36008);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(35981);
    paramString = REMOTE_CALL("isApkExistMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(35981);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(35981);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isApkExistMM(String paramString)
  {
    AppMethodBeat.i(35982);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    paramString = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.path)) && (com.tencent.mm.vfs.e.cN(paramString.path)))
    {
      AppMethodBeat.o(35982);
      return true;
    }
    AppMethodBeat.o(35982);
    return false;
  }
  
  public int isAutoAdDownload()
  {
    AppMethodBeat.i(35959);
    Object localObject = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(35959);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(35959);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public int isAutoAdDownloadMM()
  {
    AppMethodBeat.i(35962);
    int i = ag.cpc().b(null, null);
    AppMethodBeat.o(35962);
    return i;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(35929);
    if (this.rcG == null)
    {
      AppMethodBeat.o(35929);
      return false;
    }
    boolean bool = this.rcG.isConnected();
    AppMethodBeat.o(35929);
    return bool;
  }
  
  public boolean isDownloading(String paramString)
  {
    AppMethodBeat.i(35984);
    paramString = REMOTE_CALL("isDownloadingMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(35984);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(35984);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isDownloadingMM(String paramString)
  {
    AppMethodBeat.i(35983);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    paramString = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    if ((paramString != null) && (paramString.status == 1))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    AppMethodBeat.o(35983);
    return false;
  }
  
  public boolean isPaused(String paramString)
  {
    AppMethodBeat.i(35988);
    paramString = REMOTE_CALL("isPausedMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(35988);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(35988);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isPausedMM(String paramString)
  {
    AppMethodBeat.i(35987);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    paramString = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    if ((paramString != null) && (paramString.status == 2))
    {
      AppMethodBeat.o(35987);
      return true;
    }
    AppMethodBeat.o(35987);
    return false;
  }
  
  public boolean isPkgInstalled(String paramString)
  {
    AppMethodBeat.i(35986);
    paramString = REMOTE_CALL("isPkgInstalledMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(35986);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(35986);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isPkgInstalledMM(String paramString)
  {
    AppMethodBeat.i(35985);
    Object localObject = a.e.rrx;
    localObject = ah.getContext();
    if ((localObject == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(35985);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.model.app.p.u((Context)localObject, paramString);
    AppMethodBeat.o(35985);
    return bool;
  }
  
  public boolean isRecExpAd(String paramString)
  {
    AppMethodBeat.i(35947);
    paramString = REMOTE_CALL("isRecExpAdMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(35947);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(35947);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isRecExpAdMM(String paramString)
  {
    AppMethodBeat.i(35948);
    paramString = ag.cpf().abu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(35948);
      return false;
    }
    boolean bool = paramString.cqx();
    AppMethodBeat.o(35948);
    return bool;
  }
  
  public boolean isUseSnsDownloadImage()
  {
    AppMethodBeat.i(36058);
    Object localObject = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(36058);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(36058);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isUseSnsDownloadImageMM()
  {
    AppMethodBeat.i(36059);
    AdLandingPagesProxy.f localf = rcH;
    int i;
    if (bo.yB() - localf.lastUpdateTime > 3600L)
    {
      i = 1;
      if (i != 0) {
        localf.rcO = false;
      }
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.kernel.g.RG())
        {
          com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100348");
          if (localc.isValid())
          {
            if (bo.getInt((String)localc.dvN().get("downloadMode"), 0) != 1) {
              continue;
            }
            bool = true;
            localf.rcO = bool;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        ab.printErrStackTrace("AdLandingPagesProxy", localException, "get abtest failed!", new Object[0]);
        continue;
      }
      localf.lastUpdateTime = bo.yB();
      bool = rcH.rcO;
      AppMethodBeat.o(36059);
      return bool;
      i = 0;
      break;
      bool = false;
    }
  }
  
  public boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36052);
    paramString = REMOTE_CALL("isVideoDataAvailableMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramString == null)
    {
      AppMethodBeat.o(36052);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(36052);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isVideoDataAvailableMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36053);
    boolean bool = com.tencent.mm.modelvideo.o.alF().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    ab.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(36053);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdChannelEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(35973);
    AdLandingPagesProxy.e locale = (AdLandingPagesProxy.e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(35973);
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(35980);
    ab.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        ab.e("AdLandingPagesProxy", "exception:%s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(35980);
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
            AppMethodBeat.o(35980);
            return;
          }
          paramBundle.putSerializable("result_key", (Serializable)paramString);
        }
      }
      AppMethodBeat.o(35980);
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
  public void onCdnVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36055);
    ab.i("AdLandingPagesProxy", "cdn video data available %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.rcL.containsKey(paramString)) {
      ((h.a)this.rcL.get(paramString)).m(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(36055);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoFinish(String paramString, int paramInt)
  {
    AppMethodBeat.i(36057);
    ab.i("AdLandingPagesProxy", "cdn video finish %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, true).commit();
    }
    if (this.rcL.containsKey(paramString)) {
      ((h.a)this.rcL.remove(paramString)).a(paramString, paramInt, null);
    }
    AppMethodBeat.o(36057);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36054);
    ab.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.rcL.containsKey(paramString)) {
      ((h.a)this.rcL.get(paramString)).l(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(36054);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoProgress(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36056);
    ab.i("AdLandingPagesProxy", "cdn video progress %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.rcL.containsKey(paramString)) {
      ((h.a)this.rcL.get(paramString)).n(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(36056);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AppMethodBeat.i(35970);
    AdLandingPagesProxy.e locale = (AdLandingPagesProxy.e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((locale != null) && (!bo.isNullOrNil(paramString))) {
      locale.ad(paramString);
    }
    AppMethodBeat.o(35970);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFavOfficialItemEnd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36031);
    AdLandingPagesProxy.e locale = (AdLandingPagesProxy.e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ab.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      if (locale != null) {
        locale.h(paramInt1, paramInt2, null);
      }
      AppMethodBeat.o(36031);
      return;
      ab.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[] { paramString });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onImgDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36043);
    ab.i("AdLandingPagesProxy", "onImgDownloadCallback");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36043);
      return;
    }
    paramString = (AdLandingPagesProxy.g)this.rcK.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.cof();
        AppMethodBeat.o(36043);
        return;
      }
      paramString.coe();
    }
    AppMethodBeat.o(36043);
  }
  
  public boolean pauseTask(String paramString)
  {
    AppMethodBeat.i(36003);
    paramString = REMOTE_CALL("pauseTaskMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(36003);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(36003);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean pauseTaskMM(String paramString)
  {
    AppMethodBeat.i(36002);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    boolean bool = com.tencent.mm.plugin.downloader.model.f.bjl().iB(l);
    AppMethodBeat.o(36002);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    AppMethodBeat.i(35991);
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.rcI.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.cob();
    }
    AppMethodBeat.o(35991);
  }
  
  public void playTimelineBackAnimation(long paramLong)
  {
    AppMethodBeat.i(35978);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineBackAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    AppMethodBeat.o(35978);
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineBackAnimationMM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(35979);
    to localto = new to();
    localto.cKd.cps = paramLong2;
    com.tencent.mm.sdk.b.a.ymk.l(localto);
    AppMethodBeat.o(35979);
  }
  
  public void playTimelineClickAnimation(long paramLong)
  {
    AppMethodBeat.i(35976);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineClickAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    AppMethodBeat.o(35976);
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineClickAnimationMM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(35977);
    tp localtp = new tp();
    localtp.cKe.cps = paramLong2;
    com.tencent.mm.sdk.b.a.ymk.l(localtp);
    AppMethodBeat.o(35977);
  }
  
  @com.tencent.mm.remoteservice.e
  public void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(35990);
    ab.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.rcI.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.DE(paramInt);
    }
    AppMethodBeat.o(35990);
  }
  
  public long queryIdByAppid(String paramString)
  {
    AppMethodBeat.i(36001);
    paramString = REMOTE_CALL("queryIdByAppidMM", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(36001);
      return -1L;
    }
    long l = ((Long)paramString).longValue();
    AppMethodBeat.o(36001);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public long queryIdByAppidMM(String paramString)
  {
    AppMethodBeat.i(36000);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    AppMethodBeat.o(36000);
    return l;
  }
  
  public long[] queryVideoMoov(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36047);
    ab.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", new Object[] { paramString1, paramString2, paramString3 });
    if (bo.Q(new String[] { paramString1, paramString2, paramString3 }))
    {
      AppMethodBeat.o(36047);
      return null;
    }
    paramString1 = (long[])REMOTE_CALL("queryVideoMoovMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(36047);
    return paramString1;
  }
  
  @com.tencent.mm.remoteservice.f
  public long[] queryVideoMoovMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36048);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.fileType = 100;
    localC2CDownloadRequest.url = paramString3;
    localC2CDownloadRequest.savePath = paramString2;
    paramString1 = new long[2];
    if (CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, paramString1))
    {
      AppMethodBeat.o(36048);
      return paramString1;
    }
    AppMethodBeat.o(36048);
    return null;
  }
  
  public void reportDownloadInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(36011);
    REMOTE_CALL("reportDownloadInfoMM", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(36011);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportDownloadInfoMM(int paramInt, String paramString)
  {
    AppMethodBeat.i(36010);
    a.e.rrx.reportDownloadInfo(paramInt, paramString);
    AppMethodBeat.o(36010);
  }
  
  public void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36050);
    h.qsU.cT(955, 32);
    REMOTE_CALL("requestVideoDataMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(36050);
  }
  
  @com.tencent.mm.remoteservice.f
  public void requestVideoDataMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36051);
    h.qsU.cT(955, 33);
    com.tencent.mm.modelvideo.o.alF();
    com.tencent.mm.al.e.r(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(36051);
  }
  
  public boolean resumeTask(String paramString1, AdLandingPagesProxy.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36007);
    paramString2 = REMOTE_CALL("resumeTaskMM", new Object[] { paramString1, paramString2, paramString3 });
    if (paramString2 == null) {}
    for (boolean bool = false;; bool = ((Boolean)paramString2).booleanValue())
    {
      if (bool) {
        this.rcI.put(Long.valueOf(queryIdByAppid(paramString1)), parama);
      }
      AppMethodBeat.o(36007);
      return bool;
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean resumeTaskMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36006);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    a.b localb = this.rcJ;
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      if (localb != null) {
        locala.rcJ = localb;
      }
      locala.rrt.put(paramString1, new a.d(paramString2, paramString3));
      boolean bool = com.tencent.mm.plugin.downloader.model.f.bjl().iC(localFileDownloadTaskInfo.id);
      AppMethodBeat.o(36006);
      return bool;
    }
    AppMethodBeat.o(36006);
    return false;
  }
  
  @com.tencent.mm.remoteservice.e
  public void resumed(long paramLong)
  {
    AppMethodBeat.i(35995);
    this.rcI.get(Long.valueOf(paramLong));
    AppMethodBeat.o(35995);
  }
  
  public void saveAdVoteInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36027);
    REMOTE_CALL("saveAdVoteInfoMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(36027);
  }
  
  @com.tencent.mm.remoteservice.f
  public void saveAdVoteInfoMM(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36028);
    com.tencent.mm.plugin.sns.storage.v.h(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    AppMethodBeat.o(36028);
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    AppMethodBeat.i(35989);
    this.rcI.get(Long.valueOf(paramLong));
    AppMethodBeat.o(35989);
  }
  
  public long startDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, AdLandingPagesProxy.a parama, String paramString6, String paramString7)
  {
    AppMethodBeat.i(35997);
    ab.i("AdLandingPagesProxy", "startDownload, appId=" + paramString1 + ", pkg=" + paramString2 + ", aid=" + paramString6 + ", url=" + paramString4);
    paramString1 = REMOTE_CALL("startDownloadMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(paramBoolean), paramString6, paramString7 });
    if (paramString1 == null) {}
    for (long l = -1L;; l = ((Long)paramString1).longValue())
    {
      this.rcI.put(Long.valueOf(l), parama);
      AppMethodBeat.o(35997);
      return l;
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long startDownloadMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7)
  {
    AppMethodBeat.i(35996);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    AdLandingPagesProxy.b localb = new AdLandingPagesProxy.b(this, paramString1, paramString2, paramBoolean);
    a.b localb1 = this.rcJ;
    g.a locala1 = new g.a();
    locala1.setAppId(paramString1);
    locala1.dC(paramString2);
    locala1.JM(paramString3);
    locala1.JJ(paramString4);
    locala1.JL(paramString5);
    locala1.gr(paramBoolean);
    paramString3 = locala1.kYR;
    long l = com.tencent.mm.plugin.downloader.model.f.bjl().a(paramString3);
    if (localb1 != null) {
      locala.rcJ = localb1;
    }
    if (paramBoolean) {
      locala.a(paramString2, localb);
    }
    locala.rrt.put(paramString1, new a.d(paramString6, paramString7));
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.a(locala.rru);
    ab.i("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(35996);
    return l;
  }
  
  public void stopDownloadLandingPageVideo(String paramString)
  {
    AppMethodBeat.i(36045);
    if (this.rcL.containsKey(paramString))
    {
      this.rcL.remove(paramString);
      ab.i("AdLandingPagesProxy", "stop download video %s", new Object[] { paramString });
      h.qsU.cT(955, 34);
      ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, false).commit();
    }
    REMOTE_CALL("stopDownloadLandingPageVideoMM", new Object[] { paramString });
    AppMethodBeat.o(36045);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopDownloadLandingPageVideoMM(String paramString)
  {
    AppMethodBeat.i(36046);
    ag.cpa().aaa(paramString);
    AppMethodBeat.o(36046);
  }
  
  public void stopTask(String paramString)
  {
    AppMethodBeat.i(35999);
    REMOTE_CALL("stopTaskMM", new Object[] { paramString });
    AppMethodBeat.o(35999);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopTaskMM(String paramString)
  {
    AppMethodBeat.i(35998);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.rrx;
    paramString = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      com.tencent.mm.plugin.downloader.model.f.bjl().iz(l);
    }
    AppMethodBeat.o(35998);
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    AppMethodBeat.i(35992);
    if ((AdLandingPagesProxy.a)this.rcI.get(Long.valueOf(paramLong)) != null) {
      this.rcI.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(35992);
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    AppMethodBeat.i(35993);
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.rcI.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.coc();
      this.rcI.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(35993);
  }
  
  public boolean useOnlineStreamPlayer()
  {
    AppMethodBeat.i(35953);
    Object localObject = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(35953);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(35953);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean useOnlineStreamPlayerMM()
  {
    AppMethodBeat.i(35954);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100208");
    if (localc.isValid())
    {
      int i = bo.getInt((String)localc.dvN().get("useOnlineVideoPlayer"), 0);
      ab.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(35954);
        return true;
      }
      AppMethodBeat.o(35954);
      return false;
    }
    AppMethodBeat.o(35954);
    return false;
  }
  
  public void writeDeferredDeepLink(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36014);
    REMOTE_CALL("writeDeferredDeepLinkMM", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(36014);
  }
  
  @com.tencent.mm.remoteservice.f
  public void writeDeferredDeepLinkMM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36015);
    Ih().edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(36015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */