package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.e.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class e
{
  private static Set<String> DyR;
  
  static
  {
    AppMethodBeat.i(202226);
    DyR = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(202226);
  }
  
  public static void a(ADXml.b paramb, String paramString)
  {
    AppMethodBeat.i(202222);
    if (paramb != null)
    {
      aG(paramb.DWj, paramString, "preloadScanRes bgImage");
      aG(paramb.pSE, paramString, "preloadScanRes descIcon");
      aG(paramb.DWk, paramString, "preloadScanRes succIcon");
    }
    AppMethodBeat.o(202222);
  }
  
  private static void a(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(202221);
    if ((paramADXml == null) || (!paramADXml.isFullCardAd()) || (paramADXml.adFullCardInfo == null))
    {
      AppMethodBeat.o(202221);
      return;
    }
    if (paramADXml.adFullCardInfo.DWE != null)
    {
      aG(paramADXml.adFullCardInfo.DWE.EwR, paramString, "preloadFullCardImage fullcardEndView.titleImage");
      aG(paramADXml.adFullCardInfo.DWE.coverImgUrl, paramString, "preloadFullCardImage fullcardEndView.coverImg");
    }
    aG(paramADXml.adFullCardInfo.DWA, paramString, "preloadFullCardImage fullcard.frontCover");
    aG(paramADXml.adFullCardInfo.DWC, paramString, "preloadFullCardImage fullcard.endCover");
    AppMethodBeat.o(202221);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, ADXml paramADXml, int paramInt)
  {
    AppMethodBeat.i(202214);
    try
    {
      if (!eXV())
      {
        Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(202214);
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
    AppMethodBeat.o(202214);
    return false;
  }
  
  private static boolean a(final cnb paramcnb, String paramString)
  {
    AppMethodBeat.i(202219);
    String str1 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str2 = r.j(paramcnb);
    str1 = str1 + str2;
    if (s.YS(str1))
    {
      Log.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + paramString + ", mediaId=" + paramcnb.Id + ", filePath=" + str1);
      AppMethodBeat.o(202219);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202210);
        try
        {
          Log.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + this.jrJ + ", mediaId=" + paramcnb.Id);
          aj.faJ().a(paramcnb, 4, null, bp.Oqt);
          AppMethodBeat.o(202210);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + localThrowable.toString());
          AppMethodBeat.o(202210);
        }
      }
    });
    AppMethodBeat.o(202219);
    return true;
  }
  
  public static boolean a(ds paramds)
  {
    AppMethodBeat.i(202215);
    try
    {
      if (!eXV())
      {
        Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(202215);
        return false;
      }
      String str = z.b(paramds.KHG.MYH.ObjectDesc);
      paramds = z.a(paramds.KHG.MYI);
      b(com.tencent.mm.modelsns.n.PM(str), new ADXml(paramds), 1);
    }
    catch (Throwable paramds)
    {
      for (;;)
      {
        Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + paramds.toString());
      }
    }
    AppMethodBeat.o(202215);
    return false;
  }
  
  private static void aG(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(202224);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("TimeLineAdPreloadHelper", paramString3 + " url is empty, snsid=" + paramString2);
      AppMethodBeat.o(202224);
      return;
    }
    String str = h.kz("adId", paramString1);
    if ((!TextUtils.isEmpty(str)) && (s.YS(str)))
    {
      Log.i("TimeLineAdPreloadHelper", paramString3 + " file exists, snsid=" + paramString2);
      AppMethodBeat.o(202224);
      return;
    }
    if (DyR.contains(paramString1))
    {
      Log.w("TimeLineAdPreloadHelper", paramString3 + " is in downloading, snsid=" + paramString2);
      AppMethodBeat.o(202224);
      return;
    }
    DyR.add(paramString1);
    h.a(paramString1, true, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(202213);
        Log.i("TimeLineAdPreloadHelper", this.myS + " succ, snsid=" + paramString2 + ", url=" + paramString1);
        e.DyR.remove(paramString1);
        AppMethodBeat.o(202213);
      }
      
      public final void eWN() {}
      
      public final void eWO()
      {
        AppMethodBeat.i(202212);
        Log.e("TimeLineAdPreloadHelper", this.myS + " failed, snsid=" + paramString2 + ", url=" + paramString1);
        e.DyR.remove(paramString1);
        AppMethodBeat.o(202212);
      }
    });
    AppMethodBeat.o(202224);
  }
  
  public static String aNR(String paramString)
  {
    AppMethodBeat.i(258594);
    paramString = h.kz("adId", paramString);
    AppMethodBeat.o(258594);
    return paramString;
  }
  
  private static void b(TimeLineObject paramTimeLineObject, ADXml paramADXml, int paramInt)
  {
    AppMethodBeat.i(202216);
    Log.i("TimeLineAdPreloadHelper", "doPreload, scene=".concat(String.valueOf(paramInt)));
    b(paramTimeLineObject, paramADXml);
    a(paramADXml, paramTimeLineObject.Id);
    if (paramADXml != null) {
      a(paramADXml.adScanJumpInfo, paramTimeLineObject.Id);
    }
    AppMethodBeat.o(202216);
  }
  
  private static boolean b(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(202223);
    if ((paramADXml == null) || (paramADXml.adFinderTopicInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(202223);
      return false;
    }
    try
    {
      paramADXml = paramADXml.adFinderTopicInfo.DrS;
      boolean bool = com.tencent.mm.plugin.sns.ad.i.c.isEmpty(paramADXml);
      if (bool)
      {
        AppMethodBeat.o(202223);
        return false;
      }
      paramADXml = paramADXml.iterator();
      while (paramADXml.hasNext())
      {
        com.tencent.mm.plugin.sns.ad.a.e locale = (com.tencent.mm.plugin.sns.ad.a.e)paramADXml.next();
        if ((locale != null) && (locale.eWB()))
        {
          a(locale.ebR, paramString);
          b(locale.ebR, paramString);
        }
      }
      Log.d("TimeLineAdPreloadHelper", "the topic card resource preloaded!");
    }
    catch (Throwable paramADXml)
    {
      Log.e("TimeLineAdPreloadHelper", "preloadTopicCardRes exp=" + paramADXml.toString());
      AppMethodBeat.o(202223);
      return false;
    }
    AppMethodBeat.o(202223);
    return true;
  }
  
  private static boolean b(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(202218);
    try
    {
      if (paramTimeLineObject.ContentObj.LoU != 15)
      {
        Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
        AppMethodBeat.o(202218);
        return false;
      }
      if ((paramTimeLineObject.ContentObj.LoV == null) || (paramTimeLineObject.ContentObj.LoV.isEmpty()))
      {
        Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
        AppMethodBeat.o(202218);
        return false;
      }
      if (b(paramADXml, paramTimeLineObject.Id))
      {
        Log.i("TimeLineAdPreloadHelper", "the sns info is topic card info, snsId=" + paramTimeLineObject.Id);
        AppMethodBeat.o(202218);
        return true;
      }
      cnb localcnb = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
      boolean bool = a.a(paramTimeLineObject, paramADXml);
      Log.i("TimeLineAdPreloadHelper", "AdH265Helper, preloadAdVideo, isOnlineVideo=".concat(String.valueOf(bool)));
      b.a(paramADXml, localcnb, paramTimeLineObject.Id);
      if (!bool) {
        a(localcnb, paramTimeLineObject.Id);
      }
      b(localcnb, paramTimeLineObject.Id);
      AppMethodBeat.o(202218);
      return true;
    }
    catch (Throwable paramTimeLineObject)
    {
      Log.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + paramTimeLineObject.toString());
      AppMethodBeat.o(202218);
    }
    return false;
  }
  
  private static boolean b(final cnb paramcnb, String paramString)
  {
    AppMethodBeat.i(202220);
    String str1 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str2 = r.e(paramcnb);
    if (s.YS(str1 + str2))
    {
      Log.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + paramString + ", mediaId=" + paramcnb.Id);
      AppMethodBeat.o(202220);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(202211);
        try
        {
          Log.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + this.jrJ + ", mediaId=" + paramcnb.Id);
          com.tencent.mm.plugin.sns.data.n localn = new com.tencent.mm.plugin.sns.data.n(paramcnb);
          localn.DEs = 1;
          localn.dPI = paramcnb.Id;
          com.tencent.mm.plugin.sns.model.c localc = aj.faJ();
          cnb localcnb = paramcnb;
          if (paramcnb.oUv == 6) {
            i = 5;
          }
          localc.a(localcnb, i, localn, bp.Oqt);
          AppMethodBeat.o(202211);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + localThrowable.toString());
          AppMethodBeat.o(202211);
        }
      }
    });
    AppMethodBeat.o(202220);
    return true;
  }
  
  private static boolean eXV()
  {
    AppMethodBeat.i(202217);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())) || (NetStatusUtil.is5G(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(202217);
      return true;
    }
    AppMethodBeat.o(202217);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.e
 * JD-Core Version:    0.7.0.1
 */