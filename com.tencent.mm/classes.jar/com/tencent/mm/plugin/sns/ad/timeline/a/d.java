package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.o;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d
{
  private static Set<String> zrP;
  
  static
  {
    AppMethodBeat.i(219141);
    zrP = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(219141);
  }
  
  public static void a(b.b paramb, String paramString)
  {
    AppMethodBeat.i(219138);
    if (paramb != null)
    {
      av(paramb.zOg, paramString, "preloadScanRes bgImage");
      av(paramb.oEV, paramString, "preloadScanRes descIcon");
      av(paramb.zOh, paramString, "preloadScanRes succIcon");
    }
    AppMethodBeat.o(219138);
  }
  
  private static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(219137);
    if ((paramb == null) || (!paramb.dZB()) || (paramb.zNK == null))
    {
      AppMethodBeat.o(219137);
      return;
    }
    if (paramb.zNK.zOM != null)
    {
      av(paramb.zNK.zOM.Aog, paramString, "preloadFullCardImage fullcardEndView.titleImage");
      av(paramb.zNK.zOM.coverImgUrl, paramString, "preloadFullCardImage fullcardEndView.coverImg");
    }
    av(paramb.zNK.zOI, paramString, "preloadFullCardImage fullcard.frontCover");
    av(paramb.zNK.zOK, paramString, "preloadFullCardImage fullcard.endCover");
    AppMethodBeat.o(219137);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, b paramb, int paramInt)
  {
    AppMethodBeat.i(219132);
    try
    {
      if (!dVt())
      {
        ae.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(219132);
        return false;
      }
      b(paramTimeLineObject, paramb, paramInt);
    }
    catch (Throwable paramTimeLineObject)
    {
      for (;;)
      {
        ae.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp=" + paramTimeLineObject.toString());
      }
    }
    AppMethodBeat.o(219132);
    return false;
  }
  
  public static boolean a(dj paramdj)
  {
    AppMethodBeat.i(219133);
    try
    {
      if (!dVt())
      {
        ae.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(219133);
        return false;
      }
      String str = z.b(paramdj.FOb.HMY.ObjectDesc);
      paramdj = z.a(paramdj.FOb.HMZ);
      b(com.tencent.mm.modelsns.h.GZ(str), new b(paramdj), 1);
    }
    catch (Throwable paramdj)
    {
      for (;;)
      {
        ae.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + paramdj.toString());
      }
    }
    AppMethodBeat.o(219133);
    return false;
  }
  
  private static void av(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(219139);
    if (TextUtils.isEmpty(paramString1))
    {
      ae.w("TimeLineAdPreloadHelper", paramString3 + " url is empty, snsid=" + paramString2);
      AppMethodBeat.o(219139);
      return;
    }
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramString1);
    if ((!TextUtils.isEmpty(str)) && (o.fB(str)))
    {
      ae.i("TimeLineAdPreloadHelper", paramString3 + " file exists, snsid=" + paramString2);
      AppMethodBeat.o(219139);
      return;
    }
    if (zrP.contains(paramString1))
    {
      ae.w("TimeLineAdPreloadHelper", paramString3 + " is in downloading, snsid=" + paramString2);
      AppMethodBeat.o(219139);
      return;
    }
    zrP.add(paramString1);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString1, true, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(219131);
        ae.i("TimeLineAdPreloadHelper", this.lso + " succ, snsid=" + paramString2 + ", url=" + paramString1);
        d.zrP.remove(paramString1);
        AppMethodBeat.o(219131);
      }
      
      public final void dVu() {}
      
      public final void dVv()
      {
        AppMethodBeat.i(219130);
        ae.e("TimeLineAdPreloadHelper", this.lso + " failed, snsid=" + paramString2 + ", url=" + paramString1);
        d.zrP.remove(paramString1);
        AppMethodBeat.o(219130);
      }
    });
    AppMethodBeat.o(219139);
  }
  
  public static String ayX(String paramString)
  {
    AppMethodBeat.i(224102);
    paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramString);
    AppMethodBeat.o(224102);
    return paramString;
  }
  
  private static void b(TimeLineObject paramTimeLineObject, b paramb, int paramInt)
  {
    AppMethodBeat.i(219134);
    ae.i("TimeLineAdPreloadHelper", "doPreload, scene=".concat(String.valueOf(paramInt)));
    b(paramTimeLineObject, paramb);
    a(paramb, paramTimeLineObject.Id);
    if (paramb != null) {
      a(paramb.zNZ, paramTimeLineObject.Id);
    }
    AppMethodBeat.o(219134);
  }
  
  private static boolean b(TimeLineObject paramTimeLineObject, b paramb)
  {
    AppMethodBeat.i(219136);
    label361:
    for (;;)
    {
      try
      {
        if (paramTimeLineObject.HUG.Gtw != 15)
        {
          ae.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(219136);
          return false;
        }
        if ((paramTimeLineObject.HUG.Gtx == null) || (paramTimeLineObject.HUG.Gtx.isEmpty()))
        {
          ae.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(219136);
          return false;
        }
        final bzh localbzh = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
        String str1;
        if (!a.a(paramTimeLineObject, paramb))
        {
          paramb = paramTimeLineObject.Id;
          str1 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
          String str2 = r.i(localbzh);
          str1 = str1 + str2;
          if (o.fB(str1)) {
            ae.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + paramb + ", mediaId=" + localbzh.Id + ", filePath=" + str1);
          }
        }
        else
        {
          paramTimeLineObject = paramTimeLineObject.Id;
          paramb = ap.jv(ah.getAccSnsPath(), localbzh.Id);
          str1 = r.d(localbzh);
          if (!o.fB(paramb + str1)) {
            break label361;
          }
          ae.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + paramTimeLineObject + ", mediaId=" + localbzh.Id);
          AppMethodBeat.o(219136);
          return true;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219128);
            try
            {
              ae.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + this.iwu + ", mediaId=" + localbzh.Id);
              ah.dXz().a(localbzh, 4, null, bk.JgC);
              AppMethodBeat.o(219128);
              return;
            }
            catch (Throwable localThrowable)
            {
              ae.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + localThrowable.toString());
              AppMethodBeat.o(219128);
            }
          }
        });
        continue;
        ar.f(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(219129);
            try
            {
              ae.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + this.iwu + ", mediaId=" + localbzh.Id);
              n localn = new n(localbzh);
              localn.zui = 1;
              localn.dyb = localbzh.Id;
              c localc = ah.dXz();
              bzh localbzh = localbzh;
              if (localbzh.nJA == 6) {
                i = 5;
              }
              localc.a(localbzh, i, localn, bk.JgC);
              AppMethodBeat.o(219129);
              return;
            }
            catch (Throwable localThrowable)
            {
              ae.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + localThrowable.toString());
              AppMethodBeat.o(219129);
            }
          }
        });
      }
      catch (Throwable paramTimeLineObject)
      {
        ae.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + paramTimeLineObject.toString());
        AppMethodBeat.o(219136);
        return false;
      }
    }
  }
  
  private static boolean dVt()
  {
    AppMethodBeat.i(219135);
    if ((az.isWifi(ak.getContext())) || (az.is4G(ak.getContext())) || (az.is5G(ak.getContext())))
    {
      AppMethodBeat.o(219135);
      return true;
    }
    AppMethodBeat.o(219135);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */