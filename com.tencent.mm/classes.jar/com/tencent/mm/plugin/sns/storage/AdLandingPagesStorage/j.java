package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mm.m.e;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j oKH = new j();
  ConcurrentLinkedQueue<String> oKG = new ConcurrentLinkedQueue();
  
  private boolean Ox(String paramString)
  {
    return this.oKG.contains(paramString);
  }
  
  private void Oy(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (Ox(paramString)) {
      return;
    }
    this.oKG.add(paramString);
    h.c("adId", paramString, true, 0, new j.9(this, paramString));
  }
  
  private void a(String paramString, final s params)
  {
    Object localObject;
    if (params.oDh == 101)
    {
      params = ((n)params).oCS.iterator();
      while (params.hasNext())
      {
        localObject = ((m)params.next()).oCS.iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramString, (s)((Iterator)localObject).next());
        }
      }
    }
    if (params.oDh == 41)
    {
      localObject = (p)params;
      if (!Ox(((p)localObject).oCV)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.oKG.add(((p)localObject).oCV);
            h.c(paramString, ((p)localObject).oCV, true, params.oDh, new j.1(this, (p)localObject));
            return;
            if (params.oDh != 44) {
              break;
            }
            localObject = (o)params;
          } while (Ox(((o)localObject).oCV));
          this.oKG.add(((o)localObject).oCV);
          h.c(paramString, ((o)localObject).oCV, true, params.oDh, new j.3(this, (o)localObject));
          return;
          if (params.oDh != 45) {
            break;
          }
          localObject = (p)params;
        } while (Ox(((p)localObject).oCV));
        this.oKG.add(((p)localObject).oCV);
        h.c(paramString, ((p)localObject).oCV, true, params.oDh, new j.4(this, (p)localObject));
        return;
        if (params.oDh != 61) {
          break;
        }
        params = (q)params;
        if (!Ox(params.oCX))
        {
          localObject = new PInt();
          PInt localPInt = new PInt();
          c.Ni();
          if (c.a((PInt)localObject, localPInt))
          {
            this.oKG.add(params.oCX);
            h.d(paramString, params.oCX, true, 61, new f.a()
            {
              public final void Op(String paramAnonymousString)
              {
                j.a(j.this, params.oCX);
              }
              
              public final void bCF()
              {
                y.e("AdLandingPagesPreDownloadResHelper", " pre download " + params.oCX + "is error");
                j.a(j.this, params.oCX);
              }
              
              public final void bFl() {}
            });
          }
        }
      } while (Ox(params.oCY));
      this.oKG.add(params.oCY);
      h.c(paramString, params.oCY, true, 1000000001, new f.a()
      {
        public final void Op(String paramAnonymousString)
        {
          j.a(j.this, params.oCY);
        }
        
        public final void bCF()
        {
          y.e("AdLandingPagesPreDownloadResHelper", " pre download " + params.oCY + "is error");
          j.a(j.this, params.oCY);
        }
        
        public final void bFl() {}
      });
      return;
    } while (params.oDh != 62);
    if (com.tencent.mm.m.g.AA().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("AdLandingPagesPreDownloadResHelper", "pre down video value: " + bool);
      localObject = (w)params;
      if ((bool) && (!Ox(((w)localObject).oCZ)))
      {
        this.oKG.add(((w)localObject).oCZ);
        h.a(paramString, ((w)localObject).oCZ, true, params.oDh, new c.a()
        {
          public final void Oq(String paramAnonymousString)
          {
            j.a(j.this, this.oKN.oCZ);
          }
          
          public final void cu(String paramAnonymousString, int paramAnonymousInt) {}
          
          public final void uv(String paramAnonymousString)
          {
            y.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.oKN.oCZ + "is error");
            j.a(j.this, this.oKN.oCZ);
          }
        });
      }
      if (Ox(((w)localObject).oDK)) {
        break;
      }
      this.oKG.add(((w)localObject).oDK);
      h.c("adId", ((w)localObject).oDK, true, params.oDh, new j.8(this, (w)localObject));
      return;
    }
  }
  
  public static j bFV()
  {
    return oKH;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    paramString2 = i.r(paramString2, paramString3, "", "");
    int i;
    if (paramInt == 0)
    {
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        y.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
        paramString2 = paramString2.iterator();
      }
      while (paramString2.hasNext())
      {
        paramString3 = (g)paramString2.next();
        localObject = paramString3.oKx.iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramString1, (s)((Iterator)localObject).next());
        }
        Oy(paramString3.oKv);
        continue;
        y.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
        i = com.tencent.mm.m.g.AA().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
        paramInt = com.tencent.mm.m.g.AA().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
        if (paramString2.size() > 0)
        {
          paramString2 = paramString2.iterator();
          if (paramString2.hasNext())
          {
            paramString3 = (g)paramString2.next();
            Oy(paramString3.oKv);
            if ((paramInt > 0) && (i > 0))
            {
              paramString3 = paramString3.oKx.iterator();
              label212:
              if (!paramString3.hasNext()) {
                break label488;
              }
              ai.d(new j.10(this, paramString1, (s)paramString3.next()));
              paramInt -= 1;
              if (paramInt > 0) {
                break label485;
              }
            }
          }
        }
      }
    }
    label478:
    label479:
    label482:
    label485:
    label488:
    for (;;)
    {
      i -= 1;
      break;
      if (paramInt == 1)
      {
        y.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
        if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
        {
          y.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
          i = com.tencent.mm.m.g.AA().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
          paramInt = com.tencent.mm.m.g.AA().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
          if (paramString2.size() <= 0) {
            break label478;
          }
          paramString2 = paramString2.iterator();
          if (!paramString2.hasNext()) {
            break label478;
          }
          paramString3 = (g)paramString2.next();
          Oy(paramString3.oKv);
          if ((paramInt <= 0) || (i <= 0)) {
            break label478;
          }
          paramString3 = paramString3.oKx.iterator();
          label379:
          if (!paramString3.hasNext()) {
            break label482;
          }
          ai.d(new j.2(this, paramString1, (s)paramString3.next()));
          paramInt -= 1;
          if (paramInt > 0) {
            break label479;
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        y.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
        paramString1 = paramString2.iterator();
        while (paramString1.hasNext())
        {
          Oy(((g)paramString1.next()).oKv);
          continue;
          y.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        }
        return;
        break label379;
      }
      break label212;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */