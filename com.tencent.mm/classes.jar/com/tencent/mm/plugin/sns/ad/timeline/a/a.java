package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.bf;
import com.tencent.mm.vfs.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class a
{
  private static Set<String> xLW;
  
  static
  {
    AppMethodBeat.i(200016);
    xLW = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(200016);
  }
  
  public static void a(b.a parama, String paramString)
  {
    AppMethodBeat.i(210249);
    if (parama != null)
    {
      ao(parama.ygD, paramString, "preloadScanRes bgImage");
      ao(parama.nUY, paramString, "preloadScanRes descIcon");
      ao(parama.ygE, paramString, "preloadScanRes succIcon");
    }
    AppMethodBeat.o(210249);
  }
  
  private static void a(com.tencent.mm.plugin.sns.storage.b paramb, String paramString)
  {
    AppMethodBeat.i(200014);
    if ((paramb == null) || (!paramb.dJM()) || (paramb.ygn == null))
    {
      AppMethodBeat.o(200014);
      return;
    }
    if (paramb.ygn.yhg != null)
    {
      ao(paramb.ygn.yhg.yFD, paramString, "preloadFullCardImage fullcardEndView.titleImage");
      ao(paramb.ygn.yhg.coverImgUrl, paramString, "preloadFullCardImage fullcardEndView.coverImg");
    }
    ao(paramb.ygn.yhc, paramString, "preloadFullCardImage fullcard.frontCover");
    ao(paramb.ygn.yhe, paramString, "preloadFullCardImage fullcard.endCover");
    AppMethodBeat.o(200014);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb, int paramInt)
  {
    AppMethodBeat.i(200009);
    try
    {
      if (!dFZ())
      {
        ac.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(200009);
        return false;
      }
      b(paramTimeLineObject, paramb, paramInt);
    }
    catch (Throwable paramTimeLineObject)
    {
      for (;;)
      {
        ac.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp=" + paramTimeLineObject.toString());
      }
    }
    AppMethodBeat.o(200009);
    return false;
  }
  
  public static boolean a(di paramdi)
  {
    AppMethodBeat.i(200010);
    try
    {
      if (!dFZ())
      {
        ac.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
        AppMethodBeat.o(200010);
        return false;
      }
      String str = z.b(paramdi.DQo.FIN.ObjectDesc);
      paramdi = z.a(paramdi.DQo.FIO);
      b(g.Ds(str), new com.tencent.mm.plugin.sns.storage.b(paramdi), 1);
    }
    catch (Throwable paramdi)
    {
      for (;;)
      {
        ac.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + paramdi.toString());
      }
    }
    AppMethodBeat.o(200010);
    return false;
  }
  
  public static String aCn(String paramString)
  {
    AppMethodBeat.i(210250);
    paramString = h.js("adId", paramString);
    AppMethodBeat.o(210250);
    return paramString;
  }
  
  private static void ao(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(200015);
    if (TextUtils.isEmpty(paramString1))
    {
      ac.w("TimeLineAdPreloadHelper", paramString3 + " url is empty, snsid=" + paramString2);
      AppMethodBeat.o(200015);
      return;
    }
    String str = h.js("adId", paramString1);
    if ((!TextUtils.isEmpty(str)) && (i.eA(str)))
    {
      ac.i("TimeLineAdPreloadHelper", paramString3 + " file exists, snsid=" + paramString2);
      AppMethodBeat.o(200015);
      return;
    }
    if (xLW.contains(paramString1))
    {
      ac.w("TimeLineAdPreloadHelper", paramString3 + " is in downloading, snsid=" + paramString2);
      AppMethodBeat.o(200015);
      return;
    }
    xLW.add(paramString1);
    h.a(paramString1, true, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(200008);
        ac.i("TimeLineAdPreloadHelper", this.kRn + " succ, snsid=" + paramString2 + ", url=" + paramString1);
        a.xLW.remove(paramString1);
        AppMethodBeat.o(200008);
      }
      
      public final void dFC() {}
      
      public final void dFD()
      {
        AppMethodBeat.i(200007);
        ac.e("TimeLineAdPreloadHelper", this.kRn + " failed, snsid=" + paramString2 + ", url=" + paramString1);
        a.xLW.remove(paramString1);
        AppMethodBeat.o(200007);
      }
    });
    AppMethodBeat.o(200015);
  }
  
  private static void b(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb, int paramInt)
  {
    AppMethodBeat.i(200011);
    ac.i("TimeLineAdPreloadHelper", "doPreload, scene=".concat(String.valueOf(paramInt)));
    c(paramTimeLineObject);
    a(paramb, paramTimeLineObject.Id);
    if (paramb != null) {
      a(paramb.ygA, paramTimeLineObject.Id);
    }
    AppMethodBeat.o(200011);
  }
  
  private static boolean c(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(200013);
    for (;;)
    {
      try
      {
        if (paramTimeLineObject.FQo.Ety != 15)
        {
          ac.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(200013);
          return false;
        }
        if ((paramTimeLineObject.FQo.Etz == null) || (paramTimeLineObject.FQo.Etz.isEmpty()))
        {
          ac.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(200013);
          return false;
        }
        final btz localbtz = (btz)paramTimeLineObject.FQo.Etz.get(0);
        String str1 = paramTimeLineObject.Id;
        String str2 = an.jc(af.getAccSnsPath(), localbtz.Id);
        String str3 = q.i(localbtz);
        str2 = str2 + str3;
        if (i.eA(str2))
        {
          ac.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + str1 + ", mediaId=" + localbtz.Id + ", filePath=" + str2);
          paramTimeLineObject = paramTimeLineObject.Id;
          str1 = an.jc(af.getAccSnsPath(), localbtz.Id);
          str2 = q.d(localbtz);
          if (i.eA(str1 + str2))
          {
            ac.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + paramTimeLineObject + ", mediaId=" + localbtz.Id);
            AppMethodBeat.o(200013);
            return true;
          }
        }
        else
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200005);
              try
              {
                ac.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + this.iaf + ", mediaId=" + localbtz.Id);
                af.dHM().a(localbtz, 4, null, bf.GYH);
                AppMethodBeat.o(200005);
                return;
              }
              catch (Throwable localThrowable)
              {
                ac.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + localThrowable.toString());
                AppMethodBeat.o(200005);
              }
            }
          });
          continue;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(200006);
            try
            {
              ac.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + this.iaf + ", mediaId=" + localbtz.Id);
              m localm = new m(localbtz);
              localm.xNy = 1;
              localm.dlj = localbtz.Id;
              com.tencent.mm.plugin.sns.model.b localb = af.dHM();
              btz localbtz = localbtz;
              if (localbtz.ndI == 6) {
                i = 5;
              }
              localb.a(localbtz, i, localm, bf.GYH);
              AppMethodBeat.o(200006);
              return;
            }
            catch (Throwable localThrowable)
            {
              ac.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + localThrowable.toString());
              AppMethodBeat.o(200006);
            }
          }
        });
      }
      catch (Throwable paramTimeLineObject)
      {
        ac.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + paramTimeLineObject.toString());
        AppMethodBeat.o(200013);
        return false;
      }
    }
  }
  
  private static boolean dFZ()
  {
    AppMethodBeat.i(200012);
    if ((ax.isWifi(ai.getContext())) || (ax.is4G(ai.getContext())) || (ax.is5G(ai.getContext())))
    {
      AppMethodBeat.o(200012);
      return true;
    }
    AppMethodBeat.o(200012);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */