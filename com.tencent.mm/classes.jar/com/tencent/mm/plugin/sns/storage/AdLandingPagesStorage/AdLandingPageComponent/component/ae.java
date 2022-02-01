package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.a.uf.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class ae
  extends q
{
  com.tencent.mm.ui.base.p mHk = null;
  private com.tencent.mm.plugin.sns.data.h zUA;
  volatile int zXA = -10;
  c<uf> zXB;
  aa zXw;
  String zXx = "";
  String zXy = "";
  String zXz = "";
  
  public ae(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    this.zXw = paramaa;
  }
  
  private void eaO()
  {
    AppMethodBeat.i(219508);
    Bundle localBundle;
    if (this.zUA == null)
    {
      localBundle = new Bundle();
      localObject = this.zXw;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = ((aa)localObject).zQM;; localObject = "")
    {
      localBundle.putString("qrExtInfo", (String)localObject);
      this.zUA = new com.tencent.mm.plugin.sns.data.h(this.context, eaD(), 3, localBundle);
      AppMethodBeat.o(219508);
      return;
    }
  }
  
  protected final void L(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219507);
    uf localuf = new uf();
    localuf.dJJ.dJK = eaz();
    localuf.dJJ.dJL = paramString1;
    localuf.dJJ.dJM = paramString2;
    localuf.dJJ.dJN = paramInt;
    a.IvT.l(localuf);
    AppMethodBeat.o(219507);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219503);
    super.dUI();
    eaO();
    if (this.zXB == null)
    {
      this.zXB = new c()
      {
        private boolean a(uf paramAnonymousuf)
        {
          AppMethodBeat.i(219493);
          for (;;)
          {
            try
            {
              localae = ae.this;
              if ((paramAnonymousuf != null) && (paramAnonymousuf.dJJ != null))
              {
                localObject = localae.zXw;
                if (localObject != null) {
                  continue;
                }
              }
            }
            catch (Throwable paramAnonymousuf)
            {
              ae localae;
              Object localObject;
              String str1;
              int i;
              String str2;
              continue;
            }
            AppMethodBeat.o(219493);
            return false;
            str1 = paramAnonymousuf.dJJ.dJK;
            localObject = paramAnonymousuf.dJJ.dJL;
            i = paramAnonymousuf.dJJ.dJN;
            str2 = localae.eaz();
            com.tencent.mm.sdk.platformtools.ae.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, from " + str1 + "; self is " + str2 + "; type is " + i);
            if ((!bu.lX(str1, str2)) && (!TextUtils.isEmpty(paramAnonymousuf.dJJ.dJM)))
            {
              paramAnonymousuf = paramAnonymousuf.dJJ.dJM;
              com.tencent.mm.sdk.platformtools.ae.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, the path is ".concat(String.valueOf(paramAnonymousuf)));
              if (i == 0)
              {
                if ((bu.lX((String)localObject, localae.zXw.zRs)) && (TextUtils.isEmpty(localae.zXx))) {
                  localae.zXx = paramAnonymousuf;
                }
              }
              else if ((i == 1) && (bu.lX((String)localObject, localae.zXy)) && (TextUtils.isEmpty(localae.zXz))) {
                localae.zXz = paramAnonymousuf;
              }
            }
          }
        }
      };
      this.zXB.alive();
    }
    AppMethodBeat.o(219503);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(219504);
    super.dUJ();
    String str;
    if (this.zXw != null)
    {
      str = this.zXw.zRs;
      com.tencent.mm.sdk.platformtools.ae.d("SnsAd.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      if (this.zXw.zRt != 1) {}
    }
    try
    {
      AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", this.zXw.zQM, "", new b(this));
      this.zXA = 0;
      com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = " + this.zXA);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, eaI().zRh, new a(this, false));
      AppMethodBeat.o(219504);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable.toString());
      }
    }
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(219506);
    super.dUM();
    if (this.zXB != null)
    {
      this.zXB.dead();
      this.zXB = null;
    }
    AppMethodBeat.o(219506);
  }
  
  protected final void ear()
  {
    AppMethodBeat.i(219505);
    eaO();
    try
    {
      if (this.zXw.zRt == 1)
      {
        if ((this.mHk == null) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
          this.mHk = com.tencent.mm.ui.base.h.b(this.context, "加载中", true, null);
        }
        if ((this.zXA == 3) && (!TextUtils.isEmpty(this.zXz)))
        {
          if (this.mHk != null)
          {
            this.mHk.dismiss();
            this.mHk = null;
          }
          this.zVg.jH("qrUrl", this.zXy);
          this.zUA.jl(this.zXz, this.zXy);
          AppMethodBeat.o(219505);
          return;
        }
        if ((this.zXA == 0) || (this.zXA == 1) || (this.zXA == 2))
        {
          if (this.mHk != null) {
            this.mHk.show();
          }
          AppMethodBeat.o(219505);
          return;
        }
      }
      if (this.mHk != null)
      {
        this.mHk.dismiss();
        this.mHk = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.zVg.jH("qrUrl", this.zXw.zRs);
          this.zUA.jl(this.zXx, this.zXw.zRs);
          AppMethodBeat.o(219505);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localThrowable2)));
        }
        localThrowable1 = localThrowable1;
        com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable1.toString());
      }
      AppMethodBeat.o(219505);
    }
    if (!TextUtils.isEmpty(this.zXx)) {}
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ae> zXD;
    private boolean zXE;
    
    a(ae paramae, boolean paramBoolean)
    {
      AppMethodBeat.i(219496);
      this.zXE = false;
      this.zXD = new WeakReference(paramae);
      this.zXE = paramBoolean;
      AppMethodBeat.o(219496);
    }
    
    public final void ayY(String paramString)
    {
      AppMethodBeat.i(219499);
      ae localae = (ae)this.zXD.get();
      if (localae != null)
      {
        com.tencent.mm.sdk.platformtools.ae.d("SnsAd.AdLandingPageQRCodeBtnComp", "download qr image completed, the path " + paramString + "; cId " + localae.eaz());
        if (this.zXE)
        {
          localae.zXz = paramString;
          localae.zXA = 3;
          com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 3");
          localae.L(1, localae.zXy, paramString);
          AppMethodBeat.o(219499);
          return;
        }
        localae.zXx = paramString;
        if (localae.zXw != null)
        {
          localae.L(0, localae.zXw.zRs, paramString);
          AppMethodBeat.o(219499);
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ae.w("SnsAd.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      }
      AppMethodBeat.o(219499);
    }
    
    public final void dVu()
    {
      AppMethodBeat.i(219497);
      ae localae = (ae)this.zXD.get();
      if ((localae != null) && (this.zXE))
      {
        localae.zXA = 2;
        com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 2");
      }
      AppMethodBeat.o(219497);
    }
    
    public final void dVv()
    {
      AppMethodBeat.i(219498);
      com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      final ae localae = (ae)this.zXD.get();
      if ((localae != null) && (this.zXE))
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219495);
            try
            {
              if (localae.mHk != null)
              {
                localae.mHk.dismiss();
                localae.mHk = null;
              }
              AppMethodBeat.o(219495);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable.toString());
              AppMethodBeat.o(219495);
            }
          }
        });
        localae.zXA = -2;
        com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -2");
      }
      AppMethodBeat.o(219498);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ae> zXD;
    
    b(ae paramae)
    {
      AppMethodBeat.i(219501);
      this.zXD = new WeakReference(paramae);
      AppMethodBeat.o(219501);
    }
    
    public final void be(Object paramObject) {}
    
    public final void h(int paramInt1, int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(219502);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          bhn localbhn = new bhn();
          localbhn.parseFrom((byte[])paramObject);
          if (this.zXD != null)
          {
            paramObject = (ae)this.zXD.get();
            if (paramObject != null)
            {
              com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "request new qr image imgUrl completed");
              paramObject.zXy = localbhn.url;
              paramObject.zXA = 1;
              com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 1");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramObject.zXy, paramObject.eaI().zRh, new ae.a(paramObject, true));
            }
          }
          AppMethodBeat.o(219502);
          return;
        }
        if (this.zXD != null)
        {
          paramObject = (ae)this.zXD.get();
          if (paramObject != null)
          {
            paramObject.zXA = -1;
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219500);
                try
                {
                  if (paramObject.mHk != null)
                  {
                    paramObject.mHk.dismiss();
                    paramObject.mHk = null;
                  }
                  AppMethodBeat.o(219500);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable.toString());
                  AppMethodBeat.o(219500);
                }
              }
            });
            com.tencent.mm.sdk.platformtools.ae.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -1");
          }
        }
        AppMethodBeat.o(219502);
        return;
      }
      catch (Throwable paramObject)
      {
        com.tencent.mm.sdk.platformtools.ae.e("SnsAd.AdLandingPageQRCodeBtnComp", paramObject.toString());
        AppMethodBeat.o(219502);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */