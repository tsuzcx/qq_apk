package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.bj;
import com.tencent.mm.vfs.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class b
{
  private static Set<String> zbl;
  
  static
  {
    AppMethodBeat.i(197669);
    zbl = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(197669);
  }
  
  public static void a(b.a parama, String paramString)
  {
    AppMethodBeat.i(197666);
    if (parama != null)
    {
      av(parama.zwH, paramString, "preloadScanRes bgImage");
      av(parama.oyt, paramString, "preloadScanRes descIcon");
      av(parama.zwI, paramString, "preloadScanRes succIcon");
    }
    AppMethodBeat.o(197666);
  }
  
  private static void a(com.tencent.mm.plugin.sns.storage.b paramb, String paramString)
  {
    AppMethodBeat.i(197665);
    if ((paramb == null) || (!paramb.dWa()) || (paramb.zwp == null))
    {
      AppMethodBeat.o(197665);
      return;
    }
    if (paramb.zwp.zxn != null)
    {
      av(paramb.zwp.zxn.zWV, paramString, "preloadFullCardImage fullcardEndView.titleImage");
      av(paramb.zwp.zxn.coverImgUrl, paramString, "preloadFullCardImage fullcardEndView.coverImg");
    }
    av(paramb.zwp.zxj, paramString, "preloadFullCardImage fullcard.frontCover");
    av(paramb.zwp.zxl, paramString, "preloadFullCardImage fullcard.endCover");
    AppMethodBeat.o(197665);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb, int paramInt)
  {
    AppMethodBeat.i(197660);
    try
    {
      if (!dRV())
      {
        ad.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(197660);
        return false;
      }
      b(paramTimeLineObject, paramb, paramInt);
    }
    catch (Throwable paramTimeLineObject)
    {
      for (;;)
      {
        ad.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp=" + paramTimeLineObject.toString());
      }
    }
    AppMethodBeat.o(197660);
    return false;
  }
  
  public static boolean a(dj paramdj)
  {
    AppMethodBeat.i(197661);
    try
    {
      if (!dRV())
      {
        ad.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(197661);
        return false;
      }
      String str = z.b(paramdj.FvD.Htv.ObjectDesc);
      paramdj = z.a(paramdj.FvD.Htw);
      b(com.tencent.mm.modelsns.h.Gx(str), new com.tencent.mm.plugin.sns.storage.b(paramdj), 1);
    }
    catch (Throwable paramdj)
    {
      for (;;)
      {
        ad.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + paramdj.toString());
      }
    }
    AppMethodBeat.o(197661);
    return false;
  }
  
  private static void av(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(197667);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.w("TimeLineAdPreloadHelper", paramString3 + " url is empty, snsid=" + paramString2);
      AppMethodBeat.o(197667);
      return;
    }
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", paramString1);
    if ((!TextUtils.isEmpty(str)) && (i.fv(str)))
    {
      ad.i("TimeLineAdPreloadHelper", paramString3 + " file exists, snsid=" + paramString2);
      AppMethodBeat.o(197667);
      return;
    }
    if (zbl.contains(paramString1))
    {
      ad.w("TimeLineAdPreloadHelper", paramString3 + " is in downloading, snsid=" + paramString2);
      AppMethodBeat.o(197667);
      return;
    }
    zbl.add(paramString1);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString1, true, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(197659);
        ad.i("TimeLineAdPreloadHelper", this.lnO + " succ, snsid=" + paramString2 + ", url=" + paramString1);
        b.zbl.remove(paramString1);
        AppMethodBeat.o(197659);
      }
      
      public final void dRW() {}
      
      public final void dRX()
      {
        AppMethodBeat.i(197658);
        ad.e("TimeLineAdPreloadHelper", this.lnO + " failed, snsid=" + paramString2 + ", url=" + paramString1);
        b.zbl.remove(paramString1);
        AppMethodBeat.o(197658);
      }
    });
    AppMethodBeat.o(197667);
  }
  
  public static String axF(String paramString)
  {
    AppMethodBeat.i(221343);
    paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", paramString);
    AppMethodBeat.o(221343);
    return paramString;
  }
  
  private static void b(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb, int paramInt)
  {
    AppMethodBeat.i(197662);
    ad.i("TimeLineAdPreloadHelper", "doPreload, scene=".concat(String.valueOf(paramInt)));
    b(paramTimeLineObject, paramb);
    a(paramb, paramTimeLineObject.Id);
    if (paramb != null) {
      a(paramb.zwD, paramTimeLineObject.Id);
    }
    AppMethodBeat.o(197662);
  }
  
  private static boolean b(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb)
  {
    AppMethodBeat.i(197664);
    label361:
    for (;;)
    {
      try
      {
        if (paramTimeLineObject.HAT.GaP != 15)
        {
          ad.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(197664);
          return false;
        }
        if ((paramTimeLineObject.HAT.GaQ == null) || (paramTimeLineObject.HAT.GaQ.isEmpty()))
        {
          ad.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(197664);
          return false;
        }
        final byn localbyn = (byn)paramTimeLineObject.HAT.GaQ.get(0);
        String str1;
        if (!a.a(paramTimeLineObject, paramb))
        {
          paramb = paramTimeLineObject.Id;
          str1 = ao.jo(ag.getAccSnsPath(), localbyn.Id);
          String str2 = q.i(localbyn);
          str1 = str1 + str2;
          if (i.fv(str1)) {
            ad.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + paramb + ", mediaId=" + localbyn.Id + ", filePath=" + str1);
          }
        }
        else
        {
          paramTimeLineObject = paramTimeLineObject.Id;
          paramb = ao.jo(ag.getAccSnsPath(), localbyn.Id);
          str1 = q.d(localbyn);
          if (!i.fv(paramb + str1)) {
            break label361;
          }
          ad.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + paramTimeLineObject + ", mediaId=" + localbyn.Id);
          AppMethodBeat.o(197664);
          return true;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197656);
            try
            {
              ad.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + this.itA + ", mediaId=" + localbyn.Id);
              ag.dTZ().a(localbyn, 4, null, bj.ILV);
              AppMethodBeat.o(197656);
              return;
            }
            catch (Throwable localThrowable)
            {
              ad.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + localThrowable.toString());
              AppMethodBeat.o(197656);
            }
          }
        });
        continue;
        aq.f(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(197657);
            try
            {
              ad.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + this.itA + ", mediaId=" + localbyn.Id);
              m localm = new m(localbyn);
              localm.zds = 1;
              localm.dwW = localbyn.Id;
              com.tencent.mm.plugin.sns.model.b localb = ag.dTZ();
              byn localbyn = localbyn;
              if (localbyn.nEf == 6) {
                i = 5;
              }
              localb.a(localbyn, i, localm, bj.ILV);
              AppMethodBeat.o(197657);
              return;
            }
            catch (Throwable localThrowable)
            {
              ad.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + localThrowable.toString());
              AppMethodBeat.o(197657);
            }
          }
        });
      }
      catch (Throwable paramTimeLineObject)
      {
        ad.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + paramTimeLineObject.toString());
        AppMethodBeat.o(197664);
        return false;
      }
    }
  }
  
  private static boolean dRV()
  {
    AppMethodBeat.i(197663);
    if ((ay.isWifi(aj.getContext())) || (ay.is4G(aj.getContext())) || (ay.is5G(aj.getContext())))
    {
      AppMethodBeat.o(197663);
      return true;
    }
    AppMethodBeat.o(197663);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */