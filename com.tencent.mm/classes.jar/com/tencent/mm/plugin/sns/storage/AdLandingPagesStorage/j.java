package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j
{
  private static j rCq;
  ConcurrentLinkedQueue<String> rCp;
  
  static
  {
    AppMethodBeat.i(37781);
    rCq = new j();
    AppMethodBeat.o(37781);
  }
  
  private j()
  {
    AppMethodBeat.i(37775);
    this.rCp = new ConcurrentLinkedQueue();
    AppMethodBeat.o(37775);
  }
  
  private void a(String paramString, final t paramt)
  {
    AppMethodBeat.i(37777);
    Object localObject1;
    if (i.Eo(paramt.type))
    {
      localObject1 = new ArrayList();
      if (i.Ep(paramt.type)) {
        ((List)localObject1).addAll(((z)paramt).cqF());
      }
      for (;;)
      {
        paramt = ((List)localObject1).iterator();
        while (paramt.hasNext()) {
          a(paramString, (t)paramt.next());
        }
        if (i.Es(paramt.type)) {
          ((List)localObject1).addAll(((r)paramt).aWy);
        } else if (i.Eq(paramt.type)) {
          ((List)localObject1).addAll(((u)paramt).cqF());
        } else if (i.Er(paramt.type)) {
          ((List)localObject1).addAll(((s)paramt).cqF());
        }
      }
      AppMethodBeat.o(37777);
      return;
    }
    if (paramt.rsJ == 41)
    {
      localObject1 = (o)paramt;
      if (abr(((o)localObject1).rsw))
      {
        AppMethodBeat.o(37777);
        return;
      }
      this.rCp.add(((o)localObject1).rsw);
      h.c(paramString, ((o)localObject1).rsw, true, paramt.rsJ, new j.1(this, (o)localObject1));
      AppMethodBeat.o(37777);
      return;
    }
    if (paramt.rsJ == 44)
    {
      localObject1 = (n)paramt;
      if (abr(((n)localObject1).rsw))
      {
        AppMethodBeat.o(37777);
        return;
      }
      this.rCp.add(((n)localObject1).rsw);
      h.c(paramString, ((n)localObject1).rsw, true, paramt.rsJ, new j.4(this, (n)localObject1));
      AppMethodBeat.o(37777);
      return;
    }
    if (paramt.rsJ == 45)
    {
      localObject1 = (o)paramt;
      if (abr(((o)localObject1).rsw))
      {
        AppMethodBeat.o(37777);
        return;
      }
      this.rCp.add(((o)localObject1).rsw);
      h.c(paramString, ((o)localObject1).rsw, true, paramt.rsJ, new j.5(this, (o)localObject1));
      AppMethodBeat.o(37777);
      return;
    }
    Object localObject2;
    if (paramt.rsJ == 61)
    {
      paramt = (q)paramt;
      if (!abr(paramt.rsz))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        com.tencent.mm.modelcontrol.c.afT();
        if (com.tencent.mm.modelcontrol.c.a((PInt)localObject1, (PInt)localObject2))
        {
          this.rCp.add(paramt.rsz);
          h.d(paramString, paramt.rsz, true, 61, new f.a()
          {
            public final void abi(String paramAnonymousString)
            {
              AppMethodBeat.i(37766);
              j.a(j.this, paramt.rsz);
              AppMethodBeat.o(37766);
            }
            
            public final void coe()
            {
              AppMethodBeat.i(37765);
              com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramt.rsz + "is error");
              j.a(j.this, paramt.rsz);
              AppMethodBeat.o(37765);
            }
            
            public final void cqU() {}
          });
        }
      }
      if (!abr(paramt.rsA))
      {
        this.rCp.add(paramt.rsA);
        h.c(paramString, paramt.rsA, true, 1000000001, new f.a()
        {
          public final void abi(String paramAnonymousString)
          {
            AppMethodBeat.i(37768);
            j.a(j.this, paramt.rsA);
            AppMethodBeat.o(37768);
          }
          
          public final void coe()
          {
            AppMethodBeat.i(37767);
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramt.rsA + "is error");
            j.a(j.this, paramt.rsA);
            AppMethodBeat.o(37767);
          }
          
          public final void cqU() {}
        });
      }
      AppMethodBeat.o(37777);
      return;
    }
    Object localObject3;
    if (paramt.rsJ == 62)
    {
      boolean bool;
      int i;
      if (com.tencent.mm.m.g.Nq().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)paramt;
        if ((bool) && (!abr(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rsB)))
        {
          this.rCp.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rsB);
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rsB;
          i = paramt.rsJ;
          localObject3 = new j.8(this, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1);
          if ((!bo.isNullOrNil((String)localObject2)) && (!bo.isNullOrNil(paramString))) {
            break label724;
          }
          ((c.a)localObject3).CF("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!abr(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rtl))
        {
          this.rCp.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rtl);
          h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rtl, true, paramt.rsJ, new j.9(this, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1));
        }
        AppMethodBeat.o(37777);
        return;
        bool = false;
        break;
        label724:
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str1 = h.crV();
        String str2 = ag.cE((String)localObject2);
        paramString = paramString + "_stream_" + str2;
        str2 = str1 + paramString;
        if (!bo.isNullOrNil(str2))
        {
          if (com.tencent.mm.vfs.e.cN(str2))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str2 });
            al.d(new e.4((c.a)localObject3, str2));
          }
          else
          {
            new c(str1, paramString, i, new e.5((c.a)localObject3, (String)localObject2)).execute(new Void[0]);
          }
        }
        else {
          al.d(new e.6((c.a)localObject3));
        }
      }
    }
    if (paramt.rsJ == 133)
    {
      localObject2 = (p)paramt;
      localObject3 = ((p)localObject2).rrf;
      localObject1 = ((p)localObject2).rsx;
      localObject2 = ((p)localObject2).rsy;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!abr((String)localObject3)))
        {
          this.rCp.add(localObject3);
          h.c(paramString, (String)localObject3, true, paramt.rsJ, new j.10(this, (String)localObject3));
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!abr((String)localObject1)))
            {
              this.rCp.add(localObject1);
              h.c(paramString, (String)localObject1, true, paramt.rsJ, new j.11(this, (String)localObject1));
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!abr((String)localObject2)))
              {
                this.rCp.add(localObject2);
                h.c(paramString, (String)localObject2, true, paramt.rsJ, new j.2(this, (String)localObject2));
              }
              AppMethodBeat.o(37777);
              return;
            }
            catch (Throwable paramString)
            {
              com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl exp=" + paramString.toString());
            }
            localThrowable2 = localThrowable2;
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download sphereImageUrl expl=" + localThrowable2.toString());
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl exp=" + localThrowable1.toString());
          }
        }
      }
    }
    AppMethodBeat.o(37777);
  }
  
  private boolean abr(String paramString)
  {
    AppMethodBeat.i(37776);
    boolean bool = this.rCp.contains(paramString);
    AppMethodBeat.o(37776);
    return bool;
  }
  
  private void abs(String paramString)
  {
    AppMethodBeat.i(37778);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(37778);
      return;
    }
    if (abr(paramString))
    {
      AppMethodBeat.o(37778);
      return;
    }
    this.rCp.add(paramString);
    h.c("adId", paramString, true, 0, new j.3(this, paramString));
    AppMethodBeat.o(37778);
  }
  
  public static j crY()
  {
    return rCq;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(37779);
    Object localObject = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    paramString2 = i.gC(paramString2, paramString3);
    int i;
    if (paramInt == 0)
    {
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
      {
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (g)paramString2.next();
          localObject = paramString3.rCg.iterator();
          while (((Iterator)localObject).hasNext()) {
            a(paramString1, (t)((Iterator)localObject).next());
          }
          localObject = paramString3.rCh.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            a(paramString1, (t)paramString3.rCh.get(str));
          }
          abs(paramString3.rCe);
        }
        AppMethodBeat.o(37779);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
      i = com.tencent.mm.m.g.Nq().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      paramInt = com.tencent.mm.m.g.Nq().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      if (paramString2.size() > 0)
      {
        paramString2 = paramString2.iterator();
        if (paramString2.hasNext())
        {
          paramString3 = (g)paramString2.next();
          abs(paramString3.rCe);
          if ((paramInt > 0) && (i > 0))
          {
            paramString3 = paramString3.rCg.iterator();
            label284:
            if (!paramString3.hasNext()) {
              break label573;
            }
            a(paramString1, (t)paramString3.next());
            paramInt -= 1;
            if (paramInt > 0) {
              break label570;
            }
          }
        }
      }
    }
    label564:
    label567:
    label570:
    label573:
    for (;;)
    {
      i -= 1;
      break;
      AppMethodBeat.o(37779);
      return;
      if (paramInt == 1)
      {
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
        if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1))
        {
          com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
          i = com.tencent.mm.m.g.Nq().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
          paramInt = com.tencent.mm.m.g.Nq().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
          if (paramString2.size() > 0)
          {
            paramString2 = paramString2.iterator();
            if (paramString2.hasNext())
            {
              paramString3 = (g)paramString2.next();
              abs(paramString3.rCe);
              if ((paramInt > 0) && (i > 0))
              {
                paramString3 = paramString3.rCg.iterator();
                label451:
                if (!paramString3.hasNext()) {
                  break label567;
                }
                a(paramString1, (t)paramString3.next());
                paramInt -= 1;
                if (paramInt > 0) {
                  break label564;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        AppMethodBeat.o(37779);
        return;
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
        paramString1 = paramString2.iterator();
        while (paramString1.hasNext()) {
          abs(((g)paramString1.next()).rCe);
        }
        AppMethodBeat.o(37779);
        return;
        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        AppMethodBeat.o(37779);
        return;
        break label451;
      }
      break label284;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */