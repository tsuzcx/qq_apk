package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j yuL;
  ConcurrentLinkedQueue<String> yuK;
  
  static
  {
    AppMethodBeat.i(97391);
    yuL = new j();
    AppMethodBeat.o(97391);
  }
  
  private j()
  {
    AppMethodBeat.i(97385);
    this.yuK = new ConcurrentLinkedQueue();
    AppMethodBeat.o(97385);
  }
  
  private void a(String paramString, final x paramx)
  {
    AppMethodBeat.i(97387);
    Object localObject1;
    if (i.OV(paramx.type))
    {
      localObject1 = new ArrayList();
      if (i.OW(paramx.type)) {
        ((List)localObject1).addAll(((ag)paramx).dKd());
      }
      for (;;)
      {
        paramx = ((List)localObject1).iterator();
        while (paramx.hasNext()) {
          a(paramString, (x)paramx.next());
        }
        if (i.OZ(paramx.type)) {
          ((List)localObject1).addAll(((v)paramx).bsA);
        } else if (i.OX(paramx.type)) {
          ((List)localObject1).addAll(((y)paramx).dKd());
        } else if (i.OY(paramx.type)) {
          ((List)localObject1).addAll(((w)paramx).dKd());
        }
      }
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.yjt == 41)
    {
      localObject1 = (s)paramx;
      if (auP(((s)localObject1).yjd))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.yuK.add(((s)localObject1).yjd);
      h.c(paramString, ((s)localObject1).yjd, true, paramx.yjt, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(97361);
          j.a(j.this, this.yuM.yjd);
          AppMethodBeat.o(97361);
        }
        
        public final void dFC() {}
        
        public final void dFD()
        {
          AppMethodBeat.i(97360);
          ac.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.yuM.yjd + "is error");
          j.a(j.this, this.yuM.yjd);
          AppMethodBeat.o(97360);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.yjt == 44)
    {
      localObject1 = (r)paramx;
      if (auP(((r)localObject1).yjd))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.yuK.add(((r)localObject1).yjd);
      h.c(paramString, ((r)localObject1).yjd, true, paramx.yjt, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(97368);
          j.a(j.this, this.yuQ.yjd);
          AppMethodBeat.o(97368);
        }
        
        public final void dFC() {}
        
        public final void dFD()
        {
          AppMethodBeat.i(97367);
          ac.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.yuQ.yjd + "is error");
          j.a(j.this, this.yuQ.yjd);
          AppMethodBeat.o(97367);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.yjt == 45)
    {
      localObject1 = (s)paramx;
      if (auP(((s)localObject1).yjd))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.yuK.add(((s)localObject1).yjd);
      h.c(paramString, ((s)localObject1).yjd, true, paramx.yjt, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(97370);
          j.a(j.this, this.yuM.yjd);
          AppMethodBeat.o(97370);
        }
        
        public final void dFC() {}
        
        public final void dFD()
        {
          AppMethodBeat.i(97369);
          ac.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.yuM.yjd + "is error");
          j.a(j.this, this.yuM.yjd);
          AppMethodBeat.o(97369);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    Object localObject2;
    if (paramx.yjt == 61)
    {
      paramx = (u)paramx;
      if (!auP(paramx.yji))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        com.tencent.mm.modelcontrol.c.aDI();
        if (com.tencent.mm.modelcontrol.c.a((PInt)localObject1, (PInt)localObject2))
        {
          this.yuK.add(paramx.yji);
          if (paramx.yjr) {
            break label546;
          }
          h.d(paramString, paramx.yji, true, 61, new f.a()
          {
            public final void asD(String paramAnonymousString)
            {
              AppMethodBeat.i(97372);
              j.a(j.this, paramx.yji);
              AppMethodBeat.o(97372);
            }
            
            public final void dFC() {}
            
            public final void dFD()
            {
              AppMethodBeat.i(97371);
              ac.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + paramx.yji);
              j.a(j.this, paramx.yji);
              AppMethodBeat.o(97371);
            }
          });
        }
      }
      for (;;)
      {
        if (!auP(paramx.yjj))
        {
          this.yuK.add(paramx.yjj);
          h.c(paramString, paramx.yjj, true, 1000000001, new f.a()
          {
            public final void asD(String paramAnonymousString)
            {
              AppMethodBeat.i(200325);
              j.a(j.this, paramx.yjj);
              AppMethodBeat.o(200325);
            }
            
            public final void dFC() {}
            
            public final void dFD()
            {
              AppMethodBeat.i(200324);
              ac.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + paramx.yjj);
              j.a(j.this, paramx.yjj);
              AppMethodBeat.o(200324);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        label546:
        h.b(paramString, paramx.yji, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(97374);
            j.a(j.this, paramx.yji);
            AppMethodBeat.o(97374);
          }
          
          public final void dFC() {}
          
          public final void dFD()
          {
            AppMethodBeat.i(97373);
            ac.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + paramx.yji);
            j.a(j.this, paramx.yji);
            AppMethodBeat.o(97373);
          }
        });
      }
    }
    Object localObject3;
    if (paramx.yjt == 62)
    {
      boolean bool;
      int i;
      if (com.tencent.mm.m.g.ZY().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        ac.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)paramx;
        if ((bool) && (!auP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjk)))
        {
          this.yuK.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjk);
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjk;
          i = paramx.yjt;
          localObject3 = new c.a()
          {
            public final void ML(String paramAnonymousString)
            {
              AppMethodBeat.i(200326);
              ac.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.yuS.yjk + "is error");
              j.a(j.this, this.yuS.yjk);
              AppMethodBeat.o(200326);
            }
            
            public final void cZ(String paramAnonymousString, int paramAnonymousInt) {}
            
            public final void vn(String paramAnonymousString)
            {
              AppMethodBeat.i(200327);
              j.a(j.this, this.yuS.yjk);
              AppMethodBeat.o(200327);
            }
          };
          if ((!bs.isNullOrNil((String)localObject2)) && (!bs.isNullOrNil(paramString))) {
            break label752;
          }
          ((c.a)localObject3).ML("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!auP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).ykg))
        {
          this.yuK.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).ykg);
          h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).ykg, true, paramx.yjt, new f.a()
          {
            public final void asD(String paramAnonymousString)
            {
              AppMethodBeat.i(97381);
              j.a(j.this, this.yuS.ykg);
              AppMethodBeat.o(97381);
            }
            
            public final void dFC()
            {
              AppMethodBeat.i(97379);
              AppMethodBeat.o(97379);
            }
            
            public final void dFD()
            {
              AppMethodBeat.i(97380);
              ac.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.yuS.ykg + "is error");
              j.a(j.this, this.yuS.yjk);
              AppMethodBeat.o(97380);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        bool = false;
        break;
        label752:
        ac.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str1 = h.dLL();
        String str2 = ah.dg((String)localObject2);
        paramString = paramString + "_stream_" + str2;
        str2 = str1 + paramString;
        if (!bs.isNullOrNil(str2))
        {
          if (com.tencent.mm.vfs.i.eA(str2))
          {
            ac.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str2 });
            ap.f(new e.4((c.a)localObject3, str2));
          }
          else
          {
            new c(str1, paramString, i, new e.5((c.a)localObject3, (String)localObject2)).execute(new Void[0]);
          }
        }
        else {
          ap.f(new e.6((c.a)localObject3));
        }
      }
    }
    if (paramx.yjt == 133)
    {
      localObject2 = (t)paramx;
      localObject3 = ((t)localObject2).yho;
      localObject1 = ((t)localObject2).yjg;
      localObject2 = ((t)localObject2).yjh;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!auP((String)localObject3)))
        {
          this.yuK.add(localObject3);
          h.c(paramString, (String)localObject3, true, paramx.yjt, new f.a()
          {
            public final void asD(String paramAnonymousString)
            {
              AppMethodBeat.i(97384);
              j.a(j.this, this.yuT);
              ac.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.yuT);
              AppMethodBeat.o(97384);
            }
            
            public final void dFC()
            {
              AppMethodBeat.i(97382);
              ac.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
              AppMethodBeat.o(97382);
            }
            
            public final void dFD()
            {
              AppMethodBeat.i(97383);
              ac.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.yuT);
              j.a(j.this, this.yuT);
              AppMethodBeat.o(97383);
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
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!auP((String)localObject1)))
            {
              this.yuK.add(localObject1);
              h.c(paramString, (String)localObject1, true, paramx.yjt, new f.a()
              {
                public final void asD(String paramAnonymousString)
                {
                  AppMethodBeat.i(97364);
                  j.a(j.this, this.yuO);
                  ac.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + this.yuO);
                  AppMethodBeat.o(97364);
                }
                
                public final void dFC()
                {
                  AppMethodBeat.i(97362);
                  ac.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
                  AppMethodBeat.o(97362);
                }
                
                public final void dFD()
                {
                  AppMethodBeat.i(97363);
                  ac.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + this.yuO);
                  j.a(j.this, this.yuO);
                  AppMethodBeat.o(97363);
                }
              });
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!auP((String)localObject2)))
              {
                this.yuK.add(localObject2);
                h.c(paramString, (String)localObject2, true, paramx.yjt, new f.a()
                {
                  public final void asD(String paramAnonymousString)
                  {
                    AppMethodBeat.i(97366);
                    j.a(j.this, this.yuP);
                    ac.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.yuP);
                    AppMethodBeat.o(97366);
                  }
                  
                  public final void dFC()
                  {
                    AppMethodBeat.i(200321);
                    ac.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
                    AppMethodBeat.o(200321);
                  }
                  
                  public final void dFD()
                  {
                    AppMethodBeat.i(97365);
                    ac.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.yuP);
                    j.a(j.this, this.yuP);
                    AppMethodBeat.o(97365);
                  }
                });
              }
              AppMethodBeat.o(97387);
              return;
            }
            catch (Throwable paramString)
            {
              ac.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl exp=" + paramString.toString());
            }
            localThrowable2 = localThrowable2;
            ac.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download sphereImageUrl expl=" + localThrowable2.toString());
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            ac.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl exp=" + localThrowable1.toString());
          }
        }
      }
    }
    AppMethodBeat.o(97387);
  }
  
  private boolean auP(String paramString)
  {
    AppMethodBeat.i(97386);
    boolean bool = this.yuK.contains(paramString);
    AppMethodBeat.o(97386);
    return bool;
  }
  
  private void auQ(final String paramString)
  {
    AppMethodBeat.i(97388);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    if (auP(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    this.yuK.add(paramString);
    h.c("adId", paramString, true, 0, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(200323);
        j.a(j.this, paramString);
        AppMethodBeat.o(200323);
      }
      
      public final void dFC() {}
      
      public final void dFD()
      {
        AppMethodBeat.i(200322);
        ac.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString + "is error");
        j.a(j.this, paramString);
        AppMethodBeat.o(200322);
      }
    });
    AppMethodBeat.o(97388);
  }
  
  public static j dLO()
  {
    return yuL;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(97389);
    Object localObject = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    paramString2 = new i.a(paramString2, paramString3);
    paramString3 = paramString2.yuE;
    paramString2 = paramString2.yuF;
    int j;
    int i;
    if (paramInt == 0)
    {
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        ac.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          Iterator localIterator = ((g)localObject).yuw.iterator();
          while (localIterator.hasNext()) {
            a(paramString1, (x)localIterator.next());
          }
          localIterator = ((g)localObject).yux.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            a(paramString1, (x)((g)localObject).yux.get(str));
          }
          auQ(((g)localObject).yuu);
        }
      }
      ac.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
      j = com.tencent.mm.m.g.ZY().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      paramInt = com.tencent.mm.m.g.ZY().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      if ((paramString3 != null) && (paramString3.size() > 0))
      {
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          auQ(((g)localObject).yuu);
          if ((paramInt <= 0) || (j <= 0)) {
            break;
          }
          localObject = ((g)localObject).yuw.iterator();
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
      ac.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        ac.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
        j = com.tencent.mm.m.g.ZY().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        paramInt = com.tencent.mm.m.g.ZY().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
        if ((paramString3 != null) && (paramString3.size() > 0))
        {
          paramString3 = paramString3.iterator();
          while (paramString3.hasNext())
          {
            localObject = (g)paramString3.next();
            auQ(((g)localObject).yuu);
            if ((paramInt <= 0) || (j <= 0)) {
              break;
            }
            localObject = ((g)localObject).yuw.iterator();
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
        ac.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
        paramString1 = paramString3.iterator();
        while (paramString1.hasNext()) {
          auQ(((g)paramString1.next()).yuu);
        }
      }
    }
    else
    {
      ac.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
    }
    if (paramString2 != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString2.yjG)) {
        auQ(paramString2.yjG);
      }
      if (!TextUtils.isEmpty(paramString2.iconUrl)) {
        auQ(paramString2.iconUrl);
      }
      AppMethodBeat.o(97389);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("AdLandingPagesPreDownloadResHelper", "predownload float bar res exp=" + paramString1.toString());
      AppMethodBeat.o(97389);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */