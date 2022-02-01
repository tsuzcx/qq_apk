package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.io.Serializable;

public final class ae
  extends o
  implements Serializable
{
  AdLandingPagesProxy.e xaM;
  protected n xdf;
  
  public ae(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    AppMethodBeat.i(96736);
    this.xaM = new AdLandingPagesProxy.e()
    {
      public final void bf(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96735);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96734);
              t.makeText(ae.this.context, 2131763758, 0).show();
              AppMethodBeat.o(96734);
            }
          });
          AppMethodBeat.o(96735);
          return;
        }
        avj localavj = new avj();
        try
        {
          localavj.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localavj.DuL;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localavj.DuM);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)ae.this.context, paramAnonymousObject);
          AppMethodBeat.o(96735);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", bt.m(paramAnonymousObject));
          AppMethodBeat.o(96735);
        }
      }
    };
    this.xdf = paramn;
    if ((paramContext instanceof SnsAdNativeLandingPagesUI))
    {
      paramContext = dwi();
      this.xdf.wVT = bt.aGi(paramContext.wSi);
      this.xdf.wxc = paramContext.dvK;
      this.xdf.iYE = paramContext.iYE;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.xdf);
    }
    for (;;)
    {
      this.xas.bg("smartphoneID", paramn.wVR);
      AppMethodBeat.o(96736);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", "context is not SnsAdNativeLandingPagesUI");
    }
  }
  
  protected final void dwp()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.xdf.wVT, this.xdf.wVS, this.xdf.iYE, this.xdf.wxc, this.xdf.wVR, this.xaM);
    dwn();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */