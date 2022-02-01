package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wh;
import com.tencent.mm.f.a.wh.a;
import com.tencent.mm.plugin.sns.ad.landingpage.a.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;

public final class ae
  extends q
{
  j Kqk;
  ac KsQ;
  String KsR = "";
  String KsS = "";
  String KsT = "";
  volatile int KsU = -10;
  IListener<wh> KsV;
  s qVG = null;
  
  public ae(Context paramContext, ac paramac, ViewGroup paramViewGroup)
  {
    super(paramContext, paramac, paramViewGroup);
    this.KsQ = paramac;
  }
  
  private void fRz()
  {
    AppMethodBeat.i(231703);
    Bundle localBundle;
    ac localac;
    String str;
    if (this.Kqk == null)
    {
      localBundle = new Bundle();
      localac = this.KsQ;
      if (localac == null) {
        break label89;
      }
      str = localac.Kmh;
      localBundle.putString("qrExtInfo", str);
      if (localac == null) {
        break label95;
      }
    }
    label89:
    label95:
    for (int i = localac.KmU;; i = 0)
    {
      localBundle.putInt("qrIsDirectJump", i);
      this.Kqk = new j(this.context, fRp(), 3, localBundle);
      AppMethodBeat.o(231703);
      return;
      str = "";
      break;
    }
  }
  
  protected final void R(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(231702);
    wh localwh = new wh();
    localwh.fVv.fVw = this.KqB.KmB;
    localwh.fVv.fVx = paramString1;
    localwh.fVv.fVy = paramString2;
    localwh.fVv.fVz = paramInt;
    EventCenter.instance.publish(localwh);
    AppMethodBeat.o(231702);
  }
  
  protected final void fKd()
  {
    AppMethodBeat.i(231697);
    fRz();
    try
    {
      if ((this.qVG == null) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
        this.qVG = a.aH(this.context, i.j.sns_ad_loading);
      }
      if ((this.qVG != null) && (!this.qVG.isShowing())) {
        this.qVG.show();
      }
      if (this.KsQ.KmT == 1)
      {
        if ((this.KsU == 3) && (!TextUtils.isEmpty(this.KsT)))
        {
          this.KqQ.kQ("qrUrl", this.KsS);
          this.KqQ.br("qrScanDirectJump", this.KsQ.KmU);
          if (this.KsQ.KmU == 1)
          {
            this.Kqk.b(this.KsT, this.KsS, this.qVG);
            AppMethodBeat.o(231697);
            return;
          }
          this.Kqk.a(this.KsT, this.KsS, this.qVG);
          AppMethodBeat.o(231697);
          return;
        }
        if ((this.KsU != 0) && (this.KsU != 1))
        {
          int i = this.KsU;
          if (i != 2) {}
        }
        else
        {
          AppMethodBeat.o(231697);
          return;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable1.toString());
      if (!TextUtils.isEmpty(this.KsR))
      {
        try
        {
          this.KqQ.kQ("qrUrl", this.KsQ.KmS);
          this.KqQ.br("qrScanDirectJump", this.KsQ.KmU);
          if (this.KsQ.KmU != 1) {
            break label348;
          }
          this.Kqk.b(this.KsR, this.KsQ.KmS, this.qVG);
          AppMethodBeat.o(231697);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localThrowable2)));
        }
      }
      else
      {
        AppMethodBeat.o(231697);
        return;
      }
    }
    label348:
    this.Kqk.a(this.KsR, this.KsQ.KmS, this.qVG);
    AppMethodBeat.o(231697);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(231690);
    super.fKe();
    String str;
    if (this.KsQ != null)
    {
      str = this.KsQ.KmS;
      Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      if (this.KsQ.KmT != 1) {}
    }
    try
    {
      AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", this.KsQ.Kmh, "", fRp().uxInfo, this.KqB.KmB, fRp().getSnsId(), new b(this));
      this.KsU = 0;
      Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = " + this.KsU);
      h.a("adId", str, new a(this, false));
      AppMethodBeat.o(231690);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable.toString());
      }
    }
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(231699);
    super.fKo();
    if (this.KsV != null)
    {
      this.KsV.dead();
      this.KsV = null;
    }
    AppMethodBeat.o(231699);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(231687);
    super.fKp();
    fRz();
    if (this.KsV == null)
    {
      this.KsV = new IListener()
      {
        private boolean a(wh paramAnonymouswh)
        {
          AppMethodBeat.i(269193);
          for (;;)
          {
            try
            {
              localae = ae.this;
              if ((paramAnonymouswh != null) && (paramAnonymouswh.fVv != null))
              {
                localObject = localae.KsQ;
                if (localObject != null) {
                  continue;
                }
              }
            }
            catch (Throwable paramAnonymouswh)
            {
              ae localae;
              Object localObject;
              String str1;
              int i;
              String str2;
              continue;
            }
            AppMethodBeat.o(269193);
            return false;
            str1 = paramAnonymouswh.fVv.fVw;
            localObject = paramAnonymouswh.fVv.fVx;
            i = paramAnonymouswh.fVv.fVz;
            str2 = localae.KqB.KmB;
            Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, from " + str1 + "; self is " + str2 + "; type is " + i);
            if ((!Util.isEqual(str1, str2)) && (!TextUtils.isEmpty(paramAnonymouswh.fVv.fVy)))
            {
              paramAnonymouswh = paramAnonymouswh.fVv.fVy;
              Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, the path is ".concat(String.valueOf(paramAnonymouswh)));
              if (i == 0)
              {
                if ((Util.isEqual((String)localObject, localae.KsQ.KmS)) && (TextUtils.isEmpty(localae.KsR))) {
                  localae.KsR = paramAnonymouswh;
                }
              }
              else if ((i == 1) && (Util.isEqual((String)localObject, localae.KsS)) && (TextUtils.isEmpty(localae.KsT))) {
                localae.KsT = paramAnonymouswh;
              }
            }
          }
        }
      };
      this.KsV.alive();
    }
    AppMethodBeat.o(231687);
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ae> KsX;
    private boolean KsY;
    
    a(ae paramae, boolean paramBoolean)
    {
      AppMethodBeat.i(268118);
      this.KsY = false;
      this.KsX = new WeakReference(paramae);
      this.KsY = paramBoolean;
      AppMethodBeat.o(268118);
    }
    
    public final void aYs(String paramString)
    {
      AppMethodBeat.i(268122);
      ae localae = (ae)this.KsX.get();
      if (localae != null)
      {
        Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "download qr image completed, the path " + paramString + "; cId " + localae.KqB.KmB);
        if (this.KsY)
        {
          localae.KsT = paramString;
          localae.KsU = 3;
          Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 3");
          localae.R(1, localae.KsS, paramString);
          AppMethodBeat.o(268122);
          return;
        }
        localae.KsR = paramString;
        if (localae.KsQ != null)
        {
          localae.R(0, localae.KsQ.KmS, paramString);
          AppMethodBeat.o(268122);
        }
      }
      else
      {
        Log.w("SnsAd.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      }
      AppMethodBeat.o(268122);
    }
    
    public final void fJU()
    {
      AppMethodBeat.i(268119);
      ae localae = (ae)this.KsX.get();
      if ((localae != null) && (this.KsY))
      {
        localae.KsU = 2;
        Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 2");
      }
      AppMethodBeat.o(268119);
    }
    
    public final void fJV()
    {
      AppMethodBeat.i(268121);
      Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      ae localae = (ae)this.KsX.get();
      if (localae != null)
      {
        if (this.KsY)
        {
          localae.KsU = -2;
          Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -2");
        }
        if (localae.Kqk != null) {
          localae.Kqk.a(localae.qVG);
        }
      }
      AppMethodBeat.o(268121);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ae> KsX;
    
    b(ae paramae)
    {
      AppMethodBeat.i(266426);
      this.KsX = new WeakReference(paramae);
      AppMethodBeat.o(266426);
    }
    
    public final void aH(Object paramObject) {}
    
    public final void i(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(266427);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          cbd localcbd = new cbd();
          localcbd.parseFrom((byte[])paramObject);
          if (this.KsX != null)
          {
            paramObject = (ae)this.KsX.get();
            if ((paramObject != null) && (paramObject.KqB.KmB.equals(localcbd.Tjv)))
            {
              Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "request new qr image imgUrl completed");
              paramObject.KsS = localcbd.url;
              paramObject.KsU = 1;
              Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 1");
              h.a("adId", paramObject.KsS, new ae.a(paramObject, true));
            }
          }
          AppMethodBeat.o(266427);
          return;
        }
        if (this.KsX != null)
        {
          paramObject = (ae)this.KsX.get();
          if (paramObject != null)
          {
            paramObject.KsU = -1;
            Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -1");
          }
        }
        AppMethodBeat.o(266427);
        return;
      }
      catch (Throwable paramObject)
      {
        Log.e("SnsAd.AdLandingPageQRCodeBtnComp", paramObject.toString());
        AppMethodBeat.o(266427);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */