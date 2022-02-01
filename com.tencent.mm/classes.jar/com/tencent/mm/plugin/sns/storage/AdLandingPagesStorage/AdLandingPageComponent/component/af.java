package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.io.Serializable;

public final class af
  extends p
  implements Serializable
{
  AdLandingPagesProxy.e zEw;
  protected n zHc;
  
  public af(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    AppMethodBeat.i(96736);
    this.zEw = new AdLandingPagesProxy.e()
    {
      public final void be(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96735);
        ad.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96734);
              t.makeText(af.this.context, 2131763758, 0).show();
              AppMethodBeat.o(96734);
            }
          });
          AppMethodBeat.o(96735);
          return;
        }
        bct localbct = new bct();
        try
        {
          localbct.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localbct.Gzl;
          ad.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localbct.Gzm);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)af.this.context, paramAnonymousObject);
          AppMethodBeat.o(96735);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          ad.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", bt.n(paramAnonymousObject));
          AppMethodBeat.o(96735);
        }
      }
    };
    this.zHc = paramn;
    paramContext = dWZ();
    this.zHc.zyP = bt.aRf(paramContext.zuP);
    this.zHc.yXS = paramContext.dFy;
    this.zHc.jSR = paramContext.jSR;
    ad.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.zHc);
    this.zEb.bl("smartphoneID", paramn.zyN);
    AppMethodBeat.o(96736);
  }
  
  protected final void dXg()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.zHc.zyP, this.zHc.zyO, this.zHc.jSR, this.zHc.yXS, this.zHc.zyN, this.zEw);
    dXe();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af
 * JD-Core Version:    0.7.0.1
 */