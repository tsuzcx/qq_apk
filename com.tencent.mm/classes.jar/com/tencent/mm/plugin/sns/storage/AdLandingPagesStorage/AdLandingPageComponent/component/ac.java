package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class ac
  extends o
{
  private g wZQ;
  private z xcH;
  String xcI = "";
  
  public ac(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    this.xcH = paramz;
  }
  
  private void dwv()
  {
    AppMethodBeat.i(187419);
    Bundle localBundle;
    if (this.wZQ == null)
    {
      localBundle = new Bundle();
      localObject = this.xcH;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = ((z)localObject).wWr;; localObject = "")
    {
      localBundle.putString("qrExtInfo", (String)localObject);
      this.wZQ = new g(this.context, dwi(), 3, localBundle);
      AppMethodBeat.o(187419);
      return;
    }
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(187417);
    super.dvN();
    if (this.xcH != null)
    {
      String str = this.xcH.wWQ;
      ad.d("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      h.a(str, dwo().wWF, new a(this));
    }
    AppMethodBeat.o(187417);
  }
  
  protected final void dvW()
  {
    AppMethodBeat.i(187418);
    dwv();
    if (!TextUtils.isEmpty(this.xcI)) {
      try
      {
        this.xas.iQ("qrUrl", this.xcH.wWQ);
        this.wZQ.iw(this.xcI, this.xcH.wWQ);
        AppMethodBeat.o(187418);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localThrowable)));
      }
    }
    AppMethodBeat.o(187418);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(187416);
    super.dvx();
    dwv();
    AppMethodBeat.o(187416);
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ac> xcJ;
    
    a(ac paramac)
    {
      AppMethodBeat.i(187413);
      this.xcJ = new WeakReference(paramac);
      AppMethodBeat.o(187413);
    }
    
    public final void apm(String paramString)
    {
      AppMethodBeat.i(187415);
      ad.d("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "download qr image completed");
      ac localac = (ac)this.xcJ.get();
      if (localac != null)
      {
        localac.xcI = paramString;
        AppMethodBeat.o(187415);
        return;
      }
      ad.w("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      AppMethodBeat.o(187415);
    }
    
    public final void dsA()
    {
      AppMethodBeat.i(187414);
      ad.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      AppMethodBeat.o(187414);
    }
    
    public final void duP() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */