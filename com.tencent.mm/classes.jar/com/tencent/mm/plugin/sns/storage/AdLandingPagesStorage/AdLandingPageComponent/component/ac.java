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
import java.lang.ref.WeakReference;

public final class ac
  extends o
{
  private g ymD;
  private z ypv;
  String ypw = "";
  
  public ac(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    this.ypv = paramz;
  }
  
  private void dKU()
  {
    AppMethodBeat.i(200219);
    Bundle localBundle;
    if (this.ymD == null)
    {
      localBundle = new Bundle();
      localObject = this.ypv;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = ((z)localObject).yjf;; localObject = "")
    {
      localBundle.putString("qrExtInfo", (String)localObject);
      this.ymD = new g(this.context, dKH(), 3, localBundle);
      AppMethodBeat.o(200219);
      return;
    }
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(200216);
    super.dJW();
    dKU();
    AppMethodBeat.o(200216);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(200217);
    super.dKm();
    if (this.ypv != null)
    {
      String str = this.ypv.yjE;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
      h.a(str, dKN().yjt, new a(this));
    }
    AppMethodBeat.o(200217);
  }
  
  protected final void dKv()
  {
    AppMethodBeat.i(200218);
    dKU();
    if (!TextUtils.isEmpty(this.ypw)) {
      try
      {
        this.ynh.jo("qrUrl", this.ypv.yjE);
        this.ymD.iT(this.ypw, this.ypv.yjE);
        AppMethodBeat.o(200218);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(localThrowable)));
      }
    }
    AppMethodBeat.o(200218);
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ac> ypx;
    
    a(ac paramac)
    {
      AppMethodBeat.i(200213);
      this.ypx = new WeakReference(paramac);
      AppMethodBeat.o(200213);
    }
    
    public final void asD(String paramString)
    {
      AppMethodBeat.i(200215);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "download qr image completed");
      ac localac = (ac)this.ypx.get();
      if (localac != null)
      {
        localac.ypw = paramString;
        AppMethodBeat.o(200215);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
      AppMethodBeat.o(200215);
    }
    
    public final void dFC() {}
    
    public final void dFD()
    {
      AppMethodBeat.i(200214);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Sns.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
      AppMethodBeat.o(200214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */