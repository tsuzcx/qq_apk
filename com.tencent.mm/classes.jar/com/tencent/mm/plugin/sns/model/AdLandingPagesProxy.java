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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.3;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private static AdLandingPagesProxy zfj;
  public static f zfm;
  private Map<Long, e> callbacks;
  private com.tencent.mm.al.f hPn;
  private Map<n, Long> zfk;
  private com.tencent.mm.remoteservice.d zfl;
  private ConcurrentHashMap<Long, ArrayList<a>> zfn;
  private a.b zfo;
  private Map<String, g> zfp;
  private Map<String, h.a> zfq;
  
  static
  {
    AppMethodBeat.i(95375);
    zfm = new f();
    AppMethodBeat.o(95375);
  }
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    AppMethodBeat.i(95227);
    this.callbacks = new HashMap();
    this.zfk = new HashMap();
    this.hPn = new AdLandingPagesProxy.1(this);
    this.zfn = new ConcurrentHashMap();
    this.zfo = new AdLandingPagesProxy.2(this);
    this.zfp = new HashMap();
    this.zfq = new HashMap();
    this.zfl = paramd;
    AppMethodBeat.o(95227);
  }
  
  private static SharedPreferences WD()
  {
    AppMethodBeat.i(95329);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences(aj.getPackageName() + "_comm_preferences", 0);
    AppMethodBeat.o(95329);
    return localSharedPreferences;
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    AppMethodBeat.i(95228);
    if (zfj == null) {
      zfj = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(aj.getContext()));
    }
    AdLandingPagesProxy localAdLandingPagesProxy = zfj;
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.dYg().C(paramLong, paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(176248);
      return;
    }
    paramString2 = new a.d(paramString2, paramString3, paramString4);
    locala.zxO.put(paramString1, paramString2);
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95216);
        if (!com.tencent.mm.kernel.g.ajA().aiK())
        {
          AppMethodBeat.o(95216);
          return;
        }
        Object localObject = ag.dUe().azZ(paramString);
        if (localObject != null)
        {
          localObject = ((p)localObject).dRL();
          if (localObject != null)
          {
            AdLandingPagesProxy.ayu(((com.tencent.mm.plugin.sns.storage.b)localObject).dWg());
            AdLandingPagesProxy.ayu(((com.tencent.mm.plugin.sns.storage.b)localObject).dWh());
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
    this.zfp.clear();
    this.callbacks.clear();
    this.zfn.clear();
    AppMethodBeat.o(95350);
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearCallbackMM()
  {
    AppMethodBeat.i(95349);
    this.zfk.clear();
    this.zfo = null;
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1337, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1210, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2874, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2721, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1802, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2605, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2883, this.hPn);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.ahp(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(95242);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(95226);
    this.zfl.connect(paramRunnable);
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
    int i = w.Ar(paramString);
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
    WD().edit().remove(paramString).commit();
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
    this.zfk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1210, this.hPn);
    AppMethodBeat.o(95275);
  }
  
  public void doAdUpdateQrUrlScene(String paramString1, String paramString2, String paramString3, e parame)
  {
    AppMethodBeat.i(197825);
    long l = System.currentTimeMillis();
    this.callbacks.put(Long.valueOf(l), parame);
    REMOTE_CALL("doAdUpdateQrUrlSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(197825);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdUpdateQrUrlSceneMM(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197826);
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h(paramString1, paramString2, paramString3);
    this.zfk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.aiU().a(1022, this.hPn);
    com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
    AppMethodBeat.o(197826);
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
    bsl localbsl = new bsl();
    localbsl.GNa = paramInt;
    localbsl.GNh = ((int)(System.currentTimeMillis() / 1000L));
    localbsl.nDi = 1;
    localbsl.GNb = new com.tencent.mm.bx.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localbsl);
    paramString = new com.tencent.mm.plugin.sns.ad.d.g(paramString);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1802, this.hPn);
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
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g(paramString1, paramString2, paramString3);
    this.zfk.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1337, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2721, this.hPn);
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
    cv localcv = new cv();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      bt.isNullOrNil(paramString1);
    }
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a(localcv, paramString6.hashCode(), u.aAm(), paramString4, paramString5, paramString6, paramString7, paramString2);
    paramString1 = y.AH(paramString3);
    localcv.dnG.sessionId = paramString1;
    localcv.dnG.title = paramString4;
    localcv.dnG.desc = paramString5;
    paramString1 = localcv.dnG.dnI;
    if ((paramString1 != null) && (paramString1.nZa != null) && (paramString1.nZa.size() > 0) && (paramString1.nZa.get(0) != null))
    {
      ((ajn)paramString1.nZa.get(0)).aOE(paramString6);
      ((ajn)paramString1.nZa.get(0)).aOf(paramString4);
      ((ajn)paramString1.nZa.get(0)).aOg(paramString5);
      ((ajn)paramString1.nZa.get(0)).aOD(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.aPd(paramString4);
      paramString1.aPe(paramString5);
    }
    localcv.dnG.dnM = paramInt2;
    com.tencent.mm.sdk.b.a.IbL.l(localcv);
    paramInt1 = localcv.dnG.dnL;
    AppMethodBeat.o(95264);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(95266);
    cv localcv = new cv();
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a(localcv, paramIntent);
    localcv.dnG.dnM = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localcv);
    paramInt = localcv.dnG.dnL;
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
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f(paramString);
    this.zfk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2874, this.hPn);
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
    this.zfk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2944, this.hPn);
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
    this.zfk.put(paramString1, Long.valueOf(paramLong1));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2605, this.hPn);
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
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g(paramString);
    this.zfk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1337, this.hPn);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2721, this.hPn);
    AppMethodBeat.o(95272);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(197824);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString1.ahp(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString1.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(197824);
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
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i(paramString);
    this.zfk.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2883, this.hPn);
    AppMethodBeat.o(95280);
  }
  
  public void downloadLandingPageVideo(String paramString1, String paramString2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95355);
    if (bt.V(new String[] { paramString1, paramString2, paramString3 }))
    {
      if (parama != null) {
        parama.a(paramString1, -1, null);
      }
      AppMethodBeat.o(95355);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(955, 20);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (com.tencent.mm.vfs.i.fv(paramString3))
    {
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(955, 21);
        parama.a(paramString1, 0, null);
        AppMethodBeat.o(95355);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(955, 22);
    }
    while (this.zfq.containsKey(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ad.i("%s is already in downloading", paramString2);
      AppMethodBeat.o(95355);
      return;
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "last download file was deleted");
        com.tencent.mm.plugin.report.service.g.yhR.dD(955, 23);
        localSharedPreferences.edit().putBoolean(paramString1, false).commit();
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(955, 24);
      }
    }
    if (parama != null) {
      this.zfq.put(paramString1, parama);
    }
    REMOTE_CALL("downloadLandingPageVideoMM", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(95355);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPageVideoMM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95360);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.g.yhR.dD(955, 25);
    ag.dTZ().a(paramString1, paramString2, paramString3, new AdLandingPagesProxy.d(this, paramString1));
    AppMethodBeat.o(95360);
  }
  
  public void downloadLandingPagesCDNFile(String paramString1, String paramString2, String paramString3, int paramInt, g paramg)
  {
    AppMethodBeat.i(197828);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      if (paramg != null) {
        paramg.dRX();
      }
      AppMethodBeat.o(197828);
      return;
    }
    if (paramg != null) {
      this.zfp.put(paramString2, paramg);
    }
    REMOTE_CALL("downloadLandingPagesCDNFileMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(197828);
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesCDNFileMM(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(197829);
    if (paramInt == 0)
    {
      downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
      AppMethodBeat.o(197829);
      return;
    }
    if (paramInt == 1) {
      downloadLandingPagesSightMMImpl(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(197829);
  }
  
  public void downloadLandingPagesImageMMImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(95353);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    paramString3 = com.tencent.mm.modelsns.h.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    final com.tencent.mm.plugin.sns.data.m localm = new com.tencent.mm.plugin.sns.data.m(paramString3);
    localm.zds = 3;
    localm.dwW = paramString3.Id;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95218);
        ag.dTZ().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, paramString3.Id));
        b localb = ag.dTZ();
        byn localbyn = paramString3;
        com.tencent.mm.plugin.sns.data.m localm = localm;
        bj localbj = bj.frn();
        localbj.hbR = ((int)(System.currentTimeMillis() / 1000L));
        localb.a(localbyn, 8, localm, localbj, paramString1, paramString2);
        AppMethodBeat.o(95218);
      }
    });
    AppMethodBeat.o(95353);
  }
  
  public void downloadLandingPagesSightMMImpl(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(197830);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "downloadLandingPagesSightMMImpl, mediaId=".concat(String.valueOf(paramString2)));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197819);
        ag.dTZ().a(new AdLandingPagesProxy.c(AdLandingPagesProxy.this, this.zbm.Id));
        b localb = ag.dTZ();
        byn localbyn = this.zbm;
        bj localbj = bj.frn();
        localbj.hbR = ((int)(System.currentTimeMillis() / 1000L));
        localb.a(localbyn, 4, null, localbj, paramString1, paramString2);
        AppMethodBeat.o(197819);
      }
    });
    AppMethodBeat.o(197830);
  }
  
  @com.tencent.mm.remoteservice.e
  public void failed(long paramLong)
  {
    AppMethodBeat.i(95305);
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dTk();
      }
    }
    this.zfn.remove(Long.valueOf(paramLong));
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
    gw localgw = new gw();
    localgw.dsV.type = 35;
    com.tencent.mm.sdk.b.a.IbL.l(localgw);
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
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197821);
        new com.tencent.mm.plugin.scanner.c().bL(paramInt, paramString).a(new d.b() {});
        AppMethodBeat.o(197821);
      }
    });
    AppMethodBeat.o(95372);
  }
  
  public void geoLocation(String paramString, e parame)
  {
    AppMethodBeat.i(197833);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.d("AdLandingPagesProxy", "geoLocation is called!!");
      long l = System.currentTimeMillis();
      this.callbacks.put(Long.valueOf(l), parame);
      REMOTE_CALL("geoLocationMM", new Object[] { Long.valueOf(l), paramString });
      AppMethodBeat.o(197833);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "geoLocation catch one exception");
      AppMethodBeat.o(197833);
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public void geoLocationMM(long paramLong, String paramString)
  {
    AppMethodBeat.i(197834);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.d("AdLandingPagesProxy", "geoLocationMM is called!!");
      com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b localb = com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c.a(this, "onGeoLocation", paramLong);
      if (localb != null) {
        localb.request(paramString);
      }
      AppMethodBeat.o(197834);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "geoLocationMM catch one exception");
      AppMethodBeat.o(197834);
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
    String str = ag.getAccSnsPath();
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
    int i = x.aH(paramString1, paramString2, paramString3);
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
    paramString1 = x.aI(paramString1, paramString2, paramString3);
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
    com.tencent.mm.kernel.g.ajD();
    paramObject = com.tencent.mm.kernel.g.ajC().ajl().get(paramInt, paramObject);
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
    paramString = com.tencent.mm.model.c.d.aDt().getExpIdByKey(paramString);
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
    paramInt = com.tencent.mm.model.c.d.aDt().gm(paramString, paramInt);
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
    paramString = ag.dUe().azZ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dRK().zuQ;
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
    paramString = ag.dUe().azZ(paramString);
    if (paramString != null)
    {
      int i = paramString.dYW();
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
    paramString = ag.dUe().azZ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dYP();
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
      localp.zMC = paramString.getInt("localid");
      paramString = paramString.getBundle("adValues");
      if (paramString != null)
      {
        localObject = new com.tencent.mm.plugin.sns.storage.e();
        ((com.tencent.mm.plugin.sns.storage.e)localObject).ao(paramString);
        localp.zMP = ((com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    AppMethodBeat.o(95249);
    return localp;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bundle getSnsInfoMM(String paramString)
  {
    AppMethodBeat.i(95250);
    paramString = ag.dUe().azZ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95250);
      return null;
    }
    paramString = paramString.dYs();
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
    Object localObject = ag.dUh().zZ(paramLong);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.sns.ad.d.h.b(((com.tencent.mm.plugin.sns.storage.e)localObject).dYl());
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
    paramString = ag.dUe().azZ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dYQ();
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
    paramString = ag.dUe().azZ(paramString);
    if (paramString != null)
    {
      paramString = paramString.dYT();
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
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqx, 0);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    paramString = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramString);
    if (paramString.nsQ != 0L)
    {
      int i = (int)(paramString.pmT * 100L / paramString.nsQ);
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
    com.tencent.mm.kernel.g.ajA();
    String str = com.tencent.mm.kernel.a.aiq();
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
    paramString3 = a.e.zxS;
    paramString4 = aj.getContext();
    AdLandingPagesProxy.b localb = new AdLandingPagesProxy.b(this, paramString1, paramString2, false);
    if ((paramString4 == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(95319);
      return false;
    }
    paramString1 = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramString1);
    if ((paramString1 != null) && (paramString1.status == 3) && (!TextUtils.isEmpty(paramString1.path)))
    {
      paramString3.aA(4, paramString1.id);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
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
    int i = ag.dUb().b(null, null);
    AppMethodBeat.o(95262);
    return i;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(95229);
    if (this.zfl == null)
    {
      AppMethodBeat.o(95229);
      return false;
    }
    boolean bool = this.zfl.isConnected();
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    paramString = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    paramString = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bg(aj.getContext(), paramString);
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
    paramString = ag.dUe().azZ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(95248);
      return false;
    }
    boolean bool = paramString.dWk();
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
    f localf = zfm;
    int i;
    if (bt.HI() - localf.lastUpdateTime > 3600L)
    {
      i = 1;
      if (i != 0) {
        localf.zfv = false;
      }
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.kernel.g.ajx())
        {
          com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100348");
          if (localc.isValid())
          {
            if (bt.getInt((String)localc.foF().get("downloadMode"), 0) != 1) {
              continue;
            }
            bool = true;
            localf.zfv = bool;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("AdLandingPagesProxy", localException, "get abtest failed!", new Object[0]);
        continue;
      }
      localf.lastUpdateTime = bt.HI();
      bool = zfm.zfv;
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
    boolean bool = o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(2538, this.hPn);
    AppMethodBeat.o(95286);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdUpdateQrUrlEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(197827);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if (locale != null) {
      locale.h(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(197827);
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
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "exception:%s", new Object[] { bt.n(paramString) });
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
    if (this.zfq.containsKey(paramString)) {
      ((h.a)this.zfq.get(paramString)).onDataAvailable(paramString, paramLong1, paramLong2);
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
    if (this.zfq.containsKey(paramString)) {
      ((h.a)this.zfq.remove(paramString)).a(paramString, paramInt, null);
    }
    AppMethodBeat.o(95368);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(197832);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.zfq.containsKey(paramString1)) {
      ((h.a)this.zfq.get(paramString1)).a(paramString1, paramLong1, paramLong2, paramString2);
    }
    AppMethodBeat.o(197832);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onCdnVideoProgress(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95367);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "cdn video progress %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.zfq.containsKey(paramString)) {
      ((h.a)this.zfq.get(paramString)).i(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95367);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AppMethodBeat.i(95270);
    e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
    if ((locale != null) && (!bt.isNullOrNil(paramString))) {
      locale.be(paramString);
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
  public void onGeoLocation(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(197835);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.d("AdLandingPagesProxy", "onGeoLocation is called!!");
      e locale = (e)this.callbacks.remove(Long.valueOf(paramLong));
      if (locale != null) {
        locale.be(paramObject);
      }
      AppMethodBeat.o(197835);
      return;
    }
    catch (Throwable paramObject)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesProxy", "onGeoLocation catch one exception");
      AppMethodBeat.o(197835);
    }
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
    paramString = (g)this.zfp.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.dTm();
        AppMethodBeat.o(95354);
        return;
      }
      paramString.dRX();
    }
    AppMethodBeat.o(95354);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSightDownloadCallback(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197831);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onSightDownloadCallback, id=" + paramString + ", isOk=" + paramBoolean);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(197831);
      return;
    }
    paramString = (g)this.zfp.remove(paramString);
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.dTm();
        AppMethodBeat.o(197831);
        return;
      }
      paramString.dRX();
    }
    AppMethodBeat.o(197831);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    boolean bool = com.tencent.mm.plugin.downloader.model.f.ccl().tT(l);
    AppMethodBeat.o(95313);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    AppMethodBeat.i(95302);
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dTh();
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
    wq localwq = new wq();
    localwq.dKZ.gW = paramLong2;
    com.tencent.mm.sdk.b.a.IbL.l(localwq);
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
    wr localwr = new wr();
    localwr.dLa.gW = paramLong2;
    com.tencent.mm.sdk.b.a.IbL.l(localwr);
    AppMethodBeat.o(95288);
  }
  
  @com.tencent.mm.remoteservice.e
  public void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95301);
    com.tencent.mm.sdk.platformtools.ad.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.PN(paramInt);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    AppMethodBeat.o(95311);
    return l;
  }
  
  public long[] queryVideoMoov(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95358);
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", new Object[] { paramString1, paramString2, paramString3 });
    if (bt.V(new String[] { paramString1, paramString2, paramString3 }))
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
    a.e.zxS.reportDownloadInfo(paramInt, paramString);
    AppMethodBeat.o(95321);
  }
  
  public void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95361);
    com.tencent.mm.plugin.report.service.g.yhR.dD(955, 32);
    REMOTE_CALL("requestVideoDataMM", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(95361);
  }
  
  @com.tencent.mm.remoteservice.f
  public void requestVideoDataMM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95362);
    com.tencent.mm.plugin.report.service.g.yhR.dD(955, 33);
    o.aMK();
    com.tencent.mm.ao.e.r(paramString, paramInt1, paramInt2);
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
        paramString2 = (ArrayList)this.zfn.get(Long.valueOf(l));
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
      this.zfn.put(Long.valueOf(l), paramString1);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    a.b localb = this.zfo;
    com.tencent.mm.plugin.downloader.model.f.ccl();
    com.tencent.mm.plugin.downloader.model.c.a(locala.zxP);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      if (localb != null) {
        locala.zfo = localb;
      }
      locala.zxO.put(paramString1, new a.d(paramString2, paramString3, paramString4));
      boolean bool = com.tencent.mm.plugin.downloader.model.f.ccl().tU(localFileDownloadTaskInfo.id);
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
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dTl();
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
    x.b(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4);
    AppMethodBeat.o(95339);
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    AppMethodBeat.i(95300);
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
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
      paramString2 = (ArrayList)this.zfn.get(Long.valueOf(l));
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
      this.zfn.put(Long.valueOf(l), paramString1);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    AdLandingPagesProxy.b localb = new AdLandingPagesProxy.b(this, paramString1, paramString3, paramBoolean1);
    a.b localb1 = this.zfo;
    if (!paramBoolean2)
    {
      paramString2 = new g.a();
      paramString2.setAppId(paramString1);
      paramString2.aap(paramString1);
      paramString2.ft(paramString3);
      paramString2.aan(paramString4);
      paramString2.aak(paramString5);
      paramString2.aam(paramString6);
      paramString2.jQ(paramBoolean1);
      paramString2 = paramString2.pmN;
    }
    com.tencent.mm.plugin.downloader_app.a.a locala1;
    for (long l = com.tencent.mm.plugin.downloader.model.f.ccl().a(paramString2);; l = ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(locala1, new a.3(locala)))
    {
      if (localb1 != null) {
        locala.zfo = localb1;
      }
      if (paramBoolean1) {
        locala.a(paramString3, localb);
      }
      locala.zxO.put(paramString1, new a.d(paramString7, paramString8, paramString9));
      com.tencent.mm.plugin.downloader.model.f.ccl();
      com.tencent.mm.plugin.downloader.model.c.a(locala.zxP);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(176244);
      return l;
      locala1 = new com.tencent.mm.plugin.downloader_app.a.a();
      locala1.downloadUrl = paramString5;
      locala1.appId = paramString2;
      locala1.poz = paramString1;
      locala1.packageName = paramString3;
      locala1.lMs = paramString4;
      locala1.appName = paramString6;
      locala1.duJ = 1;
      locala1.poB = paramBoolean1;
      locala1.scene = 5101;
    }
  }
  
  public void stopDownloadLandingPageVideo(String paramString)
  {
    AppMethodBeat.i(95356);
    if (this.zfq.containsKey(paramString))
    {
      this.zfq.remove(paramString);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "stop download video %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yhR.dD(955, 34);
      aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramString, false).commit();
    }
    REMOTE_CALL("stopDownloadLandingPageVideoMM", new Object[] { paramString });
    AppMethodBeat.o(95356);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopDownloadLandingPageVideoMM(String paramString)
  {
    AppMethodBeat.i(95357);
    ag.dTZ().ayz(paramString);
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
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.e.zxS;
    paramString = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      com.tencent.mm.plugin.downloader.model.f.ccl().tR(l);
    }
    AppMethodBeat.o(95309);
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    AppMethodBeat.i(95303);
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dTi();
      }
    }
    this.zfn.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95303);
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    AppMethodBeat.i(95304);
    Iterator localIterator = ((ArrayList)this.zfn.get(Long.valueOf(paramLong))).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dTj();
      }
    }
    this.zfn.remove(Long.valueOf(paramLong));
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
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100208");
    if (localc.isValid())
    {
      int i = bt.getInt((String)localc.foF().get("useOnlineVideoPlayer"), 0);
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
    WD().edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(95326);
  }
  
  public static abstract interface a
  {
    public abstract void PN(int paramInt);
    
    public abstract void dTh();
    
    public abstract void dTi();
    
    public abstract void dTj();
    
    public abstract void dTk();
    
    public abstract void dTl();
    
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
    
    public final void ays(String paramString) {}
    
    public final void bM(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(95221);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!bt.V(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        ag.dTZ().b(this);
      }
      AppMethodBeat.o(95221);
    }
    
    public final void bN(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197822);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesProxy", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
      if ((!bt.V(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        AdLandingPagesProxy.this.CLIENT_CALL("onSightDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        ag.dTZ().b(this);
      }
      AppMethodBeat.o(197822);
    }
    
    public final void dTb() {}
  }
  
  public static abstract interface e
  {
    public abstract void be(Object paramObject);
    
    public abstract void h(int paramInt1, int paramInt2, Object paramObject);
  }
  
  public static final class f
  {
    long lastUpdateTime = 0L;
    boolean zfv = false;
  }
  
  public static abstract interface g
  {
    public abstract void dRX();
    
    public abstract void dTm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */