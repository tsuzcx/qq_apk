package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h.a;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.sns.ad.adxml.d.a.a;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j QXo = null;
  private static int QXq = 0;
  ConcurrentLinkedQueue<String> QXn;
  private o QXp;
  o.a QXr;
  
  private j()
  {
    AppMethodBeat.i(306745);
    this.QXn = new ConcurrentLinkedQueue();
    this.QXr = new o.a()
    {
      public final void a(o.b paramAnonymousb)
      {
        AppMethodBeat.i(306787);
        Log.d("AdLandingPageResPreloader", "onParseResItem:".concat(String.valueOf(paramAnonymousb)));
        if (paramAnonymousb.hCh == 1)
        {
          j.this.mB(paramAnonymousb.url, paramAnonymousb.desc);
          AppMethodBeat.o(306787);
          return;
        }
        if (paramAnonymousb.hCh == 2) {
          try
          {
            boolean bool = com.tencent.mm.vfs.y.ZC(k.mE("adId", paramAnonymousb.url));
            if (bool)
            {
              AppMethodBeat.o(306787);
              return;
            }
            com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b.downloadPagFile(paramAnonymousb.url);
            AppMethodBeat.o(306787);
            return;
          }
          finally
          {
            Log.e("AdLandingPageResPreloader", "onPreloadPagFile, exp=" + paramAnonymousb.toString());
          }
        }
        AppMethodBeat.o(306787);
      }
    };
    this.QXp = new o("landingPage");
    this.QXp.QXr = this.QXr;
    AppMethodBeat.o(306745);
  }
  
  private void a(String paramString, aa paramaa)
  {
    AppMethodBeat.i(306762);
    Object localObject1;
    Object localObject2;
    if (l.als(paramaa.type))
    {
      localObject1 = new ArrayList();
      if (l.alt(paramaa.type)) {
        ((List)localObject1).addAll(((am)paramaa).haE());
      }
      for (;;)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramString, (aa)((Iterator)localObject1).next());
        }
        if (l.alw(paramaa.type)) {
          ((List)localObject1).addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y)paramaa).aAO);
        } else if (l.alu(paramaa.type)) {
          ((List)localObject1).addAll(((ab)paramaa).haE());
        } else if (l.alv(paramaa.type)) {
          ((List)localObject1).addAll(((z)paramaa).haE());
        } else if (l.alx(paramaa.type)) {
          ((List)localObject1).addAll(((com.tencent.mm.plugin.sns.ad.landingpage.component.info.b)paramaa).haE());
        }
      }
      if (l.alx(paramaa.type))
      {
        paramString = (com.tencent.mm.plugin.sns.ad.landingpage.component.info.b)paramaa;
        if ((paramString.PMk != null) && (paramString.PMk.PMp != null))
        {
          localObject1 = paramString.PMk.PMp.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d.a.a)((Iterator)localObject1).next();
            if (!TextUtils.isEmpty(((d.a.a)localObject2).ADt)) {
              mB(((d.a.a)localObject2).ADt, paramString.QKH);
            }
          }
        }
        this.QXp.o(paramaa, null);
      }
      AppMethodBeat.o(306762);
      return;
    }
    Object localObject3;
    if (paramaa.QKH == 61)
    {
      localObject1 = (w)paramaa;
      e.a((w)localObject1, true);
      if (!aZF(((w)localObject1).QKp))
      {
        localObject2 = new PInt();
        localObject3 = new PInt();
        com.tencent.mm.modelcontrol.d.bId();
        if (com.tencent.mm.modelcontrol.d.a((PInt)localObject2, (PInt)localObject3))
        {
          this.QXn.add(((w)localObject1).QKp);
          if (!((w)localObject1).QKx) {
            break label442;
          }
          k.a(paramString, ((w)localObject1).QKp, true, 61, new g.a()
          {
            public final void aWn(String paramAnonymousString)
            {
              AppMethodBeat.i(306793);
              j.a(j.this, this.QXt.QKp);
              AppMethodBeat.o(306793);
            }
            
            public final void gZM() {}
            
            public final void gZN()
            {
              AppMethodBeat.i(306791);
              Log.e("AdLandingPageResPreloader", "pre download sight by http error:" + this.QXt.QKp);
              j.a(j.this, this.QXt.QKp);
              AppMethodBeat.o(306791);
            }
          });
        }
      }
      for (;;)
      {
        this.QXp.o(paramaa, null);
        AppMethodBeat.o(306762);
        return;
        label442:
        k.d(paramString, ((w)localObject1).QKp, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(306789);
            j.a(j.this, this.QXt.QKp);
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 10);
            AppMethodBeat.o(306789);
          }
          
          public final void gZM()
          {
            AppMethodBeat.i(306778);
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 9);
            AppMethodBeat.o(306778);
          }
          
          public final void gZN()
          {
            AppMethodBeat.i(306785);
            Log.e("AdLandingPageResPreloader", "pre download sight by cdn error:" + this.QXt.QKp);
            j.a(j.this, this.QXt.QKp);
            AppMethodBeat.o(306785);
          }
        });
      }
    }
    boolean bool;
    if (paramaa.QKH == 62)
    {
      int i;
      if (i.aRC().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        Log.i("AdLandingPageResPreloader", "pre down video value: ".concat(String.valueOf(bool)));
        localObject2 = (ap)paramaa;
        if ((bool) && (!aZF(((ap)localObject2).PSB)))
        {
          this.QXn.add(((ap)localObject2).PSB);
          localObject1 = ((ap)localObject2).PSB;
          i = paramaa.QKH;
          localObject2 = new d.a()
          {
            public final void GO(String paramAnonymousString)
            {
              AppMethodBeat.i(306788);
              j.a(j.this, this.QXu.PSB);
              AppMethodBeat.o(306788);
            }
            
            public final void V(String paramAnonymousString, int paramAnonymousInt) {}
            
            public final void abh(String paramAnonymousString)
            {
              AppMethodBeat.i(306784);
              Log.e("AdLandingPageResPreloader", " pre download " + this.QXu.PSB + "is error");
              j.a(j.this, this.QXu.PSB);
              AppMethodBeat.o(306784);
            }
          };
          if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString))) {
            break label610;
          }
          ((d.a)localObject2).abh("the res or adId is null");
        }
      }
      for (;;)
      {
        this.QXp.o(paramaa, null);
        AppMethodBeat.o(306762);
        return;
        bool = false;
        break;
        label610:
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject1 + " for adid:" + paramString);
        localObject3 = k.hkC();
        String str = MD5Util.getMD5String((String)localObject1);
        paramString = paramString + "_stream_" + str;
        str = (String)localObject3 + paramString;
        if (!Util.isNullOrNil(str))
        {
          if (com.tencent.mm.vfs.y.ZC(str))
          {
            Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str });
            MMHandlerThread.postToMainThread(new f.4((d.a)localObject2, str));
          }
          else
          {
            new d((String)localObject3, paramString, i, new f.5((d.a)localObject2, (String)localObject1)).execute(new Void[0]);
          }
        }
        else {
          MMHandlerThread.postToMainThread(new f.6((d.a)localObject2));
        }
      }
    }
    if (paramaa.QKH == 142)
    {
      paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)paramaa;
      bool = paramString.QJv;
      Log.i("AdLandingPageResPreloader", "pre down generalVideoInfo value: ".concat(String.valueOf(bool)));
      if ((!bool) && (paramString.preloadRatio > 0))
      {
        bool = e.gZH();
        localObject1 = e.cO(paramString.videoUrl, bool);
        localObject2 = e.cP("AdLandingGeneralVideo_" + ((String)localObject1).hashCode(), bool);
        localObject3 = k.hkC() + "AdLandingGeneralVideo_" + ((String)localObject1).hashCode() + ".mp4";
        if (aZF((String)localObject1)) {
          break label1040;
        }
        this.QXn.add(localObject1);
        Log.i("AdLandingPageResPreloader", "startDownloadingUrl, mediaId = " + (String)localObject2 + ", enableH265 = " + bool);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 7);
        AdLandingPagesProxy.getInstance().downloadLandingPageVideo((String)localObject2, (String)localObject1, (String)localObject3, 1, true, paramString.preloadRatio, new h.a()
        {
          public final void a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.d paramAnonymousd)
          {
            AppMethodBeat.i(306800);
            Log.i("AdLandingPageResPreloader", "onFinish, mediaId = " + paramAnonymousString + ", ret = " + paramAnonymousInt);
            j.a(j.this, this.Alb);
            AppMethodBeat.o(306800);
          }
          
          public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
          
          public final void h(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
          {
            AppMethodBeat.i(306795);
            Log.i("AdLandingPageResPreloader", "onProgress, mediaId = " + paramAnonymousString + ", offset = " + paramAnonymousLong1 + ", total = " + paramAnonymousLong2);
            AppMethodBeat.o(306795);
          }
          
          public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
          
          public final void onM3U8Ready(String paramAnonymousString1, String paramAnonymousString2) {}
        });
      }
      for (;;)
      {
        this.QXp.o(paramaa, null);
        AppMethodBeat.o(306762);
        return;
        label1040:
        Log.i("AdLandingPageResPreloader", "isDownloadingUrl, mediaId = " + (String)localObject2 + ", enableH265 = " + bool);
      }
    }
    this.QXp.o(paramaa, null);
    AppMethodBeat.o(306762);
  }
  
  private boolean aZF(String paramString)
  {
    try
    {
      AppMethodBeat.i(306747);
      boolean bool = this.QXn.contains(paramString);
      AppMethodBeat.o(306747);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void aZG(String paramString)
  {
    try
    {
      AppMethodBeat.i(306750);
      this.QXn.remove(paramString);
      AppMethodBeat.o(306750);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void az(String paramString1, String paramString2, int paramInt)
  {
    int i = 2;
    int j = 1;
    AppMethodBeat.i(306754);
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = new l.a(paramString1, paramString2);
        paramString2 = ((l.a)localObject1).QXz;
        paramString1 = ((l.a)localObject1).QXA;
        boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        if (!bool) {
          break label700;
        }
        switch (paramInt)
        {
        case 5: 
          Log.i("AdLandingPageResPreloader", "getPreloadLimit, isWifi=" + bool + ", scene=" + paramInt + ", pageLimit=" + j + ", resCount=" + i);
          localObject2 = new Pair(Integer.valueOf(j), Integer.valueOf(i));
          j = ((Integer)((Pair)localObject2).first).intValue();
          i = ((Integer)((Pair)localObject2).second).intValue();
          localObject2 = new StringBuilder("startPreDownloadResource, pageLimt=").append(j).append(", resLimit=").append(i).append(", scene=").append(paramInt).append(", pageCount=");
          if (paramString2 != null) {
            break label429;
          }
          paramInt = 0;
          Log.i("AdLandingPageResPreloader", paramInt);
          localObject1 = ((l.a)localObject1).QXD;
          if (localObject1 == null) {
            break label437;
          }
          Log.i("AdLandingPageResPreloader", "preload adEggAnimationInfo");
          this.QXp.o(localObject1, null);
          if ((((com.tencent.mm.plugin.sns.ad.adxml.d)localObject1).PMk == null) || (((com.tencent.mm.plugin.sns.ad.adxml.d)localObject1).PMk.PMp == null)) {
            break label437;
          }
          localObject1 = ((com.tencent.mm.plugin.sns.ad.adxml.d)localObject1).PMk.PMp.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label437;
          }
          localObject2 = (d.a.a)((Iterator)localObject1).next();
          if (TextUtils.isEmpty(((d.a.a)localObject2).ADt)) {
            continue;
          }
          mB(((d.a.a)localObject2).ADt, "adEggAnimationInfo");
          continue;
          j = i.aRC().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        }
      }
      finally
      {
        Log.e("AdLandingPageResPreloader", "startPreDownloadResource, exp=" + paramString1.toString());
        AppMethodBeat.o(306754);
        return;
      }
      i = i.aRC().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
      continue;
      j = i.aRC().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      i = i.aRC().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      continue;
      label429:
      paramInt = paramString2.size();
      continue;
      label437:
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        paramString2 = paramString2.iterator();
        paramInt = i;
        while (paramString2.hasNext())
        {
          localObject1 = (h)paramString2.next();
          mB(((h)localObject1).QXg, "pageInfo-backgroundCoverUrl");
          if ((paramInt > 0) && (j > 0))
          {
            localObject2 = ((h)localObject1).QXi.iterator();
            do
            {
              i = paramInt;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              a("adId", (aa)((Iterator)localObject2).next());
              i = paramInt - 1;
              paramInt = i;
            } while (i > 0);
            int k = j - 1;
            j = k;
            paramInt = i;
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
            {
              localObject2 = ((h)localObject1).QXj.keySet().iterator();
              for (;;)
              {
                j = k;
                paramInt = i;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                String str = (String)((Iterator)localObject2).next();
                Log.i("AdLandingPageResPreloader", "preload floatComponent, cid=".concat(String.valueOf(str)));
                a("adId", (aa)((h)localObject1).QXj.get(str));
              }
            }
          }
        }
      }
      if (paramString1 != null)
      {
        Log.i("AdLandingPageResPreloader", "preload floatBarComp");
        this.QXp.o(paramString1, null);
      }
      AppMethodBeat.o(306754);
      return;
      i = 1000;
      j = 1000;
      continue;
      switch (paramInt)
      {
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        break;
      case 5: 
        label700:
        i = 0;
        j = 0;
      }
    }
  }
  
  public static j hkB()
  {
    try
    {
      AppMethodBeat.i(306738);
      if (QXo == null) {
        QXo = new j();
      }
      j localj = QXo;
      AppMethodBeat.o(306738);
      return localj;
    }
    finally {}
  }
  
  public final void ay(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(306774);
    Log.i("AdLandingPageResPreloader", "startPreDownloadResource, preloadSize=" + QXq);
    az(paramString1, paramString2, paramInt);
    AppMethodBeat.o(306774);
  }
  
  public final void mB(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(306777);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("AdLandingPageResPreloader", "predownload img url==null, compType=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(306777);
      return;
    }
    if (aZF(paramString1))
    {
      Log.w("AdLandingPageResPreloader", "predownload img busy, compType=" + paramString2 + ", url=" + paramString1);
      AppMethodBeat.o(306777);
      return;
    }
    this.QXn.add(paramString1);
    k.b("adId", paramString1, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(306786);
        Log.d("AdLandingPageResPreloader", "predownload img succ, compType=" + paramString2 + ", url=" + paramString1);
        j.a(j.this, paramString1);
        AppMethodBeat.o(306786);
      }
      
      public final void gZM() {}
      
      public final void gZN()
      {
        AppMethodBeat.i(306779);
        Log.e("AdLandingPageResPreloader", "predownload img err, compType=" + paramString2 + ", url=" + paramString1);
        j.a(j.this, paramString1);
        AppMethodBeat.o(306779);
      }
    });
    AppMethodBeat.o(306777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */