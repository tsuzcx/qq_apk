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
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import java.io.Serializable;

public final class ae
  extends o
  implements Serializable
{
  AdLandingPagesProxy.e ynB;
  protected n ypU;
  
  public ae(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    AppMethodBeat.i(96736);
    this.ynB = new AdLandingPagesProxy.e()
    {
      public final void bc(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96735);
        ac.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ap.f(new Runnable()
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
        ayp localayp = new ayp();
        try
        {
          localayp.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localayp.EPU;
          ac.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localayp.EPV);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)ae.this.context, paramAnonymousObject);
          AppMethodBeat.o(96735);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          ac.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", bs.m(paramAnonymousObject));
          AppMethodBeat.o(96735);
        }
      }
    };
    this.ypU = paramn;
    if ((paramContext instanceof SnsAdNativeLandingPagesUI))
    {
      paramContext = dKH();
      this.ypU.yiH = bs.aLz(paramContext.yeO);
      this.ypU.xID = paramContext.dtx;
      this.ypU.jyU = paramContext.jyU;
      ac.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.ypU);
    }
    for (;;)
    {
      this.ynh.bi("smartphoneID", paramn.yiF);
      AppMethodBeat.o(96736);
      return;
      ac.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", "context is not SnsAdNativeLandingPagesUI");
    }
  }
  
  protected final void dKO()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.ypU.yiH, this.ypU.yiG, this.ypU.jyU, this.ypU.xID, this.ypU.yiF, this.ynB);
    dKM();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */