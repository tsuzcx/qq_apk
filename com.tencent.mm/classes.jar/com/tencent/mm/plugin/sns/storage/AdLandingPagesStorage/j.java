package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b.a;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b.a.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j KyF;
  ConcurrentLinkedQueue<String> KyE;
  
  static
  {
    AppMethodBeat.i(97391);
    KyF = new j();
    AppMethodBeat.o(97391);
  }
  
  private j()
  {
    AppMethodBeat.i(97385);
    this.KyE = new ConcurrentLinkedQueue();
    AppMethodBeat.o(97385);
  }
  
  private void O(String paramString1, final int paramInt, final String paramString2)
  {
    AppMethodBeat.i(218556);
    if (TextUtils.isEmpty(paramString2))
    {
      Log.w("AdLandingPagesPreDownloadResHelper", "predownload imgUrl==null, compType=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(218556);
      return;
    }
    if (bbg(paramString2))
    {
      Log.w("AdLandingPagesPreDownloadResHelper", "predownload img busy, compType=" + paramInt + ", url=" + paramString2);
      AppMethodBeat.o(218556);
      return;
    }
    this.KyE.add(paramString2);
    h.a(paramString1, paramString2, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(244169);
        Log.d("AdLandingPagesPreDownloadResHelper", "predownload img succ, compType=" + paramInt + ", url=" + paramString2);
        j.a(j.this, paramString2);
        AppMethodBeat.o(244169);
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(244167);
        Log.e("AdLandingPagesPreDownloadResHelper", "predownload img err, compType=" + paramInt + ", url=" + paramString2);
        j.a(j.this, paramString2);
        AppMethodBeat.o(244167);
      }
    });
    AppMethodBeat.o(218556);
  }
  
  public static void a(final dq paramdq, final boolean paramBoolean)
  {
    AppMethodBeat.i(218558);
    String str = com.tencent.mm.platformtools.z.a(paramdq.RIZ.Ulc);
    if (!Util.isNullOrNil(str)) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(225946);
          int i;
          Object localObject;
          if ((new ADXml(this.KyM).isLandingPagesAd()) && (i.bbf(this.KyM)))
          {
            i = 0;
            if (paramBoolean) {
              i = 6;
            }
            localObject = "";
          }
          try
          {
            str = com.tencent.mm.plugin.sns.data.t.Qu(paramdq.RIZ.Ulb.Id);
            localObject = str;
          }
          catch (Exception localException)
          {
            String str;
            label66:
            break label66;
          }
          Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages, scene=" + i + ", snsId=" + (String)localObject);
          j.fSt().g("adId", this.KyM, "adxml", i);
          str = ADXml.getGestureCanvasInfo(this.KyM);
          if (i.bbf(str))
          {
            i = 1;
            if (paramBoolean) {
              i = 7;
            }
            Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages for gestureAdXml, scene=" + i + ", snsId=" + (String)localObject);
            j.fSt().g("adId", str, "adxml", i);
          }
          AppMethodBeat.o(225946);
        }
      }, "predownloadAdLandingPages");
    }
    AppMethodBeat.o(218558);
  }
  
  private void a(final String paramString, final aa paramaa)
  {
    AppMethodBeat.i(97387);
    Object localObject1;
    Object localObject2;
    if (i.agz(paramaa.type))
    {
      localObject1 = new ArrayList();
      if (i.agA(paramaa.type)) {
        ((List)localObject1).addAll(((al)paramaa).fKw());
      }
      for (;;)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramString, (aa)((Iterator)localObject1).next());
        }
        if (i.agD(paramaa.type)) {
          ((List)localObject1).addAll(((y)paramaa).ayS);
        } else if (i.agB(paramaa.type)) {
          ((List)localObject1).addAll(((ab)paramaa).fKw());
        } else if (i.agC(paramaa.type)) {
          ((List)localObject1).addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)paramaa).fKw());
        } else if (i.agE(paramaa.type)) {
          ((List)localObject1).addAll(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)paramaa).fKw());
        }
      }
      if (i.agE(paramaa.type))
      {
        paramaa = (com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)paramaa;
        O(paramString, paramaa.KmC, paramaa.JBF);
        if (paramaa.JBH != null)
        {
          if (TextUtils.isEmpty(com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.kn(paramaa.JBH.JBJ, paramaa.JBH.JBK))) {
            com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.downloadPagFile(paramaa.JBH.JBJ);
          }
          if (paramaa.JBH.JBI != null)
          {
            localObject1 = paramaa.JBH.JBI.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b.a.a)((Iterator)localObject1).next();
              if (!TextUtils.isEmpty(((b.a.a)localObject2).xei)) {
                O(paramString, paramaa.KmC, ((b.a.a)localObject2).xei);
              }
            }
          }
        }
      }
      AppMethodBeat.o(97387);
      return;
    }
    if (paramaa.KmC == 41)
    {
      paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa;
      if (bbg(paramaa.Kmf))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.KyE.add(paramaa.Kmf);
      h.a(paramString, paramaa.Kmf, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(97361);
          j.a(j.this, paramaa.Kmf);
          AppMethodBeat.o(97361);
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(97360);
          Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramaa.Kmf + "is error");
          j.a(j.this, paramaa.Kmf);
          AppMethodBeat.o(97360);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramaa.KmC == 143)
    {
      paramaa = (com.tencent.mm.plugin.sns.ad.landingpage.component.b.f)paramaa;
      O(paramString, paramaa.KmC, paramaa.JBS);
      O(paramString, paramaa.KmC, paramaa.JBT);
      O(paramString, paramaa.KmC, paramaa.JBU);
      O(paramString, paramaa.KmC, paramaa.JBW);
      AppMethodBeat.o(97387);
      return;
    }
    if (paramaa.KmC == 44)
    {
      paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramaa;
      if (bbg(paramaa.Kmf))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.KyE.add(paramaa.Kmf);
      h.a(paramString, paramaa.Kmf, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(97368);
          j.a(j.this, paramaa.Kmf);
          AppMethodBeat.o(97368);
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(97367);
          Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramaa.Kmf + "is error");
          j.a(j.this, paramaa.Kmf);
          AppMethodBeat.o(97367);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramaa.KmC == 45)
    {
      paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa;
      if (bbg(paramaa.Kmf))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.KyE.add(paramaa.Kmf);
      h.a(paramString, paramaa.Kmf, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(97370);
          j.a(j.this, paramaa.Kmf);
          AppMethodBeat.o(97370);
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(97369);
          Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramaa.Kmf + "is error");
          j.a(j.this, paramaa.Kmf);
          AppMethodBeat.o(97369);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramaa.KmC == 61)
    {
      paramaa = (w)paramaa;
      com.tencent.mm.plugin.sns.ad.d.d.a(paramaa, true);
      if (!bbg(paramaa.Kml))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        com.tencent.mm.modelcontrol.d.bkm();
        if (com.tencent.mm.modelcontrol.d.a((PInt)localObject1, (PInt)localObject2))
        {
          this.KyE.add(paramaa.Kml);
          if (paramaa.Kms) {
            break label762;
          }
          h.a(paramString, paramaa.Kml, true, 61, new f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(97372);
              j.a(j.this, paramaa.Kml);
              AppMethodBeat.o(97372);
            }
            
            public final void fJU() {}
            
            public final void fJV()
            {
              AppMethodBeat.i(97371);
              Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + paramaa.Kml);
              j.a(j.this, paramaa.Kml);
              AppMethodBeat.o(97371);
            }
          });
        }
      }
      for (;;)
      {
        if (!bbg(paramaa.Kmm))
        {
          this.KyE.add(paramaa.Kmm);
          h.a(paramString, paramaa.Kmm, new f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(194603);
              j.a(j.this, paramaa.Kmm);
              AppMethodBeat.o(194603);
            }
            
            public final void fJU() {}
            
            public final void fJV()
            {
              AppMethodBeat.i(194602);
              Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + paramaa.Kmm);
              j.a(j.this, paramaa.Kmm);
              AppMethodBeat.o(194602);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        label762:
        h.c(paramString, paramaa.Kml, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(97374);
            j.a(j.this, paramaa.Kml);
            AppMethodBeat.o(97374);
          }
          
          public final void fJU() {}
          
          public final void fJV()
          {
            AppMethodBeat.i(97373);
            Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + paramaa.Kml);
            j.a(j.this, paramaa.Kml);
            AppMethodBeat.o(97373);
          }
        });
      }
    }
    boolean bool;
    if (paramaa.KmC == 62)
    {
      int i;
      if (com.tencent.mm.n.h.axc().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        Log.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (an)paramaa;
        if ((bool) && (!bbg(((an)localObject1).JCf)))
        {
          this.KyE.add(((an)localObject1).JCf);
          localObject2 = ((an)localObject1).JCf;
          i = paramaa.KmC;
          paramaa = new c.a()
          {
            public final void Oy(String paramAnonymousString)
            {
              AppMethodBeat.i(267243);
              j.a(j.this, this.KyS.JCf);
              AppMethodBeat.o(267243);
            }
            
            public final void aij(String paramAnonymousString)
            {
              AppMethodBeat.i(267242);
              Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.KyS.JCf + "is error");
              j.a(j.this, this.KyS.JCf);
              AppMethodBeat.o(267242);
            }
            
            public final void dT(String paramAnonymousString, int paramAnonymousInt) {}
          };
          if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(paramString))) {
            break label964;
          }
          paramaa.aij("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!bbg(((an)localObject1).Knz))
        {
          this.KyE.add(((an)localObject1).Knz);
          h.a("adId", ((an)localObject1).Knz, new f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(97381);
              j.a(j.this, this.KyS.Knz);
              AppMethodBeat.o(97381);
            }
            
            public final void fJU()
            {
              AppMethodBeat.i(97379);
              AppMethodBeat.o(97379);
            }
            
            public final void fJV()
            {
              AppMethodBeat.i(97380);
              Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.KyS.Knz + "is error");
              j.a(j.this, this.KyS.JCf);
              AppMethodBeat.o(97380);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        bool = false;
        break;
        label964:
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str2 = h.fSq();
        String str3 = MD5Util.getMD5String((String)localObject2);
        paramString = paramString + "_stream_" + str3;
        str3 = str2 + paramString;
        if (!Util.isNullOrNil(str3))
        {
          if (com.tencent.mm.vfs.u.agG(str3))
          {
            Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str3 });
            MMHandlerThread.postToMainThread(new e.4(paramaa, str3));
          }
          else
          {
            new c(str2, paramString, i, new e.5(paramaa, (String)localObject2)).execute(new Void[0]);
          }
        }
        else {
          MMHandlerThread.postToMainThread(new e.6(paramaa));
        }
      }
    }
    if (paramaa.KmC == 133)
    {
      localObject1 = (v)paramaa;
      localObject2 = ((v)localObject1).KjX;
      paramaa = ((v)localObject1).Kmj;
      localObject1 = ((v)localObject1).Kmk;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!bbg((String)localObject2)))
        {
          this.KyE.add(localObject2);
          h.a(paramString, (String)localObject2, new f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(97384);
              j.a(j.this, this.KyT);
              Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.KyT);
              AppMethodBeat.o(97384);
            }
            
            public final void fJU()
            {
              AppMethodBeat.i(97382);
              Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
              AppMethodBeat.o(97382);
            }
            
            public final void fJV()
            {
              AppMethodBeat.i(97383);
              Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.KyT);
              j.a(j.this, this.KyT);
              AppMethodBeat.o(97383);
            }
          });
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          for (;;)
          {
            if ((!TextUtils.isEmpty(paramaa)) && (!bbg(paramaa)))
            {
              this.KyE.add(paramaa);
              h.a(paramString, paramaa, new f.a()
              {
                public final void aYs(String paramAnonymousString)
                {
                  AppMethodBeat.i(97364);
                  j.a(j.this, paramaa);
                  Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + paramaa);
                  AppMethodBeat.o(97364);
                }
                
                public final void fJU()
                {
                  AppMethodBeat.i(97362);
                  Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
                  AppMethodBeat.o(97362);
                }
                
                public final void fJV()
                {
                  AppMethodBeat.i(97363);
                  Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + paramaa);
                  j.a(j.this, paramaa);
                  AppMethodBeat.o(97363);
                }
              });
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!bbg((String)localObject1)))
              {
                this.KyE.add(localObject1);
                h.a(paramString, (String)localObject1, new f.a()
                {
                  public final void aYs(String paramAnonymousString)
                  {
                    AppMethodBeat.i(97366);
                    j.a(j.this, this.KyJ);
                    Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.KyJ);
                    AppMethodBeat.o(97366);
                  }
                  
                  public final void fJU()
                  {
                    AppMethodBeat.i(268260);
                    Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
                    AppMethodBeat.o(268260);
                  }
                  
                  public final void fJV()
                  {
                    AppMethodBeat.i(97365);
                    Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.KyJ);
                    j.a(j.this, this.KyJ);
                    AppMethodBeat.o(97365);
                  }
                });
              }
              AppMethodBeat.o(97387);
              return;
            }
            catch (Throwable paramString)
            {
              Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl exp=" + paramString.toString());
              AppMethodBeat.o(97387);
              return;
            }
            localThrowable = localThrowable;
            Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download sphereImageUrl expl=" + localThrowable.toString());
          }
        }
        catch (Throwable paramaa)
        {
          for (;;)
          {
            Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl exp=" + paramaa.toString());
          }
        }
      }
    }
    if (paramaa.KmC == 142)
    {
      paramString = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)paramaa;
      bool = paramString.Klo;
      Log.i("AdLandingPagesPreDownloadResHelper", "pre down generalVideoInfo value: ".concat(String.valueOf(bool)));
      if ((!bool) && (paramString.preloadRatio > 0))
      {
        bool = com.tencent.mm.plugin.sns.ad.d.d.fJQ();
        paramaa = com.tencent.mm.plugin.sns.ad.d.d.co(paramString.videoUrl, bool);
        localObject1 = com.tencent.mm.plugin.sns.ad.d.d.cp("AdLandingGeneralVideo_" + paramaa.hashCode(), bool);
        String str1 = h.fSq() + "AdLandingGeneralVideo_" + paramaa.hashCode() + ".mp4";
        if (bbg(paramaa)) {
          break label1667;
        }
        this.KyE.add(paramaa);
        Log.i("AdLandingPagesPreDownloadResHelper", "startDownloadingUrl, mediaId = " + (String)localObject1 + ", enableH265 = " + bool);
        AdLandingPagesProxy.getInstance().downloadLandingPageVideo((String)localObject1, paramaa, str1, 1, true, paramString.preloadRatio, new h.a()
        {
          public final void Kj(String paramAnonymousString) {}
          
          public final void a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.d paramAnonymousd)
          {
            AppMethodBeat.i(220965);
            Log.i("AdLandingPagesPreDownloadResHelper", "onFinish, mediaId = " + paramAnonymousString + ", ret = " + paramAnonymousInt);
            j.a(j.this, paramaa);
            AppMethodBeat.o(220965);
          }
          
          public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
          
          public final void h(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
          {
            AppMethodBeat.i(220957);
            Log.i("AdLandingPagesPreDownloadResHelper", "onProgress, mediaId = " + paramAnonymousString + ", offset = " + paramAnonymousLong1 + ", total = " + paramAnonymousLong2);
            AppMethodBeat.o(220957);
          }
          
          public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
        });
      }
    }
    for (;;)
    {
      if (!bbg(paramString.thumbUrl))
      {
        this.KyE.add(paramString.thumbUrl);
        h.a("adId", paramString.thumbUrl, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(196404);
            j.a(j.this, paramString.thumbUrl);
            AppMethodBeat.o(196404);
          }
          
          public final void fJU() {}
          
          public final void fJV()
          {
            AppMethodBeat.i(196403);
            Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString.thumbUrl + "is error");
            j.a(j.this, paramString.thumbUrl);
            AppMethodBeat.o(196403);
          }
        });
      }
      AppMethodBeat.o(97387);
      return;
      label1667:
      Log.i("AdLandingPagesPreDownloadResHelper", "isDownloadingUrl, mediaId = " + (String)localObject1 + ", enableH265 = " + bool);
    }
  }
  
  public static void bM(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(218561);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(218561);
      return;
    }
    n localn = aj.fOI();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject = (SnsObject)paramLinkedList.get(i);
      SnsInfo localSnsInfo;
      if (localObject != null)
      {
        localSnsInfo = localn.Rd(((SnsObject)localObject).Id);
        if (localSnsInfo != null)
        {
          localObject = localSnsInfo.getTimeLine();
          if (localObject != null) {
            break label106;
          }
        }
      }
      label106:
      for (localObject = "";; localObject = ((TimeLineObject)localObject).canvasInfo)
      {
        if (!Util.isNullOrNil((String)localObject)) {
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(269728);
              if (i.bbf(this.KyP))
              {
                Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, snsId=" + this.mhm);
                j.fSt().g("adId", this.KyP, "adxml", 4);
                AppMethodBeat.o(269728);
                return;
              }
              Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, invalid canvas, snsId=" + this.mhm);
              AppMethodBeat.o(269728);
            }
          }, "preDownloadAdLandingPagesForSnsObject");
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(218561);
  }
  
  private boolean bbg(String paramString)
  {
    AppMethodBeat.i(97386);
    boolean bool = this.KyE.contains(paramString);
    AppMethodBeat.o(97386);
    return bool;
  }
  
  private void bbh(final String paramString)
  {
    AppMethodBeat.i(97388);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    if (bbg(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    this.KyE.add(paramString);
    h.a("adId", paramString, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(210930);
        j.a(j.this, paramString);
        AppMethodBeat.o(210930);
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(210929);
        Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString + "is error");
        j.a(j.this, paramString);
        AppMethodBeat.o(210929);
      }
    });
    AppMethodBeat.o(97388);
  }
  
  public static void bbi(String paramString)
  {
    AppMethodBeat.i(218563);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218563);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226578);
        if (i.bbf(this.KyP))
        {
          Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForMsg");
          j.fSt().g("adId", this.KyP, "adxml", 5);
          AppMethodBeat.o(226578);
          return;
        }
        Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForMsg, invalid canvas");
        AppMethodBeat.o(226578);
      }
    }, "preDownloadAdLandingPagesForMsg");
    AppMethodBeat.o(218563);
  }
  
  public static void bbj(String paramString)
  {
    AppMethodBeat.i(218565);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218565);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267596);
        if (i.bbf(this.KyP))
        {
          Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg");
          j.fSt().g("adId", this.KyP, "adxml", 2);
          String str = ADXml.getGestureCanvasInfo(this.KyP);
          if (i.bbf(str))
          {
            Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg for gestureAdXml");
            j.fSt().g("adId", str, "adxml", 3);
          }
          AppMethodBeat.o(267596);
          return;
        }
        Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg, inValidCanvas");
        AppMethodBeat.o(267596);
      }
    }, "preDownloadAdLandingPagesForAtMsg");
    AppMethodBeat.o(218565);
  }
  
  public static void f(LinkedList<dq> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(218557);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(218557);
      return;
    }
    int i = 0;
    while (i < paramLinkedList.size())
    {
      a((dq)paramLinkedList.get(i), paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(218557);
  }
  
  public static j fSt()
  {
    return KyF;
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = 2;
    int j = 1;
    int k = 0;
    AppMethodBeat.i(97389);
    for (;;)
    {
      try
      {
        paramString2 = new i.a(paramString2, paramString3);
        paramString3 = paramString2.Kyx;
        paramString2 = paramString2.Kyy;
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
          break label563;
        }
        switch (paramInt)
        {
        case 5: 
          Object localObject = new Pair(Integer.valueOf(j), Integer.valueOf(i));
          j = ((Integer)((Pair)localObject).first).intValue();
          i = ((Integer)((Pair)localObject).second).intValue();
          localObject = new StringBuilder("startPreDownloadResource, pageLimt=").append(j).append(", resLimit=").append(i).append(", scene=").append(paramInt).append(", pageCount=");
          if (paramString3 != null) {
            break label486;
          }
          paramInt = k;
          Log.i("AdLandingPagesPreDownloadResHelper", paramInt);
          if ((paramString3 == null) || (paramString3.size() <= 0)) {
            break label495;
          }
          paramString3 = paramString3.iterator();
          paramInt = i;
          if (!paramString3.hasNext()) {
            break label495;
          }
          localObject = (g)paramString3.next();
          bbh(((g)localObject).Kyn);
          if ((paramInt <= 0) || (j <= 0)) {
            break label495;
          }
          Iterator localIterator = ((g)localObject).Kyp.iterator();
          i = paramInt;
          if (localIterator.hasNext())
          {
            a(paramString1, (aa)localIterator.next());
            i = paramInt - 1;
            paramInt = i;
            if (i > 0) {
              continue;
            }
          }
          k = j - 1;
          j = k;
          paramInt = i;
          if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            continue;
          }
          localIterator = ((g)localObject).Kyq.keySet().iterator();
          j = k;
          paramInt = i;
          if (!localIterator.hasNext()) {
            continue;
          }
          String str = (String)localIterator.next();
          Log.i("AdLandingPagesPreDownloadResHelper", "preload floatComponent, cid=".concat(String.valueOf(str)));
          a(paramString1, (aa)((g)localObject).Kyq.get(str));
          continue;
          j = com.tencent.mm.n.h.axc().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        }
      }
      catch (Throwable paramString1)
      {
        Log.e("AdLandingPagesPreDownloadResHelper", "startPreDownloadResource, exp=" + paramString1.toString());
        AppMethodBeat.o(97389);
        return;
      }
      i = com.tencent.mm.n.h.axc().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
      continue;
      j = com.tencent.mm.n.h.axc().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      i = com.tencent.mm.n.h.axc().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      continue;
      label486:
      paramInt = paramString3.size();
      continue;
      label495:
      if (paramString2 != null)
      {
        Log.i("AdLandingPagesPreDownloadResHelper", "preload floatBarComp");
        if (!TextUtils.isEmpty(paramString2.KmW)) {
          bbh(paramString2.KmW);
        }
        if (!TextUtils.isEmpty(paramString2.iconUrl)) {
          bbh(paramString2.iconUrl);
        }
      }
      AppMethodBeat.o(97389);
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
      default: 
        break;
      case 5: 
        label563:
        i = 0;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */