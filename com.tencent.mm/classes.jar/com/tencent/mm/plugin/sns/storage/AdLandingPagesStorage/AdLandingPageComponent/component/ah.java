package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ya;
import com.tencent.mm.plugin.sns.ad.landingpage.a.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.j.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

public final class ah
  extends r
{
  private j.a QOr;
  private j QRl;
  ac QRq;
  String QRr;
  String QRs;
  String QRt;
  volatile int QRu;
  IListener<ya> QRv;
  w ubo;
  
  public ah(Context paramContext, ac paramac, ViewGroup paramViewGroup)
  {
    super(paramContext, paramac, paramViewGroup);
    AppMethodBeat.i(306918);
    this.QRr = "";
    this.QRs = "";
    this.QRt = "";
    this.QRu = -10;
    this.ubo = null;
    this.QOr = new j.a()
    {
      public final void a(String paramAnonymousString1, boolean paramAnonymousBoolean, String paramAnonymousString2, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(306891);
        Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "onFinish, isSucc=" + paramAnonymousBoolean + ", errMsg=" + paramAnonymousString2 + ", url=" + paramAnonymousString1);
        ah.this.hjy();
        AppMethodBeat.o(306891);
      }
    };
    this.QRq = paramac;
    AppMethodBeat.o(306918);
  }
  
  private void hjz()
  {
    AppMethodBeat.i(306921);
    Bundle localBundle;
    ac localac;
    String str;
    if (this.QRl == null)
    {
      localBundle = new Bundle();
      localac = this.QRq;
      if (localac == null) {
        break label89;
      }
      str = localac.QKl;
      localBundle.putString("qrExtInfo", str);
      if (localac == null) {
        break label95;
      }
    }
    label89:
    label95:
    for (int i = localac.QKZ;; i = 0)
    {
      localBundle.putInt("qrIsDirectJump", i);
      this.QRl = new j(this.context, hjn(), 3, localBundle);
      AppMethodBeat.o(306921);
      return;
      str = "";
      break;
    }
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(306923);
    super.Gs();
    hjz();
    if (this.QRv == null)
    {
      this.QRv = new AdLandingPageQRCodeBtnComp.3(this, f.hfK);
      this.QRv.alive();
    }
    AppMethodBeat.o(306923);
  }
  
  protected final void U(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(306943);
    ya localya = new ya();
    localya.ibv.ibw = this.QOV.QKG;
    localya.ibv.ibx = paramString1;
    localya.ibv.iby = paramString2;
    localya.ibv.ibz = paramInt;
    localya.publish();
    AppMethodBeat.o(306943);
  }
  
  protected final void hac()
  {
    AppMethodBeat.i(306932);
    hjz();
    try
    {
      if ((this.ubo == null) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
        this.ubo = a.aU(this.context, b.j.sns_ad_loading);
      }
      if ((this.ubo != null) && (!this.ubo.isShowing())) {
        this.ubo.show();
      }
      Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "qrScanDirectJump=" + this.QRq.QKZ);
      if (this.QRq.QKY == 1)
      {
        if ((this.QRu == 3) && (!TextUtils.isEmpty(this.QRt)))
        {
          this.QPl.mx("qrUrl", this.QRs);
          this.QPl.bD("qrScanDirectJump", this.QRq.QKZ);
          if (this.QRq.QKZ == 1)
          {
            this.QRl.b(this.QRt, this.QRs, this.QOr);
            AppMethodBeat.o(306932);
            return;
          }
          this.QRl.a(this.QRt, this.QRs, this.QOr);
          AppMethodBeat.o(306932);
          return;
        }
        if ((this.QRu != 0) && (this.QRu != 1))
        {
          int i = this.QRu;
          if (i != 2) {}
        }
        else
        {
          AppMethodBeat.o(306932);
          return;
        }
      }
    }
    finally
    {
      Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localObject1.toString());
      if (!TextUtils.isEmpty(this.QRr))
      {
        try
        {
          this.QPl.mx("qrUrl", this.QRq.QKX);
          this.QPl.bD("qrScanDirectJump", this.QRq.QKZ);
          if (this.QRq.QKZ != 1) {
            break label376;
          }
          this.QRl.b(this.QRr, this.QRq.QKX, this.QOr);
          AppMethodBeat.o(306932);
          return;
        }
        finally
        {
          Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localObject2)));
        }
      }
      else
      {
        AppMethodBeat.o(306932);
        return;
      }
    }
    label376:
    this.QRl.a(this.QRr, this.QRq.QKX, this.QOr);
    AppMethodBeat.o(306932);
  }
  
  protected final void had()
  {
    AppMethodBeat.i(306927);
    super.had();
    String str;
    if (this.QRq != null)
    {
      str = this.QRq.QKX;
      Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      if (this.QRq.QKY != 1) {}
    }
    try
    {
      AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", this.QRq.QKl, "", hjn().uxInfo, this.QOV.QKG, hjn().getSnsId(), new b(this));
      this.QRu = 0;
      Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = " + this.QRu);
      k.b("adId", str, new a(this, false));
      AppMethodBeat.o(306927);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localObject.toString());
      }
    }
  }
  
  public final void has()
  {
    AppMethodBeat.i(306940);
    super.has();
    if (this.QRv != null)
    {
      this.QRv.dead();
      this.QRv = null;
    }
    AppMethodBeat.o(306940);
  }
  
  public final void hjy()
  {
    AppMethodBeat.i(306937);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(306887);
        try
        {
          if ((ah.this.ubo != null) && (ah.this.ubo.isShowing())) {
            ah.this.ubo.dismiss();
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(306887);
        }
      }
    });
    AppMethodBeat.o(306937);
  }
  
  public static final class a
    implements g.a
  {
    WeakReference<ah> QRx;
    private boolean QRy;
    
    a(ah paramah, boolean paramBoolean)
    {
      AppMethodBeat.i(307229);
      this.QRy = false;
      this.QRx = new WeakReference(paramah);
      this.QRy = paramBoolean;
      AppMethodBeat.o(307229);
    }
    
    public final void aWn(String paramString)
    {
      AppMethodBeat.i(307244);
      ah localah = (ah)this.QRx.get();
      if (localah != null)
      {
        Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "download qr image completed, the path " + paramString + "; cId " + localah.QOV.QKG);
        if (this.QRy)
        {
          localah.QRt = paramString;
          localah.QRu = 3;
          Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 3");
          localah.U(1, localah.QRs, paramString);
          AppMethodBeat.o(307244);
          return;
        }
        localah.QRr = paramString;
        if (localah.QRq != null)
        {
          localah.U(0, localah.QRq.QKX, paramString);
          AppMethodBeat.o(307244);
        }
      }
      else
      {
        Log.w("SnsAd.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      }
      AppMethodBeat.o(307244);
    }
    
    public final void gZM()
    {
      AppMethodBeat.i(307235);
      ah localah = (ah)this.QRx.get();
      if ((localah != null) && (this.QRy))
      {
        localah.QRu = 2;
        Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 2");
      }
      AppMethodBeat.o(307235);
    }
    
    public final void gZN()
    {
      AppMethodBeat.i(307240);
      Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      ah localah = (ah)this.QRx.get();
      if (localah != null)
      {
        if (this.QRy)
        {
          localah.QRu = -2;
          Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -2");
        }
        localah.hjy();
      }
      AppMethodBeat.o(307240);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ah> QRx;
    
    b(ah paramah)
    {
      AppMethodBeat.i(307242);
      this.QRx = new WeakReference(paramah);
      AppMethodBeat.o(307242);
    }
    
    public final void h(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(307253);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          cqm localcqm = new cqm();
          localcqm.parseFrom((byte[])paramObject);
          if (this.QRx != null)
          {
            paramObject = (ah)this.QRx.get();
            if ((paramObject != null) && (paramObject.QOV.QKG.equals(localcqm.aawY)))
            {
              Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "request new qr image imgUrl completed");
              paramObject.QRs = localcqm.url;
              paramObject.QRu = 1;
              Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 1");
              k.b("adId", paramObject.QRs, new ah.a(paramObject, true));
            }
          }
          AppMethodBeat.o(307253);
          return;
        }
        if (this.QRx != null)
        {
          paramObject = (ah)this.QRx.get();
          if (paramObject != null)
          {
            paramObject.QRu = -1;
            Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -1");
          }
        }
        AppMethodBeat.o(307253);
        return;
      }
      finally
      {
        Log.e("SnsAd.AdLandingPageQRCodeBtnComp", paramObject.toString());
        AppMethodBeat.o(307253);
      }
    }
    
    public final void onCallback(Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah
 * JD-Core Version:    0.7.0.1
 */