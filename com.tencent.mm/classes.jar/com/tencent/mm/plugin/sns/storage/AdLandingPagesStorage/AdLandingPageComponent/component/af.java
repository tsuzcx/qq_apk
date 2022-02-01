package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class af
  extends q
{
  private com.tencent.mm.plugin.sns.data.h EcI;
  ab EfL;
  String EfM = "";
  String EfN = "";
  String EfO = "";
  volatile int EfP = -10;
  IListener<vd> EfQ;
  com.tencent.mm.ui.base.q nUi = null;
  
  public af(Context paramContext, ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
    this.EfL = paramab;
  }
  
  private void fdE()
  {
    AppMethodBeat.i(203017);
    Bundle localBundle;
    if (this.EcI == null)
    {
      localBundle = new Bundle();
      localObject = this.EfL;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = ((ab)localObject).DYM;; localObject = "")
    {
      localBundle.putString("qrExtInfo", (String)localObject);
      this.EcI = new com.tencent.mm.plugin.sns.data.h(this.context, fds(), 3, localBundle);
      AppMethodBeat.o(203017);
      return;
    }
  }
  
  protected final void O(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(203016);
    vd localvd = new vd();
    localvd.ebw.ebx = fdn();
    localvd.ebw.eby = paramString1;
    localvd.ebw.ebz = paramString2;
    localvd.ebw.ebA = paramInt;
    EventCenter.instance.publish(localvd);
    AppMethodBeat.o(203016);
  }
  
  protected final void eWS()
  {
    AppMethodBeat.i(203014);
    fdE();
    try
    {
      if (this.EfL.DZz == 1)
      {
        if ((this.nUi == null) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
          this.nUi = com.tencent.mm.ui.base.h.a(this.context, "加载中", true, null);
        }
        if ((this.EfP == 3) && (!TextUtils.isEmpty(this.EfO)))
        {
          if (this.nUi != null)
          {
            this.nUi.dismiss();
            this.nUi = null;
          }
          this.Edn.kv("qrUrl", this.EfN);
          this.EcI.jX(this.EfO, this.EfN);
          AppMethodBeat.o(203014);
          return;
        }
        if ((this.EfP == 0) || (this.EfP == 1) || (this.EfP == 2))
        {
          if (this.nUi != null) {
            this.nUi.show();
          }
          AppMethodBeat.o(203014);
          return;
        }
      }
      if (this.nUi != null)
      {
        this.nUi.dismiss();
        this.nUi = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.Edn.kv("qrUrl", this.EfL.DZy);
          this.EcI.jX(this.EfM, this.EfL.DZy);
          AppMethodBeat.o(203014);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localThrowable2)));
        }
        localThrowable1 = localThrowable1;
        Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable1.toString());
      }
      AppMethodBeat.o(203014);
    }
    if (!TextUtils.isEmpty(this.EfM)) {}
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(203013);
    super.eWT();
    String str;
    if (this.EfL != null)
    {
      str = this.EfL.DZy;
      Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      if (this.EfL.DZz != 1) {}
    }
    try
    {
      AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", this.EfL.DYM, "", fds().uxInfo, fdn(), fds().getSnsId(), new b(this));
      this.EfP = 0;
      Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = " + this.EfP);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, fdx().DZj, new a(this, false));
      AppMethodBeat.o(203013);
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
  
  public final void eXd()
  {
    AppMethodBeat.i(203015);
    super.eXd();
    if (this.EfQ != null)
    {
      this.EfQ.dead();
      this.EfQ = null;
    }
    AppMethodBeat.o(203015);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(203012);
    super.eXe();
    fdE();
    if (this.EfQ == null)
    {
      this.EfQ = new IListener()
      {
        private boolean a(vd paramAnonymousvd)
        {
          AppMethodBeat.i(203002);
          for (;;)
          {
            try
            {
              localaf = af.this;
              if ((paramAnonymousvd != null) && (paramAnonymousvd.ebw != null))
              {
                localObject = localaf.EfL;
                if (localObject != null) {
                  continue;
                }
              }
            }
            catch (Throwable paramAnonymousvd)
            {
              af localaf;
              Object localObject;
              String str1;
              int i;
              String str2;
              continue;
            }
            AppMethodBeat.o(203002);
            return false;
            str1 = paramAnonymousvd.ebw.ebx;
            localObject = paramAnonymousvd.ebw.eby;
            i = paramAnonymousvd.ebw.ebA;
            str2 = localaf.fdn();
            Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, from " + str1 + "; self is " + str2 + "; type is " + i);
            if ((!Util.isEqual(str1, str2)) && (!TextUtils.isEmpty(paramAnonymousvd.ebw.ebz)))
            {
              paramAnonymousvd = paramAnonymousvd.ebw.ebz;
              Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, the path is ".concat(String.valueOf(paramAnonymousvd)));
              if (i == 0)
              {
                if ((Util.isEqual((String)localObject, localaf.EfL.DZy)) && (TextUtils.isEmpty(localaf.EfM))) {
                  localaf.EfM = paramAnonymousvd;
                }
              }
              else if ((i == 1) && (Util.isEqual((String)localObject, localaf.EfN)) && (TextUtils.isEmpty(localaf.EfO))) {
                localaf.EfO = paramAnonymousvd;
              }
            }
          }
        }
      };
      this.EfQ.alive();
    }
    AppMethodBeat.o(203012);
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<af> EfS;
    private boolean EfT;
    
    a(af paramaf, boolean paramBoolean)
    {
      AppMethodBeat.i(203005);
      this.EfT = false;
      this.EfS = new WeakReference(paramaf);
      this.EfT = paramBoolean;
      AppMethodBeat.o(203005);
    }
    
    public final void aNH(String paramString)
    {
      AppMethodBeat.i(203008);
      af localaf = (af)this.EfS.get();
      if (localaf != null)
      {
        Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "download qr image completed, the path " + paramString + "; cId " + localaf.fdn());
        if (this.EfT)
        {
          localaf.EfO = paramString;
          localaf.EfP = 3;
          Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 3");
          localaf.O(1, localaf.EfN, paramString);
          AppMethodBeat.o(203008);
          return;
        }
        localaf.EfM = paramString;
        if (localaf.EfL != null)
        {
          localaf.O(0, localaf.EfL.DZy, paramString);
          AppMethodBeat.o(203008);
        }
      }
      else
      {
        Log.w("SnsAd.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      }
      AppMethodBeat.o(203008);
    }
    
    public final void eWN()
    {
      AppMethodBeat.i(203006);
      af localaf = (af)this.EfS.get();
      if ((localaf != null) && (this.EfT))
      {
        localaf.EfP = 2;
        Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 2");
      }
      AppMethodBeat.o(203006);
    }
    
    public final void eWO()
    {
      AppMethodBeat.i(203007);
      Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      final af localaf = (af)this.EfS.get();
      if ((localaf != null) && (this.EfT))
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203004);
            try
            {
              if (localaf.nUi != null)
              {
                localaf.nUi.dismiss();
                localaf.nUi = null;
              }
              AppMethodBeat.o(203004);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable.toString());
              AppMethodBeat.o(203004);
            }
          }
        });
        localaf.EfP = -2;
        Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -2");
      }
      AppMethodBeat.o(203007);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<af> EfS;
    
    b(af paramaf)
    {
      AppMethodBeat.i(203010);
      this.EfS = new WeakReference(paramaf);
      AppMethodBeat.o(203010);
    }
    
    public final void bn(Object paramObject) {}
    
    public final void h(int paramInt1, int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(203011);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          btl localbtl = new btl();
          localbtl.parseFrom((byte[])paramObject);
          if (this.EfS != null)
          {
            paramObject = (af)this.EfS.get();
            if ((paramObject != null) && (paramObject.fdn().equals(localbtl.Mac)))
            {
              Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "request new qr image imgUrl completed");
              paramObject.EfN = localbtl.url;
              paramObject.EfP = 1;
              Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 1");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramObject.EfN, paramObject.fdx().DZj, new af.a(paramObject, true));
            }
          }
          AppMethodBeat.o(203011);
          return;
        }
        if (this.EfS != null)
        {
          paramObject = (af)this.EfS.get();
          if (paramObject != null)
          {
            paramObject.EfP = -1;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203009);
                try
                {
                  if (paramObject.nUi != null)
                  {
                    paramObject.nUi.dismiss();
                    paramObject.nUi = null;
                  }
                  AppMethodBeat.o(203009);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e("SnsAd.AdLandingPageQRCodeBtnComp", localThrowable.toString());
                  AppMethodBeat.o(203009);
                }
              }
            });
            Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -1");
          }
        }
        AppMethodBeat.o(203011);
        return;
      }
      catch (Throwable paramObject)
      {
        Log.e("SnsAd.AdLandingPageQRCodeBtnComp", paramObject.toString());
        AppMethodBeat.o(203011);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af
 * JD-Core Version:    0.7.0.1
 */