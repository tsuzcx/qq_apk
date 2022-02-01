package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;

public final class ad
  extends p
{
  com.tencent.mm.ui.base.p mCf = null;
  private g zDx;
  private z zGq;
  String zGr = "";
  String zGs = "";
  String zGt = "";
  volatile int zGu = -10;
  
  public ad(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    this.zGq = paramz;
  }
  
  private void dXl()
  {
    AppMethodBeat.i(197996);
    Bundle localBundle;
    if (this.zDx == null)
    {
      localBundle = new Bundle();
      localObject = this.zGq;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = ((z)localObject).zzN;; localObject = "")
    {
      localBundle.putString("qrExtInfo", (String)localObject);
      this.zDx = new g(this.context, dWZ(), 3, localBundle);
      AppMethodBeat.o(197996);
      return;
    }
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(197993);
    super.dRk();
    dXl();
    AppMethodBeat.o(197993);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(197994);
    super.dRl();
    String str;
    if (this.zGq != null)
    {
      str = this.zGq.zAs;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      if (this.zGq.zAt != 1) {}
    }
    try
    {
      AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", this.zGq.zzN, "", new b(this));
      this.zGu = 0;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "mNewQRStatus = " + this.zGu);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, dXf().zAh, new a(this, false));
      AppMethodBeat.o(197994);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", localThrowable.toString());
      }
    }
  }
  
  protected final void dWN()
  {
    AppMethodBeat.i(197995);
    dXl();
    try
    {
      if (this.zGq.zAt == 1)
      {
        if ((this.mCf == null) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
          this.mCf = com.tencent.mm.ui.base.h.b(this.context, "加载中", true, null);
        }
        if ((this.zGu == 3) && (!TextUtils.isEmpty(this.zGt)))
        {
          if (this.mCf != null)
          {
            this.mCf.dismiss();
            this.mCf = null;
          }
          this.zEb.jB("qrUrl", this.zGs);
          this.zDx.je(this.zGt, this.zGs);
          AppMethodBeat.o(197995);
          return;
        }
        if ((this.zGu == 0) || (this.zGu == 1) || (this.zGu == 2))
        {
          if (this.mCf != null) {
            this.mCf.show();
          }
          AppMethodBeat.o(197995);
          return;
        }
      }
      if (this.mCf != null)
      {
        this.mCf.dismiss();
        this.mCf = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.zEb.jB("qrUrl", this.zGq.zAs);
          this.zDx.je(this.zGr, this.zGq.zAs);
          AppMethodBeat.o(197995);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localThrowable2)));
        }
        localThrowable1 = localThrowable1;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", localThrowable1.toString());
      }
      AppMethodBeat.o(197995);
    }
    if (!TextUtils.isEmpty(this.zGr)) {}
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ad> zGv;
    private boolean zGw;
    
    a(ad paramad, boolean paramBoolean)
    {
      AppMethodBeat.i(197986);
      this.zGw = false;
      this.zGv = new WeakReference(paramad);
      this.zGw = paramBoolean;
      AppMethodBeat.o(197986);
    }
    
    public final void axG(String paramString)
    {
      AppMethodBeat.i(197989);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "download qr image completed");
      ad localad = (ad)this.zGv.get();
      if (localad != null)
      {
        if (this.zGw)
        {
          localad.zGt = paramString;
          localad.zGu = 3;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 3");
          AppMethodBeat.o(197989);
          return;
        }
        localad.zGr = paramString;
        AppMethodBeat.o(197989);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      AppMethodBeat.o(197989);
    }
    
    public final void dRW()
    {
      AppMethodBeat.i(197987);
      ad localad = (ad)this.zGv.get();
      if ((localad != null) && (this.zGw))
      {
        localad.zGu = 2;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 2");
      }
      AppMethodBeat.o(197987);
    }
    
    public final void dRX()
    {
      AppMethodBeat.i(197988);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      final ad localad = (ad)this.zGv.get();
      if ((localad != null) && (this.zGw))
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197985);
            try
            {
              if (localad.mCf != null)
              {
                localad.mCf.dismiss();
                localad.mCf = null;
              }
              AppMethodBeat.o(197985);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", localThrowable.toString());
              AppMethodBeat.o(197985);
            }
          }
        });
        localad.zGu = -2;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -2");
      }
      AppMethodBeat.o(197988);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ad> zGv;
    
    b(ad paramad)
    {
      AppMethodBeat.i(197991);
      this.zGv = new WeakReference(paramad);
      AppMethodBeat.o(197991);
    }
    
    public final void be(Object paramObject) {}
    
    public final void h(int paramInt1, int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(197992);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          bgx localbgx = new bgx();
          localbgx.parseFrom((byte[])paramObject);
          if (this.zGv != null)
          {
            paramObject = (ad)this.zGv.get();
            if (paramObject != null)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "request new qr image imgUrl completed");
              paramObject.zGs = localbgx.url;
              paramObject.zGu = 1;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 1");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramObject.zGs, paramObject.dXf().zAh, new ad.a(paramObject, true));
            }
          }
          AppMethodBeat.o(197992);
          return;
        }
        if (this.zGv != null)
        {
          paramObject = (ad)this.zGv.get();
          if (paramObject != null)
          {
            paramObject.zGu = -1;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(197990);
                try
                {
                  if (paramObject.mCf != null)
                  {
                    paramObject.mCf.dismiss();
                    paramObject.mCf = null;
                  }
                  AppMethodBeat.o(197990);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", localThrowable.toString());
                  AppMethodBeat.o(197990);
                }
              }
            });
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -1");
          }
        }
        AppMethodBeat.o(197992);
        return;
      }
      catch (Throwable paramObject)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", paramObject.toString());
        AppMethodBeat.o(197992);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */