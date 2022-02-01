package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
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
  private static j Ely;
  ConcurrentLinkedQueue<String> Elx;
  
  static
  {
    AppMethodBeat.i(97391);
    Ely = new j();
    AppMethodBeat.o(97391);
  }
  
  private j()
  {
    AppMethodBeat.i(97385);
    this.Elx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(97385);
  }
  
  public static void a(final ds paramds, final boolean paramBoolean)
  {
    AppMethodBeat.i(203179);
    String str = com.tencent.mm.platformtools.z.a(paramds.KHG.MYI);
    if (!Util.isNullOrNil(str)) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203170);
          int i;
          Object localObject;
          if ((new ADXml(this.ElE).isLandingPagesAd()) && (i.aQg(this.ElE)))
          {
            i = 0;
            if (paramBoolean) {
              i = 6;
            }
            localObject = "";
          }
          try
          {
            str = r.Jb(paramds.KHG.MYH.Id);
            localObject = str;
          }
          catch (Exception localException)
          {
            String str;
            label66:
            break label66;
          }
          Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages, scene=" + i + ", snsId=" + (String)localObject);
          j.fez().h("adId", this.ElE, "adxml", i);
          str = ADXml.getGestureCanvasInfo(this.ElE);
          if (i.aQg(str))
          {
            i = 1;
            if (paramBoolean) {
              i = 7;
            }
            Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages for gestureAdXml, scene=" + i + ", snsId=" + (String)localObject);
            j.fez().h("adId", str, "adxml", i);
          }
          AppMethodBeat.o(203170);
        }
      }, "predownloadAdLandingPages");
    }
    AppMethodBeat.o(203179);
  }
  
  private void a(String paramString, final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z paramz)
  {
    AppMethodBeat.i(97387);
    Object localObject1;
    final int i;
    if (i.Zi(paramz.type))
    {
      localObject1 = new ArrayList();
      if (i.Zj(paramz.type)) {
        ((List)localObject1).addAll(((ak)paramz).eXg());
      }
      for (;;)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramString, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)((Iterator)localObject1).next());
        }
        if (i.Zm(paramz.type)) {
          ((List)localObject1).addAll(((x)paramz).aQz);
        } else if (i.Zk(paramz.type)) {
          ((List)localObject1).addAll(((aa)paramz).eXg());
        } else if (i.Zl(paramz.type)) {
          ((List)localObject1).addAll(((y)paramz).eXg());
        } else if (i.Zn(paramz.type)) {
          ((List)localObject1).addAll(((b)paramz).eXg());
        }
      }
      if (i.Zn(paramz.type))
      {
        paramz = (b)paramz;
        i = paramz.DZj;
        paramz = paramz.DtQ;
        if (TextUtils.isEmpty(paramz))
        {
          Log.w("AdLandingPagesPreDownloadResHelper", "predownload imgUrl==null, compType=".concat(String.valueOf(i)));
          AppMethodBeat.o(97387);
          return;
        }
        if (aQh(paramz))
        {
          Log.w("AdLandingPagesPreDownloadResHelper", "predownload img busy, compType=" + i + ", url=" + paramz);
          AppMethodBeat.o(97387);
          return;
        }
        this.Elx.add(paramz);
        h.a(paramString, paramz, true, i, new f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(203169);
            Log.d("AdLandingPagesPreDownloadResHelper", "predownload img succ, compType=" + i + ", url=" + paramz);
            j.a(j.this, paramz);
            AppMethodBeat.o(203169);
          }
          
          public final void eWN() {}
          
          public final void eWO()
          {
            AppMethodBeat.i(203168);
            Log.e("AdLandingPagesPreDownloadResHelper", "predownload img err, compType=" + i + ", url=" + paramz);
            j.a(j.this, paramz);
            AppMethodBeat.o(203168);
          }
        });
      }
      AppMethodBeat.o(97387);
      return;
    }
    if (paramz.DZj == 41)
    {
      localObject1 = (t)paramz;
      if (aQh(((t)localObject1).DYK))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.Elx.add(((t)localObject1).DYK);
      h.a(paramString, ((t)localObject1).DYK, true, paramz.DZj, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(97361);
          j.a(j.this, this.Elz.DYK);
          AppMethodBeat.o(97361);
        }
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(97360);
          Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Elz.DYK + "is error");
          j.a(j.this, this.Elz.DYK);
          AppMethodBeat.o(97360);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramz.DZj == 44)
    {
      localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramz;
      if (aQh(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject1).DYK))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.Elx.add(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject1).DYK);
      h.a(paramString, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject1).DYK, true, paramz.DZj, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(97368);
          j.a(j.this, this.ElI.DYK);
          AppMethodBeat.o(97368);
        }
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(97367);
          Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.ElI.DYK + "is error");
          j.a(j.this, this.ElI.DYK);
          AppMethodBeat.o(97367);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    if (paramz.DZj == 45)
    {
      localObject1 = (t)paramz;
      if (aQh(((t)localObject1).DYK))
      {
        AppMethodBeat.o(97387);
        return;
      }
      this.Elx.add(((t)localObject1).DYK);
      h.a(paramString, ((t)localObject1).DYK, true, paramz.DZj, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(97370);
          j.a(j.this, this.Elz.DYK);
          AppMethodBeat.o(97370);
        }
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(97369);
          Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.Elz.DYK + "is error");
          j.a(j.this, this.Elz.DYK);
          AppMethodBeat.o(97369);
        }
      });
      AppMethodBeat.o(97387);
      return;
    }
    Object localObject2;
    if (paramz.DZj == 61)
    {
      paramz = (v)paramz;
      if (!aQh(paramz.DYQ))
      {
        localObject1 = new PInt();
        localObject2 = new PInt();
        d.baW();
        if (d.a((PInt)localObject1, (PInt)localObject2))
        {
          this.Elx.add(paramz.DYQ);
          if (paramz.DYZ) {
            break label700;
          }
          h.b(paramString, paramz.DYQ, true, 61, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(97372);
              j.a(j.this, paramz.DYQ);
              AppMethodBeat.o(97372);
            }
            
            public final void eWN() {}
            
            public final void eWO()
            {
              AppMethodBeat.i(97371);
              Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + paramz.DYQ);
              j.a(j.this, paramz.DYQ);
              AppMethodBeat.o(97371);
            }
          });
        }
      }
      for (;;)
      {
        if (!aQh(paramz.DYR))
        {
          this.Elx.add(paramz.DYR);
          h.a(paramString, paramz.DYR, true, 1000000001, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(203175);
              j.a(j.this, paramz.DYR);
              AppMethodBeat.o(203175);
            }
            
            public final void eWN() {}
            
            public final void eWO()
            {
              AppMethodBeat.i(203174);
              Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + paramz.DYR);
              j.a(j.this, paramz.DYR);
              AppMethodBeat.o(203174);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        label700:
        h.b(paramString, paramz.DYQ, new f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(97374);
            j.a(j.this, paramz.DYQ);
            AppMethodBeat.o(97374);
          }
          
          public final void eWN() {}
          
          public final void eWO()
          {
            AppMethodBeat.i(97373);
            Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + paramz.DYQ);
            j.a(j.this, paramz.DYQ);
            AppMethodBeat.o(97373);
          }
        });
      }
    }
    Object localObject3;
    if (paramz.DZj == 62)
    {
      boolean bool;
      if (com.tencent.mm.n.h.aqJ().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0)
      {
        bool = true;
        Log.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(bool)));
        localObject1 = (am)paramz;
        if ((bool) && (!aQh(((am)localObject1).DYS)))
        {
          this.Elx.add(((am)localObject1).DYS);
          localObject2 = ((am)localObject1).DYS;
          i = paramz.DZj;
          localObject3 = new c.a()
          {
            public final void Hn(String paramAnonymousString)
            {
              AppMethodBeat.i(203177);
              j.a(j.this, this.ElK.DYS);
              AppMethodBeat.o(203177);
            }
            
            public final void aas(String paramAnonymousString)
            {
              AppMethodBeat.i(203176);
              Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.ElK.DYS + "is error");
              j.a(j.this, this.ElK.DYS);
              AppMethodBeat.o(203176);
            }
            
            public final void dx(String paramAnonymousString, int paramAnonymousInt) {}
          };
          if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(paramString))) {
            break label909;
          }
          ((c.a)localObject3).aas("the res or adId is null");
        }
      }
      for (;;)
      {
        if (!aQh(((am)localObject1).Ead))
        {
          this.Elx.add(((am)localObject1).Ead);
          h.a("adId", ((am)localObject1).Ead, true, paramz.DZj, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(97381);
              j.a(j.this, this.ElK.Ead);
              AppMethodBeat.o(97381);
            }
            
            public final void eWN()
            {
              AppMethodBeat.i(97379);
              AppMethodBeat.o(97379);
            }
            
            public final void eWO()
            {
              AppMethodBeat.i(97380);
              Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.ElK.Ead + "is error");
              j.a(j.this, this.ElK.DYS);
              AppMethodBeat.o(97380);
            }
          });
        }
        AppMethodBeat.o(97387);
        return;
        bool = false;
        break;
        label909:
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + (String)localObject2 + " for adid:" + paramString);
        String str1 = h.few();
        String str2 = MD5Util.getMD5String((String)localObject2);
        paramString = paramString + "_stream_" + str2;
        str2 = str1 + paramString;
        if (!Util.isNullOrNil(str2))
        {
          if (com.tencent.mm.vfs.s.YS(str2))
          {
            Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str2 });
            MMHandlerThread.postToMainThread(new e.4((c.a)localObject3, str2));
          }
          else
          {
            new c(str1, paramString, i, new e.5((c.a)localObject3, (String)localObject2)).execute(new Void[0]);
          }
        }
        else {
          MMHandlerThread.postToMainThread(new e.6((c.a)localObject3));
        }
      }
    }
    if (paramz.DZj == 133)
    {
      localObject2 = (u)paramz;
      localObject3 = ((u)localObject2).DWL;
      localObject1 = ((u)localObject2).DYO;
      localObject2 = ((u)localObject2).DYP;
      try
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!aQh((String)localObject3)))
        {
          this.Elx.add(localObject3);
          h.a(paramString, (String)localObject3, true, paramz.DZj, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(97384);
              j.a(j.this, this.ElL);
              Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.ElL);
              AppMethodBeat.o(97384);
            }
            
            public final void eWN()
            {
              AppMethodBeat.i(97382);
              Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
              AppMethodBeat.o(97382);
            }
            
            public final void eWO()
            {
              AppMethodBeat.i(97383);
              Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.ElL);
              j.a(j.this, this.ElL);
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
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!aQh((String)localObject1)))
            {
              this.Elx.add(localObject1);
              h.a(paramString, (String)localObject1, true, paramz.DZj, new f.a()
              {
                public final void aNH(String paramAnonymousString)
                {
                  AppMethodBeat.i(97364);
                  j.a(j.this, this.ElB);
                  Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + this.ElB);
                  AppMethodBeat.o(97364);
                }
                
                public final void eWN()
                {
                  AppMethodBeat.i(97362);
                  Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
                  AppMethodBeat.o(97362);
                }
                
                public final void eWO()
                {
                  AppMethodBeat.i(97363);
                  Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + this.ElB);
                  j.a(j.this, this.ElB);
                  AppMethodBeat.o(97363);
                }
              });
            }
            try
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!aQh((String)localObject2)))
              {
                this.Elx.add(localObject2);
                h.a(paramString, (String)localObject2, true, paramz.DZj, new f.a()
                {
                  public final void aNH(String paramAnonymousString)
                  {
                    AppMethodBeat.i(97366);
                    j.a(j.this, this.ElC);
                    Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.ElC);
                    AppMethodBeat.o(97366);
                  }
                  
                  public final void eWN()
                  {
                    AppMethodBeat.i(203165);
                    Log.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
                    AppMethodBeat.o(203165);
                  }
                  
                  public final void eWO()
                  {
                    AppMethodBeat.i(97365);
                    Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.ElC);
                    j.a(j.this, this.ElC);
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
            }
            localThrowable2 = localThrowable2;
            Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download sphereImageUrl expl=" + localThrowable2.toString());
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Log.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl exp=" + localThrowable1.toString());
          }
        }
      }
    }
    AppMethodBeat.o(97387);
  }
  
  private boolean aQh(String paramString)
  {
    AppMethodBeat.i(97386);
    boolean bool = this.Elx.contains(paramString);
    AppMethodBeat.o(97386);
    return bool;
  }
  
  private void aQi(final String paramString)
  {
    AppMethodBeat.i(97388);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    if (aQh(paramString))
    {
      AppMethodBeat.o(97388);
      return;
    }
    this.Elx.add(paramString);
    h.a("adId", paramString, true, 0, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(203167);
        j.a(j.this, paramString);
        AppMethodBeat.o(203167);
      }
      
      public final void eWN() {}
      
      public final void eWO()
      {
        AppMethodBeat.i(203166);
        Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + paramString + "is error");
        j.a(j.this, paramString);
        AppMethodBeat.o(203166);
      }
    });
    AppMethodBeat.o(97388);
  }
  
  public static void aQj(String paramString)
  {
    AppMethodBeat.i(203181);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203181);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203172);
        if (i.aQg(this.ElH))
        {
          Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForMsg");
          j.fez().h("adId", this.ElH, "adxml", 5);
          AppMethodBeat.o(203172);
          return;
        }
        Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForMsg, invalid canvas");
        AppMethodBeat.o(203172);
      }
    }, "preDownloadAdLandingPagesForMsg");
    AppMethodBeat.o(203181);
  }
  
  public static void aQk(String paramString)
  {
    AppMethodBeat.i(203182);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203182);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203173);
        if (i.aQg(this.ElH))
        {
          Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg");
          j.fez().h("adId", this.ElH, "adxml", 2);
          String str = ADXml.getGestureCanvasInfo(this.ElH);
          if (i.aQg(str))
          {
            Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg for gestureAdXml");
            j.fez().h("adId", str, "adxml", 3);
          }
          AppMethodBeat.o(203173);
          return;
        }
        Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg, inValidCanvas");
        AppMethodBeat.o(203173);
      }
    }, "preDownloadAdLandingPagesForAtMsg");
    AppMethodBeat.o(203182);
  }
  
  public static void br(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(203180);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(203180);
      return;
    }
    n localn = aj.faO();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject = (SnsObject)paramLinkedList.get(i);
      SnsInfo localSnsInfo;
      if (localObject != null)
      {
        localSnsInfo = localn.JJ(((SnsObject)localObject).Id);
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
              AppMethodBeat.i(203171);
              if (i.aQg(this.ElH))
              {
                Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, snsId=" + this.jrJ);
                j.fez().h("adId", this.ElH, "adxml", 4);
                AppMethodBeat.o(203171);
                return;
              }
              Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, invalid canvas, snsId=" + this.jrJ);
              AppMethodBeat.o(203171);
            }
          }, "preDownloadAdLandingPagesForSnsObject");
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(203180);
  }
  
  public static void d(LinkedList<ds> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(203178);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(203178);
      return;
    }
    int i = 0;
    while (i < paramLinkedList.size())
    {
      a((ds)paramLinkedList.get(i), paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(203178);
  }
  
  public static j fez()
  {
    return Ely;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3, int paramInt)
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
        paramString3 = paramString2.Elq;
        paramString2 = paramString2.Elr;
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
          aQi(((g)localObject).Elg);
          if ((paramInt <= 0) || (j <= 0)) {
            break label495;
          }
          Iterator localIterator = ((g)localObject).Eli.iterator();
          i = paramInt;
          if (localIterator.hasNext())
          {
            a(paramString1, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)localIterator.next());
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
          localIterator = ((g)localObject).Elj.keySet().iterator();
          j = k;
          paramInt = i;
          if (!localIterator.hasNext()) {
            continue;
          }
          String str = (String)localIterator.next();
          Log.i("AdLandingPagesPreDownloadResHelper", "preload floatComponent, cid=".concat(String.valueOf(str)));
          a(paramString1, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)((g)localObject).Elj.get(str));
          continue;
          j = com.tencent.mm.n.h.aqJ().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
        }
      }
      catch (Throwable paramString1)
      {
        Log.e("AdLandingPagesPreDownloadResHelper", "startPreDownloadResource, exp=" + paramString1.toString());
        AppMethodBeat.o(97389);
        return;
      }
      i = com.tencent.mm.n.h.aqJ().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
      continue;
      j = com.tencent.mm.n.h.aqJ().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
      i = com.tencent.mm.n.h.aqJ().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
      continue;
      label486:
      paramInt = paramString3.size();
      continue;
      label495:
      if (paramString2 != null)
      {
        Log.i("AdLandingPagesPreDownloadResHelper", "preload floatBarComp");
        if (!TextUtils.isEmpty(paramString2.DZB)) {
          aQi(paramString2.DZB);
        }
        if (!TextUtils.isEmpty(paramString2.iconUrl)) {
          aQi(paramString2.iconUrl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j
 * JD-Core Version:    0.7.0.1
 */