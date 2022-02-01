package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.adxml.i.a;
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.adxml.n;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.ad.d.r;
import com.tencent.mm.plugin.sns.ad.j.a;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.a;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.o.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.o.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h
{
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.o QaB;
  private static Set<String> QaC;
  
  static
  {
    AppMethodBeat.i(311298);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.o localo = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.o("timeline");
    QaB = localo;
    localo.QXr = new o.a()
    {
      public final void a(o.b paramAnonymousb)
      {
        AppMethodBeat.i(311170);
        Log.d("TimeLineAdPreloadHelper", "onParseResItem:".concat(String.valueOf(paramAnonymousb)));
        if (paramAnonymousb.hCh == 1)
        {
          h.h(paramAnonymousb.url, "", paramAnonymousb.desc, true);
          AppMethodBeat.o(311170);
          return;
        }
        if (paramAnonymousb.hCh == 2) {
          try
          {
            boolean bool = y.ZC(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mE("adId", paramAnonymousb.url));
            if (bool)
            {
              AppMethodBeat.o(311170);
              return;
            }
            com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b.downloadPagFile(paramAnonymousb.url);
            AppMethodBeat.o(311170);
            return;
          }
          finally
          {
            Log.e("TimeLineAdPreloadHelper", "onPreloadPagFile, exp=" + paramAnonymousb.toString());
          }
        }
        AppMethodBeat.o(311170);
      }
    };
    QaC = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(311298);
  }
  
  private static void a(com.tencent.mm.plugin.sns.ad.adxml.i parami, String paramString)
  {
    AppMethodBeat.i(311230);
    if ((parami != null) && (parami.PMR != null) && (parami.PMR.size() > 0))
    {
      parami = parami.PMR.iterator();
      while (parami.hasNext()) {
        h(((i.a)parami.next()).iconUrl, paramString, "preloadLivingAnimIcon", true);
      }
    }
    AppMethodBeat.o(311230);
  }
  
  public static void a(ADXml.b paramb, String paramString)
  {
    AppMethodBeat.i(311221);
    if (paramb != null)
    {
      h(paramb.PNb, paramString, "preloadScanRes bgImage", false);
      h(paramb.wtd, paramString, "preloadScanRes descIcon", false);
      h(paramb.QHs, paramString, "preloadScanRes succIcon", false);
    }
    AppMethodBeat.o(311221);
  }
  
  private static boolean a(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(311243);
    if ((paramADXml == null) || (paramADXml.adFinderTopicInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(311243);
      return false;
    }
    try
    {
      paramADXml = paramADXml.adFinderTopicInfo.PMG;
      boolean bool = d.isEmpty(paramADXml);
      if (bool)
      {
        AppMethodBeat.o(311243);
        return false;
      }
      paramADXml = paramADXml.iterator();
      while (paramADXml.hasNext())
      {
        g localg = (g)paramADXml.next();
        if ((localg != null) && (localg.gZy()))
        {
          a(localg.ibT, paramString);
          b(localg.ibT, paramString);
        }
      }
      Log.d("TimeLineAdPreloadHelper", "the topic card resource preloaded!");
    }
    finally
    {
      Log.e("TimeLineAdPreloadHelper", "preloadTopicCardRes exp=" + paramADXml.toString());
      AppMethodBeat.o(311243);
      return false;
    }
    AppMethodBeat.o(311243);
    return true;
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, ADXml paramADXml, ADInfo paramADInfo, int paramInt)
  {
    AppMethodBeat.i(311157);
    try
    {
      i.ajC(paramInt);
      if (!hbV())
      {
        Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(311157);
        return false;
      }
      b(paramTimeLineObject, paramADXml, paramADInfo, paramInt);
    }
    finally
    {
      for (;;)
      {
        Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp=" + paramTimeLineObject.toString());
      }
    }
    AppMethodBeat.o(311157);
    return false;
  }
  
  private static boolean a(final dmz paramdmz, String paramString)
  {
    AppMethodBeat.i(311205);
    String str1 = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str2 = t.i(paramdmz);
    str1 = str1 + str2;
    if (y.ZC(str1))
    {
      Log.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + paramString + ", mediaId=" + paramdmz.Id + ", filePath=" + str1);
      AppMethodBeat.o(311205);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(311167);
        try
        {
          Log.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + h.this + ", mediaId=" + paramdmz.Id);
          al.hgw().a(paramdmz, 4, null, br.adkd);
          AppMethodBeat.o(311167);
          return;
        }
        finally
        {
          Log.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + localObject.toString());
          AppMethodBeat.o(311167);
        }
      }
    });
    AppMethodBeat.o(311205);
    return true;
  }
  
  public static boolean a(ef paramef, int paramInt)
  {
    AppMethodBeat.i(311175);
    label531:
    label789:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int k;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      try
      {
        i.ajC(paramInt);
        localObject3 = w.b(paramef.YGn.abCS.ObjectDesc);
        localObject1 = w.a(paramef.YGn.abCT);
        localObject2 = w.a(paramef.YGo);
        paramef = com.tencent.mm.modelsns.o.Pm((String)localObject3);
        if ((paramef.ContentObj != null) && (paramef.ContentObj.Zpr != null) && (paramef.ContentObj.Zpr.size() > 0))
        {
          localObject3 = (dmz)paramef.ContentObj.Zpr.get(0);
          if (localObject3 != null) {
            ((dmz)localObject3).isAd = true;
          }
        }
        localObject1 = new ADXml((String)localObject1);
        localObject2 = new ADInfo((String)localObject2);
        if (paramInt == 4) {}
        try
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1697, 5);
          i = paramef.ContentObj.Zpq;
          j = 0;
          if (i == 15) {
            break label759;
          }
          if (i != 5) {
            break label531;
          }
        }
        finally
        {
          long l1;
          long l2;
          Log.e("TimeLineStaticHelper", "reportAdType, exp=" + localObject4.toString());
          continue;
        }
        k = 15;
        if (((ADXml)localObject1).isFullCardAd()) {
          if (((ADXml)localObject1).isLongPressGestureAd())
          {
            i = 22;
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1697, i);
          }
        }
      }
      finally
      {
        Object localObject3;
        Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + paramef.toString());
        AppMethodBeat.o(311175);
        return false;
      }
      try
      {
        l1 = System.currentTimeMillis();
        localObject3 = (SensorManager)MMApplicationContext.getContext().getSystemService("sensor");
        if (((SensorManager)localObject3).getDefaultSensor(1) != null) {
          break label664;
        }
        i = 0;
        if (((SensorManager)localObject3).getDefaultSensor(9) != null) {
          break label669;
        }
        j = 0;
        if (((SensorManager)localObject3).getDefaultSensor(4) != null) {
          break label674;
        }
        k = 0;
        if (((SensorManager)localObject3).getDefaultSensor(10) != null) {
          break label680;
        }
        m = 0;
        if (((SensorManager)localObject3).getDefaultSensor(2) != null) {
          break label686;
        }
        n = 0;
        if (((SensorManager)localObject3).getDefaultSensor(11) != null) {
          break label692;
        }
        i1 = 0;
        if (((SensorManager)localObject3).getDefaultSensor(15) != null) {
          break label698;
        }
        i2 = 0;
        if (((SensorManager)localObject3).getDefaultSensor(3) != null) {
          break label704;
        }
        i3 = 0;
        localObject3 = m + "|" + n + "|" + i1 + "|" + i2 + "|" + i3;
        com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.QnD, String.valueOf(k), j, i, (String)localObject3);
        l2 = System.currentTimeMillis();
        Log.i("TimeLineStaticHelper", "reportSensor, cost=" + (l2 - l1));
      }
      finally
      {
        boolean bool;
        label664:
        label669:
        label674:
        label680:
        label686:
        label692:
        label698:
        label704:
        Log.e("TimeLineStaticHelper", "reportSensor, exp=" + localObject5.toString());
        continue;
        b(paramef, (ADXml)localObject1, (ADInfo)localObject2, paramInt);
        continue;
        i = 0;
      }
      if (!hbV())
      {
        Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(311175);
        return false;
        if (paramInt != 1) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1697, 6);
        continue;
        if (i != 1) {
          break label754;
        }
        i = 1;
        continue;
        if (((ADXml)localObject1).isGestureAd())
        {
          i = 23;
          continue;
        }
        if (((ADXml)localObject1).isTwistAd())
        {
          i = 24;
          continue;
        }
        if (!((ADXml)localObject1).isShakeAd()) {
          break label766;
        }
        i = 25;
        continue;
        if (((ADXml)localObject1).isCardAd())
        {
          if (i == 0) {
            break label789;
          }
          i = 9;
          continue;
        }
        if (((ADXml)localObject1).isSphereCardAd())
        {
          i = 13;
          continue;
        }
        if (!((ADXml)localObject1).isFinderTopicCard())
        {
          bool = ((ADXml)localObject1).isSlideFullCard();
          if (!bool) {}
        }
        else
        {
          i = 14;
          continue;
        }
        if (i != 0)
        {
          i = 7;
          continue;
        }
        i = k;
        if (j == 0) {
          continue;
        }
        i = 8;
        continue;
        i = 1;
        continue;
        j = 1;
        continue;
        k = 1;
        continue;
        m = 1;
        continue;
        n = 1;
        continue;
        i1 = 1;
        continue;
        i2 = 1;
        continue;
        i3 = 1;
        continue;
      }
      label754:
      continue;
      label759:
      int j = 1;
      int i = 0;
      continue;
      label766:
      if (i != 0)
      {
        i = 11;
      }
      else
      {
        i = k;
        if (j != 0)
        {
          i = 12;
          continue;
          i = k;
          if (j != 0) {
            i = 10;
          }
        }
      }
    }
  }
  
  private static void b(ADXml paramADXml, ADInfo paramADInfo)
  {
    AppMethodBeat.i(311264);
    if ((paramADXml == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(311264);
      return;
    }
    if (!paramADInfo.preloadFinderFeed)
    {
      AppMethodBeat.o(311264);
      return;
    }
    try
    {
      if (paramADXml.adFinderInfo != null) {
        com.tencent.mm.plugin.sns.ad.d.o.aWo(paramADXml.adFinderInfo.hAx);
      }
      if (paramADXml.adActionLinkClickInfo != null) {
        c(paramADXml.adActionLinkClickInfo);
      }
      if ((paramADXml.adCardActionBtnInfo != null) && (paramADXml.adCardActionBtnInfo.clickActionInfo != null)) {
        c(paramADXml.adCardActionBtnInfo.clickActionInfo);
      }
      if ((paramADXml.adTagBtnInfo != null) && (paramADXml.adTagBtnInfo.clickActionInfo != null)) {
        c(paramADXml.adTagBtnInfo.clickActionInfo);
      }
      Object localObject = paramADXml.getAdSelectInfo();
      if (localObject != null)
      {
        if (((ADXml.h)localObject).QHR != null) {
          c(((ADXml.h)localObject).QHR);
        }
        if (((ADXml.h)localObject).QHS != null) {
          c(((ADXml.h)localObject).QHS);
        }
      }
      if ((paramADXml.adSliderFullCardInfo != null) && (!d.isEmpty(paramADXml.adSliderFullCardInfo.PMG)))
      {
        paramADXml = paramADXml.adSliderFullCardInfo.PMG.iterator();
        while (paramADXml.hasNext())
        {
          localObject = (com.tencent.mm.plugin.sns.ad.adxml.l)paramADXml.next();
          if (localObject != null)
          {
            if (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject).clickActionInfo != null) {
              c(((com.tencent.mm.plugin.sns.ad.adxml.l)localObject).clickActionInfo);
            }
            if ((((com.tencent.mm.plugin.sns.ad.adxml.l)localObject).PMY != null) && (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject).PMY.PNj != null)) {
              c(((com.tencent.mm.plugin.sns.ad.adxml.l)localObject).PMY.PNj);
            }
          }
        }
      }
      if (d.isEmpty(paramADInfo.adClickActionInfoList)) {
        break label324;
      }
    }
    finally
    {
      Log.e("TimeLineAdPreloadHelper", paramADXml.toString());
      AppMethodBeat.o(311264);
      return;
    }
    paramADXml = paramADInfo.adClickActionInfoList.iterator();
    while (paramADXml.hasNext())
    {
      paramADInfo = (AdClickActionInfo)paramADXml.next();
      if (paramADInfo != null) {
        c(paramADInfo);
      }
    }
    label324:
    AppMethodBeat.o(311264);
  }
  
  private static void b(TimeLineObject paramTimeLineObject, ADXml paramADXml, ADInfo paramADInfo, int paramInt)
  {
    AppMethodBeat.i(311183);
    Log.i("TimeLineAdPreloadHelper", "doPreload, scene=" + paramInt + ", snsId=" + paramTimeLineObject.Id);
    c(paramTimeLineObject, paramADXml);
    QaB.gs(paramADXml);
    if (paramADXml != null)
    {
      if (paramADXml.adScanJumpInfo != null) {
        a(paramADXml.adScanJumpInfo, paramTimeLineObject.Id);
      }
      if (paramADXml.adLiveInfo != null) {
        a(paramADXml.adLiveInfo, paramTimeLineObject.Id);
      }
      if ((r.aJT("wxaliteb984a6d0a709290f7f2cd6cab0db8fbe")) && ((paramADXml.adFinderLivePreviewInfo != null) || ((paramADXml.adCardActionBtnInfo != null) && (paramADXml.adCardActionBtnInfo.clickActionInfo != null) && (paramADXml.adCardActionBtnInfo.clickActionInfo.PLT)))) {
        r.gZW();
      }
    }
    b(paramADXml, paramADInfo);
    k.d(paramADXml);
    AppMethodBeat.o(311183);
  }
  
  private static boolean b(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(311253);
    if ((paramADXml == null) || (paramADXml.adSliderFullCardInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(311253);
      return false;
    }
    for (;;)
    {
      try
      {
        Object localObject = paramADXml.adSliderFullCardInfo.PMG;
        boolean bool = d.isEmpty((Collection)localObject);
        if (bool)
        {
          AppMethodBeat.o(311253);
          return false;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        com.tencent.mm.plugin.sns.ad.adxml.l locall = (com.tencent.mm.plugin.sns.ad.adxml.l)((Iterator)localObject).next();
        if (locall != null) {
          if (locall.gZy())
          {
            e.a(paramADXml, locall.ibT, paramString);
            a(locall.ibT, paramString);
            b(locall.ibT, paramString);
          }
          else
          {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.c("adId", locall.ibT.aaTl, new k.a(null));
          }
        }
      }
      finally
      {
        Log.e("TimeLineAdPreloadHelper", "preloadSlideFullCardRes exp = " + paramADXml.toString());
        AppMethodBeat.o(311253);
        return false;
      }
    }
    Log.d("TimeLineAdPreloadHelper", "the slide full card resource preloaded!");
    AppMethodBeat.o(311253);
    return true;
  }
  
  private static boolean b(final dmz paramdmz, String paramString)
  {
    AppMethodBeat.i(311211);
    String str1 = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str2 = t.d(paramdmz);
    if (y.ZC(str1 + str2))
    {
      Log.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + paramString + ", mediaId=" + paramdmz.Id);
      AppMethodBeat.o(311211);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(311173);
        try
        {
          Log.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + h.this + ", mediaId=" + paramdmz.Id);
          p localp = new p(paramdmz);
          localp.QnY = 1;
          localp.hOG = paramdmz.Id;
          c localc = al.hgw();
          dmz localdmz = paramdmz;
          if (paramdmz.vhJ == 6) {
            i = 5;
          }
          localc.a(localdmz, i, localp, br.adkd);
          AppMethodBeat.o(311173);
          return;
        }
        finally
        {
          Log.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + localObject.toString());
          AppMethodBeat.o(311173);
        }
      }
    });
    AppMethodBeat.o(311211);
    return true;
  }
  
  private static void c(AdClickActionInfo paramAdClickActionInfo)
  {
    AppMethodBeat.i(311274);
    if (paramAdClickActionInfo == null)
    {
      AppMethodBeat.o(311274);
      return;
    }
    com.tencent.mm.plugin.sns.ad.d.o.aWo(paramAdClickActionInfo.PMe);
    AppMethodBeat.o(311274);
  }
  
  private static boolean c(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(311197);
    for (;;)
    {
      dmz localdmz;
      try
      {
        if (paramTimeLineObject.ContentObj.Zpq != 15)
        {
          Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(311197);
          return false;
        }
        if ((paramTimeLineObject.ContentObj.Zpr == null) || (paramTimeLineObject.ContentObj.Zpr.isEmpty()))
        {
          Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(311197);
          return false;
        }
        if (a(paramADXml, paramTimeLineObject.Id))
        {
          Log.i("TimeLineAdPreloadHelper", "the sns info is topic card info, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(311197);
          return true;
        }
        if (b(paramADXml, paramTimeLineObject.Id))
        {
          Log.i("TimeLineAdPreloadHelper", "the sns info is slide full card info, snsId = " + paramTimeLineObject.Id);
          AppMethodBeat.o(311197);
          return true;
        }
        localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
        boolean bool = b.a(paramTimeLineObject, paramADXml);
        Log.i("TimeLineAdPreloadHelper", "preloadAdVideo, isOnlineVideo=" + bool + ", snsId=" + paramTimeLineObject.Id);
        if (!bool)
        {
          if (paramADXml != null)
          {
            if (!paramADXml.isFullCardAd()) {
              continue;
            }
            Log.i("TimeLineAdPreloadHelper", "preloadAdVideo, !isOnlineVideo, isFullCard, checkH265");
            e.a(paramADXml, localdmz, paramTimeLineObject.Id);
            if (paramADXml != null)
            {
              Object localObject = paramADXml.adBreakFrameInfo;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.storage.b)localObject).QIv.ibT.isAd = true;
              }
              if ((paramADXml.isAdBreakFrameVideo()) && (localObject != null))
              {
                localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).QIv.ibT;
                e.a(paramADXml, (dmz)localObject, paramTimeLineObject.Id);
                a((dmz)localObject, paramTimeLineObject.Id);
              }
            }
          }
          a(localdmz, paramTimeLineObject.Id);
          b(localdmz, paramTimeLineObject.Id);
          AppMethodBeat.o(311197);
          return true;
          Log.i("TimeLineAdPreloadHelper", "preloadAdVideo, !isOnlineVideo, !isFullCard, disableH265");
          e.a(localdmz, false);
          continue;
        }
        e.a(paramADXml, localdmz, paramTimeLineObject.Id);
      }
      finally
      {
        Log.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + paramTimeLineObject.toString());
        AppMethodBeat.o(311197);
        return false;
      }
      b(localdmz, paramTimeLineObject.Id);
    }
  }
  
  public static void h(final String paramString1, final String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(311287);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("TimeLineAdPreloadHelper", paramString3 + " url is empty, snsid=" + paramString2);
      AppMethodBeat.o(311287);
      return;
    }
    if (paramBoolean) {}
    for (String str = a.aWQ(paramString1); (!TextUtils.isEmpty(str)) && (y.ZC(str)); str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", paramString1))
    {
      Log.i("TimeLineAdPreloadHelper", paramString3 + " file exists, snsid=" + paramString2 + ", filePath=" + str);
      AppMethodBeat.o(311287);
      return;
    }
    if (QaC.contains(paramString1))
    {
      Log.w("TimeLineAdPreloadHelper", paramString3 + " is in downloading, snsid=" + paramString2);
      AppMethodBeat.o(311287);
      return;
    }
    QaC.add(paramString1);
    if (paramBoolean)
    {
      a.a(paramString1, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(311181);
          Log.i("TimeLineAdPreloadHelper", h.this + " cdn succ, snsid=" + paramString2 + ", url=" + paramString1);
          h.QaC.remove(paramString1);
          AppMethodBeat.o(311181);
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(311174);
          Log.e("TimeLineAdPreloadHelper", h.this + " cdn failed, snsid=" + paramString2 + ", url=" + paramString1);
          h.QaC.remove(paramString1);
          AppMethodBeat.o(311174);
        }
      });
      AppMethodBeat.o(311287);
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.a(paramString1, true, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(311171);
        Log.i("TimeLineAdPreloadHelper", h.this + " succ, snsid=" + paramString2 + ", url=" + paramString1);
        h.QaC.remove(paramString1);
        AppMethodBeat.o(311171);
      }
      
      public final void gZM() {}
      
      public final void gZN()
      {
        AppMethodBeat.i(311163);
        Log.e("TimeLineAdPreloadHelper", h.this + " failed, snsid=" + paramString2 + ", url=" + paramString1);
        h.QaC.remove(paramString1);
        AppMethodBeat.o(311163);
      }
    });
    AppMethodBeat.o(311287);
  }
  
  private static boolean hbV()
  {
    AppMethodBeat.i(311186);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())) || (NetStatusUtil.is5G(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(311186);
      return true;
    }
    AppMethodBeat.o(311186);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.h
 * JD-Core Version:    0.7.0.1
 */