package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j xhX;
  ConcurrentLinkedQueue<String> xhW;
  
  static
  {
    AppMethodBeat.i(97391);
    xhX = new j();
    AppMethodBeat.o(97391);
  }
  
  private j()
  {
    AppMethodBeat.i(97385);
    this.xhW = new ConcurrentLinkedQueue();
    AppMethodBeat.o(97385);
  }
  
  private void a(String paramString, final x paramx)
  {
    AppMethodBeat.i(97387);
    Object localObject1;
    if (i.MS(paramx.type))
    {
      localObject1 = new ArrayList();
      if (i.MT(paramx.type)) {
        ((List)localObject1).addAll(((af)paramx).dvE());
      }
      for (;;)
      {
        paramx = ((List)localObject1).iterator();
        while (paramx.hasNext()) {
          a(paramString, (x)paramx.next());
        }
        if (i.MW(paramx.type)) {
          ((List)localObject1).addAll(((v)paramx).buB);
        } else if (i.MU(paramx.type)) {
          ((List)localObject1).addAll(((y)paramx).dvE());
        } else if (i.MV(paramx.type)) {
          ((List)localObject1).addAll(((w)paramx).dvE());
        }
      }
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.wWF == 41)
    {
      localObject1 = (s)paramx;
      if (apG(((s)localObject1).wWp))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.xhW.add(((s)localObject1).wWp);
      h.c(paramString, ((s)localObject1).wWp, true, paramx.wWF, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(97361);
          j.a(j.this, this.xhY.wWp);
          AppMethodBeat.o(97361);
        }
        
        public final void dsA()
        {
          AppMethodBeat.i(97360);
          ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.xhY.wWp + "is error");
          j.a(j.this, this.xhY.wWp);
          AppMethodBeat.o(97360);
        }
        
        public final void duP() {}
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.wWF == 44)
    {
      localObject1 = (r)paramx;
      if (apG(((r)localObject1).wWp))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.xhW.add(((r)localObject1).wWp);
      h.c(paramString, ((r)localObject1).wWp, true, paramx.wWF, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(97368);
          j.a(j.this, this.xic.wWp);
          AppMethodBeat.o(97368);
        }
        
        public final void dsA()
        {
          AppMethodBeat.i(97367);
          ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.xic.wWp + "is error");
          j.a(j.this, this.xic.wWp);
          AppMethodBeat.o(97367);
        }
        
        public final void duP() {}
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.wWF == 45)
    {
      localObject1 = (s)paramx;
      if (apG(((s)localObject1).wWp))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.xhW.add(((s)localObject1).wWp);
      h.c(paramString, ((s)localObject1).wWp, true, paramx.wWF, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(97370);
          j.a(j.this, this.xhY.wWp);
          AppMethodBeat.o(97370);
        }
        
        public final void dsA()
        {
          AppMethodBeat.i(97369);
          ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.xhY.wWp + "is error");
          j.a(j.this, this.xhY.wWp);
          AppMethodBeat.o(97369);
        }
        
        public final void duP() {}
      });
      AppMethodBeat.o(97387);
      return;
    }
    Object localObject2;
    if (paramx.wWF == 61)
    {
      paramx = (u)paramx;
      if (!apG(paramx.wWu))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        com.tencent.mm.modelcontrol.c.awQ();
        if (com.tencent.mm.modelcontrol.c.a((PInt)localObject1, (PInt)localObject2))
        {
          this.xhW.add(paramx.wWu);
          if (paramx.wWD) {
            break label546;
          }
          h.d(paramString, paramx.wWu, true, 61, new f.a()
          {
            public final void apm(String paramAnonymousString)
            {
              AppMethodBeat.i(97372);
              j.a(j.this, paramx.wWu);
              AppMethodBeat.o(97372);
            }
            
            public final void dsA()
            {
              AppMethodBeat.i(97371);
              ad.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + paramx.wWu);
              j.a(j.this, paramx.wWu);
              AppMethodBeat.o(97371);
            }
            
            public final void duP() {}
          });
        }
      }
      for (;;)
      {
        if (!apG(paramx.wWv))
        {
          this.xhW.add(paramx.wWv);
          h.c(paramString, paramx.wWv, true, 1000000001, new f.a()
          {
            public final void apm(String paramAnonymousString)
            {
              AppMethodBeat.i(187519);
              j.a(j.this, paramx.wWv);
              AppMethodBeat.o(187519);
            }
            
            public final void dsA()
            {
              AppMethodBeat.i(187518);
              ad.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + paramx.wWv);
              j.a(j.this, paramx.wWv);
              AppMethodBeat.o(187518);
            }
            
            public final void duP() {}
          });
        }
        AppMethodBeat.o(97387);
        return;
        label546:
        h.b(paramString, paramx.wWu, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(97374);
            j.a(j.this, paramx.wWu);
            AppMethodBeat.o(97374);
          }
          
          public final void dsA()
          {
            AppMethodBeat.i(97373);
            ad.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + paramx.wWu);
            j.a(j.this, paramx.wWu);
            AppMethodBeat.o(97373);
          }
          
          public final void duP() {}
        });
      }
    }
    Object localObject3;
    if (paramx.wWF == 62)
    {
      boolean bool;
      int i;
      if (com.tencent.mm.m.g.Zd().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        ad.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (ah)paramx;
        if ((bool) && (!apG(((ah)localObject1).wWw)))
        {
          this.xhW.add(((ah)localObject1).wWw);
          localObject2 = ((ah)localObject1).wWw;
          i = paramx.wWF;
          localObject3 = new c.a()
          {
            public final void IK(String paramAnonymousString)
            {
              AppMethodBeat.i(187520);
              ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.xie.wWw + "is error");
              j.a(j.this, this.xie.wWw);
              AppMethodBeat.o(187520);
            }
            
            public final void cU(String paramAnonymousString, int paramAnonymousInt) {}
            
            public final void rl(String paramAnonymousString)
            {
              AppMethodBeat.i(187521);
              j.a(j.this, this.xie.wWw);
              AppMethodBeat.o(187521);
            }
          };
          if ((!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil(paramString))) {
            break label752;
          }
          ((c.a)localObject3).IK("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!apG(((ah)localObject1).wXs))
        {
          this.xhW.add(((ah)localObject1).wXs);
          h.c("adId", ((ah)localObject1).wXs, true, paramx.wWF, new f.a()
          {
            public final void apm(String paramAnonymousString)
            {
              AppMethodBeat.i(97381);
              j.a(j.this, this.xie.wXs);
              AppMethodBeat.o(97381);
            }
            
            public final void dsA()
            {
              AppMethodBeat.i(97380);
              ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.xie.wXs + "is error");
              j.a(j.this, this.xie.wWw);
              AppMethodBeat.o(97380);
            }
            
            public final void duP()
            {
              AppMethodBeat.i(97379);
              AppMethodBeat.o(97379);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        bool = false;
        break;
        label752:
        ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str1 = h.dxm();
        String str2 = ai.du((String)localObject2);
        paramString = paramString + "_stream_" + str2;
        str2 = str1 + paramString;
        if (!bt.isNullOrNil(str2))
        {
          if (com.tencent.mm.vfs.i.eK(str2))
          {
            ad.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str2 });
            aq.f(new e.4((c.a)localObject3, str2));
          }
          else
          {
            new c(str1, paramString, i, new e.5((c.a)localObject3, (String)localObject2)).execute(new Void[0]);
          }
        }
        else {
          aq.f(new e.6((c.a)localObject3));
        }
      }
    }
    if (paramx.wWF == 133)
    {
      localObject2 = (t)paramx;
      localObject3 = ((t)localObject2).wUA;
      localObject1 = ((t)localObject2).wWs;
      localObject2 = ((t)localObject2).wWt;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!apG((String)localObject3)))
        {
          this.xhW.add(localObject3);
          h.c(paramString, (String)localObject3, true, paramx.wWF, new f.a()
          {
            public final void apm(String paramAnonymousString)
            {
              AppMethodBeat.i(97384);
              j.a(j.this, this.xif);
              ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.xif);
              AppMethodBeat.o(97384);
            }
            
            public final void dsA()
            {
              AppMethodBeat.i(97383);
              ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.xif);
              j.a(j.this, this.xif);
              AppMethodBeat.o(97383);
            }
            
            public final void duP()
            {
              AppMethodBeat.i(97382);
              ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
              AppMethodBeat.o(97382);
            }
          });
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!apG((String)localObject1)))
            {
              this.xhW.add(localObject1);
              h.c(paramString, (String)localObject1, true, paramx.wWF, new f.a()
              {
                public final void apm(String paramAnonymousString)
                {
                  AppMethodBeat.i(97364);
                  j.a(j.this, this.xia);
                  ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + this.xia);
                  AppMethodBeat.o(97364);
                }
                
                public final void dsA()
                {
                  AppMethodBeat.i(97363);
                  ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + this.xia);
                  j.a(j.this, this.xia);
                  AppMethodBeat.o(97363);
                }
                
                public final void duP()
                {
                  AppMethodBeat.i(97362);
                  ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
                  AppMethodBeat.o(97362);
                }
              });
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!apG((String)localObject2)))
              {
                this.xhW.add(localObject2);
                h.c(paramString, (String)localObject2, true, paramx.wWF, new f.a()
                {
                  public final void apm(String paramAnonymousString)
                  {
                    AppMethodBeat.i(97366);
                    j.a(j.this, this.xib);
                    ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.xib);
                    AppMethodBeat.o(97366);
                  }
                  
                  public final void dsA()
                  {
                    AppMethodBeat.i(97365);
                    ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.xib);
                    j.a(j.this, this.xib);
                    AppMethodBeat.o(97365);
                  }
                  
                  public final void duP()
                  {
                    AppMethodBeat.i(187515);
                    ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
                    AppMethodBeat.o(187515);
                  }
                });
              }
              AppMethodBeat.o(97387);
              return;
            }
            catch (Throwable paramString)
            {
              ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl exp=" + paramString.toString());
            }
            localThrowable2 = localThrowable2;
            ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download sphereImageUrl expl=" + localThrowable2.toString());
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl exp=" + localThrowable1.toString());
          }
        }
      }
    }
    AppMethodBeat.o(97387);
  }
  
  private boolean apG(String paramString)
  {
    AppMethodBeat.i(97386);
    boolean bool = this.xhW.contains(paramString);
    AppMethodBeat.o(97386);
    return bool;
  }
  
  private void apH(final String paramString)
  {
    AppMethodBeat.i(97388);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    if (apG(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    this.xhW.add(paramString);
    h.c("adId", paramString, true, 0, new f.a()
    {
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(187517);
        j.a(j.this, paramString);
        AppMethodBeat.o(187517);
      }
      
      public final void dsA()
      {
        AppMethodBeat.i(187516);
        ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString + "is error");
        j.a(j.this, paramString);
        AppMethodBeat.o(187516);
      }
      
      public final void duP() {}
    });
    AppMethodBeat.o(97388);
  }
  
  public static j dxp()
  {
    return xhX;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(97389);
    Object localObject = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    paramString2 = new i.a(paramString2, paramString3);
    paramString3 = paramString2.xhQ;
    paramString2 = paramString2.xhR;
    int j;
    int i;
    if (paramInt == 0)
    {
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        ad.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          Iterator localIterator = ((g)localObject).xhI.iterator();
          while (localIterator.hasNext()) {
            a(paramString1, (x)localIterator.next());
          }
          localIterator = ((g)localObject).xhJ.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            a(paramString1, (x)((g)localObject).xhJ.get(str));
          }
          apH(((g)localObject).xhG);
        }
      }
      ad.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
      j = com.tencent.mm.m.g.Zd().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      paramInt = com.tencent.mm.m.g.Zd().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      if ((paramString3 != null) && (paramString3.size() > 0))
      {
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          apH(((g)localObject).xhG);
          if ((paramInt <= 0) || (j <= 0)) {
            break;
          }
          localObject = ((g)localObject).xhI.iterator();
          do
          {
            i = paramInt;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            a(paramString1, (x)((Iterator)localObject).next());
            i = paramInt - 1;
            paramInt = i;
          } while (i > 0);
          j -= 1;
          paramInt = i;
        }
      }
    }
    else if (paramInt == 1)
    {
      ad.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        ad.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
        j = com.tencent.mm.m.g.Zd().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        paramInt = com.tencent.mm.m.g.Zd().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
        if ((paramString3 != null) && (paramString3.size() > 0))
        {
          paramString3 = paramString3.iterator();
          while (paramString3.hasNext())
          {
            localObject = (g)paramString3.next();
            apH(((g)localObject).xhG);
            if ((paramInt <= 0) || (j <= 0)) {
              break;
            }
            localObject = ((g)localObject).xhI.iterator();
            do
            {
              i = paramInt;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              a(paramString1, (x)((Iterator)localObject).next());
              i = paramInt - 1;
              paramInt = i;
            } while (i > 0);
            j -= 1;
            paramInt = i;
          }
        }
      }
      else
      {
        ad.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
        paramString1 = paramString3.iterator();
        while (paramString1.hasNext()) {
          apH(((g)paramString1.next()).xhG);
        }
      }
    }
    else
    {
      ad.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
    }
    if (paramString2 != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString2.wWR)) {
        apH(paramString2.wWR);
      }
      if (!TextUtils.isEmpty(paramString2.iconUrl)) {
        apH(paramString2.iconUrl);
      }
      AppMethodBeat.o(97389);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("AdLandingPagesPreDownloadResHelper", "predownload float bar res exp=" + paramString1.toString());
      AppMethodBeat.o(97389);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */