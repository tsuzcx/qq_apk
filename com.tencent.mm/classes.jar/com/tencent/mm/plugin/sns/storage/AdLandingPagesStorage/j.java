package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j Adg;
  ConcurrentLinkedQueue<String> Adf;
  
  static
  {
    AppMethodBeat.i(97391);
    Adg = new j();
    AppMethodBeat.o(97391);
  }
  
  private j()
  {
    AppMethodBeat.i(97385);
    this.Adf = new ConcurrentLinkedQueue();
    AppMethodBeat.o(97385);
  }
  
  private void a(String paramString, final y paramy)
  {
    AppMethodBeat.i(97387);
    Object localObject1;
    if (i.Rk(paramy.type))
    {
      localObject1 = new ArrayList();
      if (i.Rl(paramy.type)) {
        ((List)localObject1).addAll(((ai)paramy).dZS());
      }
      for (;;)
      {
        paramy = ((List)localObject1).iterator();
        while (paramy.hasNext()) {
          a(paramString, (y)paramy.next());
        }
        if (i.Ro(paramy.type)) {
          ((List)localObject1).addAll(((w)paramy).aQH);
        } else if (i.Rm(paramy.type)) {
          ((List)localObject1).addAll(((z)paramy).dZS());
        } else if (i.Rn(paramy.type)) {
          ((List)localObject1).addAll(((x)paramy).dZS());
        }
      }
      AppMethodBeat.o(97387);
      return;
    }
    if (paramy.zRh == 41)
    {
      localObject1 = (s)paramy;
      if (aBn(((s)localObject1).zQK))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.Adf.add(((s)localObject1).zQK);
      h.c(paramString, ((s)localObject1).zQK, true, paramy.zRh, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(97361);
          j.a(j.this, this.Adh.zQK);
          AppMethodBeat.o(97361);
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(97360);
          ae.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Adh.zQK + "is error");
          j.a(j.this, this.Adh.zQK);
          AppMethodBeat.o(97360);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramy.zRh == 44)
    {
      localObject1 = (r)paramy;
      if (aBn(((r)localObject1).zQK))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.Adf.add(((r)localObject1).zQK);
      h.c(paramString, ((r)localObject1).zQK, true, paramy.zRh, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(97368);
          j.a(j.this, this.Adl.zQK);
          AppMethodBeat.o(97368);
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(97367);
          ae.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Adl.zQK + "is error");
          j.a(j.this, this.Adl.zQK);
          AppMethodBeat.o(97367);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramy.zRh == 45)
    {
      localObject1 = (s)paramy;
      if (aBn(((s)localObject1).zQK))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.Adf.add(((s)localObject1).zQK);
      h.c(paramString, ((s)localObject1).zQK, true, paramy.zRh, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(97370);
          j.a(j.this, this.Adh.zQK);
          AppMethodBeat.o(97370);
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(97369);
          ae.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Adh.zQK + "is error");
          j.a(j.this, this.Adh.zQK);
          AppMethodBeat.o(97369);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    Object localObject2;
    if (paramy.zRh == 61)
    {
      paramy = (u)paramy;
      if (!aBn(paramy.zQP))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        com.tencent.mm.modelcontrol.c.aHe();
        if (com.tencent.mm.modelcontrol.c.a((PInt)localObject1, (PInt)localObject2))
        {
          this.Adf.add(paramy.zQP);
          if (paramy.zQY) {
            break label546;
          }
          h.d(paramString, paramy.zQP, true, 61, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(97372);
              j.a(j.this, paramy.zQP);
              AppMethodBeat.o(97372);
            }
            
            public final void dVu() {}
            
            public final void dVv()
            {
              AppMethodBeat.i(97371);
              ae.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + paramy.zQP);
              j.a(j.this, paramy.zQP);
              AppMethodBeat.o(97371);
            }
          });
        }
      }
      for (;;)
      {
        if (!aBn(paramy.zQQ))
        {
          this.Adf.add(paramy.zQQ);
          h.c(paramString, paramy.zQQ, true, 1000000001, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(219635);
              j.a(j.this, paramy.zQQ);
              AppMethodBeat.o(219635);
            }
            
            public final void dVu() {}
            
            public final void dVv()
            {
              AppMethodBeat.i(219634);
              ae.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + paramy.zQQ);
              j.a(j.this, paramy.zQQ);
              AppMethodBeat.o(219634);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        label546:
        h.b(paramString, paramy.zQP, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(97374);
            j.a(j.this, paramy.zQP);
            AppMethodBeat.o(97374);
          }
          
          public final void dVu() {}
          
          public final void dVv()
          {
            AppMethodBeat.i(97373);
            ae.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + paramy.zQP);
            j.a(j.this, paramy.zQP);
            AppMethodBeat.o(97373);
          }
        });
      }
    }
    Object localObject3;
    if (paramy.zRh == 62)
    {
      boolean bool;
      int i;
      if (com.tencent.mm.n.g.acL().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        ae.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)paramy;
        if ((bool) && (!aBn(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zQR)))
        {
          this.Adf.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zQR);
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zQR;
          i = paramy.zRh;
          localObject3 = new c.a()
          {
            public final void QR(String paramAnonymousString)
            {
              AppMethodBeat.i(219636);
              ae.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Adn.zQR + "is error");
              j.a(j.this, this.Adn.zQR);
              AppMethodBeat.o(219636);
            }
            
            public final void dp(String paramAnonymousString, int paramAnonymousInt) {}
            
            public final void yO(String paramAnonymousString)
            {
              AppMethodBeat.i(219637);
              j.a(j.this, this.Adn.zQR);
              AppMethodBeat.o(219637);
            }
          };
          if ((!bu.isNullOrNil((String)localObject2)) && (!bu.isNullOrNil(paramString))) {
            break label752;
          }
          ((c.a)localObject3).QR("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!aBn(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRV))
        {
          this.Adf.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRV);
          h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRV, true, paramy.zRh, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(97381);
              j.a(j.this, this.Adn.zRV);
              AppMethodBeat.o(97381);
            }
            
            public final void dVu()
            {
              AppMethodBeat.i(97379);
              AppMethodBeat.o(97379);
            }
            
            public final void dVv()
            {
              AppMethodBeat.i(97380);
              ae.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Adn.zRV + "is error");
              j.a(j.this, this.Adn.zQR);
              AppMethodBeat.o(97380);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        bool = false;
        break;
        label752:
        ae.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str1 = h.ebF();
        String str2 = aj.ej((String)localObject2);
        paramString = paramString + "_stream_" + str2;
        str2 = str1 + paramString;
        if (!bu.isNullOrNil(str2))
        {
          if (o.fB(str2))
          {
            ae.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str2 });
            ar.f(new e.4((c.a)localObject3, str2));
          }
          else
          {
            new c(str1, paramString, i, new e.5((c.a)localObject3, (String)localObject2)).execute(new Void[0]);
          }
        }
        else {
          ar.f(new e.6((c.a)localObject3));
        }
      }
    }
    if (paramy.zRh == 133)
    {
      localObject2 = (t)paramy;
      localObject3 = ((t)localObject2).zOU;
      localObject1 = ((t)localObject2).zQN;
      localObject2 = ((t)localObject2).zQO;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!aBn((String)localObject3)))
        {
          this.Adf.add(localObject3);
          h.c(paramString, (String)localObject3, true, paramy.zRh, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(97384);
              j.a(j.this, this.Ado);
              ae.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.Ado);
              AppMethodBeat.o(97384);
            }
            
            public final void dVu()
            {
              AppMethodBeat.i(97382);
              ae.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
              AppMethodBeat.o(97382);
            }
            
            public final void dVv()
            {
              AppMethodBeat.i(97383);
              ae.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.Ado);
              j.a(j.this, this.Ado);
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
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!aBn((String)localObject1)))
            {
              this.Adf.add(localObject1);
              h.c(paramString, (String)localObject1, true, paramy.zRh, new f.a()
              {
                public final void ayY(String paramAnonymousString)
                {
                  AppMethodBeat.i(97364);
                  j.a(j.this, this.Adj);
                  ae.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + this.Adj);
                  AppMethodBeat.o(97364);
                }
                
                public final void dVu()
                {
                  AppMethodBeat.i(97362);
                  ae.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
                  AppMethodBeat.o(97362);
                }
                
                public final void dVv()
                {
                  AppMethodBeat.i(97363);
                  ae.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + this.Adj);
                  j.a(j.this, this.Adj);
                  AppMethodBeat.o(97363);
                }
              });
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!aBn((String)localObject2)))
              {
                this.Adf.add(localObject2);
                h.c(paramString, (String)localObject2, true, paramy.zRh, new f.a()
                {
                  public final void ayY(String paramAnonymousString)
                  {
                    AppMethodBeat.i(97366);
                    j.a(j.this, this.Adk);
                    ae.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.Adk);
                    AppMethodBeat.o(97366);
                  }
                  
                  public final void dVu()
                  {
                    AppMethodBeat.i(219631);
                    ae.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
                    AppMethodBeat.o(219631);
                  }
                  
                  public final void dVv()
                  {
                    AppMethodBeat.i(97365);
                    ae.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.Adk);
                    j.a(j.this, this.Adk);
                    AppMethodBeat.o(97365);
                  }
                });
              }
              AppMethodBeat.o(97387);
              return;
            }
            catch (Throwable paramString)
            {
              ae.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl exp=" + paramString.toString());
            }
            localThrowable2 = localThrowable2;
            ae.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download sphereImageUrl expl=" + localThrowable2.toString());
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            ae.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl exp=" + localThrowable1.toString());
          }
        }
      }
    }
    AppMethodBeat.o(97387);
  }
  
  private boolean aBn(String paramString)
  {
    AppMethodBeat.i(97386);
    boolean bool = this.Adf.contains(paramString);
    AppMethodBeat.o(97386);
    return bool;
  }
  
  private void aBo(final String paramString)
  {
    AppMethodBeat.i(97388);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    if (aBn(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    this.Adf.add(paramString);
    h.c("adId", paramString, true, 0, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(219633);
        j.a(j.this, paramString);
        AppMethodBeat.o(219633);
      }
      
      public final void dVu() {}
      
      public final void dVv()
      {
        AppMethodBeat.i(219632);
        ae.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString + "is error");
        j.a(j.this, paramString);
        AppMethodBeat.o(219632);
      }
    });
    AppMethodBeat.o(97388);
  }
  
  public static j ebI()
  {
    return Adg;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(97389);
    Object localObject = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    paramString2 = new i.a(paramString2, paramString3);
    paramString3 = paramString2.AcY;
    paramString2 = paramString2.AcZ;
    int j;
    int i;
    if (paramInt == 0)
    {
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        ae.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          Iterator localIterator = ((g)localObject).AcQ.iterator();
          while (localIterator.hasNext()) {
            a(paramString1, (y)localIterator.next());
          }
          localIterator = ((g)localObject).AcR.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            a(paramString1, (y)((g)localObject).AcR.get(str));
          }
          aBo(((g)localObject).AcO);
        }
      }
      ae.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
      j = com.tencent.mm.n.g.acL().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      paramInt = com.tencent.mm.n.g.acL().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      if ((paramString3 != null) && (paramString3.size() > 0))
      {
        paramString3 = paramString3.iterator();
        while (paramString3.hasNext())
        {
          localObject = (g)paramString3.next();
          aBo(((g)localObject).AcO);
          if ((paramInt <= 0) || (j <= 0)) {
            break;
          }
          localObject = ((g)localObject).AcQ.iterator();
          do
          {
            i = paramInt;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            a(paramString1, (y)((Iterator)localObject).next());
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
      ae.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        ae.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
        j = com.tencent.mm.n.g.acL().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        paramInt = com.tencent.mm.n.g.acL().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
        if ((paramString3 != null) && (paramString3.size() > 0))
        {
          paramString3 = paramString3.iterator();
          while (paramString3.hasNext())
          {
            localObject = (g)paramString3.next();
            aBo(((g)localObject).AcO);
            if ((paramInt <= 0) || (j <= 0)) {
              break;
            }
            localObject = ((g)localObject).AcQ.iterator();
            do
            {
              i = paramInt;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              a(paramString1, (y)((Iterator)localObject).next());
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
        ae.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
        paramString1 = paramString3.iterator();
        while (paramString1.hasNext()) {
          aBo(((g)paramString1.next()).AcO);
        }
      }
    }
    else
    {
      ae.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
    }
    if (paramString2 != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString2.zRv)) {
        aBo(paramString2.zRv);
      }
      if (!TextUtils.isEmpty(paramString2.iconUrl)) {
        aBo(paramString2.iconUrl);
      }
      AppMethodBeat.o(97389);
      return;
    }
    catch (Exception paramString1)
    {
      ae.e("AdLandingPagesPreDownloadResHelper", "predownload float bar res exp=" + paramString1.toString());
      AppMethodBeat.o(97389);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */