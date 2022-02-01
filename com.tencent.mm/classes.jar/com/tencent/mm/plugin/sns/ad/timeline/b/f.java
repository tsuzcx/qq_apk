package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.adxml.e;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.adxml.g.a;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.ad.adxml.k;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class f
{
  private static Set<String> JJa;
  
  static
  {
    AppMethodBeat.i(256332);
    JJa = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(256332);
  }
  
  private static void a(g paramg, String paramString)
  {
    AppMethodBeat.i(256320);
    if ((paramg != null) && (paramg.Jyx != null) && (paramg.Jyx.size() > 0))
    {
      paramg = paramg.Jyx.iterator();
      while (paramg.hasNext()) {
        g(((g.a)paramg.next()).iconUrl, paramString, "preloadLivingAnimIcon", true);
      }
    }
    AppMethodBeat.o(256320);
  }
  
  private static void a(k paramk, String paramString)
  {
    AppMethodBeat.i(256318);
    if (paramk != null)
    {
      g(paramk.JyG, paramString, "preloadTagBtnRes bgImageUrl", true);
      g(paramk.JyH, paramString, "preloadTagBtnRes bgImageUrlDark", true);
    }
    AppMethodBeat.o(256318);
  }
  
  public static void a(ADXml.b paramb, String paramString)
  {
    AppMethodBeat.i(256316);
    if (paramb != null)
    {
      g(paramb.JyG, paramString, "preloadScanRes bgImage", false);
      g(paramb.toE, paramString, "preloadScanRes descIcon", false);
      g(paramb.Kjv, paramString, "preloadScanRes succIcon", false);
    }
    AppMethodBeat.o(256316);
  }
  
  private static void a(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(256314);
    if ((paramADXml == null) || (!paramADXml.isFullCardAd()) || (paramADXml.adFullCardInfo == null))
    {
      AppMethodBeat.o(256314);
      return;
    }
    if (paramADXml.adFullCardInfo.KjP != null)
    {
      g(paramADXml.adFullCardInfo.KjP.KKK, paramString, "preloadFullCardImage fullcardEndView.titleImage", false);
      g(paramADXml.adFullCardInfo.KjP.coverImgUrl, paramString, "preloadFullCardImage fullcardEndView.coverImg", false);
    }
    if (!TextUtils.isEmpty(paramADXml.adFullCardInfo.KjL)) {
      g(paramADXml.adFullCardInfo.KjL, paramString, "preloadFullCardImage fullcard.frontCover", false);
    }
    if (!TextUtils.isEmpty(paramADXml.adFullCardInfo.KjN)) {
      g(paramADXml.adFullCardInfo.KjN, paramString, "preloadFullCardImage fullcard.endCover", false);
    }
    AppMethodBeat.o(256314);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, ADXml paramADXml, int paramInt)
  {
    AppMethodBeat.i(256303);
    try
    {
      aeT(paramInt);
      if (!fLy())
      {
        Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(256303);
        return false;
      }
      b(paramTimeLineObject, paramADXml, paramInt);
    }
    catch (Throwable paramTimeLineObject)
    {
      for (;;)
      {
        Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp=" + paramTimeLineObject.toString());
      }
    }
    AppMethodBeat.o(256303);
    return false;
  }
  
  private static boolean a(final cvt paramcvt, String paramString)
  {
    AppMethodBeat.i(256312);
    String str1 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str2 = t.i(paramcvt);
    str1 = str1 + str2;
    if (u.agG(str1))
    {
      Log.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + paramString + ", mediaId=" + paramcvt.Id + ", filePath=" + str1);
      AppMethodBeat.o(256312);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198048);
        try
        {
          Log.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + this.mhm + ", mediaId=" + paramcvt.Id);
          aj.fOD().a(paramcvt, 4, null, bp.VGp);
          AppMethodBeat.o(198048);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + localThrowable.toString());
          AppMethodBeat.o(198048);
        }
      }
    });
    AppMethodBeat.o(256312);
    return true;
  }
  
  public static boolean a(dq paramdq, int paramInt)
  {
    AppMethodBeat.i(256304);
    label283:
    label418:
    for (;;)
    {
      Object localObject1;
      int k;
      try
      {
        aeT(paramInt);
        Object localObject2 = z.b(paramdq.RIZ.Ulb.ObjectDesc);
        localObject1 = z.a(paramdq.RIZ.Ulc);
        paramdq = o.Xk((String)localObject2);
        if ((paramdq.ContentObj != null) && (paramdq.ContentObj.Sqr != null) && (paramdq.ContentObj.Sqr.size() > 0))
        {
          localObject2 = (cvt)paramdq.ContentObj.Sqr.get(0);
          if (localObject2 != null) {
            ((cvt)localObject2).isAd = true;
          }
        }
        localObject1 = new ADXml((String)localObject1);
        if (paramInt == 4) {}
        try
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1697, 5);
          i = paramdq.ContentObj.Sqq;
          if (i == 15) {
            break label435;
          }
          if (i != 5) {
            break label283;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.e("TimeLineAdPreloadHelper", "reportAdType, exp=" + localThrowable.toString());
          continue;
        }
        k = 15;
        if (!((ADXml)localObject1).isFullCardAd()) {
          break label337;
        }
        if (!((ADXml)localObject1).isLongPressGestureAd()) {
          break label295;
        }
        i = 22;
        com.tencent.mm.plugin.report.service.h.IzE.el(1697, i);
        if (fLy()) {
          break label418;
        }
        Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(256304);
        return false;
        if (paramInt != 1) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(1697, 6);
        continue;
        if (i != 1) {
          break label428;
        }
      }
      catch (Throwable paramdq)
      {
        Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + paramdq.toString());
        AppMethodBeat.o(256304);
        return false;
      }
      int i = 1;
      int j = 0;
      continue;
      label295:
      if (((ADXml)localObject1).isGestureAd())
      {
        i = 23;
      }
      else if (((ADXml)localObject1).isTwistAd())
      {
        i = 24;
      }
      else
      {
        if (((ADXml)localObject1).isShakeAd())
        {
          i = 25;
          continue;
          label337:
          if (((ADXml)localObject1).isCardAd())
          {
            if (i != 0) {
              i = 9;
            }
          }
          else
          {
            if (((ADXml)localObject1).isSphereCardAd())
            {
              i = 13;
              continue;
            }
            if (!((ADXml)localObject1).isFinderTopicCard())
            {
              boolean bool = ((ADXml)localObject1).isSlideFullCard();
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
            b(paramdq, (ADXml)localObject1, paramInt);
            continue;
            i = 0;
            j = 0;
            continue;
            i = 0;
            j = 1;
          }
        }
        else
        {
          label428:
          label435:
          if (i != 0)
          {
            i = 11;
            continue;
          }
          i = k;
          if (j == 0) {
            continue;
          }
          i = 12;
          continue;
        }
        i = k;
        if (j != 0) {
          i = 10;
        }
      }
    }
  }
  
  public static String aYH(String paramString)
  {
    AppMethodBeat.i(293123);
    paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramString);
    AppMethodBeat.o(293123);
    return paramString;
  }
  
  private static void aeT(int paramInt)
  {
    AppMethodBeat.i(256307);
    try
    {
      String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
      l.a(l.JQQ, str, paramInt, 0, "");
      AppMethodBeat.o(256307);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("TimeLineAdPreloadHelper", "reportNetType, exp=" + localThrowable.toString());
      AppMethodBeat.o(256307);
    }
  }
  
  private static void b(TimeLineObject paramTimeLineObject, ADXml paramADXml, int paramInt)
  {
    AppMethodBeat.i(256308);
    Log.i("TimeLineAdPreloadHelper", "doPreload, scene=" + paramInt + ", snsId=" + paramTimeLineObject.Id);
    c(paramTimeLineObject, paramADXml);
    a(paramADXml, paramTimeLineObject.Id);
    if (paramADXml != null)
    {
      if (paramADXml.adScanJumpInfo != null) {
        a(paramADXml.adScanJumpInfo, paramTimeLineObject.Id);
      }
      if (paramADXml.adTagBtnInfo != null) {
        a(paramADXml.adTagBtnInfo, paramTimeLineObject.Id);
      }
      if (paramADXml.adLiveInfo != null) {
        a(paramADXml.adLiveInfo, paramTimeLineObject.Id);
      }
      if ((paramADXml.isShakeAd()) && (paramADXml.adShakeInfo != null) && (TextUtils.isEmpty(com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.kn(paramADXml.adShakeInfo.JNy, paramADXml.adShakeInfo.JNz)))) {
        com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.downloadPagFile(paramADXml.adShakeInfo.JNy);
      }
    }
    h.c(paramADXml);
    AppMethodBeat.o(256308);
  }
  
  private static boolean b(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(256322);
    if ((paramADXml == null) || (paramADXml.adFinderTopicInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(256322);
      return false;
    }
    try
    {
      paramADXml = paramADXml.adFinderTopicInfo.Jym;
      boolean bool = com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramADXml);
      if (bool)
      {
        AppMethodBeat.o(256322);
        return false;
      }
      paramADXml = paramADXml.iterator();
      while (paramADXml.hasNext())
      {
        e locale = (e)paramADXml.next();
        if ((locale != null) && (locale.fJE()))
        {
          a(locale.fVT, paramString);
          b(locale.fVT, paramString);
        }
      }
      Log.d("TimeLineAdPreloadHelper", "the topic card resource preloaded!");
    }
    catch (Throwable paramADXml)
    {
      Log.e("TimeLineAdPreloadHelper", "preloadTopicCardRes exp=" + paramADXml.toString());
      AppMethodBeat.o(256322);
      return false;
    }
    AppMethodBeat.o(256322);
    return true;
  }
  
  private static boolean b(final cvt paramcvt, String paramString)
  {
    AppMethodBeat.i(256313);
    String str1 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str2 = t.d(paramcvt);
    if (u.agG(str1 + str2))
    {
      Log.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + paramString + ", mediaId=" + paramcvt.Id);
      AppMethodBeat.o(256313);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(220485);
        try
        {
          Log.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + this.mhm + ", mediaId=" + paramcvt.Id);
          p localp = new p(paramcvt);
          localp.JRn = 1;
          localp.fIY = paramcvt.Id;
          c localc = aj.fOD();
          cvt localcvt = paramcvt;
          if (paramcvt.rWu == 6) {
            i = 5;
          }
          localc.a(localcvt, i, localp, bp.VGp);
          AppMethodBeat.o(220485);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + localThrowable.toString());
          AppMethodBeat.o(220485);
        }
      }
    });
    AppMethodBeat.o(256313);
    return true;
  }
  
  private static boolean c(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(256325);
    if ((paramADXml == null) || (paramADXml.adSliderFullCardInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(256325);
      return false;
    }
    for (;;)
    {
      try
      {
        Object localObject = paramADXml.adSliderFullCardInfo.Jym;
        boolean bool = com.tencent.mm.plugin.sns.ad.i.d.isEmpty((Collection)localObject);
        if (bool)
        {
          AppMethodBeat.o(256325);
          return false;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i locali = (i)((Iterator)localObject).next();
        if (locali != null) {
          if (locali.fJE())
          {
            com.tencent.mm.plugin.sns.ad.d.d.a(paramADXml, locali.fVT, paramString);
            a(locali.fVT, paramString);
            b(locali.fVT, paramString);
          }
          else
          {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.b("adId", locali.fVT.TDF, new h.a(null));
          }
        }
      }
      catch (Throwable paramADXml)
      {
        Log.e("TimeLineAdPreloadHelper", "preloadSlideFullCardRes exp = " + paramADXml.toString());
        AppMethodBeat.o(256325);
        return false;
      }
    }
    Log.d("TimeLineAdPreloadHelper", "the slide full card resource preloaded!");
    AppMethodBeat.o(256325);
    return true;
  }
  
  private static boolean c(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(256311);
    for (;;)
    {
      cvt localcvt;
      try
      {
        if (paramTimeLineObject.ContentObj.Sqq != 15)
        {
          Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(256311);
          return false;
        }
        if ((paramTimeLineObject.ContentObj.Sqr == null) || (paramTimeLineObject.ContentObj.Sqr.isEmpty()))
        {
          Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(256311);
          return false;
        }
        if (b(paramADXml, paramTimeLineObject.Id))
        {
          Log.i("TimeLineAdPreloadHelper", "the sns info is topic card info, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(256311);
          return true;
        }
        if (c(paramADXml, paramTimeLineObject.Id))
        {
          Log.i("TimeLineAdPreloadHelper", "the sns info is slide full card info, snsId = " + paramTimeLineObject.Id);
          AppMethodBeat.o(256311);
          return true;
        }
        localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
        boolean bool = b.a(paramTimeLineObject, paramADXml);
        Log.i("TimeLineAdPreloadHelper", "preloadAdVideo, isOnlineVideo=" + bool + ", snsId=" + paramTimeLineObject.Id);
        if (!bool)
        {
          if (paramADXml != null)
          {
            if (paramADXml.isFullCardAd())
            {
              Log.i("TimeLineAdPreloadHelper", "preloadAdVideo, !isOnlineVideo, isFullCard, checkH265");
              com.tencent.mm.plugin.sns.ad.d.d.a(paramADXml, localcvt, paramTimeLineObject.Id);
            }
          }
          else
          {
            a(localcvt, paramTimeLineObject.Id);
            b(localcvt, paramTimeLineObject.Id);
            AppMethodBeat.o(256311);
            return true;
          }
          Log.i("TimeLineAdPreloadHelper", "preloadAdVideo, !isOnlineVideo, !isFullCard, disableH265");
          com.tencent.mm.plugin.sns.ad.d.d.a(localcvt, false);
          continue;
        }
        com.tencent.mm.plugin.sns.ad.d.d.a(paramADXml, localcvt, paramTimeLineObject.Id);
      }
      catch (Throwable paramTimeLineObject)
      {
        Log.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + paramTimeLineObject.toString());
        AppMethodBeat.o(256311);
        return false;
      }
      b(localcvt, paramTimeLineObject.Id);
    }
  }
  
  private static boolean fLy()
  {
    AppMethodBeat.i(256309);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())) || (NetStatusUtil.is5G(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(256309);
      return true;
    }
    AppMethodBeat.o(256309);
    return false;
  }
  
  private static void g(final String paramString1, final String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(256327);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("TimeLineAdPreloadHelper", paramString3 + " url is empty, snsid=" + paramString2);
      AppMethodBeat.o(256327);
      return;
    }
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId_mm", paramString1); (!TextUtils.isEmpty(str)) && (u.agG(str)); str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramString1))
    {
      Log.i("TimeLineAdPreloadHelper", paramString3 + " file exists, snsid=" + paramString2 + ", filePath=" + str);
      AppMethodBeat.o(256327);
      return;
    }
    if (JJa.contains(paramString1))
    {
      Log.w("TimeLineAdPreloadHelper", paramString3 + " is in downloading, snsid=" + paramString2);
      AppMethodBeat.o(256327);
      return;
    }
    JJa.add(paramString1);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.sns.ad.i.a.a(paramString1, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(256598);
          Log.i("TimeLineAdPreloadHelper", this.pxm + " cdn succ, snsid=" + paramString2 + ", url=" + paramString1);
          f.JJa.remove(paramString1);
          AppMethodBeat.o(256598);
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(256596);
          Log.e("TimeLineAdPreloadHelper", this.pxm + " cdn failed, snsid=" + paramString2 + ", url=" + paramString1);
          f.JJa.remove(paramString1);
          AppMethodBeat.o(256596);
        }
      });
      AppMethodBeat.o(256327);
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString1, true, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(220168);
        Log.i("TimeLineAdPreloadHelper", this.pxm + " succ, snsid=" + paramString2 + ", url=" + paramString1);
        f.JJa.remove(paramString1);
        AppMethodBeat.o(220168);
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(220165);
        Log.e("TimeLineAdPreloadHelper", this.pxm + " failed, snsid=" + paramString2 + ", url=" + paramString1);
        f.JJa.remove(paramString1);
        AppMethodBeat.o(220165);
      }
    });
    AppMethodBeat.o(256327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.f
 * JD-Core Version:    0.7.0.1
 */