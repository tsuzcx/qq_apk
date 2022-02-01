package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
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
  private static j zLZ;
  ConcurrentLinkedQueue<String> zLY;
  
  static
  {
    AppMethodBeat.i(97391);
    zLZ = new j();
    AppMethodBeat.o(97391);
  }
  
  private j()
  {
    AppMethodBeat.i(97385);
    this.zLY = new ConcurrentLinkedQueue();
    AppMethodBeat.o(97385);
  }
  
  private void a(String paramString, final x paramx)
  {
    AppMethodBeat.i(97387);
    Object localObject1;
    if (i.QD(paramx.type))
    {
      localObject1 = new ArrayList();
      if (i.QE(paramx.type)) {
        ((List)localObject1).addAll(((ah)paramx).dWq());
      }
      for (;;)
      {
        paramx = ((List)localObject1).iterator();
        while (paramx.hasNext()) {
          a(paramString, (x)paramx.next());
        }
        if (i.QH(paramx.type)) {
          ((List)localObject1).addAll(((v)paramx).aQH);
        } else if (i.QF(paramx.type)) {
          ((List)localObject1).addAll(((y)paramx).dWq());
        } else if (i.QG(paramx.type)) {
          ((List)localObject1).addAll(((w)paramx).dWq());
        }
      }
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.zAh == 41)
    {
      localObject1 = (s)paramx;
      if (azW(((s)localObject1).zzL))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.zLY.add(((s)localObject1).zzL);
      h.c(paramString, ((s)localObject1).zzL, true, paramx.zAh, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(97361);
          j.a(j.this, this.zMa.zzL);
          AppMethodBeat.o(97361);
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(97360);
          ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.zMa.zzL + "is error");
          j.a(j.this, this.zMa.zzL);
          AppMethodBeat.o(97360);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.zAh == 44)
    {
      localObject1 = (r)paramx;
      if (azW(((r)localObject1).zzL))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.zLY.add(((r)localObject1).zzL);
      h.c(paramString, ((r)localObject1).zzL, true, paramx.zAh, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(97368);
          j.a(j.this, this.zMe.zzL);
          AppMethodBeat.o(97368);
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(97367);
          ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.zMe.zzL + "is error");
          j.a(j.this, this.zMe.zzL);
          AppMethodBeat.o(97367);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramx.zAh == 45)
    {
      localObject1 = (s)paramx;
      if (azW(((s)localObject1).zzL))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.zLY.add(((s)localObject1).zzL);
      h.c(paramString, ((s)localObject1).zzL, true, paramx.zAh, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(97370);
          j.a(j.this, this.zMa.zzL);
          AppMethodBeat.o(97370);
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(97369);
          ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.zMa.zzL + "is error");
          j.a(j.this, this.zMa.zzL);
          AppMethodBeat.o(97369);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    Object localObject2;
    if (paramx.zAh == 61)
    {
      paramx = (u)paramx;
      if (!azW(paramx.zzQ))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        com.tencent.mm.modelcontrol.c.aGN();
        if (com.tencent.mm.modelcontrol.c.a((PInt)localObject1, (PInt)localObject2))
        {
          this.zLY.add(paramx.zzQ);
          if (paramx.zzZ) {
            break label546;
          }
          h.d(paramString, paramx.zzQ, true, 61, new f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(97372);
              j.a(j.this, paramx.zzQ);
              AppMethodBeat.o(97372);
            }
            
            public final void dRW() {}
            
            public final void dRX()
            {
              AppMethodBeat.i(97371);
              ad.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + paramx.zzQ);
              j.a(j.this, paramx.zzQ);
              AppMethodBeat.o(97371);
            }
          });
        }
      }
      for (;;)
      {
        if (!azW(paramx.zzR))
        {
          this.zLY.add(paramx.zzR);
          h.c(paramString, paramx.zzR, true, 1000000001, new f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(198121);
              j.a(j.this, paramx.zzR);
              AppMethodBeat.o(198121);
            }
            
            public final void dRW() {}
            
            public final void dRX()
            {
              AppMethodBeat.i(198120);
              ad.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + paramx.zzR);
              j.a(j.this, paramx.zzR);
              AppMethodBeat.o(198120);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        label546:
        h.b(paramString, paramx.zzQ, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(97374);
            j.a(j.this, paramx.zzQ);
            AppMethodBeat.o(97374);
          }
          
          public final void dRW() {}
          
          public final void dRX()
          {
            AppMethodBeat.i(97373);
            ad.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + paramx.zzQ);
            j.a(j.this, paramx.zzQ);
            AppMethodBeat.o(97373);
          }
        });
      }
    }
    Object localObject3;
    if (paramx.zAh == 62)
    {
      boolean bool;
      int i;
      if (com.tencent.mm.n.g.acA().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        ad.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)paramx;
        if ((bool) && (!azW(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zzS)))
        {
          this.zLY.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zzS);
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zzS;
          i = paramx.zAh;
          localObject3 = new c.a()
          {
            public final void Qi(String paramAnonymousString)
            {
              AppMethodBeat.i(198122);
              ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.zMg.zzS + "is error");
              j.a(j.this, this.zMg.zzS);
              AppMethodBeat.o(198122);
            }
            
            public final void dk(String paramAnonymousString, int paramAnonymousInt) {}
            
            public final void ye(String paramAnonymousString)
            {
              AppMethodBeat.i(198123);
              j.a(j.this, this.zMg.zzS);
              AppMethodBeat.o(198123);
            }
          };
          if ((!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil(paramString))) {
            break label752;
          }
          ((c.a)localObject3).Qi("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!azW(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAV))
        {
          this.zLY.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAV);
          h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAV, true, paramx.zAh, new f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(97381);
              j.a(j.this, this.zMg.zAV);
              AppMethodBeat.o(97381);
            }
            
            public final void dRW()
            {
              AppMethodBeat.i(97379);
              AppMethodBeat.o(97379);
            }
            
            public final void dRX()
            {
              AppMethodBeat.i(97380);
              ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.zMg.zAV + "is error");
              j.a(j.this, this.zMg.zzS);
              AppMethodBeat.o(97380);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        bool = false;
        break;
        label752:
        ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str1 = h.dYb();
        String str2 = ai.ee((String)localObject2);
        paramString = paramString + "_stream_" + str2;
        str2 = str1 + paramString;
        if (!bt.isNullOrNil(str2))
        {
          if (com.tencent.mm.vfs.i.fv(str2))
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
    if (paramx.zAh == 133)
    {
      localObject2 = (t)paramx;
      localObject3 = ((t)localObject2).zxv;
      localObject1 = ((t)localObject2).zzO;
      localObject2 = ((t)localObject2).zzP;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!azW((String)localObject3)))
        {
          this.zLY.add(localObject3);
          h.c(paramString, (String)localObject3, true, paramx.zAh, new f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(97384);
              j.a(j.this, this.zMh);
              ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.zMh);
              AppMethodBeat.o(97384);
            }
            
            public final void dRW()
            {
              AppMethodBeat.i(97382);
              ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
              AppMethodBeat.o(97382);
            }
            
            public final void dRX()
            {
              AppMethodBeat.i(97383);
              ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.zMh);
              j.a(j.this, this.zMh);
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
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!azW((String)localObject1)))
            {
              this.zLY.add(localObject1);
              h.c(paramString, (String)localObject1, true, paramx.zAh, new f.a()
              {
                public final void axG(String paramAnonymousString)
                {
                  AppMethodBeat.i(97364);
                  j.a(j.this, this.zMc);
                  ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + this.zMc);
                  AppMethodBeat.o(97364);
                }
                
                public final void dRW()
                {
                  AppMethodBeat.i(97362);
                  ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
                  AppMethodBeat.o(97362);
                }
                
                public final void dRX()
                {
                  AppMethodBeat.i(97363);
                  ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + this.zMc);
                  j.a(j.this, this.zMc);
                  AppMethodBeat.o(97363);
                }
              });
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!azW((String)localObject2)))
              {
                this.zLY.add(localObject2);
                h.c(paramString, (String)localObject2, true, paramx.zAh, new f.a()
                {
                  public final void axG(String paramAnonymousString)
                  {
                    AppMethodBeat.i(97366);
                    j.a(j.this, this.zMd);
                    ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.zMd);
                    AppMethodBeat.o(97366);
                  }
                  
                  public final void dRW()
                  {
                    AppMethodBeat.i(198117);
                    ad.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
                    AppMethodBeat.o(198117);
                  }
                  
                  public final void dRX()
                  {
                    AppMethodBeat.i(97365);
                    ad.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.zMd);
                    j.a(j.this, this.zMd);
                    AppMethodBeat.o(97365);
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
  
  private boolean azW(String paramString)
  {
    AppMethodBeat.i(97386);
    boolean bool = this.zLY.contains(paramString);
    AppMethodBeat.o(97386);
    return bool;
  }
  
  private void azX(final String paramString)
  {
    AppMethodBeat.i(97388);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    if (azW(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    this.zLY.add(paramString);
    h.c("adId", paramString, true, 0, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(198119);
        j.a(j.this, paramString);
        AppMethodBeat.o(198119);
      }
      
      public final void dRW() {}
      
      public final void dRX()
      {
        AppMethodBeat.i(198118);
        ad.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString + "is error");
        j.a(j.this, paramString);
        AppMethodBeat.o(198118);
      }
    });
    AppMethodBeat.o(97388);
  }
  
  public static j dYe()
  {
    return zLZ;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(97389);
    Object localObject = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    paramString2 = new i.a(paramString2, paramString3);
    paramString3 = paramString2.zLR;
    paramString2 = paramString2.zLS;
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
          Iterator localIterator = ((g)localObject).zLJ.iterator();
          while (localIterator.hasNext()) {
            a(paramString1, (x)localIterator.next());
          }
          localIterator = ((g)localObject).zLK.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            a(paramString1, (x)((g)localObject).zLK.get(str));
          }
          azX(((g)localObject).zLH);
        }
      }
      ad.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
      j = com.tencent.mm.n.g.acA().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      paramInt = com.tencent.mm.n.g.acA().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      if ((paramString3 != null) && (paramString3.size() > 0))
      {
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          azX(((g)localObject).zLH);
          if ((paramInt <= 0) || (j <= 0)) {
            break;
          }
          localObject = ((g)localObject).zLJ.iterator();
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
        j = com.tencent.mm.n.g.acA().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        paramInt = com.tencent.mm.n.g.acA().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
        if ((paramString3 != null) && (paramString3.size() > 0))
        {
          paramString3 = paramString3.iterator();
          while (paramString3.hasNext())
          {
            localObject = (g)paramString3.next();
            azX(((g)localObject).zLH);
            if ((paramInt <= 0) || (j <= 0)) {
              break;
            }
            localObject = ((g)localObject).zLJ.iterator();
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
          azX(((g)paramString1.next()).zLH);
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
      if (!TextUtils.isEmpty(paramString2.zAv)) {
        azX(paramString2.zAv);
      }
      if (!TextUtils.isEmpty(paramString2.iconUrl)) {
        azX(paramString2.iconUrl);
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